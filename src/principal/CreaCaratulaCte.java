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

public class CreaCaratulaCte {

	public static final String plantilla = CtsArmado.pathJar + "Plantilla GM05 Color.pdf";
	public static String pathSal = CtsArmado.pathSal;
	public static final String path = CtsArmado.pathSpool + "Spool_Carat_Aseg.txt";

	int contCar = 0;
	int largoArreg = 0;
	String poliza = "";
	String primNeta = "", derPoliza="", primTotal="", totalPagar= "", importePrem="";


	public CreaCaratulaCte(String nNegocio, String primNeta, String derPoliza, String primTotal, String totalPagar, String importePrem) {
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
			CreaCaratulaCte cc = new CreaCaratulaCte("","","","","","");		
			cc.creaCaratulaColor(path);
		} catch (Exception e) {			
			e.printStackTrace();
	
		}finally{
			//poder continuar despues de una exception
		}
	}

	public boolean creaCaratulaColor(String file){
		boolean flagDoc = false;
		try{
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
//			br.readLine();
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
					if(line.indexOf("CNSF")>-1){
//						datos[cont]=line;
						break;
					}
				}else
					datos[cont]="";
				cont++;
			}
			if(line!=null){
				creaCaraCte(datos);
				cont=0;
				flagDoc = true;
			}else{
				flag= false;
			}
		}
		br.close();
		}
		catch (IOException c) {
			// TODO: handle exception
		}catch(DocumentException e){
			
		}
		return flagDoc;

	}

	public void creaCaraCte(String[] datos) throws IOException, DocumentException{
		PdfReader reader;
		PdfStamper stamper = null;
		reader = new PdfReader(plantilla);
		Font Arial=new Font(Font.getFamily("Arial"),(float) 10);
		Arial.setColor(23, 54, 93);

		poliza = (((datos[0].substring(83, 85).trim())) + ((datos[0].substring(86, 99).trim())));
		System.out.println("poliza: " + poliza);
		File fl = new File(pathSal+ "\\"+poliza+"\\Caratula\\");
		fl.mkdirs();
		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+ "\\"+poliza+"\\Caratula\\"+"Caratula_Asegurado_"+poliza+".pdf"));
