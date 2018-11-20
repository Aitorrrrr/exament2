package exament2;

public class Operacion {

	private String tipo;
	private int cantidad;
	private double precio;
	
	public Operacion()
	{
		
	}
	
	public Operacion(String tipo, int cantidad, double precio) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Operacion [tipo=" + tipo + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
}
