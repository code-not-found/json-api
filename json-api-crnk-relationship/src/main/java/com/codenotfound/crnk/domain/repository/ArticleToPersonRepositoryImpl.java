package com.codenotfound.crnk.domain.repository;

import org.springframework.stereotype.Component;

import com.codenotfound.crnk.domain.model.Article;
import com.codenotfound.crnk.domain.model.Person;

import io.crnk.core.repository.RelationshipRepositoryBase;

@Component
public class ArticleToPersonRepositoryImpl
    extends RelationshipRepositoryBase<Article, Long, Person, Long> {

  public ArticleToPersonRepositoryImpl() {
    super(Article.class, Person.class);
  }
}
