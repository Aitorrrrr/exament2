package exament2;

import java.util.ArrayList;

public class Accion {

	private String nombre;
	private ArrayList<Operacion> operaciones;

	public Accion()
	{
		
	}
	
	public Accion(ArrayList<Operacion> operaciones, String nombre) {
		super();
		this.operaciones = operaciones;
		this.nombre = nombre;
	}

	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		String auxiliar = "";
		
		auxiliar = "Nombre de la acción: "+this.nombre+"\n";
		for (Operacion aux: operaciones)
		{
			auxiliar+=aux.toString()+"\n";
		}
		
		auxiliar+="\n";
		
		return auxiliar;
	}
	
	
}
