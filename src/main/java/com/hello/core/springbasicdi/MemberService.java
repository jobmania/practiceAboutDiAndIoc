package com.hello.core.springbasicdi;

public interface MemberService {
    void join(Member member);
    Member findById(Long memberId);
}
