package com.test;

import com.test.models.*;
import com.test.repositories.*;
import java.beans.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(LinkRepository linkRepository){
		return args -> {
			linkRepository.save(new Link("something.com"));
			linkRepository.save(new Link("something2.com"));
		};
	}

}
