package com.munggle.alarm.service;

import com.munggle.alarm.dto.AlarmCreateDto;
import com.munggle.alarm.dto.AlarmListDto;
import com.munggle.alarm.mapper.AlarmMapper;
import com.munggle.alarm.repository.AlarmRepository;
import com.munggle.domain.exception.AlarmNotFoundException;
import com.munggle.domain.exception.IllegalAlarmTypeException;
import com.munggle.domain.exception.UserNotFoundException;
import com.munggle.domain.model.entity.Alarm;
import com.munggle.domain.model.entity.User;
import com.munggle.domain.model.entity.type.AlarmType;
import com.munggle.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.munggle.domain.exception.ExceptionMessage.*;

@Service @Slf4j
@RequiredArgsConstructor
public class AlarmServiceImpl implements AlarmService{

    private final AlarmRepository alarmRepository;
    private final UserRepository userRepository;

    @Override
    public AlarmListDto getAlarmList(Long userId) {

        User toUser = userRepository.findByIdAndIsEnabledTrue(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        checkAlarms(toUser); // 알림 확인 처리 메서드

        List<Alarm> alarm = alarmRepository.findByToUser(toUser);

        return AlarmListDto.builder()
                .userId(userId)
                .alarms(alarm.stream()
                        .map(AlarmMapper::toAlarmDetailDto)
                        .collect(Collectors.toList()))
                .build();
    }

    // === 알림 개수 확인 메서드 === //
    @Override
    public Integer countAlarm(Long userId) {

        User user = userRepository.findByIdAndIsEnabledTrue(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        return alarmRepository.countByToUserIdAndIsCheckedFalse(user);
    }

    // === 알림 타입을 지정해주는 메서드 === //
    private AlarmType getAlarmType(String type) {
        switch (type) {
            case "POST":
                return AlarmType.POST;
            case "LIKE":
                return AlarmType.LIKE;
            case "COMMENT":
                return AlarmType.COMMENT;
            case "DM":
                return AlarmType.DM;
            case "FOLLOW":
                return AlarmType.FOLLOW;
            default:
                throw new IllegalAlarmTypeException(ALARM_TYPE_ILLEGAL);
        }
    }

    @Override
    @Transactional
    public void InsetAlarm(AlarmCreateDto alarmCreateDto) {

        AlarmType type = getAlarmType(alarmCreateDto.getAlarmType());
        User fromUser = userRepository.findByIdAndIsEnabledTrue(alarmCreateDto.getFromUserId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        User toUser = userRepository.findByIdAndIsEnabledTrue(alarmCreateDto.getToUserId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        Alarm alarm = AlarmMapper.toEntity(alarmCreateDto, fromUser, toUser, type);

        alarmRepository.save(alarm);
    }

    @Override
    @Transactional
    public void deleteAlarm(Long alarmId) {
        Alarm alarm = alarmRepository.findByIdAndIsDeletedFalse(alarmId)
                .orElseThrow(() -> new AlarmNotFoundException(ALARM_NOT_FOUND));

        alarmRepository.delete(alarm);
    }

    // === 알림 확인 메서드 === //
    @Transactional
    public void checkAlarms(User toUser) {

        List<Alarm> alarms = alarmRepository.findByToUserAndIsCheckedFalse(toUser);
        for (Alarm alarm : alarms) {
            alarm.markAsChecked();
        }

        alarmRepository.saveAll(alarms);
    }
}