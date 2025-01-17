package com.ehyundai.app.port;


import com.ehyundai.app.post.model.Post;

import java.util.List;

public interface SubscribingPostPort {

    void addPostToFollowerInboxes(Post post, List<Long> followerUserIds);
    void removePostFromFollowerInboxes(Long postId);
    List<Long> listPostIdsByFollowerUserIdWithPagination(Long followerUserId, int pageNumber, int pageSize);
}
