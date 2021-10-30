package clases;

import java.util.List;

public class Usuario {
	
	private String nombre;
	private Integer monedas;
	private Double tiempo;
	private TipoAtraccion preferencia;
	private List<Atraccion> itinerario;
	
	private aceptarItinerario(List<Atraccion> unItinerario) {
		
	}
	
	
	public Usuario(String nombre, Integer monedas, Double tiempo, TipoAtraccion preferencia, List<Atraccion> itinerario) {
		this.setNombre(nombre);
		this.setMonedas(monedas);
		this.setTiempo(tiempo);
		this.setPreferencia(preferencia);
		this.itinerario = itinerario;
	}
	public Usuario(String nombre, Integer monedas, Double tiempo) {
		this.setNombre(nombre);
		this.setMonedas(monedas);
		this.setTiempo(tiempo);
	}

	public Usuario() {

	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMonedas() {
		return monedas;
	}

	public void setMonedas(Integer monedas) {
		this.monedas = monedas;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}

	public TipoAtraccion getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
	}

	public List<Atraccion> getItinerario() {
		return itinerario;
	}

	public void setItinerario(List<Atraccion> itinerario) {
		this.itinerario = itinerario;
	}

	@Override
	public String toString() {
		return "Usuario nombre: " + nombre + ", monedas: " + monedas + ", tiempo " + tiempo + ", preferencia "
				+ preferencia + ", itinerario " + itinerario;
	}
	
	

}
