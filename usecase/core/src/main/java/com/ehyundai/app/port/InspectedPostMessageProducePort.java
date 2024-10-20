package com.ehyundai.app.port;


import com.ehyundai.app.inspectedpost.model.InspectedPost;

public interface InspectedPostMessageProducePort {

    void sendCreateMessage(InspectedPost inspectedPost);
    void sendUpdateMessage(InspectedPost inspectedPost);
    void sendDeleteMessage(Long id);
}
