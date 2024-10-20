package com.ehyundai.app;


import com.ehyundai.app.post.model.Post;

public interface SubscribingPostAddToInboxUsecase {

    void saveSubscribingInboxPost(Post post);
}
