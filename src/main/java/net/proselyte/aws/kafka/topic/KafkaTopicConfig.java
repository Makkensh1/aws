package net.proselyte.aws.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static net.proselyte.aws.kafka.topic.KafkaTopicConstants.NOTIFICATION_TOPIC;
import static net.proselyte.aws.kafka.topic.KafkaTopicConstants.RECIPIENT_TOPIC;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic NotificationTopic() {
        return TopicBuilder.name(NOTIFICATION_TOPIC)
                .partitions(5)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic recipientTopic(){
        return  TopicBuilder.name(RECIPIENT_TOPIC)
                .partitions(5)
                .replicas(1)
                .build();
    }


}
