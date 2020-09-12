package com.litoos11.micro.cursos.services;

import com.litoos11.micro.commons.services.CommonService;
import com.litoos11.micro.cursos.entitys.Curso;

public interface CursoService extends CommonService<Curso> {
	
	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> getExamenesIdsWhitRespuestasAlumno(Long alumnoId);
}