//		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+"_"+datos[0].substring(datos[0].length()/2, ((datos[0].length()/2)+50)).trim()+"_"+contCar+".pdf"));
		Phrase phraset = null;
		PdfContentByte canvas;  
		PdfContentByte canvas2;
		canvas = stamper.getOverContent(1);
		canvas2 = stamper.getOverContent(2);
		canvas.beginText(); 

		largoArreg = datos[0].length();
		Chunk c0= new Chunk(datos[0].substring(0, 16), Arial);

		largoArreg = datos[0].length();
		Chunk c1= new Chunk(datos[0].substring(83, 93).trim(), Arial);

		largoArreg = datos[2].length();
		Chunk c2 = new Chunk(datos[2].substring(10, 65), Arial);

		largoArreg = datos[2].length();
		Chunk c3= new Chunk(datos[2].substring(65, largoArreg).trim(), Arial);

		largoArreg = datos[4].length();
		Chunk c4= new Chunk(datos[4].substring(10, 70).trim(), Arial);

		largoArreg = datos[4].length();
		Chunk c5 = new Chunk(datos[4].substring(70, largoArreg).trim(), Arial);

		largoArreg = datos[5].length();
		Chunk c6= new Chunk(datos[5].substring(10, largoArreg).trim(), Arial);

		largoArreg = datos[6].length();
		Chunk c7= new Chunk(datos[6].substring(10, largoArreg).trim(), Arial);

		largoArreg = datos[8].length();
		Chunk c8 = new Chunk(datos[8].substring(0, 2), Arial);
		Chunk c9= new Chunk(datos[8].substring(5, 9), Arial);
		Chunk c10= new Chunk(datos[8].substring(9,13), Arial);
		Chunk c11 = new Chunk(datos[8].substring(16,18), Arial);
		Chunk c12= new Chunk(datos[8].substring(21,23), Arial);
		Chunk c13= new Chunk(datos[8].substring(26,30), Arial);
		Chunk c14 = new Chunk(datos[8].substring(37,45), Arial);
		Chunk c15= new Chunk(datos[8].substring(60,75).trim(), Arial);
		Chunk c16= new Chunk(datos[8].substring(82,92), Arial);


		largoArreg = datos[9].length();
		Chunk c17=null;
		Chunk c18=null;
		Chunk c19=null;
		Chunk c20=null;
		
		if(largoArreg > 80)
		{
			c17= new Chunk(datos[9].substring(0,25 ).trim(), Arial);
			c18= new Chunk(datos[9].substring(27,55).trim(), Arial);
			c19 = new Chunk(datos[9].substring(55,75).trim(), Arial);
			c20= new Chunk(datos[9].substring(81, largoArreg).trim(), Arial);
		}else if (this.largoArreg >= 70 && this.largoArreg < 80){
			c17= new Chunk(datos[9].substring(0,25 ).trim(), Arial);
			c18= new Chunk(datos[9].substring(27,55).trim(), Arial);
			c19 = new Chunk(datos[9].substring(55,largoArreg).trim(), Arial);
			c20 = new Chunk();
		}else if (this.largoArreg > 30 && this.largoArreg < 65){
            c17 = new Chunk(datos[9].substring(0, 27).trim(), Arial);
            c18 = new Chunk(datos[9].substring(27, largoArreg).trim(), Arial);
            c19 = new Chunk();
            c20 = new Chunk();
        	}else if (this.largoArreg < 40){
    			c17= new Chunk(datos[9].substring(0, largoArreg).trim(), Arial);
    			c18= new Chunk();
    			c19 = new Chunk();
    			c20 = new Chunk();
    		}else{
			c17= new Chunk();
			c18= new Chunk();
			c19 = new Chunk();
			c20 = new Chunk();
		}


		largoArreg = datos[10].length();
		Chunk c21= null;
		Chunk c22= null;
		Chunk c23= null;
		Chunk c24= null;
		if(largoArreg > 80){
			c21= new Chunk(datos[10].substring(0,30).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32,50), Arial);
			c23= new Chunk(datos[10].substring(55,75).trim(), Arial);
			c24 = new Chunk(datos[10].substring(81, largoArreg).trim(), Arial);
		}else if ((largoArreg > 65 && largoArreg < 80)){
			c21= new Chunk(datos[10].substring(0,15).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32,50), Arial);
			c23= new Chunk(datos[10].substring(56,largoArreg).trim(), Arial);
			c24 = new Chunk();
		}
		else if (this.largoArreg > 30 && this.largoArreg < 65){
			c21= new Chunk(datos[10].substring(0,30).trim(), Arial);
			c22 = new Chunk(datos[10].substring(31,largoArreg).trim(), Arial);
			c23= new Chunk();
			c24 = new Chunk();
		}else if (this.largoArreg < 40){
			c21= new Chunk(datos[10].substring(0,largoArreg).trim(), Arial);
			c22 = new Chunk();
			c23= new Chunk();
			c24 = new Chunk();
		}
		else {
			c21= new Chunk();
			c22 = new Chunk();
			c23= new Chunk();
			c24 = new Chunk();
		}
			
		largoArreg = datos[11].length();
		Chunk c210= null;
		Chunk c220= null;
		Chunk c230= null;
		Chunk c240= null;
		if(largoArreg > 80){
			c210= new Chunk(datos[11].substring(0,22).trim(), Arial);
			c220= new Chunk(datos[11].substring(23,55).trim(), Arial);
			c230= new Chunk(datos[11].substring(56,78).trim(), Arial);
			c240= new Chunk(datos[11].substring(79, largoArreg).trim(), Arial);
		}else if ((largoArreg > 65 && largoArreg < 80)){
			c210= new Chunk(datos[11].substring(0,15).trim(), Arial);
			c220= new Chunk(datos[11].substring(32,50), Arial);
			c230= new Chunk(datos[11].substring(56,largoArreg).trim(), Arial);
			c240= new Chunk();
		}
		else if (largoArreg > 30 && largoArreg < 65){
			c210= new Chunk(datos[11].substring(0,32).trim(), Arial);
			c220= new Chunk(datos[11].substring(32,largoArreg).trim(), Arial);
			c230= new Chunk();
			c240= new Chunk();
		}else{
			c210= new Chunk(datos[11].substring(0,largoArreg).trim(), Arial);
			c220= new Chunk();
			c230= new Chunk();
			c240= new Chunk();
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
			
			largoArreg = datos[13].length();
			Chunk c251= new Chunk();
			Chunk c251A= new Chunk();
			if(largoArreg < 66){
			c251= new Chunk(datos[13].substring(0, largoArreg).trim(), Arial);
			}
			else if(largoArreg > 30 && largoArreg < 65){
				c251= new Chunk(datos[13].substring(0, 30).trim(), Arial);
				c251A= new Chunk(datos[13].substring(31, largoArreg).trim(), Arial);
			}
			
			largoArreg = datos[14].length();
			Chunk c252= new Chunk(datos[14].substring(0, largoArreg).trim(), Arial);
			
		largoArreg = datos[16].length();
		Chunk c25= new Chunk(datos[16].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[17].length();
		Chunk cA25= new Chunk(datos[17].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[20].length();
		Chunk c26= new Chunk(datos[20].substring(0, largoArreg).trim(), Arial);

		largoArreg = datos[21].length();
		Chunk c27 = new Chunk(datos[21].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[22].length();
		Chunk c27A = new Chunk(datos[22].substring(0, largoArreg).trim(), Arial);

		largoArreg = datos[23].length();
		Chunk c28= new Chunk(datos[23].substring(0, largoArreg).trim(), Arial);

		largoArreg = datos[24].length();
		Chunk c29= new Chunk(datos[24].substring(0, largoArreg).trim(), Arial);

		Chunk c30 = null;
		Chunk c31= null;
		Chunk c32= null;
		Chunk c33 = null;
		Chunk c34 = null;
		Chunk c35 = null;
		Chunk c36 = null;
		
		largoArreg = datos[28].length();

		if (largoArreg > 10){
			if(primNeta.equals("")){
				c30 = new Chunk(datos[28].substring(0, 14).trim(), Arial);
			}else{
				c30 = new Chunk(primNeta.trim(), Arial);
			}
			
			if(derPoliza.equals("")){
				c31= new Chunk(datos[28].substring(14,26).trim(), Arial);
			}else{
				c31 = new Chunk(derPoliza.trim(), Arial);
			}
			
			c32= new Chunk(datos[28].substring(26,39).trim(), Arial);;
			
			if(primTotal.equals("")){
				c33 = new Chunk(datos[28].substring(39,54).trim(), Arial);
			}else{
				c33 = new Chunk(primTotal.trim(), Arial);
			}
					
		c34 = new Chunk(datos[28].substring(54,68).trim(), Arial);
		
		if(totalPagar.equals("")){
			c35 = new Chunk(datos[28].substring(68,82).trim(), Arial);
		}else{
			c35 = new Chunk(totalPagar.trim(), Arial);
		}
		
		if(importePrem.equals("")){
			c36 = new Chunk(datos[28].substring(82, largoArreg).trim(), Arial);
		}else{
			c36 = new Chunk(importePrem.trim(), Arial);
		}
		
		}else{
			c30 = new Chunk();
			c31= new Chunk();
			c32= new Chunk();;
			c33 = new Chunk();
			c34 = new Chunk();
			c35 = new Chunk();
			c36 = new Chunk();
		}
		
		largoArreg = datos[29].length();
		Chunk c37 = new Chunk(datos[29].substring(0, 15).trim(), Arial);
		
		largoArreg = datos[29].length();
		Chunk c38 = new Chunk(datos[29].substring(15,24).trim(), Arial);
		
		largoArreg = datos[29].length();
		Chunk c39 = new Chunk(datos[29].substring(24,80).trim(), Arial);
		
		largoArreg = datos[29].length();
		Chunk c40 = new Chunk(datos[29].substring(80,85).trim(), Arial);
		
		largoArreg = datos[29].length();
		Chunk c41 = new Chunk(datos[29].substring(85, largoArreg).trim(), Arial);
		
		Chunk c42 =null;
		Chunk c43 =null;
		Chunk c44 =null;
		largoArreg = datos[71].length();
		if (largoArreg > 10){
		c42 = new Chunk(datos[71].substring(7, 9), Arial);
		c43 = new Chunk(datos[71].substring(13, 30).trim(), Arial);
		c44 = new Chunk(datos[71].substring(30, 34).trim(), Arial);
		}else{
		c42 = new Chunk();
		c43 = new Chunk();
		c44 = new Chunk();
		}
		largoArreg = datos[72].length();
		
		Chunk c45 = new Chunk(datos[72].substring(0, 41).trim(), Arial);
		
		phraset = new Phrase(c0);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 28, 697, 0);         
		System.out.println("Generando c0: " + phraset);
		
		Arial.setSize((float) 11);
		Arial.setStyle(1);
		phraset = new Phrase(c1);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 532, 697, 0);         
		System.out.println("Generando c01: " + phraset);

		Arial.setSize((float) 10);
		Arial.setStyle(0);
		
		phraset = new Phrase(c2);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 671, 0);
		System.out.println("Generando c2: " + phraset);
		
		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 455, 671, 0); 
		System.out.println("Generando c3: " + phraset);
		
		phraset = new Phrase(c4); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 635, 0);  
		System.out.println("Generando c4: " + phraset);
		phraset = new Phrase(c5);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 487, 635, 0);
		System.out.println("Generando c5: " + phraset);
		phraset = new Phrase(c6); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 625, 0);
		System.out.println("Generando c6: " + phraset);
		phraset = new Phrase(c7);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 85, 613, 0);
		System.out.println("Generando c7: " + phraset);
		phraset = new Phrase(c8); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 32, 561, 0); 
		System.out.println("Generando c8: " + phraset);
		phraset = new Phrase(c9);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 64, 561, 0);
		System.out.println("Generando c9: " + phraset);
		phraset = new Phrase(c10); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 92, 561, 0);
		System.out.println("Generando c10: " + phraset);
		phraset = new Phrase(c11);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 129, 561, 0);
		System.out.println("Generando c11: " + phraset);
		phraset = new Phrase(c12); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 158, 561, 0); 
		System.out.println("Generando c12: " + phraset);
		phraset = new Phrase(c13); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 185, 561, 0); 
		System.out.println("Generando c13: " + phraset);

		phraset = new Phrase(c14);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 240, 570, 0);
		System.out.println("Generando c14: " + phraset);
		phraset = new Phrase(c15); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 355, 570, 0);
		System.out.println("Generando c15: " + phraset);
		phraset = new Phrase(c16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 495, 570, 0);
		System.out.println("Generando c16: " + phraset);


		phraset = new Phrase(c17);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 533, 0);
		System.out.println("Generando c17: " + phraset);

		phraset = new Phrase(c18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 227, 533, 0);
		System.out.println("Generando c18: " + phraset);
		phraset = new Phrase(c19); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 362, 533, 0);
		System.out.println("Generando c19: " + phraset);
		phraset = new Phrase(c20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 510, 533, 0);
		System.out.println("Generando c20: " + phraset);


		phraset = new Phrase(c21);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 523, 0);
		System.out.println("Generando c21: " + phraset);
		phraset = new Phrase(c22); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 227, 523, 0);
		System.out.println("Generando c22: " + phraset);
		phraset = new Phrase(c23);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 362, 523, 0);
		System.out.println("Generando c23: " + phraset);
		phraset = new Phrase(c24); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 510, 523, 0);  
		System.out.println("Generando c24: " + phraset);
		
		phraset = new Phrase(c210);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 513, 0);
		System.out.println("Generando c210: " + phraset);
		phraset = new Phrase(c220); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 227, 513, 0);
		System.out.println("Generando c220: " + phraset);
		phraset = new Phrase(c230);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 362, 513, 0);
		System.out.println("Generando c230: " + phraset);
		phraset = new Phrase(c240); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 510, 513, 0);  
		System.out.println("Generando c240: " + phraset);
		
		phraset = new Phrase(c250); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 501, 0);  
		System.out.println("Generando c250: " + phraset);
		phraset = new Phrase(c250A); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 227, 501, 0);
		System.out.println("Generando c250A: " + phraset);
		 phraset = new Phrase(c250B);
	        ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)362.0f, (float)501.0f, (float)0.0f);
	        System.out.println("Generando c250B: " + (Object)phraset);
	        phraset = new Phrase(c250C);
	        ColumnText.showTextAligned((PdfContentByte)canvas, (int)0, (Phrase)phraset, (float)510.0f, (float)501.0f, (float)0.0f);
	        System.out.println("Generando c250C: " + (Object)phraset);
		
		phraset = new Phrase(c251); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 489, 0);  
		System.out.println("Generando c251: " + phraset);
		phraset = new Phrase(c251A); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 227, 489, 0);
		System.out.println("Generando c251A: " + phraset);
		
		phraset = new Phrase(c252); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 477, 0);  
		System.out.println("Generando c252: " + phraset);
		
		phraset = new Phrase(c25);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 417, 0);
		System.out.println("Generando c25: " + phraset);
		phraset = new Phrase(cA25);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 405, 0);
		System.out.println("Generando cA25: " + phraset);
		
		phraset = new Phrase(c26);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 365, 0);
		System.out.println("Generando c26: " + phraset);
		phraset = new Phrase(c27);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 355, 0);
		System.out.println("Generando c27: " + phraset);
		phraset = new Phrase(c27A);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 345, 0);
		System.out.println("Generando c27A: " + phraset);
		phraset = new Phrase(c28);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 323, 0);
		System.out.println("Generando c28: " + phraset);
		phraset = new Phrase(c29);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 559, 323, 0);
		System.out.println("Generando c29: " + phraset);
		phraset = new Phrase(c30);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 28,157 , 0);
		System.out.println("Generando c30: " + phraset);
		phraset = new Phrase(c31);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 122, 157, 0);  
		System.out.println("Generando c31: " + phraset);
		phraset = new Phrase(c32); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 189, 157, 0);
		System.out.println("Generando c32: " + phraset);
		phraset = new Phrase(c33); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 258, 157, 0); 
		System.out.println("Generando c33: " + phraset);
		phraset = new Phrase(c34); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 335, 157, 0);  
		System.out.println("Generando c34: " + phraset);
		phraset = new Phrase(c35); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 425, 157, 0);  
		System.out.println("Generando c35: " + phraset);
		phraset = new Phrase(c36); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 505, 157, 0);  
		System.out.println("Generando c36: " + phraset);
		phraset = new Phrase(c37); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 28, 107, 0);  
		System.out.println("Generando c37: " + phraset);
		phraset = new Phrase(c38); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 116, 107, 0);  
		System.out.println("Generando c38: " + phraset);
		phraset = new Phrase(c39); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 180, 107, 0);  
		System.out.println("Generando c39: " + phraset);
		phraset = new Phrase(c40); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 487, 107, 0);  
		System.out.println("Generando c40: " + phraset);
		phraset = new Phrase(c41); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 532, 107, 0);  
		System.out.println("Generando c41: " + phraset);

		phraset = new Phrase(c42); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset,  73, 336, 0);  
		System.out.println("Generando c42: " + phraset);
		phraset = new Phrase(c43); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 102, 336, 0);  
		System.out.println("Generando c43: " + phraset);
		phraset = new Phrase(c44); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 181, 336, 0);  
		System.out.println("Generando c44: " + phraset);
		phraset = new Phrase(c45); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset,36, 322, 0);  
		System.out.println("Generando c45: " + phraset);

		contCar++;
		System.out.println("Generando caratula asegurado: " + contCar);
		canvas.endText();
		stamper.close();
	}
}
