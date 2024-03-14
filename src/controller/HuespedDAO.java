package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Huesped;
import views.Busqueda;

public class HuespedDAO {
	
//CREAR HUESPED	
	public static void crearHuespedDB(Huesped huesped) {
		Connexion db_connexion = new Connexion();
		
		try(Connection connexion = db_connexion.get_connection()) {
			
			PreparedStatement ps=null;
			
			try {
				String query = "INSERT INTO tb_huespedes(`nombre`, `apellido`, `fecha_de_nacimiento`, `nacionalidad`, `telefono`, `id_reserva`) VALUES ('?', '?', '?', '?', '?', ?)";
				ps=connexion.prepareStatement(query);
				
				
				  System.out.println("En clase Dao, los datos son: "); 
				  huesped.getNombre(); 
				  huesped.getApellido(); 
				  huesped.getFecha_de_nacimiento(); 
				  huesped.getNacionalidad();
				  huesped.getTelefono();
				  huesped.getId_reserva();
				  
				  ps.setString(1, huesped.getNombre()); 
				  ps.setString(2, huesped.getApellido());
				  ps.setDate(3, new java.sql.Date(huesped.getFecha_de_nacimiento().getTime()));
				  ps.setString(4, huesped.getNacionalidad()); 
				  ps.setString(5,huesped.getTelefono()); 
				  ps.setInt(6, huesped.getId());
				 
				ps.executeUpdate();
				System.out.println("Nuevo huesped agregado");
			} catch (SQLException ex) {
				System.out.println(ex);
				System.out.println("No se logró ingresar el huesped");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
//BUSCAR HUESPED	
	public static void buscarHuespedDB(String apellido_buscar) {
		//System.out.println("El apellido a buscar es: " + apellido_buscar);
        
		//Obtener la lista de objetos Huesped
		List<Huesped> lista_huespedes = new ArrayList<>(); 
		
		
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
				huesped.setId(rs.getInt("id"));
				huesped.setNombre(rs.getString("nombre"));
				huesped.setApellido(rs.getString("apellido"));
				huesped.setTelefono(rs.getString("telefono"));
				
				lista_huespedes.add(huesped);
				
				
				//System.out.println("El nombre del huesped es: " + rs.getString("nombre"));
				//huesped.setNombre(rs.getString("nombre"));
				//System.out.println("El apellido del huesped es: " + rs.getString("apellido"));
				//huesped.setApellido(rs.getString("apellido"));
				//System.out.println("El telefono del huesped es: " + rs.getString("telefono"));
				//huesped.setTelefono(rs.getString("telefono"));
				//System.out.println("ID: " + rs.getInt("id"));
				//huesped.setId(rs.getInt("id"));
				
				//System.out.println("ID: " + huesped.getId());
				//System.out.println("Nombre: " + huesped.getNombre());
				//System.out.println("Apellido: " + huesped.getApellido());
				//System.out.println("Telefono: " + huesped.getTelefono());
			}
			
			Busqueda busqueda = new Busqueda();
			busqueda.cargarHuespedTabla(lista_huespedes);
			System.out.println("La lista en HuespedDAO: " + lista_huespedes);
			
		} catch (SQLException e) {
			System.out.println("No se pudieron buscar los huespedes");
			System.out.println(e);
		}
		
		
	}

}
