package net.proselyte.aws.service;

import lombok.AllArgsConstructor;
import net.proselyte.aws.dto.NotificationDto;
import net.proselyte.aws.mapper.NotificationMapper;
import net.proselyte.aws.repository.NotificationRepo;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepo repo;
    private final NotificationMapper mapper;



    @Override
    public void saveNotification(NotificationDto notificationDto) {
        repo.save(mapper.toNotification(notificationDto)).subscribe();
    }
}
