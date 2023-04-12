package kr.co.rland.web.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import kr.co.rland.web.repository.jdbc.JdbcMenuRepository;

//스프링이 제공하는 객체 생성 어노테이션
//@Component, @Service, @Repository, @Configuration, @Controller(URL에 매칭)<- IOC 컨테이너에 들어갈 녀석들이다.

//@Configuration
public class Config {
	//함수명이 name이 될 것이다.
//	@Bean //반환하는 것을 IOC 컨테이너에 넣어달라는 어노테이션
//	public JdbcMenuRepository repository() {
//		return new JdbcMenuRepository();
//	}
	
	@Bean
	public List list() {
		return new ArrayList<>();
	}
	
	@Bean
	public String hello() {
		return "Hello 콩자루?";
	}
}
