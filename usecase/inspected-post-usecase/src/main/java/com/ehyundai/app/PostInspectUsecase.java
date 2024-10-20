package com.ehyundai.app;


import com.ehyundai.app.inspectedpost.model.InspectedPost;
import com.ehyundai.app.post.model.Post;

public interface PostInspectUsecase {

    InspectedPost inspectAndGetIfValid(Post post);
}
