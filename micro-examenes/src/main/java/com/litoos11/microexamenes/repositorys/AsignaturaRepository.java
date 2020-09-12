package com.litoos11.microexamenes.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.litoos11.micro.commons.examenes.entitys.Asignatura;

@Repository("asignaturaRepository")
public interface AsignaturaRepository extends CrudRepository<Asignatura, Long>{

}
