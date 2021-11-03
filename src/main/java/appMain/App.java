package appMain;

import java.sql.SQLException;
import java.util.*;

import clases.Usuario;
import dao.UsuarioDAO;

public class App {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner (System.in);
		UsuarioDAO user = new UsuarioDAO();
		Usuario usuarioP = new Usuario();
		String nombreUsuario;
		
		/*PRIMERO SE BUSCA AL USUARIO EN LA BD, la idea es que sea un bucle en donde si no lo encuentra, avise que es usuario inválido y lo vuelva a pedir
		Por el momento solo da error si no lo encuentra*/
		
		System.out.println("Bienvedo al sistema de Turismo en la Tierra Media" 
			+"\nPor favor ingrese su nombre: (Eowyn, Gandalf, Sam, Galadriel)");
		nombreUsuario = sc.nextLine();
		sc.close();
		
		usuarioP = user.encontrarUsuario(nombreUsuario);
		String names = usuarioP.getNombre();
		
		if(nombreUsuario.equalsIgnoreCase(names)){
			System.out.println("Bienvenido\n" + usuarioP.toString());
			System.out.println("-------------\nEstas son las ofertas de hoy: ");
			
		}else {
			System.out.println("Ususario incorrecto");
		}
		
		

	}

}
