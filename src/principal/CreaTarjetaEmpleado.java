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
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

//import org.apache.pdfbox.pdmodel.PDDocument;

public class CreaTarjetaEmpleado {

	//Aqui va la PLANTILLA
	public static final String plantillaAC = CtsArmado.pathJar + "Plantilla Tarjeta Empleado.pdf";
	public static final String plantillaAS = CtsArmado.pathJar + "Plantilla Tarjeta AS OK.pdf";
	public static final String plantillaNC = CtsArmado.pathJar + "Plantilla Tarjeta NC OK.pdf";
	public static final String plantillaNS = CtsArmado.pathJar + "Plantilla Tarjeta NS OK.pdf";
	
	//Aqui van la DATOS
	public static final String entrada = CtsArmado.ArchSalControl + "GeneraTarjetas.txt";

	//Aqui va el PathSalida
	public static String pathSal = CtsArmado.ArchTar;


	public static void main(String[] args) {
		try{
			CreaTarjetaEmpleado cc = new CreaTarjetaEmpleado("");		
			cc.CreaPDF(CtsArmado.ArchTar);
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (DocumentException e) {			
			e.printStackTrace();
		}
	}

	public CreaTarjetaEmpleado(String nNegocio){
		pathSal = CtsArmado.ArchTar;
		pathSal = pathSal + nNegocio;
		pathSal = CtsArmado.ArchTar; //fase2
	}
	
	public void CreaPDF(String file) throws IOException, DocumentException {
		System.out.println("file: " + entrada);
		PdfReader reader;
		PdfStamper stamper = null;
		BufferedReader br = null; 
		String titular = "";
		String tipoTarj = "";
		String medica = " ";
		String poliza = "";
		String certificado = "";
		String plan = "";
		String miembro = "";
		String noEmpleado  = "";
		String deducible  = "";
		String coaseguro  = "";
		String inicioVigencia = "";
		String otrasCias = "";
		File f = null;
		
		int cont = 0;
		
 	//	f = new File(file);
		f = new File(entrada);
		br = new BufferedReader(new FileReader(f)); 
		String line = ""; 

		
			



		while((line = br.readLine()) != null){ 

			reader = new PdfReader(plantillaAC);


			titular = line.substring(0, 30);
			titular = titular.trim();
			poliza = line.substring(38, 46);
			String ast = line.substring(120,121);
			if(ast.equals("*")){
				certificado = line.substring(120, 128);
			}else {
				certificado = line.substring(119, 127);
			}
			plan = line.substring(285, 301);
			plan = plan.trim();
			noEmpleado = line.substring(199, 205);
			inicioVigencia = line.substring(151, 164);
			otrasCias = line.substring(373, 386);
			QRMaker qrm = new QRMaker();
			qrm.getQR(poliza+" "+certificado+" "+titular+" http://www.gnp.com.mx");
			Image img = Image.getInstance(CtsArmado.RUTA_IMAGEN);
	        img.setAbsolutePosition(340,278);			
			Font helvetica = new Font(FontFamily.HELVETICA);
			helvetica.setSize(10);
			helvetica.setStyle(1);
			helvetica.setColor(20,13,77);
			//		Font helvetica = new Font(FontFamily.HELVETICA, 10,1,BaseColor.RED); 
			cont++;
			File fa = new File(pathSal+poliza+"\\");	
			fa.mkdir();
//			File fi = new File(pathSal+poliza+"\\"+poliza+"_"+certificado + ".pdf");	
//			stamper = new PdfStamper(reader, new FileOutputStream(pathSal+poliza+"\\"+certificado+"_"+poliza + ".pdf"));     	       

			stamper = new PdfStamper(reader, new FileOutputStream(pathSal+poliza+"\\"+certificado +"_" +poliza +".pdf"));     	       
			
			PdfContentByte under, canvas; 
			under = stamper.getUnderContent(1);
	        under.addImage(img);
			stamper.setRotateContents(false);
			canvas = stamper.getOverContent(1); 
			canvas.beginText(); 
//			BaseFont bf_helv = helvetica.getCalculatedBaseFont(false);
			if  (tipoTarj.equals("A")) {

				Chunk c =  new Chunk(titular, helvetica);
				Phrase phraset = new Phrase(c);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 187, 610, 0);

				Chunk d =  new Chunk(poliza, helvetica);
				Phrase phrasep = new Phrase(d);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasep, 210, 594, 0);

				Chunk e =  new Chunk(certificado, helvetica);
				Phrase phrasec = new Phrase(e);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasec, 335, 594, 0);

				Chunk h =  new Chunk(miembro, helvetica);
				Phrase phrasem = new Phrase(h);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasem, 355, 563, 0);

