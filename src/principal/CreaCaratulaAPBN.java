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

public class CreaCaratulaAPBN {



	
	public static final String plantilla = CtsArmado.pathJar + "Plantilla AP BN.pdf";
	public static String pathSal = CtsArmado.pathSal;
	public static final String path = CtsArmado.pathSpool + "Spool_Carat_AP.txt";

	int contCar = 0;
	int largoArreg = 0;
	String poliza = "";

	public CreaCaratulaAPBN(String nNegocio) {
		pathSal = CtsArmado.pathSal;
		pathSal  = pathSal + nNegocio;
	}

	public static void main(String[] args) {
		try{
			CreaCaratulaAPBN cc = new CreaCaratulaAPBN("");		
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
		String datos[] = new String[40];
		f = new File(file);
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader(f));        	
		while(flag){
			cont=0;
//			br.readLine();
			if((line = br.readLine()) == null){
				break;
			}
			
			while((line.trim().indexOf("DJD1 FEED='SEGU1")<0) && (line = br.readLine()) != null){
			
			}
			
			while(((line = br.readLine()) != null)&&(cont<40) ){
				
				if(line.length()>0){
					datos[cont]=line.substring(1, line.length());
					if(line.indexOf("DJD1 FEED='SEGU1',FORM=AZ89A,END;")>-1){
						break;
					}
				}else
					datos[cont]="";
				cont++;
			}
			if(line!=null){
				creaCaraAP(datos);
				cont=0;
			}else{
				flag= false;
			}
		}
		br.close();
	}

