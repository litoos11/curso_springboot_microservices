package com.litoos11.micro.app.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.litoos11.micro.app.usuarios.client.CursoFeignClient;
import com.litoos11.micro.app.usuarios.repositorys.AlumnoRepository;
import com.litoos11.micro.commons.alumnos.entitys.Alumno;
import com.litoos11.micro.commons.services.CommonServiceImpl;

@Service("alumnoService")
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Autowired
	private CursoFeignClient clientCurso;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String search) {
		return repository.findByNombreOrApellido(search);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void deleteCursoAlumnoById(Long id) {
		clientCurso.deleteCursoAlumnoById(id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		this.deleteCursoAlumnoById(id);
	}
	
}
