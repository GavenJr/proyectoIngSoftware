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
 * Clase Rol
 * idRol,
 * nombre,
 */

@Entity												
@Table (name = "rol")

public class Rol {

    // Atributos
        @Id
        int id;
        String nombre;

        @ManyToOne
        @JoinColumn(name = "id")
        Usuario usuario;

        // Constructor con parametros idRol
        public Rol(int idRol, String nombre) { 
            this.id = idRol;
            this.nombre = nombre;
        }

        // Getters y Setters
        public int getIdRol() {
            return id;
        }
        public void setIdRol(int idRol) {
            this.id = idRol;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

    
}
