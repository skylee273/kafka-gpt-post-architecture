package com.ehyundai.app;

import com.ehyundai.app.post.model.Post;
import lombok.Data;

public interface PostDeleteUsecase {

    Post delete(Request request);

    @Data
    class Request {
        private final Long postId;
    }
}
