package com.ehyundai.app;

import com.ehyundai.app.port.PostSearchPort;
import com.ehyundai.app.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostSearchService implements PostSearchUsecase {

    private static final int PAGE_SIZE = 5;

    private final PostSearchPort postSearchPort;
    private final PostResolvingHelpUsecase postResolvingHelpUsecase;

    @Override
    public List<ResolvedPost> getSearchResultByKeyword(String keyword, int pageNumber) {
        List<Long> postIds = postSearchPort.searchPostIdsByKeyword(keyword, pageNumber, PAGE_SIZE);
        return postResolvingHelpUsecase.resolvePostsByIds(postIds);
    }
}
