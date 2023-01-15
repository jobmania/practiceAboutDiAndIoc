package com.hello.core._3Test;

import com.hello.core._1_springbasicdi.AppConfig;
import com.hello.core._3_practice.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @org.junit.jupiter.api.Test
    void test3(){
        User user = new User(1L,"power");

        DIContainer diContainer = createDIContainer();
        final var userService = diContainer.getBean(UserService.class);
        userService.save(user);

        User findUser = userService.find(1L);

        Assertions.assertThat(findUser.getName()).isEqualTo("power");

    }

    private static DIContainer createDIContainer() {
        final var rootPackageName = User.class.getPackage().getName();
        return DIContainer.createContainerForPackage(rootPackageName);
    }


}
