package com.jhs.global.base.container;

import com.jhs.domain.article.Board.controller.BoardController;
import com.jhs.domain.article.Board.dto.Board;
import com.jhs.domain.article.Board.repository.BoardRepository;
import com.jhs.domain.article.Board.service.BoardService;
import com.jhs.domain.article.article.controller.ArticleController;
import com.jhs.domain.article.article.repository.ArticleRepository;
import com.jhs.domain.article.article.service.ArticleService;
import com.jhs.domain.member.controller.MemberController;
import com.jhs.domain.member.repository.MemberRepository;
import com.jhs.domain.member.service.MemberService;
import com.jhs.global.base.interceptor.NeedLoginInterceptor;
import com.jhs.global.base.interceptor.NeedLogoutInterceptor;
import com.jhs.global.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static Session session;

  public static NeedLoginInterceptor needLoginInterceptor;
  public static NeedLogoutInterceptor needLogoutInterceptor;

  public static BoardRepository boardRepository;
  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static BoardService boardService;
  public static MemberService memberService;
  public static ArticleService articleService;

  public static BoardController boardController;
  public static MemberController memberController;
  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    session = new Session();

    needLoginInterceptor = new NeedLoginInterceptor();
    needLogoutInterceptor = new NeedLogoutInterceptor();

    boardRepository = new BoardRepository();
    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    boardService = new BoardService();
    memberService = new MemberService();
    articleService = new ArticleService();

    boardController = new BoardController();
    memberController = new MemberController();
    articleController = new ArticleController();
  }
}