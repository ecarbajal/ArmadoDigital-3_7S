package principal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
 
public class MergePDF {
   
    public static void concatPDFs(List<InputStream> streamOfPDFFiles,
                                  OutputStream outputStream) {
 
        Document document = new Document();
        try {
              List<PdfReader> readers = new ArrayList<PdfReader>();

            for (InputStream streamOfPDFFile : streamOfPDFFiles) {
                InputStream pdf = streamOfPDFFile;
                PdfReader pdfReader = new PdfReader(pdf);
                readers.add(pdfReader);
            }
 
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
 
            document.open();
            PdfContentByte cb = writer.getDirectContent();
 
            PdfImportedPage page;
            int pageOfCurrentReaderPDF = 0;

            for (PdfReader reader : readers) {
                PdfReader pdfReader = reader;

                while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {

                    Rectangle rectangle = pdfReader.getPageSizeWithRotation(1);
                    document.setPageSize(rectangle);
                    document.newPage();

                    pageOfCurrentReaderPDF++;
                    //              currentPageNumber++;
                    page = writer.getImportedPage(pdfReader,
                            pageOfCurrentReaderPDF);
                    switch (rectangle.getRotation()) {
                        case 0:
                            cb.addTemplate(page, 1f, 0, 0, 1f, 0, 0);
                            break;
                        case 90:
                            cb.addTemplate(page, 0, -1f, 1f, 0, 0, pdfReader.getPageSizeWithRotation(1).getHeight());
                            break;
                        case 180:
                            cb.addTemplate(page, -1f, 0, 0, -1f, 0, 0);
                            break;
                        case 270:
                            cb.addTemplate(page, 0, 1.0F, -1.0F, 0, pdfReader.getPageSizeWithRotation(1).getWidth(), 0);
                            break;
                        default:
                            break;
                    }
                    cb.beginText();
                    cb.getPdfDocument().getPageSize();
                    cb.endText();
                }
                pageOfCurrentReaderPDF = 0;
            }
            outputStream.flush();
            document.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen())
                document.close();
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}