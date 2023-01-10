package com.hello.core.practice;

import java.util.HashSet;
import java.util.Set;

public class DiContainer {
    private final Set<Object> beans;

    public DIContainer(final Set<Class<?>> classes) {
        Set<Object> beans = new HashSet<>();
        for (Class<?> clazz : classes) {
            Object instance = instantiateClass(clazz);
            beans.add(instance);
        }

        this.beans = beans;
    }

    // instantiateClass() 메소드는 객체간의 관계를 정의하는 역할을 수행
    private Object instantiateClass(final Class<?> clazz) {
        String className = clazz.getSimpleName();
        if (className.equals("UserService")) {
            return new UserService(new InMemoryUserDao());  // 외부에서 주입..
        }

        if (className.equals("InMemoryUserDao")) {
            return new InMemoryUserDao();
        }

        throw new IllegalArgumentException("해당 클래스로 빈을 등록할 수 없습니다.");
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(final Class<T> aClass) {
        return (T) beans.stream()
                .filter(it -> it.getClass().equals(aClass))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("빈을 찾을 수 없습니다."));
    }


}
