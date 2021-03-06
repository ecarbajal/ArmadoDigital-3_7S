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

public class CreaRegistro_endBN {

	public static final String plantilla = CtsArmado.pathJar + "Plantilla GM07 BN.pdf";
	public static final String plantilla2 = CtsArmado.pathJar + "Plantilla GM07 BNB.pdf";
	public static String pathSal = CtsArmado.pathSal;
	public static final String path = CtsArmado.pathSpool + "Spool_Reg_end.txt";

	int contCar = 0;
	int largoArreg = 0;
	int largopol = 0;
	String poliza = "";
	String cad = "";
	String cad2 = "";

	public CreaRegistro_endBN(String nNegocio) {
		pathSal = CtsArmado.pathSal;
		pathSal  = pathSal + nNegocio;
	}

	public static void main(String[] args) {
		try{
			CreaRegistro_endBN cc = new CreaRegistro_endBN("");		
			cc.creaRegis_end(path);
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (DocumentException e) {			
			e.printStackTrace();
		}
	}

	public void creaRegis_end(String file) throws IOException, DocumentException{
		File f = null;
		String line = "";
		int cont = 0, contfin=0;
		boolean flag = true;
		String datos[] = new String[45];
		String datosfin[] = new String[45];
		f = new File(path);
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader(f));    
		
			while(flag){
				cont=0;	
				contfin=0;
			
				while(((line = br.readLine()) != null) && (line.trim().indexOf("+*17 "))<0){
				datosfin[contfin]=line.substring(1, line.length());
				contfin++;
				}
				if(line != null){			
				datos[cont]=line.substring(1, line.length());
				cont++;
				}else{
					while((contfin<45)){
						datosfin[contfin]="";
						contfin++;
					}
				}
			
			
			while(((line = br.readLine()) != null)&&(cont<45)){
				if(!line.trim().equals("DJD1 FORM=NULA,END;")){
					if(line.length()>0){
						if((line.trim().equals("DJD1 FEED='SEGU1',PMODE=POR,FORM=AZ48,JDE=AZ48,DUP=YES,END;"))||(line.trim().equals("DJD1 FEED='SEGU1',JDE=GM07,PMODE=POR,DUP=NO,FORM=GM07,END;"))){
							datos[cont]="";
						}else{
							datos[cont]=line.substring(1, line.length());
						}
						}else{
						datos[cont]="";
					}
					cont++;
//					boolean ultimaPag = true;
				}else{
					while((cont<45)){
						datos[cont]="";
						cont++;
					}
//					boolean ultimaPag = false;
					
				}
			}
			
			if(line!=null){
				creaCaraCte(datos);
				cont=0;
			}else{
				flag= false;
				if (!datosfin[16].equals(""))
					creaCarafin(datosfin,this.poliza);
			}
		}
		br.close();
		System.out.println("final");
	}
	
