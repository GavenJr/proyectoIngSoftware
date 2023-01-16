package com.teamxploitdx.proyecto_ubb.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Borrador {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date ultima_edicion;
	// private Date finalizado;
	
	@ManyToOne()
    @JoinColumn(name = "id_encuestado")	// Referencia a la clave foranea SQL
	private Encuestado encuestado;
	
	@ManyToOne()
	@JoinColumn(name = "id_encuesta")	// Referencia a la clave foranea SQL
	private Encuesta encuesta;
	
	/* **************************************
	// CODIGO QUE ROMPE EL PROYECTO
	//
	// // Relaciones implicitas
	// //@OneToMany(mappedBy = "university")
	// @OneToMany(mappedBy = "borrador")
	// //@JsonManagedReference
	// @JsonIgnore
	// @Column(nullable = true)
    // private List<Respuesta> respuestas;

	// @OneToMany(mappedBy = "borrador")
    // private List<Respuesta> respuestas;

	*****************************************/
	
	public Borrador() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUltima_edicion() {
		return this.ultima_edicion;
	}

	public void setUltima_edicion(Date ultima_edicion) {
		this.ultima_edicion = ultima_edicion;
	}

	// public Date getFinalizado() {
	// 	return this.finalizado;
	// }

	// public void setFinalizado(Date finalizado) {
	// 	this.finalizado = finalizado;
	// }

	public Encuestado getEncuestado() {
		return this.encuestado;
	}

	public void setEncuestado(Encuestado encuestado) {
		this.encuestado = encuestado;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	// public List<Respuesta> getRespuestas() {
	// 	return this.respuestas;
	// }

	// public void setRespuestas(List<Respuesta> respuestas) {
	// 	this.respuestas = respuestas;
	// }


	
}
