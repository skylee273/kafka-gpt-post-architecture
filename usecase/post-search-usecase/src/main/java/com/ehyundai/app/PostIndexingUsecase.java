package com.ehyundai.app;


import com.ehyundai.app.inspectedpost.model.InspectedPost;

public interface PostIndexingUsecase {

    void save(InspectedPost post);
    void delete(Long postId);

}
