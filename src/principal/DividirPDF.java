package principal;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

public class DividirPDF {
	public void divPDF(String archivo) {
		try {
			String inFile = archivo.toLowerCase();
			System.out.println("Lee " + inFile);
			PdfReader reader = new PdfReader(inFile);
			int n = reader.getNumberOfPages();
			System.out.println("Numero de paginas: " + n);
			int i = 0;
			while (i < n) {
				String outFile = inFile.substring(0, inFile.indexOf(".pdf"))
						+ "-" + String.format("%03d", i + 1) + ".pdf";
				System.out.println("Escribe " + outFile);
				Document document = new Document(
						reader.getPageSizeWithRotation(1));
				PdfCopy writer = new PdfCopy(document, new FileOutputStream(
						outFile));
				document.open();
				PdfImportedPage page = writer.getImportedPage(reader, ++i);
				writer.addPage(page);
				document.close();
				writer.close();
			}
		} catch (java.lang.Throwable ignored) {
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
