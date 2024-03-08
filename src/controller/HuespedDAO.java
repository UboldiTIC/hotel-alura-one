package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Huesped;

public class HuespedDAO {
	
	public static void crearHuespedDB(Huesped huesped) {
		Connexion db_connexion = new Connexion();
		
		try(Connection connexion = db_connexion.get_connection()) {
			
			PreparedStatement ps=null;
			
			try {
				String query = "INSERT INTO huespedes(`nombre`, `apellido`, `telefono`) VALUES (?, ?, ?)";
				ps=connexion.prepareStatement(query);
				
				System.out.println("En clase Dao, los datos son: " + huesped.getNombre() + huesped.getApellido() + huesped.getTelefono());
			
				ps.setString(1, huesped.getNombre());
				ps.setString(2, huesped.getApellido());
				  //ps.setString(3, huesped.getNacionalidad()); 
				ps.setString(3, huesped.getTelefono()); 
				ps.executeUpdate();
				System.out.println("Nuevo huesped agregado");
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	public static void buscarHuespedDB(String apellido_buscar) {
		System.out.println("El apellido a buscar es: " + apellido_buscar);
        Connexion db_connexion = new Connexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        
		try(Connection connexion = db_connexion.get_connection()) {
			
			//Editar SQL para buscar por apellido. 
			String query = "INSERT INTO huespedes(`nombre`, `apellido`, `telefono`) VALUES (?, ?, ?)";
			ps=connexion.prepareStatement(query);
			
			//System.out.println("ID: " + getInt("id"));
			System.out.println("El nombre del huesped es: " + rs.getString("nombre"));
			System.out.println("El apellido del huesped es: " + rs.getString("apellido"));
			System.out.println("El telefono del huesped es: " + rs.getString("telefono"));
			
		} catch (SQLException e) {
			System.out.println("No se pudieron buscar los huespedes");
			System.out.println(e);
		}
		
	}

}
