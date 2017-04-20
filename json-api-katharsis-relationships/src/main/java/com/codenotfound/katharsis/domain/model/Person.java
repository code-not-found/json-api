package com.codenotfound.katharsis.domain.model;

import java.util.ArrayList;
import java.util.List;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "people")
public class Person {

  @JsonApiId
  private Long id;

  private String name;

  @JsonApiRelation(opposite = "author")
  private List<Article> articles = new ArrayList<>();

  public Person() {
    super();
  }

  public Person(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }
}
