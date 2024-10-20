package com.ehyundai.app;

import com.ehyundai.app.port.MetadataPort;
import com.ehyundai.app.port.SubscribingPostPort;
import com.ehyundai.app.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribingPostAddToInboxService implements SubscribingPostAddToInboxUsecase {


    private final SubscribingPostPort subscribingPostPort;
    private final MetadataPort metadataPort;

    @Override
    public void saveSubscribingInboxPost(Post post) {
        List<Long> followerUserIds = metadataPort.listFollowerIdsByUserId(post.getUserId());
        subscribingPostPort.addPostToFollowerInboxes(post, followerUserIds);
    }
}
