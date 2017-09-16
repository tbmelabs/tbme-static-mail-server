package ch.tbmelabs.mailserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.tbmelabs.mailserver.mail.MailService;
import ch.tbmelabs.mailserver.resource.model.Mail;
import ch.tbmelabs.mailserver.resource.repository.ApiKeyCRUDRepository;

@Controller
public class MailController {
  @Autowired
  private ApiKeyCRUDRepository apiKeyRepository;

  @Autowired
  private MailService mailService;

  @RequestMapping(value = { "/send-mail/{api_key}" }, method = RequestMethod.POST)
  public ResponseEntity<Object> sendMail(@PathVariable(name = "api_key", required = true) String apiKey,
      @RequestBody(required = true) Mail mail) {
    if (apiKeyRepository.findByApiKey(apiKey) == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    mailService.sendMail(mail);

    return ResponseEntity.ok().build();
  }
}