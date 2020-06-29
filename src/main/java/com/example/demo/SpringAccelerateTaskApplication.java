package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.AccountRepository;


@EnableJpaAuditing
@SpringBootApplication
public class SpringAccelerateTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAccelerateTaskApplication.class, args);

		
		
	}

}
