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
	private boolean visible;
	private int min_respuestas;
	private int max_respuestas;

	@ManyToOne							// Cardinalidad de la relacion n:1
	@JoinColumn(name = "id_empresa")	// Atributo que hace la relacion
	private Empresa empresa;			// Referencia al objeto 1
    
	@ManyToOne							// Cardinalidad de la relacion n:1
	@JoinColumn(name = "id_categoría")	// Atributo que hace la relacion
	private Categoria categoria;			// Referencia al objeto 1
	/* - - - - - - - - - - - - - - -
	 * 	Constructores
	 */

	 public Encuesta(){}

	public Encuesta(int id, String nombre, String descripcion, Date fecha_inicio, Date fecha_termino, boolean visible, int min_respuestas, int max_respuestas, Empresa empresa, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_termino = fecha_termino;
		this.visible = visible;
		this.min_respuestas = min_respuestas;
		this.max_respuestas = max_respuestas;
		this.empresa = empresa;
		this.categoria = categoria;
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
	    
}
