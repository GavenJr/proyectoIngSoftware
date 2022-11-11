package com.teamxploitdx.proyecto_ubb.Model;
// imports de Java
import java.sql.Date;
// imports de dependencias
import javax.persistence.Entity;							// Si no pueden importar de javax,
import javax.persistence.GeneratedValue;					// les faltan dependencias en el POM
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int id_empresa;
    private int id_categoria;
    

	/* - - - - - - - - - - - - - - -
	 * 
	 * 	Getters y Setters
	 * 
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
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
    
    //@id 
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	    
	    

	
}