	private void creaCarafin(String[] datosfin, String poliza) throws IOException, DocumentException {

		PdfReader reader;
		PdfStamper stamper = null;
		reader = new PdfReader(plantilla2);
		Font Arial=new Font(Font.getFamily("Arial"),(float) 10);
		Arial.setSize((float) 10);
		Arial.setColor(80, 80, 80);
		cad2 = Integer.toString(contCar);
		System.out.println("poliza: " + poliza);
		File fl = new File(pathSal+ "\\"+poliza+"\\Registro Asegurados\\");
		fl.mkdirs();
		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+ "\\"+poliza+"\\Registro Asegurados\\"+"Registro_"+poliza+""+"_9999"+".pdf"));
		Phrase phraset = null;
		PdfContentByte canvas;  
		canvas = stamper.getOverContent(1);
		canvas.beginText(); 
		
		largoArreg = datosfin[16].length();
		Chunk c1 = new Chunk(datosfin[16].substring(8, 10), Arial);
		Chunk c2 = new Chunk(datosfin[16].substring(15, 30).trim(), Arial);
		Chunk c3 = new Chunk(datosfin[16].substring(31, 35).trim(), Arial);
		largoArreg = datosfin[17].length();
		Chunk c4 = new Chunk(datosfin[17].substring(0, 40).trim(), Arial);
		
		phraset = new Phrase(c1); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset,  64, 238, 0);  
		System.out.println("Generando c1: " + phraset);
		phraset = new Phrase(c2); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 95, 238, 0);  
		System.out.println("Generando c2: " + phraset);
		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 180, 238, 0);  
		System.out.println("Generando c3: " + phraset);
		phraset = new Phrase(c4); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset,50, 226, 0);  
		System.out.println("Generando c4: " + phraset);
		
		contCar++;;
		System.out.println("Generando fin Registro: " + contCar);
		canvas.endText();
		stamper.close();
	
	}

	public void creaCaraCte(String[] datos) throws IOException, DocumentException{
		PdfReader reader;
		PdfStamper stamper = null;
		reader = new PdfReader(plantilla);
		Font Arial=new Font(Font.getFamily("Arial"),(float) 9.96);
		Arial.setSize((float) 9.96);
		Arial.setColor(23, 54, 93);
		cad2 = Integer.toString(contCar);
		cad = fillCeros(cad2, 4);
		 System.out.println("90: " + datos[0].substring(90,91));
		if (datos[0].substring(90,91).equals(" "))
			{	
			poliza = 0 + (datos[0].substring(91, 98).trim());
			}
		else{
			poliza = (datos[0].substring(86, 96).trim());
		}
		largopol=poliza.length();
		if (largopol<8){
			poliza = "0" + poliza;
		}
		System.out.println("poliza: " + poliza);
		File fl = new File(pathSal+ "\\"+poliza+"\\Registro Asegurados\\");
		fl.mkdirs();

		stamper = new PdfStamper(reader, new FileOutputStream(pathSal+ "\\"+poliza+"\\Registro Asegurados\\"+"Registro_"+poliza+"_"+cad+".pdf"));
		Phrase phraset = null;
		PdfContentByte canvas;  
		canvas = stamper.getOverContent(1);
		canvas.beginText(); 
		int ind1 = 0;	
		int i;
		largoArreg = datos[0].length();
		ind1 = largoArreg/2;
		Chunk c0= new Chunk(datos[0].substring(0, ind1).trim(), Arial);
		Chunk c01= new Chunk(datos[0].substring(ind1, largoArreg).trim(), Arial);			
		largoArreg = datos[2].length();
		Chunk c1= new Chunk(datos[2].substring(0, 70).trim(), Arial);		
		Chunk c11= new Chunk(datos[2].substring(70, largoArreg).trim(), Arial);		
		largoArreg = datos[4].length();
		Chunk c2= new Chunk(datos[4].substring(0, 71).trim(), Arial);
		Chunk c21= new Chunk(datos[4].substring(71, largoArreg).trim(), Arial);		
		largoArreg = datos[5].length();
		Chunk c3= new Chunk(datos[5].substring(0, largoArreg).trim(), Arial);		
		largoArreg = datos[7].length();		
		Chunk c4 = new Chunk(datos[7].substring(0, 3).trim(), Arial);
		Chunk c41 = new Chunk(datos[7].substring(3, 8).trim(), Arial);
		Chunk c42 = new Chunk(datos[7].substring(8, 16).trim(), Arial);
		Chunk c43 = new Chunk(datos[7].substring(16, 20).trim(), Arial);
		Chunk c44 = new Chunk(datos[7].substring(20, 25).trim(), Arial);
		Chunk c45 = new Chunk(datos[7].substring(25, 32).trim(), Arial);
		Chunk c46 = new Chunk(datos[7].substring(32, 50).trim(), Arial);
		Chunk c47 = new Chunk(datos[7].substring(50, 80).trim(), Arial);
		Chunk c48 = new Chunk(datos[7].substring(80, 105).trim(), Arial);		
		Chunk datosChuck[][] = new Chunk[37][7];
		for(i = 10; i<44;i++){			
				largoArreg = datos[i].length();
				if(largoArreg<1){
					datosChuck[i-9][0]= new Chunk();
					datosChuck[i-9][1]= new Chunk();
					datosChuck[i-9][2]= new Chunk();
					datosChuck[i-9][3]= new Chunk();
					datosChuck[i-9][4]= new Chunk();
					datosChuck[i-9][5]= new Chunk();
					datosChuck[i-9][6]= new Chunk();			
			}else if(largoArreg<10&&largoArreg>0){	
				datosChuck[i-9][0]= new Chunk(datos[i].substring(0, largoArreg).trim(), Arial);
				datosChuck[i-9][1]= new Chunk();
				datosChuck[i-9][2]= new Chunk();
				datosChuck[i-9][3]= new Chunk();
				datosChuck[i-9][4]= new Chunk();
				datosChuck[i-9][5]= new Chunk();
				datosChuck[i-9][6]= new Chunk();		
			}else if(largoArreg<45&&largoArreg>9){		
				datosChuck[i-9][0]= new Chunk(datos[i].substring(0, 9).trim(), Arial);
				datosChuck[i-9][1]= new Chunk(datos[i].substring(9, largoArreg).trim(), Arial);
				datosChuck[i-9][2]= new Chunk();
				datosChuck[i-9][3]= new Chunk();
				datosChuck[i-9][4]= new Chunk();
				datosChuck[i-9][5]= new Chunk();
				datosChuck[i-9][6]= new Chunk();	
			}else if(largoArreg<49&&largoArreg>43){	
				datosChuck[i-9][0]= new Chunk(datos[i].substring(0, 9).trim(), Arial);
				datosChuck[i-9][1]= new Chunk(datos[i].substring(9, 40).trim(), Arial);
				datosChuck[i-9][2]= new Chunk(datos[i].substring(44, largoArreg).trim(), Arial);
				datosChuck[i-9][3]= new Chunk();
				datosChuck[i-9][4]= new Chunk();
				datosChuck[i-9][5]= new Chunk();
				datosChuck[i-9][6]= new Chunk();
			}else if(largoArreg<57&&largoArreg>48){
				datosChuck[i-9][0]= new Chunk(datos[i].substring(0, 9).trim(), Arial);
				datosChuck[i-9][1]= new Chunk(datos[i].substring(9, 40).trim(), Arial);
				datosChuck[i-9][2]= new Chunk(datos[i].substring(44, 49).trim(), Arial);
				datosChuck[i-9][3]= new Chunk(datos[i].substring(49, largoArreg).trim(), Arial);				
				datosChuck[i-9][4]= new Chunk();
				datosChuck[i-9][5]= new Chunk();
				datosChuck[i-9][6]= new Chunk();
			}else if(largoArreg<75&&largoArreg>56){
				datosChuck[i-9][0]= new Chunk(datos[i].substring(0, 9).trim(), Arial);
				datosChuck[i-9][1]= new Chunk(datos[i].substring(9, 40).trim(), Arial);
				datosChuck[i-9][2]= new Chunk(datos[i].substring(44, 49).trim(), Arial);
				datosChuck[i-9][3]= new Chunk(datos[i].substring(49, 57).trim(), Arial);
				datosChuck[i-9][4]= new Chunk(datos[i].substring(57,largoArreg).trim(), Arial);				
				datosChuck[i-9][5]= new Chunk();
				datosChuck[i-9][6]= new Chunk();
			}else if(largoArreg<87&&largoArreg>74){
				datosChuck[i-9][0]= new Chunk(datos[i].substring(0, 9).trim(), Arial);
				datosChuck[i-9][1]= new Chunk(datos[i].substring(9, 40).trim(), Arial);
				datosChuck[i-9][2]= new Chunk(datos[i].substring(44, 49).trim(), Arial);
				datosChuck[i-9][3]= new Chunk(datos[i].substring(49, 57).trim(), Arial);
				datosChuck[i-9][4]= new Chunk(datos[i].substring(57, 74).trim(), Arial);
				datosChuck[i-9][5]= new Chunk(datos[i].substring(74, largoArreg).trim(), Arial);				
				datosChuck[i-9][6]= new Chunk();
			}else if(largoArreg>86){				
				datosChuck[i-9][0]= new Chunk(datos[i].substring(0, 9).trim(), Arial);
				datosChuck[i-9][1]= new Chunk(datos[i].substring(9, 40).trim(), Arial);
				datosChuck[i-9][2]= new Chunk(datos[i].substring(44, 49).trim(), Arial);
				datosChuck[i-9][3]= new Chunk(datos[i].substring(49, 57).trim(), Arial);
				datosChuck[i-9][4]= new Chunk(datos[i].substring(57, 74).trim(), Arial);
				datosChuck[i-9][5]= new Chunk(datos[i].substring(74, 86).trim(), Arial);
				datosChuck[i-9][6]= new Chunk(datos[i].substring(86, largoArreg).trim(), Arial);
			}
		}
		
		phraset = new Phrase(c0);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 20, 733, 0);         
		System.out.println("Generando c0: " + phraset);	
		
		Arial.setSize((float) 11);
		Arial.setStyle(1);
		phraset = new Phrase(c01);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 550, 733, 0);         
		System.out.println("Generando c01: " + phraset);
		
		Arial.setSize((float) 10);
		Arial.setStyle(0);
