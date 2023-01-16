package com.teamxploitdx.proyecto_ubb.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String texto;
	private int orden;
	private boolean obligatoria;

	@ManyToOne()
	@JoinColumn(name = "id_encuesta")	// Referencia a la clave foranea SQL
	Encuesta encuesta;
	

	// **************************************
	// CODIGO QUE ROMPE EL PROYECTO
	// 	REVISA LA CLASE "Encuesta" PARA UNA EXPLICACION
	//
	// // Relaciones implicitas
	// @OneToMany (mappedBy = "pregunta")	// Referencia a la variable pregunta en alternativa
	// @JsonIgnore
	// @Column(nullable = true)
	// @joinColumn(name = "")
	// private Set<Alternativa> alternativas;
	//
	// @OneToMany(mappedBy = "pregunta")	// Referencia a la variable pregunta en respuesta
	// //@JsonManagedReference
	// @JsonIgnore
	// @Column(nullable = true)
    // private Set<Respuesta> respuestas;
	//
	// @OneToMany (mappedBy = "pregunta")
	// private Set<Alternativa> alternativas;
	//
	// @OneToMany(mappedBy = "pregunta")
    // private Set<Respuesta> respuestas;
	//
	// ***************************************

	public Pregunta() {
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public boolean isObligatoria() {
		return this.obligatoria;
	}

	public boolean getObligatoria() {
		return this.obligatoria;
	}

	public void setObligatoria(boolean obligatoria) {
		this.obligatoria = obligatoria;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	// public List<Alternativa> getAlternativas() {
	// 	return this.alternativas;
	// }

	// public void setAlternativas(List<Alternativa> alternativas) {
	// 	this.alternativas = alternativas;
	// }

	// public List<Respuesta> getRespuestas() {
	// 	return this.respuestas;
	// }

	// public void setRespuestas(List<Respuesta> respuestas) {
	// 	this.respuestas = respuestas;
	// }
	
}
