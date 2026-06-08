package com.jhs.global.base.container;

import com.jhs.domain.article.controller.ArticleController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    articleController = new ArticleController();
  }
}
