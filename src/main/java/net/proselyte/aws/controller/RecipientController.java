package net.proselyte.aws.controller;

import lombok.AllArgsConstructor;
import net.proselyte.aws.dto.RecipientDto;
import net.proselyte.aws.service.RecipientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RecipientController {


    private final RecipientService recipientService;


    @PostMapping(value = "/recipient", headers = "content-type=text/json", consumes = {"application/json"})
    ResponseEntity<RecipientDto> postRecipient(@RequestBody RecipientDto recipientDto) {
        recipientService.pushRecipient(recipientDto);

        return new ResponseEntity<>(recipientDto, HttpStatus.CREATED);
    }
}
