package com.codenotfound.crnk;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.codenotfound.crnk.domain.model.Article;
import com.codenotfound.crnk.domain.model.Person;
import com.codenotfound.crnk.domain.repository.ArticleRepository;
import com.codenotfound.crnk.domain.repository.PersonRepository;

@Configuration
public class SpringCrnkApplicationConfig {

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
