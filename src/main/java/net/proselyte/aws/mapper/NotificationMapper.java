package net.proselyte.aws.mapper;

import net.proselyte.aws.dto.NotificationDto;
import net.proselyte.aws.dto.RecipientDto;
import net.proselyte.aws.model.NotificationEntity;
import net.proselyte.aws.model.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto toNotificationDto(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity toNotification(NotificationDto dto);

    RecipientDto toRecipientDto(RecipientEntity entity);
    RecipientEntity toRecipient(RecipientDto dto);

}
