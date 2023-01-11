package com.hello.core._1_springbasicdi;

public interface MemberService {
    void join(Member member);
    Member findById(Long memberId);
}
