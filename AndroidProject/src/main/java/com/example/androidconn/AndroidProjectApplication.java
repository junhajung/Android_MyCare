package com.example.androidconn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAspectJAutoProxy // aop 만들기 위한 추가
@ComponentScan({"com.example.controller"}) //controller 패키지명 위치
@EntityScan(basePackages = {"com.example.entity"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
@SpringBootApplication
public class AndroidProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndroidProjectApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AndroidProjectApplication.class);
	}
}
