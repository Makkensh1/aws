package net.proselyte.aws.service;

import net.proselyte.aws.dto.NotificationDto;

public interface NotificationService {

    void saveNotification(NotificationDto entity);

}
