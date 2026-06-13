package com.jhs.domain.article.service;

import com.jhs.domain.article.dto.Article;
import com.jhs.domain.article.repository.ArticleRepository;
import com.jhs.global.base.container.Container;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public Article write(String title, String content) {
    return articleRepository.write(title, content);
  }

  public List<Article> getArticles() {
    return articleRepository.findByAll();
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }

  public void modify(int id, String title, String content) {
    articleRepository.modify(id, title, content);
  }
}