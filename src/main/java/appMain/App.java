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
			
			

			switch (eleccion) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;

			default:
				break;
			}

		} else {
			System.out.println("Ususario incorrecto");
		}

	}

}
