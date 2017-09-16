package ch.tbmelabs.mailserver.resource.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import ch.tbmelabs.mailserver.resource.model.ApiKey;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
    repositoryRestConfiguration.exposeIdsFor(ApiKey.class);
  }
}