package com.ehyundai.app.port;


import com.ehyundai.app.inspectedpost.model.InspectedPost;

import java.util.List;

public interface PostSearchPort {

    void indexPost(InspectedPost post);
    void deletePost(Long id);
    List<Long> searchPostIdsByKeyword(String keyword, int pageNumber, int pageSize);
}
