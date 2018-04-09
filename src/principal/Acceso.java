package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Acceso extends javax.swing.JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = -7749076619086833615L;
	private JLabel labelUser;
	private JLabel labelPass;
	private JLabel labelAcceso;
	private JTextField textUser;
	private JPasswordField textPass;
	private JLabel labelImagen_gnp2;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JButton botonPassChange;
	private JPanel panel1;
	private String cua;

	public Acceso() {
		inicializar();
	}

	void inicializar() {
		setName("Acceso");
		setSize(450, 450);
		setTitle("Armado Digital");
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		getPanel1().add(getTextUser(), getTextUser().getName());
		getPanel1().add(getTextPass(), getTextPass().getName());
		getPanel1().add(getLabelUser(), getLabelUser().getName());
		getPanel1().add(getLabelPass(), getLabelPass().getName());
		getPanel1().add(getLabelAcceso(), getLabelAcceso().getName());
		getPanel1().add(getBotonAceptar(), getBotonAceptar().getName());
		getPanel1().add(getBotonCancelar(), getBotonCancelar().getName());
		getPanel1().add(getBotonPassChange(), getBotonPassChange().getName());
		getPanel1().add(getImagen_gnp2(), getImagen_gnp2().getName());
		add(getPanel1(), getPanel1().getName());
		getImagen_gnp2().setVisible(true);
		getBotonAceptar().setVisible(true);
		getBotonCancelar().setVisible(true);
		getBotonPassChange().setVisible(true);
		getLabelUser().setVisible(true);
		getLabelPass().setVisible(true);
		getLabelAcceso().setVisible(true);
		getTextUser().setVisible(true);
		getTextPass().setVisible(true);
		getPanel1().setVisible(true);
		getBotonAceptar().addActionListener(this);
		getBotonCancelar().addActionListener(this);
		getBotonPassChange().addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
	     	   public void windowClosing(WindowEvent e) {
	     			System.exit(0);		
	     		}
	        });
	}

	protected JLabel getLabelAcceso(){
		if (labelAcceso == null) {
	        try {
	        	labelAcceso = new JLabel();
	        	labelAcceso.setName("LabelArmado");
	        	Font font = new Font("Arial Rounded MT", Font.BOLD, 28);            	
	        	labelAcceso.setFont(font);            	
	        	labelAcceso.setText("ACCESO ARMADO DIGITAL"); 
	        	labelAcceso.setForeground(new Color(255,140,00));
	        	labelAcceso.setBounds(30,25,400,50);
	        	labelAcceso.setVisible(true);
	        } catch (java.lang.Throwable ivjExc) {
	  //          ivjExc.printStackTrace();
	        }
	    }
	    return labelAcceso;
	}


	JPanel getPanel1() {
		if (panel1 == null) {
			try {
				panel1 = new JPanel();
				panel1.setName("panel1");
				panel1.setBounds(0, 0, 530, 470);
				panel1.setLayout(null);
				panel1.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return panel1;
	}

	// etiqueta USUARIO
	JLabel getLabelUser() {
		if (labelUser == null) {
			try {
				labelUser = new JLabel();
				labelUser.setName("labelUser");
				labelUser.setText("Usuario:");
				labelUser.setSize(300, 23);
				labelUser.setLocation(55, 100);  
				labelUser.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return labelUser;
	}

	// JTextField del Usuario
	JTextField getTextUser() {
		if (textUser == null) {
			try {
				textUser = new JTextField();
				textUser.setName("textUser");
				textUser.setSize(100, 23);
				textUser.setLocation(125, 100);	
				Font font1 = new Font("Courier New", Font.BOLD, 12);
				textUser.setFont(font1);
				textUser.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return textUser;
	}

	// Etiqueta Password
	JLabel getLabelPass() {
		if (labelPass == null) {
			try {
				labelPass = new JLabel();
				labelPass.setName("labelPss");
				labelPass.setText("Password: ");
				labelPass.setSize(300, 23);
				labelPass.setLocation(55, 140); 
				labelPass.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return labelPass;
	}

	// JTextField del password
	JPasswordField getTextPass() {
		if (textPass == null) {
			try {
				textPass = new JPasswordField();
				textPass.setName("textPath2");
				textPass.setSize(100, 23);
				textPass.setLocation(125, 140);	
				Font font1 = new Font("Courier New", Font.BOLD, 12);
				textPass.setFont(font1);

				textPass.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return textPass;
	}
	
	JLabel getImagen_gnp2() {
		if (labelImagen_gnp2 == null) {
			try {
				labelImagen_gnp2 = new JLabel();
				labelImagen_gnp2.setName("LabelImagen_gnp2");
				ImageIcon ima = new ImageIcon(".. \\..\\images\\logo_gnp.png");
				labelImagen_gnp2.setIcon(ima);
				labelImagen_gnp2.setBounds(145,270,280,120);
				labelImagen_gnp2.setVisible(true);
			} catch (java.lang.Throwable ignored) {

			}
		}
		return labelImagen_gnp2;
	}

	JButton getBotonAceptar() {
		if (botonAceptar == null) {
			try {
				botonAceptar = new JButton();
				botonAceptar.setName("BotonAceptar");
				botonAceptar.setText("Entrar");
            	botonAceptar.setBounds(85, 200, 100, 25);  
				botonAceptar.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return botonAceptar;
	}

	JButton getBotonCancelar() {
		if (botonCancelar == null) {
			try {
				botonCancelar = new JButton();
				botonCancelar.setName("BotonCancelar");
				botonCancelar.setText("Salir");
				botonCancelar.setBounds(225, 200, 100, 25);
				botonCancelar.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return botonCancelar;
	}
	
	JButton getBotonPassChange() {		
		if (botonPassChange == null) {
			try {
				botonPassChange = new JButton();
				botonPassChange.setName("BotonPassChange");
				botonPassChange.setText("Cambiar Password");
				botonPassChange.setBounds(130, 245, 150, 25);  
				botonPassChange.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return botonPassChange;
	}



	String login() {
		this.setVisible(true);
		return cua;
	}

	public static void main(String[] args) {
		Acceso as = new Acceso();
		as.login();		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBotonAceptar()) {
			if (getTextUser().getText().equals("") || getTextPass().equals("")) {
				String st = "Debe informarse el Usuario y Password";
				JOptionPane.showMessageDialog(null, st);
			} else {
				if (validar()) {
					Principal pr = new Principal();
					Principal.usuario = getTextUser().getText();
					Principal.cua = cua;
					if(cua.indexOf("1") > -1){
						pr.ejecutaPrincipal();
					}else{
					}
					this.setVisible(false);
				}
			}
		}

		if (e.getSource() == getBotonCancelar()) {
			System.exit(0);
		}
		
		if (e.getSource() == getBotonPassChange()) {						
			if (getTextUser().getText().equals("")){
				String st = "   Debe informarse el Usuario";
				JOptionPane.showMessageDialog(null, st);				
			}else{
				String[] users = new String[3];
				DBConnect dbc = new DBConnect();
				try {
					users = dbc.getUser(getTextUser().getText());
				} catch (SQLException ignored) {}	
				if (users[0] != null) {
					CambioPassword cp = new CambioPassword(getTextUser().getText());
					cp.setVisible(true);					
				}else{
					String st = "   El usuario no esta Registrado";
					JOptionPane.showMessageDialog(null, st);
				}
			}			
		}
	}

	public void focusGained(FocusEvent arg0) {
	}

	public void focusLost(FocusEvent arg0) {
	}

	private boolean validar() {
		boolean valido = false;
		String[] users = new String[4];
		DBConnect dbc = new DBConnect();
 		//dbc.showDB();
		try {
			users = dbc.getUser(getTextUser().getText());
		} catch (SQLException ignored) { }		
		if (users[0] != null) {
			char clave[] = getTextPass().getPassword();
			String clavedef = new String(clave);
			this.cua = users[3];
			if (users[2].equals(clavedef)) {
				valido = true;
			} else {
				String st = "       Password Incorrecto";
				JOptionPane.showMessageDialog(null, st);
			}
		} else {
			String st = "El usuario no esta Registrado";
			JOptionPane.showMessageDialog(null, st);
		}
		return valido;
	}

}
