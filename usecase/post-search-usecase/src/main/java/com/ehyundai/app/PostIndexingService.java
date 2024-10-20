package com.ehyundai.app;

import com.ehyundai.app.inspectedpost.model.InspectedPost;
import com.ehyundai.app.port.PostSearchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostIndexingService implements PostIndexingUsecase {

    private final PostSearchPort postSearchPort;

    @Override
    public void save(InspectedPost post) {
        postSearchPort.indexPost(post);
    }

    @Override
    public void delete(Long postId) {
        postSearchPort.deletePost(postId);
    }
}
