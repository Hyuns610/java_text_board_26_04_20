package com.jhs.global.base.container;

import com.jhs.domain.article.controller.ArticleController;
import com.jhs.domain.article.service.ArticleService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleService articleService;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);

    articleService = new ArticleService();

    articleController = new ArticleController();
  }
}
