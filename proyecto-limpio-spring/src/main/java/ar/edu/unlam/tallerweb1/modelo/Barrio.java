package ar.edu.unlam.tallerweb1.modelo;

public class Barrio {
	private String nombre;
	private long id;
	private Comuna comuna;
	
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
