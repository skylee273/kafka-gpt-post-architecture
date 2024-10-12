package com.ehyundai.app;

import com.ehyundai.app.port.PostPort;
import com.ehyundai.app.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostUpdateService implements PostUpdateUsecase {

    private final PostPort postPort;

    @Transactional
    @Override
    public Post update(PostUpdateUsecase.Request request) {
        Post post = postPort.findById(request.getPostId());
        if (post == null) return null;
        post.update(
            request.getTitle(),
            request.getContent(),
            request.getCategoryId()
        );
        Post savedPost = postPort.save(post);
        return savedPost;
    }
}
