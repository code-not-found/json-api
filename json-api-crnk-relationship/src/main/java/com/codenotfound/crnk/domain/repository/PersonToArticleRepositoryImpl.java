package com.codenotfound.crnk.domain.repository;

import org.springframework.stereotype.Component;

import com.codenotfound.crnk.domain.model.Article;
import com.codenotfound.crnk.domain.model.Person;

import io.crnk.core.repository.RelationshipRepositoryBase;

@Component
public class PersonToArticleRepositoryImpl
    extends RelationshipRepositoryBase<Person, Long, Article, Long> {

  public PersonToArticleRepositoryImpl() {
    super(Person.class, Article.class);
  }
}
