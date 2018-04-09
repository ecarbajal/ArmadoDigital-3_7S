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
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

//import org.apache.pdfbox.pdmodel.PDDocument;

public class CreaTarjetaAPF {

	//Aqui va la PLANTILLA
	public static final String plantillaAC = CtsArmado.pathJar + "Plantilla Tarjeta APF OK.pdf";


	//Aqui van la DATOS
	public static final String entrada = CtsArmado.ArchSalControl +  "GeneraTarjetas.txt";

	//Aqui va el PathSalida
	public static String pathSal = (CtsArmado.ArchTar + "APF\\");


	public CreaTarjetaAPF(String nNegocio){
//		pathSal = CtsArmado.ArchTar;
//		pathSal = pathSal + nNegocio;
//		pathSal = CtsArmado.ArchTar; //fase2
	}

	public void CreaPDFAPF(String file) throws IOException, DocumentException {
		System.out.println("file: " + entrada);
		PdfReader reader;
		PdfStamper stamper = null;
		BufferedReader br = null; 
		
		String titular = "";
		String parentesco = "";
		String poliza = "";
		String certificado = "";
		String ingColect = "";
		String antOtrCia = "";
		String inVige = "";
		String edad = "";
		String sumaPoten  = "";
		String iQ  = "";
		String saBasica  = "";
		String deducible = "";
		String coaseguro = "";
		String dependencia = "";
//		String nivelTabular = "";
		File f = null;
		int cont = 0;

		f = new File(entrada);
		br = new BufferedReader(new FileReader(f)); 
		String line = ""; 


	



		while((line = br.readLine()) != null){ 

			reader = new PdfReader(plantillaAC);
			line.length();
			System.out.println("Longitud APF: " + line.length());

			poliza = line.substring(38, 46);
			certificado = line.substring(120, 128);
			titular = line.substring(0, 30).trim();
			parentesco = line.substring(283, 296).trim();
			ingColect = line.substring(67, 77);
			antOtrCia = line.substring(175, 185);
			inVige = line.substring(97, 107);
			edad = line.substring(223, 225);
			sumaPoten = line.substring(147, 160);
			iQ = line.substring(226, 233);
			saBasica = line.substring(200, 211);
			deducible = line.substring(251, 259);
			coaseguro = line.substring(275, 279);
			dependencia = line.substring(297, 317).trim();
//			nivelTabular = line.substring(317, 318);
		
			Font helvetica = new Font(FontFamily.HELVETICA);
			helvetica.setSize(10);
			helvetica.setStyle(1);
			helvetica.setColor(20,13,77);
			//		Font helvetica = new Font(FontFamily.HELVETICA, 10,1,BaseColor.RED); 
			cont++;
			File fa = new File(pathSal);
			if(!fa.exists()){
				fa.mkdir();
			}
			stamper = new PdfStamper(reader, new FileOutputStream(pathSal+dependencia +"_" +poliza +"_"+certificado+".pdf"));     	       

			PdfContentByte canvas; 
			stamper.getUnderContent(1);
			stamper.setRotateContents(false);
			canvas = stamper.getOverContent(1); 
			canvas.beginText(); 

				//Titular
				Chunk a =  new Chunk(titular, helvetica);
				Phrase phrasea = new Phrase(a);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasea, 190, 624, 0);
				//parentesco
				Chunk b =  new Chunk(parentesco, helvetica);
				Phrase phraseb = new Phrase(b);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraseb, 330, 644, 0);
				//Poliza
				Chunk c =  new Chunk(poliza, helvetica);
				Phrase phrasec = new Phrase(c);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasec, 218, 611, 0);
				//Certificado
				Chunk d =  new Chunk(certificado, helvetica);
				Phrase phrased = new Phrase(d);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrased, 363, 611, 0);
				helvetica.setSize(8);
				//ingColect 
				Chunk e =  new Chunk(ingColect, helvetica);
				Phrase phrasee = new Phrase(e);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasee, 252, 598, 0);
				//antOtrCia 
				Chunk g =  new Chunk(antOtrCia , helvetica);
				Phrase phraseg = new Phrase(g);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraseg, 363, 598, 0);
				//inVige 
				Chunk h =  new Chunk(inVige , helvetica);
				Phrase phraseh = new Phrase(h);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phraseh, 252, 585, 0);
                 //edad
				Chunk i =  new Chunk(edad , helvetica);
				Phrase phrasei = new Phrase(i);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasei, 350, 585, 0); 
				//sumaPoten  
				Chunk j =  new Chunk(sumaPoten  , helvetica);
				Phrase phrasej = new Phrase(j);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasej, 262, 571, 0); 
				//iQ  
				Chunk k =  new Chunk(iQ  , helvetica);
				Phrase phrasek = new Phrase(k);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasek, 350, 571, 0); 
				//saBasica    
				Chunk l =  new Chunk(saBasica    , helvetica);
				Phrase phrasel = new Phrase(l);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasel, 233, 557, 0); 
				//deducible   
				Chunk m =  new Chunk(deducible   , helvetica);
				Phrase phrasem = new Phrase(m);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasem, 233, 543, 0); 
				//coaseguro   
				Chunk n =  new Chunk(coaseguro   , helvetica);
				Phrase phrasen = new Phrase(n);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrasen, 233, 530, 0); 


			canvas.endText();
			stamper.close();

			System.out.println("Generando tarjeta APF: " + cont);

		}        	
		br.close();

		System.out.println("Ya acabe Tarjetas APF");

	}



	public void ExistinPDF(){
	}

}
