package com.litoos11.microexamenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.litoos11.micro.commons.examenes.entitys.Asignatura;
import com.litoos11.micro.commons.examenes.entitys.Examen;
import com.litoos11.micro.commons.services.CommonServiceImpl;
import com.litoos11.microexamenes.repositorys.AsignaturaRepository;
import com.litoos11.microexamenes.repositorys.ExamenRepository;

@Service("examenService")
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

	@Autowired
	@Qualifier("asignaturaRepository")
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {		
		return asignaturaRepository.findAll();
	}

}
