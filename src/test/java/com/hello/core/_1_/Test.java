package com.hello.core._1_;

import com.hello.core._1_springbasicdi.AppConfig;
import com.hello.core._1_springbasicdi.Member;
import com.hello.core._1_springbasicdi.MemberService;
import com.hello.core._1_springbasicdi.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @org.junit.jupiter.api.Test
    void Test1(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        Member member = new Member(1L,"BBC");
        memberService.join(member);

        Member findMember = memberService.findById(1L);
        Assertions.assertThat(findMember.getName()).isEqualTo("BBC");

    }
}
