package net.proselyte.aws.service;

import lombok.AllArgsConstructor;
import net.proselyte.aws.dto.NotificationDto;
import net.proselyte.aws.mapper.NotificationMapper;
import net.proselyte.aws.model.NotificationEntity;
import net.proselyte.aws.repository.NotificationRepo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static net.proselyte.aws.kafka.topic.KafkaTopicConstants.NOTIFICATION_TOPIC;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepo repo;
    private final NotificationMapper mapper;
    private KafkaTemplate<String, NotificationDto> notificationDtoKafkaTemplate;


    @Override
    public void saveNotification(NotificationEntity entity) {
        notificationDtoKafkaTemplate.send(NOTIFICATION_TOPIC, mapper.map(entity));


    }
}
