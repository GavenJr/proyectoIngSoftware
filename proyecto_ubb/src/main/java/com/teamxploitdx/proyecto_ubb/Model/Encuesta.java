package com.teamxploitdx.proyecto_ubb.Model;
// imports de Java
import java.sql.Date;
// imports de dependencias
import javax.persistence.Entity;							// Si no pueden importar de javax,
import javax.persistence.GeneratedValue;					// les faltan dependencias en el POM
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity														// Indicamos que es una entidad
@Table (name = "encuesta")									// indicamos el nombre del initDB.sql
public class Encuesta {
	@Id														// El atributo deabajo es la clave primaria 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// Indicamos que es un valor generado 
    private int id;

	private String nombre;
	private String descripcion ;
    private Date fecha_inicio;
	private Date fecha_termino;
    private int min,max;
    private boolean visibilidad;

    //private int id_empresa;			//basura
    //private int id_categoria;			//basura

	@ManyToOne							// Cardinalidad de la relacion n:1
	@JoinColumn(name = "id_empresa")	// Atributo que hace la relacion
	private Empresa empresa;			// Referencia al objeto 1
    
	/* - - - - - - - - - - - - - - -
	 * 	Constructores
	 */
	public Encuesta(){}

	public Encuesta(int id, String nombre, String descripcion, Date fecha_inicio, Date fecha_termino, int min, int max, boolean visibilidad, int id_empresa, int id_categoria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_termino = fecha_termino;
		this.min = min;
		this.max = max;
		this.visibilidad = visibilidad;
	}


	/* - - - - - - - - - - - - - - -
	 * 	Getters y Setters
	 */
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_termino() {
		return fecha_termino;
	}
	public void setFecha_termino(Date fecha_termino) {
		this.fecha_termino = fecha_termino;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
		}
	public void setMax(int max) {
		this.max = max;
	}
	public boolean isVisibilidad() {
		return visibilidad;
	}
	public void setVisibilidad(boolean visibilidad) {
		this.visibilidad = visibilidad;
	}
	    

	
}
