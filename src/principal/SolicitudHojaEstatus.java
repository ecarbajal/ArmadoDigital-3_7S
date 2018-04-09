package principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.itextpdf.text.DocumentException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
public class SolicitudHojaEstatus extends JFrame implements ActionListener, FocusListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelArmado;
	private JPanel panelPrincipal = new JPanel();
	private JButton btnSolicitar;
	private JTextField textFieldFolio;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox  comboBoxAnio;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SolicitudHojaEstatus window = new SolicitudHojaEstatus();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SolicitudHojaEstatus() {
		setResizable(false);
		getContentPane().setLayout(null);
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBounds(0, 0, 394, 188);
		getContentPane().add(panelPrincipal);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		this.setName("Solicitud");
		setSize(400, 217);
		setTitle("Solicitud");
		setDefaultCloseOperation(1);
		getContentPane().add(getpanelPrincipal());
		panelPrincipal.setLayout(null);
		getpanelPrincipal().add((Component)this.getLabelArmado());
		getpanelPrincipal().add((Component)this.gettextFolio());
		getpanelPrincipal().add((Component)this.getbtnSolicitar());
//		getpanelPrincipal().add((Component)this.getcomboBoxDia());
//		getpanelPrincipal().add((Component)this.getcomboBoxMes());
//		getpanelPrincipal().add((Component)this.getcomboBoxAnio());
		textFieldFolio.addFocusListener(this);
		btnSolicitar.addActionListener(this);

		JLabel lblFechaDeSolicitud = new JLabel("Fecha de Solicitud:");
		lblFechaDeSolicitud.setBounds(21, 85, 151, 17);
		lblFechaDeSolicitud.setForeground(new Color(0, 0, 128));
		lblFechaDeSolicitud.setFont(new Font("Arial", Font.PLAIN, 14));
		panelPrincipal.add(lblFechaDeSolicitud);


		JLabel labelFolio = new JLabel("Folio:");
		labelFolio.setBounds(21, 57, 35, 17);
		labelFolio.setForeground(new Color(0, 0, 128));
		labelFolio.setFont(new Font("Arial", Font.PLAIN, 14));
		panelPrincipal.add(labelFolio);
		
		JLabel lblDa = new JLabel("D\u00EDa:");
		lblDa.setBounds(36, 116, 29, 14);
		lblDa.setForeground(new Color(0, 0, 128));
		lblDa.setFont(new Font("Arial", Font.PLAIN, 14));
		panelPrincipal.add(lblDa);
		
		JLabel lblNewLabel = new JLabel("Mes");
		lblNewLabel.setBounds(145, 116, 35, 14);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		panelPrincipal.add(lblNewLabel);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(250, 116, 34, 14);
		lblDa.setForeground(new Color(0, 0, 128));
		lblDa.setFont(new Font("Arial", Font.PLAIN, 14));
		panelPrincipal.add(lblAo);
	}
