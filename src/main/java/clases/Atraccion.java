package clases;

public class Atraccion {
	
	private String nombre;
	private int costo, cupo;
	private double tiempo;
	private TipoAtraccion tipo;
	
	public Atraccion(String nombre, int costo, int cupo, double tiempo, TipoAtraccion tipo) {
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
	
	
	
	
	
	

}
