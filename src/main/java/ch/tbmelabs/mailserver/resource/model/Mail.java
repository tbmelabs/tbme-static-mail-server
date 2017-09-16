package ch.tbmelabs.mailserver.resource.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mail_log")
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
public class Mail extends NicelyDocumentedMysqlEntity {
  @NotEmpty
  @Length(max = 256)
  @Column(name = "from_email", columnDefinition = "VARCHAR(256)")
  private String sender;

  @NotEmpty
  @Length(max = 256)
  @Column(name = "to_email", columnDefinition = "VARCHAR(256)")
  private String receiver;

  @NotEmpty
  @Length(max = 256)
  @Column(name = "subject", columnDefinition = "VARCHAR(256)")
  private String subject;

  @NotEmpty
  @Length(max = 1024)
  @Column(name = "message", columnDefinition = "VARCHAR(1024)")
  private String message;

  @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
  @JoinColumn(name = "api_key_id", referencedColumnName = "id", columnDefinition = "BIGINT", unique = true)
  private ApiKey apiKey;
}
