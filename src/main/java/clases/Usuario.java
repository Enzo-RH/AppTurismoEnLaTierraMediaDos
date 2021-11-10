package clases;

public class Usuario {
	
	private Integer id;
	private String nombre;
	private Integer monedas;
	private Double tiempo;
	private String preferencia;
	private Itinerario itinerario;
	
	
	public Usuario(Integer id, String nombre, Integer monedas, Double tiempo, String preferencia, Itinerario itinerario) {
		this.setId(id);
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

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nMonedas: " + monedas + "\nTiempo: " + tiempo + "\nPreferencia: "
				+ preferencia + "\nItinerario: " + itinerario.toString();
	}
	
	

}
