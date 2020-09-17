package com.pika.Onlinegrocerystore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan(value = "com.pika.Onlinegrocerystore.dao")
@ComponentScan("com.pika.Onlinegrocerystore.Controller")
@ComponentScan("com.pika.Onlinegrocerystore.Services")

public class OnlineGroceryStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGroceryStoreApplication.class, args);
	}

}
