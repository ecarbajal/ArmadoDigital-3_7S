package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.itextpdf.text.DocumentException;

import principal.EnvioFTP;
import principal.Usuarios;

public class Solicitud
extends JFrame
implements ActionListener,
FocusListener,
MouseMotionListener {

	public static void main(String[] args) throws DocumentException {
		Solicitud sl1 = new Solicitud();
		sl1.setUsuario("USERXXX" , "PRUEBA", "1");
		sl1.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	private JLabel labelPath;
    private JLabel labelPath2;
    private JLabel labelPath3;
    private JLabel labelPath4;
    private JLabel labelPath5;
    private JLabel labelPath6;
    private JLabel labelCond;

    private JTextField textPath;
    private JTextField textPath2;
    private JTextField textPath3;
    private JTextField textPath4;
    private JTextField textPath5;
    private JTextField textCond;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JButton botonCond;
    private JButton botonEnviar;
    private JButton botonReset;
    private JPanel panel1;
    private JScrollPane panelArea;
    private JLabel labelCheck;
    private JLabel labelCheck2;
    private JLabel labelCheck3;
    private JLabel labelCheck4;
    private JLabel labelCheck5;
    private JLabel labelCheck6;
    private JLabel labelCheck7;
    private JLabel labelCheck8;
    private JLabel labelCheck9;
    private JCheckBox ChkCon;
    private JCheckBox ChkCon2;
    private JCheckBox ChkCon3;
    private JCheckBox ChkCon4;
    private JCheckBox ChkCon5;
    private JCheckBox ChkCon6;
    private JCheckBox ChkCon7;
    private JCheckBox ChkCon8;
    private JCheckBox ChkCon9;
    public JRadioButton botonSoli;
    private JRadioButton botonAseg;
    private JRadioButton botonAgen;
    private JRadioButton botonEndo;
    private JRadioButton botonCert;
    private JLabel labelArmado;
    private JTextArea txtArchivo;
    private String archivoS = "";
    private String archivoR = "";
    private String user;
    private Map<String, String> users;
    private Map<String, String> cua;
	private Map<String, String> polizas;
	private String cua2;
    public Solicitud() {
        this.inicializar();
    }

    void inicializar() {
        this.users = new HashMap<String, String>();
        Usuarios us = new Usuarios();
        this.users = us.recuperaUser();
        
        this.cua = new HashMap<String, String>();
//        cua cua = new cua();
//        this.cua = cua.recuperacua();
        
        this.polizas = new HashMap<String, String>();
        polizas pol = new polizas();
        this.polizas = pol.recuperaPoliza();
        
        
        this.setName("Solicitud");
        this.setSize(540, 600);
        this.setTitle("Solicitud");
        this.setLayout(null);
        this.setDefaultCloseOperation(1);
        this.add(this.getPanel1());
        this.getPanel1().add((Component)this.getLabelArmado(), this.getLabelArmado().getName());
        this.getPanel1().add((Component)this.getTextPath(), this.getTextPath().getName());
        this.getPanel1().add((Component)this.getTextPath2(), this.getTextPath2().getName());
        this.getPanel1().add((Component)this.getTextPath3(), this.getTextPath3().getName());
        this.getPanel1().add((Component)this.getTextPath4(), this.getTextPath4().getName());
        this.getPanel1().add((Component)this.getTextPath5(), this.getTextPath5().getName());
        this.getPanel1().add((Component)this.getLabelPath(), this.getLabelPath().getName());
        this.getPanel1().add((Component)this.getLabelPath2(), this.getLabelPath2().getName());
        this.getPanel1().add((Component)this.getLabelPath3(), this.getLabelPath3().getName());
        this.getPanel1().add((Component)this.getLabelPath4(), this.getLabelPath4().getName());
        this.getPanel1().add((Component)this.getLabelPath5(), this.getLabelPath5().getName());
        this.getPanel1().add((Component)this.getLabelPath6(), this.getLabelPath6().getName());
        this.getPanel1().add((Component)this.getBotonAgregar(), this.getBotonAgregar().getName());
        this.getPanel1().add((Component)this.getBotonCancelar(), this.getBotonCancelar().getName());
        this.getPanel1().add((Component)this.getLabelCond(), this.getLabelCond().getName());
        this.getPanel1().add((Component)this.getTextCond(), this.getTextCond().getName());
        this.getPanel1().add((Component)this.getBotonCond(), this.getBotonCond().getName());
        this.getPanel1().add((Component)this.getLabelCheck(), this.getLabelCheck().getName());
        this.add((Component)this.getPanel1(), this.getPanel1().getName());
        this.getPanel1().add((Component)this.getLabelCheck2(), this.getLabelCheck2().getName());
        this.getPanel1().add((Component)this.getLabelCheck3(), this.getLabelCheck3().getName());
        this.getPanel1().add((Component)this.getLabelCheck4(), this.getLabelCheck4().getName());
        this.getPanel1().add((Component)this.getLabelCheck5(), this.getLabelCheck5().getName());
        this.getPanel1().add((Component)this.getLabelCheck6(), this.getLabelCheck6().getName());
        this.getPanel1().add((Component)this.getLabelCheck7(), this.getLabelCheck7().getName());
        this.getPanel1().add((Component)this.getLabelCheck8(), this.getLabelCheck8().getName());
        this.getPanel1().add((Component)this.getLabelCheck9(), this.getLabelCheck9().getName());
        this.getPanel1().add((Component)this.getChkCaratula(), this.getChkCaratula().getName());
        this.getPanel1().add((Component)this.getChkConCerts(), this.getChkConCerts().getName());
        this.getPanel1().add((Component)this.getChkConTarjs(), this.getChkConTarjs().getName());
        this.getPanel1().add((Component)this.getBotonSoli(), this.getBotonSoli().getName());
        this.getPanel1().add((Component)this.getBotonAseg(), this.getBotonAseg().getName());
        this.getPanel1().add((Component)this.getBotonAgen(), this.getBotonAgen().getName());
        this.getPanel1().add((Component)this.getBotonEndo(), this.getBotonEndo().getName());
        this.getPanel1().add((Component)this.getBotonCert(), this.getBotonCert().getName());
        this.getPanel1().add((Component)this.getChkConEndAse(), this.getChkConEndAse().getName());
        this.getPanel1().add((Component)this.getChkEndPoli(), this.getChkEndPoli().getName());
        this.getPanel1().add((Component)this.getChkEndAseg(), this.getChkEndAseg().getName());
        this.getPanel1().add((Component)this.getChkEndABD(), this.getChkEndABD().getName());
        this.getPanel1().add((Component)this.getChkCon6(), this.getChkCon6().getName());
        this.getPanel1().add((Component)this.getChkConFact(), this.getChkConFact().getName());
        this.getPanel1().add((Component)this.getBotonEnviar(), this.getBotonEnviar().getName());
        this.getPanel1().add((Component)this.getBotonReset(), this.getBotonReset().getName());
        this.getPanel1().add((Component)this.getPanelArea(), this.getPanelArea().getName());
        

        this.getLabelArmado().setVisible(true);
        this.getBotonAgregar().setVisible(true);
        this.getChkCaratula().setVisible(true);
        this.getChkConCerts().setVisible(true);
        this.getChkConTarjs().setVisible(true);
        this.getChkConEndAse().setVisible(true);
        this.getChkEndPoli().setVisible(true);
        this.getChkEndAseg().setVisible(true);
        this.getChkEndABD().setVisible(true);
        this.getChkCon6().setVisible(false);
        this.getChkConFact().setVisible(false);
        this.getBotonCancelar().setVisible(true);
        this.getBotonSoli().setVisible(false);
        this.getBotonSoli().setEnabled(true);
        this.getBotonSoli().setSelected(false);
        this.getBotonAseg().setVisible(false);
        this.getBotonAgen().setVisible(false);
        this.getBotonEndo().setVisible(false);
        this.getBotonCert().setVisible(false);
        this.getBotonCond().setVisible(false);
        this.getLabelPath().setVisible(true);
        this.getLabelPath3().setVisible(false);
        this.getLabelPath4().setVisible(true);
        this.getLabelPath5().setVisible(true);
        this.getPanel1().setVisible(true);
        this.getLabelCheck().setVisible(true);
        this.getLabelCheck2().setVisible(true);
        this.getLabelCheck3().setVisible(true);
        this.getLabelCheck4().setVisible(true);
        this.getLabelCheck5().setVisible(true);
        this.getLabelCheck6().setVisible(false);
        this.getLabelCheck7().setVisible(false);
        this.getLabelCheck8().setVisible(true);
        this.getLabelCheck9().setVisible(true);
        this.getLabelCond().setVisible(false);
        this.getTextPath2().setVisible(true);
        this.getTextPath3().setVisible(true);
        this.getTextPath4().setVisible(true);
        this.getTextPath5().setVisible(false);
        this.getTextCond().setVisible(false);
        this.getChkConEndAse().setEnabled(true);
        this.getChkCaratula().setEnabled(true);
        this.getBotonAseg().setEnabled(false);
        this.getBotonAgen().setEnabled(false);
        this.getBotonEndo().setEnabled(false);
        this.getBotonCert().setEnabled(false);
        this.getTextArchivo().setVisible(true);
        this.getTextArchivo().setEditable(false);
        this.getBotonEnviar().setVisible(true);
        this.getBotonReset().setVisible(true);
        this.getBotonAgregar().addActionListener(this);
        this.getBotonCancelar().addActionListener(this);
        this.getBotonSoli().addActionListener(this);
        this.getBotonAgen().addActionListener(this);
        this.getBotonAseg().addActionListener(this);
        this.getBotonEndo().addActionListener(this);
        this.getBotonCert().addActionListener(this);
        this.getBotonEnviar().addActionListener(this);
        this.getBotonCond().addActionListener(this);
        this.getChkCaratula().addActionListener(this);
        this.getChkConCerts().addActionListener(this);
        this.getChkConTarjs().addActionListener(this);
        this.getChkConEndAse().addActionListener(this);
        this.getChkEndPoli().addActionListener(this);
        this.getChkEndAseg().addActionListener(this);
        this.getChkEndABD().addActionListener(this);
        this.getChkCon6().addActionListener(this);
        this.getChkConFact().addActionListener(this);
        this.getTextPath().addFocusListener(this);
        this.getTextPath3().addFocusListener(this);
        this.getBotonReset().addActionListener(this);
    }

    JLabel getLabelArmado() {
        if (this.labelArmado == null) {
            try {
                this.labelArmado = new JLabel();
                this.labelArmado.setName("LabelArmado");
                Font font = new Font("Arial Rounded MT", 1, 22);
                this.labelArmado.setFont(font);
                this.labelArmado.setText("SOLICITUD DE DOCUMENTOS");
                this.labelArmado.setForeground(new Color(255, 140, 0));
                this.labelArmado.setBounds(100, 10, 400, 50);
                this.labelArmado.setVisible(true);
            }
            catch (Throwable font) {
                // empty catch block
            }
        }
        return this.labelArmado;
    }

    JPanel getPanel1() {
        if (this.panel1 == null) {
            try {
                this.panel1 = new JPanel();
                this.panel1.setName("panel1");
                this.panel1.setBounds(0, 0, 530, 600);
                this.panel1.setLayout(null);
                this.panel1.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.panel1;
    }

    JScrollPane getPanelArea() {
        if (this.panelArea == null) {
            try {
                this.panelArea = new JScrollPane(this.getTextArchivo());
                this.panelArea.setName("panelArea");
                this.panelArea.setBounds(10, 370, 500, 120);
                this.panelArea.setLayout(new BorderLayout());
                this.panelArea.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.panelArea;
    }

    JLabel getLabelPath() {
        if (this.labelPath == null) {
            try {
                this.labelPath = new JLabel();
                this.labelPath.setName("labelPath");
                this.labelPath.setText("Nombre del Negocio: (20 Cars.)");
                this.labelPath.setSize(300, 23);
                this.labelPath.setLocation(10, 70);
                this.labelPath.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelPath;
    }

    JTextField getTextPath() {
        if (this.textPath == null) {
            try {
                this.textPath = new JTextField();
                this.textPath.setName("textPath");
                this.textPath.setSize(145, 23);
                this.textPath.setLocation(10, 100);
                Font font1 = new Font("Courier New", 1, 12);
                this.textPath.setFont(font1);
                this.textPath.setVisible(true);
            }
            catch (Throwable font1) {
                // empty catch block
            }
        }
        return this.textPath;
    }

    JLabel getLabelPath2() {
        if (this.labelPath2 == null) {
            try {
                this.labelPath2 = new JLabel();
                this.labelPath2.setName("labelPath2");
                this.labelPath2.setText("Documentos a Solicitar :");
                this.labelPath2.setSize(300, 23);
                this.labelPath2.setLocation(10, 140);
                this.labelPath2.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelPath2;
    }

    JLabel getLabelPath6() {
        if (this.labelPath6 == null) {
            try {
                this.labelPath6 = new JLabel();
                this.labelPath6.setName("labelPath6");
                this.labelPath6.setText("Negocio Actual:");
                this.labelPath6.setSize(300, 23);
                this.labelPath6.setLocation(205, 140);
                this.labelPath6.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelPath6;
    }

    JTextField getTextPath4() {
        if (this.textPath4 == null) {
            try {
                this.textPath4 = new JTextField();
                this.textPath4.setName("textPath4");
                this.textPath4.setSize(145, 23);
                this.textPath4.setLocation(205, 165);
                Font font1 = new Font("Courier New", 1, 12);
                this.textPath4.setFont(font1);
                this.textPath4.setEnabled(false);
                this.textPath4.setVisible(true);
            }
            catch (Throwable font1) {
                // empty catch block
            }
        }
        return this.textPath4;
    }

    JCheckBox getChkConTarjs() {
        if (this.ChkCon8 == null) {
            try {
                this.ChkCon8 = new JCheckBox();
                this.ChkCon8.setName("ChkCon8");
                this.ChkCon8.setBounds(10, 160, 20, 25);
                this.ChkCon8.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon8;
    }

    JLabel getLabelCheck8() {
        if (this.labelCheck8 == null) {
            try {
                this.labelCheck8 = new JLabel();
                this.labelCheck8.setName("labelCheck8");
                this.labelCheck8.setText("Tarjetas");
                this.labelCheck8.setBounds(30, 160, 200, 25);
                this.labelCheck8.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck8;
    }

    JCheckBox getChkConCerts() {
        if (this.ChkCon2 == null) {
            try {
                this.ChkCon2 = new JCheckBox();
                this.ChkCon2.setName("ChkCon2");
                this.ChkCon2.setBounds(10, 180, 20, 25);
                this.ChkCon2.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon2;
    }

    JLabel getLabelCheck2() {
        if (this.labelCheck2 == null) {
            try {
                this.labelCheck2 = new JLabel();
                this.labelCheck2.setName("labelCheck2");
                this.labelCheck2.setText("Certificados");
                this.labelCheck2.setBounds(30, 180, 200, 25);
                this.labelCheck2.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck2;
    }

    JCheckBox getChkCaratula() {
        if (this.ChkCon == null) {
            try {
                this.ChkCon = new JCheckBox();
                this.ChkCon.setName("ChkCon");
                this.ChkCon.setBounds(10, 200, 20, 25);
                this.ChkCon.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon;
    }

    JLabel getLabelCheck() {
        if (this.labelCheck == null) {
            try {
                this.labelCheck = new JLabel();
                this.labelCheck.setName("labelCheck");
                this.labelCheck.setText("Caratula");
                this.labelCheck.setBounds(30, 200, 200, 25);
                this.labelCheck.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck;
    }

    public JRadioButton getBotonSoli() {
        if (this.botonSoli == null) {
            try {
                this.botonSoli = new JRadioButton();
                this.botonSoli.setName("BotonSoli");
                this.botonSoli.setText("Edo. Solicitud");
                this.botonSoli.setBounds(275, 100, 120, 25);
                this.botonSoli.setVisible(false);
                this.botonSoli.setEnabled(false);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.botonSoli;
    }

    JRadioButton getBotonAseg() {
        if (this.botonAseg == null) {
            try {
                this.botonAseg = new JRadioButton();
                this.botonAseg.setName("BotonAseg");
                this.botonAseg.setText("Asegurado");
                this.botonAseg.setBounds(120, 200, 100, 25);
                this.botonAseg.setVisible(false);
                this.botonAseg.setEnabled(false);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.botonAseg;
    }

    JRadioButton getBotonAgen() {
        if (this.botonAgen == null) {
            try {
                this.botonAgen = new JRadioButton();
                this.botonAgen.setName("BotonAgen");
                this.botonAgen.setText("Agente");
                this.botonAgen.setBounds(220, 200, 100, 25);
                this.botonAgen.setVisible(false);
                this.botonAgen.setEnabled(false);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.botonAgen;
    }

    JCheckBox getChkConEndAse() {
        if (this.ChkCon3 == null) {
            try {
                this.ChkCon3 = new JCheckBox();
                this.ChkCon3.setName("ChkCon3");
                this.ChkCon3.setBounds(10, 220, 20, 25);
                this.ChkCon3.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon3;
    }

    JLabel getLabelCheck3() {
        if (this.labelCheck3 == null) {
            try {
                this.labelCheck3 = new JLabel();
                this.labelCheck3.setName("labelCheck3");
                this.labelCheck3.setText("Registro Asegurados");
                this.labelCheck3.setBounds(30, 220, 200, 25);
                this.labelCheck3.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck3;
    }

    JCheckBox getChkEndPoli() {
        if (this.ChkCon4 == null) {
            try {
                this.ChkCon4 = new JCheckBox();
                this.ChkCon4.setName("ChkCon4");
                this.ChkCon4.setBounds(10, 240, 20, 25);
                this.ChkCon4.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon4;
    }

    JLabel getLabelCheck4() {
        if (this.labelCheck4 == null) {
            try {
                this.labelCheck4 = new JLabel();
                this.labelCheck4.setName("labelCheck4");
                this.labelCheck4.setText("Endosos Poliza");
                this.labelCheck4.setBounds(30, 240, 200, 25);
                this.labelCheck4.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck4;
    }

    JCheckBox getChkEndAseg() {
        if (this.ChkCon5 == null) {
            try {
                this.ChkCon5 = new JCheckBox();
                this.ChkCon5.setName("ChkCon5");
                this.ChkCon5.setBounds(10, 260, 20, 25);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon5;
    }

    JLabel getLabelCheck5() {
        if (this.labelCheck5 == null) {
            try {
                this.labelCheck5 = new JLabel();
                this.labelCheck5.setName("labelCheck5");
                this.labelCheck5.setText("Endosos Asegurados");
                this.labelCheck5.setBounds(30, 260, 200, 25);
                this.labelCheck5.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck5;
    }

    JCheckBox getChkEndABD() {
        if (this.ChkCon9 == null) {
            try {
                this.ChkCon9 = new JCheckBox();
                this.ChkCon9.setName("ChkCon9");
                this.ChkCon9.setBounds(10, 280, 20, 25);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon9;
    }

    JLabel getLabelCheck9() {
        if (this.labelCheck9 == null) {
            try {
                this.labelCheck9 = new JLabel();
                this.labelCheck9.setName("labelCheck9");
                this.labelCheck9.setText("Movimientos por:");
                this.labelCheck9.setBounds(30, 280, 200, 25);
                this.labelCheck9.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck9;
    }

    JRadioButton getBotonCert() {
        if (this.botonCert == null) {
            try {
                this.botonCert = new JRadioButton();
                this.botonCert.setName("BotonCert");
                this.botonCert.setText("Certificado");
                this.botonCert.setBounds(130, 280, 100, 25);
                this.botonCert.setVisible(false);
                this.botonCert.setEnabled(false);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.botonCert;
    }

    JRadioButton getBotonEndo() {
        if (this.botonEndo == null) {
            try {
                this.botonEndo = new JRadioButton();
                this.botonEndo.setName("BotonEndo");
                this.botonEndo.setText("Endoso");
                this.botonEndo.setBounds(230, 280, 100, 25);
                this.botonEndo.setVisible(false);
                this.botonEndo.setEnabled(false);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.botonEndo;
    }

    JTextField getTextPath5() {
        if (this.textPath5 == null) {
            try {
                this.textPath5 = new JTextField();
                this.textPath5.setName("textPath4");
                this.textPath5.setSize(72, 23);
                this.textPath5.setLocation(350, 280);
                Font font1 = new Font("Courier New", 1, 12);
                this.textPath5.setFont(font1);
                this.textPath5.setEnabled(true);
                this.textPath5.setVisible(true);
            }
            catch (Throwable font1) {
                // empty catch block
            }
        }
        return this.textPath5;
    }

    JCheckBox getChkConFact() {
        if (this.ChkCon7 == null) {
            try {
                this.ChkCon7 = new JCheckBox();
                this.ChkCon7.setName("ChkCon7");
                this.ChkCon7.setBounds(10, 280, 20, 25);
                this.ChkCon7.setVisible(true);
                this.ChkCon7.setEnabled(false);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.ChkCon7;
    }

    JLabel getLabelCheck7() {
        if (this.labelCheck7 == null) {
            try {
                this.labelCheck7 = new JLabel();
                this.labelCheck7.setName("labelCheck7");
                this.labelCheck7.setText("Facturacion");
                this.labelCheck7.setBounds(30, 280, 200, 25);
                this.labelCheck7.setVisible(true);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
        }
        return this.labelCheck7;
    }

    JLabel getLabelPath3() {
        if (this.labelPath3 == null) {
            try {
                this.labelPath3 = new JLabel();
                this.labelPath3.setName("labelPath3");
                this.labelPath3.setText("Estructura:");
                this.labelPath3.setSize(300, 23);
                this.labelPath3.setLocation(10, 280);
                this.labelPath3.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.labelPath3;
    }

    JCheckBox getChkCon6() {
        if (this.ChkCon6 == null) {
            try {
                this.ChkCon6 = new JCheckBox();
                this.ChkCon6.setName("ChkCon6");
                this.ChkCon6.setBounds(10, 300, 20, 25);
                this.ChkCon6.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.ChkCon6;
    }

    JLabel getLabelCheck6() {
        if (this.labelCheck6 == null) {
            try {
                this.labelCheck6 = new JLabel();
                this.labelCheck6.setName("labelCheck6");
                this.labelCheck6.setText("Genera Carpeta para Cada Asegurado");
                this.labelCheck6.setBounds(30, 250, 300, 25);
                this.labelCheck6.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.labelCheck6;
    }

    JLabel getLabelCond() {
        if (this.labelCond == null) {
            try {
                this.labelCond = new JLabel();
                this.labelCond.setName("labelCond");
                this.labelCond.setText("Seleccione Archivo de Control:");
                this.labelCond.setSize(200, 23);
                this.labelCond.setLocation(10, 280);
                this.labelCond.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.labelCond;
    }

    JButton getBotonAgregar() {
        if (this.botonAceptar == null) {
            try {
                this.botonAceptar = new JButton();
                this.botonAceptar.setName("BotonAceptar");
                this.botonAceptar.setText("Agregar");
                this.botonAceptar.setBounds(110, 500, 100, 25);
                this.botonAceptar.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.botonAceptar;
    }

    JButton getBotonEnviar() {
        if (this.botonEnviar == null) {
            try {
                this.botonEnviar = new JButton();
                this.botonEnviar.setName("botonEnviar");
                this.botonEnviar.setText("Enviar");
                this.botonEnviar.setBounds(240, 500, 100, 25);
                this.botonEnviar.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.botonEnviar;
    }

    JButton getBotonCancelar() {
        if (this.botonCancelar == null) {
            try {
                this.botonCancelar = new JButton();
                this.botonCancelar.setName("BotonCancelar");
                this.botonCancelar.setText("Salir");
                this.botonCancelar.setBounds(370, 500, 100, 25);
                this.botonCancelar.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.botonCancelar;
    }

    JTextField getTextCond() {
        if (this.textCond == null) {
            try {
                this.textCond = new JTextField();
                this.textCond.setName("textCond");
                this.textCond.setSize(400, 23);
                this.textCond.setLocation(10, 310);
                this.textCond.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.textCond;
    }

    JButton getBotonCond() {
        if (this.botonCond == null) {
            try {
                this.botonCond = new JButton();
                this.botonCond.setName("botonCond");
                this.botonCond.setText("...");
                this.botonCond.setBounds(410, 310, 23, 23);
                this.botonCond.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.botonCond;
    }

    JButton getBotonReset() {
        if (this.botonReset == null) {
            try {
                this.botonReset = new JButton();
                this.botonReset.setName("botonReset");
                this.botonReset.setText("Reset");
                this.botonReset.setBounds(370, 165, 100, 23);
                this.botonReset.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.botonReset;
    }

    JLabel getLabelPath4() {
        if (this.labelPath4 == null) {
            try {
                this.labelPath4 = new JLabel();
                this.labelPath4.setName("labelPath4");
                this.labelPath4.setText("Numero de Poliza: (8 Digs.)");
                this.labelPath4.setSize(300, 23);
                this.labelPath4.setLocation(205, 70);
                this.labelPath4.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.labelPath4;
    }

    JTextField getTextPath2() {
        if (this.textPath2 == null) {
            try {
                this.textPath2 = new JTextField();
                this.textPath2.setName("textPath2");
                this.textPath2.setSize(65, 23);
                this.textPath2.setLocation(205, 100);
                Font font1 = new Font("Courier New", 1, 12);
                this.textPath2.setFont(font1);
                this.textPath2.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.textPath2;
    }

    JLabel getLabelPath5() {
        if (this.labelPath5 == null) {
            try {
                this.labelPath5 = new JLabel();
                this.labelPath5.setName("labelPath5");
                this.labelPath5.setText("Usuario:");
                this.labelPath5.setSize(300, 23);
                this.labelPath5.setLocation(400, 70);
                this.labelPath5.setVisible(true);
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.labelPath5;
    }

    JTextField getTextPath3() {
        if (this.textPath3 == null) {
            try {
                this.textPath3 = new JTextField();
                this.textPath3.setName("textPath3");
                this.textPath3.setSize(100, 23);
                this.textPath3.setLocation(400, 100);
                Font font1 = new Font("Courier New", 1, 12);
                this.textPath3.setFont(font1);
                this.textPath3.setEnabled(false);
                this.textPath3.setVisible(true);
            }
            catch (Throwable font1) {
                // empty catch block
            }
        }
        return this.textPath3;
    }

    JTextArea getTextArchivo() {
        if (this.txtArchivo == null) {
            try {
                this.txtArchivo = new JTextArea(600, 10000);
                this.txtArchivo.setName("txtArchivo");
            }
            catch (Throwable ivjExc) {
                ivjExc.printStackTrace();
            }
        }
        return this.txtArchivo;
    }



	
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.getBotonAgregar()) {
            String st;
            if (this.getChkEndABD().isSelected()) {
                if (this.getTextPath().getText().equals("") || this.getTextPath2().getText().equals("") ) {
                    st = "Debe informarse el Negocio, la P\u00f3liza, y Numero del Documento";
                    JOptionPane.showMessageDialog(null, st);
                } else if (!(this.getBotonEndo().isSelected() || this.getBotonCert().isSelected())) {
                    st = "Debe seleccionarse el tipo de Documento";
                    JOptionPane.showMessageDialog(null, st);	
                } else {
                    this.user = this.getTextPath3().getText();
                    String poliza = getTextPath2().getText();
//                    String folio = cua.get(cua2);
//                    String polizaper = polizas.get(folio);
//                    if(poliza == polizaper){// version brokers
                    this.armadoArchivo(this.armadoDeLinea());
                    System.out.println("Se agrego registro a " + this.archivoS);

//                    }else{
//                    	st = "No cuentas con permiso para esta póliza";
//                        JOptionPane.showMessageDialog(null, st);
//                    }
                }
            } else if (this.getTextPath().getText().equals("") || this.getTextPath2().getText().equals("")) {
                st = "Debe informarse el Nombre del Negocio y la P\u00f3liza";
                JOptionPane.showMessageDialog(null, st);
            } else {
                this.user = this.getTextPath3().getText();
                String poliza = getTextPath2().getText();
//                String folio = cua.get(cua2);
//                String polizaper = polizas.get(folio);
//                if(poliza.equals(polizaper)){
                this.armadoArchivo(this.armadoDeLinea());
                System.out.println("Se agrego registro a " + this.archivoS);

//                }else{
//                	st = "No cuentas con permiso para esta póliza";
//                    JOptionPane.showMessageDialog(null, st);
//                }
            }
        }
        if (e.getSource() == this.getBotonSoli()) {
            if (this.getBotonSoli().isSelected()) {
                this.getBotonAseg().setEnabled(false);
                this.getBotonAseg().setSelected(false);
                this.getBotonAgen().setEnabled(false);
                this.getBotonAgen().setSelected(false);
                this.getChkConTarjs().setEnabled(false);
                this.getChkConTarjs().setSelected(false);
                this.getChkConCerts().setEnabled(false);
                this.getChkConCerts().setSelected(false);
                this.getChkCaratula().setEnabled(false);
                this.getChkCaratula().setSelected(false);
                this.getChkConEndAse().setEnabled(false);
                this.getChkConEndAse().setSelected(false);
                this.getChkEndAseg().setEnabled(false);
                this.getChkEndAseg().setSelected(false);
                this.getChkEndABD().setEnabled(false);
                this.getChkEndABD().setSelected(false);
                this.getChkEndPoli().setEnabled(false);
                this.getChkEndPoli().setSelected(false);
                this.getTextPath().setEnabled(false);
                this.getTextPath().setText("_EDO_SOLICITUD");
                this.getTextPath2().setText("");
            } else {
                this.getChkConTarjs().setEnabled(true);
                this.getChkConTarjs().setSelected(false);
                this.getChkConCerts().setEnabled(true);
                this.getChkConCerts().setSelected(false);
                this.getChkCaratula().setEnabled(true);
                this.getChkCaratula().setSelected(false);
                this.getChkConEndAse().setEnabled(true);
                this.getChkConEndAse().setSelected(false);
                this.getChkEndAseg().setEnabled(true);
                this.getChkEndAseg().setSelected(false);
                this.getChkEndABD().setEnabled(true);
                this.getChkEndABD().setSelected(false);
                this.getChkEndPoli().setEnabled(true);
                this.getChkEndPoli().setSelected(false);
                this.getTextPath().setEnabled(true);
                this.getTextPath().setText("");
                this.getTextPath2().setText("");
            }
        }
        if (e.getSource() == this.getChkEndABD()) {
            if (this.getChkEndABD().isSelected()) {
                this.getBotonEndo().setVisible(true);
                this.getBotonCert().setVisible(true);
                this.getBotonEndo().setEnabled(true);
                this.getBotonCert().setEnabled(true);
                this.getBotonEndo().setSelected(false);
                this.getBotonCert().setSelected(false);
                this.getBotonAseg().setEnabled(false);
                this.getBotonAseg().setSelected(false);
                this.getBotonAseg().setVisible(false);
                this.getBotonAgen().setEnabled(false);
                this.getBotonAgen().setSelected(false);
                this.getBotonAgen().setVisible(false);
                this.getChkConTarjs().setEnabled(false);
                this.getChkConTarjs().setSelected(false);
                this.getChkEndAseg().setEnabled(false);
                this.getChkEndAseg().setSelected(false);
                this.getChkConCerts().setEnabled(false);
                this.getChkConCerts().setSelected(false);
                this.getChkCaratula().setEnabled(false);
                this.getChkCaratula().setSelected(false);
                this.getChkConEndAse().setEnabled(false);
                this.getChkConEndAse().setSelected(false);
                this.getChkEndPoli().setEnabled(false);
                this.getChkEndPoli().setSelected(false);
                this.getTextPath5().setEnabled(true);
                this.getTextPath5().setVisible(true);
                this.getTextPath().setEnabled(true);
            } else {
                this.getBotonEndo().setVisible(false);
                this.getBotonCert().setVisible(false);
                this.getChkConTarjs().setEnabled(true);
                this.getChkConTarjs().setSelected(false);
                this.getChkConCerts().setEnabled(true);
                this.getChkConCerts().setSelected(false);
                this.getChkCaratula().setEnabled(true);
                this.getChkCaratula().setSelected(false);
                this.getChkConEndAse().setEnabled(true);
                this.getChkConEndAse().setSelected(false);
                this.getChkEndAseg().setEnabled(true);
                this.getChkEndAseg().setSelected(false);
                this.getChkEndABD().setEnabled(true);
                this.getChkEndABD().setSelected(false);
                this.getChkEndPoli().setEnabled(true);
                this.getChkEndPoli().setSelected(false);
                this.getTextPath5().setEnabled(false);
                this.getTextPath5().setVisible(false);
                this.getTextPath5().setText("");
                this.getTextPath().setEnabled(true);
            }
        }
       
        if (e.getSource() == this.getChkCaratula()) {
            if (this.getChkCaratula().isSelected()) {
                this.getBotonAseg().setEnabled(true);
                this.getBotonAseg().setSelected(true);
                this.getBotonAseg().setVisible(true);
                this.getBotonAgen().setVisible(true);
                this.getBotonAgen().setEnabled(true);
                this.getBotonAgen().setSelected(true);
            } else {
                this.getBotonAseg().setEnabled(false);
                this.getBotonAseg().setSelected(false);
                this.getBotonAseg().setVisible(false);
                this.getBotonAgen().setVisible(false);
                this.getBotonAgen().setEnabled(false);
                this.getBotonAgen().setSelected(false);
            }
        }
        if (e.getSource() == this.getBotonCancelar()) {
            File ruta = new File(this.archivoS);
            this.getBotonSoli().setSelected(false);
            System.out.println("aprete salir");
            if (ruta.exists()) {
                ruta.delete();
            }
            this.setVisible(false);
        }
        if (e.getSource() == this.getBotonEnviar()) {
            EnvioFTP ftp = new EnvioFTP();
//            File rut1 = new File(this.archivoS);
            boolean boton = false;
            if (this.getBotonSoli().isSelected()) {
                boton = true;
            }
            if (ftp.enviaArchivoFTPMainframe(this.archivoS, (String)this.users.get(this.user), boton)) {
                this.setVisible(false);
            }
            if (this.getBotonSoli().isSelected()) {
                File rut = new File(this.archivoR);
                rut.delete();
            }
        }
        if (e.getSource() == this.getBotonReset()) {
            this.getTextPath4().setText("");
            File fd = new File("C:\\Armado Digital SIGMA\\Tarjetas\\SolicitudesR.txt");
            fd.delete();
            fd = new File("C:\\Armado Digital SIGMA\\Tarjetas\\GeneraTarjetas.txt");
            fd.delete();
            String pr = "C:\\Armado Digital SIGMA\\Tarjetas\\";
            System.out.println("pr: " + pr);
            this.borrarArc(pr);
            File dir = new File(pr);
            dir.mkdirs();
        }
    }

    private void armadoArchivo(String[] cadena) {
        String pathASalGen = "C:\\Armado Digital SIGMA\\Tarjetas\\SolicitudesD.txt";
        String pathSalReal = "C:\\Armado Digital SIGMA\\Tarjetas\\SolicitudesR.txt";
        String lineArch = "";
        try {
            this.archivoR = pathSalReal;
            this.archivoS = pathASalGen;
            RandomAccessFile archWR = new RandomAccessFile(this.archivoR, "rw");
            RandomAccessFile archWS = new RandomAccessFile(this.archivoS, "rw");
            archWR.seek(0);
            archWS.seek(0);
            archWR.seek(archWR.length());
            archWS.seek(archWS.length());
            archWR.writeBytes(String.valueOf(cadena[1]) + "\n");
            archWS.writeBytes(String.valueOf(cadena[0]) + "\n");
            archWS.seek(0);
            archWR.seek(0);
            this.getTextArchivo().setText("");
            while ((lineArch = archWS.readLine()) != null) {
                this.getTextArchivo().setText(String.valueOf(this.getTextArchivo().getText()) + lineArch + "\n");
            }
            archWR.close();
            archWS.close();
        }
        catch (Exception archWR) {
            // empty catch block
        }
    }

    private String[] armadoDeLinea() {
        String[] datos = new String[]{"", ""};
        String cad = "";
        String cad2 = "";
        if (this.getChkEndABD().isSelected()) {
            cad = this.getBotonCert().isSelected() ? String.valueOf(new StringBuilder(String.valueOf(this.fillCeros(this.getTextPath2().getText(), 8))).append("C").append(this.fillCeros(this.getTextPath5().getText(), 8)).toString()) + "AAXXXAA" : String.valueOf(new StringBuilder(String.valueOf(this.fillCeros(this.getTextPath2().getText(), 8))).append(this.fillCeros(this.getTextPath5().getText(), 9)).toString()) + "AAXXXAA";
            cad2 = cad;
        } else {
            cad = String.valueOf(this.fillCeros(this.getTextPath2().getText(), 8)) + this.fillCeros(this.getTextPath5().getText(), 9);
            if (this.getChkCaratula().isSelected()) {
                cad = this.getBotonAseg().isSelected() ? String.valueOf(cad) + "X" : String.valueOf(cad) + "A";
                cad = this.getBotonAgen().isSelected() ? String.valueOf(cad) + "X" : String.valueOf(cad) + "A";
            } else {
                cad = String.valueOf(cad) + "AA";
            }
            cad = this.getChkConCerts().isSelected() ? String.valueOf(cad) + "X" : String.valueOf(cad) + "A";
            cad = this.getChkConEndAse().isSelected() ? String.valueOf(cad) + "X" : String.valueOf(cad) + "A";
            cad2 = String.valueOf(cad);
            cad = String.valueOf(cad) + "X";   
            cad2 = this.getChkConTarjs().isSelected() ? String.valueOf(cad2) + "X" : String.valueOf(cad2) + "A";
            cad = this.getChkEndPoli().isSelected() ? String.valueOf(cad) + "X" : String.valueOf(cad) + "A";
            cad2= this.getChkEndPoli().isSelected() ? String.valueOf(cad2) + "X" : String.valueOf(cad2) + "A";
            cad = this.getChkEndAseg().isSelected() ? String.valueOf(cad) + "X" : String.valueOf(cad) + "A";
            cad2= this.getChkEndAseg().isSelected() ? String.valueOf(cad2) + "X" : String.valueOf(cad2) + "A";
        }
        cad2 = String.valueOf(cad2) + (String)this.users.get(this.user);
        cad = String.valueOf(cad) + (String)this.users.get(this.user);
        System.out.println("soy cad: " + cad);
        System.out.println("soy cad2: " + cad2);
        if (this.getChkEndABD().isSelected() && this.getChkEndABD().isEnabled()) {
            this.getTextPath().setText(String.valueOf(this.getTextPath().getText()) + "_MOVIMIENTOS");
            this.getTextPath().setEnabled(false);
            this.getChkEndABD().setEnabled(false);
            this.getBotonReset().setEnabled(false);
            if (this.getBotonCert().isSelected()) {
                this.getBotonEndo().setEnabled(false);
            } else {
                this.getBotonCert().setEnabled(false);
            }
        }
        cad2 = String.valueOf(cad2) + this.getTextPath().getText();
        cad = String.valueOf(cad) + this.getTextPath().getText();
        System.out.println("soy cad: " + cad);
        System.out.println("soy cad2: " + cad2);
        datos[0] = cad;
        datos[1] = cad2;
        return datos;
    }

    public String fillCeros(String valor, int longitud) {
        while (valor.length() < longitud) {
            valor = "0" + valor;
        }
        return valor;
    }

    @Override
    public void focusGained(FocusEvent focusevent) {
    }

    @Override
    public void focusLost(FocusEvent arg0) {
        arg0.getSource();
     
        if (arg0.getSource() == this.getTextPath()) {
            this.getTextPath().setText(this.getTextPath().getText().toUpperCase());
        }
        if (arg0.getSource() == this.getTextPath3()) {
            this.getTextPath3().setText(this.getTextPath3().getText().toLowerCase());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        e.getSource();
        this.getPanelArea();
    }

    @Override
    public void mouseMoved(MouseEvent mouseevent) {
    }

    public void setUsuario(String usuario, String nNegocio, String cua2 ) {
        this.textPath3.setText(usuario);
        this.textPath4.setText(nNegocio);
        this.cua2 = cua2;
    }

    private void borrarArc(String dir) {
        File fs = new File(dir);
        if (fs.isDirectory()) {
            String[] ficheros = fs.list();
            for (int x = 0; x < ficheros.length; ++x) {
                this.borrarArc(String.valueOf(dir) + "\\" + ficheros[x]);
            }
            if (fs.delete()) {
                System.out.println("Carpeta borrada " + dir);
            }
        } else if (fs.delete()) {
            System.out.println("Archivo borrado " + dir);
        }
    }

}
