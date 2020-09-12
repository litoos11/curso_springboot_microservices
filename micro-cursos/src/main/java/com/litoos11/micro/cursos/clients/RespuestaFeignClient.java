package com.litoos11.micro.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "micro-respuestas")
public interface RespuestaFeignClient {

	@GetMapping("/alumno/{alumnoId}/examenes-respondidos")
	public Iterable<Long> getExamenesIdsWhitRespuestasAlumno(@PathVariable Long alumnoId);
}
