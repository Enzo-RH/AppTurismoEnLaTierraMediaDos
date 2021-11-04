package appMain;

import java.sql.SQLException;
import java.util.*;
import clases.Atraccion;
import clases.Promocion;
import clases.Usuario;
import dao.AtraccionDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;

public class App {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		UsuarioDAO user = new UsuarioDAO();
		PromocionDAO promo = new PromocionDAO();
		AtraccionDAO atrac = new AtraccionDAO();
		Usuario usuarioP = new Usuario();
		boolean condicion = true;

		String nombreUsuario;

		/*
		 * PRIMERO SE BUSCA AL USUARIO EN LA BD, la idea es que sea un bucle en donde si
		 * no lo encuentra, avise que es usuario inválido y lo vuelva a pedir Por el
		 * momento solo da error si no lo encuentra
		 */

		System.out.println("Bienvedo al sistema de Turismo en la Tierra Media"
				+ "\nPor favor ingrese su nombre: (Eowyn, Gandalf, Sam, Galadriel)");
		nombreUsuario = sc.nextLine();
		sc.close();

		usuarioP = user.encontrarUsuario(nombreUsuario);
		String names = usuarioP.getNombre();

		if (nombreUsuario.equalsIgnoreCase(names)) {
			
			//Si lo encuentra lo muestra por pantalla y luego le ofrece las promociones y atracciones
			System.out.println("Bienvenido\n" + usuarioP.toString());
			System.out.println("-------------\nEstas son las promociones y atracciones ");

			Iterator<Promocion> iterP = promo.mostrarPromociones().iterator();
			while (iterP.hasNext()) {
				System.out.println(iterP.next().toString());
			}

			Iterator<Atraccion> iterA = atrac.mostrarPromociones().iterator();
			while (iterA.hasNext()) {
				System.out.println(iterA.next().toString());
			}
			
			
			Iterator<Atraccion> iterDos = usuarioP.getItinerario().iterator();
			//Le pide que elija los que quiere comprar y se suman a su itinerario
			while(condicion){
				System.out.println("Ingrese el numero de la que desee comprar: (9 para salir)");
				int eleccion = sc.nextInt();
				
				switch (eleccion) {
				case 1:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 2:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 3:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 4:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 5:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 6:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 7:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 8:
					(usuarioP.getItinerario()).add(atrac.encontrarAtraccion(eleccion));
					break;
				case 9:
					condicion = false;
					break;

				default:
					System.out.println("Numero equivocado, vuelva a intentarlo");
					break;
				}
				
				//se muestra el itinerario
				while (iterDos.hasNext()) {
					System.out.println(iterDos.next().toString());
				}
			}

			
		} else {
			System.out.println("Ususario incorrecto");
		}

	}

}
