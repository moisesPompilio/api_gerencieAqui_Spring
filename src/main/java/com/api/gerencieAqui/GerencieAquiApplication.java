package com.api.gerencieAqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.gerencieAqui.infrastructure.repository.CustomJpaRepositoryImpl;


@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class GerencieAquiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerencieAquiApplication.class, args);
	}

}
