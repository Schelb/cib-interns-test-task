package com.example.Raiffeisen;

import Controller.SocksController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = SocksController.class)
public class RaiffeisenApplication {
	public static void main(String[] args) {
		SpringApplication.run(RaiffeisenApplication.class, args);
	}
}
