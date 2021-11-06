package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import dao.AtraccionDAO;
import clases.Atraccion;
import clases.Itinerario;
import clases.Usuario;
import jdbc.ConnectionProvider;

public class ItinerarioDAO {

	// Transforma el ResultSet en un obj Itinerario // modificar
	public Itinerario aItinerario(ResultSet resultados) throws SQLException {
		return new Itinerario(resultados.getInt(1), resultados.getInt(3), resultados.getDouble(2), null);
	}

	// Encuentra un usuario y lo devuelve
	public Itinerario encontrarItinerario(Integer usuarioId) throws SQLException {

		String sql = "SELECT * FROM itinerario WHERE id_propietario = ? ";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, usuarioId);
		ResultSet resultados = statement.executeQuery();
		Itinerario itinerario = null;
		AtraccionDAO atraccio = new AtraccionDAO();
		
		while (resultados.next()) {
			itinerario = aItinerario(resultados);
			itinerario.setAtracciones(atraccio.atraccionesDeItienrario(itinerario.getId()));
		}

		return itinerario;

	}

	 //Actualiza el tiempo y el presupuesto del itinerario
	public int updateItinerario(Atraccion unaAtraccion) throws SQLException {

		String sql = "UPDATE itinerario SET moneda = moneda + ?, tiempo = tiempo + ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, unaAtraccion.getCosto());
		statement.setDouble(2, unaAtraccion.getTiempo());
		Integer rows = statement.executeUpdate();

		return rows;

	}
	

}
