package com.hello.core._2_practice.user;

import java.util.HashSet;
import java.util.Set;

/**
 * 스프링의 BeanFactory, ApplicationContext에 해당되는 클래스

 * 제어의 역전(IoC)
 * 구현에 의존하면  객체는 능동적으로 자신이 사용할 클래스를 결정하고, 직접 객체를 생성했다.
 * 하지만 제어의 역전이라는 개념이 적용되면 객체는 자신이 사용할 객체를 선택하고 생성하지 않는다.
 * 모든 제어 권한을 자신이 아닌 다른 대상에게 위임한다.
 * UserService는 DIContainer에게 모든 제어 권한을 위임한 상태다.
 * DIContainer가 객체를 생성하고 관계를 설정하도록 구현해보자.
 */


public class DIContainer {
    private final Set<Object> beans ; // 중복없이 담을 컨테이너...
    public DIContainer(final Set<Class<?>> classes){
        this.beans = creatBeans(classes);
    }
    private Set<Object> creatBeans(final Set<Class<?>> classes) {
        Set<Object> beans = new HashSet<>();
        for(Class<?> aClass : classes){
            beans.add(createInstance(aClass));
        }
        return beans;
    }

    // 객체간의 관계를 정의하는 역할을 수행.. 받아온 인스턴스를 모두 beans 필드에 저장
    private Object createInstance(final Class<?> aClass) {
        String className = aClass.getSimpleName(); //패키지 경로가 포함되지 않은 클래스명만 추출
        if (className.equals("UserServiceImpl")) {
            return new UserServiceImpl(new UserRepositoryImpl());
        }

        if (className.equals("UserRepositoryImpl")) {
            return new UserRepositoryImpl();
        }
        throw new IllegalArgumentException("해당 클래스로 빈을 등록할 수 없습니다.");
    }

    // 빈 컨텍스트(DI)에서 관리하는 빈을 찾아서 반환한다.
    @SuppressWarnings("unchecked")
    public <T> T getBean(final Class<T> aClass) {
        return (T) beans.stream()
                .filter(bean -> aClass.isAssignableFrom(bean.getClass()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}