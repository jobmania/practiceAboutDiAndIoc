package com.hello.core._3_test;

import com.hello.core._2_practice.user.User;
import com.hello.core._3_practice.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class UserTest {

    UserService userService;


    @BeforeEach //테스트전
    public void beforeEach(){
        TestConfig testConfig = new TestConfig();
        userService = testConfig.userService();

    }


    @Test
    void checkUser(){
        User user = new User(1L, "AA");
        userService.join(user);

        User findUser = userService.findById(1L);

        Assertions.assertThat(findUser).isEqualTo(user);

    }



    @Configuration
    static class TestConfig{
        @Inject
        public UserService userService(){
            return new UserServiceImpl(userRepository());
        }
        @Inject
        public UserRepository userRepository(){
            return new UserRepositoryImpl();
        }
    }
}
