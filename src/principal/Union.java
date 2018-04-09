package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Union extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel labelCheck;
	private JLabel labelPath;
	private JLabel labelCond;	
	private JCheckBox ChkCon;
	private JTextField textCond;
	private JTextField textPath;
	private JButton botonCond;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JButton botonCarpeta;
	private JPanel panel1;
	private String arc;

	public Union(){
		inicializar();
	}

	void inicializar(){

		setName("Union");
		setSize(460, 420);
		setTitle("Unificar PDF's");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		add(getPanel1());
		getPanel1().add(getTextPath(), getTextPath().getName());
		getPanel1().add(getTextCond(), getTextCond().getName());
		getPanel1().add(getChkCon(), getChkCon().getName());
		getPanel1().add(getLabelCheck(), getLabelCheck().getName());
		getPanel1().add(getBotonAceptar(), getBotonAceptar().getName());
		getPanel1().add(getBotonCancelar(), getBotonCancelar().getName());
		getPanel1().add(getLabelCond(), getLabelCond().getName());
		getPanel1().add(getLabelPath(), getLabelPath().getName());       
		getPanel1().add(getBotonCond(), getBotonCond().getName());
		getPanel1().add(getBotonCarpeta(), getBotonCarpeta().getName());
		add(getPanel1(), getPanel1().getName());
		getChkCon().setVisible(true);
		getLabelCheck().setVisible(true);
		getBotonAceptar().setVisible(true);
		getBotonCancelar().setVisible(true);
		getBotonCond().setVisible(true);
		getLabelCond().setVisible(true);
		getLabelPath().setVisible(true);
		getTextCond().setVisible(true);
		getBotonCarpeta().setVisible(true);
		getPanel1().setVisible(true);

		getBotonAceptar().addActionListener(this);
		getBotonCancelar().addActionListener(this); 
		getChkCon().addActionListener(this);
		getBotonCond().addActionListener(this);
		getBotonCarpeta().addActionListener(this);
	}

	JTextField getTextCond() {
		if (textCond == null) {
			try {
				textCond = new JTextField();
				textCond.setName("textCond");  
				textCond.setSize(400,23);
				textCond.setLocation(10, 160);            	
				textCond.setVisible(true);
				textCond.setEnabled(false);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return textCond;
	}	

	JTextField getTextPath() {
		if (textPath == null) {
			try {
				textPath = new JTextField();
				textPath.setName("textPath");  
				textPath.setSize(400,23);
				textPath.setLocation(10, 50);            	
				textPath.setVisible(true);            	
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return textPath;
	}	

	JLabel getLabelPath() {
		if (labelPath == null) {
			try {
				labelPath = new JLabel();
				labelPath.setName("labelPath");
				labelPath.setText("Seleccion a Nivel CARPETA para fusionar los PDF's");
				labelPath.setSize(300,23);
				labelPath.setLocation(10, 20);            	
				labelPath.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return labelPath;
	}	

	JLabel getLabelCond() {
		if (labelCond == null) {
			try {
				labelCond = new JLabel();
				labelCond.setName("labelCond");
				labelCond.setText("Ruta del Documento a Incluir");
				labelCond.setSize(200,23);
				labelCond.setLocation(10, 130);            	
				labelCond.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return labelCond;
	}	

	JPanel getPanel1() {
		if (panel1 == null) {
			try {
				panel1 = new JPanel();
				panel1.setName("panel1");             	  
				panel1.setBounds(0, 0, 460, 420);            	    
				panel1.setLayout(null);  
				panel1.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return panel1;
	}	

	JCheckBox getChkCon() {
		if (ChkCon == null) {
			try {
				ChkCon = new JCheckBox();
				ChkCon.setName("ChkCon");            	
				ChkCon.setBounds(10, 100, 20, 25);            	
				ChkCon.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return ChkCon;
	}


	JLabel getLabelCheck() {
		if (labelCheck == null) {
			try {
				labelCheck = new JLabel();
				labelCheck.setName("labelCheck"); 
				labelCheck.setText("Incluir Documento");  
				labelCheck.setBounds(30, 100, 200, 25);            	
				labelCheck.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return labelCheck;
	}

	JButton getBotonCarpeta() {
		if (botonCarpeta == null) {
			try {
				botonCarpeta = new JButton();
				botonCarpeta.setName("botonCarpeta");
				botonCarpeta.setText("...");
				botonCarpeta.setBounds(410, 50, 23, 23);   	            	
				botonCarpeta.setVisible(true);            	
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonCarpeta;
	}

	JButton getBotonCond() {
		if (botonCond == null) {
			try {
				botonCond = new JButton();
				botonCond.setName("botonCond");
				botonCond.setText("...");
				botonCond.setBounds(410, 160, 23, 23);   	            	
				botonCond.setVisible(true);
				botonCond.setEnabled(false);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonCond;
	}

	JButton getBotonCancelar() {
		if (botonCancelar == null) {
			try {
				botonCancelar = new JButton();
				botonCancelar.setName("BotonCancelar");
				botonCancelar.setText("Cancelar");
				botonCancelar.setBounds(150, 220, 100, 25); 	            	
				botonCancelar.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonCancelar;
	}

	JButton getBotonAceptar() {
		if (botonAceptar == null) {
			try {
				botonAceptar = new JButton();
				botonAceptar.setName("BotonAceptar");
				botonAceptar.setText("Aceptar");
				botonAceptar.setBounds(28, 220, 100, 25);   	            	
				botonAceptar.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonAceptar;
	}


	public void creaFusion(String Arc, String con, boolean chk){
		String[] nomArc = new String[3];	
		try{		
			File fr = new File(Arc);
			if(!fr.exists()){
				fr.mkdir();
			}
			if (fr.isDirectory()) {		
				String[] ficheros = fr.list();		
				for (int x=0;x<ficheros.length;x++){
					File f2 = new File(Arc + "\\" +ficheros[x]);
					if(f2.isDirectory()){
						creaFusion(Arc + "\\" +ficheros[x], Arc, chk);
					} else{
						nomArc = fusion(Arc,con,chk);						
						x=ficheros.length;	
					}
				}	
			}		
		}catch(Exception exc){
			exc.printStackTrace();
		}		
	}


	void creaFusion2(String Arc, String con, boolean chk){
		try{		
			File fr = new File(Arc);	
			if (fr.isDirectory()) {		
				String[] ficheros = fr.list();		
				for (int x=0;x<ficheros.length;x++){
					File f2 = new File(Arc + "\\" +ficheros[x]);
					if(f2.isDirectory()){
						creaFusion2(Arc + "\\" +ficheros[x], con, chk);
					} else{
						if((Arc.indexOf("_Cert_")>0)||(Arc.indexOf("_Tarj_")>0)){
							fusion2(Arc,con,chk);
						} else{
							fusion2(Arc,con,chk);	
						}
						x=ficheros.length;
					}
				}
			}		
		}catch(Exception exc){
			exc.printStackTrace();
		}		
	}
	
	void creaFusion3(String Arc, String poliza, boolean chk){
		try{		
			File fr = new File(Arc);	
			if (fr.isDirectory()) {		
				String[] ficheros = fr.list();		
				for (int x=0;x<ficheros.length;x++){
					File f2 = new File(Arc + "\\" +ficheros[x]);
					if(f2.isDirectory()){
						creaFusion3(Arc + "\\" +ficheros[x], poliza, chk);
					} else{
							fusion3(Arc,poliza,chk);	
							x=ficheros.length;
					}
				}
			}		
		}catch(Exception exc){
			exc.printStackTrace();
		}		
	}

	void fusion2(String dir, String dirCon, boolean con) throws Exception{				
		File fd = new File(dir);						
		System.out.println(dir);
		borrarArc(dir+"\\Fusionado_de_Carpeta.pdf");
		String[] fic = fd.list();
		List<InputStream> pdfs = new ArrayList<InputStream>();			
		if(con){
			pdfs.add(new FileInputStream(dirCon));
		}
		for (String aFic : fic) {
			File fe = new File(aFic);
			pdfs.add(new FileInputStream(dir + "\\" + fe));
		}
		OutputStream output;
		String nomArchivo = dir+"\\Fusionado_de_Carpeta.pdf";
		output = new FileOutputStream(nomArchivo);	
		MergePDF.concatPDFs(pdfs, output);
	}
	
	void fusion3(String dir, String poliza, boolean con) throws Exception{				
		File fd = new File(dir);						
		System.out.println(dir);
		String[] fic = fd.list();
		List<InputStream> pdfs = new ArrayList<InputStream>();			
		for (String aFic : fic) {
			File fe = new File(aFic);
			pdfs.add(new FileInputStream(dir + "\\" + fe));
		}
		OutputStream output;
		String nomArchivo = CtsArmado.pathsal+"\\Hoja_de_Estatus_" + poliza + ".pdf";
		output = new FileOutputStream(nomArchivo);	
		MergePDF.concatPDFs(pdfs, output);
	}

	String[] fusion(String dir, String dirCon, boolean con) throws Exception{
		String[] nomArchivo = new String[3];			
		File fd = new File(dir);
		String[] fic = fd.list();
		String arcBorrado = "";
		System.out.println(dir);
		for (String aFic : fic) {
			if (aFic.toString().indexOf("A") == 8) {
				arcBorrado = aFic.toString();
				borrarArc(dir + "\\" + aFic);
			}
		}
		String datosA[] = new String[6];			
		List<InputStream> pdfs = new ArrayList<InputStream>();
//		if(con){
//			pdfs.add(new FileInputStream(dirCon));
//		}
		boolean cer = false;
		for (String aFic : fic) {
			System.out.println(aFic.toString());			
			if (!aFic.toString().equals(arcBorrado)) {
				if (aFic.indexOf("_Cert") > 0) {
					datosA = aFic.split("_");
					cer=true;
				}
				if(cer){
					File fe = new File(aFic);
					pdfs.add(new FileInputStream(dir + "\\"+ fe));
				}
			}
		}
		OutputStream output;
		
		//			 if(con){
		//				 nomArchivo[0] = dir+"\\"+datosA[0]+"_"+datosA[1]+"_COND_CERTIFICADO y TARJETAS_" + datosA[3];
		//				 nomArchivo[1] = datosA[3];
		//				 nomArchivo[2] = datosA[1];
		//				  output = new FileOutputStream(nomArchivo[0]);				  
		//			 }else{
		if(datosA[0]!=null){
		nomArchivo[0] = dirCon+"\\" + datosA[1]+" " + datosA[3];
		output = new FileOutputStream(nomArchivo[0]);
		nomArchivo[1] = datosA[3];
		nomArchivo[2] = datosA[1];
		//			 }
		MergePDF.concatPDFs(pdfs, output);
		output.close();
		}

		//			 renombrePDF(nomArchivo[0], nomArchivo[1], nomArchivo[2]);

//		for (String aFic : fic) {
//			if (aFic.toString().indexOf("A") != 8) {
//				arcBorrado = aFic.toString();
//				borrarArc(dir + "\\" + aFic);
//			}
//		}
//		fd.delete();
		
			
		
		borrarArc1(dir);
		
		return nomArchivo;
	}

	String selecDirectorio(){
		JFileChooser filechoose = new JFileChooser("C:\\");
		filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		filechoose.showOpenDialog(null);	        
		File file = filechoose.getSelectedFile();                  
		if(file.exists()){  
			return file.getAbsolutePath();
		}else{
			System.out.println("No se encontro el Directorio");
		}
		return null;
	}

	String selecArchivo(){
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

	void setArc(String arc){
		this.arc = arc;
	}

	String getArc(){
		return arc;
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBotonAceptar()) {				
			try{

				System.out.println("       Iniciando la fusión");
				JOptionPane.showMessageDialog(null, "   Iniciando fusión de la carpeta \nPresione Aceptar para Continuar", "Fusión PDF´s", JOptionPane.INFORMATION_MESSAGE);
				
				creaFusion2(getArc(), getTextCond().getText(), getChkCon().isSelected());
				
				System.out.println("      Finalizó la fusión");
				JOptionPane.showMessageDialog(null, "Finalizó la fusión de la carpeta", "Fusión PDF´s", JOptionPane.INFORMATION_MESSAGE);

			}catch(Exception ignored){}
		}
		if (e.getSource() == getBotonCancelar()) {
			this.setVisible(false);

		}
		if (e.getSource() == getChkCon()) {
			if(getChkCon().isSelected()){
				getTextCond().setEnabled(true);
				getBotonCond().setEnabled(true);
			}else{
				getTextCond().setEnabled(false);
				getBotonCond().setEnabled(false);
				getTextCond().setText("");					
			}				
		}
		if(e.getSource() == getBotonCond()) {
			getTextCond().setText(selecArchivo());
		}
		if(e.getSource() == getBotonCarpeta()) {
			getTextPath().setText(selecDirectorio());
			setArc(getTextPath().getText());
		}
	}

	private void borrarArc(String dir){
		File fs = new File(dir);
					if(fs.exists()){
						if(fs.delete()){
							System.out.println("Archivo borrado " + dir);				
					}		
				}
	}
	
	
	private void borrarArc1(String dir){
		File fs = new File(dir);
		if (fs.isDirectory()) {		
			String[] ficheros = fs.list();
			for (int x=0;x<ficheros.length;x++){
				borrarArc1(dir +"\\"+ ficheros[x]);				
			}
			if(fs.delete()){
				System.out.println("Carpeta borrado " + dir);				
			}
		}else{
			if(fs.delete()){
				System.out.println("Archivo borrado " + dir);				
			}		
		}		
	}	
		//		private void renombrePDF(String Archivo1, String nombre, String certificado){
		//			boolean correcto = false;
		//			File f1 = new File(Archivo1);
		//			String path = Archivo1.substring(0,Archivo1.lastIndexOf("\\"));
		//			String Archivo2 = path + "\\" + certificado + "_" + nombre + ".pdf";
		//			File f2 = new File(Archivo2);
		//			correcto = f1.renameTo(f2);
		//			if (correcto){
		//		        System.out.println("El renombrado ha sido correcto");		        
		//		    }else{
		//		        System.out.println("El renombrado no se ha podido realizar");
		//		    }		    
		//		}


	}
