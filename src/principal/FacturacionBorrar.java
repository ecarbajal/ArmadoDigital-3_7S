package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;

public class FacturacionBorrar {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturacionBorrar window = new FacturacionBorrar();
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
	public FacturacionBorrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 854, 614);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(179, 79, 154, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 114, 154, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(179, 183, 154, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 217, 154, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(444, 217, 154, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblRfc = new JLabel("RFC:");
		lblRfc.setBounds(103, 82, 56, 16);
		panel.add(lblRfc);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(103, 117, 56, 16);
		panel.add(lblNombre);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(103, 186, 56, 16);
		panel.add(lblCalle);
		
		JLabel lblNoExterior = new JLabel("No. Exterior:");
		lblNoExterior.setBounds(103, 220, 76, 16);
		panel.add(lblNoExterior);
		
		JLabel lblNoInterior = new JLabel("No. Interior:");
		lblNoInterior.setBounds(353, 220, 79, 16);
		panel.add(lblNoInterior);
		
		textField_5 = new JTextField();
		textField_5.setBounds(179, 252, 154, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblColonia = new JLabel("Colonia:");
		lblColonia.setBounds(103, 255, 56, 16);
		panel.add(lblColonia);
		
		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setBounds(352, 301, 76, 16);
		panel.add(lblMunicipio);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(103, 301, 56, 16);
		panel.add(lblEstado);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(103, 351, 56, 16);
		panel.add(lblPas);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo Postal:");
		lblCdigoPostal.setBounds(353, 258, 96, 16);
		panel.add(lblCdigoPostal);
		
		textField_6 = new JTextField();
		textField_6.setBounds(444, 252, 154, 22);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnGenerarFactura = new JButton("Generar Factura");
		btnGenerarFactura.setBounds(441, 463, 135, 25);
		panel.add(btnGenerarFactura);
		
		JLabel lblNoDeFactura = new JLabel("No. de Factura");
		lblNoDeFactura.setBounds(375, 82, 96, 16);
		panel.add(lblNoDeFactura);
		
		JLabel lblNoDeCliente = new JLabel("No. de Cliente");
		lblNoDeCliente.setBounds(376, 117, 95, 16);
		panel.add(lblNoDeCliente);
		
		textField_7 = new JTextField();
		textField_7.setBounds(482, 79, 116, 22);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(483, 114, 116, 22);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblDatosDelCliente = new JLabel("DATOS DEL CLIENTE");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosDelCliente.setBounds(103, 154, 161, 16);
		panel.add(lblDatosDelCliente);
		
		JLabel lblMontoDeLa = new JLabel("MONTO DE LA FACTURA");
		lblMontoDeLa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMontoDeLa.setBounds(103, 396, 230, 16);
		panel.add(lblMontoDeLa);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(643, 113, 97, 25);
		panel.add(btnConsultar);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(179, 298, 154, 22);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(179, 333, 154, 22);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(444, 298, 154, 22);
		panel.add(textField_11);
		
		JLabel lblSubTotal = new JLabel("Sub Total:");
		lblSubTotal.setBounds(103, 433, 76, 16);
		panel.add(lblSubTotal);
		
		textField_12 = new JTextField();
		textField_12.setBounds(179, 430, 154, 22);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblIva = new JLabel("I.V.A. 16%");
		lblIva.setBounds(103, 467, 76, 16);
		panel.add(lblIva);
		
		textField_13 = new JTextField();
		textField_13.setBounds(179, 464, 154, 22);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(103, 505, 56, 16);
		panel.add(lblTotal);
		
		textField_14 = new JTextField();
		textField_14.setBounds(179, 502, 154, 22);
		panel.add(textField_14);
		textField_14.setColumns(10);
	}
}
