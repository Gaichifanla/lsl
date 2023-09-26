package com.lsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//(scanBasePackages = "com.lsl.controller")
@MapperScan("com.lsl.mapper")
public class LslApplication {
	public static void main(String[] args) {
		SpringApplication.run(LslApplication.class, args);
	}

}
