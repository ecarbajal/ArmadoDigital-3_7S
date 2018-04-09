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
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class CreaCertificadoLAIBN {	

	public static final String plantilla = CtsArmado.pathJar + "Plantilla GM03 BN.pdf";
	public static String pathSal = CtsArmado.pathSal;
	public static final String path = CtsArmado.pathSpool + "Spool_Cert_LAI.txt";
	
	int contCar = 0;
	int largoArreg = 0;
	String poliza = "";
	String certif ="";
	String certifcom ="";
	public CreaCertificadoLAIBN(String nNegocio, String nPoliza) {
		pathSal = CtsArmado.pathSal;
		pathSal  = pathSal + nNegocio;
		poliza = nPoliza;
	}

	public static void main(String[] args) {
		try{
			CreaCertificadoLAIBN cc = new CreaCertificadoLAIBN("", null);		
			cc.creaCertif(path);
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

	public void creaCertif(String file) {
		try{
		File f = null;
		String line = "";
		int cont = 0;
		boolean flag = true;
		int tipoForm = 0;
		String datos[] = new String[100];
		f = new File(path);
		BufferedReader br = null; 		
		br = new BufferedReader(new FileReader(f));
		

		while(flag){ 
			if(line.indexOf("FORM=GM03,")>0){
				tipoForm = 0;
			}else{
				tipoForm = 1;;
			}		
			
			while(((line = br.readLine()) != null) && (line.trim().indexOf("17 "))<0){
			}
			if(line != null){			
			datos[cont]=line.substring(1, line.length());
			cont++;
			}
			
			while(((line = br.readLine()) != null)&&(!(line.indexOf("CNSF")>-1))){
				
				if(line.length()>0){
					datos[cont]=line.substring(1, line.length());
					cont++;
				}else{
					datos[cont]="";
				cont++;
				}
			}
			if(line!=null){
				datos[cont]=line.substring(1, line.length());
				cont++;
				while((cont<90)){
					datos[cont]="";
					cont++;
				}
				if((tipoForm==0))
				creaCaraCte(datos);
				else
					creaCaraCte(datos);
				cont=0;
			}else{
				if(tipoForm==0)
					creaCaraCte(datos);
				flag= false;
			}
		}			
		br.close();		
	}catch(Exception e){
		e.printStackTrace();
	}
}

	public void creaCaraCte(String[] datos) throws IOException, DocumentException{
		PdfReader reader;
		PdfStamper stamper = null;		
		reader = new PdfReader(plantilla);
		Font Arial=new Font(Font.getFamily("Arial"),(float) 9.96);
		Arial.setSize((float) 10);
		Arial.setColor(15, 15, 15);
		poliza = (((datos[0].substring(83, 87).trim())) + ((datos[0].substring(87, 94).trim())));
		System.out.println("poliza: " + poliza);
		File fl = new File(pathSal+ "\\" + poliza+"\\Certificados y Tarjetas\\");
		fl.mkdirs();
		String letra = datos[7].substring(7, 8).trim() ;
		if(letra.indexOf("A")>-1){
			certif = datos[7].substring(0, 7).trim() ;	
		}else{
			certif = datos[7].substring(0, 8).trim() ;
		}
		
		
		System.out.println("certif: " + certif);		
		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+ "\\"+poliza+ "\\Certificados y Tarjetas" +"\\"+"Certificado_"+poliza+"_"+certif+".pdf"));
		Phrase phraset = null;
		PdfContentByte canvas;
		PdfContentByte canvas2; 
		PdfContentByte canvas3; 
		canvas = stamper.getOverContent(1);
		canvas.beginText();	
		canvas2 = stamper.getOverContent(2);
		canvas2.beginText();	
		canvas3 = stamper.getOverContent(3);
		canvas3.beginText();
		Chunk c0= null;
		Chunk c1= null;
		Chunk c2= null;
		Chunk c3= null;		
		Chunk c4= null;
		Chunk c5= null;
		Chunk c6= null;
		Chunk c7= null;
		Chunk c8= null;
		Chunk c9= null;
		Chunk c10= null;		
		Chunk c11= null;
		Chunk c12= null;
		Chunk c13= null;
		Chunk c14= null;
		Chunk c15= null;
		Chunk c16= null;
		Chunk c17= null;		
		Chunk c18= null;
		Chunk c19= null;
		Chunk c20= null;
		Chunk c21= null;
		Chunk c22= null;
		Chunk c23= null;
		Chunk c24= null;		
		Chunk c25= null;
		Chunk c26= null;
		Chunk c27= null;
		Chunk c28= null;
		Chunk c29= null;
		Chunk c30= null;
		Chunk c31= null;		
		Chunk c32= null;
		Chunk c33= null;
		Chunk c34= null;
		Chunk c35= null;
		Chunk c36= null;
		Chunk c37= null;
		Chunk c38= null;
		Chunk c39= null;		
		Chunk c40= null;
		Chunk c41= null;
		Chunk c42= null;
		Chunk c43= null;
		Chunk c44= null;
		Chunk c45= null;
		Chunk c46= null;		
		Chunk c47= null;
		Chunk c48= null;
		Chunk c49= null;
		Chunk c50= null;
		Chunk c51= null;
		Chunk c52= null;
		Chunk c53= null;
		Chunk c54= null;
		Chunk c55= null;
		Chunk c56= null;
		Chunk c57= null;
		Chunk c58= null;
		Chunk c59= null;
		Chunk c60= null;		
		Chunk c61= null;
		Chunk c62= null;
		Chunk c63= null;
		Chunk c64= null;
		Chunk c65= null;
		Chunk c66= null;
		Chunk c67= null;		
		Chunk c68= null;
		Chunk c69= null;
		Chunk c70= null;
		Chunk c71= null;
		Chunk c72= null;
		Chunk c73= null;
		Chunk c74= null;
		Chunk c75= null;
		Chunk c75A= null;
		Chunk c76= null;
		Chunk c77= null;
		Chunk c78= null;
		Chunk c78A= null;
		Chunk c80= null;
		Chunk c80A= null;
		Chunk c80B= null;
		Chunk c80C= null;
		Chunk c81A= null;
		Chunk c81B= null;
		Chunk c81C= null;
		Chunk c82A= null;
		Chunk c82B= null;
		Chunk c82C= null;
		Chunk c83A= null;
		Chunk c83B= null;
		Chunk c83C= null;
		Chunk c84A= null;
		Chunk c84B= null;
		Chunk c84C= null;
		Chunk c85A= null;
		Chunk c85B= null;
		Chunk c85C= null;
		Chunk c86A= null;
		Chunk c86B= null;
		Chunk c86C= null;
		Chunk c81= null;
		Chunk c82= null;
		Chunk c83= null;
		Chunk c84= null;
		Chunk c85= null;
		Chunk c86= null;
		Chunk c81D= null;
		Chunk c82D= null;
		Chunk c83D= null;
		Chunk c84D= null;
		Chunk c85D= null;
		Chunk c86D= null;
		Chunk c89= null;
		Chunk c90= null;
		Chunk c91= null;
		Chunk c92= null;
		Chunk c93= null;
		Chunk c94= null;
		Chunk c95= null;
		Chunk c96= null;
		Chunk c97= null;
		Chunk c98= null;

		largoArreg = datos[0].length();
		if(largoArreg<1){
			c0= new Chunk();
			c1= new Chunk();
		}else if(largoArreg<86&&largoArreg>0){
			c0= new Chunk(datos[0].substring(0, largoArreg), Arial);		
			c1= new Chunk();	
		}else if(largoArreg>85){
			c0= new Chunk(datos[0].substring(0, 18), Arial);
			c1= new Chunk(datos[0].substring(85, largoArreg), Arial);	
		}
		largoArreg = datos[2].length();
		if(largoArreg<1){
			c2= new Chunk();
			c3= new Chunk();
		}else if(largoArreg<81&&largoArreg>0){
			c2= new Chunk(datos[2].substring(9, largoArreg).trim(), Arial);
			c3= new Chunk();
		}else if(largoArreg>80){
			c2= new Chunk(datos[2].substring(9, 74).trim(), Arial);		
			c3= new Chunk(datos[2].substring(74, largoArreg).trim(), Arial);
		}
		
		
		largoArreg = datos[3].length();
		if(largoArreg<1){
			c4= new Chunk();
			c5= new Chunk();
		}else if(largoArreg<78&&largoArreg>0){
			c4= new Chunk(datos[3].substring(9, largoArreg).trim(), Arial);
			c5= new Chunk();
		}else if(largoArreg>78){
			c4= new Chunk(datos[3].substring(9, 74).trim(), Arial);		
			c5= new Chunk(datos[3].substring(74, largoArreg).trim(), Arial);
		}
		
		largoArreg = datos[4].length();
		if(largoArreg<10){
			c6= new Chunk();
		}else{ 
			c6= new Chunk(datos[4].substring(9, largoArreg).trim(), Arial);
		}		
		largoArreg = datos[5].length();
		if(largoArreg<10){
			c7= new Chunk();
		}else{
			c7= new Chunk(datos[5].substring(9, largoArreg).trim(), Arial);
		}		
		// AQUI FALTARIA LA MATRIZ PARA LOS ASEGURADOS		
		// TITULAR
		// CERTIFICADO
		largoArreg = datos[7].length();
		if(largoArreg<1){
			c8= new Chunk();
			c9= new Chunk();
			c10= new Chunk();
			c11= new Chunk();
			c12= new Chunk();
			c13= new Chunk();
			c14= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c8= new Chunk(datos[7].substring(0, largoArreg).trim(), Arial);
			c9= new Chunk();
			c10= new Chunk();
			c11= new Chunk();
			c12= new Chunk();
			c13= new Chunk();
			c14= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c8= new Chunk(datos[7].substring(0, 9).trim(), Arial);
			c9= new Chunk(datos[7].substring(9, largoArreg).trim(), Arial);
			c10= new Chunk();
			c11= new Chunk();
			c12= new Chunk();
			c13= new Chunk();
			c14= new Chunk();
		}else if(largoArreg<59&&largoArreg>46){
			c8= new Chunk(datos[7].substring(0, 9).trim(), Arial);
			c9= new Chunk(datos[7].substring(9, 45).trim(), Arial);
			c10= new Chunk(datos[7].substring(45, largoArreg).trim(), Arial);			
			c11= new Chunk();
			c12= new Chunk();
			c13= new Chunk();
			c14= new Chunk();
		}else if(largoArreg<69&&largoArreg>57){
			c8= new Chunk(datos[7].substring(0, 9).trim(), Arial);
			c9= new Chunk(datos[7].substring(9, 45).trim(), Arial);
			c10= new Chunk(datos[7].substring(45, 57).trim(), Arial);
			c11= new Chunk(datos[7].substring(57, largoArreg).trim(), Arial);			
			c12= new Chunk();
			c13= new Chunk();
			c14= new Chunk();
		}else if(largoArreg<75&&largoArreg>67){
			c8= new Chunk(datos[7].substring(0, 9).trim(), Arial);
			c9= new Chunk(datos[7].substring(9, 45).trim(), Arial);
			c10= new Chunk(datos[7].substring(45, 57).trim(), Arial);
			c11= new Chunk(datos[7].substring(57, 68).trim(), Arial);
			c12= new Chunk(datos[7].substring(70, largoArreg).trim(), Arial);			
			c13= new Chunk();
			c14= new Chunk();
		}else if(largoArreg<87&&largoArreg>74){
			c8= new Chunk(datos[7].substring(0, 9).trim(), Arial);
			c9= new Chunk(datos[7].substring(9, 45).trim(), Arial);
			c10= new Chunk(datos[7].substring(45, 57).trim(), Arial);
			c11= new Chunk(datos[7].substring(57, 68).trim(), Arial);
			c12= new Chunk(datos[7].substring(70, 73).trim(), Arial);
			c13= new Chunk(datos[7].substring(75, largoArreg).trim(), Arial);			
			c14= new Chunk();
		}else if(largoArreg>86){
			c8= new Chunk(datos[7].substring(0, 9).trim(), Arial); 			// CERTIFICADO
			c9= new Chunk(datos[7].substring(9, 45).trim(), Arial);		// NOMBRE
			c10= new Chunk(datos[7].substring(45, 57).trim(), Arial);		// PARENTESCO
			c11= new Chunk(datos[7].substring(57, 71).trim(), Arial);   	// FECHA DE NACIMIENTO
			c12= new Chunk(datos[7].substring(71, 81).trim(), Arial);       // GENERO
			c13= new Chunk(datos[7].substring(81, largoArreg).trim(), Arial);       // ANTIGUEDAD GNP
			c14= new Chunk();
//			c14= new Chunk(datos[36].substring(85, largoArreg).trim(), Arial);	// ANTIGUEDAD OTRAS
		}			
		// DEPENDIENTE 1
		// CERTIFICADO
		largoArreg = datos[8].length();
		if(largoArreg<1){
			c15= new Chunk();
			c16= new Chunk();
			c17= new Chunk();
			c18= new Chunk();
			c19= new Chunk();
			c20= new Chunk();
			c21= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c15= new Chunk(datos[8].substring(0, largoArreg).trim(), Arial);
			c16= new Chunk();
			c17= new Chunk();
			c18= new Chunk();
			c19= new Chunk();
			c20= new Chunk();
			c21= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c15= new Chunk(datos[8].substring(0, 9).trim(), Arial);
			c16= new Chunk(datos[8].substring(9, largoArreg).trim(), Arial);
			c17= new Chunk();
			c18= new Chunk();
			c19= new Chunk();
			c20= new Chunk();
			c21= new Chunk();
		}else if(largoArreg<58&&largoArreg>46){
			c15= new Chunk(datos[8].substring(0, 9).trim(), Arial);
			c16= new Chunk(datos[8].substring(9, 45).trim(), Arial);
			c17= new Chunk(datos[8].substring(45, largoArreg).trim(), Arial);			
			c18= new Chunk();
			c19= new Chunk();
			c20= new Chunk();
			c21= new Chunk();
		}else if(largoArreg<68&&largoArreg>57){
			c15= new Chunk(datos[8].substring(0, 9).trim(), Arial);
			c16= new Chunk(datos[8].substring(9, 45).trim(), Arial);
			c17= new Chunk(datos[8].substring(45, 57).trim(), Arial);
			c18= new Chunk(datos[8].substring(57, largoArreg).trim(), Arial);			
			c19= new Chunk();
			c20= new Chunk();
			c21= new Chunk();
		}else if(largoArreg<74&&largoArreg>67){
			c15= new Chunk(datos[8].substring(0, 9).trim(), Arial);
			c16= new Chunk(datos[8].substring(9, 45).trim(), Arial);
			c17= new Chunk(datos[8].substring(45, 57).trim(), Arial);
			c18= new Chunk(datos[8].substring(57, 68).trim(), Arial);
			c19= new Chunk(datos[8].substring(70, largoArreg).trim(), Arial);			
			c20= new Chunk();
			c21= new Chunk();
		}else if(largoArreg<87&&largoArreg>74){
			c15= new Chunk(datos[8].substring(0, 9).trim(), Arial);
			c16= new Chunk(datos[8].substring(9, 45).trim(), Arial);
			c17= new Chunk(datos[8].substring(45, 57).trim(), Arial);
			c18= new Chunk(datos[8].substring(57, 68).trim(), Arial);
			c19= new Chunk(datos[8].substring(70, 73).trim(), Arial);
			c20= new Chunk(datos[8].substring(75, largoArreg).trim(), Arial);			
			c21= new Chunk();
		}else if(largoArreg>86){
			c15= new Chunk(datos[8].substring(0, 9).trim(), Arial); 			// NOMBRE
			c16= new Chunk(datos[8].substring(9, 45).trim(), Arial);		// PARENTESCO
			c17= new Chunk(datos[8].substring(45, 57).trim(), Arial);		// FECHA NACIMIENTO
			c18= new Chunk(datos[8].substring(57, 71).trim(), Arial);   	// GENERO
			c19= new Chunk(datos[8].substring(71, 81).trim(), Arial);       // ANTIGUEDAD GNP
			c20= new Chunk(datos[8].substring(81, largoArreg).trim(), Arial);       // ANTIGUEDAD OTRAS
//			c21= new Chunk(datos[8].substring(85, largoArreg).trim(), Arial);	
			c21= new Chunk();

		}		
		// DEPENDIENTE 2
		 // CERTIFICADO
		largoArreg = datos[10].length();
		if(largoArreg<1){
			c22= new Chunk();
			c23= new Chunk();
			c24= new Chunk();
			c25= new Chunk();
			c26= new Chunk();
			c27= new Chunk();
			c28= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c22= new Chunk(datos[10].substring(0,largoArreg).trim(), Arial);
			c23= new Chunk();
			c24= new Chunk();
			c25= new Chunk();
			c26= new Chunk();
			c27= new Chunk();
			c28= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c22= new Chunk(datos[10].substring(0, 9).trim(), Arial);
			c23= new Chunk(datos[10].substring(9, largoArreg).trim(), Arial);
			c24= new Chunk();
			c25= new Chunk();
			c26= new Chunk();
			c27= new Chunk();
			c28= new Chunk();
		}else if(largoArreg<58&&largoArreg>45){
			c22= new Chunk(datos[10].substring(0, 9).trim(), Arial);
			c23= new Chunk(datos[10].substring(9, 45).trim(), Arial);
			c24= new Chunk(datos[10].substring(45, largoArreg).trim(), Arial);			
			c25= new Chunk();
			c26= new Chunk();
			c27= new Chunk();
			c28= new Chunk();
		}else if(largoArreg<69&&largoArreg>57){
			c22= new Chunk(datos[10].substring(0, 9).trim(), Arial);
			c23= new Chunk(datos[10].substring(9, 45).trim(), Arial);
			c24= new Chunk(datos[10].substring(45, 57).trim(), Arial);
			c25= new Chunk(datos[10].substring(57, largoArreg).trim(), Arial);			
			c26= new Chunk();
			c27= new Chunk();
			c28= new Chunk();
		}else if(largoArreg<74&&largoArreg>68){
			c22= new Chunk(datos[10].substring(0, 9).trim(), Arial);
			c23= new Chunk(datos[10].substring(9, 45).trim(), Arial);
			c24= new Chunk(datos[10].substring(45, 57).trim(), Arial);
			c25= new Chunk(datos[10].substring(57, 68).trim(), Arial);
			c26= new Chunk(datos[10].substring(70, largoArreg).trim(), Arial);			
			c27= new Chunk();
			c28= new Chunk();
		}else if(largoArreg<87&&largoArreg>75){
			c22= new Chunk(datos[10].substring(0, 9).trim(), Arial);
			c23= new Chunk(datos[10].substring(9, 45).trim(), Arial);
			c24= new Chunk(datos[10].substring(45, 57).trim(), Arial);
			c25= new Chunk(datos[10].substring(57, 68).trim(), Arial);
			c26= new Chunk(datos[10].substring(70, 73).trim(), Arial);
			c27= new Chunk(datos[10].substring(75, largoArreg).trim(), Arial);			
			c28= new Chunk();
		}else if(largoArreg>86){
			c22= new Chunk(datos[10].substring(0, 9).trim(), Arial); 			// NOMBRE
			c23= new Chunk(datos[10].substring(9, 45).trim(), Arial);		// PARENTESCO
			c24= new Chunk(datos[10].substring(45, 57).trim(), Arial);		// FECHA NACIMIENTO
			c25= new Chunk(datos[10].substring(57, 71).trim(), Arial);   	// GENERO
			c26= new Chunk(datos[10].substring(71, 81).trim(), Arial);       // ANTIGUEDAD GNP
			c27= new Chunk(datos[10].substring(81, largoArreg).trim(), Arial);       // ANTIGUEDAD OTRAS
//			c28= new Chunk(datos[10].substring(85, largoArreg).trim(), Arial);	
			c28= new Chunk();

		}		
		// DEPENDIENTE 3
		largoArreg = datos[11].length();
		if(largoArreg<1){
			c29= new Chunk();
			c30= new Chunk();
			c31= new Chunk();
			c32= new Chunk();
			c33= new Chunk();
			c34= new Chunk();
			c35= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c29= new Chunk(datos[11].substring(0, 9).trim(), Arial);
			c30= new Chunk();
			c31= new Chunk();
			c32= new Chunk();
			c33= new Chunk();
			c34= new Chunk();
			c35= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c29= new Chunk(datos[11].substring(0, 9).trim(), Arial);
			c30= new Chunk(datos[11].substring(9, largoArreg).trim(), Arial);
			c31= new Chunk();
			c32= new Chunk();
			c33= new Chunk();
			c34= new Chunk();
			c35= new Chunk();
		}else if(largoArreg<59&&largoArreg>45){
			c29= new Chunk(datos[11].substring(0, 9).trim(), Arial);
			c30= new Chunk(datos[11].substring(9, 45).trim(), Arial);
			c31= new Chunk(datos[11].substring(45, largoArreg).trim(), Arial);			
			c32= new Chunk();
			c33= new Chunk();
			c34= new Chunk();
			c35= new Chunk();
		}else if(largoArreg<69&&largoArreg>57){
			c29= new Chunk(datos[11].substring(0, 9).trim(), Arial);
			c30= new Chunk(datos[11].substring(9, 45).trim(), Arial);
			c31= new Chunk(datos[11].substring(45, 57).trim(), Arial);
			c32= new Chunk(datos[11].substring(57, largoArreg).trim(), Arial);			
			c33= new Chunk();
			c34= new Chunk();
			c35= new Chunk();
		}else if(largoArreg<74&&largoArreg>68){
			c29= new Chunk(datos[11].substring(0, 9).trim(), Arial);
			c30= new Chunk(datos[11].substring(9, 45).trim(), Arial);
			c31= new Chunk(datos[11].substring(45, 57).trim(), Arial);
			c32= new Chunk(datos[11].substring(57, 68).trim(), Arial);
			c33= new Chunk(datos[11].substring(70, largoArreg).trim(), Arial);			
			c34= new Chunk();
			c35= new Chunk();
		}else if(largoArreg<87&&largoArreg>75){
			c29= new Chunk(datos[11].substring(0, 9).trim(), Arial);
			c30= new Chunk(datos[11].substring(9, 45).trim(), Arial);
			c31= new Chunk(datos[11].substring(45, 57).trim(), Arial);
			c32= new Chunk(datos[11].substring(57, 68).trim(), Arial);
			c33= new Chunk(datos[11].substring(70, 73).trim(), Arial);
			c34= new Chunk(datos[11].substring(75, largoArreg).trim(), Arial);			
			c35= new Chunk();
		}else if(largoArreg>86){
			c29= new Chunk(datos[11].substring(0, 9).trim(), Arial); 			// NOMBRE
			c30= new Chunk(datos[11].substring(9, 45).trim(), Arial);		// PARENTESCO
			c31= new Chunk(datos[11].substring(45, 57).trim(), Arial);		// FECHA NACIMIENTO
			c32= new Chunk(datos[11].substring(57, 71).trim(), Arial);   	// GENERO
			c33= new Chunk(datos[11].substring(71, 81).trim(), Arial);       // ANTIGUEDAD GNP
			c34= new Chunk(datos[11].substring(81, largoArreg).trim(), Arial);       // ANTIGUEDAD OTRAS
//			c35= new Chunk(datos[11].substring(85, largoArreg).trim(), Arial);	
			c35= new Chunk();

		}		
		// DEPENDIENTE 4
		largoArreg = datos[12].length();
		if(largoArreg<1){
			c36= new Chunk();
			c37= new Chunk();
			c38= new Chunk();
			c39= new Chunk();
			c40= new Chunk();
			c41= new Chunk();
			c42= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c36= new Chunk(datos[12].substring(0, largoArreg).trim(), Arial);
			c37= new Chunk();
			c38= new Chunk();
			c39= new Chunk();
			c40= new Chunk();
			c41= new Chunk();
			c42= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c36= new Chunk(datos[12].substring(0, 9).trim(), Arial);
			c37= new Chunk(datos[12].substring(9, largoArreg).trim(), Arial);
			c38= new Chunk();
			c39= new Chunk();
			c40= new Chunk();
			c41= new Chunk();
			c42= new Chunk();
		}else if(largoArreg<59&&largoArreg>45){
			c36= new Chunk(datos[12].substring(0, 9).trim(), Arial);
			c37= new Chunk(datos[12].substring(9, 45).trim(), Arial);
			c38= new Chunk(datos[12].substring(45, largoArreg).trim(), Arial);			
			c39= new Chunk();
			c40= new Chunk();
			c41= new Chunk();
			c42= new Chunk();
		}else if(largoArreg<69&&largoArreg>57){
			c36= new Chunk(datos[12].substring(0, 9).trim(), Arial);
			c37= new Chunk(datos[12].substring(9, 45).trim(), Arial);
			c38= new Chunk(datos[12].substring(45, 57).trim(), Arial);
			c39= new Chunk(datos[12].substring(57, largoArreg).trim(), Arial);			
			c40= new Chunk();
			c41= new Chunk();
			c42= new Chunk();
		}else if(largoArreg<75&&largoArreg>68){
			c36= new Chunk(datos[12].substring(0, 9).trim(), Arial);
			c37= new Chunk(datos[12].substring(9, 45).trim(), Arial);
			c38= new Chunk(datos[12].substring(45, 57).trim(), Arial);
			c39= new Chunk(datos[12].substring(57, 68).trim(), Arial);
			c40= new Chunk(datos[12].substring(70, largoArreg).trim(), Arial);			
			c41= new Chunk();
			c42= new Chunk();
		}else if(largoArreg<87&&largoArreg>74){
			c36= new Chunk(datos[12].substring(0, 9).trim(), Arial);
			c37= new Chunk(datos[12].substring(9, 45).trim(), Arial);
			c38= new Chunk(datos[12].substring(45, 57).trim(), Arial);
			c39= new Chunk(datos[12].substring(57, 68).trim(), Arial);
			c40= new Chunk(datos[12].substring(70, 73).trim(), Arial);
			c41= new Chunk(datos[12].substring(75, largoArreg).trim(), Arial);			
			c42= new Chunk();
		}else if(largoArreg>86){
			c36= new Chunk(datos[12].substring(0, 9).trim(), Arial); 			// NOMBRE
			c37= new Chunk(datos[12].substring(9, 45).trim(), Arial);		// PARENTESCO
			c38= new Chunk(datos[12].substring(45, 57).trim(), Arial);		// FECHA NACIMIENTO
			c39= new Chunk(datos[12].substring(57, 71).trim(), Arial);   	// GENERO
			c40= new Chunk(datos[12].substring(71, 81).trim(), Arial);       // ANTIGUEDAD GNP
			c41= new Chunk(datos[12].substring(81, largoArreg).trim(), Arial);       // ANTIGUEDAD OTRAS
//			c42= new Chunk(datos[12].substring(85, largoArreg).trim(), Arial);	
			c42= new Chunk();

		}		
		// DEPENDIENTE 5
		largoArreg = datos[13].length();
		if(largoArreg<1){
			c43= new Chunk();
			c44= new Chunk();
			c45= new Chunk();
			c46= new Chunk();
			c47= new Chunk();
			c48= new Chunk();
			c49= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c43= new Chunk(datos[13].substring(0, largoArreg).trim(), Arial);
			c44= new Chunk();
			c45= new Chunk();
			c46= new Chunk();
			c47= new Chunk();
			c48= new Chunk();
			c49= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c43= new Chunk(datos[13].substring(0, 9).trim(), Arial);
			c44= new Chunk(datos[13].substring(9, largoArreg).trim(), Arial);
			c45= new Chunk();
			c46= new Chunk();
			c47= new Chunk();
			c48= new Chunk();
			c49= new Chunk();
		}else if(largoArreg<59&&largoArreg>45){
			c43= new Chunk(datos[13].substring(0, 9).trim(), Arial);
			c44= new Chunk(datos[13].substring(9, 45).trim(), Arial);
			c45= new Chunk(datos[13].substring(45, largoArreg).trim(), Arial);			
			c46= new Chunk();
			c47= new Chunk();
			c48= new Chunk();
			c49= new Chunk();
		}else if(largoArreg<69&&largoArreg>57){
			c43= new Chunk(datos[13].substring(0, 9).trim(), Arial);
			c44= new Chunk(datos[13].substring(9, 45).trim(), Arial);
			c45= new Chunk(datos[13].substring(45, 57).trim(), Arial);
			c46= new Chunk(datos[13].substring(57, largoArreg).trim(), Arial);			
			c47= new Chunk();
			c48= new Chunk();
			c49= new Chunk();
		}else if(largoArreg<75&&largoArreg>68){
			c43= new Chunk(datos[13].substring(0, 9).trim(), Arial);
			c44= new Chunk(datos[13].substring(9, 45).trim(), Arial);
			c45= new Chunk(datos[13].substring(45, 57).trim(), Arial);
			c46= new Chunk(datos[13].substring(57, 70).trim(), Arial);
			c47= new Chunk(datos[13].substring(70, largoArreg).trim(), Arial);			
			c48= new Chunk();
			c49= new Chunk();
		}else if(largoArreg<87&&largoArreg>74){
			c43= new Chunk(datos[13].substring(0, 9).trim(), Arial);
			c44= new Chunk(datos[13].substring(9, 45).trim(), Arial);
			c45= new Chunk(datos[13].substring(45, 57).trim(), Arial);
			c46= new Chunk(datos[13].substring(57, 70).trim(), Arial);
			c47= new Chunk(datos[13].substring(70, 73).trim(), Arial);
			c48= new Chunk(datos[13].substring(75, largoArreg).trim(), Arial);			
			c49= new Chunk();
		}else if(largoArreg>86){
			c43= new Chunk(datos[13].substring(0, 9).trim(), Arial); 			// NOMBRE
			c44= new Chunk(datos[13].substring(9, 45).trim(), Arial);		// PARENTESCO
			c45= new Chunk(datos[13].substring(45, 57).trim(), Arial);		// FECHA NACIMIENTO
			c46= new Chunk(datos[13].substring(57, 70).trim(), Arial);   	// GENERO
			c47= new Chunk(datos[13].substring(73, 79).trim(), Arial);       // ANTIGUEDAD GNP
			c48= new Chunk(datos[13].substring(81, largoArreg).trim(), Arial);       // ANTIGUEDAD OTRAS
//			c49= new Chunk(datos[13].substring(85, largoArreg).trim(), Arial);	
			c49= new Chunk();

		}		
		// DEPENDIENTE 6
		largoArreg = datos[14].length();
		if(largoArreg<1){
			c50= new Chunk();
			c51= new Chunk();
			c52= new Chunk();
			c53= new Chunk();
			c54= new Chunk();
			c55= new Chunk();
			c56= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c50= new Chunk(datos[14].substring(0, largoArreg).trim(), Arial);
			c51= new Chunk();
			c52= new Chunk();
			c53= new Chunk();
			c54= new Chunk();
			c55= new Chunk();
			c56= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c50= new Chunk(datos[14].substring(0, 9).trim(), Arial);
			c51= new Chunk(datos[14].substring(9, largoArreg).trim(), Arial);
			c52= new Chunk();
			c53= new Chunk();
			c54= new Chunk();
			c55= new Chunk();
			c56= new Chunk();
		}else if(largoArreg<59&&largoArreg>46){
			c50= new Chunk(datos[14].substring(0, 9).trim(), Arial);
			c51= new Chunk(datos[14].substring(9, 45).trim(), Arial);
			c52= new Chunk(datos[14].substring(45, largoArreg).trim(), Arial);			
			c53= new Chunk();
			c54= new Chunk();
			c55= new Chunk();
			c56= new Chunk();
		}else if(largoArreg<69&&largoArreg>58){
			c50= new Chunk(datos[14].substring(0, 9).trim(), Arial);
			c51= new Chunk(datos[14].substring(9, 45).trim(), Arial);
			c52= new Chunk(datos[14].substring(45, 57).trim(), Arial);
			c53= new Chunk(datos[14].substring(57, largoArreg).trim(), Arial);			
			c54= new Chunk();
			c55= new Chunk();
			c56= new Chunk();
		}else if(largoArreg<75&&largoArreg>67){
			c50= new Chunk(datos[14].substring(0, 9).trim(), Arial);
			c51= new Chunk(datos[14].substring(9, 45).trim(), Arial);
			c52= new Chunk(datos[14].substring(45, 57).trim(), Arial);
			c53= new Chunk(datos[14].substring(57, 68).trim(), Arial);
			c54= new Chunk(datos[14].substring(70, largoArreg).trim(), Arial);			
			c55= new Chunk();
			c56= new Chunk();
		}else if(largoArreg<87&&largoArreg>74){
			c50= new Chunk(datos[14].substring(0, 9).trim(), Arial);
			c51= new Chunk(datos[14].substring(9, 45).trim(), Arial);
			c52= new Chunk(datos[14].substring(45, 57).trim(), Arial);
			c53= new Chunk(datos[14].substring(57, 68).trim(), Arial);
			c54= new Chunk(datos[14].substring(70, 73).trim(), Arial);
			c55= new Chunk(datos[14].substring(75, largoArreg).trim(), Arial);
			c56= new Chunk();
		}else if(largoArreg>86){
			c50= new Chunk(datos[14].substring(0, 9).trim(), Arial); 			// NOMBRE
			c51= new Chunk(datos[14].substring(9, 45).trim(), Arial);		// PARENTESCO
			c52= new Chunk(datos[14].substring(46, 58).trim(), Arial);		// FECHA NACIMIENTO
			c53= new Chunk(datos[14].substring(58, 71).trim(), Arial);   	// GENERO
			c54= new Chunk(datos[14].substring(71, 81).trim(), Arial);       // ANTIGUEDAD GNP
			c55= new Chunk(datos[14].substring(81, largoArreg).trim(), Arial);       // ANTIGUEDAD OTRAS
//			c56= new Chunk(datos[14].substring(85, largoArreg).trim(), Arial);	
			c56= new Chunk();

		}	
			// DEPENDIENTE 7
		largoArreg = datos[36].length();
		if(largoArreg<1){
			c81= new Chunk();
			c81A= new Chunk();
			c81B= new Chunk();
			c81C= new Chunk();
			c81D= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c81= new Chunk(datos[36].substring(0, 9).trim(), Arial);
			c81A= new Chunk();
			c81B= new Chunk();
			c81C= new Chunk();
			c81D= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c81= new Chunk(datos[36].substring(0, 9).trim(), Arial);
			c81A= new Chunk(datos[36].substring(9, largoArreg).trim(), Arial);
			c81B= new Chunk();	
			c81C= new Chunk();
			c81D= new Chunk();
		}else if(largoArreg>46){
			c81= new Chunk(datos[36].substring(0, 9).trim(), Arial);
			c81A= new Chunk(datos[36].substring(9, 46).trim(), Arial);
			c81B= new Chunk(datos[36].substring(46, 56).trim(), Arial);	
			c81C= new Chunk(datos[36].substring(56, largoArreg).trim(), Arial);
			c81D= new Chunk();
		}
		
		largoArreg = datos[37].length();
		if(largoArreg<1){
			c82= new Chunk();
			c82A= new Chunk();
			c82B= new Chunk();
			c82C= new Chunk();
			c82D= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c82= new Chunk(datos[37].substring(0, 9).trim(), Arial);
			c82A= new Chunk();
			c82B= new Chunk();
			c82C= new Chunk();
			c82D= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c82= new Chunk(datos[37].substring(0, 9).trim(), Arial);
			c82A= new Chunk(datos[37].substring(9, largoArreg).trim(), Arial);
			c82B= new Chunk();
			c82C= new Chunk();
			c82D= new Chunk();
		}else if(largoArreg>46){
			c82= new Chunk(datos[37].substring(0, 9).trim(), Arial);
			c82A= new Chunk(datos[37].substring(9, 46).trim(), Arial);
			c82B= new Chunk(datos[37].substring(46, 56).trim(), Arial);	
			c82C= new Chunk(datos[37].substring(56, largoArreg).trim(), Arial);
			c82D= new Chunk();
		}
		largoArreg = datos[38].length();
		if(largoArreg<1){
			c83= new Chunk();
			c83A= new Chunk();
			c83B= new Chunk();
			c83C= new Chunk();
			c83D= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c83= new Chunk(datos[38].substring(0, 9).trim(), Arial);
			c83A= new Chunk();
			c83B= new Chunk();
			c83C= new Chunk();
			c83D= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c83= new Chunk(datos[38].substring(0, 9).trim(), Arial);
			c83A= new Chunk(datos[38].substring(9, largoArreg).trim(), Arial);
			c83B= new Chunk();
			c83C= new Chunk();
			c83D= new Chunk();
		}else if(largoArreg>46){
			c83= new Chunk(datos[38].substring(0, 9).trim(), Arial);
			c83A= new Chunk(datos[38].substring(9, 46).trim(), Arial);
			c83B= new Chunk(datos[38].substring(46, 56).trim(), Arial);	
			c83C= new Chunk(datos[38].substring(56, largoArreg).trim(), Arial);
			c83D= new Chunk();
		}
		largoArreg = datos[39].length();
		if(largoArreg<1){
			c84= new Chunk();
			c84A= new Chunk();
			c84B= new Chunk();
			c84C= new Chunk();
			c84D= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c84= new Chunk(datos[39].substring(0, 9).trim(), Arial);
			c84A= new Chunk();
			c84B= new Chunk();
			c84C= new Chunk();
			c84D= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c84= new Chunk(datos[39].substring(0, 9).trim(), Arial);
			c84A= new Chunk(datos[39].substring(9, largoArreg).trim(), Arial);
			c84B= new Chunk();
			c84C= new Chunk();
			c84D= new Chunk();
		}else if(largoArreg>46){
			c84= new Chunk(datos[39].substring(0, 9).trim(), Arial);
			c84A= new Chunk(datos[39].substring(9, 46).trim(), Arial);
			c84B= new Chunk(datos[39].substring(46, 56).trim(), Arial);	
			c84C= new Chunk(datos[39].substring(56, largoArreg).trim(), Arial);
			c84D= new Chunk();
		}
		largoArreg = datos[40].length();
		if(largoArreg<1){
			c85= new Chunk();
			c85A= new Chunk();
			c85B= new Chunk();
			c85C= new Chunk();
			c85D= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c85= new Chunk(datos[40].substring(0, 9).trim(), Arial);
			c85A= new Chunk();
			c85B= new Chunk();
			c85B= new Chunk();
			c85D= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c85= new Chunk(datos[40].substring(0, 9).trim(), Arial);
			c85A= new Chunk(datos[40].substring(9, largoArreg).trim(), Arial);
			c85B= new Chunk();
			c85C= new Chunk();
			c85D= new Chunk();
		}else if(largoArreg>46){
			c85= new Chunk(datos[40].substring(0, 9).trim(), Arial);
			c85A= new Chunk(datos[40].substring(9, 46).trim(), Arial);
			c85B= new Chunk(datos[40].substring(46, 56).trim(), Arial);	
			c85C= new Chunk(datos[40].substring(56, largoArreg).trim(), Arial);
			c85D= new Chunk();
				}
		largoArreg = datos[41].length();
		if(largoArreg<1){
			c86= new Chunk();
			c86A= new Chunk();
			c86B= new Chunk();
			c86C= new Chunk();
			c86D= new Chunk();
		}else if(largoArreg<10&&largoArreg>0){
			c86= new Chunk(datos[41].substring(0, 9).trim(), Arial);
			c86A= new Chunk();
			c86B= new Chunk();
			c86C= new Chunk();
			c86D= new Chunk();
		}else if(largoArreg<46&&largoArreg>9){
			c86= new Chunk(datos[41].substring(0, 9).trim(), Arial);
			c86A= new Chunk(datos[41].substring(9, largoArreg).trim(), Arial);
			c86B= new Chunk();
			c86C= new Chunk();
			c86D= new Chunk();
		}else if(largoArreg>46){
			c86= new Chunk(datos[41].substring(0, 9).trim(), Arial);
			c86A= new Chunk(datos[41].substring(9, 46).trim(), Arial);
			c86B= new Chunk(datos[41].substring(46, 56).trim(), Arial);	
			c86C= new Chunk(datos[41].substring(56, largoArreg).trim(), Arial);
			c86D= new Chunk();
			}
		// FIN ASEGURADOS
		
		
		
		largoArreg = datos[15].length();
		if(largoArreg<1){
			c57 = new Chunk();
			c58 = new Chunk();
			c59 = new Chunk();
		}else if(largoArreg<43&&largoArreg>0){
			c57 = new Chunk(datos[15].substring(37, 47).trim(), Arial);
			c58 = new Chunk();
			c59 = new Chunk();
		}else if(largoArreg<67&&largoArreg>42){
			c57 = new Chunk(datos[15].substring(37, 47).trim(), Arial);
			c58 = new Chunk(datos[15].substring(55, 66).trim(), Arial);
			c59 = new Chunk();
		}else if(largoArreg>130){
			c57 = new Chunk(datos[15].substring(37, 47).trim(), Arial);	    //COBRANZA
			c58 = new Chunk(datos[15].substring(55,66).trim(), Arial);	
			c59 = new Chunk(datos[15].substring(77, 88).trim(), Arial);		//FECHA
		}
		largoArreg = datos[16].length();
		if(largoArreg<1){
			c60 = new Chunk();
			c61 = new Chunk();
			c62 = new Chunk();
			c63 = new Chunk();
			c64 = new Chunk();
			c65 = new Chunk();
		}else {
			c60 = new Chunk(datos[16].substring(0, 3).trim(), Arial);
			c61 = new Chunk(datos[16].substring(5, 7).trim(), Arial);
			c62 = new Chunk(datos[16].substring(9, 13).trim(), Arial);
			c63 = new Chunk(datos[16].substring(15, 17).trim(), Arial);
			c64 = new Chunk(datos[16].substring(19, 21).trim(), Arial);
			c65 = new Chunk(datos[16].substring(23, 27).trim(), Arial);
		}
		largoArreg = datos[17].length();
		if(largoArreg<1){
			c66 = new Chunk();
			c67 = new Chunk();
			c68 = new Chunk();
			c69 = new Chunk();
		}else if(largoArreg < 30){
			c66 = new Chunk(datos[17].substring(0, largoArreg).trim(), Arial);
			c67 = new Chunk();
			c68 = new Chunk();
			c69 = new Chunk();
		}else{
			c66 = new Chunk(datos[17].substring(0, 30).trim(), Arial);
			c67 = new Chunk(datos[17].substring(30, 53).trim(), Arial);
			c68 = new Chunk(datos[17].substring(53, 75).trim(), Arial);
			c69 = new Chunk(datos[17].substring(75, largoArreg).trim(), Arial);
		}
		largoArreg = datos[18].length();
		if(largoArreg<1){
			c70 = new Chunk();
			c71 = new Chunk();
			c72 = new Chunk();
			c73 = new Chunk();
		}else if(largoArreg<30&&largoArreg>0){
			c70= new Chunk(datos[18].substring(0, largoArreg).trim(), Arial);
			c71= new Chunk();
			c72= new Chunk();
			c73= new Chunk();
		}else if(largoArreg<55&&largoArreg>29){
			c70 = new Chunk(datos[18].substring(0, 30).trim(), Arial);
			c71= new Chunk(datos[18].substring(30, largoArreg).trim(), Arial);
			c72= new Chunk();
			c73= new Chunk();
		}else if(largoArreg<75&&largoArreg>54){
			c70 = new Chunk(datos[18].substring(0, 30).trim(), Arial);
			c71= new Chunk(datos[18].substring(30, 53).trim(), Arial);
			c72 = new Chunk(datos[18].substring(53, largoArreg).trim(), Arial);
			c73= new Chunk();			
		}else{
			c70 = new Chunk(datos[18].substring(0, 30).trim(), Arial);
			c71 = new Chunk(datos[18].substring(30, 53).trim(), Arial);
			c72 = new Chunk(datos[18].substring(53, 75).trim(), Arial);
			c73 = new Chunk(datos[18].substring(75, largoArreg).trim(), Arial);
		}	
		
		largoArreg = datos[19].length();
		if(largoArreg<1){
			c80 = new Chunk();
			c80A = new Chunk();
			c80B = new Chunk();
			c80C = new Chunk();
		}else if(largoArreg<30&&largoArreg>10){
			c80 = new Chunk(datos[19].substring(0, largoArreg).trim(), Arial);
			c80A = new Chunk();
			c80B = new Chunk();
			c80C = new Chunk();
		}else if(largoArreg<55&&largoArreg>29){
			c80 = new Chunk(datos[19].substring(0, 30).trim(), Arial);
			c80A = new Chunk(datos[19].substring(31, largoArreg).trim(), Arial);
			c80B = new Chunk();
			c80C = new Chunk();
		}else if(largoArreg<75&&largoArreg>54){
			c80 = new Chunk(datos[19].substring(0, 30).trim(), Arial);
			c80A = new Chunk(datos[19].substring(31, 53).trim(), Arial);
			c80B = new Chunk(datos[19].substring(53, largoArreg).trim(), Arial);
			c80C = new Chunk();
		}else{
			c80 = new Chunk(datos[19].substring(0, 30).trim(), Arial);
			c80A = new Chunk(datos[19].substring(31, 53).trim(), Arial);
			c80B = new Chunk(datos[19].substring(53, 74).trim(), Arial);
			c80C = new Chunk(datos[19].substring(75, largoArreg).trim(), Arial);
		}
		
		largoArreg = datos[20].length();
		c92 = new Chunk(datos[20].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[21].length();
		c93 = new Chunk(datos[21].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[22].length();
		c94= new Chunk(datos[22].substring(0, largoArreg).trim(), Arial);
		
		largoArreg = datos[24].length();
		c74 = new Chunk(datos[24].substring(0, datos[24].length()), Arial);
		
		c75 = new Chunk(datos[28].substring(0, datos[28].length()), Arial);
		c75A = new Chunk(datos[29].substring(0, datos[29].length()), Arial);
		
		
		largoArreg = datos[58].length();
		if(largoArreg<10){
			c76 = new Chunk();
			c77 = new Chunk();
			c78 = new Chunk();
			c78A = new Chunk();
		}else{
			largoArreg = datos[58].length();
			c76 = new Chunk(datos[58].substring(0, 11).trim(), Arial);
			largoArreg = datos[58].length();
			c77 = new Chunk(datos[58].substring(11, 28).trim(), Arial);
			largoArreg = datos[58].length();
			c78 = new Chunk(datos[58].substring(28, largoArreg).trim(), Arial);
			largoArreg = datos[59].length();
			c78A = new Chunk(datos[59].substring(0, 30).trim(), Arial);
			largoArreg = datos[59].length();
		}		

		largoArreg = datos[65].length();
		if(largoArreg<10){
			c95 = new Chunk();
			c96 = new Chunk();
			c97 = new Chunk();	
			c98 = new Chunk();
		}else{
			largoArreg = datos[65].length();
			c95 = new Chunk(datos[65].substring(8, 11).trim(), Arial);
			largoArreg = datos[65].length();
			c96 = new Chunk(datos[65].substring(15, 27).trim(), Arial);
			largoArreg = datos[65].length();
			c97 = new Chunk(datos[65].substring(31, 35).trim(), Arial);
			largoArreg = datos[66].length();
			c98 = new Chunk(datos[66].substring(2, 35).trim(), Arial);
				
		}		

		
		largoArreg = datos[45].length();
		c89 = new Chunk(datos[45].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[46].length();
		c90 = new Chunk(datos[46].substring(0, largoArreg).trim(), Arial);
		largoArreg = datos[47].length();
		c91 = new Chunk(datos[47].substring(0, largoArreg).trim(), Arial);
		

		phraset = new Phrase(c0);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 34, 703, 0);
		System.out.println("Generando c0: " + phraset);
		phraset = new Phrase(c1); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 510, 701, 0);
		System.out.println("Generando c1: " + phraset);		
		// Datos Generales
		phraset = new Phrase(c2);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 74, 682, 0);
		System.out.println("Generando c2: " + phraset);
		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 441, 682, 0); 
		System.out.println("Generando c3: " + phraset);
		phraset = new Phrase(c4); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 74, 657, 0);  
		System.out.println("Generando c4: " + phraset);
		phraset = new Phrase(c5);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 476, 661, 0);
		System.out.println("Generando c5: " + phraset);
		phraset = new Phrase(c6); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 74, 647, 0);
		System.out.println("Generando c6: " + phraset);		
		//Blanco
		phraset = new Phrase(c7);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 74, 637, 0);
		System.out.println("Generando c7: " + phraset);		
		
		// Asegurados
		phraset = new Phrase(c8); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 583, 0); 
		System.out.println("Generando c8: " + phraset);
		phraset = new Phrase(c9);     
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 75, 583, 0);
		System.out.println("Generando c9: " + phraset);
		phraset = new Phrase(c10); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 314, 583, 0);
		System.out.println("Generando c10: " + phraset);
		phraset = new Phrase(c11);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 400, 583, 0);
		System.out.println("Generando c11: " + phraset);
		phraset = new Phrase(c12); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 487, 583, 0); 
		System.out.println("Generando c12: " + phraset);	
		phraset = new Phrase(c13); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 583, 0); 
		System.out.println("Generando c13: " + phraset);
		phraset = new Phrase(c14);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 583, 0);
		System.out.println("Generando c14: " + phraset);	
		//Planes
		phraset = new Phrase(c15); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 566, 0);
		System.out.println("Generando c15: " + phraset);
		phraset = new Phrase(c16);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 75, 566, 0);
		System.out.println("Generando c16: " + phraset);
		phraset = new Phrase(c17);		
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 314, 566, 0);
		System.out.println("Generando c17: " + phraset);
		phraset = new Phrase(c18);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 400, 566, 0);
		System.out.println("Generando c18: " + phraset);
		phraset = new Phrase(c19); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 488, 566, 0);
		System.out.println("Generando c19: " + phraset);
		phraset = new Phrase(c20);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 566, 0);
		System.out.println("Generando c20: " + phraset);
		phraset = new Phrase(c21);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 566, 0);
		System.out.println("Generando c21: " + phraset);
		phraset = new Phrase(c22); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 549, 0);
		System.out.println("Generando c22: " + phraset);
		phraset = new Phrase(c23);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 75, 549, 0);
		System.out.println("Generando c23: " + phraset);
		phraset = new Phrase(c24); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 314, 549, 0);  
		System.out.println("Generando c24: " + phraset);
		phraset = new Phrase(c25);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 400, 549, 0);
		System.out.println("Generando c25: " + phraset);
		phraset = new Phrase(c26);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 488, 549, 0);
		System.out.println("Generando c26: " + phraset);
		phraset = new Phrase(c27);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 549, 0);
		System.out.println("Generando c27: " + phraset);
		phraset = new Phrase(c28);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 549, 0);
		System.out.println("Generando c28: " + phraset);
		
		phraset = new Phrase(c29); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 532, 0);
		System.out.println("Generando c29: " + phraset);
		phraset = new Phrase(c30);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 75, 532, 0);
		System.out.println("Generando c30: " + phraset);
		phraset = new Phrase(c31); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 314, 532, 0);  
		System.out.println("Generando c31: " + phraset);
		phraset = new Phrase(c32);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 400, 532, 0);
		System.out.println("Generando c32: " + phraset);
		phraset = new Phrase(c33);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 488, 532, 0);
		System.out.println("Generando c33: " + phraset);
		phraset = new Phrase(c34);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 532, 0);
		System.out.println("Generando c34: " + phraset);
		phraset = new Phrase(c35);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 532, 0);
		System.out.println("Generando c35: " + phraset);
		
		phraset = new Phrase(c36); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 515, 0);
		System.out.println("Generando c36: " + phraset);
		phraset = new Phrase(c37);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 75, 515, 0);
		System.out.println("Generando c37: " + phraset);
		phraset = new Phrase(c38); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 314, 515, 0);  
		System.out.println("Generando c38: " + phraset);
		phraset = new Phrase(c39);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 400, 515, 0);
		System.out.println("Generando c39: " + phraset);
		phraset = new Phrase(c40);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 488, 515, 0);
		System.out.println("Generando c40: " + phraset);
		phraset = new Phrase(c41);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 515, 0);
		System.out.println("Generando c41: " + phraset);
		phraset = new Phrase(c42);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 515, 0);
		System.out.println("Generando c42: " + phraset);

		phraset = new Phrase(c43); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 498, 0);
		System.out.println("Generando c43: " + phraset);
		phraset = new Phrase(c44);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 75, 498, 0);
		System.out.println("Generando c44: " + phraset);
		phraset = new Phrase(c45); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 314, 498, 0);  
		System.out.println("Generando c45: " + phraset);
		phraset = new Phrase(c46);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 400, 498, 0);
		System.out.println("Generando c46: " + phraset);
		phraset = new Phrase(c47);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 488, 498, 0);
		System.out.println("Generando c47: " + phraset);
		phraset = new Phrase(c48);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 498, 0);
		System.out.println("Generando c48: " + phraset);
		phraset = new Phrase(c49);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 498, 0);
		System.out.println("Generando c49: " + phraset);
		
		phraset = new Phrase(c50); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 483, 0);
		System.out.println("Generando c50: " + phraset);
		phraset = new Phrase(c51);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 75, 483, 0);
		System.out.println("Generando c51: " + phraset);
		phraset = new Phrase(c52); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 314, 483, 0);  
		System.out.println("Generando c52: " + phraset);
		phraset = new Phrase(c53);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 400, 483, 0);
		System.out.println("Generando c53: " + phraset);
		phraset = new Phrase(c54);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 488, 483, 0);
		System.out.println("Generando c54: " + phraset);
		phraset = new Phrase(c55);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 483, 0);
		System.out.println("Generando c55: " + phraset);
		phraset = new Phrase(c56);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 540, 483, 0);
		System.out.println("Generando c56: " + phraset);
		// FIN ASEGURADOS
		
		phraset = new Phrase(c57);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 230, 432, 0);
		System.out.println("Generando c57: " + phraset);		
		phraset = new Phrase(c58);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 365, 432, 0);
		System.out.println("Generando c58: " + phraset);
		phraset = new Phrase(c59);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 490, 432, 0);
		System.out.println("Generando c59: " + phraset);
				
		phraset = new Phrase(c60);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 432, 0);
		System.out.println("Generando c60: " + phraset);
		phraset = new Phrase(c61);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 41, 432, 0);
		System.out.println("Generando c61: " + phraset);
		phraset = new Phrase(c62);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 69, 432, 0);
		System.out.println("Generando c62: " + phraset);
		phraset = new Phrase(c63);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 104, 432, 0);
		System.out.println("Generando c63: " + phraset);
		phraset = new Phrase(c64);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 135, 432, 0);
		System.out.println("Generando c64: " + phraset);
		phraset = new Phrase(c65);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 166, 432, 0);
		System.out.println("Generando c65: " + phraset);
				
		phraset = new Phrase(c66);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 400, 0);
		System.out.println("Generando c66: " + phraset);
		phraset = new Phrase(c67);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 223, 400, 0);
		System.out.println("Generando c67: " + phraset);
		phraset = new Phrase(c68);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 366, 400, 0);
		System.out.println("Generando c68: " + phraset);
		phraset = new Phrase(c69);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 505, 400, 0);
		System.out.println("Generando c69: " + phraset);
		
		phraset = new Phrase(c70);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 388, 0);
		System.out.println("Generando c70: " + phraset);
		phraset = new Phrase(c71);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 223, 388, 0);
		System.out.println("Generando c71: " + phraset);
		phraset = new Phrase(c72);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 366, 388, 0);
		System.out.println("Generando c72: " + phraset);
		phraset = new Phrase(c73);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 505, 388, 0);
		System.out.println("Generando c73: " + phraset);		

		phraset = new Phrase(c74);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 290, 0);
		System.out.println("Generando c74: " + phraset);		
		phraset = new Phrase(c75);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 160, 205, 0);
		System.out.println("Generando c75: " + phraset);
		phraset = new Phrase(c75A);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 160, 193, 0);
		System.out.println("Generando c75A: " + phraset);
		
		phraset = new Phrase(c92);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 364, 0);
		System.out.println("Generando c92: " + phraset);
		phraset = new Phrase(c93);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 352, 0);
		System.out.println("Generando c93: " + phraset);
		phraset = new Phrase(c94);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 340, 0);
		System.out.println("Generando c94: " + phraset);

		
		phraset = new Phrase(c80A);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 223, 376, 0);
		System.out.println("Generando c80A: " + phraset);
		
		phraset = new Phrase(c80B);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 366, 376, 0);
		System.out.println("Generando c80B: " + phraset);
		
		phraset = new Phrase(c80C);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 505, 376, 0);
		System.out.println("Generando c80C: " + phraset);
		
		phraset = new Phrase(c80);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 12, 376, 0);
		System.out.println("Generando c80: " + phraset);
				
		phraset = new Phrase(c95);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 72, 298, 0);
		System.out.println("Generando c95: " + phraset);
		phraset = new Phrase(c96);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 105, 298, 0);
		System.out.println("Generando c96: " + phraset);
		phraset = new Phrase(c97);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 217, 298, 0);
		System.out.println("Generando c97: " + phraset);
		phraset = new Phrase(c98);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 48, 285, 0);
		System.out.println("Generando c98: " + phraset);

		
		
		
		phraset = new Phrase(c81);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 15, 656, 0);
		phraset = new Phrase(c82);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 15, 641, 0);
		phraset = new Phrase(c83);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 15, 625, 0);
		phraset = new Phrase(c84);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 15, 607, 0);
		phraset = new Phrase(c85);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 15, 585, 0);
		phraset = new Phrase(c86);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 15, 567, 0);
		
		phraset = new Phrase(c81A);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 103, 656, 0);
		phraset = new Phrase(c81B);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 322, 656, 0);
		phraset = new Phrase(c81C);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 656, 0);
		phraset = new Phrase(c82C);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 641, 0);
		phraset = new Phrase(c83C);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 625, 0);
		phraset = new Phrase(c84C);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 607, 0);
		phraset = new Phrase(c85C);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset,420, 585, 0);
		phraset = new Phrase(c86C);        
	    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 567, 0);
	    phraset = new Phrase(c81D);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 656, 0);
		phraset = new Phrase(c82D);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 641, 0);
		phraset = new Phrase(c83D);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 625, 0);
		phraset = new Phrase(c84D);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 607, 0);
		phraset = new Phrase(c85D);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset,420, 588, 0);
		phraset = new Phrase(c86D);        
	    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 420, 567, 0);
	    
	    phraset = new Phrase(c82A);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 103, 641, 0);
		phraset = new Phrase(c82B);                
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 322, 641, 0);
		phraset = new Phrase(c83A);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 103, 625, 0);
		phraset = new Phrase(c83B);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 322, 625, 0);
		phraset = new Phrase(c84A);       
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 103, 607, 0);
		phraset = new Phrase(c84B);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 322, 607, 0);
		phraset = new Phrase(c85A);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 103, 588, 0);
		phraset = new Phrase(c85B);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 322, 585, 0);
		phraset = new Phrase(c86A);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 103, 567, 0);
		phraset = new Phrase(c86B);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 322, 567, 0);
		phraset = new Phrase(c89);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 30, 68, 0);
		phraset = new Phrase(c90);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 30, 690, 0);
		phraset = new Phrase(c91);        
		ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, phraset, 30, 700, 0);
	
		
		phraset = new Phrase(c76);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 81, 231, 0);
		System.out.println("Generando c76: " + phraset);
		phraset = new Phrase(c77);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 116, 231, 0);
		System.out.println("Generando c77: " + phraset);
		phraset = new Phrase(c78);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 218, 231, 0);
		System.out.println("Generando c78: " + phraset);
		phraset = new Phrase(c78A);        
		ColumnText.showTextAligned(canvas3, Element.ALIGN_LEFT, phraset, 50, 218, 0);
		System.out.println("Generando c78A: " + phraset);
		
		
		
		contCar++;;
		System.out.println("Generando Certificado: " + contCar);
		canvas.endText();
		stamper.close();
	}

	public void creaCaraCteRev(String[] datos) throws IOException, DocumentException{
		PdfReader reader;
		PdfStamper stamper = null;
		reader = new PdfReader(plantilla);
		//	Font Arial=new Font(Font.getFamily("Curier"),9,Font.BOLD);

		//	Font Arial = FontFactory.getFont("Times New Roman");
		BaseFont bf_times = BaseFont.createFont("c:/windows/fonts/lucon.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
		//	BaseFont bf_times = BaseFont.COURIER;
		Font Arial = new Font(bf_times);
		//	Font Arial = new Font(vlad);
		// 	Arial.setSize(9);
		Arial.setStyle(1);
		Arial.setSize((float) 8.78);
		System.out.println("Arial: " + Arial);

		poliza = (((datos[0].substring(94, 97).trim())) + ((datos[0].substring(97, 104).trim())));
		System.out.println("poliza: " + poliza);
		File fl = new File(pathSal+poliza);
		fl.mkdir();
		
		certif = datos[7].substring(0, 7).trim() ;
		System.out.println("certif: " + certif);
		
		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+poliza+"\\"+"Certificado_"+poliza+"_"+certif+".pdf"));
