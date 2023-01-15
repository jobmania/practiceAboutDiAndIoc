package com.hello.core._2_Test;

import com.hello.core._2_practice.user.*;
import org.assertj.core.api.Assertions;

import java.util.HashSet;

public class Test {

    @org.junit.jupiter.api.Test
    void test2(){

        User user = new User(1L,"John");

        DIContainer diContainer = creatDIContainer();

        UserService userService = diContainer.getBean(UserService.class);

        userService.save(user);
        User findUser = userService.findById(1L);

        Assertions.assertThat(findUser.getName()).isEqualTo("John");

    }

    private static DIContainer creatDIContainer() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        // 빈으로 등록할 타입을 지정..
        classes.add(UserRepositoryImpl.class);
        classes.add(UserServiceImpl.class);
        return new DIContainer(classes);
    }

}
