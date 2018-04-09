package principal;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;


public class EnvioFTP {	

	private int reply;
	private int reply2;

	public boolean enviaArchivoFTPMainframe(String archivo, String user, boolean boton ){
		try {
			FTPClient cliente = new FTPClient();
			cliente.connect(CtsArmado.FTPIPDES);
			reply = cliente.getReplyCode();
			if (reply == 220)
			{
				if(cliente.login(CtsArmado.userFTPDES,CtsArmado.passFTPDES))
				{	
					reply = cliente.getReplyCode();
					if (reply2 != 450  ) {
						FileInputStream in = new FileInputStream(archivo);
						System.out.println("Archivo : " + archivo);
						System.out.println("in: " + in);
						if(boton) {
							user = "SOLICI";
							cliente.deleteFile(CtsArmado.archivosalidaMFDES);
							reply = cliente.getReplyCode();
							System.out.println("reply Borra solic: " + reply);
							cliente.appendFile(CtsArmado.archivosalidaMFDES,in);
							reply = cliente.getReplyCode();
							System.out.println("reply sube solici: " + reply);
							System.out.println("Archivo : " + archivo);
							System.out.println("in: " + in);
						} else {
//			fase2			cliente.deleteFile(CtsArmado.archivosalidaCerts+user+"\'");
//							reply = cliente.getReplyCode();
//							System.out.println("reply Borra normalCert: " + reply);
							cliente.deleteFile(CtsArmado.archivosalidaMFDES+"\'");
							reply = cliente.getReplyCode();
							System.out.println("reply Borra normalTarj: " + reply);
							cliente.appendFile(CtsArmado.archivosalidaMFDES+"\'",in);
							reply = cliente.getReplyCode();
							System.out.println("reply sube normal: " + reply);
							System.out.println("Archivo : " + archivo);
							System.out.println("in: " + in);
						}
						reply = cliente.getReplyCode();
						System.out.println("reply desp de enviar: " + reply);
						if (reply == 250 )
						{
							in.close();
							cliente.logout();
							cliente.disconnect();	
							System.out.println("Archivo FTP enviado correctamente");
							String st="Archivo enviado correctamente";
							JOptionPane.showMessageDialog(null,st);
							return true;
						} else {
							String st="El Archivo no se ha podido transmitir\nIntenta de nuevo en 2 minutos";
							JOptionPane.showMessageDialog(null,st);
						}
					} else
					{
						String st="El Archivo no se ha podido enviar \n Esta siendo utilizado por azul";
						JOptionPane.showMessageDialog(null,st);
					}


				}else
				{
					String st="User o Password Invalido";
					JOptionPane.showMessageDialog(null,st);
				} // fin else 230

			} else
			{
				String st="Conectese a la Red";
				JOptionPane.showMessageDialog(null,st);
			} // fin del else 220
			return false;
		}catch(FileNotFoundException ex){
			//   		System.out.println("No se pudo encontrar el archivo " + conf.getArchivoSalida());
			//	ex.printStackTrace();
			return false;				
		}catch(Exception e){
			//  System.out.println("Ocurrio una excepción en la clase enviaArchivoFTPMainframe");
			//	e.printStackTrace();
			String st="Esta desconectado de la red \n        Conectese a la Red";
			JOptionPane.showMessageDialog(null, st);
			return false;
		}
	}

	public void RecibeFTP(String user){
		try{
			FTPClient cliente = new FTPClient();	
			cliente.connect(CtsArmado.FTPIPDES);			
			if(cliente.login(CtsArmado.userFTPPRU,CtsArmado.passFTPPRU)){
				reply = cliente.getReplyCode();
				System.out.println("Codigo: " + reply);
				String remoteFile1 = CtsArmado.Archi6+user+"\'";
				File downloadFile1 = new File(CtsArmado.ArchSal);
				BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));

				cliente.retrieveFile(remoteFile1, outputStream1);

				outputStream1.close();

				cliente.logout();

				cliente.disconnect();	

				System.out.println("Archivo FTP descargado correctamente");
			}else{
				System.out.println("No se pudo realizar el login al servidor FTP el Usuario o Paswword son incorrectos");

				cliente.disconnect();    

			}		
		}
		catch(Exception e){//   		
			//	e.printStackTrace();

		}
	}
}
