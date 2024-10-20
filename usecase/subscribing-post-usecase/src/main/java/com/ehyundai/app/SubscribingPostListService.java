package com.ehyundai.app;

import com.ehyundai.app.port.SubscribingPostPort;
import com.ehyundai.app.post.model.ResolvedPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribingPostListService implements SubscribingPostListUsecase {

    private static final int PAGE_SIZE = 5;

    private final SubscribingPostPort subscribingPostPort;
    private final PostResolvingHelpUsecase postResolvingHelpUsecase;

    @Override
    public List<ResolvedPost> listSubscribingInboxPosts(Request request) {
        List<Long> subscribingPostIds = subscribingPostPort.listPostIdsByFollowerUserIdWithPagination(
            request.getFollowerUserId(),
            request.getPageNumber(),
            PAGE_SIZE
        );
        return postResolvingHelpUsecase.resolvePostsByIds(subscribingPostIds);
    }
}
