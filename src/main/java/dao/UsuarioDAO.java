package dao;

import java.sql.*;
import clases.Usuario;
import jdbc.ConnectionProvider;

public class UsuarioDAO {
	
	public Usuario aUsuario(ResultSet resultados) throws SQLException{
		return new Usuario(resultados.getString(1), resultados.getInt(2), resultados.getDouble(3));
	}
	
	public Usuario encontrarUsuario(String nombreBuscado) throws SQLException {
		
		String sql = "SELECT * FROM usuario WHERE nombre LIKE '%" + nombreBuscado + "%'";
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
