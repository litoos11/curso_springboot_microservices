package com.litoos11.micro.respuestas.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.litoos11.micro.respuestas.entitys.Respuesta;
import com.litoos11.micro.respuestas.services.RespuestaService;

@RestController
public class RespuestaController {

	@Autowired
	@Qualifier("respuestaService")
	private RespuestaService respuestaService;

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas) {
		respuestas = ((List<Respuesta>) respuestas).stream().map(respuesta -> {
			respuesta.setAlumnoId(respuesta.getAlumno().getId());
			return respuesta;
		}).collect(Collectors.toList());
		
		Iterable<Respuesta> respuestasSave = respuestaService.saveAll(respuestas);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestasSave);
	}

	@GetMapping("/alumno/{alumnoId}/examen/{examenId}")
	public ResponseEntity<?> getRespuestaByAlumnoAndExamen(@PathVariable Long alumnoId, @PathVariable Long examenId) {
		Iterable<Respuesta> respuestas = respuestaService.findRespuestaByAlumnoByExamen(alumnoId, examenId);
		return ResponseEntity.ok(respuestas);
	}

	@GetMapping("/alumno/{alumnoId}/examenes-respondidos")
	public ResponseEntity<?> getExamenesIdsWhitRespuestasAlumno(@PathVariable Long alumnoId) {
		Iterable<Long> examenesIds = respuestaService.findExamenesIdsWhitRespuestasByAlumno(alumnoId);
		return ResponseEntity.ok(examenesIds);
	}
}
