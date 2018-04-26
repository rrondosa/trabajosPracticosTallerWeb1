package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Farmacia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	@ManyToOne
	private Direccion direccion;
	@ManyToOne
	private Punto puntoLocalizacion;

	public Farmacia() {
	}

	public Farmacia(String nombre, String telefono, String diaDeTurno, Direccion direccion, Punto puntoLocalizacion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.diaDeTurno = diaDeTurno;
		this.direccion = direccion;
		this.puntoLocalizacion = puntoLocalizacion;
	}

	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDiaDeTurno() {
		return diaDeTurno;
	}

	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Punto getPuntoLocalizacion() {
		return puntoLocalizacion;
	}

	public void setPuntoLocalizacion(Punto puntoLocalizacion) {
		this.puntoLocalizacion = puntoLocalizacion;
	}

}
