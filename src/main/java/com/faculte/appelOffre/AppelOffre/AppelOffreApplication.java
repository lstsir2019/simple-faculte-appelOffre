package com.faculte.appelOffre.AppelOffre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.faculte.appelOffre.AppelOffre.domain.rest")
@EnableDiscoveryClient
public class AppelOffreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppelOffreApplication.class, args);
	}

}
