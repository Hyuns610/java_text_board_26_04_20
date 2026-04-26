package com.jhs;

import com.jhs.domain.article.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    List<Article> articles = new ArrayList<>();
    int lastId = 0;

    System.out.println("== 자바 게시판 시작 ==");

    while (true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine();

      if (cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 작성 ==");
        System.out.print("제목 : ");
        String title = sc.nextLine();

        System.out.print("내용 : ");
        String content = sc.nextLine();

        int id = ++lastId;

        Article article = new Article();
        article.id = id;
        article.title = title;
        article.content = content;

        System.out.println("생성 된 게시물 객체 : " + article);

        articles.add(article);

        System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
      }

      else if (cmd.startsWith("/usr/article/detail")) {
        String[] urlBits = cmd.trim().split("/");

        if(articles.isEmpty()) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        Article article = articles.get(articles.size() - 1); // getLast() 로 대체 가능

        System.out.printf("== %d번 게시물 상세보기 ==\n", article.id);
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.title);
        System.out.printf("내용 : %s\n", article.content);

      }

      else if (cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else {
        System.out.println("명령어 확인 후 다시 입력해주세요.");
      }
    }

    System.out.println("== 자바 게시판 종료 ==");

    sc.close();
  }
}