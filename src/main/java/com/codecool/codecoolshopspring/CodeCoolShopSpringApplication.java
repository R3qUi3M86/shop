package com.codecool.codecoolshopspring;

import com.codecool.codecoolshopspring.model.user.User;
import com.codecool.codecoolshopspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CodeCoolShopSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(CodeCoolShopSpringApplication.class, args);
	}
}