//		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+"_"+datos[0].substring(datos[0].length()/2, ((datos[0].length()/2)+50)).trim()+"_"+contCar+".pdf"));

		Phrase phraset = null;
		PdfContentByte canvas;  
		canvas = stamper.getOverContent(1);
		canvas.beginText(); 


		largoArreg = datos[0].length();
		Chunk c0= new Chunk(datos[0].substring(0, largoArreg), Arial);

		largoArreg = datos[1].length();
		Chunk c1= new Chunk(datos[1].substring(0, largoArreg), Arial);

		largoArreg = datos[2].length();
		Chunk c2 = new Chunk(datos[2].substring(0, largoArreg), Arial);

		largoArreg = datos[3].length();
		Chunk c3= new Chunk(datos[3].substring(0, largoArreg), Arial);

		largoArreg = datos[4].length();
		Chunk c4= new Chunk(datos[4].substring(0, largoArreg), Arial);

		largoArreg = datos[5].length();
		Chunk c5 = new Chunk(datos[5].substring(0, largoArreg), Arial);

		largoArreg = datos[6].length();
		Chunk c6= new Chunk(datos[6].substring(0, largoArreg), Arial);

		largoArreg = datos[7].length();
		Chunk c7= new Chunk(datos[7].substring(0, largoArreg), Arial);

		largoArreg = datos[7].length();
		Chunk c8 = new Chunk(datos[7].substring(0, largoArreg), Arial);

		largoArreg = datos[8].length();
		Chunk c9= new Chunk(datos[8].substring(0, largoArreg), Arial);

		largoArreg = datos[10].length();
		Chunk c10= new Chunk(datos[10].substring(0, largoArreg), Arial);

		largoArreg = datos[11].length();
		Chunk c11 = new Chunk(datos[11].substring(0, largoArreg), Arial);

		phraset = new Phrase(c0);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 698, 0);         
		System.out.println("Generando c0: " + phraset);
		phraset = new Phrase(c1);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 688, 0);         
		System.out.println("Generando c1: " + phraset);
		phraset = new Phrase(c2);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 662, 0);
		System.out.println("Generando c2: " + phraset);
		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 650, 0); 
		System.out.println("Generando c3: " + phraset);
		phraset = new Phrase(c4); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 638, 0);  
		System.out.println("Generando c4: " + phraset);
		phraset = new Phrase(c5);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 628, 0);
		System.out.println("Generando c5: " + phraset);
		phraset = new Phrase(c6); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 618, 0);
		System.out.println("Generando c6: " + phraset);
		phraset = new Phrase(c7);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 579, 0);
		System.out.println("Generando c7: " + phraset);
		phraset = new Phrase(c8); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 567, 0); 
		System.out.println("Generando c8: " + phraset);
		phraset = new Phrase(c9);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 555, 0);
		System.out.println("Generando c9: " + phraset);
		phraset = new Phrase(c10); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 543, 0);
		System.out.println("Generando c10: " + phraset);
		phraset = new Phrase(c11);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 531, 0);
		System.out.println("Generando c11: " + phraset);			
		contCar++;;
		System.out.println("Generando Certificado: " + contCar);
		canvas.endText();
		stamper.close();
	}
}

