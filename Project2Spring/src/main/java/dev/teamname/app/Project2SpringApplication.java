package dev.teamname.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dev.teamname")
@EnableJpaRepositories("dev.teamname.repositories")
@EntityScan("dev.teamname.entities")
public class Project2SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project2SpringApplication.class, args);
	}

}
