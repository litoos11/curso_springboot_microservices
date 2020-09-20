package com.litoos11.micro.respuestas.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.litoos11.micro.commons.alumnos.entitys.Alumno;
import com.litoos11.micro.commons.examenes.entitys.Pregunta;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name = "respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String texto;

	// @ManyToOne(fetch = FetchType.LAZY)
	@Transient
	private Alumno alumno;

	@Column(name = "alumno_id")
	private Long alumnoId;

	@OneToOne(fetch = FetchType.LAZY)
	private Pregunta pregunta;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

}
