package com.ehyundai.app;


import com.ehyundai.app.post.model.Post;
import com.ehyundai.app.post.model.ResolvedPost;

import java.util.List;

public interface PostResolvingHelpUsecase {

    ResolvedPost resolvePostById(Long postId);
    List<ResolvedPost> resolvePostsByIds(List<Long> postIds);
    void resolvePostAndSave(Post post);
    void deleteResolvedPost(Long postId);
}
