package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Status extends javax.swing.JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel labelS1;
	private JLabel labelS2;
	private JLabel labelS3;
	private JLabel labelS4;
	private JLabel labelS5;
	private JLabel labelS6;
	
	private final String user;	
	
	
	private JButton botonAceptar;
	private JButton botonActualiza;
	
	private JLabel labelTitulo;
	
	private JPanel panel1;
	
	public Status(String user){
		this.user = user;
		inicializar();
		if(ejecutaProcesos()){
			EstatusFTP ft = new EstatusFTP(user, user); 
			ft.armadoDeArchivos();
		}
	}

	private boolean ejecutaProcesos() {
		boolean finalizado = false;
		
		try{
			Thread.sleep(6000);
			String resp1="";
			String resp2="";
			String resp3="";
			String resp4="";

			String resp6="";
		
			EstatusFTP ftp1 = new EstatusFTP(CtsArmado.Archi1, user);
			EstatusFTP ftp2 = new EstatusFTP(CtsArmado.Archi2, user);
			EstatusFTP ftp3 = new EstatusFTP(CtsArmado.Archi3, user);
			EstatusFTP ftp4 = new EstatusFTP(CtsArmado.Archi4, user);
//			EstatusFTP ftp5 = new EstatusFTP(CtsArmado.Archi5, user);
			EstatusFTP ftp6 = new EstatusFTP(CtsArmado.Archi8, user);			
//			do{	
				resp1 = ftp1.call();	
				resp2 = ftp2.call();
				resp2 = ftp3.call();
				resp2 = ftp4.call();

				resp6 = ftp6.call();
				

				getLabelS1().setText(resp6);
				getLabelS2().setText(resp6);
				getLabelS3().setText(resp6);
				getLabelS4().setText(resp6);
				getLabelS5().setText(resp6);
				getLabelS6().setText(resp6);

//				resp2 = ftp2.call();	
//				getLabelS2().setText(resp2);
//				resp3 = ftp3.call();	
//				getLabelS3().setText(resp3);
//				resp4 = ftp4.call();	
//				getLabelS4().setText(resp4);
//				resp5 = ftp5.call();	
//				getLabelS5().setText(resp5);				
//				resp6 = ftp6.call();	
//				getLabelS6().setText(resp6);
				this.setVisible(true);
				this.repaint();
				String st ="         PROCESO TERMINADO\n       Los Archivos de Control \nSe han generado Exitosamente";

				JOptionPane.showMessageDialog(null, st);
				if(resp1.equals("Terminado")){


					finalizado=true;
				}			
				return finalizado;			
		}catch(Exception ignored){			
		}
		return finalizado;
	}

	private void inicializar() {
		setName("Status");
        setSize(400, 500);
        setTitle("Status de Procesamiento");
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        add(getPanel1());
        getPanel1().add(getLabelTitulo(),getLabelTitulo().getName());	
        getPanel1().add(getLabel1(),getLabel1().getName());	
        getPanel1().add(getLabelS1(),getLabelS1().getName());	
        getPanel1().add(getLabel2(),getLabel2().getName());	
        getPanel1().add(getLabelS2(),getLabelS2().getName());	
        getPanel1().add(getLabel3(),getLabel3().getName());	
        getPanel1().add(getLabelS3(),getLabelS3().getName());	
        getPanel1().add(getLabel4(),getLabel4().getName());	
        getPanel1().add(getLabelS4(),getLabelS4().getName());	
        getPanel1().add(getLabel5(),getLabel5().getName());	
        getPanel1().add(getLabelS5(),getLabelS5().getName());	
        getPanel1().add(getLabel6(),getLabel6().getName());	
        getPanel1().add(getLabelS6(),getLabelS6().getName());
        getPanel1().add(getBotonAceptar(), getBotonAceptar().getName());
        getPanel1().add(getBotonActualiza(), getBotonActualiza().getName());
        getBotonAceptar().addActionListener(this);
        getBotonActualiza().addActionListener(this);
	}
	
	protected JLabel getLabelTitulo(){
		if (labelTitulo == null) {
	        try {
	        	labelTitulo = new JLabel();
	        	labelTitulo.setName("LabelTitulo");
	        	Font font = new Font("Arial Rounded MT", Font.BOLD, 26);               	
	        	labelTitulo.setFont(font);            	
	        	labelTitulo.setText("STATUS"); 
	        	labelTitulo.setForeground(new Color(255,140,00));
	        	labelTitulo.setBounds(130,15,400,50);
	        	labelTitulo.setVisible(true);
	        } catch (java.lang.Throwable ivjExc) {
	  //          ivjExc.printStackTrace();
	        }
	    }
	    return labelTitulo;
	}

	protected JPanel getPanel1() {
		if (panel1 == null) {
			try {
				panel1 = new JPanel();
				panel1.setName("panel1");             	  
				panel1.setBounds(0, 0, 400, 450);            	    
				panel1.setLayout(null);  
				panel1.setVisible(true);
			} catch (java.lang.Throwable ignored) {
			}
		}
		return panel1;
	}
	
	
	protected JLabel getLabel1() {
        if (label1 == null) {
            try {
            	label1 = new JLabel();
            	label1.setName("label1");
            	label1.setText("Archivo Certificados:     ");
            	label1.setSize(200,25);
            	label1.setLocation(10, 90);            	
            	label1.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return label1;
    }	
	
	protected JLabel getLabelS1() {
        if (labelS1 == null) {
            try {
            	labelS1 = new JLabel();
            	labelS1.setName("labelS1");
            	labelS1.setText("");
            	labelS1.setSize(250,25);
            	labelS1.setLocation(300, 90);            	
            	labelS1.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return labelS1;
    }	
	
	protected JLabel getLabel2() {
        if (label2 == null) {
            try {
            	label2 = new JLabel();
            	label2.setName("label2");
            	label2.setText("Caratulas de Cliente:     ");
            	label2.setSize(200,25);
            	label2.setLocation(10, 140);            	
            	label2.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return label2;
    }	
	
	protected JLabel getLabelS2() {
        if (labelS2 == null) {
            try {
            	labelS2 = new JLabel();
            	labelS2.setName("labelS2");
            	labelS2.setText("");
            	labelS2.setSize(300,25);
            	labelS2.setLocation(300, 140);            	
            	labelS2.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return labelS2;
    }	
	
	protected JLabel getLabel3() {
        if (label3 == null) {
            try {
            	label3 = new JLabel();
            	label3.setName("label3");
            	label3.setText("Registros de Asegurados:     ");
            	label3.setSize(200,25);
            	label3.setLocation(10, 190);            	
            	label3.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return label3;
    }	
	
	protected JLabel getLabelS3() {
        if (labelS3 == null) {
            try {
            	labelS3 = new JLabel();
            	labelS3.setName("labelS3");
            	labelS3.setText("");
            	labelS3.setSize(300,25);
            	labelS3.setLocation(300, 190);            	
            	labelS3.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return labelS3;
    }	
	
	protected JLabel getLabel4() {
        if (label4 == null) {
            try {
            	label4 = new JLabel();
            	label4.setName("label4");
            	label4.setText("Endosos:     ");
            	label4.setSize(200,25);
            	label4.setLocation(10, 240);            	
            	label4.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return label4;
    }	
	
	protected JLabel getLabelS4() {
        if (labelS4 == null) {
            try {
            	labelS4 = new JLabel();
            	labelS4.setName("labelS4");
            	labelS4.setText("");
            	labelS4.setSize(300,25);
            	labelS4.setLocation(300, 240);            	
            	labelS4.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return labelS4;
    }	
	
	protected JLabel getLabel5() {
        if (label5 == null) {
            try {
            	label5 = new JLabel();
            	label5.setName("label5");
            	label5.setText("Caratulas del Agente:     ");
            	label5.setSize(200,25);
            	label5.setLocation(10, 290);            	
            	label5.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return label5;
    }	
	
	protected JLabel getLabelS5() {
        if (labelS5 == null) {
            try {
            	labelS5 = new JLabel();
            	labelS5.setName("labelS5");
            	labelS5.setText("");
            	labelS5.setSize(300,25);
            	labelS5.setLocation(300, 290);            	
            	labelS5.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return labelS5;
    }	
	
	protected JLabel getLabel6() {
        if (label6 == null) {
            try {
            	label6 = new JLabel();
            	label6.setName("label6");
            	label6.setText("Archivo Tarjetas:     ");
            	label6.setSize(200,25);
            	label6.setLocation(10, 340);            	
            	label6.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return label6;
    }	
	
	protected JLabel getLabelS6() {
        if (labelS6 == null) {
            try {
            	labelS6 = new JLabel();
            	labelS6.setName("labelS6");
            	labelS6.setText("");
            	labelS6.setSize(300,25);
            	labelS6.setLocation(300, 340);            	
            	labelS6.setVisible(true);
            } catch (java.lang.Throwable ignored) {
            }
        }
        return labelS6;
    }
	
	 protected JButton getBotonAceptar() {
	        if (botonAceptar == null) {
	            try {
	            	botonAceptar = new JButton();
	            	botonAceptar.setName("BotonAceptar");
	            	botonAceptar.setText("Salir");
	            	botonAceptar.setBounds(220, 400, 100, 25);   	            	
	            	botonAceptar.setVisible(true);
	            } catch (java.lang.Throwable ivjExc) {
	                ivjExc.printStackTrace();
	            }
	        }
	        return botonAceptar;
	    }

	 protected JButton getBotonActualiza() {
	        if (botonActualiza == null) {
	            try {
	            	botonActualiza = new JButton();
	            	botonActualiza.setName("BotonActualiza");
	            	botonActualiza.setText("Actualizar");
	            	botonActualiza.setBounds(40, 400, 100, 25);   	            	
	            	botonActualiza.setVisible(true);
	            } catch (java.lang.Throwable ivjExc) {
	                ivjExc.printStackTrace();
	            }
	        }
	        return botonActualiza;
	    }
	
	 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBotonAceptar()) {
			this.setVisible(false);		
		}
		if (e.getSource() == getBotonActualiza()) {
			if(ejecutaProcesos()){ 
				EstatusFTP ft = new EstatusFTP(user, user); 
				ft.armadoDeArchivos();
			}
			this.setVisible(true);	
			
		}
	}
}
