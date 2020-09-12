package com.litoos11.micro.app.usuarios.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.litoos11.micro.commons.alumnos.entitys.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long>{
	
	@Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Alumno> findByNombreOrApellido(String search);
}
