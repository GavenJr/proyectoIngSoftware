package com.teamxploitdx.proyecto_ubb.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Encuestado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
    private String apellido;
	private String email;
	
	@ManyToMany
    @JoinTable(name = "preferencias", joinColumns = @JoinColumn(name = "id_encuestado"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> preferencias;
	

	// **************************************
	// CODIGO QUE ROMPE EL PROYECTO
	// 	REVISA LA CLASE "Encuesta" PARA UNA EXPLICACION
	//
	// @OneToMany (mappedBy = "encuestado")
	// private Set<Borrador> borradores;
	// ***************************************

	public Encuestado() {
	}
	 
	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Many to Many
	public List<Categoria> getPreferencias() {
        if (preferencias == null) {
            preferencias = new ArrayList<>();
        }
        return preferencias;
    }

    public void setPreferencias(List<Categoria> preferencias) {
        this.preferencias = preferencias;
    }
    
    public void addPreferencias(Categoria categoria) {
        getPreferencias().add(categoria);
        categoria.addEncuestado(this);
    }
    
    // //One to Many
	// public List<Borrador> getBorradores() {
	// 	return borradores;
	// }
	// public void setBorradores(List<Borrador> borradores) {
	// 	this.borradores = borradores;
	// }
	
	// public void addBorrador(Borrador borrador) {
    //     getBorradores().add(borrador);
    //     borrador.setEncuestado(this);
    // }
}