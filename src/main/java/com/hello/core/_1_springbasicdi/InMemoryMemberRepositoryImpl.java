package com.hello.core._1_springbasicdi;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryMemberRepositoryImpl implements MemberRepository {


    private static Map<Long, Member> store = new HashMap<>();



    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
