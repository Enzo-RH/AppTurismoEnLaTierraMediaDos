package dao;

import java.sql.*;
import clases.Usuario;
import jdbc.ConnectionProvider;

public class UsuarioDAO {
	
	public Usuario aUsuario(ResultSet resultados) throws SQLException{
		return new Usuario(resultados.getString(2), resultados.getInt(3), resultados.getDouble(4));
	}
	
	public Usuario encontrarUsuario(String nombreBuscado) throws SQLException {
		
		String sql = "SELECT * FROM usuario WHERE nombre = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nombreBuscado);
		ResultSet resultados = statement.executeQuery();
		
		Usuario usuario = null;
		
		if (resultados.next()) {
			usuario = aUsuario(resultados);
		}
		
		return usuario;
		
	}

}
