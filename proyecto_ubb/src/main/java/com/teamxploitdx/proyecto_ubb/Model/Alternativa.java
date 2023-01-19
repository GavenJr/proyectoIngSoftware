
package com.teamxploitdx.proyecto_ubb.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Alternativa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String texto;
	
	@ManyToOne()
    @JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;
	
	// **************************************
	// CODIGO QUE ROMPE EL PROYECTO
	// 	REVISA LA CLASE "Encuesta" PARA UNA EXPLICACION
	//
	// // Relaciones implicitas
	// @OneToMany(mappedBy = "alternativa")
	// @JsonManagedReference
	// @JsonIgnore
    // private Set<Respuesta> respuestas;
	//
	// @OneToMany(mappedBy = "alternativa")
    // private Set<Respuesta> respuestas;
	//
	// ***************************************

	public Alternativa() {
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

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	// public List<Respuesta> getRespuestas() {
	// 	return this.respuestas;
	// }

	// public void setRespuestas(List<Respuesta> respuestas) {
	// 	this.respuestas = respuestas;
	// }

}
