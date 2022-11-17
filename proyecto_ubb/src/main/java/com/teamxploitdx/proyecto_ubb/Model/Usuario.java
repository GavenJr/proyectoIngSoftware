package com.teamxploitdx.proyecto_ubb.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;


@Entity
public class Usuario {
    /**
     *
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    @ManyToOne 
    @JsonBackReference
    @JoinColumn (name = "id_empresa", referencedColumnName = "id")
    private Empresa empresa;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    private Rol rol;

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa2) {
        this.empresa = empresa2;
    }
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
    
}