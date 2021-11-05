package dao;

import java.sql.*;
import clases.Usuario;
import jdbc.ConnectionProvider;

public class UsuarioDAO {
	// Transforma el ResultSet en un obj Usuario
	public Usuario aUsuario(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getString(2), resultados.getInt(3), resultados.getDouble(4),
				resultados.getString(7), null);
	}

	// Encuentra un usuario y lo devuelve
	public Usuario encontrarUsuario(String nombreBuscado) throws SQLException {

		String sql = "SELECT * FROM usuario LEFT JOIN tipoAtraccion ON usuario.id_tipo = tipoAtraccion.idTipo WHERE usuario.nombre = ? ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nombreBuscado);
		ResultSet resultados = statement.executeQuery();

		Usuario usuario = null;

		while(resultados.next()) {
			usuario = aUsuario(resultados);
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
