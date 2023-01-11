package com.hello.core._1_member;

import com.hello.core._1_springbasicdi.AppConfig;
import com.hello.core._1_springbasicdi.Member;
import com.hello.core._1_springbasicdi.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberInMemoryTest {

    MemberService memberService;


    @BeforeEach //테스트전
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }



    @Test
    @DisplayName("인메모리 테스트")
    void checkMember(){

        Member member = new Member(1L,"member1");

        memberService.join(member);
        Member member1 = memberService.findById(1L);


        Assertions.assertThat(member1).isEqualTo(member);

    }

}
