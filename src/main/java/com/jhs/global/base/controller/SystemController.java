package com.jhs.global.base.controller;

import com.jhs.domain.article.controller.ArticleController;
import com.jhs.global.base.container.Container;
import com.jhs.global.base.rq.Rq;

import java.util.Scanner;

public class SystemController {
  private ArticleController articleController;

  public SystemController() {
    articleController = Container.articleController;
  }

  public void run() {
    Scanner sc = Container.sc;
    Rq rq = new Rq();
    System.out.println("== 자바 게시판 시작 ==");

    while (true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine().trim();

      rq.setCommand(cmd);
      rq.getActionPath();

      if(cmd.trim().isEmpty()) {
        System.out.println("명령어를 입력해주세요.");
        continue;
      }

      if(cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        System.out.println("== 자바 게시판 종료 ==");

        sc.close();
        break;
      }

      switch (rq.getUrlPathUserType()) {
        case "usr" -> {
          switch (rq.getUrlPathControllerName()) {
            case "article" -> {
              switch (rq.getUrlPathUserAction()) {
                case "write" -> articleController.doWrite();
                case "detail" -> articleController.showDetail();
                case "list" -> articleController.showList();
              }
            }
          }
        }
      }
    }
  }
}
