package com.hello.core._3_practice;


import com.hello.core._3_practice.annotation.Autowired;
import com.hello.core._3_practice.annotation.Component;
import org.reflections.Reflections;


import java.util.HashSet;
import java.util.Set;

public class ClassPathScanner {

    public static Set<Class<?>> getClassesInPackage(final String packageName){

        Set<Class<?>> classes = new HashSet<>();
        Reflections reflections = new Reflections(packageName);

        final Set<Class<?>> componentClass = reflections.getTypesAnnotatedWith(Component.class);
        final Set<Class<?>> autoWiredClass = reflections.getTypesAnnotatedWith(Autowired.class);

        classes.addAll(componentClass);
        classes.addAll(autoWiredClass);

        return classes;
    }

}
