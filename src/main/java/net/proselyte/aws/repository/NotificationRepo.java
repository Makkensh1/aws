package net.proselyte.aws.repository;

import net.proselyte.aws.model.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NotificationRepo extends R2dbcRepository<NotificationEntity, String> {

    Flux<NotificationEntity> findAllByRecipientUid(String uid);
}
