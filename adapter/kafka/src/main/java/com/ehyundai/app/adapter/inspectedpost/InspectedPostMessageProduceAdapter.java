package com.ehyundai.app.adapter.inspectedpost;

import com.ehyundai.app.CustomObjectMapper;
import com.ehyundai.app.adapter.common.OperationType;
import com.ehyundai.app.inspectedpost.model.InspectedPost;
import com.ehyundai.app.port.InspectedPostMessageProducePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.ehyundai.app.adapter.common.Topic.INSPECTED_POST;


@RequiredArgsConstructor
@Component
public class InspectedPostMessageProduceAdapter implements InspectedPostMessageProducePort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CustomObjectMapper objectMapper = new CustomObjectMapper();

    @Override
    public void sendCreateMessage(InspectedPost inspectedPost) {
        InspectedPostMessage message = new InspectedPostMessage(
            inspectedPost.getPost().getId(),
            new InspectedPostMessage.Payload(
                inspectedPost.getPost(),
                inspectedPost.getCategoryName(),
                inspectedPost.getAutoGeneratedTags(),
                inspectedPost.getInspectedAt()
            ),
            OperationType.CREATE
        );
        this.sendMessage(message);
    }

    @Override
    public void sendUpdateMessage(InspectedPost inspectedPost) {
        InspectedPostMessage message = new InspectedPostMessage(
            inspectedPost.getPost().getId(),
            new InspectedPostMessage.Payload(
                inspectedPost.getPost(),
                inspectedPost.getCategoryName(),
                inspectedPost.getAutoGeneratedTags(),
                inspectedPost.getInspectedAt()
            ),
            OperationType.UPDATE
        );
        this.sendMessage(message);
    }

    @Override
    public void sendDeleteMessage(Long postId) {
        InspectedPostMessage message = new InspectedPostMessage(
            postId,
            null,
            OperationType.DELETE
        );
        this.sendMessage(message);
    }

    private void sendMessage(InspectedPostMessage message) {
        try {
            kafkaTemplate.send(INSPECTED_POST, message.getId().toString(), objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
