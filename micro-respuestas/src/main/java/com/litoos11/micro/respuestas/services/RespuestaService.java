package com.litoos11.micro.respuestas.services;

import com.litoos11.micro.respuestas.entitys.Respuesta;

public interface RespuestaService {

	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);
	
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
	
	public Iterable<Long> findExamenesIdsWhitRespuestasByAlumno(Long alumnoId);
}
