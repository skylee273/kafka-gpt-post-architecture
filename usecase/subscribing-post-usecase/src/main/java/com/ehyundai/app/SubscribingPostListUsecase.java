package com.ehyundai.app;

import com.ehyundai.app.post.model.ResolvedPost;
import lombok.Data;

import java.util.List;

public interface SubscribingPostListUsecase {

    // 구족자의 인박스 안에 있는 컨텐츠 목록을 조회한다.
    List<ResolvedPost> listSubscribingInboxPosts(Request request);

    @Data
    class Request {
        private final int pageNumber;
        private final Long followerUserId;
    }
}
