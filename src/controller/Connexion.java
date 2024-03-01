package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	public Connection get_connection(){
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_alura", "root", "nuevaKatu@Dante9");
	            //Probar conexión:
	            if(connection != null){
	                System.out.println("conexión exitosa");
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return connection;
	    }
    
}