//
//	public JComboBox<Object> getcomboBoxDia(){
//		if(comboBoxDia == null){
//			comboBoxDia  = new JComboBox<Object>(); 
//			comboBoxDia.setModel(new DefaultComboBoxModel<Object>(new String[] {" ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
//			comboBoxDia.setBounds(75, 113, 60, 20);
//		}
//		return comboBoxDia;
//	}
//
//	public JComboBox<Object> getcomboBoxMes(){
//		if(comboBoxMes == null){
//			comboBoxMes  = new JComboBox<Object>(); 
//			comboBoxMes.setModel(new DefaultComboBoxModel<Object>(new String[] {" ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
//			comboBoxMes.setBounds(177, 113, 60, 20);
//		}
//		return comboBoxMes;
//	}
//
//	public JComboBox<Object> getcomboBoxAnio(){
//		if(comboBoxAnio == null){
//			comboBoxAnio  = new JComboBox<Object>(); 
//			comboBoxAnio.setModel(new DefaultComboBoxModel<Object>(new String[] {" ", "2015", "2016"}));
//			comboBoxAnio.setBounds(294, 113, 60, 20);
//		}
//		return comboBoxAnio;
//	}

	private Component getbtnSolicitar() {
		if (btnSolicitar == null) {
			try {
				btnSolicitar = new JButton("Solicitar");
				btnSolicitar.setBounds(254, 154, 100, 23);
				btnSolicitar.setVisible(true);
			}catch(Throwable var1_1){

			}
		}
		return btnSolicitar;
	}

	JTextField gettextFolio() {
		if (this.textFieldFolio == null) {
			try {
				textFieldFolio = new JTextField();
				textFieldFolio.setBounds(70, 56, 132, 20);	  
				textFieldFolio.setVisible(true);
			}catch(Throwable font1){
			}
		}
		return textFieldFolio;
	}

	JLabel getLabelArmado() {
		this.labelArmado = new JLabel();
		labelArmado.setBackground(Color.WHITE);
		labelArmado.setFont(new Font("Arial", Font.BOLD, 18));
		labelArmado.setName("LabelArmado");
		labelArmado.setText("SOLICITUD DE HOJA DE ESTATUS");
		labelArmado.setForeground(new Color(0, 70, 129));
		labelArmado.setBounds(53, 11, 301, 22);
		labelArmado.setVisible(true);
		return labelArmado;
	}

	JPanel getpanelPrincipal() {
		if (this.panelPrincipal == null) {
			try {
				this.panelPrincipal.setName("panelPrincipal");
				this.panelPrincipal.setBounds(0, 0, 530, 470);
				this.panelPrincipal.setLayout(null);
				this.panelPrincipal.setVisible(true);
			}
			catch (Throwable var1_1) {
				// empty catch block
			}
		}
		return this.panelPrincipal;
	}
	
	 public void actionPerformed(ActionEvent e) {
		 
		 
	        String dia = "";
	        String mes = "";
	        String anio = "";
	        String folio = gettextFolio().getText();
	        dia = this.comboBoxDia.getSelectedItem().toString();
	        mes = this.comboBoxMes.getSelectedItem().toString();
	        anio = this.comboBoxAnio.getSelectedItem().toString();
	     
	        
	        
	        if (e.getSource() == this.btnSolicitar) {
	        	if((folio == null) || dia.indexOf(" ")>-1 || mes.indexOf(" ")>-1 || anio.indexOf(" ")>-1){
	        		String ms = "Debe llenar todos los campos";
	        		JOptionPane.showMessageDialog(null, ms);
	        	}else{
	        	anio = anio.substring(2, 4);
	            String linea = "PNCVS.PET" + folio + ".D0" + anio + mes + dia + ".DL70HS04";
	            System.out.println("Archivo Solicitado: " + linea);
	            try {
	            	FTPRecibo ft = new FTPRecibo();
	                ft.ftpArchivo(linea, "FTPPNCVS", "A3DQF5HI");
	            }
	            catch (IOException e1) {
	                System.out.println("No se pudo realizar la descarga FTP");
	                e1.printStackTrace();
	            }
	          
	        }
	        }
	    }
	 
//     if (e.getSource() == this.getBotonCancelar()) {
//         File ruta = new File(this.archivoS);
//         this.getBotonSoli().setSelected(false);
//         System.out.println("aprete salir");
//         if (ruta.exists()) {
//             ruta.delete();
//         }
//         this.setVisible(false);
//     }

	    public String fillCeros(String valor, int longitud) {
	        while (valor.length() < longitud) {
	            valor = "0" + valor;
	        }
	        return valor;
	    }

	    public void focusLost(FocusEvent arg0) {
	        arg0.getSource();
	        if (arg0.getSource() == this.gettextFolio()) {
	        	gettextFolio().setText(fillCeros(gettextFolio().getText(),5));
		        }
	    }

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
}
