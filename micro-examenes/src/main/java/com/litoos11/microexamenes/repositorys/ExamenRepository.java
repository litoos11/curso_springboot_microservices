package com.litoos11.microexamenes.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.litoos11.micro.commons.examenes.entitys.Examen;

public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long>{

	@Query("select e from Examen e where e.nombre like %?1%")
	public List<Examen> findByNombre(String nombre);
}
