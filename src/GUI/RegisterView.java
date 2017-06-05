package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Coche;
import Models.ListaOrdenada;

public class RegisterView {

	private JFrame frame;
	private JTextField txtMatricula;
	private JTextField txtHoraEntrada;
	private JTextField textHoraSalida;
	private JTextField txtImporteEntregado;
	private JButton btnEntrada;
	private JButton btnSalida;
	private JButton btnCaja;
	private JButton btnRegistrar;
	private JLabel lblTotalAPagar;
	private JLabel lblPrecio;
	private JLabel lblCambio;
	private JLabel lblVuelta;
	private JButton btnPagar;
	private ListaOrdenada<Coche> Lista;
	private Date HoraEntrada;
	private Date HoraSalida;
	private String Matricula;
	private float PrecioTotal;
	private long DiferenciaHora;
	private float ImporteEntregado;
	private float Cambio;
	private JTextField textCaja;
	private JLabel lblCaja;
	private float DineroTotal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView window = new RegisterView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
		setProperties();
		setAdapters();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		btnEntrada = new JButton("Entrada");
		btnSalida = new JButton("Salida");
		btnCaja = new JButton("Caja");
		
		txtMatricula = new JTextField("Matricula");
		btnRegistrar = new JButton("Registrar");
		
		txtHoraEntrada = new JTextField("Hora Entrada");
		txtHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtHoraEntrada.setVisible(false);
		
		textHoraSalida = new JTextField("Hora Salida");
		textHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textHoraSalida.setVisible(false);
		
		lblTotalAPagar = new JLabel("Total a Pagar");
		lblTotalAPagar.setVisible(false);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setVisible(false);
		
		txtImporteEntregado = new JTextField("Importe Entregado");
		txtImporteEntregado.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtImporteEntregado.setVisible(false);
		
		lblCambio = new JLabel("Cambio");
		lblCambio.setVisible(false);
		
		lblVuelta = new JLabel("Vuelta");
		lblVuelta.setVisible(false);
		
		btnPagar = new JButton("Pagar y Salir");
		btnPagar.setVisible(false);
		
		lblCaja = new JLabel("Caja Total");
		lblCaja.setVisible(false);
		
