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

  public Article write(String title, String content, int writerId, String writerName) {
    return articleRepository.write(title, content, writerId, writerName);
  }

  public List<Article> getArticles() {
    return articleRepository.findByAll();
  }

  public List<Article> getArticles(String keyword) {
    if(keyword.isEmpty()) return articleRepository.findByAll();

    return getFilteredArticles(keyword);
  }

  private List<Article> getFilteredArticles(String keyword) {
    return articleRepository.findByKeywordContaining(keyword);
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }

  public void modify(int id, String title, String content) {
    articleRepository.modify(id, title, content);
  }

  public void delete(int id) {
    articleRepository.delete(id);
  }
}