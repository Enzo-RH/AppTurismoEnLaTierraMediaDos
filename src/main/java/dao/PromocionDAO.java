package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import clases.Promocion;
import jdbc.ConnectionProvider;

public class PromocionDAO {
	
	public Promocion aPromocion(ResultSet resultados) throws SQLException{
		return new Promocion(resultados.getString(2), resultados.getDouble(3), resultados.getInt(4), resultados.getString(8), null);
	}
	
	public List<Promocion> mostrarPromociones() throws SQLException {
		
		String sql = "SELECT * FROM promocion LEFT JOIN tipoAtraccion ON promocion.id_tipo = tipoAtraccion.idTipo" ;
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		List<Promocion> listaPromociones = new LinkedList<Promocion>();
		Promocion promos;
		
		if (resultados.next()) {
			promos = aPromocion(resultados);
			listaPromociones.add(promos);
			
		}
		
		return listaPromociones;
		
	}
}

