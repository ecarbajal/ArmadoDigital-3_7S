package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class CreaEndosoMovAD {

	public static final String plantilla = CtsArmado.pathJar + "Plantilla GM09.pdf";
	public static String pathSal = CtsArmado.pathSal;
	public static final String path = CtsArmado.pathSpool + "Spool_End_mov.txt";

	int contCar = 0;
	int largoArreg = 0;
	int largoArreg11 = 0;
	int largoArreg12 = 0;
	int largoArreg13 = 0;
	int largoArreg9 = 0;
	String poliza = "";
	String endoso = "";


	public CreaEndosoMovAD(String nNegocio) {
		pathSal = CtsArmado.pathSal;
		pathSal  = pathSal + nNegocio;
	}

	public static void main(String[] args) {
		try{
			CreaEndosoMovAD cc = new CreaEndosoMovAD("");		
			cc.creaEndos(path);
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (DocumentException e) {			
			e.printStackTrace();
		}
	}

	public void creaEndos(String file) throws IOException, DocumentException{
		File f = null;
		String line = "";
		int cont = 0;
		boolean flag = true;
		String datos[] = new String[50];
		f = new File(path);
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader(f));    

		br.readLine();  
		while(flag){
			cont=0;	
			while(((line = br.readLine()) != null) && (line.trim().indexOf("17 "))<0){
			}
			if(line != null){			
			datos[cont]=line.substring(1, line.length());
			cont++;
			}
			while(((line = br.readLine()) != null)&&((cont<50))){
				if(!line.trim().equals("FORM=AZ51,JDE=AZ51,DUP=YES,END;")){
					if(line.length()>0){					
						datos[cont]=line.substring(1, line.length());
					}else{
						datos[cont]="";
					}
					cont++;
				}else{
					while((cont<40)){
						datos[cont]="";
						cont++;
					}
					//					ultimaPag = false;
				}
			}
			if(line!=null){
				creaCaraCte(datos);
				cont=0;
			}else{
				flag= false;
			}
		}
		br.close();
	}

	public void creaCaraCte(String[] datos) throws IOException, DocumentException{
		PdfReader reader;
		PdfStamper stamper = null;
		String c341 = "";
		String c342 = "";
		String c343 = "";
		String c344 = "";
		String c345 = "";
		reader = new PdfReader(plantilla);
		Font arial=new Font(Font.getFamily("arial"),10);
		arial.setSize((float) 10);
		arial.setColor(23, 54, 93);

		//	Font arial = FontFactory.getFont("Times New Roman");
		//		BaseFont bf_times = BaseFont.createFont("c:/windows/fonts/lucon.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
		//	BaseFont bf_times = BaseFont.COURIER;
		//		Font arial = new Font(bf_times);
		//	Font arial = new Font(vlad);
		// 	arial.setSize(9);

		//arial.setSize((float) 9);
		//		System.out.println("arial: " + arial);
		poliza = (((datos[0].substring(83,85).trim())) + ((datos[0].substring(86, 92).trim())));
		largoArreg9 = datos[9].length();
		endoso = (datos[9].substring(0, largoArreg9).trim());
		System.out.println("endoso: " + endoso);

//		largoArreg = datos[34].length();
//		largoArreg11 = datos[11].length();
//		largoArreg12 = datos[12].length();
//		largoArreg13 = datos[13].length();
//
//		if (largoArreg > 1) {
//			c341= datos[34].substring(14, 37).trim();
//			//			System.out.println("c341: " + c341);
//
//			if (c341.equals("APLICADO AL CERTIFICADO")) {
//				c342= datos[34].substring(38, largoArreg).trim();
//				c343= datos[11].substring(0, largoArreg11).trim();
//				//				System.out.println("c342: " + c342);
//				//				System.out.println("c343: " + c343);
//
//				if (c343.equals("RECONOCIMIENTO DE ANTIGUEDAD")) {
//					String antiguedad = datos[15].substring(30, 40).trim();
//					//					System.out.println("antiguedad: " + antiguedad);
//					c343 = c343 + " " + antiguedad;
//				}
//				
//				if (c343.indexOf("SE HACE CONSTATAR QUE LA")<-1) {
//					c343 = "Endoso_Exclusion";
//				}
//				
//				if (c343.indexOf("POR MEDIO DEL PRESENTE ENDOSO")<-1) {
//					c343 = "Endoso_Exclusion";
//				}
//				
//				if (c343.equals("SUMA ASEGURADA PAGADA")) {
//					c344= datos[18].trim();
//					
//					
//					//					System.out.println("c344: " + c344);
//				}else {
//					c344 = c343;
//					// jhp					c345= datos[11].substring(0, 35).trim();
//					c345= datos[11].substring(0, largoArreg11).trim();
//					System.out.println("c345: " + c345);
//					if (c345.equals("POR MEDIO DEL PRESENTE")) {
//						//						System.out.println("c345-1: " + c345);
//						String beneficio = datos[12].substring(36, 80).trim();
//						//						System.out.println("beneficio-1: " + beneficio);
//						c344 = beneficio;
//
//					}
//				}
//
//			}
//
//		} else {
//			c344= datos[11].substring(0, largoArreg11).trim();
//			//			System.out.println("Poliza c344: " + c344);
//			if (c344.equals("")){
//				c344= datos[12].substring(0, largoArreg12).trim();
//				//				System.out.println("Poliza 12 c344: " + c344);
//				if (c344.equals("")) {
//					c344= datos[13].substring(0, largoArreg13).trim();
//					//					System.out.println("Poliza 13 c344: " + c344);
//				}
//			}
//		}


		File fl = new File(pathSal+"\\"+poliza+"\\Endosos\\");
		fl.mkdirs();
		System.out.println("fl: " + fl);
		c344 = c344.replaceAll("/", "_");
		c344 = c344.replaceAll(":", "");
		//		c344 = c344.replaceAll(" ...", "... ");

		//	fase2	stamper = new PdfStamper(reader, new FileOutputStream(pathSal+poliza+"\\endosos\\"+"Endoso_"+poliza+"_"+ c342 + "_" + c344+".pdf"));
		//	fase1	stamper = new PdfStamper(reader, new FileOutputStream(pathSal+poliza+"\\Endosos\\"+"AZUL_CERT_ASEG_POLIZA__"+poliza+"__ENDOSO__"+contCar+".pdf"));
		String nombreArchivo =  "";
		nombreArchivo = (pathSal+"\\"+poliza+"\\endosos\\"+ contCar +" Endoso de Movimiento " + endoso + ".pdf");

		stamper = new PdfStamper(reader, new FileOutputStream(nombreArchivo));

		Phrase phraset = null;
		PdfContentByte canvas, canvas2;  
		canvas = stamper.getOverContent(1);
		canvas2 = stamper.getOverContent(2);
		canvas.beginText(); 
		canvas2.beginText(); 


		largoArreg = datos[0].length();
		Chunk c0= new Chunk(datos[0].substring(0, 20).trim(), arial);
		Chunk c1= new Chunk(datos[0].substring(83, 100).trim(), arial);

		largoArreg = datos[1].length();
		Chunk c2 = new Chunk(datos[1].substring(10, 65).trim(), arial);
		Chunk c3= new Chunk(datos[1].substring(69, largoArreg).trim(), arial);

		largoArreg = datos[3].length();
		Chunk c4= new Chunk(datos[3].substring(10, 65).trim(), arial);
		Chunk c5 = new Chunk(datos[3].substring(73, largoArreg).trim(), arial);

		largoArreg = datos[4].length();
		Chunk c6= new Chunk(datos[4].substring(10, largoArreg).trim(), arial);

		largoArreg = datos[5].length();
		Chunk c7= new Chunk(datos[5].substring(10, largoArreg).trim(), arial);

		largoArreg = datos[7].length();
		Chunk c8 = new Chunk(datos[7].substring(1, 3).trim(), arial);
		Chunk c9= new Chunk(datos[7].substring(6, 10).trim(), arial);
		Chunk c10= new Chunk(datos[7].substring(10, 15).trim(), arial);
		Chunk c11 = new Chunk(datos[7].substring(16,18).trim(), arial);
		Chunk c12= new Chunk(datos[7].substring(20,23).trim(), arial);
		Chunk c13= new Chunk(datos[7].substring(25,30).trim(), arial);
		Chunk c14 = new Chunk(datos[7].substring(34,48).trim(), arial);
		Chunk c15= new Chunk(datos[7].substring(48,65).trim(), arial);
		Chunk c16= new Chunk(datos[7].substring(65,80).trim(), arial);
		Chunk c16A= new Chunk(datos[7].substring(81,90).trim(), arial);


		largoArreg = datos[8].length();
		Chunk c17A = new Chunk(datos[8].substring(50, largoArreg).trim(), arial);

		largoArreg = datos[9].length();
		Chunk c17 = new Chunk(datos[9].substring(50, largoArreg).trim(), arial);

		largoArreg = datos[10].length();
		Chunk c18= new Chunk(datos[10].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[11].length();
		Chunk c018= new Chunk(datos[11].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[12].length();
		Chunk c019= new Chunk(datos[12].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[13].length();
		Chunk c19= new Chunk(datos[13].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[14].length();
		Chunk c20 = new Chunk(datos[14].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[15].length();
		Chunk c21= new Chunk(datos[15].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[16].length();
		Chunk c22= new Chunk(datos[16].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[17].length();
		Chunk c23 = new Chunk(datos[17].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[18].length();
		Chunk c023 = new Chunk(datos[18].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[19].length();
		Chunk c24= new Chunk(datos[19].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[20].length();
		Chunk c25 = new Chunk(datos[20].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[21].length();
		Chunk c025 = new Chunk(datos[21].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[22].length();
		Chunk c026 = new Chunk(datos[22].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[23].length();
		Chunk c027 = new Chunk(datos[23].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[24].length();
		Chunk c028 = new Chunk(datos[24].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[25].length();
		Chunk c029 = new Chunk(datos[25].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[26].length();
		Chunk c030 = new Chunk(datos[26].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[27].length();
		Chunk c031 = new Chunk(datos[27].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[28].length();
		Chunk c032 = new Chunk(datos[28].substring(0, largoArreg).trim(), arial);

		largoArreg = datos[33].length();
		Chunk c033 = new Chunk(datos[33].substring(0, 13).trim(), arial);	// prima neta
		Chunk c033A = new Chunk(datos[33].substring(13, 24).trim(), arial);	// derecho de póliza
		Chunk c033B = new Chunk(datos[33].substring(25, 36).trim(), arial);	// recargo fraccion
		Chunk c034 = new Chunk(datos[33].substring(37, 53).trim(), arial);	// prima total
		Chunk c035 = new Chunk(datos[33].substring(54, 65).trim(), arial);	//iva
		Chunk c036 = new Chunk(datos[33].substring(66, largoArreg).trim(), arial);	//total a pagar

		largoArreg = datos[35].length();
		Chunk c037 = new Chunk(datos[35].substring(0, 46).trim(), arial);	// 
		Chunk c038 = new Chunk(datos[35].substring(47, 53).trim(), arial);	// derecho de póliza
		Chunk c039 = new Chunk(datos[35].substring(54, largoArreg).trim(), arial);	// recargo fraccion
		
		
		largoArreg = datos[48].length();
		Chunk c27= new Chunk(datos[48].substring(0, 81).trim(), arial);
		largoArreg = datos[48].length();
		Chunk c28 = new Chunk(datos[48].substring(82,largoArreg).trim(), arial);
		largoArreg = datos[49].length();
		Chunk c29= new Chunk(datos[49].substring(0, 15).trim(), arial);
		largoArreg = datos[49].length();
		Chunk c30= new Chunk(datos[49].substring(16, 80).trim(), arial);


		phraset = new Phrase(c0);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 32, 693, 0);         
		System.out.println("Generando c0: " + phraset);
		arial.setSize((float) 11);
		arial.setStyle(1);
		phraset = new Phrase(c1);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 522, 693, 0);         
		System.out.println("Generando c01: " + phraset);

		arial.setSize((float) 10);
		arial.setStyle(0);

		phraset = new Phrase(c2);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 679, 0);
		System.out.println("Generando c2: " + phraset);

		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 435, 679, 0); 
		System.out.println("Generando c3: " + phraset);

		phraset = new Phrase(c4); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 645, 0);  
		System.out.println("Generando c4: " + phraset);
		phraset = new Phrase(c5);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 460, 646, 0);
		System.out.println("Generando c5: " + phraset);
		phraset = new Phrase(c6); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 635, 0);
		System.out.println("Generando c6: " + phraset);
		phraset = new Phrase(c7);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 625, 0);
		System.out.println("Generando c7: " + phraset);
		phraset = new Phrase(c8); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 567, 0); 
		System.out.println("Generando c8: " + phraset);
		phraset = new Phrase(c9);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 58, 567, 0);
		System.out.println("Generando c9: " + phraset);
		phraset = new Phrase(c10); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 567, 0);
		System.out.println("Generando c10: " + phraset);
		phraset = new Phrase(c11);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 121, 567, 0);
		System.out.println("Generando c11: " + phraset);
		phraset = new Phrase(c12); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 150, 567, 0); 
		System.out.println("Generando c12: " + phraset);
		phraset = new Phrase(c13); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 174, 567, 0); 
		System.out.println("Generando c13: " + phraset);
		phraset = new Phrase(c14);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 235, 567, 0);
		System.out.println("Generando c14: " + phraset);
		phraset = new Phrase(c15); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 335, 567, 0);
		System.out.println("Generando c15: " + phraset);
		phraset = new Phrase(c16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 428, 567, 0);
		System.out.println("Generando c16: " + phraset);
		phraset = new Phrase(c16A);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 567, 0);
		System.out.println("Generando c16A: " + phraset);
		phraset = new Phrase(c17);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 505, 534, 0);
		System.out.println("Generando c17: " + phraset);
		phraset = new Phrase(c17A);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 330, 548, 0);
		System.out.println("Generando c17A: " + phraset);
		//TEXTO DEL ENDOSO
		phraset = new Phrase(c18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 511+10, 0);
		System.out.println("Generando c18: " + phraset);
		phraset = new Phrase(c018);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 498+10, 0);
		System.out.println("Generando c018: " + phraset);
		phraset = new Phrase(c019);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 486+10, 0);
		System.out.println("Generando c019: " + phraset);
		phraset = new Phrase(c19); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 474+10, 0);
		System.out.println("Generando c19: " + phraset);
		phraset = new Phrase(c20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 462+10, 0);
		System.out.println("Generando c20: " + phraset);
		phraset = new Phrase(c21);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 452+10, 0);
		System.out.println("Generando c21: " + phraset);
		phraset = new Phrase(c22); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 438+10, 0);
		System.out.println("Generando c22: " + phraset);
		phraset = new Phrase(c23);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 426+10, 0);
		System.out.println("Generando c23: " + phraset);
		phraset = new Phrase(c023);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 414+10, 0);
		System.out.println("Generando c023: " + phraset);
		phraset = new Phrase(c24); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 402+10, 0);  
		System.out.println("Generando c24: " + phraset);
		phraset = new Phrase(c25);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 390+10, 0);
		System.out.println("Generando c25: " + phraset);
		phraset = new Phrase(c025);    
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 378+10, 0);
		System.out.println("Generando c025: " + phraset);
		phraset = new Phrase(c026);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 366+10, 0);
		System.out.println("Generando c026: " + phraset);
		phraset = new Phrase(c027);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 354+10, 0);
		System.out.println("Generando c027: " + phraset);
		phraset = new Phrase(c028); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 342+10, 0);
		System.out.println("Generando c028: " + phraset);
		phraset = new Phrase(c029); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 330+10, 0);
		System.out.println("Generando c029: " + phraset);
		phraset = new Phrase(c030); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 318+10, 0);
		System.out.println("Generando c030: " + phraset);
		phraset = new Phrase(c031); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 306+10, 0);
		System.out.println("Generando c031: " + phraset);
		phraset = new Phrase(c032); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 294+10, 0);
		System.out.println("Generando c032: " + phraset);
		phraset = new Phrase(c033); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 29, 207, 0);
		System.out.println("Generando c033: " + phraset);
		phraset = new Phrase(c033A); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 118, 207, 0);
		System.out.println("Generando c033A: " + phraset);
		phraset = new Phrase(c033B); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 178, 207, 0);
		System.out.println("Generando c033B: " + phraset);
		phraset = new Phrase(c034); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 250, 207, 0);
		System.out.println("Generando c034: " + phraset);
		phraset = new Phrase(c035); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 345, 207, 0);
		System.out.println("Generando c035: " + phraset);
		phraset = new Phrase(c036); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 415, 207, 0);
		System.out.println("Generando c036: " + phraset);
		
		phraset = new Phrase(c037); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 118, 160, 0);
		System.out.println("Generando c037: " + phraset);
		phraset = new Phrase(c038); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 330, 160, 0);
		System.out.println("Generando c038: " + phraset);
		phraset = new Phrase(c039); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 380, 160, 0);
		System.out.println("Generando c039: " + phraset);
		//FIN TEXTO DEL ENDOSO
		
//		phraset = new Phrase(c26); 
//		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 380, 255, 0);
//		System.out.println("Generando c26: " + phraset);
		phraset = new Phrase(c27);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 452, 615, 0);
		System.out.println("Generando c27: " + phraset);
		phraset = new Phrase(c28);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 492, 615, 0);
		System.out.println("Generando c28: " + phraset);
		phraset = new Phrase(c29);        
		System.out.println("Generando c29: " + phraset);
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 32, 599, 0);
		phraset = new Phrase(c30);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 137, 599, 0);
		System.out.println("Generando c30: " + phraset);


		contCar++;

		System.out.println("Generando Endosos: " + contCar + " " + c344);
		canvas.endText();
		canvas2.endText();
		stamper.close();
	}


}