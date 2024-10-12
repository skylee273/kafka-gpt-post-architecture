package com.ehyundai.app.controller;

import com.ehyundai.app.PostCreateUsecase;
import com.ehyundai.app.PostDeleteUsecase;
import com.ehyundai.app.PostUpdateUsecase;
import com.ehyundai.app.dto.PostCreateRequest;
import com.ehyundai.app.dto.PostDetailDto;
import com.ehyundai.app.dto.PostDto;
import com.ehyundai.app.dto.PostUpdateRequest;
import com.ehyundai.app.post.model.Post;
import com.ehyundai.app.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostCreateUsecase postCreateUsecase;
    private final PostUpdateUsecase postUpdateUsecase;
    private final PostDeleteUsecase postDeleteUsecase;

    @PostMapping
    ResponseEntity<PostDto> createPost(
        @RequestBody PostCreateRequest request
    ) {
        Post post = postCreateUsecase.create(
            new PostCreateUsecase.Request(
                request.getUserId(),
                request.getTitle(),
                request.getContent(),
                request.getCategoryId()
            )
        );
        return ResponseEntity.ok().body(toDto(post));
    }

    @PutMapping("/{postId}")
    ResponseEntity<PostDto> updatePost(
        @PathVariable("postId") Long id,
        @RequestBody PostUpdateRequest request
    ) {
        Post post = postUpdateUsecase.update(
            new PostUpdateUsecase.Request(
                id,
                request.getTitle(),
                request.getContent(),
                request.getCategoryId()
            )
        );
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(toDto(post));
    }

    @DeleteMapping("/{postId}")
    ResponseEntity<PostDto> deletePost(
        @PathVariable("postId") Long id
    ) {
        Post post = postDeleteUsecase.delete(
            new PostDeleteUsecase.Request(
                id
            )
        );
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(toDto(post));
    }



    private PostDto toDto(Post post) {
        return new PostDto(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getUserId(),
            post.getCategoryId(),
            post.getCreatedAt(),
            post.getUpdatedAt(),
            post.getDeletedAt()
        );
    }

    private PostDetailDto toDto(ResolvedPost resolvedPost) {
        return new PostDetailDto(
            resolvedPost.getId(),
            resolvedPost.getTitle(),
            resolvedPost.getContent(),
            resolvedPost.getUserName(),
            resolvedPost.getCategoryName(),
            resolvedPost.getCreatedAt(),
            resolvedPost.isUpdated()
        );
    }
}
