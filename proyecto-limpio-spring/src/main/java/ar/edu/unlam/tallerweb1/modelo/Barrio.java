package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Barrio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	@ManyToOne
	private Comuna comuna;
	@OneToMany
	private List<Direccion> listaDirecciones;

	public Barrio() {
	}

	public Barrio(String nombre, Comuna comuna, List<Direccion> listaDirecciones) {
		this.nombre = nombre;
		this.comuna = comuna;
		this.listaDirecciones = listaDirecciones;
	}

	public List<Direccion> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	public Barrio(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
}
