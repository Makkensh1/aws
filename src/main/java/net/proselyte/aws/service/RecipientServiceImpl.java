package net.proselyte.aws.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.proselyte.aws.dto.RecipientDto;
import net.proselyte.aws.mapper.RecipientMapper;
import net.proselyte.aws.repository.RecipientRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipientServiceImpl implements RecipientService{

    private final RecipientRepository repository;
    private final KafkaTemplate<String, RecipientDto> kafkaTemplate;
    private final RecipientMapper mapper;
    private final ObjectMapper objectMapper;

    @Override
    public void saveRecipient(RecipientDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public void pushRecipient(RecipientDto dto) {

    }
}
