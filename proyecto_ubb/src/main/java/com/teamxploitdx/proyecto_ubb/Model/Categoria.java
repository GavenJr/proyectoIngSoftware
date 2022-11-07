package com.teamxploitdx.proyecto_ubb.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@ManyToMany(mappedBy = "preferencias")
    private List<Encuestado> encuestados;
	
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
	
	//Many to Many
	
	@JsonIgnore
    public List<Encuestado> getEncuestados() {
        if (encuestados == null) {
            encuestados = new ArrayList<>();
        }
        return encuestados;
    }

    @JsonIgnore
    public void setEmpleados(List<Encuestado> encuestados) {
        this.encuestados = encuestados;
    }

    public void addEncuestado(Encuestado encuestado) {
        getEncuestados().add(encuestado);
    }
}