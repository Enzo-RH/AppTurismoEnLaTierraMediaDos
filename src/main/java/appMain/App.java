package appMain;

import java.nio.file.attribute.UserPrincipal;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import clases.*;
import dao.AtraccionDAO;
import dao.ItinerarioDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;

public class App {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		UsuarioDAO user = new UsuarioDAO();
		PromocionDAO promo = new PromocionDAO();
		AtraccionDAO atrac = new AtraccionDAO();
		ItinerarioDAO itiner = new ItinerarioDAO();
		Usuario usuarioP = new Usuario();
		Itinerario itinerP = new Itinerario();
		Atraccion atracP = new Atraccion();

		usuarioP.setItinerario(null);
		boolean condicion = true;

		String nombreUsuario;

		/*
		 * PRIMERO SE BUSCA AL USUARIO EN LA BD, la idea es que sea un bucle en donde si
		 * no lo encuentra, avise que es usuario inv?lido y lo vuelva a pedir Por el
		 * momento solo da error si no lo encuentra
		 */

		System.out.println("Bienvedo al sistema de Turismo en la Tierra Media"
				+ "\nPor favor ingrese su nombre: (Eowyn, Gandalf, Sam, Galadriel)");
		nombreUsuario = sc.nextLine();

		usuarioP = user.encontrarUsuario(nombreUsuario);
		itinerP = usuarioP.getItinerario();
		String names = usuarioP.getNombre();
		Integer eleccion;

		if (nombreUsuario.equalsIgnoreCase(names)) {

			// Si lo encuentra lo muestra por pantalla y luego le ofrece las promociones y
			// atracciones
			System.out.println("BIENVENIDO\nINFORMACION DE USUARIO:\n" + usuarioP.toString());
			System.out.println("-------------\n-Promociones disponibles-\n");

			Iterator<Promocion> iterP = promo.mostrarPromociones().iterator();
			while (iterP.hasNext()) {
				System.out.println(iterP.next().toString() + "\n-");
			}

			System.out.println("--------------\n-Atracciones disponibles-\n");

			Iterator<Atraccion> iterA = atrac.mostrarAtracciones().iterator();
			while (iterA.hasNext()) {
				System.out.println(iterA.next().toString());
			}

			// Le pide que elija los que quiere comprar y se suman a su itinerario
			while (condicion) {
				System.out.println("Ingrese el id de la atraccion que desee comprar: 0 para salir");
				eleccion = sc.nextInt();

				if (eleccion == 0) {

					System.out.println("Gracias por utilizar nuestros servicios");
					condicion = false;

				} else if ((eleccion < 1) || (eleccion > (atrac.mostrarAtracciones().size()))) {

					System.out.println("El numero ingresado es incorrecto");

				} else if ((itinerP.getAtracciones().get(0).getIdAtraccion())
						.equals(atrac.encontrarAtraccion(eleccion).getIdAtraccion())) {

					System.out.println("Esta atracci?n ya forma parte de su itinerario");

				} else if ((atrac.encontrarAtraccion(eleccion).getCosto() > usuarioP.getMonedas())
						|| (atrac.encontrarAtraccion(eleccion).getTiempo() > usuarioP.getTiempo())
						|| (atrac.encontrarAtraccion(eleccion).getCupo() > 0)) {

					System.out.println("No dispone del presupuesto o tiempo necesario");

				} else {

					usuarioP.getItinerario().getAtracciones().add(atrac.encontrarAtraccion(eleccion));
					user.actualizarUsuario(usuarioP.getId(), atrac.encontrarAtraccion(eleccion).getCosto(),
							atrac.encontrarAtraccion(eleccion).getTiempo()); //Se actualiza el usuario
					itiner.actualizarItinerario(atrac.encontrarAtraccion(eleccion).getCosto(), atrac.encontrarAtraccion(eleccion).getTiempo(), usuarioP.getId()); //Se actualiza el itinerario
					atrac.actualizarAtraccion(eleccion); //Se actualiza la atracci?n
					System.out.println("Atracci?n agregada exitosamente");
				}

				usuarioP.toString();
			}

		} else

		{
			// Esto no funciona porque primero larga la SQLException
			System.out.println("Ususario incorrecto");
		}

	}

}
