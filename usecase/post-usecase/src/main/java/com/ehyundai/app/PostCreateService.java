package com.ehyundai.app;

import com.ehyundai.app.port.PostPort;
import com.ehyundai.app.post.model.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostCreateService implements PostCreateUsecase {

    private final PostPort postPort;

    @Transactional
    @Override
    public Post create(Request request) {
        Post post = Post.generate(
            request.getUserId(),
            request.getTitle(),
            request.getContent(),
            request.getCategoryId()
        );
        Post savedPost = postPort.save(post);
        return savedPost;
    }
}