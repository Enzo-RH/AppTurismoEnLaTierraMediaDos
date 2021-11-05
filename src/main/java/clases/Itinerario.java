package clases;

import java.util.List;

public class Itinerario {

	private Integer costoTotal;
	private Double tiempoTotal;
	private List<Atraccion> atracciones;

	public Itinerario(Integer costoTotal, Double tiempoTotal, List<Atraccion> atracciones) {
		this.costoTotal = costoTotal;
		this.tiempoTotal = tiempoTotal;
		this.atracciones = atracciones;
	}

	public Itinerario() {
	}

	public Integer getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Integer costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Double getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(Double tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	@Override
	public String toString() {
		return "Itinerario [costoTotal=" + costoTotal + ", tiempoTotal=" + tiempoTotal + ", atracciones=" + atracciones;
	}

}
