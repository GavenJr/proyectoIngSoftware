package com.teamxploitdx.proyecto_ubb.Model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
// imports de dependencias
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity														// Indicamos que es una entidad
@Table (name = "empresa")									// indicamos el nombre del initDB.sql
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    String email;
    String descripcion;

	// **************************************
	// CODIGO QUE ROMPE EL PROYECTO
    // 	REVISA LA CLASE "Encuesta" PARA UNA EXPLICACION
	//
    // @OneToMany (mappedBy = "empresa",fetch = FetchType.EAGER, cascade = CascadeType.ALL) //empresa hace referencia a el nombre de la variable creada en Usuario
    // @Column(nullable = true)
    // private Set<Usuario> usuarios;
    //
    // ***************************************

    // public List<Usuario> getUsuarios() {
    //     return usuarios;
    // }

    // public void setUsuarios(Usuario usuario) {
    //     usuarios.add(usuario);
    // }
   
    /* - - - - - - - - - - - - - - -
	* 	Constructores
	*/

    public Empresa(){}

    public Empresa(int id, String nombre, String email, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.descripcion = descripcion;
    }

    /* - - - - - - - - - - - - - - -
	* 	Getters y Setters
	*/
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
