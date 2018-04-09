package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RenombrarPDF extends javax.swing.JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton botonAceptar;
	private JButton botonCancelar;
	private JTextField textNomArc;
	private JLabel labelNomArc;
	private String archivo;	
	private javax.swing.JFrame frame;

	void inicializar(){
		
		setName("RenombrarPDF");
        setSize(460, 220); 
        setLayout(null);
        add(getLabelNomArc(), getLabelNomArc().getName());
        add(getTextNomArc(), getTextNomArc().getName());
        add(getBotonAceptar(), getBotonAceptar().getName());
        add(getBotonCancelar(), getBotonCancelar().getName());
        getLabelNomArc().setVisible(true);
        getTextNomArc().setVisible(true);
        getBotonAceptar().setVisible(true);
        getBotonCancelar().setVisible(true);
        getBotonAceptar().addActionListener(this);
        getBotonCancelar().addActionListener(this);         
	}
	
	public void renombra(String archivo){        
        frame = new javax.swing.JFrame();
        RenombrarPDF vRenombrarPDF;
		vRenombrarPDF = new RenombrarPDF();
        frame.getContentPane().add("Center", vRenombrarPDF);
        frame.setSize(vRenombrarPDF.getSize()); 
        frame.setVisible(true);
        vRenombrarPDF.setArc(archivo);
	}
	
	JLabel getLabelNomArc() {
        if (labelNomArc == null) {
            try {
            	labelNomArc = new JLabel();
            	labelNomArc.setName("labelNomArc"); 
            	labelNomArc.setText("Nuevo Nombre de Archivo");  
            	labelNomArc.setBounds(30, 20, 200, 25);            	
            	labelNomArc.setVisible(true);
            } catch (java.lang.Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return labelNomArc;
    }
	
	JTextField getTextNomArc() {
        if (textNomArc == null) {
            try {
            	textNomArc = new JTextField();
            	textNomArc.setName("TextNomArc");            	
            	textNomArc.setBounds(28, 50, 250, 25);             
            	textNomArc.setVisible(true);
            } catch (java.lang.Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return textNomArc;
    }
	
	 JButton getBotonAceptar() {
	        if (botonAceptar == null) {
	            try {
	            	botonAceptar = new JButton();
	            	botonAceptar.setName("BotonAceptar");
	            	botonAceptar.setText("Aceptar");
	            	botonAceptar.setBounds(28, 120, 100, 25);   	            	
	            	botonAceptar.setVisible(true);
	            } catch (java.lang.Throwable ivjExc) {
	                ivjExc.printStackTrace();
	            }
	        }
	        return botonAceptar;
	    }
	 
	 JButton getBotonCancelar() {
	        if (botonCancelar == null) {
	            try {
	            	botonCancelar = new JButton();
	            	botonCancelar.setName("BotonCancelar");
	            	botonCancelar.setText("Cancelar");
	            	botonCancelar.setBounds(150, 120, 100, 25); 	            	
	            	botonCancelar.setVisible(true);
	            } catch (java.lang.Throwable ivjExc) {
	                ivjExc.printStackTrace();
	            }
	        }
	        return botonCancelar;
	    }
	
	
	
	public String selecArchivo(){
		JFileChooser filechoose = new JFileChooser("C:\\");
        filechoose.showOpenDialog(null);
        File file = filechoose.getSelectedFile();                  
        if(file.exists()){  
        	return file.getAbsolutePath();
        }else{
        	System.out.println("No se encontro el Archivo");
        }
        return null;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBotonAceptar()) {
			boolean correcto = false;			
			if(!getTextNomArc().getText().equals("")){
				String path=getArc().substring(0, getArc().lastIndexOf("\\"));
				File f1=new File(archivo);
				File f2=new File(path + "\\" + getTextNomArc().getText());
				correcto = f1.renameTo(f2);
			}
		    if (correcto){
		        System.out.println("El renombrado ha sido correcto");		        
		    }else{
		        System.out.println("El renombrado no se ha podido realizar");
		    }		    
		    frame.setVisible(false);		    
		}
		if (e.getSource() == getBotonCancelar()) {
			System.out.println(frame.getParent().getName());
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
		}
	}	
	
	void setArc(String archivo){
		this.archivo = archivo;
	}
	
	String getArc(){
		return this.archivo;
	}
}
