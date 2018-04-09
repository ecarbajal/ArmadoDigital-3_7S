package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class CreaCaratulaAge {

	public static final String plantilla = CtsArmado.pathJar + "Plantilla GM06 Color.pdf";
	public static final String plantillaAP = CtsArmado.pathJar + "Plantilla AP AZ61.pdf";
	public static String pathSal = CtsArmado.pathSal;
	public static final String path = CtsArmado.pathSpool + "Spool_Carat_Agen.txt";

	int contCar = 0;
	int largoArreg = 0;	
	int Periodo = 0;
	double ComTotal = 0.00;
	String sComTotal = "";
	double ComPar=0.00;
	String sComPar= "";
	double PrimaNeta = 0.00;
	double Comision = 0.00;
	String poliza = "";
	String Pago = "";
	String sPrimaNeta = "";
	String sComision = "";
	String com1 = "";
	String com2 = "";
	String com3 = "";
	String com4 = "";
	String primNeta = "", derPoliza="", primTotal="", totalPagar= "", importePrem="";


	public CreaCaratulaAge(String nNegocio, String primNeta, String derPoliza, String primTotal, String totalPagar, String importePrem) {
		pathSal = CtsArmado.pathSal;
		pathSal  = pathSal + nNegocio;
		this.primNeta = primNeta;
		this.derPoliza = derPoliza;
		this.primTotal = primTotal;
		this.totalPagar = totalPagar;
		this.importePrem = importePrem;
	}

	public static void main(String[] args) {
		try{
			CreaCaratulaAge cc = new CreaCaratulaAge("","","","","","");		
			cc.creaCaratulaColor(path);
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (DocumentException e) {			
			e.printStackTrace();
		}
	}

	public void creaCaratulaColor(String file) throws IOException, DocumentException{
		File f = null;
		String line = "";

		file=path;
		int cont = 0;
		boolean flag = true;
		String datos[] = new String[73];
		f = new File(file);
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader(f));    
		br.readLine(); 

		while(flag){
			cont=0;
			br.readLine();
			if((line = br.readLine()) == null){
				break;
			}
			while(line.trim().indexOf("17 ")<0){
				line = br.readLine();			
			}
			datos[cont]=line.substring(1, line.length());
			cont++;
			while(((line = br.readLine()) != null)&&(cont<73) ){

				if(line.length()>0){
					datos[cont]=line.substring(1, line.length());

					if(cont == 8){
						if(line.length()>0 && line.length()<135){
							Pago = line.substring(55, 80).trim();
							if(Pago.indexOf("MENSUAL")>-1){
								Periodo = 12;
							}else if(Pago.indexOf("TRIMESTRAL")>-1){
								Periodo = 4;
							}else if(Pago.indexOf("SEMESTRAL")>-1){
								Periodo = 2;
							}else if(Pago.indexOf("ANUAL")>-1){
								Periodo = 1;
							}
						}
					}

					if(cont == 28){
						this.largoArreg = line.length();
						if (largoArreg < 10)
						{
							sPrimaNeta = "0.00";
							sPrimaNeta = sPrimaNeta.replaceAll(",", "");
							PrimaNeta = Double.parseDouble(this.sPrimaNeta);
						}else{
							sPrimaNeta = line.substring(2, 16).trim();
							sPrimaNeta = sPrimaNeta.replaceAll(",", "");
							PrimaNeta = Double.parseDouble(this.sPrimaNeta);
						}
					}

					if(cont == 29){
						if (line.length()>71){
							sComision = line.substring(61, 71).trim();
							sComision = sComision.replaceAll(",", "");
							Comision = Double.parseDouble(sComision);
							Comision = Comision/100;
						}
					}

					//					if(cont == 30 && Comision != 0){
					//						if (line.length()>71){
					//						sComision = line.substring(61, 71).trim();
					//						sComision = sComision.replaceAll(",", "");
					//						Comision = Double.parseDouble(sComision);
					//						Comision = Comision/100;
					//						}
					//					}
					if (cont == 30 && Comision == 0){
						Comision = 0.0;
						sComision ="";
					}
					if(line.indexOf("CNSF")>-1){
						break;
					}
				}else
					datos[cont]="";
				cont++;
			}
			if(line!=null){
				if(datos[9].indexOf("IDH")>-1) {
					creaCaraRespHospitalario(datos);
					cont=0;
					Periodo = 0;
					ComTotal = 0;
					ComPar=0;
					PrimaNeta = 0;
					Comision = 0;
				}else {
					creaCaraCte(datos);
					cont=0;
					Periodo = 0;
					ComTotal = 0;
					ComPar=0;
					PrimaNeta = 0;
					Comision = 0;
				}
			}else{
				flag= false;
			}
		}
		br.close();
	}

	private void creaCaraRespHospitalario(String[] datos) throws DocumentException, IOException {
		PdfStamper stamper = null;
		PdfReader reader = new PdfReader(plantillaAP);
		Font Arial = new Font(Font.getFamily((String)"Arial"), 10.0f);
		Arial.setColor(23, 54, 93);
		this.poliza = String.valueOf(datos[0].substring(83, 85).trim()) + datos[0].substring(86, 99).trim();
		System.out.println("poliza: " + this.poliza);
		File fl = new File(String.valueOf(pathSal) + "\\" + this.poliza + "\\Caratula\\");
		fl.mkdirs();
		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+ "\\"+poliza+"\\Caratula\\"+"Caratula_Agente_RH_"+poliza+".pdf"));
		Phrase phraset = null;
		PdfContentByte canvas = stamper.getOverContent(1);
		PdfContentByte canvas2 = stamper.getOverContent(2);
		canvas.beginText();

		DecimalFormatSymbols simbolo = new  DecimalFormatSymbols();
		simbolo.setDecimalSeparator('.');
		simbolo.setGroupingSeparator(',');
		DecimalFormat formateador = new DecimalFormat("$###,###,###.##",simbolo);

		ComTotal = (this.PrimaNeta*this.Comision);
		sComTotal = formateador.format(ComTotal);
		if (sComTotal.equals("$  0")){
			sComTotal = "";
		}
		if (sComTotal.indexOf(".") < 0){
			sComTotal = sComTotal + ".00";
		}
		ComPar = this.ComTotal/this.Periodo;
		sComPar = formateador.format(this.ComPar);
		if (sComPar.equals("$  0")){
			sComPar = "";
		}
		if (sComPar.indexOf(".") < 0){
			sComPar = sComPar + ".00";
		}
		this.largoArreg = datos[0].length();
		Chunk c0 = new Chunk(datos[0].substring(0, 16), Arial);
		this.largoArreg = datos[0].length();
		Chunk c1 = new Chunk(datos[0].substring(83, 93).trim(), Arial);
		this.largoArreg = datos[2].length();
		Chunk c2 = new Chunk(datos[2].substring(10, 65), Arial);
		this.largoArreg = datos[2].length();
		Chunk c3 = new Chunk(datos[2].substring(65, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[4].length();
		Chunk c4 = new Chunk(datos[4].substring(10, 70).trim(), Arial);
		this.largoArreg = datos[4].length();
		Chunk c5 = new Chunk(datos[4].substring(70, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[5].length();
		Chunk c6 = new Chunk(datos[5].substring(10, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[6].length();
		Chunk c7 = new Chunk(datos[6].substring(10, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[8].length();
		Chunk c8 = new Chunk(datos[8].substring(0, 4), Arial);
		Chunk c9 = new Chunk(datos[8].substring(6, 10), Arial);
		Chunk c10 = new Chunk(datos[8].substring(10, 17), Arial);
		Chunk c11 = new Chunk(datos[8].substring(17, 19), Arial);
		Chunk c12 = new Chunk(datos[8].substring(22, 24), Arial);
		Chunk c13 = new Chunk(datos[8].substring(26, 30), Arial);
		Chunk c14 = new Chunk(datos[8].substring(37, 45), Arial);
		Chunk c15 = new Chunk(datos[8].substring(60, 75).trim(), Arial);
		Chunk c16 = new Chunk(datos[8].substring(82, 92), Arial);

		this.largoArreg = datos[9].length();
		Chunk c17 = null;
		Chunk c18 = null;
		Chunk c19 = null;
		Chunk c20 = null;
		if (this.largoArreg > 80) {
			c17 = new Chunk(datos[9].substring(0, 20).trim(), Arial);
			c18 = new Chunk(datos[9].substring(20, 53).trim(), Arial);
			c19 = new Chunk(datos[9].substring(53, 75).trim(), Arial);
			c20 = new Chunk(datos[9].substring(81, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c17 = new Chunk(datos[9].substring(0, 27).trim(), Arial);
			c18 = new Chunk(datos[9].substring(27, 54).trim(), Arial);
			c19 = new Chunk(datos[9].substring(54, this.largoArreg).trim(), Arial);
			c20 = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 65){
			c17 = new Chunk(datos[9].substring(0, 27).trim(), Arial);
			c18 = new Chunk(datos[9].substring(27, largoArreg).trim(), Arial);
			c19 = new Chunk();
			c20 = new Chunk();
		}else {
			c17 = new Chunk(datos[9].substring(0, this.largoArreg).trim(), Arial);
			c18 = new Chunk();
			c19 = new Chunk();
			c20 = new Chunk();
		}
		this.largoArreg = datos[10].length();
		Chunk c21 = null;
		Chunk c22 = null;
		Chunk c23 = null;
		Chunk c24 = null;
		if (this.largoArreg > 80) {
			c21 = new Chunk(datos[10].substring(0, 32).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32, 54), Arial);
			c23 = new Chunk(datos[10].substring(54, 75).trim(), Arial);
			c24 = new Chunk(datos[10].substring(78, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c21 = new Chunk(datos[10].substring(0, 28).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32, 50), Arial);
			c23 = new Chunk(datos[10].substring(56, this.largoArreg).trim(), Arial);
			c24 = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 65) {
			c21 = new Chunk(datos[10].substring(0, 28).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32, this.largoArreg).trim(), Arial);
			c23 = new Chunk();
			c24 = new Chunk();
		} else {
			c21 = new Chunk(datos[10].substring(0, this.largoArreg).trim(), Arial);
			c22 = new Chunk();
			c23 = new Chunk();
			c24 = new Chunk();
		}
		this.largoArreg = datos[11].length();
		Chunk c210 = null;
		Chunk c220 = null;
		Chunk c230 = null;
		Chunk c240 = null;
		if (this.largoArreg > 80) {
			c210 = new Chunk(datos[11].substring(0, 20).trim(), Arial);
			c220 = new Chunk(datos[11].substring(32, 54).trim(), Arial);
			c230 = new Chunk(datos[11].substring(54, 75).trim(), Arial);
			c240 = new Chunk(datos[11].substring(81, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c210 = new Chunk(datos[11].substring(0, 20).trim(), Arial);
			c220 = new Chunk(datos[11].substring(32, 54), Arial);
			c230 = new Chunk(datos[11].substring(53, this.largoArreg).trim(), Arial);
			c240 = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 70) {
			c210 = new Chunk(datos[11].substring(0, 20).trim(), Arial);
			c220 = new Chunk(datos[11].substring(32, this.largoArreg).trim(), Arial);
			c230 = new Chunk();
			c240 = new Chunk();
		} else {
			c210 = new Chunk(datos[11].substring(0, this.largoArreg).trim(), Arial);
			c220 = new Chunk();
			c230 = new Chunk();
			c240 = new Chunk();
		}

		this.largoArreg = datos[12].length();
		Chunk c250 = null;
		Chunk c250A = null;
		Chunk c250B = null;
		Chunk c250C = null;
		if (this.largoArreg > 80) {
			c250 = new Chunk(datos[12].substring(0, 20).trim(), Arial);
			c250A = new Chunk(datos[12].substring(20, 53).trim(), Arial);
			c250B = new Chunk(datos[12].substring(53, 75).trim(), Arial);
			c250C = new Chunk(datos[12].substring(81, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c250 = new Chunk(datos[12].substring(0, 20).trim(), Arial);
			c250A = new Chunk(datos[12].substring(20, 53), Arial);
			c250B = new Chunk(datos[12].substring(53, this.largoArreg).trim(), Arial);
			c250C = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 70) {
			c250 = new Chunk(datos[12].substring(0, 20).trim(), Arial);
			c250A = new Chunk(datos[12].substring(20, this.largoArreg).trim(), Arial);
			c250B = new Chunk();
			c250C = new Chunk();
		} else {
			c250 = new Chunk(datos[12].substring(0, this.largoArreg).trim(), Arial);
			c250A = new Chunk();
			c250B = new Chunk();
			c250C = new Chunk();
		}

		this.largoArreg = datos[13].length();
		Chunk c251 = new Chunk();
		Chunk c251A = new Chunk();

		if(largoArreg < 70){
			c251 = new Chunk(datos[13].substring(0, this.largoArreg).trim(), Arial);	
		}
		if((this.largoArreg > 30 && this.largoArreg < 70)){
			c251 = new Chunk(datos[13].substring(0, 35).trim(), Arial);
			c251A = new Chunk(datos[13].substring(36, this.largoArreg).trim(), Arial);
		}

		this.largoArreg = datos[14].length();
		Chunk c252 = new Chunk(datos[14].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[16].length();
		Chunk c25 = new Chunk(datos[16].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[17].length();
		Chunk cA25 = new Chunk(datos[17].substring(0, this.largoArreg).trim(), Arial);

		this.largoArreg = datos[20].length();
		Chunk c26 = new Chunk(datos[20].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[21].length();
		Chunk c27 = new Chunk(datos[21].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[22].length();
		Chunk c27A = new Chunk(datos[22].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[23].length();
		Chunk c28 = new Chunk(datos[23].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[24].length();
		Chunk c29 = new Chunk(datos[24].substring(0, this.largoArreg).trim(), Arial);

		Chunk c30 = null;   
		Chunk c31 = null;
		Chunk c31A = null;
		Chunk c32 = null;
		Chunk c33 =null;      
		Chunk c34 = null;	     
		Chunk c35 = null;
		this.largoArreg = datos[28].length();


		if(largoArreg > 10){

			if(primNeta.equals("")){
				c30 = new Chunk(datos[28].substring(0, 14).trim(), Arial);
			}else{
				c30 = new Chunk(primNeta.trim(), Arial);
			}

			if(derPoliza.equals("")){
				c31 = new Chunk(datos[28].substring(15, 26).trim(), Arial);
			}else{
				c31 = new Chunk(derPoliza.trim(), Arial);
			}

			if(primTotal.equals("")){
				c32 = new Chunk(datos[28].substring(39, 54).trim(), Arial);
			}else{
				c32 = new Chunk(primTotal.trim(), Arial);
			}

			c31A = new Chunk(datos[28].substring(26, 39).trim(), Arial);	
			c33 = new Chunk(datos[28].substring(54, 68).trim(), Arial);       

			if(totalPagar.equals("")){
				c34 = new Chunk(datos[28].substring(68, 82).trim(), Arial);	     
			}else{
				c34 = new Chunk(totalPagar.trim(), Arial);
			}

			if(importePrem.equals("")){
				c35 = new Chunk(datos[28].substring(82, this.largoArreg).trim(), Arial);
			}else{
				c35 = new Chunk(importePrem.trim(), Arial);
			}
		}else{
			c30 = new Chunk();     
			c31 = new Chunk();
			c31A = new Chunk();	
			c32 = new Chunk();
			c33 = new Chunk();       
			c34 = new Chunk();	     
			c35 = new Chunk();
		}


		this.largoArreg = datos[29].length();
		Chunk c39 = new Chunk();
		if(datos[29].length() < 69 && datos[29].length() > 10){
			c39 = new Chunk(datos[29].substring(61, largoArreg).trim(), Arial);
		} else if (largoArreg > 69){
			c39 = new Chunk(datos[29].substring(61, 69).trim(), Arial);
		}else {
			c39 = new Chunk();
		}

		this.largoArreg = datos[30].length();
		Chunk c36A = new Chunk(datos[30].substring(0, 12).trim(), Arial);
		Chunk c36 = new Chunk(datos[30].substring(12, 21).trim(), Arial);
		Chunk c360 = new Chunk(datos[30].substring(21, 49).trim(), Arial);

		Chunk c40 = new Chunk(datos[30].substring(49, 55).trim(), Arial);
		Chunk c41 = null;
		Chunk cA41= new Chunk(sComTotal, Arial);
		Chunk cB41= new Chunk(sComPar, Arial);

		if(largoArreg < 65){
			c41 = new Chunk(datos[30].substring(55, largoArreg).trim(), Arial);

		}else {
			c41 = new Chunk(datos[30].substring(55, 63).trim(), Arial);


		}

		this.largoArreg = datos[68].length();
		Chunk c42 =null;
		Chunk c43 =null;
		Chunk c44 =null;
		if (largoArreg > 10){
			c42 = new Chunk(datos[68].substring(7, 9), Arial);
			c43 = new Chunk(datos[68].substring(13, 30).trim(), Arial);
			c44 = new Chunk(datos[68].substring(30, 34).trim(), Arial);
		}else{
			c42 = new Chunk();
			c43 = new Chunk();
			c44 = new Chunk();
		}
		this.largoArreg = datos[69].length();
		Chunk c45 = new Chunk(datos[69].substring(0, 41).trim(), Arial);
		phraset = new Phrase(c0);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)30.0f, (float)727.0f, (float)0.0f);
		System.out.println("Generando c0: " + (Object)phraset);
		Arial.setSize(10.0f);
		Arial.setStyle(1);
		phraset = new Phrase(c1);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)520.0f, (float)727.0f, (float)0.0f);
		System.out.println("Generando c01: " + (Object)phraset);
		Arial.setSize(10.0f);
		Arial.setStyle(0);
		phraset = new Phrase(c2);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)90.0f, (float)703.0f, (float)0.0f);
		System.out.println("Generando c2: " + (Object)phraset);
		phraset = new Phrase(c3);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)489.0f, (float)703.0f, (float)0.0f);
		System.out.println("Generando c3: " + (Object)phraset);
		phraset = new Phrase(c4);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)85.0f, (float)680.0f, (float)0.0f);
		System.out.println("Generando c4: " + (Object)phraset);
		phraset = new Phrase(c5);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)523.0f, (float)680.0f, (float)0.0f);
		System.out.println("Generando c5: " + (Object)phraset);
		phraset = new Phrase(c6);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)85.0f, (float)670.0f, (float)0.0f);
		System.out.println("Generando c6: " + (Object)phraset);
		phraset = new Phrase(c7);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)85.0f, (float)660.0f, (float)0.0f);
		System.out.println("Generando c7: " + (Object)phraset);
		phraset = new Phrase(c8);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)37.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c8: " + (Object)phraset);
		phraset = new Phrase(c9);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)65.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c9: " + (Object)phraset);
		phraset = new Phrase(c10);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)91.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c10: " + (Object)phraset);
		phraset = new Phrase(c11);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)127.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c11: " + (Object)phraset);
		phraset = new Phrase(c12);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)156.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c12: " + (Object)phraset);
		phraset = new Phrase(c13);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)183.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c13: " + (Object)phraset);
		phraset = new Phrase(c14);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)245.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c14: " + (Object)phraset);
		phraset = new Phrase(c15);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)359.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c15: " + (Object)phraset);
		phraset = new Phrase(c16);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)500.0f, (float)457.0f, (float)0.0f);
		System.out.println("Generando c16: " + (Object)phraset);
		phraset = new Phrase(c17);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)35.0f, (float)417.0f, (float)0.0f);
		System.out.println("Generando c17: " + (Object)phraset);
		phraset = new Phrase(c18);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)425.0f, (float)417.0f, (float)0.0f);
		System.out.println("Generando c18: " + (Object)phraset);

		phraset = new Phrase(c21);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)35.0f, (float)407.0f, (float)0.0f);
		System.out.println("Generando c21: " + (Object)phraset);
		phraset = new Phrase(c22);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)425.0f, (float)407.0f, (float)0.0f);
		System.out.println("Generando c22: " + (Object)phraset);

		phraset = new Phrase(c210);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)35.0f, (float)397.0f, (float)0.0f);
		System.out.println("Generando c210: " + (Object)phraset);
		phraset = new Phrase(c220);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)425.0f, (float)397.0f, (float)0.0f);
		System.out.println("Generando c220: " + (Object)phraset);

		phraset = new Phrase(c250);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)35.0f, (float)387.0f, (float)0.0f);
		System.out.println("Generando c250: " + (Object)phraset);
		phraset = new Phrase(c250A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)425.0f, (float)387.0f, (float)0.0f);
		System.out.println("Generando c250A: " + (Object)phraset);

		phraset = new Phrase(c251);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)35.0f, (float)377.0f, (float)0.0f);
		System.out.println("Generando c251: " + (Object)phraset);
		phraset = new Phrase(c251A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)227.0f, (float)377.0f, (float)0.0f);
		System.out.println("Generando c251A: " + (Object)phraset);
		
		phraset = new Phrase(c25);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)35.0f, (float)350.0f, (float)0.0f);
		System.out.println("Generando c25: " + (Object)phraset);
		
		
		
		
		phraset = new Phrase(cA25);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)340.0f, (float)0.0f);
		System.out.println("Generando cA25: " + (Object)phraset);

		phraset = new Phrase(c26);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)330.0f, (float)0.0f);
		System.out.println("Generando c26: " + (Object)phraset);
		phraset = new Phrase(c27);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)320.0f, (float)0.0f);
		System.out.println("Generando c27: " + (Object)phraset);
		phraset = new Phrase(c27A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)310.0f, (float)0.0f);
		System.out.println("Generando c27A: " + (Object)phraset);
		phraset = new Phrase(c28);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)36.0f, (float)254.0f, (float)0.0f);
		System.out.println("Generando c28: " + (Object)phraset);
		phraset = new Phrase(c29);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)36.0f, (float)244.0f, (float)0.0f);
		System.out.println("Generando c29: " + (Object)phraset);
		phraset = new Phrase(c30);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)32.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c30: " + (Object)phraset);
		phraset = new Phrase(c31);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)106.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c31: " + (Object)phraset);
		phraset = new Phrase(c31A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)167.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c31A: " + (Object)phraset);
		phraset = new Phrase(c32);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)242.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c32: " + (Object)phraset);
		phraset = new Phrase(c33);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)327.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c33: " + (Object)phraset);
		phraset = new Phrase(c34);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)390.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c34: " + (Object)phraset);
		phraset = new Phrase(c35);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)460.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c35: " + (Object)phraset);
		phraset = new Phrase(c36A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)537.0f, (float)143.0f, (float)0.0f);
		System.out.println("Generando c36A: " + (Object)phraset);
