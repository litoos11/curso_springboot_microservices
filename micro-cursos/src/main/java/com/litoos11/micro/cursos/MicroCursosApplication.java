package com.litoos11.micro.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.litoos11.micro.commons.alumnos.entitys",
			"com.litoos11.micro.commons.examenes.entitys",
			"com.litoos11.micro.cursos.entitys"})
public class MicroCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCursosApplication.class, args);
	}

}
