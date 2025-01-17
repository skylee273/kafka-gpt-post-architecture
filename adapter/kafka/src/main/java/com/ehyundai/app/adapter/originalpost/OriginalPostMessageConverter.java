package com.ehyundai.app.adapter.originalpost;


import com.ehyundai.app.post.model.Post;

public class OriginalPostMessageConverter {

    public static Post toModel(OriginalPostMessage originalPostMessage) {
        return new Post(
            originalPostMessage.getPayload().getId(),
            originalPostMessage.getPayload().getTitle(),
            originalPostMessage.getPayload().getContent(),
            originalPostMessage.getPayload().getUserId(),
            originalPostMessage.getPayload().getCategoryId(),
            originalPostMessage.getPayload().getCreatedAt(),
            originalPostMessage.getPayload().getUpdatedAt(),
            originalPostMessage.getPayload().getDeletedAt()
        );
    }
}
