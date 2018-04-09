package principal;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRMaker {

	private static final String FORMATO_IMAGEN = "gif";
	private static final int ancho = 82;
	private static final int alto = 82;

	public void  getQR(String datos){
		BitMatrix bm;
		Writer writer = new QRCodeWriter(); 
		try {
			bm = writer.encode(datos, BarcodeFormat.QR_CODE, ancho, alto);
			BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB); 
			for (int y = 0; y < ancho; y++) {
				for (int x = 0; x < alto; x++) {
					int grayValue = (bm.get(x, y) ? 1 : 0) & 0xff;
					image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
				}
			} 
			image = invertirColores(image); 
			FileOutputStream qrCode;			
			qrCode = new FileOutputStream(CtsArmado.RUTA_IMAGEN);				 
			ImageIO.write(image, FORMATO_IMAGEN, qrCode);			 
			qrCode.close(); 
			//	  Desktop d = Desktop.getDesktop();
			//	  d.open(new File(CtsArmado.RUTA_IMAGEN)); 
		} catch (WriterException e) {			
			e.printStackTrace();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} 

	}

	private static  BufferedImage invertirColores(BufferedImage imagen) {
		for (int x = 0; x < ancho; x++) {
			for (int y = 0; y < alto; y++) {
				int rgb = imagen.getRGB(x, y);
				if (rgb == -16777216) {
					imagen.setRGB(x, y, -1);
				} else {
					imagen.setRGB(x, y, -16777216);
				}
			}
		}
		return imagen;
	} 

}
