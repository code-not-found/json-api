package com.codenotfound.katharsis.client;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.codenotfound.katharsis.domain.model.Greeting;

import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;

@Component
public class GreetingClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(GreetingClient.class);

  private KatharsisClient katharsisClient =
      new KatharsisClient("http://localhost:9090/codenotfound/api");
  private ResourceRepositoryV2<Greeting, Long> resourceRepositoryV2;

  @PostConstruct
  public void init() {
    resourceRepositoryV2 = katharsisClient.getRepositoryForType(Greeting.class);
  }

  public Greeting findOne(long id) {
    Greeting result = resourceRepositoryV2.findOne(id, new QuerySpec(Greeting.class));

    LOGGER.info("found {}", result.toString());
    return result;
  }
}