//		phraset = new Phrase(c100);        
//		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 40, 540, 0);         
//		System.out.println("Generando c100: " + phraset);
		phraset = new Phrase(c1);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 78, 702, 0);         
		System.out.println("Generando c1: " + phraset);		
		phraset = new Phrase(c11);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 455, 702, 0);
		System.out.println("Generando c11: " + phraset);		
		phraset = new Phrase(c2); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 70, 678, 0); 
		System.out.println("Generando c2: " + phraset);
		phraset = new Phrase(c21); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 490, 678, 0); 
		System.out.println("Generando c21: " + phraset);		
		phraset = new Phrase(c3); 
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 70, 668, 0);  
		System.out.println("Generando c3: " + phraset);			
		phraset = new Phrase(c4);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 23, 595, 0);
		System.out.println("Generando c4: " + phraset);
		phraset = new Phrase(c41);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 60, 595, 0);
		System.out.println("Generando c41: " + phraset);
		phraset = new Phrase(c42);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 90, 595, 0);
		System.out.println("Generando c42: " + phraset);
		phraset = new Phrase(c43);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 120, 595, 0);
		System.out.println("Generando c43: " + phraset);
		phraset = new Phrase(c44);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 150, 595, 0);
		System.out.println("Generando c44: " + phraset);
		phraset = new Phrase(c45);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 178, 595, 0);
		System.out.println("Generando c45: " + phraset);
		phraset = new Phrase(c46);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 230, 595, 0);
		System.out.println("Generando c46: " + phraset);
		phraset = new Phrase(c47);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 350, 595, 0);
		System.out.println("Generando c47: " + phraset);
		phraset = new Phrase(c48);        
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 460, 595, 0);
		System.out.println("Generando c48: " + phraset);
		for(i = 10; i<44;i++){			
				phraset = new Phrase(datosChuck[i-9][0]); 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 25, 496-((i-9)*10), 0);
				System.out.println("Generando["+(i-9)+"[0]: " + phraset);
				phraset = new Phrase(datosChuck[i-9][1]); 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 90, 496-((i-9)*10), 0);
				System.out.println("Generando["+(i-9)+"[1]: " + phraset);
				phraset = new Phrase(datosChuck[i-9][2]); 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 293, 496-((i-9)*10), 0);
				System.out.println("Generando["+(i-9)+"[2]: " + phraset);
				phraset = new Phrase(datosChuck[i-9][3]); 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 340, 496-((i-9)*10), 0);
				System.out.println("Generando["+(i-9)+"[3]: "+ phraset);
				phraset = new Phrase(datosChuck[i-9][4]); 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 395, 496-((i-9)*10), 0);
				System.out.println("Generando["+(i-9)+"[4]: " + phraset);
				phraset = new Phrase(datosChuck[i-9][5]); 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 472, 496-((i-9)*10), 0);
				System.out.println("Generando["+(i-9)+"[5]: " + phraset);
				phraset = new Phrase(datosChuck[i-9][6]); 
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 535, 496-((i-9)*10), 0);
				System.out.println("Generando["+(i-9)+"[6]: " + phraset);			
		}

		contCar++;;
		System.out.println("Generando Registro: " + contCar);
		canvas.endText();
		stamper.close();
	}
	public String fillCeros(String valor, int longitud){

		while(valor.length()<longitud){
			valor = "0" + valor;
		}
		return valor;
	}
}
