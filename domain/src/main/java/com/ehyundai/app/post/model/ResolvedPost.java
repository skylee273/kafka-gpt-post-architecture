package com.ehyundai.app.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents a resolved version of a post with additional metadata such as
 * user name and category name. This class is used in service layers to provide
 * more contextual information about a post.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedPost { // 서비스용

    private Long id;
    private String title;
    private String content;
    private Long userId;
    private String userName;
    private Long categoryId;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean updated;

    public static ResolvedPost generate(
        Post post,
        String userName,
        String categoryName
    ) {
        return new ResolvedPost(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getUserId(),
            userName,
            post.getCategoryId(),
            categoryName,
            post.getCreatedAt(),
            post.getUpdatedAt(),
            !post.getCreatedAt().equals(post.getUpdatedAt())
        );
    }
}