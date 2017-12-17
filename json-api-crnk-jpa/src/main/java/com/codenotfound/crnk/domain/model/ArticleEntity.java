package com.codenotfound.crnk.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArticleEntity {

  @Id
  private Long id;

  private String title;

  public ArticleEntity() {
    super();
  }

  public ArticleEntity(Long id, String title) {
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

  @Override
  public String toString() {
    return "article[id=" + id + ", title=" + title + "]";
  }
}
