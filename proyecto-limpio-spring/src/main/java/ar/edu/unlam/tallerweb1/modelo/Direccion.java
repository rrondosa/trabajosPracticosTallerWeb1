package ar.edu.unlam.tallerweb1.modelo;

public class Direccion {
	private long id;
	private String calle;
	private String numero;
	private Barrio barrio;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
}	
