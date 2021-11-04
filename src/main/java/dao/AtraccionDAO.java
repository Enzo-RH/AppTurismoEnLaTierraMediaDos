package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import clases.Atraccion;
import jdbc.ConnectionProvider;

public class AtraccionDAO {

	public Atraccion aAtraccion(ResultSet resultados) throws SQLException{
		return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4), resultados.getDouble(5), resultados.getString(8));
	}
	
	public List<Atraccion> mostrarPromociones() throws SQLException {
		
		String sql = "SELECT * FROM atraccion LEFT JOIN tipoAtraccion ON atraccion.id_tipo = tipoAtraccion.idTipo" ;
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		List<Atraccion> listaAtracciones = new LinkedList<Atraccion>();
		//Atraccion atraccion;
		
		if (resultados.next()) {
			listaAtracciones.add(aAtraccion(resultados));		
		}
		
		return listaAtracciones;
		
	}
}
