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

public class CreaCaratulaCteBN {

	public static final String plantilla = CtsArmado.pathJar + "Plantilla GM05 BN.pdf";
	public static String pathSal = CtsArmado.pathSal;
	public static final String path = CtsArmado.pathSpool + "Spool_Carat_Aseg.txt";

	int contCar = 0;
	int largoArreg = 0;
	String poliza = "";

	public CreaCaratulaCteBN(String nNegocio) {
		pathSal = CtsArmado.pathSal;
		pathSal  = pathSal + nNegocio;
	}

	public static void main(String[] args) {
		try{
			CreaCaratulaCteBN cc = new CreaCaratulaCteBN("");		
			cc.creaCaratulaColor(path);
		} catch (Exception e) {			
			e.printStackTrace();
	
		}finally{
			//poder continuar despues de una exception
		}
	}

	public void creaCaratulaColor(String file){
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
	}

	public void creaCaraCte(String[] datos) throws IOException, DocumentException{
		PdfReader reader;
		PdfStamper stamper = null;
		reader = new PdfReader(plantilla);
		Font Arial=new Font(Font.getFamily("Arial"),(float) 10);
		Arial.setColor(80, 80, 80);

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
			c18= new Chunk(datos[9].substring(25,54).trim(), Arial);
			c19 = new Chunk(datos[9].substring(54,75).trim(), Arial);
			c20= new Chunk(datos[9].substring(81, largoArreg).trim(), Arial);
		}else if (this.largoArreg >= 70 && this.largoArreg < 80){
			c17= new Chunk(datos[9].substring(0,25 ).trim(), Arial);
			c18= new Chunk(datos[9].substring(25,54).trim(), Arial);
			c19 = new Chunk(datos[9].substring(54,largoArreg).trim(), Arial);
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
			c21= new Chunk(datos[10].substring(0,32).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32,54), Arial);
			c23= new Chunk(datos[10].substring(54,75).trim(), Arial);
			c24 = new Chunk(datos[10].substring(81, largoArreg).trim(), Arial);
		}else if ((largoArreg > 65 && largoArreg < 80)){
			c21= new Chunk(datos[10].substring(0,32).trim(), Arial);
			c22 = new Chunk(datos[10].substring(32,54), Arial);
			c23= new Chunk(datos[10].substring(54,largoArreg).trim(), Arial);
			c24 = new Chunk();
		}
		else if (this.largoArreg > 30 && this.largoArreg < 65){
			c21= new Chunk(datos[10].substring(0,30).trim(), Arial);
			c22 = new Chunk(datos[10].substring(0,largoArreg).trim(), Arial);
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
			c210= new Chunk(datos[11].substring(0,18).trim(), Arial);
			c220= new Chunk(datos[11].substring(18,53).trim(), Arial);
			c230= new Chunk(datos[11].substring(53,75).trim(), Arial);
			c240= new Chunk(datos[11].substring(75, largoArreg).trim(), Arial);
		}else if ((largoArreg > 65 && largoArreg < 80)){
			c210= new Chunk(datos[11].substring(0,18).trim(), Arial);
			c220= new Chunk(datos[11].substring(18,53), Arial);
			c230= new Chunk(datos[11].substring(53,largoArreg).trim(), Arial);
			c240= new Chunk();
		}
		else if (largoArreg > 30 && largoArreg < 65){
			c210= new Chunk(datos[11].substring(0,largoArreg).trim(), Arial);
			c220= new Chunk(datos[11].substring(32,largoArreg).trim(), Arial);
			c230= new Chunk();
			c240= new Chunk();
		}else{
			c210= new Chunk(datos[11].substring(0,largoArreg).trim(), Arial);
			c220= new Chunk();
			c230= new Chunk();
			c240= new Chunk();}

			largoArreg = datos[12].length();
			Chunk c250= new Chunk(datos[12].substring(0, largoArreg).trim(), Arial);
			
			largoArreg = datos[13].length();
			Chunk c251= new Chunk(datos[13].substring(0, largoArreg).trim(), Arial);
			
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
		c30 = new Chunk(datos[28].substring(0, 14).trim(), Arial);
		c31= new Chunk(datos[28].substring(14,25).trim(), Arial);
		c32= new Chunk(datos[28].substring(25,39).trim(), Arial);;
		c33 = new Chunk(datos[28].substring(39,54).trim(), Arial);
		c34 = new Chunk(datos[28].substring(54,68).trim(), Arial);
		c35 = new Chunk(datos[28].substring(68,82).trim(), Arial);
		c36 = new Chunk(datos[28].substring(82, largoArreg).trim(), Arial);
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
		c43 = new Chunk(datos[71].substring(14, 30).trim(), Arial);
		c44 = new Chunk(datos[71].substring(30, 34).trim(), Arial);
		}else{
		c42 = new Chunk();
		c43 = new Chunk();
		c44 = new Chunk();
		}
		largoArreg = datos[72].length();
		
		Chunk c45 = new Chunk(datos[72].substring(0, 40).trim(), Arial);
		
		phraset = new Phrase(c0);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 24, 704, 0);         
		System.out.println("Generando c0: " + phraset);
		
		Arial.setSize((float) 10);
		Arial.setStyle(1);
		phraset = new Phrase(c1);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 528, 696, 0);         
		System.out.println("Generando c01: " + phraset);
		phraset = new Phrase(c2);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 79, 671, 0);
		System.out.println("Generando c2: " + phraset);
		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 416, 671, 0); 
		System.out.println("Generando c3: " + phraset);
		phraset = new Phrase(c4); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 79, 636, 0);  
		System.out.println("Generando c4: " + phraset);
		phraset = new Phrase(c5);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 451, 636, 0);
		System.out.println("Generando c5: " + phraset);
		phraset = new Phrase(c6); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 79, 626, 0);
		System.out.println("Generando c6: " + phraset);
		phraset = new Phrase(c7);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 79, 616, 0);
		System.out.println("Generando c7: " + phraset);
		phraset = new Phrase(c8); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 27, 553, 0); 
		System.out.println("Generando c8: " + phraset);
		phraset = new Phrase(c9);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 59, 553, 0);
		System.out.println("Generando c9: " + phraset);
		phraset = new Phrase(c10); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 88, 553, 0);
		System.out.println("Generando c10: " + phraset);
		phraset = new Phrase(c11);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 125, 553, 0);
		System.out.println("Generando c11: " + phraset);
		phraset = new Phrase(c12); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 154, 553, 0); 
		System.out.println("Generando c12: " + phraset);
		phraset = new Phrase(c13); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 182, 553, 0); 
		System.out.println("Generando c13: " + phraset);

		phraset = new Phrase(c14);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 243, 556, 0);
		System.out.println("Generando c14: " + phraset);
		phraset = new Phrase(c15); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 366, 556, 0);
		System.out.println("Generando c15: " + phraset);
		phraset = new Phrase(c16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 502, 554, 0);
		System.out.println("Generando c16: " + phraset);


		phraset = new Phrase(c17);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 525, 0);
		System.out.println("Generando c17: " + phraset);

		phraset = new Phrase(c18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 221, 525, 0);
		System.out.println("Generando c18: " + phraset);
		phraset = new Phrase(c19); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 368, 525, 0);
		System.out.println("Generando c19: " + phraset);
		phraset = new Phrase(c20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 522, 525, 0);
		System.out.println("Generando c20: " + phraset);


		phraset = new Phrase(c21);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 513, 0);
		System.out.println("Generando c21: " + phraset);
		phraset = new Phrase(c22); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 221, 513, 0);
		System.out.println("Generando c22: " + phraset);
		phraset = new Phrase(c23);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 368, 513, 0);
		System.out.println("Generando c23: " + phraset);
		phraset = new Phrase(c24); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 522, 513, 0);  
		System.out.println("Generando c24: " + phraset);
		
		phraset = new Phrase(c210);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 500, 0);
		System.out.println("Generando c210: " + phraset);
		phraset = new Phrase(c220); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 221, 500, 0);
		System.out.println("Generando c220: " + phraset);
		phraset = new Phrase(c230);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 368, 500, 0);
		System.out.println("Generando c230: " + phraset);
		phraset = new Phrase(c240); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 522, 500, 0);  
		System.out.println("Generando c240: " + phraset);
		
		phraset = new Phrase(c250); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 488, 0);  
		System.out.println("Generando c250: " + phraset);
		phraset = new Phrase(c251); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 488, 0);  
		System.out.println("Generando c251: " + phraset);
		phraset = new Phrase(c252); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 488, 0);  
		System.out.println("Generando c252: " + phraset);
		
		phraset = new Phrase(c25);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 400, 0);
		System.out.println("Generando c25: " + phraset);
		phraset = new Phrase(cA25);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 388, 0);
		System.out.println("Generando cA25: " + phraset);
		
		phraset = new Phrase(c26);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 316, 0);
		System.out.println("Generando c26: " + phraset);
		phraset = new Phrase(c27);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 306, 0);
		System.out.println("Generando c27: " + phraset);
		phraset = new Phrase(c28);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 18, 256, 0);
		System.out.println("Generando c28: " + phraset);
		phraset = new Phrase(c29);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 554, 256, 0);
		System.out.println("Generando c29: " + phraset);
		phraset = new Phrase(c30);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 26, 134, 0);
		System.out.println("Generando c30: " + phraset);
		phraset = new Phrase(c31);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 123, 134, 0);  
		System.out.println("Generando c31: " + phraset);
		phraset = new Phrase(c32); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 186, 134, 0);
		System.out.println("Generando c32: " + phraset);
		phraset = new Phrase(c33); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 271, 134, 0); 
		System.out.println("Generando c33: " + phraset);
		phraset = new Phrase(c34); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 352, 134, 0);  
		System.out.println("Generando c34: " + phraset);
		phraset = new Phrase(c35); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 435, 134, 0);  
		System.out.println("Generando c35: " + phraset);
		phraset = new Phrase(c36); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 520, 134, 0);  
		System.out.println("Generando c36: " + phraset);
		phraset = new Phrase(c37); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 28, 94, 0);  
		System.out.println("Generando c37: " + phraset);
		phraset = new Phrase(c38); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 114, 94, 0);  
		System.out.println("Generando c38: " + phraset);
		phraset = new Phrase(c39); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 175, 94, 0);  
		System.out.println("Generando c39: " + phraset);
		phraset = new Phrase(c40); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 502, 94, 0);  
		System.out.println("Generando c40: " + phraset);
		phraset = new Phrase(c41); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 553, 94, 0);  
		System.out.println("Generando c41: " + phraset);

		phraset = new Phrase(c42); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset,  66, 132, 0);  
		System.out.println("Generando c42: " + phraset);
		phraset = new Phrase(c43); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 98, 132, 0);  
		System.out.println("Generando c43: " + phraset);
		phraset = new Phrase(c44); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 172, 132, 0);  
		System.out.println("Generando c44: " + phraset);
		phraset = new Phrase(c45); 
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset,40, 119, 0);  
		System.out.println("Generando c45: " + phraset);

		contCar++;
		System.out.println("Generando caratula asegurado: " + contCar);
		canvas.endText();
		stamper.close();
	}
}
