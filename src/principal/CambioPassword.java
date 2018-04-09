package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class CambioPassword extends javax.swing.JFrame implements ActionListener, FocusListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6452233096091725123L;
	private JPasswordField textPass;
	private JPasswordField textNewPass;
	private JPasswordField textNewPass2;
	private JLabel labelPass;
	private JLabel labelNewPass;
	private JLabel labelNewPass2;
	private JLabel labelCambioPass;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JPanel panel1;
	private String usuario;
	
	public CambioPassword(String usuario) {
		inicializar();
		this.usuario = usuario;
	}
	
	void inicializar() {
		setName("CambioPassword");
		setSize(300, 300);
		setTitle("Armado Digital - Cambio de Password");
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		getPanel1().add(getTextPass(), getTextPass().getName());
		getPanel1().add(getTextNewPass(), getTextNewPass().getName());
		getPanel1().add(getTextNewPass2(), getTextNewPass2().getName());
		getPanel1().add(getLabelPass(), getLabelPass().getName());
		getPanel1().add(getLabelNewPass(), getLabelNewPass().getName());
		getPanel1().add(getLabelNewPass2(), getLabelNewPass2().getName());
		getPanel1().add(getLabelCambioPass(), getLabelCambioPass().getName());
		getPanel1().add(getBotonAceptar(), getBotonAceptar().getName());
		getPanel1().add(getBotonCancelar(), getBotonCancelar().getName());	
		
		add(getPanel1(), getPanel1().getName());
	
		getBotonAceptar().setVisible(true);
		getBotonCancelar().setVisible(true);		
		getLabelNewPass().setVisible(true);
		getLabelPass().setVisible(true);
		getLabelNewPass2().setVisible(true);
		getLabelCambioPass().setVisible(true);
		getTextNewPass().setVisible(true);
		getTextNewPass2().setVisible(true);
		getTextPass().setVisible(true);
		getPanel1().setVisible(true);
		getBotonAceptar().addActionListener(this);
		getBotonCancelar().addActionListener(this);		
	}	
	
	private JLabel getLabelCambioPass() {
		if (labelCambioPass == null) {
			try {
				labelCambioPass = new JLabel();
				labelCambioPass.setName("LabelArmado");
				Font font = new Font("Arial Rounded MT", Font.BOLD, 22);
				labelCambioPass.setFont(font);
				labelCambioPass.setText("Cambiar Password");
				labelCambioPass.setForeground(new Color(255,140,00));
				labelCambioPass.setBounds(40, 15, 420, 50);
				labelCambioPass.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return labelCambioPass;	
	}

	JButton getBotonAceptar() {
		if (botonAceptar == null) {
			try {
				botonAceptar = new JButton();
				botonAceptar.setName("BotonAceptar");
				botonAceptar.setText("Aceptar");
            	botonAceptar.setBounds(30, 200, 100, 25); 
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
				botonCancelar.setBounds(160, 200, 100, 25); 
				botonCancelar.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return botonCancelar;
	}
	
	
	JLabel getLabelPass() {
		if (labelPass == null) {
			try {
				labelPass = new JLabel();
				labelPass.setName("labelPass");
				labelPass.setText("Password: ");
				labelPass.setSize(300, 23);
				labelPass.setLocation(25, 75);
				labelPass.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return labelPass;
	}

	JLabel getLabelNewPass() {
		if (labelNewPass == null) {
			try {
				labelNewPass = new JLabel();
				labelNewPass.setName("labelNewPass");
				labelNewPass.setText("Nuevo Password: ");
				labelNewPass.setSize(300, 23);
				labelNewPass.setLocation(25, 110); 
				labelNewPass.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return labelNewPass;
	}

	JLabel getLabelNewPass2() {
		if (labelNewPass2 == null) {
			try {
				labelNewPass2 = new JLabel();
				labelNewPass2.setName("labelNewPass2");
				labelNewPass2.setText("Confirme Password: ");
				labelNewPass2.setSize(300, 23);
				labelNewPass2.setLocation(25, 145);
				labelNewPass2.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return labelNewPass2;
	}
	
	JPasswordField getTextPass() {
		if (textPass == null) {
			try {
				textPass = new JPasswordField();
				textPass.setName("textPass");
				textPass.setSize(100, 23);
				textPass.setLocation(150, 75);				
				textPass.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return textPass;
	}
	
	JPasswordField getTextNewPass() {
		if (textNewPass == null) {
			try {
				textNewPass = new JPasswordField();
				textNewPass.setName("textNewPass");
				textNewPass.setSize(100, 23);
				textNewPass.setLocation(150, 110);			
				textNewPass.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return textNewPass;
	}
	
	JPasswordField getTextNewPass2() {
		if (textNewPass2 == null) {
			try {
				textNewPass2 = new JPasswordField();
				textNewPass2.setName("textNewPass2");
				textNewPass2.setSize(100, 23);
				textNewPass2.setLocation(150, 145);					
				textNewPass2.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return textNewPass2;
	}
	
	JPanel getPanel1() {
		if (panel1 == null) {
			try {
				panel1 = new JPanel();
				panel1.setName("panel1");
				panel1.setBounds(0, 0, 440, 400);
				panel1.setLayout(null);
				panel1.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return panel1;
	}
	
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBotonAceptar()) {
			DBConnect dbc = new DBConnect();
	// 		dbc.showDB();
			char clave[] = getTextPass().getPassword();
			String claveOld = new String(clave); 
			clave = getTextNewPass().getPassword();
			String claveNew = new String(clave); 
			clave = getTextNewPass2().getPassword();
			String claveNew2 = new String(clave); 			
			if(claveOld.equals("")||claveNew.equals("")||claveNew.equals("")){
				String st = "Favor de llenar todos los campos";
				JOptionPane.showMessageDialog(null, st);
			}else{
				if(claveNew.length()>8){
					String sts = "El password debe ser de un maximo de 8 caracteres";
					JOptionPane.showMessageDialog(null, sts);
				}else{
					
					if(validar(claveOld)){
						if(claveNew.equals(claveNew2)){						
//							DBConnect dbc = new DBConnect();
							try {
								if(dbc.cambioPassword(usuario, claveNew)){
									String stb = "  El password se actualizó exitosamente";
									JOptionPane.showMessageDialog(null, stb);
									this.setVisible(false);
								}else{
									String stn = "    No se pudo actualizar el password";
									JOptionPane.showMessageDialog(null, stn);
								}
							} catch (HeadlessException ignored) {} 
							  catch (SQLException ignored) { }
					}else{
						String sts = "  Los campos del nuevo password no coinciden";
						JOptionPane.showMessageDialog(null, sts);
						}	
					}					
				}
			}
		}
		if (e.getSource() == getBotonCancelar()) {
			this.setVisible(false);	
		}		
	}
	
	private boolean validar(String oldPass) {
		boolean valido = false;
		String[] users = new String[3];
		DBConnect dbc = new DBConnect();
		try {
			users = dbc.getUser(usuario);
		} catch (SQLException e) { }		
		if (users[2].equals(oldPass)) {
				valido = true;
			} else {
				String st = "       Password Incorrecto";
				JOptionPane.showMessageDialog(null, st);
			}		 
		return valido;
	}
	
	
}
