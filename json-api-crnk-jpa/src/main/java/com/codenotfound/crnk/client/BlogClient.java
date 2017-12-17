package com.codenotfound.crnk.client;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.codenotfound.crnk.domain.model.ArticleEntity;

import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.jpa.JpaModule;

@Component
public class BlogClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(BlogClient.class);

  private CrnkClient crnkClient = new CrnkClient("http://localhost:9090/codenotfound/api");

  private ResourceRepositoryV2<ArticleEntity, Long> articleResourceRepositoryV2;

  @PostConstruct
  public void init() {
    crnkClient.addModule(JpaModule.newClientModule());
    articleResourceRepositoryV2 = crnkClient.getRepositoryForType(ArticleEntity.class);
  }

  public ArticleEntity findOneArticle(long id) {
    ArticleEntity result =
        articleResourceRepositoryV2.findOne(id, new QuerySpec(ArticleEntity.class));

    LOGGER.info("found {}", result.toString());
    return result;
  }
}