		textCaja = new JTextField();
		textCaja.setVisible(false);
	}
	
	private void setProperties(){
		
		// Frame principal
		frame.setBounds(100, 100, 344, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Boton Entrada
		btnEntrada.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEntrada.setBounds(10, 11, 87, 84);
		frame.getContentPane().add(btnEntrada);
		
		// Boton Salida
		btnSalida.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSalida.setBounds(107, 11, 94, 84);
		frame.getContentPane().add(btnSalida);
		
		// Boton Caja
		btnCaja.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCaja.setBounds(211, 11, 87, 84);
		frame.getContentPane().add(btnCaja);
		
		// Texto de la matricula
		txtMatricula.setBounds(10, 106, 94, 29);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		// Boton Registrar
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(85, 167, 100, 46);
		frame.getContentPane().add(btnRegistrar);
		
		
		// Texto Hora Entrada
		txtHoraEntrada.setColumns(10);
		txtHoraEntrada.setBounds(10, 146, 175, 29);
		frame.getContentPane().add(txtHoraEntrada);
		
		// Texto Hora Salida
		textHoraSalida.setColumns(10);
		textHoraSalida.setBounds(10, 176, 175, 29);
		frame.getContentPane().add(textHoraSalida);
		
		// Texto Precio Total
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalAPagar.setBounds(211, 118, 87, 22);
		frame.getContentPane().add(lblTotalAPagar);
		
		// Label Precio
		lblPrecio.setBounds(240, 151, 69, 22);
		frame.getContentPane().add(lblPrecio);
		
		//  Texto Importe a Entregar
		txtImporteEntregado.setBounds(211, 189, 98, 24);
		frame.getContentPane().add(txtImporteEntregado);
		txtImporteEntregado.setColumns(10);
		
		// Label Cambio
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCambio.setBounds(229, 217, 75, 29);
		frame.getContentPane().add(lblCambio);
		
		// Label Muestra la vuelta
		lblVuelta.setBounds(240, 248, 58, 22);
		frame.getContentPane().add(lblVuelta);
		
		//Botton pagar
		btnPagar.setBounds(56, 224, 129, 46);
		frame.getContentPane().add(btnPagar);
		
		// Texto caja Total
		textCaja.setBounds(107, 142, 123, 36);
		frame.getContentPane().add(textCaja);
		textCaja.setColumns(10);
		
		// Label Caja
		lblCaja.setBounds(117, 113, 113, 22);
		frame.getContentPane().add(lblCaja);
		
	}
	
	private void setAdapters(){
		
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				Matricula=txtMatricula.getText();
				if(Matricula==null || Matricula.length()!=7){
					JOptionPane.showMessageDialog(frame, "Formato erroneo", "ERROR", JOptionPane.ERROR_MESSAGE);
					ModoRegistrar();
				}else{
				HoraEntrada = new Date();
				txtHoraEntrada.setVisible(true);
				txtHoraEntrada.setEditable(false);
				textHoraSalida.setVisible(true);
				textHoraSalida.setEditable(false);
				txtHoraEntrada.setText(HoraEntrada.toString());
				textHoraSalida.setText("Pendiente");
				btnRegistrar.setVisible(false);
				}
			}
		});
		
		btnEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ModoRegistrar();
				
				
			}
		});
		
		btnSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(txtMatricula.getText().equals("Matricula")){
					JOptionPane.showMessageDialog(frame, "Matricula Vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
				ModoSalida();
				HoraSalida = new Date();
				textHoraSalida.setText(HoraSalida.toString());
				DiferenciaHora(HoraEntrada, HoraSalida, TimeUnit.MINUTES);
				PrecioTotal=ObtenerPrecio();
				lblPrecio.setText(PrecioTotal+"€");
				Coche c = new Coche(Matricula,PrecioTotal,HoraSalida,HoraEntrada);
				Lista= new ListaOrdenada<Coche>();
				Lista.aniadir(c);
				
				}
			}
		});
		
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			ImporteEntregado=Float.parseFloat(txtImporteEntregado.getText());
			Cambio=(ImporteEntregado-PrecioTotal);
			if(Cambio<0){
				JOptionPane.showMessageDialog(frame, "No has introducido suficiente dinero", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else{
			lblVuelta.setText(Cambio+"€");
			txtImporteEntregado.setEnabled(false);
			}
			}
		});
		
		btnCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(DineroTotal==0f){
					JOptionPane.showMessageDialog(frame, "Caja Vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
				ModoCaja();
				textCaja.setText(DineroTotal+"€");
				}
				
			}
		});
	}
	

	/**
	 * Metodo que obtiene el precio de la estancia del coche en el parkibg
	 * @return Precio Total de la estancia de ese coche
	 */
	private float ObtenerPrecio(){
		if(DiferenciaHora<= 30){
			PrecioTotal+=0.0006*DiferenciaHora;
		}
		if(DiferenciaHora>30 || DiferenciaHora<=60){
			PrecioTotal+=0.0006*30;
			PrecioTotal+=0.0001*(DiferenciaHora-30);
		}
		if(DiferenciaHora>60 || DiferenciaHora<=720){
			PrecioTotal+=0.0006*30;
			PrecioTotal+=0.0001*30;
			PrecioTotal+=0.0003*(DiferenciaHora-60);
		}
		if(DiferenciaHora>720){
			PrecioTotal+=0.0006*30;
			PrecioTotal+=0.0001*30;
			PrecioTotal+=0.0003*660;
			PrecioTotal+=0.0015*(DiferenciaHora-720);
		}
		DineroTotal+=PrecioTotal;
		return PrecioTotal;
		
	}
	
	/**
	 * Obtiene la diferencia de tiempo entre la entrada del coche y la salida
	 * @param d1
	 * @param d2
	 * @param timeUnit
	 * @return Devuelve el tiempo en milisegundos
	 */
	private long DiferenciaHora(Date d1, Date d2, TimeUnit timeUnit) {
		long DiferenciaHora = d2.getTime() - d1.getTime();
		return timeUnit.convert(DiferenciaHora, TimeUnit.MILLISECONDS);
	}
	
	
	
	/**
	 * Cambia al ModoRegistar coches
	 */
	private void ModoRegistrar(){
		txtHoraEntrada.setVisible(false);
		textHoraSalida.setVisible(false);
		btnRegistrar.setVisible(true);
		btnPagar.setVisible(false);
		lblTotalAPagar.setVisible(false);
		lblPrecio.setVisible(false);
		txtImporteEntregado.setVisible(false);
		lblVuelta.setVisible(false);
		lblCambio.setVisible(false);
		lblCaja.setVisible(false);
		textCaja.setVisible(false);
		txtMatricula.setVisible(true);
		txtMatricula.setText("Matricula");
	}
	
	/**
	 * Cambia al modo de caja total
	 */
	private void ModoCaja(){
		txtHoraEntrada.setVisible(false);
		textHoraSalida.setVisible(false);
		btnRegistrar.setVisible(true);
		btnPagar.setVisible(false);
		lblTotalAPagar.setVisible(false);
		lblPrecio.setVisible(false);
		txtImporteEntregado.setVisible(false);
		lblVuelta.setVisible(false);
		lblCambio.setVisible(false);
		lblCaja.setVisible(true);
		textCaja.setVisible(true);
		textCaja.setEditable(false);
		btnRegistrar.setVisible(false);
		txtMatricula.setVisible(false);
		
	}
	
	/**
	 * Cambia al modo Salida del coche 
	 */
	private void ModoSalida(){
		btnRegistrar.setVisible(false);
		btnPagar.setVisible(true);
		lblTotalAPagar.setVisible(true);
		lblPrecio.setVisible(true);
		txtImporteEntregado.setVisible(true);
		lblVuelta.setVisible(true);
		lblCambio.setVisible(true);
		lblCaja.setVisible(false);
		textCaja.setVisible(false);
	}
}
