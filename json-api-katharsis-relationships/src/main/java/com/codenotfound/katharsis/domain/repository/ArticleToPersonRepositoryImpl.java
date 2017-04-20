package com.codenotfound.katharsis.domain.repository;

import org.springframework.stereotype.Component;

import com.codenotfound.katharsis.domain.model.Article;
import com.codenotfound.katharsis.domain.model.Person;

import io.katharsis.repository.RelationshipRepositoryBase;

@Component
public class ArticleToPersonRepositoryImpl
    extends RelationshipRepositoryBase<Article, Long, Person, Long> {

  public ArticleToPersonRepositoryImpl() {
    super(Article.class, Person.class);
  }
}
