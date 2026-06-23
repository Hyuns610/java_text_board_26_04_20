package com.jhs.domain.article.Board.service;

import com.jhs.domain.article.Board.dto.Board;
import com.jhs.domain.article.Board.repository.BoardRepository;
import com.jhs.global.base.container.Container;

public class BoardService {
  private BoardRepository boardRepository;

  public BoardService() {
    boardRepository = Container.boardRepository;
  }

  public Board findByBoardId(int id) {
    return boardRepository.findByBoardId(id);
  }
}
