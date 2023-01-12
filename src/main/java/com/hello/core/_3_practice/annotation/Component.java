package com.hello.core._3_practice.annotation;


/**
 * Client class should use this annotation
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
/**
 애노테이션의 메타 정보가 언제 버려질지에 대한 타이밍을 설정 , /SOURCE, CLASS, RUNTIME 중 하나를 선택/
 RetentionPolicy.RUNTIME : 런타임 동안에 유지되고, 런타임 동안에 프로그램에서 접근도 가능하다. Reflection API 로 접근도 가능
 RetentionPolicy.CLASS : 컴파일러가 컴파일에서는 어노테이션의 메모리를 가져가지만 실질적으로 런타임시에는 사라지게 됩니다.
                            런타임시에 사라진다는 것은 리플렉션으로 선언된 어노테이션 데이터를 가져올 수 없게 됩니다
 RetentionPolicy.SOURCE : 소스코드인 구간에만 유지되고 클래스 파일이 되는 컴파일 과정에서 애노테이션 정보는 사라진다. 어노테이션을 사실상 주석처럼 사용하는 것.
 * */

@Target(ElementType.TYPE)
 /**Target의 기능은 어노테이션을 붙일 수 있는 대상을 지정하는 것이다.
 위의 매개 변수로 TYPE / CONSTRUCTOR / METHOD / FIELD / PARAMETER 등등... CONSTRUCTOR / METHOD / FIELD 3 가지는 이름 그대로
 생성자와 메소드 필드에 어노테이션을 붙일 수 있다는 의미이며, TYPE 는 클래스,인터페이스,열거타입에 어노테이션을 붙일 수 있다는 의미이다.*/
public @interface Component {
}
