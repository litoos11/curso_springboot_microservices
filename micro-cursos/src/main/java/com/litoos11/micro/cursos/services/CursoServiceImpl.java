package com.litoos11.micro.cursos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.litoos11.micro.commons.alumnos.entitys.Alumno;
import com.litoos11.micro.commons.services.CommonServiceImpl;
import com.litoos11.micro.cursos.clients.AlumnoFeignClient;
import com.litoos11.micro.cursos.clients.RespuestaFeignClient;
import com.litoos11.micro.cursos.entitys.Curso;
import com.litoos11.micro.cursos.repositorys.CursoRepository;

@Service("cursoService")
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Autowired
	private RespuestaFeignClient client;
	
	@Autowired
	private AlumnoFeignClient clientAlumno;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> getExamenesIdsWhitRespuestasAlumno(Long alumnoId) {
		return client.getExamenesIdsWhitRespuestasAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids) {		
		return clientAlumno.obtenerAlumnosPorCurso(ids);
	}

	@Override
	@Transactional
	public void deleteCursoAlumnoById(Long id) {
		repository.deleteCursoAlumnoById(id);
	}
	
}
