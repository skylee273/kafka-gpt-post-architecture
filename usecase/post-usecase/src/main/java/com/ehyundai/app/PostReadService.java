package com.ehyundai.app;

import com.ehyundai.app.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostReadService implements PostReadUsecase {

    private final PostResolvingHelpUsecase postResolvingHelpUsecase;

    @Override
    public ResolvedPost getById(Long id) {
        return postResolvingHelpUsecase.resolvePostById(id);
    }
}
