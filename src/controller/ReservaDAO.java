package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Reserva;

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
				
					//ps.setInt(1, reserva.getId());
					ps.setString(1, reserva.getFecha_entrada());
					ps.setString(2, reserva.getFecha_salida()); 
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

}
