package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Usuario;
import jdbc.ConnectionProvider;

public class ItinerarioDAO {

	
	// Transforma el ResultSet en un obj Itinerario // modificar
		public Itinerario aItinerario(ResultSet resultados) throws SQLException {
			return new Usuario(resultados.getInt(3), resultados.getDouble(2),
					resultados.getString(7), null);
		}

		// Encuentra un usuario y lo devuelve
		public Itinerario encontrarItinerario(Integer usuarioId) throws SQLException {

			String sql = "SELECT * FROM itinerario RIGTH JOIN atraccionEnItinerario ON usuario.id_tipo = tipoAtraccion.idTipo WHERE usuario.nombre = ? ";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombreBuscado);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = null;

			while(resultados.next()) {
				usuario = aItinerario(resultados);
			}

			return usuario;

		}

		// Actualiza el tiempo y el presupuesto del usuario
		public int updateUsuario(Usuario unUsuario) throws SQLException {

			String sql = "UPDATE usuario SET moneda = moneda - ?, tiempo = tiempo - ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, unUsuario.getMonedas());
			statement.setDouble(2, unUsuario.getTiempo());
			Integer rows = statement.executeUpdate();
			
			return rows;

		}
}
