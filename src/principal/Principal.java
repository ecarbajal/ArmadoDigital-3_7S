
package principal;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import javax.swing.ButtonGroup;

public class Principal extends javax.swing.JPanel implements ActionListener, WindowListener{


	private static final long serialVersionUID = 1L;
	public static String usuario = "";
	public static String cua; 
	private JButton botonEncarpetado;
	private JButton botonFusionPDF;
	private JButton botonSeparacionPDF;
	private JButton botonRenombrePDF;
	private JButton botonSolicitudPDF;
	private JButton botonObtenControl;
	private JLabel labelImagen_gnp;
	private JLabel labelArmado;
	private JLabel labelVersion;
	private JCheckBox ChkCert;
	private Map<String, String> users;
	private String nNegocio = "";
	private String nPoliza = "";
	private String nTarj = "";
	private String nCert = "";
	private String nCaraAseg = "";
	private String nCaraAgen = "";
	private String nRegi = "";
	private String nEndoPoli = "";
	private String nEndoAseg = "";
	private String nTipoEndo = "";
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAnio;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox comboBoxAnio;
	private JCheckBox ChkBN;
	private JCheckBox chckbxCambiarImportes;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Principal(){
		initialize();
	}

	private void initialize() {
		setName("Principal");		 
		setSize(560, 520);
		setLayout(null);
		this.add(getLabelArmado());
		this.add(getLabelVersion());
		//		this.add(getChkCert(), getChkCert().getName());

		this.add(getBotonEncarpetado());
		this.add(getBotonFusionPDF()); 
		this.add(getBotonSeparacionPDF()); 
		this.add(getBotonGeneraDocs()); 
		//		this.add(getCambiaImp(), getCambiaImp().getName()); 
		this.add(getImagen_gnp()); 
		this.add(getBotonSolicitudPDF()); 
		this.add(getBotonObtenControl()); 
		this.add(getCBMes());
		this.add(getCBDia());
		this.add(getCBAnio());
		//		this.add(getlblDia(),getlblDia().getName());
		this.add(getlblMes());
		this.add(getlblAnio());
		getCBDia().setVisible(false);
		getCBMes().setVisible(false);
		getCBAnio().setVisible(false);
		getlblMes().setVisible(false);
		getlblAnio().setVisible(false);
		getLabelArmado().setVisible(true);
		getLabelVersion().setVisible(true);
		//		getChkCert().setVisible(true);
		getChkCert().setSelected(false);
		getBotonEncarpetado().setVisible(true);
		getBotonFusionPDF().setVisible(true);
		getBotonSeparacionPDF().setVisible(true);
		getBotonGeneraDocs().setVisible(true);
		getBotonSolicitudPDF().setVisible(true);
		getBotonObtenControl().setVisible(true);
		getBotonSolicitudPDF().setEnabled(true);
		getChkCert().addActionListener(this);
		getCBDia().addActionListener(this);
		getCBMes().addActionListener(this);
		getCBAnio().addActionListener(this);
		getBotonEncarpetado().addActionListener(this);
		getBotonFusionPDF().addActionListener(this);
		getBotonSeparacionPDF().addActionListener(this);
		getBotonGeneraDocs().addActionListener(this);
		getBotonSolicitudPDF().addActionListener(this);
		getBotonObtenControl().addActionListener(this);
		// doLayout();
		setLayout(null);

		chckbxCambiarImportes = new JCheckBox("Cambiar Importes");
		buttonGroup.add(chckbxCambiarImportes);
		chckbxCambiarImportes.setBounds(345, 210, 155, 25);
		//		add(chckbxCambiarImportes);
		add(getChkBN());


		users = new HashMap<String, String>();
		Usuarios us = new Usuarios();
		users = us.recuperaUser();
	}

	public static void main(String[] args) {			
		Principal pr = new Principal();
		pr.setVisible(false);
		Acceso as = new Acceso();
		//			usuario =as.login();
		usuario ="x";
		if(!usuario.equals("")){
			pr.ejecutaPrincipal();
			pr.setVisible(true);
		}
	}


