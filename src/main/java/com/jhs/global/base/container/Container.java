package com.jhs.global.base.container;

import com.jhs.domain.article.controller.ArticleController;
import com.jhs.domain.article.repository.ArticleRepository;
import com.jhs.domain.article.service.ArticleService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleRepository articleRepository;

  public static ArticleService articleService;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);

    articleRepository = new ArticleRepository();

    articleService = new ArticleService();

    articleController = new ArticleController();
  }
}