package com.jhs.global.base.controller;

import com.jhs.domain.article.member.member.dto.Member;
import com.jhs.global.base.controller.BaseController;
import com.jhs.domain.article.controller.ArticleController;
import com.jhs.global.base.container.Container;
import com.jhs.global.base.interceptor.Interceptor;
import com.jhs.global.base.rq.Rq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemController {
  public void run() {
    Scanner sc = Container.sc;
    Rq rq = new Rq();

    System.out.println("== 자바 게시판 시작 ==");

    while (true) {
      String promptName = "명령";

      if(rq.isLogined()) {
        Member member = rq.getLoginedMember();
        promptName = member.getUsername();
      }

      System.out.printf("%s) ", promptName);
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

      if(!rq.getUrlPathUserType().startsWith("usr")) {
        System.out.println("명령어를 확인 후 다시 입력해주세요.");
        return;
      }

      if(!runInterceptor(rq)) continue;

      BaseController baseController = getControllerByRequestUrl(rq);

      if(baseController != null) {
        baseController.doAction(rq);
      }

    }
  }

  private BaseController getControllerByRequestUrl(Rq rq) {
    switch (rq.getUrlPathUserType()) {
      case "usr" -> {
        switch (rq.getUrlPathControllerName()) {
          case "article" -> {
            return Container.articleController;
          }
          case "member" -> {
            return Container.memberController;
          }
        }
      }
    }

    return null;
  }
  private boolean runInterceptor(Rq rq) {
    List<Interceptor> interceptors = new ArrayList<>();

    interceptors.add(Container.needLoginInterceptor);
    interceptors.add(Container.needLogoutInterceptor);

    for(Interceptor interceptor : interceptors) {
      if(!interceptor.run(rq)) {
        return false;
      }
    }

    return true;
  }
}