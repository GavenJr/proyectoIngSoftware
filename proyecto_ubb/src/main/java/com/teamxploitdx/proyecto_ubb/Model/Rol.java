package com.teamxploitdx.proyecto_ubb.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class Rol {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    
    @OneToMany (mappedBy = "rol",fetch = FetchType.EAGER, cascade = CascadeType.ALL)//rol hace referencia a el nombre de la variable creada en Usuario
    @Column(nullable = true)
    @JsonManagedReference
    private List<Usuario> usuarios;
    
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

   

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void addUsuarios(Usuario usuario) {
        usuarios.add(usuario);
    }
}
