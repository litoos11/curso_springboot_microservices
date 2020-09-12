package com.litoos11.microexamenes.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.litoos11.micro.commons.controllers.CommonController;
import com.litoos11.micro.commons.examenes.entitys.Examen;
import com.litoos11.microexamenes.services.ExamenService;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Examen examen, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Examen> optionalExamen = service.findById(id);
		
		if(!optionalExamen.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen examenDb = optionalExamen.get();
		examenDb.setNombre(examen.getNombre());
		
//		List<Pregunta> eliminadas = new ArrayList<Pregunta>();
//		
//		examenDb.getPreguntas().forEach(pdb -> {
//			if(!examen.getPreguntas().contains(pdb)) {
//				eliminadas.add(pdb);
//			}
//		});
		
//		eliminadas.forEach(p -> {
//			examenDb.removePregunta(p);
//		});
		
		examenDb.getPreguntas()
			.stream()
			.filter(pdb -> !examen.getPreguntas().contains(pdb))
			.forEach(examenDb::removePregunta);		
		
		examenDb.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
	
	@GetMapping("/buscar/{nombre}")
	public ResponseEntity<?> getExamenByNombre(@PathVariable String nombre){
		return ResponseEntity.ok(service.findByNombre(nombre));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignaturas(){
		return ResponseEntity.ok(service.findAllAsignaturas());
	}

}
