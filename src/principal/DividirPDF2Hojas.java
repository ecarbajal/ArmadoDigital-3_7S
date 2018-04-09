package principal;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

public class DividirPDF2Hojas {
	
	
	public static void main(String[] args) {
		try{
			DividirPDF2Hojas cc = new DividirPDF2Hojas();		
			cc.divPDF("E:\\doc1\\214597908\\214597908-14000.pdf");
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}
	
	
	public void divPDF(String archivo) {
		
		
		try {
			String inFile = archivo.toLowerCase();
			System.out.println("Lee " + inFile);
			PdfReader reader = new PdfReader(inFile);
			int n = reader.getNumberOfPages();
			System.out.println("Numero de paginas: " + n);
			int i = 0, j=13001;
			while (i < n) {
				
				String outFile = inFile.substring(0, inFile.indexOf(".pdf"))+ "-" + String.format("%04d", j ) + ".pdf";
				j++;
				System.out.println("Escribe " + outFile);
				Document document = new Document(reader.getPageSizeWithRotation(1));
				PdfCopy writer = new PdfCopy(document, new FileOutputStream(outFile));
				document.open();
				PdfImportedPage page = writer.getImportedPage(reader, ++i);
				writer.addPage(page);
				if(i<n){
					PdfImportedPage page1 = writer.getImportedPage(reader, ++i);
					writer.addPage(page1);
				}
				document.close();
				writer.close();
			}
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

	public String selecArchivo() {
		JFileChooser filechoose = new JFileChooser("C:\\");
		filechoose.showOpenDialog(null);
		File file = filechoose.getSelectedFile();
		if (file.exists()) {
			return file.getAbsolutePath();
		} else {
			System.out.println("No se encontro el Archivo");
		}
		return null;
	}
}
