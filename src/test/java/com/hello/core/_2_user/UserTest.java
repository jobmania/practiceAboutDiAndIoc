package com.hello.core._2_user;

import com.hello.core._2_practice._1_DIContainer;
import com.hello.core._2_practice.user.InMemoryUserDao;
import com.hello.core._2_practice.user.User;
import com.hello.core._2_practice.user.UserDao;
import com.hello.core._2_practice.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class UserTest {
    @Test
    void testAnonymousClass() {
        // given  // var는 변수를 선언할 때 타입을 생략할 수 있으며, 컴파일러가 타입을 추론
        final var userDao = new UserDao() {
            private User user;

            @Override
            public void insert(User user) {
                this.user = user;
            }

            @Override
            public User findById(long id) {
                return user;
            }
        };

        

        final var userService = new UserService(userDao);
        final var user = new User(1L, "gugu");

        // when
        final var actual = userService.join(user);

        // then
        Assertions.assertThat(actual.getName()).isEqualTo("gugu");
    }



}
