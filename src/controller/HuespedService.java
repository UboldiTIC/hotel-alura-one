package controller;

import model.Huesped;

public class HuespedService {
	
	private HuespedDAO huespedDAO;
	
	public HuespedService() {
		this.huespedDAO = new HuespedDAO();
	}
	
	public void guardarHuesped(String name, String surname, String phone) {
		//faltan los parámetros en la instancia.
		Huesped huesped = new Huesped();
		huesped.setNombre(name);
		huesped.setApellido(surname);
		huesped.setTelefono(phone);
		huespedDAO.crearHuespedDB(huesped);
		
	}

}
