package com.codenotfound.crnk.client;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.codenotfound.crnk.domain.model.Article;
import com.codenotfound.crnk.domain.model.Person;

import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;

@Component
public class BlogClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(BlogClient.class);

  private CrnkClient crnkClientClient = new CrnkClient("http://localhost:9090/codenotfound/api");

  private ResourceRepositoryV2<Article, Long> articleResourceRepositoryV2;
  private ResourceRepositoryV2<Person, Long> personResourceRepositoryV2;

  @PostConstruct
  public void init() {
    articleResourceRepositoryV2 = crnkClientClient.getRepositoryForType(Article.class);
    personResourceRepositoryV2 = crnkClientClient.getRepositoryForType(Person.class);
  }

  public Article findOneArticle(long id) {
    Article result = articleResourceRepositoryV2.findOne(id, new QuerySpec(Article.class));

    LOGGER.info("found {}", result.toString());
    return result;
  }

  public Person findOnePerson(long id) {
    Person result = personResourceRepositoryV2.findOne(id, new QuerySpec(Person.class));

    LOGGER.info("found {}", result.toString());
    return result;
  }
}
