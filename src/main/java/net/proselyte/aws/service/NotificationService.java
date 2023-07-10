package net.proselyte.aws.service;

import net.proselyte.aws.model.NotificationEntity;

public interface NotificationService {

    void saveNotification(NotificationEntity entity);

}
