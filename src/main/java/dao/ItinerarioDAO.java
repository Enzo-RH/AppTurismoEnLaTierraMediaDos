package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clases.Atraccion;
import clases.Itinerario;
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
		AtraccionDAO atraccionDAO = new AtraccionDAO();

		while (resultados.next()) {
			itinerario = aItinerario(resultados);
			itinerario.setAtracciones(atraccionDAO.atraccionesDeItienrario(itinerario.getId()));
		}

		return itinerario;

	}

	// Actualiza el tiempo y el presupuesto del itinerario
	public int actualizarItinerario(Integer costoAtraccion, Double tiempoAtraccion, Integer idItinerario) throws SQLException {
		String sql = "UPDATE itinerario SET costoTotal = costoTotal + ?, tiempoTotal = tiempoTotal + ? WHERE idItinerario = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, costoAtraccion);
		statement.setDouble(2, tiempoAtraccion);
		statement.setInt(3, idItinerario);
		Integer rows = statement.executeUpdate();
		return rows;

	}

	// Agrega una atraccion al itinerario
	public int agregarAtraccion(Integer idItinerario, Integer idAtraccion) throws SQLException {
		String sql = "INSERT INTO atraccionesEnIitinerario VALUES(?,?);";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, idItinerario);
		statement.setInt(2, idAtraccion);
		Integer rows = statement.executeUpdate();
		return rows;

	}

}
