package controller;

//import java.sql.Connection;
//import model.Huesped;



public class MainTest {
	
	public static void main(String[] args) {
		
		ReservaDAO reservaDAO = new ReservaDAO();
		//reservaDAO.buscarIdReserva();
		System.out.println(reservaDAO.buscarIdReserva());
		
		/*
		 * Huesped huesped = new Huesped();
		 * 
		 * String prueba1 = huesped.getNombre(); String prueba2 = huesped.getApellido();
		 * String prueba3 = huesped.getTelefono();
		 * 
		 * System.out.
		 * println("La clase huesped contiene los siguiente valores: Nombre - " +
		 * prueba1 + "Apellido - " + prueba2 + "Telefono - " + prueba3);
		 */
		
		
	
	
	
		
	
		//Crear instancia de conexión para probar conexión inicial:
		/*
		 * Connexion conexion = new Connexion(); try(Connection cnx =
		 * conexion.get_connection()) {
		 * 
		 * } catch (Exception e) { System.out.println(e); }
		 */
	}
}
