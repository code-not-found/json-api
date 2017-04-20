package com.codenotfound.katharsis;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.codenotfound.katharsis.domain.model.Article;
import com.codenotfound.katharsis.domain.model.Person;
import com.codenotfound.katharsis.domain.repository.ArticleRepository;
import com.codenotfound.katharsis.domain.repository.PersonRepository;

@Configuration
public class SpringKatharsisApplicationConfig {

  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  PersonRepository personRepository;

  @PostConstruct
  public void init() {
    Article article1 = new Article(1L, "JSON API paints my bikeshed!");
    Article article2 = new Article(2L, "Rails is Omakase");

    Person person1 = new Person(1L, "John");

    article1.setAuthor(person1);
    article2.setAuthor(person1);

    person1.getArticles().add(article1);
    person1.getArticles().add(article2);

    articleRepository.save(article1);
    articleRepository.save(article2);

    personRepository.save(person1);
  }
}
