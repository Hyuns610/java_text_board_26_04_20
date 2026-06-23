package com.jhs.domain.article.Board.repository;

import com.jhs.domain.article.Board.dto.Board;
import com.jhs.domain.article.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoardRepository {
  private List<Board> boards;

  public BoardRepository() {
    boards = new ArrayList<>();

    makeTestData();
  }

  void makeTestData() {
    boards.add(new Board("자유", "notice"));
    boards.add(new Board("공지", "notice"));
  }

  public Board findByBoardId(int id) {
    return boards.stream()
        .filter(Board -> Board.getId() == id)
        .findFirst().orElse(null);
  }
}
