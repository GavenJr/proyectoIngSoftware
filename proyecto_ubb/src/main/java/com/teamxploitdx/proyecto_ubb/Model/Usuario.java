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
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    //cambiar Rol_idRol por relacion por Rol
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;


    @ManyToOne							// Cardinalidad de la relacion n:1
	@JoinColumn(name = "id_empresa")	// Atributo que hace la relacion
    private Empresa empresa;

    //JSON example
    /*
        {
        "nombre": "Juan",
        "apellido": "Perez",
        "email": "Juan@gmail.com",
        "rol": {
            "id": 1,
            "nombre": "Administrador"
        },
        "empresa": {
            "id": 1
        }
    }

     */
    
    // Constructor con parametros
    public Usuario(int idUsuario, String nombre, String apellido, String email) { 
        this.id = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Usuario(int idUsuario, String nombre, String apellido, String email, Rol rol, Empresa empresa) { 
        this.id = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
        this.empresa = empresa;
    }

    //constructor vacio
    public Usuario() {
    }


    
    // Getters y Setters
    public int getIdUsuario() {
        return id;
    }
    public void setIdUsuario(int idUsuario) {
        this.id = idUsuario;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    // toString
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", rol=" + rol + "]";
    }
}