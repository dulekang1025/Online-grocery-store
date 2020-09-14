package com.pika.Onlinegrocerystore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.pika.Onlinegrocerystore.dao")
public class OnlineGroceryStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGroceryStoreApplication.class, args);
	}

}
