package ch.tbmelabs.mailserver.resource.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ch.tbmelabs.mailserver.resource.model.ApiKey;

@RepositoryRestResource(exported = false)
public interface ApiKeyCRUDRepository extends CrudRepository<ApiKey, Long> {
  public ApiKey findByApiKey(String apiKey);
}