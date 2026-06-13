package com.jhs.global.base.container;

import com.jhs.domain.article.controller.ArticleController;
import com.jhs.domain.article.repository.ArticleRepository;
import com.jhs.domain.article.service.ArticleService;
import com.jhs.domain.member.controller.MemberController;
import com.jhs.domain.member.repository.MemberRepository;
import com.jhs.domain.member.service.MemberService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static MemberController memberController;
  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);

    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}