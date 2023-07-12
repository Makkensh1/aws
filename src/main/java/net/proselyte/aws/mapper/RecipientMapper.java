package net.proselyte.aws.mapper;

import net.proselyte.aws.dto.RecipientDto;
import net.proselyte.aws.model.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientDto toRecipientDto(RecipientEntity entity);

    @InheritInverseConfiguration
    RecipientEntity toRecipient(RecipientDto dto);
}