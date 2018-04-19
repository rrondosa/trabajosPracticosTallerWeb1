package ar.edu.unlam.tallerweb1.modelo;

public class Farmacia {
	private long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	private Direccion direccion;
	private Punto puntoLocalizacion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
