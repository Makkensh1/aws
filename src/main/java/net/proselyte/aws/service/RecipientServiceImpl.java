package net.proselyte.aws.service;

import lombok.AllArgsConstructor;
import net.proselyte.aws.dto.RecipientDto;
import net.proselyte.aws.mapper.RecipientMapper;
import net.proselyte.aws.repository.RecipientRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static net.proselyte.aws.kafka.topic.KafkaTopicConstants.RECIPIENT_TOPIC;

@Service
@AllArgsConstructor
public class RecipientServiceImpl implements RecipientService {

    private final RecipientRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final RecipientMapper mapper;


    @Override
    public void saveRecipient(RecipientDto dto) {
        repository.save(mapper.toRecipient(dto)).subscribe();
    }

    @Override
    public void pushRecipient(RecipientDto dto) {
        kafkaTemplate.send(RECIPIENT_TOPIC,dto);
    }
}
