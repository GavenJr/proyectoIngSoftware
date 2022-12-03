package com.teamxploitdx.proyecto_ubb.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Borrador {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date ultima_edicion;
	
	@ManyToOne()
    @JoinColumn(name = "id_encuestado")
	private Encuestado encuestado;
	
	//agregar relacion con encuestas
	
	@OneToMany(mappedBy = "university")
    private List<Respuesta> respuestas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUltima_edicion() {
		return ultima_edicion;
	}

	public void setUltima_edicion(Date ultima_edicion) {
		this.ultima_edicion = ultima_edicion;
	}

	public Encuestado getEncuestado() {
		return encuestado;
	}

	public void setEncuestado(Encuestado encuestado) {
		this.encuestado = encuestado;
	}
}
