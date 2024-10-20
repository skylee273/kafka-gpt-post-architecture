package com.ehyundai.app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscribingPostRepository extends SubscribingPostCustomRepository, MongoRepository<SubscribingPostDocument, String> {
}
