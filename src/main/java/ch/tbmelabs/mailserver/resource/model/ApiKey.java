package ch.tbmelabs.mailserver.resource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "api_key")
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
public class ApiKey extends NicelyDocumentedMysqlEntity {
  @NotEmpty
  @Length(min = 36, max = 36)
  @Column(name = "api_key", columnDefinition = "CHAR(36)")
  private String apiKey;
}
