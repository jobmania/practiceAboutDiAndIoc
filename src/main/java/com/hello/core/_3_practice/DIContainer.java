package com.hello.core._3_practice;

import java.util.Set;

public class DIContainer {

    private final Set<Object> beans;

    public DIContainer(final Set<Class<?>> beans) {
        this.beans = createBeans(beans);   // 생성한 빈을 저장..
    }

    private Set<Object> createBeans


}
