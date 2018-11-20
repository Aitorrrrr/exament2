package exament2;

public class Principal {

	public static void main(String[] args) {
		Parser parseador = new Parser();
		parseador.xmlADocument("asdf.xml");
		parseador.parsearDocumento();
		parseador.mostrarAcciones();
	}

}
