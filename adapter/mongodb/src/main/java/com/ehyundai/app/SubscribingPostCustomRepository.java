package com.ehyundai.app;

import java.util.List;

public interface SubscribingPostCustomRepository {

    List<SubscribingPostDocument> findByFollowerUserIdWithPagination(Long followerUserId, int pageNumber, int pageSize);
    void deleteAllByPostId(Long postId);
}
