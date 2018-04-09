
package principal;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import com.itextpdf.text.DocumentException;


public class FTPRecibo {
    private int reply;

    public void ftpArchivo(String archivo, String user, String pass) throws SocketException, IOException {
        try {
            FTPClient cliente = new FTPClient();
            cliente.connect("150.23.1.39");
            this.reply = cliente.getReplyCode();
            this.reply = 220;
            System.out.println("reply connect status: " + this.reply);
            if (this.reply == 220) {
                if (cliente.login(user, pass)) {
                	String RemoteFile = "\'" + archivo + "\'";
                    System.out.println("Remote File: " + RemoteFile);
                    File downloadFile1 = new File("C:\\Armado Digital Recibo\\Control\\Spool_Recibo.txt");
                    BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                    cliente.retrieveFile(RemoteFile,outputStream1);
                    this.reply = cliente.getReplyCode();
                    outputStream1.close();
                    cliente.logout();
                    cliente.disconnect();
                    if (this.reply != 550){
                    	  try {
          	                GeneraRecibo gr = new GeneraRecibo();
          	                gr.creaRecibo("");
          	            }
          	            catch (DocumentException e1) {
          	                e1.printStackTrace();
          	            }
                    }else{
                    	String ms = "No se pudo descargar el archivo.";
    	        		JOptionPane.showMessageDialog(null, ms);
                    }
                    
                } else {
                    String st = "El usuario no ha podido conectarse";
                    JOptionPane.showMessageDialog(null, st);
                }
            } else {
                String st = "No se ha podido establecer conexi\u00f3n";
                
                JOptionPane.showMessageDialog(null, st);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}