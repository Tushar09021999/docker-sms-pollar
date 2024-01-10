package com.SmsPollar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SmsPollarApplication {

	public String PORT = System.getenv("PORT");

    @Bean
   public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SmsPollarApplication.class, args);
	}
}
