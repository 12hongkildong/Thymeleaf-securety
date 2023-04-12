package kr.co.rland.web.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//interface에 @을 붙여주면 어노테이션을 정의하는 것이다.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
	//속성으로 인식된다.
	String value();
}
