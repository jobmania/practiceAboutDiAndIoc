package com.hello.core._3_practice;


import com.hello.core._3_practice.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class DIContainer {

    private final Set<Object> beans ;

    public DIContainer(final Set<Class<?>> classes){
        this.beans = creatBeans(classes);
        this.beans.forEach(this::setFields);
    }

    /**
     * 특정 패키지 아래에 존재하는 지정한 어노테이션이 붙어 있는 모든 클래스들을 찾아,
     * 이를 이용해서 빈을 등록하도록 구성.
    * */
    public static DIContainer createContainerForPackage(final String rootPackageName){
        final Set<Class<?>> allClassesInPackage = ClassPathScanner.getClassesInPackage(rootPackageName);
        return new DIContainer(allClassesInPackage);
    }



    //객체 생성..
    private Set<Object> creatBeans(final Set<Class<?>> classes) {
        Set<Object> beans = new HashSet<>();
        for(Class<?> aClass : classes){
            beans.add(createInstance(aClass));
        }
        return beans;
    }

    // 객체간의 관계를 정의하는 역할을 수행.. 받아온 인스턴스를 모두 beans 필드에 저장
    private Object createInstance(final Class<?> aClass) {
      try{
          final Constructor<?> constructor = aClass.getDeclaredConstructor();  // 생성자를 통한 객체생성.
          constructor.setAccessible(true); // private 에 대한 접근을 열어준다.
          return constructor.newInstance();
      } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
          throw new RuntimeException(e);
      }
    }

    //객체의 모든 필드를 리플렉션을 사용하여 가져옴.
    private void setFields(final Object bean) {
        final Field[] fields = bean.getClass().getDeclaredFields();  //  접근제어자 상관없이 필드 정보 조회
                                                                 // 클래스에 정의된 필드들의 정보들을 필드타입을 받아옴..
        for(Field field : fields){
            setBeanField(bean,field);
        }

    }

    //빈들 중에서 할당 가능한 빈이 있을 경우 해당 빈을 등록해주는 것이다.
    private void setBeanField(final Object bean, final Field field) {
        try {
            field.setAccessible(true);
            if (field.getAnnotation(Autowired.class) != null) {  // @Autowired 어노테이션이 붙어 있는 필드에 대해서만 주입을 진행
                field.set(bean, getBean(field.getType()));  // 해당 빈에 필드 인스턴스들을 주입..
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

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