//		phraset = new Phrase(c36);
//		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)114.0f, (float)107.0f, (float)0.0f);
//		System.out.println("Generando c36: " + (Object)phraset);
		phraset = new Phrase(c360);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)161.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c360: " + (Object)phraset);

		phraset = new Phrase(c39);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)430.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c39: " + (Object)phraset);

		phraset = new Phrase(cA41);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)471.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando cA41: " + (Object)phraset);
		phraset = new Phrase(cB41);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)536.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando cB41: " + (Object)phraset);

		phraset = new Phrase(c40);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)350.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c40: " + (Object)phraset);
		phraset = new Phrase(c41);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)387.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c41: " + (Object)phraset);
		phraset = new Phrase(c42);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)65.0f, (float)286.0f, (float)0.0f);
		System.out.println("Generando c42: " + (Object)phraset);
		phraset = new Phrase(c43);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)94.0f, (float)286.0f, (float)0.0f);
		System.out.println("Generando c43: " + (Object)phraset);
		phraset = new Phrase(c44);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)171.0f, (float)286.0f, (float)0.0f);
		System.out.println("Generando c44: " + (Object)phraset);
		phraset = new Phrase(c45);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)29.0f, (float)274.0f, (float)0.0f);
		System.out.println("Generando c45: " + (Object)phraset);
		++this.contCar;
		System.out.println("Se generó caratulaAge: " + this.contCar);
		canvas.endText();
		stamper.close();
		
	}

	public void creaCaraCte(String[] datos) throws IOException, DocumentException {
		PdfStamper stamper = null;
		PdfReader reader = new PdfReader("C:\\JAR Armado\\images\\Plantilla GM06 Color.pdf");
		Font Arial = new Font(Font.getFamily((String)"Arial"), 10.0f);
		Arial.setColor(23, 54, 93);
		this.poliza = String.valueOf(datos[0].substring(83, 85).trim()) + datos[0].substring(86, 99).trim();
		System.out.println("poliza: " + this.poliza);
		File fl = new File(String.valueOf(pathSal) + "\\" + this.poliza + "\\Caratula\\");
		fl.mkdirs();
		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+ "\\"+poliza+"\\Caratula\\"+"Caratula_Agente_"+poliza+".pdf"));
		Phrase phraset = null;
		PdfContentByte canvas = stamper.getOverContent(1);
		PdfContentByte canvas2 = stamper.getOverContent(2);
		canvas.beginText();

		DecimalFormatSymbols simbolo = new  DecimalFormatSymbols();
		simbolo.setDecimalSeparator('.');
		simbolo.setGroupingSeparator(',');
		DecimalFormat formateador = new DecimalFormat("$###,###,###.##",simbolo);

		ComTotal = (this.PrimaNeta*this.Comision);
		sComTotal = formateador.format(ComTotal);
		if (sComTotal.equals("$  0")){
			sComTotal = "";
		}
		if (sComTotal.indexOf(".") < 0){
			sComTotal = sComTotal + ".00";
		}
		ComPar = this.ComTotal/this.Periodo;
		sComPar = formateador.format(this.ComPar);
		if (sComPar.equals("$  0")){
			sComPar = "";
		}
		if (sComPar.indexOf(".") < 0){
			sComPar = sComPar + ".00";
		}
		this.largoArreg = datos[0].length();
		Chunk c0 = new Chunk(datos[0].substring(0, 16), Arial);
		this.largoArreg = datos[0].length();
		Chunk c1 = new Chunk(datos[0].substring(83, 93).trim(), Arial);
		this.largoArreg = datos[2].length();
		Chunk c2 = new Chunk(datos[2].substring(10, 65), Arial);
		this.largoArreg = datos[2].length();
		Chunk c3 = new Chunk(datos[2].substring(65, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[4].length();
		Chunk c4 = new Chunk(datos[4].substring(10, 70).trim(), Arial);
		this.largoArreg = datos[4].length();
		Chunk c5 = new Chunk(datos[4].substring(70, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[5].length();
		Chunk c6 = new Chunk(datos[5].substring(10, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[6].length();
		Chunk c7 = new Chunk(datos[6].substring(10, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[8].length();
		Chunk c8 = new Chunk(datos[8].substring(0, 4), Arial);
		Chunk c9 = new Chunk(datos[8].substring(6, 10), Arial);
		Chunk c10 = new Chunk(datos[8].substring(10, 17), Arial);
		Chunk c11 = new Chunk(datos[8].substring(17, 19), Arial);
		Chunk c12 = new Chunk(datos[8].substring(22, 24), Arial);
		Chunk c13 = new Chunk(datos[8].substring(26, 30), Arial);
		Chunk c14 = new Chunk(datos[8].substring(37, 45), Arial);
		Chunk c15 = new Chunk(datos[8].substring(60, 75).trim(), Arial);
		Chunk c16 = new Chunk(datos[8].substring(82, 92), Arial);

		this.largoArreg = datos[9].length();
		Chunk c17 = null;
		Chunk c18 = null;
		Chunk c19 = null;
		Chunk c20 = null;
		if (this.largoArreg > 80) {
			c17 = new Chunk(datos[9].substring(0, 20).trim(), Arial);
			c18 = new Chunk(datos[9].substring(20, 53).trim(), Arial);
			c19 = new Chunk(datos[9].substring(53, 75).trim(), Arial);
			c20 = new Chunk(datos[9].substring(81, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c17 = new Chunk(datos[9].substring(0, 27).trim(), Arial);
			c18 = new Chunk(datos[9].substring(27, 54).trim(), Arial);
			c19 = new Chunk(datos[9].substring(54, this.largoArreg).trim(), Arial);
			c20 = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 65){
			c17 = new Chunk(datos[9].substring(0, 27).trim(), Arial);
			c18 = new Chunk(datos[9].substring(27, largoArreg).trim(), Arial);
			c19 = new Chunk();
			c20 = new Chunk();
		}else {
			c17 = new Chunk(datos[9].substring(0, this.largoArreg).trim(), Arial);
			c18 = new Chunk();
			c19 = new Chunk();
			c20 = new Chunk();
		}
		this.largoArreg = datos[10].length();
		Chunk c21 = null;
		Chunk c22 = null;
		Chunk c23 = null;
		Chunk c24 = null;
		if (this.largoArreg > 80) {
			c21 = new Chunk(datos[10].substring(0, 32).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32, 54), Arial);
			c23 = new Chunk(datos[10].substring(54, 75).trim(), Arial);
			c24 = new Chunk(datos[10].substring(78, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c21 = new Chunk(datos[10].substring(0, 28).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32, 50), Arial);
			c23 = new Chunk(datos[10].substring(56, this.largoArreg).trim(), Arial);
			c24 = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 65) {
			c21 = new Chunk(datos[10].substring(0, 28).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32, this.largoArreg).trim(), Arial);
			c23 = new Chunk();
			c24 = new Chunk();
		} else {
			c21 = new Chunk(datos[10].substring(0, this.largoArreg).trim(), Arial);
			c22 = new Chunk();
			c23 = new Chunk();
			c24 = new Chunk();
		}
		this.largoArreg = datos[11].length();
		Chunk c210 = null;
		Chunk c220 = null;
		Chunk c230 = null;
		Chunk c240 = null;
		if (this.largoArreg > 80) {
			c210 = new Chunk(datos[11].substring(0, 20).trim(), Arial);
			c220 = new Chunk(datos[11].substring(32, 54).trim(), Arial);
			c230 = new Chunk(datos[11].substring(54, 75).trim(), Arial);
			c240 = new Chunk(datos[11].substring(81, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c210 = new Chunk(datos[11].substring(0, 20).trim(), Arial);
			c220 = new Chunk(datos[11].substring(32, 54), Arial);
			c230 = new Chunk(datos[11].substring(53, this.largoArreg).trim(), Arial);
			c240 = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 70) {
			c210 = new Chunk(datos[11].substring(0, 20).trim(), Arial);
			c220 = new Chunk(datos[11].substring(32, this.largoArreg).trim(), Arial);
			c230 = new Chunk();
			c240 = new Chunk();
		} else {
			c210 = new Chunk(datos[11].substring(0, this.largoArreg).trim(), Arial);
			c220 = new Chunk();
			c230 = new Chunk();
			c240 = new Chunk();
		}

		this.largoArreg = datos[12].length();
		Chunk c250 = null;
		Chunk c250A = null;
		Chunk c250B = null;
		Chunk c250C = null;
		if (this.largoArreg > 80) {
			c250 = new Chunk(datos[12].substring(0, 20).trim(), Arial);
			c250A = new Chunk(datos[12].substring(20, 53).trim(), Arial);
			c250B = new Chunk(datos[12].substring(53, 75).trim(), Arial);
			c250C = new Chunk(datos[12].substring(81, this.largoArreg).trim(), Arial);
		} else if (this.largoArreg >= 70 && this.largoArreg < 80) {
			c250 = new Chunk(datos[12].substring(0, 20).trim(), Arial);
			c250A = new Chunk(datos[12].substring(20, 53), Arial);
			c250B = new Chunk(datos[12].substring(53, this.largoArreg).trim(), Arial);
			c250C = new Chunk();
		} else if (this.largoArreg > 30 && this.largoArreg < 70) {
			c250 = new Chunk(datos[12].substring(0, 20).trim(), Arial);
			c250A = new Chunk(datos[12].substring(20, this.largoArreg).trim(), Arial);
			c250B = new Chunk();
			c250C = new Chunk();
		} else {
			c250 = new Chunk(datos[12].substring(0, this.largoArreg).trim(), Arial);
			c250A = new Chunk();
			c250B = new Chunk();
			c250C = new Chunk();
		}

		this.largoArreg = datos[13].length();
		Chunk c251 = new Chunk();
		Chunk c251A = new Chunk();

		if(largoArreg < 70){
			c251 = new Chunk(datos[13].substring(0, this.largoArreg).trim(), Arial);	
		}
		if((this.largoArreg > 30 && this.largoArreg < 70)){
			c251 = new Chunk(datos[13].substring(0, 35).trim(), Arial);
			c251A = new Chunk(datos[13].substring(36, this.largoArreg).trim(), Arial);
		}

		this.largoArreg = datos[14].length();
		Chunk c252 = new Chunk(datos[14].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[16].length();
		Chunk c25 = new Chunk(datos[16].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[17].length();
		Chunk cA25 = new Chunk(datos[17].substring(0, this.largoArreg).trim(), Arial);

		this.largoArreg = datos[20].length();
		Chunk c26 = new Chunk(datos[20].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[21].length();
		Chunk c27 = new Chunk(datos[21].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[22].length();
		Chunk c27A = new Chunk(datos[22].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[23].length();
		Chunk c28 = new Chunk(datos[23].substring(0, this.largoArreg).trim(), Arial);
		this.largoArreg = datos[24].length();
		Chunk c29 = new Chunk(datos[24].substring(0, this.largoArreg).trim(), Arial);

		Chunk c30 = null;   
		Chunk c31 = null;
		Chunk c31A = null;
		Chunk c32 = null;
		Chunk c33 =null;      
		Chunk c34 = null;	     
		Chunk c35 = null;
		this.largoArreg = datos[28].length();


		if(largoArreg > 10){

			if(primNeta.equals("")){
				c30 = new Chunk(datos[28].substring(0, 14).trim(), Arial);
			}else{
				c30 = new Chunk(primNeta.trim(), Arial);
			}

			if(derPoliza.equals("")){
				c31 = new Chunk(datos[28].substring(15, 26).trim(), Arial);
			}else{
				c31 = new Chunk(derPoliza.trim(), Arial);
			}

			if(primTotal.equals("")){
				c32 = new Chunk(datos[28].substring(39, 54).trim(), Arial);
			}else{
				c32 = new Chunk(primTotal.trim(), Arial);
			}

			c31A = new Chunk(datos[28].substring(26, 39).trim(), Arial);	
			c33 = new Chunk(datos[28].substring(54, 68).trim(), Arial);       

			if(totalPagar.equals("")){
				c34 = new Chunk(datos[28].substring(68, 82).trim(), Arial);	     
			}else{
				c34 = new Chunk(totalPagar.trim(), Arial);
			}

			if(importePrem.equals("")){
				c35 = new Chunk(datos[28].substring(82, this.largoArreg).trim(), Arial);
			}else{
				c35 = new Chunk(importePrem.trim(), Arial);
			}
		}else{
			c30 = new Chunk();     
			c31 = new Chunk();
			c31A = new Chunk();	
			c32 = new Chunk();
			c33 = new Chunk();       
			c34 = new Chunk();	     
			c35 = new Chunk();
		}


		this.largoArreg = datos[29].length();
		Chunk c39 = new Chunk();
		if(datos[29].length() < 69 && datos[29].length() > 10){
			c39 = new Chunk(datos[29].substring(61, largoArreg).trim(), Arial);
		} else if (largoArreg > 69){
			c39 = new Chunk(datos[29].substring(61, 69).trim(), Arial);
		}else {
			c39 = new Chunk();
		}

		this.largoArreg = datos[30].length();
		Chunk c36A = new Chunk(datos[30].substring(0, 12).trim(), Arial);
		Chunk c36 = new Chunk(datos[30].substring(12, 21).trim(), Arial);
		Chunk c360 = new Chunk(datos[30].substring(21, 49).trim(), Arial);

		Chunk c40 = new Chunk(datos[30].substring(49, 55).trim(), Arial);
		Chunk c41 = null;
		Chunk cA41= new Chunk(sComTotal, Arial);
		Chunk cB41= new Chunk(sComPar, Arial);

		if(largoArreg < 65){
			c41 = new Chunk(datos[30].substring(55, largoArreg).trim(), Arial);

		}else {
			c41 = new Chunk(datos[30].substring(55, 63).trim(), Arial);


		}

		this.largoArreg = datos[68].length();
		Chunk c42 =null;
		Chunk c43 =null;
		Chunk c44 =null;
		if (largoArreg > 10){
			c42 = new Chunk(datos[68].substring(7, 9), Arial);
			c43 = new Chunk(datos[68].substring(13, 30).trim(), Arial);
			c44 = new Chunk(datos[68].substring(30, 34).trim(), Arial);
		}else{
			c42 = new Chunk();
			c43 = new Chunk();
			c44 = new Chunk();
		}
		this.largoArreg = datos[69].length();
		Chunk c45 = new Chunk(datos[69].substring(0, 41).trim(), Arial);
		phraset = new Phrase(c0);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)28.0f, (float)711.0f, (float)0.0f);
		System.out.println("Generando c0: " + (Object)phraset);
		Arial.setSize(11.0f);
		Arial.setStyle(1);
		phraset = new Phrase(c1);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)532.0f, (float)700.0f, (float)0.0f);
		System.out.println("Generando c01: " + (Object)phraset);
		Arial.setSize(10.0f);
		Arial.setStyle(0);
		phraset = new Phrase(c2);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)85.0f, (float)672.0f, (float)0.0f);
		System.out.println("Generando c2: " + (Object)phraset);
		phraset = new Phrase(c3);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)473.0f, (float)673.0f, (float)0.0f);
		System.out.println("Generando c3: " + (Object)phraset);
		phraset = new Phrase(c4);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)85.0f, (float)645.0f, (float)0.0f);
		System.out.println("Generando c4: " + (Object)phraset);
		phraset = new Phrase(c5);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)513.0f, (float)646.0f, (float)0.0f);
		System.out.println("Generando c5: " + (Object)phraset);
		phraset = new Phrase(c6);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)85.0f, (float)635.0f, (float)0.0f);
		System.out.println("Generando c6: " + (Object)phraset);
		phraset = new Phrase(c7);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)85.0f, (float)625.0f, (float)0.0f);
		System.out.println("Generando c7: " + (Object)phraset);
		phraset = new Phrase(c8);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)32.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c8: " + (Object)phraset);
		phraset = new Phrase(c9);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)64.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c9: " + (Object)phraset);
		phraset = new Phrase(c10);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)92.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c10: " + (Object)phraset);
		phraset = new Phrase(c11);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)129.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c11: " + (Object)phraset);
		phraset = new Phrase(c12);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)158.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c12: " + (Object)phraset);
		phraset = new Phrase(c13);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)185.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c13: " + (Object)phraset);
		phraset = new Phrase(c14);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)240.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c14: " + (Object)phraset);
		phraset = new Phrase(c15);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)355.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c15: " + (Object)phraset);
		phraset = new Phrase(c16);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)495.0f, (float)570.0f, (float)0.0f);
		System.out.println("Generando c16: " + (Object)phraset);
		phraset = new Phrase(c17);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)533.0f, (float)0.0f);
		System.out.println("Generando c17: " + (Object)phraset);
		phraset = new Phrase(c18);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)227.0f, (float)533.0f, (float)0.0f);
		System.out.println("Generando c18: " + (Object)phraset);
		phraset = new Phrase(c19);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)352.0f, (float)533.0f, (float)0.0f);
		System.out.println("Generando c19: " + (Object)phraset);
		phraset = new Phrase(c20);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)510.0f, (float)533.0f, (float)0.0f);
		System.out.println("Generando c20: " + (Object)phraset);
		phraset = new Phrase(c21);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)523.0f, (float)0.0f);
		System.out.println("Generando c21: " + (Object)phraset);
		phraset = new Phrase(c22);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)227.0f, (float)523.0f, (float)0.0f);
		System.out.println("Generando c22: " + (Object)phraset);
		phraset = new Phrase(c23);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)352.0f, (float)523.0f, (float)0.0f);
		System.out.println("Generando c23: " + (Object)phraset);
		phraset = new Phrase(c24);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)510.0f, (float)523.0f, (float)0.0f);
		System.out.println("Generando c24: " + (Object)phraset);
		phraset = new Phrase(c210);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)513.0f, (float)0.0f);
		System.out.println("Generando c210: " + (Object)phraset);
		phraset = new Phrase(c220);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)227.0f, (float)513.0f, (float)0.0f);
		System.out.println("Generando c220: " + (Object)phraset);
		phraset = new Phrase(c230);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)352.0f, (float)513.0f, (float)0.0f);
		System.out.println("Generando c230: " + (Object)phraset);
		phraset = new Phrase(c240);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)510.0f, (float)513.0f, (float)0.0f);
		System.out.println("Generando c240: " + (Object)phraset);
		phraset = new Phrase(c250);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)501.0f, (float)0.0f);
		System.out.println("Generando c250: " + (Object)phraset);
		phraset = new Phrase(c250A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)227.0f, (float)501.0f, (float)0.0f);
		System.out.println("Generando c250A: " + (Object)phraset);
		phraset = new Phrase(c250B);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)352.0f, (float)501.0f, (float)0.0f);
		System.out.println("Generando c250B: " + (Object)phraset);
		phraset = new Phrase(c250C);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)510.0f, (float)501.0f, (float)0.0f);
		System.out.println("Generando c250C: " + (Object)phraset);
		phraset = new Phrase(c251);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)489.0f, (float)0.0f);
		System.out.println("Generando c251: " + (Object)phraset);
		phraset = new Phrase(c251A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)227.0f, (float)489.0f, (float)0.0f);
		System.out.println("Generando c251A: " + (Object)phraset);
		phraset = new Phrase(c252);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)477.0f, (float)0.0f);
		System.out.println("Generando c252: " + (Object)phraset);
		phraset = new Phrase(c25);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)417.0f, (float)0.0f);
		System.out.println("Generando c25: " + (Object)phraset);
		phraset = new Phrase(cA25);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)405.0f, (float)0.0f);
		System.out.println("Generando cA25: " + (Object)phraset);

		phraset = new Phrase(c26);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)345.0f, (float)0.0f);
		System.out.println("Generando c26: " + (Object)phraset);
		phraset = new Phrase(c27);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)335.0f, (float)0.0f);
		System.out.println("Generando c27: " + (Object)phraset);
		phraset = new Phrase(c27A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)323.0f, (float)0.0f);
		System.out.println("Generando c27A: " + (Object)phraset);
		phraset = new Phrase(c28);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)23.0f, (float)303.0f, (float)0.0f);
		System.out.println("Generando c28: " + (Object)phraset);
		phraset = new Phrase(c29);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)559.0f, (float)303.0f, (float)0.0f);
		System.out.println("Generando c29: " + (Object)phraset);
		phraset = new Phrase(c30);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)28.0f, (float)153.0f, (float)0.0f);
		System.out.println("Generando c30: " + (Object)phraset);
		phraset = new Phrase(c31);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)113.0f, (float)153.0f, (float)0.0f);
		System.out.println("Generando c31: " + (Object)phraset);
		phraset = new Phrase(c31A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)177.0f, (float)153.0f, (float)0.0f);
		System.out.println("Generando c31A: " + (Object)phraset);
		phraset = new Phrase(c32);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)255.0f, (float)153.0f, (float)0.0f);
		System.out.println("Generando c32: " + (Object)phraset);
		phraset = new Phrase(c33);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)345.0f, (float)153.0f, (float)0.0f);
		System.out.println("Generando c33: " + (Object)phraset);
		phraset = new Phrase(c34);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)430.0f, (float)153.0f, (float)0.0f);
		System.out.println("Generando c34: " + (Object)phraset);
		phraset = new Phrase(c35);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)525.0f, (float)153.0f, (float)0.0f);
		System.out.println("Generando c35: " + (Object)phraset);
		phraset = new Phrase(c36A);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)35.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c36A: " + (Object)phraset);
		phraset = new Phrase(c36);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)114.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c36: " + (Object)phraset);
		phraset = new Phrase(c360);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)170.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c360: " + (Object)phraset);

		phraset = new Phrase(c39);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)430.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c39: " + (Object)phraset);

		phraset = new Phrase(cA41);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)471.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando cA41: " + (Object)phraset);
		phraset = new Phrase(cB41);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)536.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando cB41: " + (Object)phraset);

		phraset = new Phrase(c40);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)350.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c40: " + (Object)phraset);
		phraset = new Phrase(c41);
		ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)387.0f, (float)107.0f, (float)0.0f);
		System.out.println("Generando c41: " + (Object)phraset);
		phraset = new Phrase(c42);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)65.0f, (float)286.0f, (float)0.0f);
		System.out.println("Generando c42: " + (Object)phraset);
		phraset = new Phrase(c43);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)94.0f, (float)286.0f, (float)0.0f);
		System.out.println("Generando c43: " + (Object)phraset);
		phraset = new Phrase(c44);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)171.0f, (float)286.0f, (float)0.0f);
		System.out.println("Generando c44: " + (Object)phraset);
		phraset = new Phrase(c45);
		ColumnText.showTextAligned((PdfContentByte)canvas2, (int)0, (Phrase)phraset, (float)29.0f, (float)274.0f, (float)0.0f);
		System.out.println("Generando c45: " + (Object)phraset);
		++this.contCar;
		System.out.println("Se generó caratulaAge: " + this.contCar);
		canvas.endText();
		stamper.close();
	}
}

