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
				String query = "INSERT INTO `hotel_alura`.`huespedes` (`nombre`, `apellido`, `nacionalidad`, `telefono`) VALUES ('?', '?', '?', '?')";
				ps=connexion.prepareStatement(query);
				ps.setString(1, huesped.getNombre());
				ps.setString(2, huesped.getApellido());
				ps.setString(3, huesped.getNacionalidad());
				ps.setInt(4, huesped.getTelefono());
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
