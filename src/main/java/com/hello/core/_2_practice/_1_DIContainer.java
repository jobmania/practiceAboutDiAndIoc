package com.hello.core._2_practice;

import com.hello.core._2_practice.user.InMemoryUserDao;
import com.hello.core._2_practice.user.UserService;

import java.util.HashSet;
import java.util.Set;

public class _1_DIContainer {

    private Set<Object> beans;

    public _1_DIContainer(Set<Class<?>> classes) {
        // 중복없이 클래스를 담을 set.
        Set<Object> beans = new HashSet<>();
        for (Class<?> clazz : classes) {
            Object instance = instantiateClass(clazz);
            beans.add(instance);
        }

        this.beans = beans;
    }

    private Object instantiateClass(Class<?> clazz) {
        String className = clazz.getSimpleName(); // getSimpleName()은 패키지 경로가 포함되지 않은 클래스명만 추출

        if (className.equals("UserService")) {
            return new UserService(new InMemoryUserDao());
        }
        if (className.equals("InMemoryUserDao")) {
            return new InMemoryUserDao();
        }
        throw new IllegalArgumentException("해당 클래스로 빈을 등록할 수 없습니다.");
    }
}