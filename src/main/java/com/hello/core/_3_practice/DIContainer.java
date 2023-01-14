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
          final Constructor<?> constructor = aClass.getDeclaredConstructor();
          constructor.setAccessible(true);
          return constructor.newInstance();
      } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
          throw new RuntimeException(e);
      }
    }

    private void setFields(final Object bean) {
        final Field[] fields = bean.getClass().getDeclaredFields();

        for(Field field : fields){
            setBeanField(bean,field);
        }

    }

    private void setBeanField(final Object bean, final Field field) {
        try {
            field.setAccessible(true);
            if (hasInjectAnnotation(field)) {
                field.set(bean, getBean(field.getType()));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean hasInjectAnnotation(Field field) {
        return field.isAnnotationPresent(Autowired.class);
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