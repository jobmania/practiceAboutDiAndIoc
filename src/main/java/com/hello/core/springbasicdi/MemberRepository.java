package com.hello.core.springbasicdi;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
