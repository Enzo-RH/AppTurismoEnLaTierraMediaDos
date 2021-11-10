package clases;

public class Atraccion {
	
	private String nombre;
	private Integer idAtraccion, costo, cupo;
	private double tiempo;
	private String tipo;
	
	public Atraccion(Integer idAtraccion, String nombre, Integer costo, Integer cupo, Double tiempo, String tipo) {
		this.idAtraccion = idAtraccion;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Integer getIdAtraccion() {
		return idAtraccion;
	}

	public void setIdAtraccion(Integer idAtraccion) {
		this.idAtraccion = idAtraccion;
	}

	@Override
	public String toString() {
		return "\n-\nidAtraccion= " + idAtraccion + "\nnombre= "+ nombre + "\ncosto= " + costo + "\ncupo= " + cupo
				+ "\ntiempo= " + tiempo + "\ntipo= " + tipo;
	}
	

}
