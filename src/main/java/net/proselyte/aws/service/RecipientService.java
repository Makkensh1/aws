package net.proselyte.aws.service;

import net.proselyte.aws.dto.RecipientDto;

public interface RecipientService {

    void saveRecipient(RecipientDto dto);

    void  pushRecipient(RecipientDto dto);
}
