package com.litoos11.microexamenes.services;

import java.util.List;

import com.litoos11.micro.commons.examenes.entitys.Asignatura;
import com.litoos11.micro.commons.examenes.entitys.Examen;
import com.litoos11.micro.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen>{
	
	public List<Examen> findByNombre(String nombre);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
