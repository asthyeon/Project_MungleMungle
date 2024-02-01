package com.munggle.post.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PostListDto {

    private Long postId;

    private String postTitle;

    private List<String> imageURLs;

    private List<String> hashtags;

    private String nickname;

    private Integer likeCnt;

    private LocalDateTime createdAt;

    // 유저 프로필 이미지 추후 추가 예정
    // 좋아요 유무 추가 예정
}
