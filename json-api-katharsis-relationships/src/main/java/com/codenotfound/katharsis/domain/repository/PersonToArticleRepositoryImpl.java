package com.codenotfound.katharsis.domain.repository;

import org.springframework.stereotype.Component;

import com.codenotfound.katharsis.domain.model.Article;
import com.codenotfound.katharsis.domain.model.Person;

import io.katharsis.repository.RelationshipRepositoryBase;

@Component
public class PersonToArticleRepositoryImpl
    extends RelationshipRepositoryBase<Person, Long, Article, Long> {

  public PersonToArticleRepositoryImpl() {
    super(Person.class, Article.class);
  }
}
