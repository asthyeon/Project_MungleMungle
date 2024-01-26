package com.munggle.domain.model.entity;

import com.munggle.dog.dto.DogCharDto;
import com.munggle.dog.dto.DogUpdateDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "dogs")
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    // 품종, 사용자Id, 생년월일, 이름 필수

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dogId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "kind_id")
    private Kind kind;
    //private Long kindId;

    @NotNull
    private Long userId;

    @NotNull
    private LocalDateTime birthDate;

    private String size;

    private Float weight;

    private String gender;

    private Boolean isNeutering;    // 중성화 여부

    // ,로 구분된 특징 (파싱해서 사용)
    // 수정 시 update 방식으로
    private String characterId;

    @NotNull
    @Size(max=15)
    private String name;

    @Size(max=100)
    private String image;

    @Size(max=100)
    private String description;

    @Column(columnDefinition = "boolean default false")
    private Boolean isMatching; // 매칭 온오프

    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;

//    public void setDogId(Long dogId){
//        this.dogId = dogId;
//    }

    public void updateDog(DogUpdateDto dogUpdateDto){
        this.birthDate = dogUpdateDto.getBirthDate();
        this.size = dogUpdateDto.getSize();
        this.weight = dogUpdateDto.getWeight();
        this.isNeutering = dogUpdateDto.getIsNeutering();
        this.name = dogUpdateDto.getName();
        this.image = dogUpdateDto.getImage();
        this.description = dogUpdateDto.getDescription();
    }

    public void deleteDog(){
        this.isDeleted = true;
    }

    public void onMatching(){
        this.isMatching = true;
    }

    public void offMatching(){
        this.isMatching = false;
    }

    public void updateCharacterId(DogCharDto dogCharDto){
        this.characterId = dogCharDto.toCharacterString();
        this.isNeutering = dogCharDto.getIsNeutering();
    }
}