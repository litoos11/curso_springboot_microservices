package com.litoos11.micro.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.litoos11.micro.commons.alumnos.entitys"})
public class MicroUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroUsuariosApplication.class, args);
	}

}
