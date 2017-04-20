package com.codenotfound.katharsis.domain.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.codenotfound.katharsis.domain.model.Article;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class ArticleRepositoryImpl extends ResourceRepositoryBase<Article, Long>
    implements ArticleRepository {

  private Map<Long, Article> articles = new HashMap<>();

  public ArticleRepositoryImpl() {
    super(Article.class);
  }

  @Override
  public synchronized void delete(Long id) {
    articles.remove(id);
  }

  @Override
  public synchronized <S extends Article> S save(S article) {
    articles.put(article.getId(), article);
    return article;
  }

  @Override
  public synchronized ResourceList<Article> findAll(QuerySpec querySpec) {
    return querySpec.apply(articles.values());
  }
}
