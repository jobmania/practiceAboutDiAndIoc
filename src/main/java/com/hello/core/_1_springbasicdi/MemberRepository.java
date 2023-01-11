package com.hello.core._1_springbasicdi;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
