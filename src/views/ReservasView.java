package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Date;
//import java.sql.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.HuespedDAO;
import controller.ReservaDAO;
import model.Huesped;
import model.Reserva;


@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;
	
	double valorTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservasView() {
		super("Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Código que crea los elementos de la interfáz gráfica
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 187, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setBounds(109, 60, 219, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));
		
		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);

//BOTON SALIR:		
		// Componentes para dejar la interfaz con estilo Material Design
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);

//BOTON ATRAS		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);
		
		
		//Campos que guardaremos en la base de datos
//FECHA ENTRADA:		
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 161, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtFechaEntrada);

//FECHA SALIDA:
		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 246, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		
//VALOR:		
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				//Activa el evento, después del usuario seleccionar las fechas se debe calcular el valor de la reserva
				
				// Si la propiedad "date" cambia en uno de los campos de fecha, calcular el valor total
			    if ("date".equals(evt.getPropertyName()) && (evt.getSource() == txtFechaEntrada || evt.getSource() == txtFechaSalida)) {
			        calcularValorTotal();
			    }	
			}
			
			private void calcularValorTotal() {
			    // Obtener las fechas y calcular la diferencia de días
			    Date fecha_entrada = (Date) txtFechaEntrada.getDate();
			    Date fecha_salida = (Date) txtFechaSalida.getDate();
			    
			    System.out.println("Datos para calcular días: " + fecha_entrada + fecha_salida);
			    
			    long diferenciaDias = (fecha_salida.getTime() - fecha_entrada.getTime()) / (1000 * 60 * 60 * 24);
			    
			    System.out.println("Son: " + diferenciaDias + " dias de vacaciones");

			    // Multiplicar la diferencia de días por el valor fijo y mostrar el resultado
			    //double valorTotal = diferenciaDias * 65.00;
			    valorTotal = diferenciaDias * 65.25;
			    //txtValor.setText(String.format("%.2f", valorTotal));
			    
			    System.out.println("El valor total es: " + valorTotal);
			    
			    txtValor = new JTextField();
				txtValor.setBackground(SystemColor.text);
				txtValor.setHorizontalAlignment(SwingConstants.CENTER);
				txtValor.setForeground(Color.BLACK);
				txtValor.setBounds(78, 328, 43, 33);
				txtValor.setEditable(false);
				txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
				txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				panel.add(txtValor);
				txtValor.setColumns(10);
//Error -> Muestra con error de formato el precio: txtValor. Revisar String.format				
				txtValor.setText(String.format("%.2f", valorTotal));
				//txtValor.setText(String.format("%d.2f", valorTotal));
			}
			
		});
		
//Muestra el valor de la variable global, carga antes de asignar. Sólo tiene valor dentro del método.
//Así funciona todo menos mostrar el valor completo en el campo txtValor: xx0.50
System.out.println("El valor total de la variable global es: " + valorTotal);
		
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtFechaSalida);
		
		/*
		 * //VALOR: Debe mostrarlo en el campo y debe enviarlo a la DB cuando se
		 * presiona Siguiente. txtValor = new JTextField();
		 * txtValor.setBackground(SystemColor.text);
		 * txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		 * txtValor.setForeground(Color.BLACK); txtValor.setBounds(78, 328, 43, 33);
		 * txtValor.setEditable(false); txtValor.setFont(new Font("Roboto Black",
		 * Font.BOLD, 17));
		 * txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		 * panel.add(txtValor); txtValor.setColumns(10);
		 * 
		 * //ver cómo viene de siguiente, creo que estoy dando formato dos veces
		 * txtValor.setText(String.format("%.2f", valorTotal));
		 */

//FORMA DE PAGO
		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
		panel.add(txtFormaPago);

		
//BOTON SIGUIENTE:		
		JPanel btnsiguiente = new JPanel();
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtFechaEntrada.getDate() != null && ReservasView.txtFechaSalida.getDate() != null) {		
					RegistroHuesped registro = new RegistroHuesped();
					registro.setVisible(true);
					
					//Lee los datos ingresados:
					Date fecha_entrada = (Date) txtFechaEntrada.getDate();
					Date fecha_salida = (Date) txtFechaSalida.getDate();
					Double valor = valorTotal;
					String forma_pago = txtFormaPago.getSelectedItem().toString();
					System.out.printf("La fecha de entrada es: " + fecha_entrada + ". La fecha de salida es: " + fecha_salida + ". El valor a pagar es:  " + valor + ". El medio de pago es: " + forma_pago);
					
					
					//Envía los datos al modelo
					Reserva reserva = new Reserva();
					reserva.setFecha_entrada(fecha_entrada);
					reserva.setFecha_salida(fecha_salida);
					reserva.setValor(valor);
					reserva.setForma_pago(forma_pago);
					System.out.println(" ");
					System.out.println("Los datos son: " + reserva.getFecha_entrada() + reserva.getFecha_salida() + reserva.getValor() + reserva.getForma_pago());
					
					//Llama a la clase DAO y los carga en la DB
					ReservaDAO reservaDAO = new ReservaDAO();
					reservaDAO.crearReservaDB(reserva);
			
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}						
		});
		btnsiguiente.setLayout(null);
		
		//btnsiguiente.setBackground(SystemColor.textHighlight);
		btnsiguiente.setBackground(new Color(12, 138, 199));
		
		btnsiguiente.setBounds(238, 493, 122, 35);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel labelSiguiente = new JLabel("SIGUIENTE");
		labelSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		labelSiguiente.setForeground(Color.WHITE);
		labelSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelSiguiente.setBounds(0, 0, 122, 35);
		btnsiguiente.add(labelSiguiente);
		

	}
		
	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
