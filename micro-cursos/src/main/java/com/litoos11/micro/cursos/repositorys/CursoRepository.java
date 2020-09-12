package com.litoos11.micro.cursos.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.litoos11.micro.cursos.entitys.Curso;

@Repository("cursoRepository")
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long>{

	@Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
	public Curso findCursoByAlumnoId(Long id);
}
