package clases;

import java.util.*;

public class Promocion {
	
	private String nombre;
	private Double tiempo;
	private Integer costo;
	private String tipo;
	private List<Atraccion> atracciones;
	
	
	public Promocion(String nombre, Double tiempo, Integer costo, String tipo, List<Atraccion> atracciones) {
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.costo = costo;
		this.tipo = tipo;
		this.atracciones = atracciones;
	}
	
	public Promocion() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	@Override
	public String toString() {
		return "Promocion nombre: " + nombre + ", tiempo: " + tiempo + ", costo: " + costo + ", tipo: " + tipo
				+ ", atracciones: " + atracciones;
	}
	
	

}
