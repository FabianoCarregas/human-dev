package br.com.alura.humandev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HumandevApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumandevApplication.class, args);
	}

}