				Chunk g =  new Chunk(plan, helvetica);
				Phrase phrasepl = new Phrase(g);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasepl, 218, 575, 0); 
			} else {

				//Titular
				Chunk c =  new Chunk(titular, helvetica);
				Phrase phraset = new Phrase(c);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 187, 610, 0);
				//Poliza
				Chunk d =  new Chunk(poliza, helvetica);
				Phrase phrasep = new Phrase(d);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasep, 218, 593, 0);
				//plan
				Chunk g =  new Chunk(plan, helvetica);
				Phrase phrasepl = new Phrase(g);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasepl, 340, 628, 0);

				helvetica.setSize(8);

				//Certificado
				Chunk e =  new Chunk(certificado, helvetica);
				Phrase phrasec = new Phrase(e);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasec, 356, 576, 0);
				//Fecha Antiguedad GNP
				Chunk h =  new Chunk(miembro, helvetica);
				Phrase phrasem = new Phrase(h);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasem, 255, 566, 0);
				//Fecha Otras Compañias
				Chunk o =  new Chunk(otrasCias, helvetica);
				Phrase phraseoc = new Phrase(o);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraseoc, 363, 565, 0);
				//Suma
				Chunk k =  new Chunk(noEmpleado, helvetica);
				Phrase phrases = new Phrase(k);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrases, 385, 591, 0);
				//Deducible
				Chunk l =  new Chunk(deducible, helvetica);
				Phrase phrased = new Phrase(l);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrased, 229, 538, 0); 
				//Coaseguro
				Chunk m =  new Chunk(coaseguro, helvetica);
				Phrase phraseco = new Phrase(m);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraseco, 232, 524, 0); 
				//Inicio vigencia
				Chunk n =  new Chunk(inicioVigencia, helvetica);
				Phrase phrasecfv = new Phrase(n);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasecfv, 259, 576, 0); 
			}


			canvas.endText();
			stamper.close();

			System.out.println("Generando tarjeta: " + cont);
			
		}        	
		br.close();
		
		System.out.println("Ya acabe Tarjetas Normales");
//		String st="  Documentacion Terminada\n Se generarón: " + cont + " tarjetas";
//		JOptionPane.showMessageDialog(null,st);
		
	}



	public void TarjetasLinea(String line) throws DocumentException, IOException{
		
		System.out.println("line: " + line);
		PdfReader reader;
		PdfStamper stamper = null;
		String titular = "";
		String poliza = "";
		String certificado = "";
		String plan = "";
		String miembro = "";
		int cont = 0;
		reader = new PdfReader(plantillaAS);

			titular = line.substring(0, 30);
			titular = titular.trim();
			poliza = line.substring(38, 46);
			String ast = line.substring(120,121);
			if(ast.equals("*")){
				certificado = line.substring(121, 128);
			}else {
				certificado = line.substring(120, 128);
			}
			miembro = line.substring(152, 162);
			plan = line.substring(285, 303);
			plan = plan.trim();
			QRMaker qrm = new QRMaker();
			qrm.getQR(poliza+" "+certificado+" "+titular+" http://www.gnp.com.mx");
			Image img = Image.getInstance(CtsArmado.RUTA_IMAGEN);
	        img.setAbsolutePosition(340,278);			
			Font helvetica = new Font(FontFamily.HELVETICA);
			helvetica.setSize(10);
			helvetica.setStyle(1);
			helvetica.setColor(20,13,77);
			cont++;
			File fa = new File(pathSal+poliza+"\\");	
			fa.mkdir();
			stamper = new PdfStamper(reader, new FileOutputStream(pathSal+poliza+"\\"+certificado +"_" +poliza +".pdf"));     	       
			
			PdfContentByte under, canvas; 
			under = stamper.getUnderContent(1);
	        under.addImage(img);
			stamper.setRotateContents(false);
			canvas = stamper.getOverContent(1); 
			canvas.beginText(); 

				Chunk c =  new Chunk(titular, helvetica);
				Phrase phraset = new Phrase(c);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraset, 187, 610, 0);

				Chunk d =  new Chunk(poliza, helvetica);
				Phrase phrasep = new Phrase(d);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasep, 210, 594, 0);

				Chunk e =  new Chunk(certificado, helvetica);
				Phrase phrasec = new Phrase(e);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasec, 335, 594, 0);

				Chunk h =  new Chunk(miembro, helvetica);
				Phrase phrasem = new Phrase(h);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasem, 355, 563, 0);

				Chunk g =  new Chunk(plan, helvetica);
				Phrase phrasepl = new Phrase(g);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasepl, 219, 575, 0); 
			

			canvas.endText();
			stamper.close();

			System.out.println("Generando tarjeta: " + cont);
	
		
		System.out.println("Ya acabe Tarjetas Normales");
		
	}

}
