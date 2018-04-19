package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

public class Comuna {
	private long id;
	private String nombre;
	private List<Barrio> listaBarrios;
	
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
	public List<Barrio> getListaBarrios() {
		return listaBarrios;
	}
	public void setListaBarrios(List<Barrio> listaBarrios) {
		this.listaBarrios = listaBarrios;
	}
	
	
}
