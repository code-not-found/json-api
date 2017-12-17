package com.codenotfound.crnk.domain.model;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

@JsonApiResource(type = "articles")
public class Article {

  @JsonApiId
  private Long id;

  private String title;

  @JsonApiRelation(opposite = "articles")
  private Person author;

  public Article() {
    super();
  }

  public Article(Long id, String title) {
    super();
    this.id = id;
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Person getAuthor() {
    return author;
  }

  public void setAuthor(Person author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "article[id=" + id + ", title=" + title + "]";
  }
}
