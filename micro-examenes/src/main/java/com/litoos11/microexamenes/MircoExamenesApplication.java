package com.litoos11.microexamenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.litoos11.micro.commons.examenes.entitys"})
public class MircoExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoExamenesApplication.class, args);
	}

}
