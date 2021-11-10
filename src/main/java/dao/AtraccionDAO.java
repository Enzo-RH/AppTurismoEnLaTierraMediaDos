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
	// Transforma el ResultSet en un obj Atraccion
	public Atraccion aAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getInt(3), resultados.getInt(4),
				resultados.getDouble(5), resultados.getString(6));
	}

	// Devuelve todas las atracciones
	public List<Atraccion> mostrarAtracciones() throws SQLException {
		String sql = "SELECT atraccion.idAtraccion, atraccion.nombre, atraccion.costo, atraccion.cupo, atraccion.tiempo, tipoAtraccion.nombre FROM atraccion LEFT JOIN tipoAtraccion ON atraccion.id_tipo = tipoAtraccion.idTipo";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		List<Atraccion> listaAtracciones = new LinkedList<Atraccion>();

		while (resultados.next()) {
			listaAtracciones.add(aAtraccion(resultados));
		}

		return listaAtracciones;

	}

	// Busca una atraccion segun su id y la devuelve
	public Atraccion encontrarAtraccion(Integer unNumero) throws SQLException {
		String sql = "SELECT * FROM atraccion WHERE idAtraccion = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, unNumero);
		ResultSet atraccionBD = statement.executeQuery();
		return aAtraccion(atraccionBD);
	}

	// Actualiza el tiempo y el presupuesto del usuario
	public int updateCupo() throws SQLException {
		String sql = "UPDATE atraccion SET cupo = cupo - 1";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		Integer rows = statement.executeUpdate();
		return rows;

	}
	//Devuelve una lista de atracciones de un itineratrio determinado
	public List<Atraccion> atraccionesDeItienrario(Integer idItinerario) throws SQLException {
		String sql = "SELECT atraccion.idAtraccion, atraccion.nombre, atraccion.costo, atraccion.cupo, atraccion.tiempo, tipoAtraccion.nombre FROM atraccionesEnItinerario, atraccion, tipoAtraccion" 
			+	" WHERE atraccionesEnItinerario.id_Atraccion = atraccion.idAtraccion"
			+	" AND atraccion.id_tipo = tipoAtraccion.idTipo"
			+	" AND atraccionesEnItinerario.id_Itinerario = ?;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, idItinerario);
		ResultSet resultados = statement.executeQuery();
		
		List<Atraccion> atraccionesDeItinerario = new LinkedList<Atraccion>();

		while (resultados.next()) {
			atraccionesDeItinerario.add(aAtraccion(resultados));
		}

		return atraccionesDeItinerario;

	}
	
	// Actualiza el cupo de la atraccion
		public int actualizarAtraccion(Integer idAtraccion) throws SQLException {
			String sql = "UPDATE atraccion SET cupo = cupo - 1 WHERE idAtraccion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idAtraccion);
			Integer rows = statement.executeUpdate();
			return rows;

		}
	
}
