package com.litoos11.micro.respuestas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.litoos11.micro.respuestas.entitys.Respuesta;
import com.litoos11.micro.respuestas.repositorys.RespuestaRepository;

@Service("respuestaService")
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	@Qualifier("respuestaRepository")
	private RespuestaRepository respuestaRepository;

	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return respuestaRepository.saveAll(respuestas);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
		return respuestaRepository.findRespuestaByAlumnoByExamen(alumnoId, examenId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsWhitRespuestasByAlumno(Long alumnoId) {
		return respuestaRepository.findExamenesIdsWhitRespuestasByAlumno(alumnoId);
	}

}
