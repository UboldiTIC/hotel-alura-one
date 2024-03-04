package model;

public class Reserva {
	
	int id;
	String fecha_entrada;
	String fecha_salida;
	double valor;
	String forma_pago;
	
	public Reserva() {
	}
	
	public Reserva(int id, String fecha_entrada, String fecha_salida, double valor, String forma_pago) {
		this.id = id;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.valor = valor;
		this.forma_pago = forma_pago;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public String getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getForma_pago() {
		return forma_pago;
	}
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
	
}
