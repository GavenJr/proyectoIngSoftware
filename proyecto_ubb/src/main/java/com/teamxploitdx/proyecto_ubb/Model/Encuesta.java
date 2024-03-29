package com.teamxploitdx.proyecto_ubb.Model;
// imports de Java
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
// imports de dependencias
import javax.persistence.Entity;							// Si no pueden importar de javax,
import javax.persistence.GeneratedValue;					// les faltan dependencias en el POM
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity														// Indicamos que es una entidad
@Table (name = "encuesta")									// indicamos el nombre del initDB.sql
public class Encuesta {
	@Id														// El atributo deabajo es la clave primaria 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)		// Indicamos que es un valor generado
	private int id;
	private String nombre;
	private String descripcion;
	private Date fecha_inicio;
	private Date fecha_termino;
	private boolean visible;
	private int min_respuestas;
	private int max_respuestas;

	@ManyToOne							// Cardinalidad de la relacion n:1
	@JoinColumn(name = "id_empresa", referencedColumnName="ID")	// Atributo que hace la relacion
	private Empresa empresa;			// Referencia al objeto 1
   
	@ManyToOne							// Cardinalidad de la relacion n:1
	@JoinColumn(name = "id_categoria", referencedColumnName="ID")	// Atributo que hace la relacion
	private Categoria categoria;			// Referencia al objeto 1

	// **************************************
	// CODIGO QUE ROMPE EL PROYECTO
	// Cuidado, que a pesar de que las relaciones OneToMany son muy convenientes como "accesos directos"
	// a las entidades que tiene cada "padre", son PESADAS para la aplicacion, por lo que afecta al
	// performance y se relentiza si hay muchas relaciones oneToMany.
	// Esto es porque se mappean las referencias al conjunto de datos definido abajo (lista, set, etc),
	// y cada vez que se deba cargar una encuesta por ejemplo, por como funciona la API de persistencia de Java,
	// deba cargar y verificar cada registro de borradores que existen dentro de cada encuesta que hay.
	// Con esto en consideracion, muchas veces se recomienda como estrategia, evitar usar OneToMany y mejor
	// simplemente recuperar de manera manual la lista de los borradores asociados a la encuesta, para que el
	// proyecto no se quede ejecutando operaciones no deseadas.
	// Y para hacerlo peor, dado el disenyo de este sistema, ciertas "cascadas" de relaciones OneToMany
	// producen un loop en el proyecto que hace caer a la aplicacion. Por ende, quitar esta mierda del
	// proyecto es saludable para la eficiencia, sostenibilidad y mantenibilidad del programa. TOMENSE ESO, RNF BABY B)
	//
	// @OneToMany(mappedBy = "encuesta")	// Variable encuesta ubicado en Borrador
    // private Set<Borrador> borradores;
	//
	// ***************************************

	/* - - - - - - - - - - - - - - -
	 * 	Constructores
	 */

	public Encuesta(){}

	// El id no se da, pues es AUTOGENERADO
	public Encuesta(String nombre, Empresa empresa){
		this.nombre = nombre;
		this.empresa = empresa;
		this.visible = false;
	}

	public Encuesta(int id, String nombre, Empresa empresa){
		this.id = id;
		this.nombre = nombre;
		this.empresa = empresa;
		this.visible = false;
	}

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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_inicio() {
		return this.fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_termino() {
		return this.fecha_termino;
	}

	public void setFecha_termino(Date fecha_termino) {
		this.fecha_termino = fecha_termino;
	}

	public boolean isVisible() {
		return this.visible;
	}

	public boolean getVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getMin_respuestas() {
		return this.min_respuestas;
	}

	public void setMin_respuestas(int min_respuestas) {
		this.min_respuestas = min_respuestas;
	}

	public int getMax_respuestas() {
		return this.max_respuestas;
	}

	public void setMax_respuestas(int max_respuestas) {
		this.max_respuestas = max_respuestas;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// public List<Borrador> getBorradores() {
	// 	return this.borradores;
	// }

	// public void setBorradores(List<Borrador> borradores) {
	// 	this.borradores = borradores;
	// }

	    
}