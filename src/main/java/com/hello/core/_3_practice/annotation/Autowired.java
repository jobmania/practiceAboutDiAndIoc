package com.hello.core._3_practice.annotation;

import java.lang.annotation.*;

/**
 * Service field variables should use this annotation
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface Autowired {

    /**
     해당 어노테이션 정보가 Javadocs(API) 문서에 포함된다는것 선언
     */
}
