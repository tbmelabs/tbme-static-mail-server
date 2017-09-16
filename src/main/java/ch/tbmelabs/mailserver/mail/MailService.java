package ch.tbmelabs.mailserver.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ch.tbmelabs.mailserver.resource.model.Mail;
import ch.tbmelabs.mailserver.resource.repository.MailCRUDRepository;

@Service
public class MailService {
  private static final Logger LOGGER = LogManager.getLogger(MailService.class);

  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private MailCRUDRepository mailRepository;

  @Value("${spring.mail.username}")
  private String smtpAddress;

  public void sendMail(Mail mail) {
    LOGGER.info("Sending email from " + mail.getSender() + " to " + mail.getReceiver());

    try {
      MimeMessage mime = mailSender.createMimeMessage();
      mime.setSubject(mail.getSubject());

      MimeMessageHelper helper = new MimeMessageHelper(mime, true);

      helper.setFrom(mail.getSender());
      helper.setTo(mail.getReceiver());

      helper.setText(mail.getMessage(), true);

      mailSender.send(mime);
    } catch (MessagingException e) {
      throw new IllegalArgumentException(e);
    }

    mailRepository.save(mail);
  }
}