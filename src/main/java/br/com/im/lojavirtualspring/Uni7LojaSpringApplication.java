package br.com.im.lojavirtualspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Uni7LojaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Uni7LojaSpringApplication.class, args);
	}

}
