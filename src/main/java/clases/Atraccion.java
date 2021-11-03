package clases;

public class Atraccion {
	
	private String nombre;
	private Integer costo, cupo;
	private double tiempo;
	private TipoAtraccion tipo;
	
	public Atraccion(String nombre, Integer costo, Integer cupo, Double tiempo, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.cupo = cupo;
		this.tiempo = tiempo;
		this.tipo = tipo;
	}

	public Atraccion() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", costo: " + costo + ", cupo: " + cupo + ", tiempo: " + tiempo + ", tipo: "
				+ tipo;
	}
	
	

}
