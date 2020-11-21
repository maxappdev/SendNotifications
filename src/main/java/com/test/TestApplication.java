package com.test;

import com.google.auth.oauth2.*;
import com.google.firebase.*;
import com.google.firebase.messaging.*;
import com.test.models.*;
import com.test.repositories.*;
import java.beans.*;
import java.io.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;

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

	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException {
		GoogleCredentials googleCredentials = GoogleCredentials
				.fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
		FirebaseOptions firebaseOptions = FirebaseOptions
				.builder()
				.setCredentials(googleCredentials)
				.build();
		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
		return FirebaseMessaging.getInstance(app);
	}

}
