package principal;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;

public class EstatusFTP {

	private String user;
	private String Arch;
	private int reply;
	boolean valida=false;
	int cont = 0;
	public EstatusFTP(){		
	}

	public EstatusFTP(String Arch,String user){
		this.user=user;
		this.Arch=Arch;
	}


	public String call(){
		String resp="Procesando";

		try{
			do{

				FTPClient cliente = new FTPClient();		
				cliente.connect(CtsArmado.FTPIPDES);
				reply = cliente.getReplyCode();
				System.out.println("reply connect status: " + reply);
				System.out.println("Arch: " + Arch);
				if (reply == 220) {
					if(cliente.login(CtsArmado.userFTPPRU,CtsArmado.passFTPPRU)){
						String remoteFile1 = CtsArmado.Archi1+user+"\'"; // Certificado
						String remoteFile2 = CtsArmado.Archi2+user+"\'"; // car cliente
						String remoteFile3 = CtsArmado.Archi3+user+"\'"; // Registro
						String remoteFile4 = CtsArmado.Archi4+user+"\'"; // Endosos
						String remoteFile5 = CtsArmado.Archi5+user+"\'"; // car agente
						String remoteFile6 = CtsArmado.Archi6+user+"\'"; // reg endoso
						String remoteFile8 = CtsArmado.Archi8+user+"\'"; // Car AP
						String remoteFile9 = CtsArmado.Archi9+user+"\'"; // LAI
						String remoteFile7 = CtsArmado.Archi7+user+"\'";
						String remoteFile10 = CtsArmado.Archi10+user+"\'"; // LAI
						String remoteFile11 = CtsArmado.Archi11+user+"\'"; // AP Agen




						File downloadFile1 = new File(CtsArmado.ArchSal1);
						BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
						cliente.retrieveFile(remoteFile1, outputStream1);

						File downloadFile2 = new File(CtsArmado.ArchSal2);
						BufferedOutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
						cliente.retrieveFile(remoteFile2, outputStream2);

						
						File downloadFile3 = new File(CtsArmado.ArchSal3);
						BufferedOutputStream outputStream3 = new BufferedOutputStream(new FileOutputStream(downloadFile3));
						cliente.retrieveFile(remoteFile3, outputStream3);

						File downloadFile4 = new File(CtsArmado.ArchSal4);
						BufferedOutputStream outputStream4 = new BufferedOutputStream(new FileOutputStream(downloadFile4));
						cliente.retrieveFile(remoteFile4, outputStream4);

						File downloadFile5 = new File(CtsArmado.ArchSal5);
						BufferedOutputStream outputStream5 = new BufferedOutputStream(new FileOutputStream(downloadFile5));
						cliente.retrieveFile(remoteFile5, outputStream5);

						File downloadFile6 = new File(CtsArmado.ArchSal6);
						BufferedOutputStream outputStream6 = new BufferedOutputStream(new FileOutputStream(downloadFile6));
						cliente.retrieveFile(remoteFile6, outputStream6);

						File downloadFile7 = new File(CtsArmado.ArchSal);
						BufferedOutputStream outputStream7 = new BufferedOutputStream(new FileOutputStream(downloadFile7));
						cliente.retrieveFile(remoteFile7, outputStream7);

						File downloadFile8 = new File(CtsArmado.ArchSal8);
						BufferedOutputStream outputStream8 = new BufferedOutputStream(new FileOutputStream(downloadFile8));
						cliente.retrieveFile(remoteFile8, outputStream8);

						File downloadFile9 = new File(CtsArmado.ArchSal9);
						BufferedOutputStream outputStream9 = new BufferedOutputStream(new FileOutputStream(downloadFile9));
						cliente.retrieveFile(remoteFile9, outputStream9);
						
						File downloadFile10 = new File(CtsArmado.ArchSal10);
						BufferedOutputStream outputStream10 = new BufferedOutputStream(new FileOutputStream(downloadFile10));
						cliente.retrieveFile(remoteFile10, outputStream10);
						
						File downloadFile11 = new File(CtsArmado.ArchSal11);
						BufferedOutputStream outputStream11 = new BufferedOutputStream(new FileOutputStream(downloadFile11));
						cliente.retrieveFile(remoteFile11, outputStream11);

						reply =  cliente.getReplyCode();
						outputStream1.close();
						outputStream2.close();
						outputStream3.close();
						outputStream4.close();
						outputStream5.close();
						outputStream6.close();
						outputStream7.close();
						outputStream8.close();
						outputStream9.close();
						outputStream10.close();
						outputStream11.close();

						cliente.logout();
						cliente.disconnect();	

						//ini

						String sFichero = CtsArmado.ArchSal;
						String sFichero1 = CtsArmado.ArchSal1;
						String sFichero2 = CtsArmado.ArchSal2;
						String sFichero3 = CtsArmado.ArchSal3;
						String sFichero4 = CtsArmado.ArchSal4;
						String sFichero5 = CtsArmado.ArchSal5;
						String sFichero6 = CtsArmado.ArchSal6;
						String sFichero8 = CtsArmado.ArchSal8;
						String sFichero9 = CtsArmado.ArchSal9;
						String sFichero10 = CtsArmado.ArchSal10;
						String sFichero11 = CtsArmado.ArchSal11;


						File fichero = new File(sFichero);
						File fichero1 = new File(sFichero1);
						File fichero2 = new File(sFichero2);
						File fichero3 = new File(sFichero3);
						File fichero4 = new File(sFichero4);
						File fichero5 = new File(sFichero5);
						File fichero6 = new File(sFichero6);
						File fichero8 = new File(sFichero8);
						File fichero9 = new File(sFichero9);
						File fichero10 = new File(sFichero10);
						File fichero11 = new File(sFichero11);

						System.out.println(fichero1.length());
						cont ++;  
						if((fichero1.length() >0 && fichero.length() > 0) || (fichero9.length() >0 && fichero.length() > 0)){
							valida = true;
							break;
						} 
						System.out.println(fichero2.length());
						cont ++;
						if(fichero2.length() >0 && fichero.length() > 0){
							valida = true;
							break;
						}
						System.out.println(fichero3.length());
						cont ++;
						if(fichero3.length() >0 && fichero.length() > 0){
							valida = true;
							break;
						}
						System.out.println(fichero4.length() );
						cont ++;
						if(fichero4.length() >0 && fichero.length() > 0){
							valida = true;
							break;
						}
						System.out.println(fichero5.length());
						cont ++;
						if(fichero5.length() >0 && fichero.length() > 0){
							valida = true;
							break;
						}
						System.out.println(fichero6.length());
						cont ++;
						if(fichero6.length() >0 && fichero.length() > 0){
							valida = true;
							break;
						}
						System.out.println(fichero8.length());
						cont ++;
						if(fichero8.length() >0 && fichero.length() > 0){
							valida = true;
							break;
						}
						System.out.println(fichero9.length());
						cont ++;
						if(fichero9.length() >0 && fichero.length() > 0){
							valida = true;
							break;
						}	
						
						System.out.println("Endoso Mov:" + fichero10.length());
						cont ++;
						if(fichero10.length() >0){
							valida = true;
							break;
						}			    
					
						System.out.println("Endoso Mov:" + fichero11.length());
						cont ++;
						if(fichero11.length() >0){
							valida = true;
							break;
						}	
		

					//fin

					
				}   	//termina if cliente login
			} else {
				if (Arch.equals("'PND.EBAZ2563.")) {
					resp = "Sin Conexión";
					String st="     Conectese a la Red";
					JOptionPane.showMessageDialog(null,st);
					reply = cliente.getReplyCode();
					System.out.println("reply connect status sin coneccion: " + reply);

				}

			}

			}while(valida == false);

			switch (reply) {
			case 550:
				resp="Procesando";
				break;
			case 450:
				resp="Terminado";
				break;
			case 250:
				resp="Terminado";
				break;
			default:
				resp="Procesando";
				break; 
			}
			
			return resp;
		}catch(Exception e){

			if (Arch.equals("'PND.EBAZ2563.")) {
				resp = "Sin Conexión";
				String st="     Conectese a la Red";
				JOptionPane.showMessageDialog(null,st);
				System.out.println("reply connect status sin coneccion: " + reply);

				System.out.println("Arch: " + Arch);
			}
			
			return resp;
			
		}
	}

