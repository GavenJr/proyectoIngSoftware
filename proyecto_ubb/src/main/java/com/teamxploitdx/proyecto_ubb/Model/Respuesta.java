package com.teamxploitdx.proyecto_ubb.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// @ManyToOne
	// @JoinColumn(name = "id_pregunta")
    // private Pregunta pregunta;
	
	// @ManyToOne
	// @JoinColumn(name = "id_alternativa")
	// private Alternativa alternativa;
	
	// @ManyToOne()
    // @JoinColumn(name = "id_borrador")
	// private Borrador borrador;

	// @OneToOne
	// @JoinColumn(name = "id_pregunta")
    // private Pregunta pregunta;

	// @OneToOne
	// @JoinColumn(name = "id_alternativa")
	// private Alternativa alternativa;

	// @ManyToOne()
    // @JoinColumn(name = "id_borrador")
	// private Borrador borrador;

	public Respuesta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Alternativa getAlternativa() {
		return this.alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

	public Borrador getBorrador() {
		return this.borrador;
	}

	public void setBorrador(Borrador borrador) {
		this.borrador = borrador;
	}

}