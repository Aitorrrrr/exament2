package exament2;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document documento;
	private ArrayList<Accion> acciones;
	
	public Parser()
	{
		this.documento=null;
		this.acciones = new ArrayList<Accion>();
	}
	
	public void xmlADocument (String fichero)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try 
		{
			DocumentBuilder db = dbf.newDocumentBuilder();
			documento = db.parse(fichero);
		} 
		catch (ParserConfigurationException pce) 
		{
			pce.printStackTrace();
		} 
		catch (SAXException se) 
		{
			se.printStackTrace();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
	}
	
	public void parsearDocumento ()
	{
		Element eleRaiz = documento.getDocumentElement();
		
		NodeList nodosAccion = eleRaiz.getElementsByTagName("accion");
		
		if (nodosAccion!=null && nodosAccion.getLength()>0)
		{
			for (int i=0; i<nodosAccion.getLength(); i++)
			{
				Element eleAccion = (Element) nodosAccion.item(i);
				
				Accion auxiliar = getAccion(eleAccion);
				
				acciones.add(auxiliar);
			}
		}
	}
	
	public Accion getAccion(Element eleAccion)
	{
		String nombre = eleAccion.getAttribute("nombre");
		ArrayList<Operacion> operaciones = getOperaciones(eleAccion, "operaciones");
		
		Accion acc = new Accion(operaciones, nombre);
		
		return acc;
	}
	
	public ArrayList<Operacion> getOperaciones(Element eleAccion, String tag)
	{
		ArrayList<Operacion> aux = new ArrayList<Operacion>();
		
		NodeList nl = eleAccion.getElementsByTagName(tag);
		if (nl!=null && nl.getLength()>0)
		{
			Element eleOperaciones = (Element) nl.item(0);
			NodeList nodosOperacion = eleOperaciones.getElementsByTagName("operacion");
			if (nodosOperacion!=null && nodosOperacion.getLength()>0)
			{
				for (int i=0; i<nodosOperacion.getLength(); i++)
				{
					Element eleOperacion = (Element) nodosOperacion.item(i);
					
					Operacion opAux = getOperacion(eleOperacion);
					
					aux.add(opAux);
				}
			}
		}
		
		return aux;
	}
	
	public Operacion getOperacion(Element eleOperacion)
	{
		String tipo = getTexto(eleOperacion, "tipo");
		int cantidad = getInt(eleOperacion, "cantidad");
		double precio = getDouble(eleOperacion, "precio");
		
		Operacion op = new Operacion(tipo, cantidad, precio);
		
		return op;
	}
	
	public String getTexto(Element eleOperacion, String tag)
	{
		String aux = null;
		NodeList nl = eleOperacion.getElementsByTagName(tag);
		
		if (nl!=null && nl.getLength()>0)
		{
			Element elemento = (Element) nl.item(0);
			
			aux = elemento.getFirstChild().getNodeValue();
		}
		
		return aux;
	}
	
	public int getInt(Element eleOperacion, String tag)
	{
		int aux;
		
		aux = Integer.parseInt(getTexto(eleOperacion,tag));
		
		return aux;
	}
	
	public double getDouble(Element eleOperacion, String tag)
	{
		double aux;
		
		aux = Double.parseDouble(getTexto(eleOperacion, tag));
		
		return aux;
	}
	
	public void mostrarAcciones()
	{
		for (Accion aux: acciones)
		{
			System.out.println(aux.toString());
		}
	}
}
