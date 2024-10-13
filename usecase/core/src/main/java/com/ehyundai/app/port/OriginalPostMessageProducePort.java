package com.ehyundai.app.port;


import com.ehyundai.app.post.model.Post;

public interface OriginalPostMessageProducePort {

    void sendCreateMessage(Post post);
    void sendUpdateMessage(Post post);
    void sendDeleteMessage(Long id);
}
