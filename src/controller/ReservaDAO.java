package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Huesped;
import model.Reserva;
import views.Busqueda;

public class ReservaDAO {
	
	//CREAR RESERVA	
		public static void crearReservaDB(Reserva reserva) {
			Connexion db_connexion = new Connexion();
			
			try(Connection connexion = db_connexion.get_connection()) {
				
				PreparedStatement ps=null;
				
				try {
					String query = "INSERT INTO reservas(`fecha_entrada`, `fecha_salida`, `valor`, `forma_pago`) VALUES (?, ?, ?, ?)";
					ps=connexion.prepareStatement(query);
					
					System.out.println("En clase Dao, los datos son: " + reserva.getFecha_entrada() + reserva.getFecha_salida() + reserva.getValor() + reserva.getForma_pago());
				
					ps.setDate(1, new java.sql.Date(reserva.getFecha_entrada().getTime()));
			        ps.setDate(2, new java.sql.Date(reserva.getFecha_salida().getTime()));
					ps.setDouble(3, reserva.getValor());
					ps.setString(4, reserva.getForma_pago());
					ps.executeUpdate();
					System.out.println("Nueva reserva agregada a la DB");
				} catch (SQLException ex) {
					System.out.println(ex);
				}
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("Error al guardar la reserva en la DB");
			}
			
		}
		
		//BUSCAR ID_RESERVA
		public static void buscarIdReserva() {
			Connexion db_connexion = new Connexion();
	        PreparedStatement ps=null;
	        ResultSet rs=null;
	       
			try(Connection connexion = db_connexion.get_connection()) {			
				String query = "SELECT MAX(id) AS id FROM reservas";
				ps=connexion.prepareStatement(query);
				
				// Ejecutar consulta
	            rs = ps.executeQuery(query);

	            // Obtener el último ID
	            int ultimoID = 0;
	            if (rs.next()) {
	                ultimoID = rs.getInt("id");
	            }
	            
	            Reserva reserva = new Reserva();
	            reserva.setId(ultimoID);

	            // Imprimir el último ID
	            System.out.println("El último ID autoincrementable es: " + ultimoID);

			} catch (SQLException e) {
				System.out.println("No se pudo buscar el último id de reservas");
				System.out.println(e);
			}
			
			
		}

}
