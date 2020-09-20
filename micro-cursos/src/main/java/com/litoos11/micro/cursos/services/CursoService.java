package com.litoos11.micro.cursos.services;

import com.litoos11.micro.commons.alumnos.entitys.Alumno;
import com.litoos11.micro.commons.services.CommonService;
import com.litoos11.micro.cursos.entitys.Curso;

public interface CursoService extends CommonService<Curso> {
	
	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> getExamenesIdsWhitRespuestasAlumno(Long alumnoId);
	
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids);
	
	public void deleteCursoAlumnoById(Long id);	
}
