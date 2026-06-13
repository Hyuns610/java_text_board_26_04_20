package com.jhs.global.base.rq;

import lombok.Getter;
import lombok.Setter;

public class Rq {
  @Getter
  @Setter
  public String url;

  @Getter
  @Setter
  String urlPathUserType;

  @Getter
  @Setter
  String urlPathControllerName;

  @Getter
  @Setter
  String urlPathUserAction;

  public void setCommand(String url) {
    this.url = url;
  }

  public String getActionPath() {
    String[] urlBits = url.trim().split("/");

    //if(urlBits.length < 4) {
    //  System.out.println("올바른 명령어 형식이 아닙니다.(예: /usr/article/list)");
     // return null;
   // }

    // ["", "usr", "article", "list"]

    urlPathUserType = urlBits[1];
    urlPathControllerName = urlBits[2];
    urlPathUserAction = urlBits[3];

    return "/%s/%s/%s".formatted(urlPathUserType, urlPathControllerName, urlPathUserAction);
  }

  public int getUrlPathVariable() {
    String[] urlBits = url.trim().split("/");

    int id = 0;

    try {
      id = Integer.parseInt(urlBits[4]);
    } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
      System.out.println("올바른 값을 입력해주세요.");
      return id;
    }

    return id;
  }
}
