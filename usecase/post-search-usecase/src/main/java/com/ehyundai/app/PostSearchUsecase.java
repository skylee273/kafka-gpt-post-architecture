package com.ehyundai.app;


import com.ehyundai.app.post.model.ResolvedPost;

import java.util.List;

public interface PostSearchUsecase {

    List<ResolvedPost> getSearchResultByKeyword(String keyword, int pageNumber);
}
