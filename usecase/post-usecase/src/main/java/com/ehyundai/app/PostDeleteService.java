package com.ehyundai.app;

import com.ehyundai.app.port.PostPort;
import com.ehyundai.app.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostDeleteService implements PostDeleteUsecase {

    private final PostPort postPort;

    @Transactional
    @Override
    public Post delete(PostDeleteUsecase.Request request) {
        Post post = postPort.findById(request.getPostId());
        if (post == null) return null;
        post.delete();
        Post savedPost = postPort.save(post);
        return savedPost;
    }
}
