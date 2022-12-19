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
	
	// // Relaciones implicitas
	// @OneToMany (mappedBy = "pregunta")	// Referencia a la variable pregunta en alternativa
	// @JsonIgnore
	// private List<Alternativa> alternativas;
	
	// @OneToMany(mappedBy = "pregunta")	// Referencia a la variable pregunta en respuesta
	// //@JsonIgnore
	// @JsonManagedReference
    // private List<Respuesta> respuestas;


	public Pregunta() {
	}
	 
	 //Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public boolean isObligatoria() {
		return obligatoria;
	}

	public void setObligatoria(boolean obligatoria) {
		this.obligatoria = obligatoria;
	}

	// public List<Alternativa> getAlternativas() {
	// 	return alternativas;
	// }

	// public void setAlternativas(List<Alternativa> alternativas) {
	// 	this.alternativas = alternativas;
	// } 
	
	// public void addAlternativas(Alternativa alternativa) {
    //     getAlternativas().add(alternativa);
    //     alternativa.setPregunta(this);
    // }
}
