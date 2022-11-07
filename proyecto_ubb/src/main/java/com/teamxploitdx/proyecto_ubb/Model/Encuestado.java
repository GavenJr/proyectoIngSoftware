package com.teamxploitdx.proyecto_ubb.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


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
	 
}