package com.ehyundai.app;


import com.ehyundai.app.post.model.ResolvedPost;

public interface PostReadUsecase {

    ResolvedPost getById(Long id);
}