	public void creaCaraAP(String[] datos) throws IOException, DocumentException{
		PdfReader reader;

		PdfStamper stamper = null;
		reader = new PdfReader(plantilla);
		Font Arial=new Font(Font.getFamily("Arial"),(float) 10);
		Arial.setColor(80, 80, 80);
		datos[1] = datos[1].replaceAll("#", "Ñ");
		datos[2] = datos[2].replaceAll("#", "Ñ");
		datos[3] = datos[3].replaceAll("#", "Ñ");
		datos[4] = datos[4].replaceAll("#", "Ñ");
		datos[5] = datos[5].replaceAll("#", "Ñ");
		datos[6] = datos[6].replaceAll("#", "Ñ");
		datos[7] = datos[7].replaceAll("#", "Ñ");
		datos[8] = datos[8].replaceAll("#", "Ñ");
		datos[9] = datos[9].replaceAll("#", "Ñ");
		
		poliza = (((datos[6].substring(49, 51).trim())) + ((datos[6].substring(61, 67).trim())));
		System.out.println("poliza: " + poliza);
		File fl = new File(pathSal+ "\\"+poliza+"\\Caratula\\");
		fl.mkdirs();
		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+ "\\"+poliza+"\\Caratula\\"+"Caratula_AP_"+poliza+".pdf"));
		Phrase phraset = null;
		PdfContentByte canvas;  
		canvas = stamper.getOverContent(1);
		canvas.beginText(); 
		Chunk c1=null;
		
		largoArreg = datos[1].length();
		if (largoArreg > 40){
			c1= new Chunk(datos[1].substring(0, 40).trim(), Arial);
		}else {
		c1= new Chunk(datos[1].substring(0, largoArreg).trim(), Arial);
		}

		largoArreg = datos[2].length();
		Chunk c2 = new Chunk(datos[2].substring(0, 20).trim(), Arial);

		largoArreg = datos[3].length();
		Chunk c3= new Chunk(datos[3].substring(0, largoArreg).trim(), Arial);

		largoArreg = datos[4].length();
		Chunk c4= new Chunk(datos[4].substring(0, largoArreg).trim(), Arial);

		largoArreg = datos[5].length();
		Chunk c5 = new Chunk(datos[5].substring(0, largoArreg).trim(), Arial);

		largoArreg = datos[6].length();
		Chunk c6= new Chunk(datos[6].substring(49, 51).trim(), Arial);
		Chunk c7= new Chunk(datos[6].substring(61, 67).trim(), Arial);
		Chunk c8 = new Chunk(datos[6].substring(70, 82).trim(), Arial);
		Chunk c9= new Chunk(datos[6].substring(82, largoArreg), Arial);
		
		Chunk c10 = null;
		Chunk c11 = null;
		Chunk c12 = null;
		Chunk c13 = null;
		Chunk c14 = null;
		Chunk c15 = null;
		Chunk c16 = null;
		Chunk c17 = null;
		Chunk c18 = null;
		Chunk c19 = null;
		Chunk c20 = null;
		largoArreg = datos[8].length();
		if (largoArreg < 30){
		c10= new Chunk(datos[8].substring(1,3), Arial);					//DIA
		c11 = new Chunk(datos[8].substring(5,7), Arial);//MES
		c12= new Chunk(datos[8].substring(9,13), Arial);//AÑO
		c13= new Chunk(datos[8].substring(16,18), Arial);//DIA
		c14 = new Chunk(datos[8].substring(20,22), Arial);//MES
		c15= new Chunk(datos[8].substring(24,28), Arial);//AÑO
		c16= new Chunk();//PRIMA NETA
		c17= new Chunk();// GASTOS DE EXPEDICION
		c18= new Chunk();// PRIMA NETA TOTAL
		c19 = new Chunk();// IVA
		c20= new Chunk(); // TOTAL A PAGAR
		}else{
			c10= new Chunk(datos[8].substring(1,3), Arial);					//DIA
			c11 = new Chunk(datos[8].substring(5,7), Arial);//MES
			c12= new Chunk(datos[8].substring(9,13), Arial);//AÑO
			c13= new Chunk(datos[8].substring(16,18), Arial);//DIA
			c14 = new Chunk(datos[8].substring(20,22), Arial);//MES
			c15= new Chunk(datos[8].substring(24,28), Arial);//AÑO
			c16= new Chunk(datos[8].substring(31,43), Arial);//PRIMA NETA
			c17= new Chunk(datos[8].substring(44,54).trim(), Arial);// GASTOS DE EXPEDICION
			c18= new Chunk(datos[8].substring(55,68).trim(), Arial);// PRIMA NETA TOTAL
			c19 = new Chunk(datos[8].substring(69,80).trim(), Arial);// IVA
			c20= new Chunk(datos[8].substring(81, largoArreg).trim(), Arial); // TOTAL A PAGAR
		}


		largoArreg = datos[9].length();
		Chunk c21 = new Chunk(datos[9].substring(0, 40).trim(), Arial); //RAZON SOCIAL
		Chunk c22 = new Chunk(datos[9].substring(45,55).trim(), Arial); // RIESGO
		Chunk c921 = new Chunk(datos[9].substring(60,65).trim(), Arial);// ASEGURADOS
		Chunk c922 = new Chunk(datos[9].substring(65,80).trim(), Arial);// RECARGO POR PAGO FRACCIONADO
		Chunk c23= new Chunk(datos[9].substring(81,largoArreg).trim(), Arial);// FORMA DE PAGO
		
		//COBERTURA 1
		largoArreg = datos[12].length();
		Chunk cA23= new Chunk(datos[12].substring(0,largoArreg).trim(), Arial);
		
		largoArreg = datos[13].length();
		Chunk c24 = null;
		Chunk c024 = null;
		Chunk cA24 = null;
		if(largoArreg > 0 && largoArreg < 49){
			c24 = new Chunk(datos[13].substring(0, 38).trim(), Arial);
			c024 = new Chunk();
			cA24 = new Chunk();
		} else if (largoArreg > 49 && largoArreg < 80){
			c24 = new Chunk(datos[13].substring(0, 38).trim(), Arial);
			c024 = new Chunk(datos[13].substring(38, largoArreg).trim(), Arial);
			cA24 = new Chunk();
		}else if (largoArreg > 80){
			c24 = new Chunk(datos[13].substring(0, 38).trim(), Arial);
			c024 = new Chunk(datos[13].substring(38, 60).trim(), Arial);
			cA24 = new Chunk(datos[13].substring(60, largoArreg).trim(), Arial);
		} else{
			c24 = new Chunk();
			c024 = new Chunk();
			cA24 = new Chunk();
		}
		
		//COBERTURA 2
		Chunk c25= null;
		Chunk c124= null;
		Chunk c125= null;
		largoArreg = datos[14].length();
		if(largoArreg > 0 && largoArreg < 49){
			c25 = new Chunk(datos[14].substring(0, 38).trim(), Arial);
			c124 = new Chunk();
			c125 = new Chunk();
		} else if (largoArreg > 49 && largoArreg < 80){
			c25 = new Chunk(datos[14].substring(0, 38).trim(), Arial);
			c124 = new Chunk(datos[14].substring(38, largoArreg).trim(), Arial);
			c125 = new Chunk();
		}else if (largoArreg > 80){
			c25 = new Chunk(datos[14].substring(0, 38).trim(), Arial);
			c124 = new Chunk(datos[14].substring(38, 60).trim(), Arial);
			c125 = new Chunk(datos[14].substring(60, largoArreg).trim(), Arial);
		}else{
			c25 = new Chunk();
			c124 = new Chunk();
			c125 = new Chunk();
		}
		
		//COBERTURA 3
		Chunk c26= null;
		Chunk c224= null;
		Chunk c324= null;
		largoArreg = datos[15].length();
		
		if(largoArreg > 10 && largoArreg < 50){
			c26 = new Chunk(datos[15].substring(0, 38).trim(), Arial);
			c224 = new Chunk();
			c324 = new Chunk();
		} else if (largoArreg > 50 && largoArreg < 80){
			c26 = new Chunk(datos[15].substring(0, 38).trim(), Arial);
			c224 = new Chunk(datos[15].substring(38, largoArreg).trim(), Arial);
			c324 = new Chunk();
		}else if (largoArreg > 80){
			c26 = new Chunk(datos[15].substring(0, 38).trim(), Arial);
			c224 = new Chunk(datos[15].substring(38, 60).trim(), Arial);
			c324 = new Chunk(datos[15].substring(60, largoArreg).trim(), Arial);
		}else{
			c26 = new Chunk();
			c224 = new Chunk();
			c324 = new Chunk();
		}
		// COBERTURA 4
		Chunk cA16= null;
		Chunk cB16= null;
		Chunk cC16= null;
		largoArreg = datos[16].length();
		
		if(largoArreg > 0 && largoArreg < 50){
			cA16 = new Chunk(datos[16].substring(0, 38).trim(), Arial);
			cB16 = new Chunk();
			cC16 = new Chunk();
		} else if (largoArreg > 50 && largoArreg < 80){
			cA16 = new Chunk(datos[16].substring(0, 38).trim(), Arial);
			cB16 = new Chunk(datos[16].substring(38, largoArreg).trim(), Arial);
			cC16 = new Chunk();
		}else if (largoArreg > 80){
			cA16 = new Chunk(datos[16].substring(0, 38).trim(), Arial);
			cB16 = new Chunk(datos[16].substring(38, 60).trim(), Arial);
			cC16 = new Chunk(datos[16].substring(60, largoArreg).trim(), Arial);
		}else{
			cA16 = new Chunk();
			cB16 = new Chunk();
			cC16 = new Chunk();
		}
		
		// COBERTURA 5
		
		Chunk cA17= null;
		Chunk cB17= null;
		Chunk cC17= null;
		largoArreg = datos[17].length();
		
		if(largoArreg > 0 && largoArreg < 50){
			cA17 = new Chunk(datos[17].substring(0, 38).trim(), Arial);
			cB17 = new Chunk();
			cC17 = new Chunk();
		} else if (largoArreg > 50 && largoArreg < 80){
			cA17 = new Chunk(datos[17].substring(0, 38).trim(), Arial);
			cB17 = new Chunk(datos[17].substring(38, largoArreg).trim(), Arial);
			cC17 = new Chunk();
		}else if (largoArreg > 80){
			cA17 = new Chunk(datos[17].substring(0, 38).trim(), Arial);
			cB17 = new Chunk(datos[17].substring(38, 60).trim(), Arial);
			cC17 = new Chunk(datos[17].substring(60, largoArreg).trim(), Arial);
		}else{
			cA17 = new Chunk();
			cB17 = new Chunk();
			cC17 = new Chunk();
		}
		
		// COBERTURA 6
		Chunk cA18= null;
		Chunk cB18= null;
		Chunk cC18= null;
		largoArreg = datos[18].length();
		
		if(largoArreg > 0 && largoArreg < 50){
			cA18 = new Chunk(datos[18].substring(0, 38).trim(), Arial);
			cB18 = new Chunk();
			cC18 = new Chunk();
		} else if (largoArreg > 50 && largoArreg < 80){
			cA18 = new Chunk(datos[18].substring(0, 38).trim(), Arial);
			cB18 = new Chunk(datos[18].substring(38, largoArreg).trim(), Arial);
			cC18 = new Chunk();
		}else if (largoArreg > 80){
			cA18 = new Chunk(datos[18].substring(0, 38).trim(), Arial);
			cB18 = new Chunk(datos[18].substring(38, 60).trim(), Arial);
			cC18 = new Chunk(datos[18].substring(60, largoArreg).trim(), Arial);
		}else{
			cA18 = new Chunk();
			cB18 = new Chunk();
			cC18 = new Chunk();
		}
		//COBERTURA 7
		Chunk cA19= null;
		Chunk cB19= null;
		Chunk cC19= null;
		largoArreg = datos[19].length();
		
		if(largoArreg > 0 && largoArreg < 50){
			cA19 = new Chunk(datos[19].substring(0, largoArreg).trim(), Arial);
			cB19 = new Chunk();
			cC19 = new Chunk();
		} else if (largoArreg > 50 && largoArreg < 80){
			cA19 = new Chunk(datos[19].substring(0, 38).trim(), Arial);
			cB19 = new Chunk(datos[19].substring(38, largoArreg).trim(), Arial);
			cC19 = new Chunk();
		}else if (largoArreg > 80){
			cA19 = new Chunk(datos[19].substring(0, 38).trim(), Arial);
			cB19 = new Chunk(datos[19].substring(38, 60).trim(), Arial);
			cC19 = new Chunk(datos[19].substring(60, largoArreg).trim(), Arial);
		}else{
			cA19 = new Chunk();
			cB19 = new Chunk();
			cC19 = new Chunk();
		}
		// COBERTURA 8
		
		Chunk cA20= null;
		Chunk cB20= null;
		Chunk cC20= null;
		largoArreg = datos[20].length();
		
		if(largoArreg > 0 && largoArreg < 50){
			cA20 = new Chunk(datos[20].substring(0, largoArreg).trim(), Arial);
			cB20 = new Chunk();
			cC20 = new Chunk();
		} else if (largoArreg > 50 && largoArreg < 80){
			cA20 = new Chunk(datos[20].substring(0, 38).trim(), Arial);
			cB20 = new Chunk(datos[20].substring(38, largoArreg).trim(), Arial);
			cC20 = new Chunk();
		}else if (largoArreg > 80){
			cA20 = new Chunk(datos[20].substring(0, 38).trim(), Arial);
			cB20 = new Chunk(datos[20].substring(38, 60).trim(), Arial);
			cC20 = new Chunk(datos[20].substring(60, largoArreg).trim(), Arial);
		}else{
			cA20 = new Chunk();
			cB20 = new Chunk();
			cC20 = new Chunk();
		}
		
		largoArreg = datos[23].length();
		Chunk c34= new Chunk(datos[23].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[24].length();
		Chunk c35= new Chunk(datos[24].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[25].length();
		Chunk c36= new Chunk(datos[25].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[26].length();
		Chunk c38= new Chunk(datos[26].substring(0, largoArreg).trim(), Arial);
			
		largoArreg = datos[32].length();
		Chunk c43 = new Chunk(datos[32].substring(70, 72).trim(), Arial);
		largoArreg = datos[32].length();
		Chunk c44 = new Chunk(datos[32].substring(78, 89).trim(), Arial);
		largoArreg = datos[32].length();
		Chunk c45 = new Chunk(datos[32].substring(90, largoArreg).trim(), Arial);
		
		largoArreg = datos[33].length();
		Chunk c46 = new Chunk(datos[33].substring(0, largoArreg).trim(), Arial);
		
		largoArreg = datos[36].length();
		Chunk c47 = new Chunk(datos[36].substring(5, 20).trim(), Arial);
		largoArreg = datos[36].length();
		Chunk c48 = new Chunk(datos[36].substring(25, 40).trim(), Arial);
		largoArreg = datos[36].length();
		Chunk c49 = new Chunk(datos[36].substring(44, largoArreg).trim(), Arial);
		

		phraset = new Phrase(c1);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 40, 690, 0);         
		System.out.println("Generando c01: " + phraset);
		phraset = new Phrase(c2);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 40, 678, 0);
		System.out.println("Generando c2: " + phraset);
		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 40, 666, 0); 
		System.out.println("Generando c3: " + phraset);
		phraset = new Phrase(c4); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 40, 654, 0);  
		System.out.println("Generando c4: " + phraset);
		phraset = new Phrase(c5);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 40, 642, 0);
		System.out.println("Generando c5: " + phraset);
		
		phraset = new Phrase(c6); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 310, 635, 0);
		System.out.println("Generando c6: " + phraset);
		phraset = new Phrase(c7);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 370, 635, 0);
		System.out.println("Generando c7: " + phraset);
		phraset = new Phrase(c8); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 435, 635, 0); 
		System.out.println("Generando c8: " + phraset);
		phraset = new Phrase(c9);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 505, 635, 0);
		System.out.println("Generando c9: " + phraset);
		
		phraset = new Phrase(c10); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 38, 582, 0);
		System.out.println("Generando c10: " + phraset);
		phraset = new Phrase(c11);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 62, 582, 0);
		System.out.println("Generando c11: " + phraset);
		phraset = new Phrase(c12); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 90, 582, 0); 
		System.out.println("Generando c12: " + phraset);
		phraset = new Phrase(c13); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 122, 582, 0); 
		System.out.println("Generando c13: " + phraset);
		phraset = new Phrase(c14);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 145, 582, 0);
		System.out.println("Generando c14: " + phraset);
		phraset = new Phrase(c15); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 168, 582, 0);
		System.out.println("Generando c15: " + phraset);
		phraset = new Phrase(c16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 218, 582, 0);
		System.out.println("Generando c16: " + phraset);
		phraset = new Phrase(c17);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 290, 582, 0);
		System.out.println("Generando c17: " + phraset);
		phraset = new Phrase(c18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 355, 582, 0);
		System.out.println("Generando c18: " + phraset);
		phraset = new Phrase(c19); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 438, 582, 0);
		System.out.println("Generando c19: " + phraset);
		phraset = new Phrase(c20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 510, 582, 0);
		System.out.println("Generando c20: " + phraset);

		phraset = new Phrase(c21);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 40, 540, 0);
		System.out.println("Generando c21: " + phraset);
		phraset = new Phrase(c22); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 303, 540, 0);
		System.out.println("Generando c22: " + phraset);
		phraset = new Phrase(c921);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 355, 540, 0);
		System.out.println("Generando c921: " + phraset);
		phraset = new Phrase(c922); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 435, 540, 0);
		System.out.println("Generando c922: " + phraset);
		phraset = new Phrase(c23);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 500, 540, 0);
		System.out.println("Generando c23: " + phraset);
		
		phraset = new Phrase(cA23);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 450, 0);
		System.out.println("Generando cA23: " + phraset);
		phraset = new Phrase(c24); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 438, 0);  
		System.out.println("Generando c24: " + phraset);
		phraset = new Phrase(c024);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 438, 0);
		System.out.println("Generando c024: " + phraset);
		phraset = new Phrase(cA24);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 438, 0);
		System.out.println("Generando cA24: " + phraset);
		phraset = new Phrase(c25);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 426, 0);
		System.out.println("Generando c25: " + phraset);
		phraset = new Phrase(c124);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 426, 0);
		System.out.println("Generando c124: " + phraset);
		phraset = new Phrase(c125);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 426, 0);
		System.out.println("Generando c125: " + phraset);
		phraset = new Phrase(c26);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 414, 0);
		System.out.println("Generando c26: " + phraset);
		phraset = new Phrase(c224);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 414, 0);
		System.out.println("Generando c224: " + phraset);
		phraset = new Phrase(c324);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 414, 0);
		System.out.println("Generando c324: " + phraset);
		phraset = new Phrase(cA16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 402, 0);
		System.out.println("Generando cA16: " + phraset);
		phraset = new Phrase(cB16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 402, 0);
		System.out.println("Generando cB16: " + phraset);
		phraset = new Phrase(cC16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 402, 0);
		System.out.println("Generando cC16: " + phraset);
		phraset = new Phrase(cA17);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 390, 0);
		System.out.println("Generando cA17: " + phraset);
		phraset = new Phrase(cB17);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 490, 0);
		System.out.println("Generando cB17: " + phraset);
		phraset = new Phrase(cC17);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 490, 0);
		System.out.println("Generando cC17: " + phraset);
		phraset = new Phrase(cA18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 378, 0);
		System.out.println("Generando cA18: " + phraset);
		phraset = new Phrase(cB18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 378, 0);
		System.out.println("Generando cB18: " + phraset);
		phraset = new Phrase(cC18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 378, 0);
		System.out.println("Generando cC18: " + phraset);
		phraset = new Phrase(cA19);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 366, 0);
		System.out.println("Generando cA19: " + phraset);
		phraset = new Phrase(cB19);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 366, 0);
		System.out.println("Generando cB19: " + phraset);
		phraset = new Phrase(cC19);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 366, 0);
		System.out.println("Generando cC19: " + phraset);
		phraset = new Phrase(cA20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 354, 0);
		System.out.println("Generando cA20: " + phraset);
		phraset = new Phrase(cB20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 270, 354, 0);
		System.out.println("Generando cB20: " + phraset);
		phraset = new Phrase(cC20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 354, 0);
		System.out.println("Generando cC20: " + phraset);

		phraset = new Phrase(c34); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 390, 318, 0);  
		System.out.println("Generando c34: " + phraset);
		phraset = new Phrase(c35); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 306, 0);  
		System.out.println("Generando c35: " + phraset);
		phraset = new Phrase(c36); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 282, 0);  
		System.out.println("Generando c36: " + phraset);
		phraset = new Phrase(c38); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 35, 270, 0);  
		System.out.println("Generando c38: " + phraset);
		
		phraset = new Phrase(c43); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 448, 178, 0);  
		System.out.println("Generando c43: " + phraset);
		phraset = new Phrase(c44); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 478, 178, 0);  
		System.out.println("Generando c44: " + phraset);
		phraset = new Phrase(c45); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 548, 178, 0);  
		System.out.println("Generando c45: " + phraset);
		phraset = new Phrase(c46); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 126, 165, 0);  
		System.out.println("Generando c46: " + phraset);

		phraset = new Phrase(c47); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 45, 75, 0);  
		System.out.println("Generando c47: " + phraset);
		phraset = new Phrase(c48); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 140, 75, 0);  
		System.out.println("Generando c48: " + phraset);
		phraset = new Phrase(c49); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 235, 75, 0);  
		System.out.println("Generando c49: " + phraset);
		
		contCar++;
		System.out.println("Generando caratulaAP: " + contCar);
		canvas.endText();
		stamper.close();
	}
}
