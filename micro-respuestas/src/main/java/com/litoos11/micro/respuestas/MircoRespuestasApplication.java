package com.litoos11.micro.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.litoos11.micro.respuestas.entitys",
	//"com.litoos11.micro.commons.alumnos.entitys",
	"com.litoos11.micro.commons.examenes.entitys"})
public class MircoRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoRespuestasApplication.class, args);
	}

}
