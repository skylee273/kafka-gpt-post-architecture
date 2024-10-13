package com.ehyundai.app.adapter.originalpost;

import com.ehyundai.app.CustomObjectMapper;
import com.ehyundai.app.adapter.common.OperationType;
import com.ehyundai.app.port.OriginalPostMessageProducePort;
import com.ehyundai.app.post.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.ehyundai.app.adapter.common.Topic.ORIGINAL_POST;


@RequiredArgsConstructor
@Component
public class OriginalPostMessageProduceAdapter implements OriginalPostMessageProducePort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CustomObjectMapper objectMapper = new CustomObjectMapper();

    @Override
    public void sendCreateMessage(Post post) {
        OriginalPostMessage message = this.convertToMessage(post.getId(), post, OperationType.CREATE);
        this.sendMessage(message);
    }

    @Override
    public void sendUpdateMessage(Post post) {
        OriginalPostMessage message = this.convertToMessage(post.getId(), post, OperationType.UPDATE);
        this.sendMessage(message);
    }

    @Override
    public void sendDeleteMessage(Long postId) {
        OriginalPostMessage message = this.convertToMessage(postId, null, OperationType.DELETE);
        this.sendMessage(message);
    }

    private OriginalPostMessage convertToMessage(Long id, Post post, OperationType operationType) {
        return new OriginalPostMessage(
            id,
            post == null ? null : new OriginalPostMessage.Payload(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUserId(),
                post.getCategoryId(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getDeletedAt()
            ),
            operationType
        );
    }

    private void sendMessage(OriginalPostMessage message) {
        try {
            kafkaTemplate.send(ORIGINAL_POST, message.getId().toString(), objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
