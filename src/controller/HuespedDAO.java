package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Huesped;

public class HuespedDAO {
	
	public static void crearHuespedDB(Huesped huesped) {
		Connexion db_connexion = new Connexion();
		
		try(Connection connexion = db_connexion.get_connection()) {
			
			PreparedStatement ps=null;
			
			try {
				String query = "INSERT INTO huespedes(`nombre`, `apellido`, `telefono`) VALUES ('Valeria', 'Rios', '558782')";
				ps=connexion.prepareStatement(query);
				/*
				 * ps.setString(0, huesped.getNombre()); ps.setString(1, huesped.getApellido());
				 * //ps.setString(3, huesped.getNacionalidad()); ps.setString(2,
				 * huesped.getTelefono());
				 */
				ps.executeUpdate();
				System.err.println("Nuevo huesped agregado");
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
