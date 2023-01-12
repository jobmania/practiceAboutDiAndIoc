package com.hello.core._4_practice.di_framework.annotation;

import java.lang.annotation.*;

/**
 * Service field variables should use this annotation
 */
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 해당 어노테이션 정보가 Javadocs(API) 문서에 포함된다는것 선언
 */
public @interface Autowired {
//   해당 어노테이션이 붙은 것을 injector 가 모두 찾아내어 오브젝트를 생성하고, {class : class's object}형태의 map에 저장해둔다
}
