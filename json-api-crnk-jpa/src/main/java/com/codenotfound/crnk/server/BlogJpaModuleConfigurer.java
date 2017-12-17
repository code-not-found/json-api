package com.codenotfound.crnk.server;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.codenotfound.crnk.domain.model.ArticleEntity;

import io.crnk.jpa.JpaModuleConfig;
import io.crnk.jpa.JpaRepositoryConfig;
import io.crnk.spring.boot.JpaModuleConfigurer;

@Component
public class BlogJpaModuleConfigurer implements JpaModuleConfigurer {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public void configure(JpaModuleConfig jpaModuleConfig) {
    jpaModuleConfig.addRepository(JpaRepositoryConfig.builder(ArticleEntity.class).build());
  }
}