	public void ejecutaPrincipal(){
		try{
			javax.swing.JFrame frame = new javax.swing.JFrame();
			Principal vPrincipal;
			vPrincipal = new Principal();
			frame.getContentPane().add(vPrincipal);
			frame.setTitle("Sistema Armado Digital");
			//       frame.pack();           
			frame.setSize(vPrincipal.getSize());           
			frame.setVisible(true);
			frame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e) {
					System.exit(0);		
				}
			});
		} catch (Throwable exception) {
			System.err.println("Exception occurred in main()");
			exception.printStackTrace(System.out);
		}

	}

	JLabel getLabelArmado(){
		if (labelArmado == null) {
			try {
				labelArmado = new JLabel();
				labelArmado.setName("LabelArmado");
				Font font = new Font("Arial Rounded MT", Font.BOLD, 36);             	
				labelArmado.setFont(font);            	
				labelArmado.setText("ARMADO DIGITAL"); 
				labelArmado.setForeground(new Color(255,140,00));
				labelArmado.setBounds(100,20,400,50);
				labelArmado.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return labelArmado;
	}


	JLabel getLabelVersion(){
		if (labelVersion == null) {
			try {
				labelVersion = new JLabel();
				labelVersion.setName("LabelVersion");
				//            	Font font = new Font("Bauhaus 83", Font.BOLD, 16);  
				Font font = new Font("Tahoma", Font.BOLD, 16); 
				labelVersion.setFont(font);            	
				labelVersion.setText("V 3.7S"); 
				labelVersion.setForeground(new Color(255,140,00));
				labelVersion.setBounds(420,22,400,50);
				labelVersion.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return labelVersion;
	}

	JLabel getImagen_gnp(){
		if (labelImagen_gnp == null) {
			try {
				labelImagen_gnp = new JLabel();
				labelImagen_gnp.setName("LabelImagen_gnp"); 
				ImageIcon ima = new ImageIcon(".. \\..\\images\\logo_gnp.png");            	
				labelImagen_gnp.setIcon(ima); 
				labelImagen_gnp.setBounds(240,330,280,120);
				labelImagen_gnp.setVisible(true);
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return labelImagen_gnp;
	}
	JButton getBotonEncarpetado() {
		if (botonEncarpetado == null) {
			try {
				botonEncarpetado = new JButton();
				botonEncarpetado.setName("BotonEncarpetado");
				botonEncarpetado.setText("Encarpetado");
				botonEncarpetado.setBounds(35,260, 150, 25);                
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonEncarpetado;
	}

	JButton getBotonFusionPDF() {
		if (botonFusionPDF == null) {
			try {
				botonFusionPDF = new JButton();
				botonFusionPDF.setName("BotonFusionPDF");
				botonFusionPDF.setText("Unificar PDF's");
				botonFusionPDF.setBounds(35,360, 150, 25);    
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonFusionPDF;
	}

	JButton getBotonSeparacionPDF() {
		if (botonSeparacionPDF == null) {
			try {
				botonSeparacionPDF = new JButton();
				botonSeparacionPDF.setName("BotonSeparacionPDF");
				botonSeparacionPDF.setText("Separacion PDF");
				botonSeparacionPDF.setBounds(35,410, 150, 25);    
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonSeparacionPDF;
	}


	JButton getBotonGeneraDocs() {
		if (botonRenombrePDF == null) {
			try {
				botonRenombrePDF = new JButton();
				botonRenombrePDF.setName("BotonRenombrePDF");
				botonRenombrePDF.setText("Genera Documentos");
				botonRenombrePDF.setBounds(35,210, 150, 25);             	
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonRenombrePDF;
	}



	JButton getBotonSolicitudPDF() {
		if (botonSolicitudPDF == null) {
			try {
				botonSolicitudPDF = new JButton();
				botonSolicitudPDF.setName("BotonSolicitudPDF");
				botonSolicitudPDF.setText("Solicitud");
				botonSolicitudPDF.setBounds(35,110, 150, 25);             	
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonSolicitudPDF;
	}


	JButton getBotonObtenControl() {
		if (botonObtenControl == null) {
			try {
				botonObtenControl = new JButton();
				botonObtenControl.setName("BotonObtenControl");
				botonObtenControl.setText("Status");
				botonObtenControl.setBounds(35,160, 150, 25);             	
			} catch (java.lang.Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return botonObtenControl;
	}


	public JComboBox getCBDia(){
		if(comboBoxDia == null){
			comboBoxDia  = new JComboBox(); 
			comboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBoxDia.setBounds(240, 260, 42, 22);
		}
		return comboBoxDia;
	}

	public JComboBox getCBMes(){
		if(comboBoxMes == null){
			comboBoxMes  = new JComboBox(); 
			comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			comboBoxMes.setBounds(335, 260, 42, 22);
		}
		return comboBoxMes;
	}

	public JComboBox getCBAnio(){
		if(comboBoxAnio == null){
			comboBoxAnio  = new JComboBox(); 
			comboBoxAnio.setModel(new DefaultComboBoxModel(new String[] {"", "2015", "2016"}));
			comboBoxAnio.setBounds(420, 260, 62, 22);
		}
		return comboBoxAnio;
	}

	JCheckBox getChkCert() {
		if (this.ChkCert == null) {
			try {
				this.ChkCert = new JCheckBox();
				this.ChkCert.setName("ChkCert");
				this.ChkCert.setBounds(46, 257, 20, 25);
			}
			catch (Throwable var1_1) {
				// empty catch block
			}
		}
		return this.ChkCert;
	}

	public JLabel getlblDia(){
		if(lblDia == null){
			lblDia = new JLabel("Certificados a partir del Día: ");
			lblDia.setFont(new Font("Arial", Font.BOLD, 12));
			lblDia.setBounds(75, 263, 170, 16);
		}
		return lblDia;
	}

	public JLabel getlblMes(){
		if(lblMes == null){
			lblMes = new JLabel("Mes: ");
			lblMes.setFont(new Font("Arial", Font.BOLD, 12));
			lblMes.setBounds(295, 260, 42, 16);
		}
		return lblMes;
	}

	public JLabel getlblAnio(){
		if(lblAnio == null){
			lblAnio = new JLabel("Año: ");
			lblAnio.setFont(new Font("Arial", Font.BOLD, 12));
			lblAnio.setBounds(385, 260, 56, 16);
		}
		return lblAnio;
	}


	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == getChkCert()){
			if (getChkCert().isSelected()){
				getCBDia().setVisible(true);
				getCBMes().setVisible(true);
				getCBAnio().setVisible(true);
				getlblMes().setVisible(true);
				getlblAnio().setVisible(true);	


			}else{
				getCBDia().setVisible(false);
				getCBMes().setVisible(false);
				getCBAnio().setVisible(false);
				getlblMes().setVisible(false);
				getlblAnio().setVisible(false);
			}
		}



		if (e.getSource() == getBotonEncarpetado()) {
			Encarpetado en1 = new Encarpetado();
			//en1.lecturaPDF(en1.selecArchivo());
			en1.setVisible(true);			
		}
		if(e.getSource() == getBotonSolicitudPDF()){
			try{
				String line;				
				nNegocio="";
				File f = new File(CtsArmado.ArchTar+"SolicitudesR.txt");
				BufferedReader br = new BufferedReader(new FileReader(f));	
				nNegocio="";
				if(((line = br.readLine()) != null)){
					nNegocio=line.substring(31, (line.length())).trim() ;
					System.out.println(nNegocio);
				} 
				br.close();

			}catch(Exception ex){
				//	ex.printStackTrace();
			}
			//

			Solicitud sl1 = new Solicitud();
			sl1.setUsuario(usuario , nNegocio, cua);
			sl1.setVisible(true);
		}		

		if(e.getSource() == getBotonFusionPDF()) {
			try{
				Union un = new Union();				
				un.setVisible(true);
				System.out.println("Fin Union PDF's"); 
			}catch(Exception ignored){}
		}		
		if(e.getSource() == getBotonSeparacionPDF()) {
			DividirPDF div = new DividirPDF();
			div.divPDF(div.selecArchivo());

		}

		if(e.getSource() == getBotonGeneraDocs()) { 
			try {
				if(chckbxCambiarImportes.isSelected()){
					IngresaMontos mon = new IngresaMontos();
					mon.setVisible(true);
				}else{

					generaDocs(nCaraAgen="", nCaraAgen="", nCaraAgen="", nCaraAgen="", nCaraAgen="");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}

			//			try{
			//				if(getChkCert().isSelected()){
			//					if (getCBAnio().getSelectedItem().toString().equals("") && getCBMes().getSelectedItem().toString().equals("") && getCBDia().getSelectedItem().toString().equals("")){
			//						String st="Complete campos de Día, Mes y Año";
			//						JOptionPane.showMessageDialog(null,st);
			//					}else{
			//						String fechaini = "";
			//						fechaini = getCBAnio().getSelectedItem().toString() + getCBMes().getSelectedItem().toString() + getCBDia().getSelectedItem().toString();
			//						Calendar c = new GregorianCalendar();
			//						String dia = Integer.toString(c.get(Calendar.DATE));
			//						String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
			//						if(mes.length()==1)
			//							mes="0"+mes;
			//						String annio = Integer.toString(c.get(Calendar.YEAR));
			//						String fechaact = annio + mes + dia;
			//						File f = new File(CtsArmado.ArchSal);
			//						BufferedReader br = new BufferedReader(new FileReader(f));	
			//						String line = "";
			//						line = br.readLine();
			//						int cont = 0;
			//						while (line != null){
			//							String fechaalta = line.substring(425,line.length());
			//							int fecsol = Integer.parseInt(fechaini);
			//							int fecalta = Integer.parseInt(fechaalta);
			//							int fecact = Integer.parseInt(fechaact);
			//							if (fecsol >= fecalta){
			//								CreaTarjeta rn = new CreaTarjeta(nNegocio);
			//								rn.TarjetasLinea(line);
			//								line=br.readLine();
			//								cont++;
			//							}else{
			//								line=br.readLine();
			//
			//							}
			//						}		
			//					}	
			//				}else{
			//					generaDocs();
			//				}
			//			}catch(Exception ex){
			//				System.out.println("Error en Generación de documentos ");
			//				//			ex.printStackTrace();
			//			}
		}	

		//		Ejecuto el bat
		if(e.getSource() == getBotonObtenControl()) { 
			try{
				Status stus = new Status(users.get(usuario));
				stus.setVisible(true);
				EstatusFTP ft = new EstatusFTP(users.get(usuario), users.get(usuario)); 
				ft.armadoDeArchivos();
			}catch(Exception ignored){}
		}
	}


	private void borrarArc(String dir){
		File fs = new File(dir);
		if (fs.isDirectory()) {		
			String[] ficheros = fs.list();
			for (int x=0;x<ficheros.length;x++){
				borrarArc(dir +"\\"+ ficheros[x]);				
			}
			if(fs.delete()){
				System.out.println("Carpeta borrada " + dir);				
			}	
		}else{
			if(fs.delete()){
				System.out.println("Archivo borrado " + dir);				
			}		
		}		
	}

	public void generaDocs(String primNeta, String derPoliza, String primTotal, String totalPagar, String importePrem) throws IOException, DocumentException{
		String line;				

		String st1="     Generando Documentos... \n Presione Aceptar para continuar";
		JOptionPane.showMessageDialog(null,st1);
		File f = new File(CtsArmado.ArchTar+"SolicitudesR.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));	
		try {
			if(((line = br.readLine()) != null)){

				nNegocio=line.substring(31, (line.length())).trim();
				nPoliza=(line.substring(0, 8).trim());
				nTipoEndo = (line.substring(10, 11).trim());
				nTarj=(line.substring(21, 22).trim());
				nCert=(line.substring(19, 20).trim());
				nCaraAseg=(line.substring(17, 18).trim());
				nCaraAgen=(line.substring(18, 19).trim());
				nRegi=(line.substring(20, 21).trim());
				nEndoPoli=(line.substring(22, 23).trim());
				nEndoAseg=(line.substring(23, 24).trim());

				System.out.println("Nego: " + nNegocio);
				System.out.println("nTarj: " + nTarj);
				System.out.println("nCert: " + nCert);
				System.out.println("nCaraAseg: " + nCaraAseg);
				System.out.println("nCaraAgen: " + nCaraAgen);
				System.out.println("nRegi: " + nRegi);
				System.out.println("nEndoPoli: " + nEndoPoli);
				System.out.println("nEndoAseg: " + nEndoAseg);


				String arcOrig = CtsArmado.pathSal+nNegocio; //vrlborra
				System.out.println("arcOrig: " + arcOrig);
				borrarArc(arcOrig);	

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();

		if(getChkBN().isSelected()){
			long time_start = System.currentTimeMillis();
			nNegocio = nNegocio + "_B&N";
			CreaTarjeta rn = new CreaTarjeta(nNegocio);
			CreaTarjetaAPF rn1 = new CreaTarjetaAPF(nNegocio);
			CreaCaratulaCteBN rm = new CreaCaratulaCteBN (nNegocio);
			CreaCaratulaAgeBN rr = new CreaCaratulaAgeBN (nNegocio);
			CreaCertificadoBN rp = new CreaCertificadoBN(nNegocio, nPoliza);
			CreaRegistroBN rq = new CreaRegistroBN(nNegocio);
			CreaEndosoBN rs = new CreaEndosoBN(nNegocio);
			CreaRegistro_endBN ro = new CreaRegistro_endBN (nNegocio);
			CreaCaratulaAPBN rt = new CreaCaratulaAPBN(nNegocio);
			CreaCertificadoLAIBN cl = new CreaCertificadoLAIBN(nNegocio, nPoliza);


			//Valida que tipo de archivo es de entrada normal =425
			String entrada = CtsArmado.ArchSalControl + "GeneraTarjetas.txt";
			f = new File(entrada);
			br = new BufferedReader(new FileReader(f)); 
			String line2 = ""; 
			int longitudReg = 0; 
			line2 = br.readLine();
			longitudReg = line2.length();
			System.out.println("Longitud entrada: " + longitudReg);
			System.out.println("nNegocio: " + nNegocio);

			if (nCaraAseg.equals("X")) {
				System.out.println("Voy a Caratulas Asegurado BN");
				rm.creaCaratulaColor("");
				rt.creaCaratulaColor("");
			}

			if (nCaraAgen.equals("X")) {
				System.out.println("Voy a Caratulas Agente BN");
				rr.creaCaratulaColor("");
			}

			if (nCert.equals("X")) {
				System.out.println("Voy a Certificados BN");
				rp.creaCertif("");
				cl.creaCertif("");
			}


			if (nRegi.equals("X")) {
				System.out.println("Voy Registro BN");
				ro.creaRegis_end("");
				rq.creaRegis("");
			}

			if (nEndoPoli.equals("X")) {
				System.out.println("Voy Endosos BN");
				rs.creaEndos("");
			}

			if (nEndoAseg.equals("X")) {
				System.out.println("Voy Endosos BN");
				rs.creaEndos("");
			}

			//						if (nTarj.equals("FASE2")) {
			if (nTarj.equals("X")) {
				//						if (nNegocio.equals("TARJETASAPF")) {
				if (longitudReg >= 425) {
					System.out.println("Voy a Tarjetas normales");
					rn.CreaPDF("");
				} else {
					System.out.println("Voy a Tarjetas APF");
					rn1.CreaPDFAPF("");
				}

			}
			long time_end = System.currentTimeMillis();
			String st= ((new StringBuilder("       Documentación Terminada \nTiempo total del proceso: ")).append((time_end - time_start) / 1000L).toString()) + " segundos.";
			JOptionPane.showMessageDialog(null,st);


		}else{
			long time_start = System.currentTimeMillis();
			CreaTarjeta rn = new CreaTarjeta(nNegocio);
			CreaTarjetaAPF rn1 = new CreaTarjetaAPF(nNegocio);
			CreaCaratulaCte rm = new CreaCaratulaCte(nNegocio, primNeta,  derPoliza,  primTotal,  totalPagar, importePrem);
			CreaCaratulaAge rr = new CreaCaratulaAge(nNegocio, primNeta,  derPoliza,  primTotal,  totalPagar, importePrem);
			CreaCertificado rp = new CreaCertificado(nNegocio, nPoliza);
			CreaRegistro rq = new CreaRegistro(nNegocio);
			CreaEndoso rs = new CreaEndoso(nNegocio);
			CreaEndosoMovAD rad = new CreaEndosoMovAD(nNegocio);
			CreaEndosoMovB rb = new CreaEndosoMovB(nNegocio);
			CreaRegistro_end_baja rob = new CreaRegistro_end_baja(nNegocio);
			CreaRegistro_end ro = new CreaRegistro_end(nNegocio);
			CreaCaratulaAPAsegurado rt = new CreaCaratulaAPAsegurado(nNegocio);
			CreaCaratulaAPAgente at = new CreaCaratulaAPAgente(nNegocio);
			CreaCertificadoLAI cl = new CreaCertificadoLAI(nNegocio, nPoliza);

			//Valida que tipo de archivo es de entrada normal =425
			String entrada = CtsArmado.ArchSalControl + "GeneraTarjetas.txt";
			f = new File(entrada);
			br = new BufferedReader(new FileReader(f)); 
			String line2 = ""; 
			int longitudReg = 0; 
			line2 = br.readLine();
			if(line2 != null){
				longitudReg = line2.length();
			}else{
				longitudReg=0;
			}
			boolean flagCar = false;
			System.out.println("Longitud entrada: " + longitudReg);
			System.out.println("nNegocio: " + nNegocio);

			if (nCaraAseg.equals("X")) {
				System.out.println("Voy a Caratulas Asegurado ");
				rm.creaCaratulaColor("");
				flagCar = rt.creaCaratulaColor("");
			}

			if (nCaraAgen.equals("X")) {
				System.out.println("Voy a Caratulas Agente ");
				rr.creaCaratulaColor("");
				at.creaCaratulaColor("");
			}

			if (nCert.equals("X")) {
				System.out.println("Voy a Certificados ");
				if(flagCar == false){
					rp.creaCertif("");
					cl.creaCertif("");
				}
			}

			if(nTipoEndo.equals("1")){	
				System.out.println("Voy a Endosos A");
				rad.creaEndos("");
				ro.creaRegis_end("");
			}else if(nTipoEndo.equals("2")){
				System.out.println("Voy a Endosos D");
				rob.creaRegis_end("");
				rad.creaEndos("");

			} else if (nTipoEndo.equals("3")){
				System.out.println("Voy a Endosos B");
				rb.creaEndos("");

			}

			if (nEndoPoli.equals("X")) {
				System.out.println("Voy Endosos ");
				rs.creaEndos("");
			}

			if (nEndoAseg.equals("X")) {
				System.out.println("Voy Endosos ");
				rs.creaEndos("");
			}
			
			if (nRegi.equals("X")) {
				System.out.println("Voy Registro ");
				rq.creaRegis("");
			}


			//					if (nTarj.equals("FASE2")) {
			if (nTarj.equals("X")) {
				//					if (nNegocio.equals("TARJETASAPF")) {
				if (longitudReg >= 425) {
					System.out.println("Voy a Tarjetas normales");
					rn.CreaPDF("");
				} else {
					System.out.println("Voy a Tarjetas APF");
					rn1.CreaPDFAPF("");
				}

			}
			long time_end = System.currentTimeMillis();
			//     		System.out.println((new StringBuilder("Tiempo total del proceso: ")).append((time_end - time_start) / 1000L).toString());


			String st= ((new StringBuilder("       Documentación Terminada \nTiempo total del proceso: ")).append((time_end - time_start) / 1000L).toString()) + " segundos.";
			JOptionPane.showMessageDialog(null,st);


		}

	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}
	private JCheckBox getChkBN() {
		if (ChkBN == null) {
			ChkBN = new JCheckBox("Genera en B/N");
			buttonGroup.add(ChkBN);
			ChkBN.setBounds(224, 210, 113, 25);
		}
		return ChkBN;
	}
}
