package com.ehyundai.app;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class SubscribingPostRepositoryImpl implements SubscribingPostCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<SubscribingPostDocument> findByFollowerUserIdWithPagination(Long followerUserId, int pageNumber, int pageSize) {
        Query query = new Query()
            .addCriteria(Criteria.where("followerUserId").is(followerUserId))
            .with(
                PageRequest.of(
                    pageNumber,
                    pageSize,
                    Sort.by(Sort.Direction.DESC, "postCreatedAt")
                )
            );
        System.out.println(query);
        return mongoTemplate.find(query, SubscribingPostDocument.class, "subscribingInboxPosts");
    }

    @Override
    public void deleteAllByPostId(Long postId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        mongoTemplate.remove(query, SubscribingPostDocument.class);
    }
}