	public void armadoDeArchivos(){
		try{
			String line;
			String poliza = "";
			String polizaAnt = "";
			File f = new File(CtsArmado.ArchSal);
			BufferedReader br = new BufferedReader(new FileReader(f));				
			PrintWriter pw = null;
			FileWriter archC =  null;
			while((line = br.readLine()) != null){
				poliza = line.substring(38, 46);
				if(polizaAnt.equals(poliza)){
					pw.println(line);	
					
				}else{
					if(archC!=null)
						archC.close();
					polizaAnt = poliza;		
					File dDir = new File(CtsArmado.ArchSalControl + "\\" + poliza + "\\");
					dDir.mkdir();
					File eDir = new File(CtsArmado.ArchSalControl + "\\" + poliza + "\\" + "Control "+ poliza + ".txt");
					if(eDir.exists()){        				
						borrarArc(CtsArmado.ArchSalControl + "\\" +  poliza + "\\" + "Control "+ poliza + ".txt");				 			
					}
					archC = new FileWriter(CtsArmado.ArchSalControl + "\\" +  poliza + "\\" + "Control "+ poliza + ".txt");
					pw = new PrintWriter(archC);
					pw.println(line);				 		
				}
			}
			pw.close();
		}catch(Exception ignored){}
	}

	private void borrarArc(String dir){
		File fs = new File(dir);
		if(fs.delete()){
			System.out.println("Archivo borrado " + dir);				
		}
		
	}		


}