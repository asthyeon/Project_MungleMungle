package com.munggle.post.controller;

import com.munggle.domain.model.entity.User;
import com.munggle.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.munggle.post.dto.PostCreateDto;
import com.munggle.post.dto.PostUpdateDto;
import com.munggle.post.dto.PostListResponseDto;
import com.munggle.post.dto.PostListRequestDto;
import com.munggle.post.dto.PostDetailResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PostListResponseDto getPostList(@RequestBody PostListRequestDto postListRequestDto) {
        // 팔로잉: 최신순으로 정렬
        // 큐레이팅 순서로 정렬

        return null;
    }

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public PostDetailResponseDto viewPost(@AuthenticationPrincipal User principal,
                                          @PathVariable(value = "postId") Long postId) {

        Long userId = principal.getId();
        return postService.getDetailPost(postId, userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void savePost(@AuthenticationPrincipal User principal,
                         @RequestPart(value = "dto") @Valid PostCreateDto postCreateDto,
                         @RequestPart(value = "file") List<MultipartFile> files) {
        log.info("제목: {}, 이미지: {}", postCreateDto.getPostTitle(), files.get(0));

        postCreateDto.setImages(files);
        postCreateDto.setUserId(principal.getId());
        postService.insertPost(postCreateDto);
    }

    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable(value = "postId") Long postId,
                           @RequestPart(value = "dto") @Valid PostUpdateDto postUpdateDto,
                           @RequestPart(value = "file") List<MultipartFile> files) {
        log.info("제목: {}, 이미지: {}", postUpdateDto.getPostTitle(), files.get(0));

        postUpdateDto.setImages(files);
        postUpdateDto.setPostId(postId);
        postService.updatePost(postUpdateDto);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable(value = "postId") Long postId) {
        postService.deletePost(postId);
    }

}