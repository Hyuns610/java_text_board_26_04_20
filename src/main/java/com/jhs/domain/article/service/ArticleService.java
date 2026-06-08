package com.jhs.domain.article.service;

import com.jhs.domain.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleService {
  private List<Article> articles;

  public ArticleService() {
    articles = new ArrayList<>();

    makeArticleTestData();
  }

  void makeArticleTestData() {
    IntStream.rangeClosed(1, 5)
        .forEach(
            i -> write("제목" + i, "내용" + i)
        );
  }

  public Article write(String title, String content) {
    Article article = new Article(title, content);
    articles.add(article);

    return article;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public Article findById(int id) {
    return articles.stream()
        .filter(article -> article.id == id) // 필터링
        .findFirst().orElse(null); // 찾으면 찾은 것중에 첫 번째거를 리턴, 못 찾으면 null을 반환
  }
}
