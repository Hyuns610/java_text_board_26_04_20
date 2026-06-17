package com.jhs.domain.member.service;

import com.jhs.domain.article.member.member.dto.Member;
import com.jhs.domain.member.repository.MemberRepository;
import com.jhs.global.base.container.Container;

import javax.sql.RowSet;
import java.util.ArrayList;
import java.util.List;

public class MemberService {
  private MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.memberRepository;
  }

  public Member join(String username, String password, String name) {
    return memberRepository.join(username, password, name);
  }

  public Member findByUsername(String username) {
    return memberRepository.findByUsername(username);
  }

  public Member findById(int id) {
    return memberRepository.findById(id);
  }
}
