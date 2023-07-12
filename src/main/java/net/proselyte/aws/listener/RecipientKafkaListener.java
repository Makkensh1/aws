package net.proselyte.aws.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.aws.dto.NotificationDto;
import net.proselyte.aws.dto.RecipientDto;
import net.proselyte.aws.service.NotificationService;
import net.proselyte.aws.service.RecipientService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static net.proselyte.aws.kafka.topic.KafkaTopicConstants.NOTIFICATION_TOPIC;
import static net.proselyte.aws.kafka.topic.KafkaTopicConstants.RECIPIENT_TOPIC;


@Component
@AllArgsConstructor
@Slf4j
public class RecipientKafkaListener {


    private final RecipientService recipientService;
    private final KafkaTemplate<String, Object> notificationDtoKafkaTemplate;
    private final NotificationService notificationService;

    @KafkaListener(topics = RECIPIENT_TOPIC, groupId = "${spring.kafka.listener.listener-1.group-id}", containerFactory = "multiTypeKafkaListenerContainerFactory")
    void recipientListener(RecipientDto dto) {
        dto.notifications().parallelStream().forEach(e -> notificationDtoKafkaTemplate.send(NOTIFICATION_TOPIC, e.recipientUID(), e));
        recipientService.saveRecipient(dto);
    }

    @KafkaListener(topics = NOTIFICATION_TOPIC, groupId = "${spring.kafka.listener.listener-2.group-id}", containerFactory = "multiTypeKafkaListenerContainerFactory")
    void notificationListener(NotificationDto notificationDto) {
        System.out.println(notificationDto.toString());
        notificationService.saveNotification(notificationDto);
    }
}
