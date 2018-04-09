package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

// Referenced classes of package principal:
//            Union, MergePDF

public class Encarpetado extends JFrame
    implements ActionListener, FocusListener, ChangeListener
{

    private static final long serialVersionUID = 0x9e0ecbf9d1d99926L;
    private JLabel labelArmado;
    private JLabel labelPath;
    private JLabel labelPathPol;
    private JLabel labelPath2;
    private JLabel labelPath3;
    private JLabel labelPath4;
    private JLabel labelCond;
    private JTextField textPath;
    private JTextField textPath2;
    private JTextField textCond;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JButton botonCond;
    private JPanel panel1;
    private JLabel labelCaratula;
    private JLabel labelCert;
    private JLabel labelTarj;
    private JLabel labelReg;
    private JLabel labelEndPol;
    private JLabel labelEndAse;
    private JLabel labelCarpeta;
    private JLabel labelFactura;
    private JCheckBox ChkCon;
    private JCheckBox ChkConCer;
    private JCheckBox ChkConTar;
    private JCheckBox ChkCon3;
    private JCheckBox ChkCon4;
    private JCheckBox ChkCon5;
    private JCheckBox ChkCon6;
    private JCheckBox ChkCon7;
    private JCheckBox ChkCon8;
    private JRadioButton botonAseg;
    private JRadioButton botonAgen;
    private String certIni;
    private JComboBox cbcarpeta;
    private JComboBox cbcarpetaSub;
    private String pathRaiz;
    private Map<String, String> cargaLista;	
    
    public Encarpetado()
    {
        certIni = "";
        inicializar();
    }

    public void inicializar()
    {
        setName("Encarpetar");
        setSize(520, 400);
        setTitle("Encarpetar PDF's");
        setLayout(null);
        setDefaultCloseOperation(1);
        add(getPanel1());
        getPanel1().add(getTextPath(), getTextPath().getName());
        getPanel1().add(getLabelArmado(), getLabelArmado().getName());
        getPanel1().add(getTextPath2(), getTextPath2().getName());
        getPanel1().add(getLabelPath(), getLabelPath().getName());
        getPanel1().add(getLabelPathPol(), getLabelPathPol().getName());
        getPanel1().add(getLabelPath2(), getLabelPath2().getName());
        getPanel1().add(getLabelPath3(), getLabelPath3().getName());
        getPanel1().add(getBotonAceptar(), getBotonAceptar().getName());
        getPanel1().add(getBotonCancelar(), getBotonCancelar().getName());
        getPanel1().add(getLabelCond(), getLabelCond().getName());
        getPanel1().add(getTextCond(), getTextCond().getName());
        getPanel1().add(getBotonCond(), getBotonCond().getName());
        getPanel1().add(getLabelPath4(), getLabelPath4().getName());
        add(getPanel1(), getPanel1().getName());
        getPanel1().add(getLabelCertificados(), getLabelCertificados().getName());
        getPanel1().add(getLabelTarjetas(), getLabelTarjetas().getName());
        getPanel1().add(getLabelCarpeta(), getLabelCarpeta().getName());
        getPanel1().add(getLabelFacturacion(), getLabelFacturacion().getName());
        getPanel1().add(getChkCertif(), getChkCertif().getName());
        getPanel1().add(getChkTarjs(), getChkTarjs().getName());
        getPanel1().add(getChkConRegAse(), getChkConRegAse().getName());
        getPanel1().add(getChkCon6(), getChkCon6().getName());
        getPanel1().add(getChkConFact(), getChkConFact().getName());
        getPanel1().add(getChkMasivo(), getChkMasivo().getName());
        getPanel1().add(getCbcarpeta(), getCbcarpeta().getName());
        getPanel1().add(getCbcarpetaSub(), getCbcarpetaSub().getName());
        getLabelArmado().setVisible(true);
        getBotonAceptar().setVisible(true);
        getChkEndosoPolizaOk().setVisible(true);
        getChkCertif().setVisible(true);
        getChkTarjs().setVisible(true);
        getChkRegistro().setVisible(true);
        getChkEndosoPoliza().setVisible(true);
        getChkConRegAse().setVisible(false);
        getChkCon6().setVisible(true);
        getBotonCancelar().setVisible(true);
        getBotonCarCte().setVisible(false);
        getBotonCarAge().setVisible(false);
        getBotonCond().setVisible(true);
        getLabelPath().setVisible(true);
        getLabelPathPol().setVisible(false);
        getPanel1().setVisible(true);
        getLabelCaratula().setVisible(true);
        getLabelCertificados().setVisible(true);
        getLabelTarjetas().setVisible(true);
        getLabelRegistro().setVisible(true);
        getLabelEndPol().setVisible(true);
        getLabelEndAse().setVisible(false);
        getLabelCarpeta().setVisible(true);
        getLabelFacturacion().setVisible(true);
        getLabelPath4().setVisible(false);
        getLabelPath3().setVisible(false);
        getChkCon6().setVisible(false);
        getLabelCarpeta().setVisible(false);
        getBotonCond().setVisible(false);
        getTextCond().setVisible(false);
        getLabelCond().setVisible(false);
        getTextPath2().setVisible(false);
        getTextPath().setVisible(false);
        getCbcarpeta().setVisible(true);
        getCbcarpetaSub().setVisible(false);
        getCbcarpetaSub().setEnabled(false);
        getChkRegistro().setEnabled(true);
        getChkEndosoPoliza().setEnabled(true);
        getChkEndosoPolizaOk().setEnabled(true);
        getChkCon6().setEnabled(false);
        getChkMasivo().setVisible(false);
        getChkMasivo().setSelected(true);
        getBotonAceptar().addActionListener(this);
        getBotonCancelar().addActionListener(this);
        getBotonCarAge().addActionListener(this);
        getBotonCarCte().addActionListener(this);
        getBotonCond().addActionListener(this);
        getChkEndosoPolizaOk().addActionListener(this);
        getChkCertif().addActionListener(this);
        getChkTarjs().addActionListener(this);
        getChkRegistro().addActionListener(this);
        getChkEndosoPoliza().addActionListener(this);
        getChkConRegAse().addActionListener(this);
        getChkCon6().addActionListener(this);
        getChkConFact().addActionListener(this);
        getChkMasivo().addActionListener(this);
        
        getCbcarpeta().addActionListener(this);
        llenarComboCarpeta();
    }

    JLabel getLabelArmado()
    {
        if(labelArmado == null)
        {
            try
            {
                labelArmado = new JLabel();
                labelArmado.setName("LabelArmado");
                Font font = new Font("Arial Rounded MT", 1, 22);
                labelArmado.setFont(font);
                labelArmado.setText("ENCARPETADO DE DOCUMENTOS");
                labelArmado.setForeground(new Color(255, 140, 0));
                labelArmado.setBounds(70, 15, 400, 50);
                labelArmado.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return labelArmado;
    }

    JPanel getPanel1()
    {
        if(panel1 == null)
        {
            try
            {
                panel1 = new JPanel();
                panel1.setName("panel1");
                panel1.setBounds(0, 0, 530, 470);
                panel1.setLayout(null);
                panel1.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return panel1;
    }

    JComboBox getCbcarpeta()
    {
        if(cbcarpeta == null)
        {
            try
            {
                cbcarpeta = new JComboBox();
                cbcarpeta.setName("cbcarpeta");
                cbcarpeta.setSize(200, 23);
                cbcarpeta.setLocation(10, 110);
                Font font1 = new Font("Courier New", 1, 12);
                cbcarpeta.setFont(font1);
                cbcarpeta.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return cbcarpeta;
    }

    JComboBox getCbcarpetaSub()
    {
        if(cbcarpetaSub == null)
        {
            try
            {
                cbcarpetaSub = new JComboBox();
                cbcarpetaSub.setName("cbcarpetaSub");
                cbcarpetaSub.setSize(200, 23);
                cbcarpetaSub.setLocation(250, 110);
                Font font1 = new Font("Courier New", 1, 12);
                cbcarpetaSub.setFont(font1);
                cbcarpetaSub.setVisible(false);
            }
            catch(Throwable throwable) { }
        }
        return cbcarpetaSub;
    }

    JTextField getTextPath()
    {
        if(textPath == null)
        {
            try
            {
                textPath = new JTextField();
                textPath.setName("textPath");
                textPath.setSize(145, 23);
                textPath.setLocation(10, 110);
                Font font1 = new Font("Courier New", 1, 12);
                textPath.setFont(font1);
                textPath.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return textPath;
    }

    JLabel getLabelPath()
    {
        if(labelPath == null)
        {
            try
            {
                labelPath = new JLabel();
                labelPath.setName("labelPath");
                labelPath.setText("Seleccione el Negocio");
                labelPath.setSize(300, 23);
                labelPath.setLocation(10, 80);
                labelPath.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return labelPath;
    }

    JLabel getLabelPathPol()
    {
        if(labelPathPol == null)
        {
            try
            {
                labelPathPol = new JLabel();
                labelPathPol.setName("labelPathPol");
                labelPathPol.setText("Seleccione la Poliza");
                labelPathPol.setSize(300, 23);
                labelPathPol.setLocation(250, 80);
                labelPathPol.setVisible(false);
            }
            catch(Throwable throwable) { }
        }
        return labelPathPol;
    }

    JLabel getLabelPath2()
    {
        if(labelPath2 == null)
        {
            try
            {
                labelPath2 = new JLabel();
                labelPath2.setName("labelPath2");
                labelPath2.setText("Carpetas a Generar :");
                labelPath2.setSize(300, 23);
                labelPath2.setLocation(10, 150);
                labelPath2.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return labelPath2;
    }

    JCheckBox getChkEndosoPolizaOk()
    {
        if(ChkCon == null)
        {
            try
            {
                ChkCon = new JCheckBox();
                ChkCon.setName("ChkCon");
                ChkCon.setBounds(10, 210, 20, 25);
                ChkCon.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return ChkCon;
    }

    JLabel getLabelCaratula()
    {
        if(labelCaratula == null)
        {
            try
            {
                labelCaratula = new JLabel();
                labelCaratula.setName("labelCaratula");
                labelCaratula.setText("Caratula");
                labelCaratula.setBounds(30, 210, 200, 25);
                labelCaratula.setVisible(false);
            }
            catch(Throwable throwable) { }
        }
        return labelCaratula;
    }

    JRadioButton getBotonCarCte()
    {
        if(botonAseg == null)
        {
            try
            {
                botonAseg = new JRadioButton();
                botonAseg.setName("BotonAseg");
                botonAseg.setText("Asegurado");
                botonAseg.setBounds(220, 210, 100, 25);
                botonAseg.setVisible(false);
                botonAseg.setEnabled(false);
            }
            catch(Throwable throwable) { }
        }
        return botonAseg;
    }

    JRadioButton getBotonCarAge()
    {
        if(botonAgen == null)
        {
            try
            {
                botonAgen = new JRadioButton();
                botonAgen.setName("BotonAgen");
                botonAgen.setText("Agente");
                botonAgen.setBounds(320, 210, 100, 25);
                botonAgen.setVisible(false);
                botonAgen.setEnabled(false);
            }
            catch(Throwable throwable) { }
        }
        return botonAgen;
    }

    JCheckBox getChkCertif()
    {
        if(ChkConCer == null)
        {
            try
            {
                ChkConCer = new JCheckBox();
                ChkConCer.setName("ChkConCer");
                ChkConCer.setBounds(10, 170, 20, 25);
                ChkConCer.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return ChkConCer;
    }

    JLabel getLabelCertificados()
    {
        if(labelCert == null)
        {
            try
            {
                labelCert = new JLabel();
                labelCert.setName("labelCert");
                labelCert.setText("Certificados");
                labelCert.setBounds(30, 170, 200, 25);
                labelCert.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return labelCert;
    }

    JCheckBox getChkTarjs()
    {
        if(ChkConTar == null)
        {
            try
            {
                ChkConTar = new JCheckBox();
                ChkConTar.setName("ChkConTar");
                ChkConTar.setBounds(10, 190, 20, 25);
                ChkConTar.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return ChkConTar;
    }

    JLabel getLabelTarjetas()
    {
        if(labelTarj == null)
        {
            try
            {
                labelTarj = new JLabel();
                labelTarj.setName("labelTarj");
                labelTarj.setText("Tarjetas");
                labelTarj.setBounds(30, 190, 200, 25);
                labelTarj.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return labelTarj;
    }

    JCheckBox getChkRegistro()
    {
        if(ChkCon3 == null)
        {
            try
            {
                ChkCon3 = new JCheckBox();
                ChkCon3.setName("ChkCon3");
                ChkCon3.setBounds(10, 230, 20, 25);
                ChkCon3.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return ChkCon3;
    }

    JLabel getLabelRegistro()
    {
        if(labelReg == null)
        {
            try
            {
                labelReg = new JLabel();
                labelReg.setName("labelReg");
                labelReg.setText("Registro Asegurados");
                labelReg.setBounds(30, 230, 200, 25);
                labelReg.setVisible(true);
            }
            catch(Throwable throwable) { }
        }
        return labelReg;
    }

    protected JCheckBox getChkEndosoPoliza()
    {
        if(ChkCon4 == null)
        {
            try
            {
                ChkCon4 = new JCheckBox();
                ChkCon4.setName("ChkCon4");
                ChkCon4.setBounds(10, 250, 20, 25);
                ChkCon4.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return ChkCon4;
    }

    protected JLabel getLabelEndPol()
    {
        if(labelEndPol == null)
        {
            try
            {
                labelEndPol = new JLabel();
                labelEndPol.setName("labelEndPol");
                labelEndPol.setText("Endosos");
                labelEndPol.setBounds(30, 250, 200, 25);
                labelEndPol.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return labelEndPol;
    }

    protected JCheckBox getChkConRegAse()
    {
        if(ChkCon5 == null)
        {
            try
            {
                ChkCon5 = new JCheckBox();
                ChkCon5.setName("ChkCon5");
                ChkCon5.setBounds(10, 270, 20, 25);
                ChkCon5.setVisible(false);
                ChkCon5.setEnabled(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return ChkCon5;
    }

    protected JLabel getLabelEndAse()
    {
        if(labelEndAse == null)
        {
            try
            {
                labelEndAse = new JLabel();
                labelEndAse.setName("labelEndAse");
                labelEndAse.setText("Endosos Asegurados.");
                labelEndAse.setBounds(30, 270, 200, 25);
                labelEndAse.setVisible(false);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return labelEndAse;
    }

    protected JCheckBox getChkConFact()
    {
        if(ChkCon7 == null)
        {
            try
            {
                ChkCon7 = new JCheckBox();
                ChkCon7.setName("ChkCon7");
                ChkCon7.setBounds(10, 210, 20, 25);
                ChkCon7.setVisible(true);
                ChkCon7.setEnabled(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return ChkCon7;
    }

    protected JCheckBox getChkMasivo()
    {
        if(ChkCon8 == null)
        {
            try
            {
                ChkCon8 = new JCheckBox();
                ChkCon8.setName("ChkCon8");
                ChkCon8.setBounds(180, 80, 20, 25);
                ChkCon8.setVisible(true);
                ChkCon8.setEnabled(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return ChkCon8;
    }

    protected JLabel getLabelFacturacion()
    {
        if(labelFactura == null)
        {
            try
            {
                labelFactura = new JLabel();
                labelFactura.setName("labelFactura");
                labelFactura.setText("Facturacion");
                labelFactura.setBounds(30, 210, 200, 25);
                labelFactura.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return labelFactura;
    }

    protected JLabel getLabelPath3()
    {
        if(labelPath3 == null)
        {
            try
            {
                labelPath3 = new JLabel();
                labelPath3.setName("labelPath3");
                labelPath3.setText("Estructura:");
                labelPath3.setSize(320, 23);
                labelPath3.setLocation(10, 310);
                labelPath3.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return labelPath3;
    }

    protected JCheckBox getChkCon6()
    {
        if(ChkCon6 == null)
        {
            try
            {
                ChkCon6 = new JCheckBox();
                ChkCon6.setName("ChkCon6");
                ChkCon6.setBounds(10, 330, 20, 25);
                ChkCon6.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return ChkCon6;
    }

    protected JLabel getLabelCarpeta()
    {
        if(labelCarpeta == null)
        {
            try
            {
                labelCarpeta = new JLabel();
                labelCarpeta.setName("labelCarpeta");
                labelCarpeta.setText("Genera Carpeta para Cada Asegurado");
                labelCarpeta.setBounds(30, 330, 300, 25);
                labelCarpeta.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return labelCarpeta;
    }

    protected JLabel getLabelCond()
    {
        if(labelCond == null)
        {
            try
            {
                labelCond = new JLabel();
                labelCond.setName("labelCond");
                labelCond.setText("Seleccione del Repositorio el Archivo de Control TXT de la Poliza a Encarpetar:");
                labelCond.setSize(500, 23);
                labelCond.setLocation(10, 370);
                labelCond.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return labelCond;
    }

    protected JTextField getTextCond()
    {
        if(textCond == null)
        {
            try
            {
                textCond = new JTextField();
                textCond.setName("textCond");
                textCond.setLocation(10, 400);
                textCond.setSize(450, 23);
                textCond.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return textCond;
    }

    protected JButton getBotonCond()
    {
        if(botonCond == null)
        {
            try
            {
                botonCond = new JButton();
                botonCond.setName("botonCond");
                botonCond.setText("...");
                botonCond.setBounds(460, 400, 23, 23);
                botonCond.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return botonCond;
    }

    protected JButton getBotonAceptar()
    {
        if(botonAceptar == null)
        {
            try
            {
                botonAceptar = new JButton();
                botonAceptar.setName("BotonAceptar");
                botonAceptar.setText("Aceptar");
                botonAceptar.setBounds(110, 300, 100, 25);
                botonAceptar.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return botonAceptar;
    }

    protected JButton getBotonCancelar()
    {
        if(botonCancelar == null)
        {
            try
            {
                botonCancelar = new JButton();
                botonCancelar.setName("BotonCancelar");
                botonCancelar.setText("Salir");
                botonCancelar.setBounds(240, 300, 100, 25);
                botonCancelar.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return botonCancelar;
    }

    protected JLabel getLabelPath4()
    {
        if(labelPath4 == null)
        {
            try
            {
                labelPath4 = new JLabel();
                labelPath4.setName("labelPath4");
                labelPath4.setText("Numero de Poliza: (8 Caracts)");
                labelPath4.setSize(300, 23);
                labelPath4.setLocation(250, 80);
                labelPath4.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return labelPath4;
    }

    protected JTextField getTextPath2()
    {
        if(textPath2 == null)
        {
            try
            {
                textPath2 = new JTextField();
                textPath2.setName("textPath2");
                textPath2.setSize(63, 23);
                textPath2.setLocation(250, 110);
                Font font1 = new Font("Courier New", 1, 12);
                textPath2.setFont(font1);
                textPath2.setVisible(true);
            }
            catch(Throwable ivjExc)
            {
                ivjExc.printStackTrace();
            }
        }
        return textPath2;
    }

    public String selecArchivo()
    {
        JFileChooser filechoose = new JFileChooser("C:\\");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("TXT", new String[] {
            "txt", "Txt", "PDF", "pdf", "Pdf"
        });
        filechoose.setFileFilter(filtro);
        filechoose.showOpenDialog(this);
        File file = filechoose.getSelectedFile();
        if(file.exists())
        {
            return file.getAbsolutePath();
        } else
        {
            System.out.println("No se encontro el Archivo");
            return null;
        }
    }

    public void lecturaPDF(String file, boolean carpeta, String poliza)
    {
        File f = null;
        BufferedReader br = null;       
        String certificado = "";
        String nombreTar = "";
        String pathMake = "";
        String arcOrig = "";
        String arcSal = "";
        String cert = "";
        try
        {
            f = new File(file);
            System.out.println((new StringBuilder("file: ")).append(f).toString());
            br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine()) != null) 
            {
                nombreTar = line.substring(0, 30).trim();
                nombreTar = nombreTar.replaceAll("#", "Ñ");
                while(nombreTar.lastIndexOf(".") == nombreTar.length() - 1)
                {
                    nombreTar = nombreTar.substring(0, nombreTar.length() - 1).trim();
                }               
                System.out.println((new StringBuilder("poliza: ")).append(poliza).toString());
            
                certificado = line.substring(120, 128);               
                System.out.println((new StringBuilder("certificado: ")).append(certificado).toString());
                cert = certificado.substring(0, certificado.length() - 1);
                System.out.println((new StringBuilder("cert: ")).append(cert).toString());
                if(cargaLista.get(cert)!=null){
                	if(!cert.equals(certIni)){
                		certIni = cert;                    
                  		File eDir = new File((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Certificados y Tarjetas\\").toString());
                		if(!eDir.exists());
//                    		primerBorrado = false;                    
                    	pathMake = (new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Certificados y Tarjetas\\").append(certificado).toString();
                    	File dir = new File(pathMake);
                    	dir.mkdirs();
                    	lecturaCertificado(certificado, poliza, nombreTar, pathMake);
                    	 ValidaCarpeta(poliza, certificado,pathMake);
                    	if(getChkConFact().isSelected())
                    	{
                    		String pathFact = (new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Facturacion\\").toString();
                    		File dirFac = new File(pathFact);
                    		dirFac.mkdirs();
                    	} 
                    	
                	}
                	if(getChkTarjs().isSelected()){                    	
                		arcOrig = (new StringBuilder("C:\\Armado Digital SIGMA\\Tarjetas\\")).append(poliza).append("\\").append(certificado).append("_").append(poliza).append(".pdf").toString();
                		System.out.println((new StringBuilder("arcOrig: ")).append(arcOrig).toString());
                		arcSal = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(pathMake))).append("\\").append(poliza).append("_").append(certificado).append("_Tarj_").append(nombreTar).toString().trim()))).append(".pdf").toString();
                		System.out.println((new StringBuilder("arcSal: ")).append(arcSal).toString());
                		FileCopy(arcOrig, arcSal);                    		
                	} 
                	
                
                }
            }
           
            Union un = new Union();
            un.creaFusion((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Certificados y Tarjetas").toString(), "", false);
   //         unifica(poliza);            
        }
        	catch(Exception e)
        {
            System.out.println("Error en lectura PDF");
        }
    }

    private void ValidaCarpeta(String poliza, String certificado, String pathMake) {
		File eDir = new File((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Certificados y Tarjetas\\").toString());
    	if (eDir.isDirectory()) {		
			String[] ficheros = eDir.list();
			String cert = certificado.substring(0, certificado.length() - 1);
			for (int x=0;x<ficheros.length;x++){
				File f2 = new File(eDir + "\\" +ficheros[x]);
				if(!f2.isDirectory()){
					if(ficheros[x].indexOf(cert)>= 0){
            		Object arcOrig = (eDir+ "\\" +ficheros[x]);
            		String arcSal = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(pathMake))).append("\\").append(poliza).append("_").append(certificado).append("_Cert2").toString().trim()))).append(".pdf").toString();
            		FileCopy((String) arcOrig, arcSal);
					}
				}
			}
    	}
    }
				
	
			
	private void unifica(String poliza)
    {
        try
        {
            File fr1 = new File((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Registro Asegurados\\").toString());
            String ficheros[] = null;
            if(fr1.isDirectory())
            {
                ficheros = fr1.list();
                List<InputStream> pdfs = new ArrayList<InputStream>();
                for(int x1 = 0; x1 < ficheros.length; x1++)
                {
                	System.out.println("Uniendo Registro: " + x1);
                    if(ficheros[x1].indexOf("Registro") >= 0)
                    {
                        pdfs.add(new FileInputStream((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Registro Asegurados\\").append(ficheros[x1].toString()).toString()));
                    }
                }

                java.io.OutputStream output = new FileOutputStream((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Registro Asegurados\\").append("Registro_Asegurados_").append(poliza).append(".pdf").toString());
                MergePDF.concatPDFs(pdfs, output);
            }
            for(int x1 = 0; x1 < ficheros.length; x1++)
            {
                File fd = new File((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Registro Asegurados\\").append(ficheros[x1].toString()).toString());
                fd.delete();
            }

        }
        catch(Exception exception) { }
    }

    private void FileCopy(String sourceFile, String destinationFile)
    {
       
        File fichero = new File(sourceFile);
        File fichero2 = new File(destinationFile);
        boolean success = fichero.renameTo(fichero2);
        if(!success)
        {
            System.out.println("Error intentando cambiar el nombre de fichero");
        }

    }

    private void lecturaCertificado(String certificado, String poliza, String nombreTar, String pathMake)
    {
        File fr = new File((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Certificados y Tarjetas\\").toString());
        System.out.println((new StringBuilder("Vine a lecturaCertificado\n")).append(fr).toString());
        if(fr.isDirectory())
        {
         
            String cert = certificado.substring(0, certificado.length() - 1);
            String arcOrig = (new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(poliza).append("\\Certificados y Tarjetas\\").append(cargaLista.get(cert)).toString();
            String arcSal = (new StringBuilder(String.valueOf(pathMake))).append("\\").append(poliza).append("_").append(certificado).append("_Cert_").append(nombreTar.trim()).append(".pdf").toString();
            FileCopy(arcOrig, arcSal);
            borrarArc(arcOrig);
        }
    }

    private void borrarArc(String dir)
    {
        File fs = new File(dir);
        if(fs.isDirectory())
        {
            String ficheros[] = fs.list();
            for(int x = 0; x < ficheros.length; x++)
            {
                borrarArc((new StringBuilder(String.valueOf(dir))).append("\\").append(ficheros[x]).toString());
            }

            if(fs.delete())
            {
                System.out.println((new StringBuilder("Carpeta borrada ")).append(dir).toString());
            }
        } else
        if(fs.delete())
        {
            System.out.println((new StringBuilder("Archivo borrado ")).append(dir).toString());
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == getBotonAceptar())
        {
            if(getChkMasivo().isSelected())
            {
                String st = "Encarpetamiento por Pool iniciado... \n Presione Aceptar para continuar";
                JOptionPane.showMessageDialog(null, st);
//jhp
                pathRaiz = (new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").toString();
                File fr = new File(pathRaiz);	
    			if (fr.isDirectory()) {		
    				String[] polizas = fr.list();		
    				for (int x=0;x<polizas.length;x++){   		
        			
                if(getChkCertif().isSelected() || getChkTarjs().isSelected())
                {
                    if(getChkCertif().isSelected())
                    {
                    	File fp = new File(pathRaiz+"\\"+polizas[x]+"\\Certificados y Tarjetas");
                    	if(fp.exists()){
                    	String[] certificados = fp.list();
                    	archivosExistentes(certificados);
                        lecturaPDF((new StringBuilder("C:\\Armado Digital SIGMA\\Tarjetas\\")).append(polizas[x]).append("\\Control ").append(polizas[x]).append(".txt").toString(), getChkCertif().isSelected(), polizas[x]);
                        certIni = "";
                    	}
                    } else
                    {
                        String pr = (new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(getCbcarpetaSub().getSelectedItem().toString()).append("\\Certificados y Tarjetas\\").toString();
                        System.out.println((new StringBuilder("pr: ")).append(pr).toString());
                        borrarArc(pr);
                        File dir = new File(pr);
                        dir.mkdirs();
                        String arcOrig = (new StringBuilder("C:\\Armado Digital SIGMA\\Tarjetas\\")).append(getCbcarpetaSub().getSelectedItem().toString()).append("\\").toString();
                        String arcSal = (new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\")).append(getCbcarpeta().getSelectedItem().toString()).append("\\").append(getCbcarpetaSub().getSelectedItem().toString()).append("\\Certificados y Tarjetas\\").toString();
                        File fo = new File(arcOrig);
                        String ficOrg[] = fo.list();
                        for(int x1 = 0; x1 < ficOrg.length; x1++)
                        {
                            String arcOrig1 = (new StringBuilder(String.valueOf(arcOrig))).append(ficOrg[x1]).toString();
                            String arcSal1 = (new StringBuilder(String.valueOf(arcSal))).append(ficOrg[x1]).toString();
                            FileCopy(arcOrig1, arcSal1);
                        }

                        pr = (new StringBuilder(String.valueOf(arcSal))).append("Control ").append(getCbcarpetaSub().getSelectedItem().toString()).append(".txt").toString();
                        System.out.println((new StringBuilder("pr2: ")).append(pr).toString());
                        borrarArc(pr);
                        
                        
                    }
              //      String poliza = getCbcarpetaSub().getSelectedItem().toString();
                    unifica(polizas[x]);
                } else
                {
                    String sts = "Debe selecionar Certificados o Tarjetas";
                    JOptionPane.showMessageDialog(null, sts);
                }
                
    				}
                    st = "Encarpetamiento Finalizado";
                    JOptionPane.showMessageDialog(null, st);
                    System.out.println("Encarpetamiento Finalizado");
    			}	
            }
            
            
        }
        
        if(e.getSource() == getChkEndosoPolizaOk())  
        {
            if(getChkEndosoPolizaOk().isSelected())
            {
                getBotonCarCte().setVisible(true);
                getBotonCarCte().setEnabled(true);
                getBotonCarCte().setSelected(true);
                getBotonCarAge().setVisible(true);
                getBotonCarAge().setEnabled(true);
                getBotonCarAge().setSelected(true);
            } else
            {
                getBotonCarCte().setVisible(false);
                getBotonCarCte().setEnabled(false);
                getBotonCarAge().setVisible(false);
                getBotonCarAge().setEnabled(false);
                getBotonCarAge().setSelected(false);
            }
        }
        if(e.getSource() == getBotonCancelar())
        {
            setVisible(false);
        }
        if(e.getSource() == getBotonCond())
        {
            getTextCond().setText(selecArchivo());
        }
        if(e.getSource() == getCbcarpeta())
        {
            getCbcarpetaSub().removeAllItems();
            llenarComboCarpetaSub(getCbcarpeta().getSelectedItem().toString());
            getCbcarpetaSub().setEnabled(true);
        }
    }

    public void focusLost(FocusEvent e)
    {
        if(e.getSource() == getTextPath())
        {
            getTextPath().setText(getTextPath().getText().toUpperCase());
        }
    }

    private void llenarComboCarpeta()
    {
        File fr = new File("C:\\Armado Digital SIGMA\\Entregables\\");
        String lista[] = null;
        lista = fr.list();
        for(int i = 0; i < lista.length; i++)
        {
            getCbcarpeta().addItem(lista[i]);
        }

    }

    private void llenarComboCarpetaSub(String item)
    {
        File fr = new File((new StringBuilder("C:\\Armado Digital SIGMA\\Entregables\\\\")).append(item).toString());
        String lista[] = null;
        lista = fr.list();
        for(int i = 0; i < lista.length; i++)
        {
            if(lista[i].indexOf(".txt") <= 0)
            {
                getCbcarpetaSub().addItem(lista[i]);
            }
        }

    }

    public void focusGained(FocusEvent focusevent)
    {
    }

    public void stateChanged(ChangeEvent changeevent)
    {
    }
    
    private void  archivosExistentes(String[] archivos){
		cargaLista = new HashMap<String, String>();
		for(int j=0;j<archivos.length;j++){
			int ind = 0;
			ind = archivos[j].indexOf(".pdf");
			if(ind<29){
			String archivo = archivos[j].substring(ind-7, ind);
			cargaLista.put(archivo, archivos[j]);	
			}else{
				String archivo = archivos[j].substring(ind-8, ind-1);
				cargaLista.put(archivo, archivos[j]);
			}
				
		}
	}
}
