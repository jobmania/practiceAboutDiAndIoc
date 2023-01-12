package com.hello.core._4_practice.di_framework.annotation;

import java.lang.annotation.*;

/**
 *  Service field variables should use this annotation
 *  This annotation Can be used to avoid conflict if there are multiple implementations of the same interface
 */

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
/**
 * 모든 자식클래스에서 부모 클래스의 어노테이션이 사용 가능하다는 것을 선언
 * */

@Documented

public @interface Qualifier {

    String value() default "";
}
