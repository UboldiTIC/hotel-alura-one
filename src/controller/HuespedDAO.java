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
			
//Agregar los otros datos una vez agregados en la DB.
			String query = "SELECT * FROM huespedes WHERE apellido = ?";
			ps=connexion.prepareStatement(query);
			ps.setString(1, apellido_buscar);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Huesped huesped = new Huesped();
				//System.out.println("El nombre del huesped es: " + rs.getString("nombre"));
				huesped.setNombre(rs.getString("nombre"));
				//System.out.println("El apellido del huesped es: " + rs.getString("apellido"));
				huesped.setApellido(rs.getString("apellido"));
				//System.out.println("El telefono del huesped es: " + rs.getString("telefono"));
				huesped.setTelefono(rs.getString("telefono"));
				//System.out.println("ID: " + rs.getInt("id"));
				huesped.setId(rs.getInt("id"));
				
				System.out.println("ID: " + huesped.getId());
				System.out.println("Nombre: " + huesped.getNombre());
				System.out.println("Apellido: " + huesped.getApellido());
				System.out.println("Telefono: " + huesped.getTelefono());
			}
			
		} catch (SQLException e) {
			System.out.println("No se pudieron buscar los huespedes");
			System.out.println(e);
		}
		
	}

}
