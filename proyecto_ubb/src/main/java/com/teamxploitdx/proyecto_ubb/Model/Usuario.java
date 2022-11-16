package com.teamxploitdx.proyecto_ubb.Model;

// imports de dependencias
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase Usuario
 * idUsuario,
 * nombre,
 * apellido,
 * email,
 * Rol_idRol
 * Empresa_idEmpresa
 */

@Entity												
@Table (name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private int Rol_idRol;
    private int Empresa_idEmpresa;



    @ManyToOne							// Cardinalidad de la relacion n:1
	@JoinColumn(name = "idEmpresa")	// Atributo que hace la relacion
    private Empresa empresa;
    
    // Constructor con parametros
    public Usuario(int idUsuario, String nombre, String apellido, String email, int rol_idRol, int empresa_idEmpresa) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        Rol_idRol = rol_idRol;
        Empresa_idEmpresa = empresa_idEmpresa;
    }
    
    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
    public int getRol_idRol() {
        return Rol_idRol;
    }
    public void setRol_idRol(int rol_idRol) {
        Rol_idRol = rol_idRol;
    }
    public int getEmpresa_idEmpresa() {
        return Empresa_idEmpresa;
    }
    public void setEmpresa_idEmpresa(int empresa_idEmpresa) {
        Empresa_idEmpresa = empresa_idEmpresa;
    }
    
    // toString
    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", Rol_idRol=" + Rol_idRol + ", Empresa_idEmpresa=" + Empresa_idEmpresa + "]";
    }
}