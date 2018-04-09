package principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class IngresaMontos extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtPrimaNeta;
	private JTextField txtDerPol;
	private JTextField txtPimTot;
	private JTextField txtTotPag;
	private JTextField txtImportePrem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresaMontos frame = new IngresaMontos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public IngresaMontos() {
		setTitle("Nuevos Importes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngresaLosNuevos = new JLabel("Ingresa los Nuevos Importes");
		lblIngresaLosNuevos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblIngresaLosNuevos.setBounds(76, 13, 297, 37);
		lblIngresaLosNuevos.setForeground(new Color(255,140,00));
		contentPane.add(lblIngresaLosNuevos);

		JLabel lblPrimaNeta = new JLabel("Prima Neta:");
		lblPrimaNeta.setBounds(44, 90, 127, 16);
		contentPane.add(lblPrimaNeta);

		JLabel lblDerechoDePliza = new JLabel("Derecho de P\u00F3liza:");
		lblDerechoDePliza.setBounds(44, 120, 127, 16);
		contentPane.add(lblDerechoDePliza);

		JLabel lblPrimaTotal = new JLabel("Prima Total:");
		lblPrimaTotal.setBounds(44, 150, 127, 16);
		contentPane.add(lblPrimaTotal);

		JLabel lblTotalAPagar = new JLabel("Total a Pagar:");
		lblTotalAPagar.setBounds(44, 180, 114, 16);
		contentPane.add(lblTotalAPagar);

		JLabel lblImportePremier = new JLabel("Importe Premier:");
		lblImportePremier.setBounds(44, 210, 127, 16);
		contentPane.add(lblImportePremier);

		txtPrimaNeta = new JTextField();
		txtPrimaNeta.setBounds(183, 87, 169, 22);
		contentPane.add(txtPrimaNeta);
		txtPrimaNeta.setColumns(10);

		txtDerPol = new JTextField();
		txtDerPol.setBounds(183, 120, 169, 22);
		contentPane.add(txtDerPol);
		txtDerPol.setColumns(10);

		txtPimTot = new JTextField();
		txtPimTot.setBounds(183, 150, 169, 22);
		contentPane.add(txtPimTot);
		txtPimTot.setColumns(10);

		txtTotPag = new JTextField();
		txtTotPag.setBounds(183, 177, 169, 22);
		contentPane.add(txtTotPag);
		txtTotPag.setColumns(10);

		txtImportePrem = new JTextField();
		txtImportePrem.setBounds(183, 207, 169, 22);
		contentPane.add(txtImportePrem);
		txtImportePrem.setColumns(10);

		JLabel label = new JLabel("$");
		label.setBounds(164, 90, 56, 16);
		contentPane.add(label);

		JLabel label_1 = new JLabel("$");
		label_1.setBounds(164, 123, 56, 16);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("$");
		label_2.setBounds(164, 153, 56, 16);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("$");
		label_3.setBounds(164, 180, 56, 16);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("$");
		label_4.setBounds(164, 210, 56, 16);
		contentPane.add(label_4);

		contentPane.add((Component)this.getBotonAceptar(), this.getBotonAceptar().getName());
		contentPane.add((Component)this.getBotonCancelar(), this.getBotonCancelar().getName());
		getBotonAceptar().addActionListener(this);
		getBotonCancelar().addActionListener(this);


		JLabel lblSolaLlenaLos = new JLabel("Sola llenar los campos de los que deseas cambiar el importe.");
		lblSolaLlenaLos.setBounds(32, 46, 361, 37);
		contentPane.add(lblSolaLlenaLos);
	}

	JButton getBotonAceptar() {
		if (this.btnAceptar == null) {
			try {
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setBounds(76, 266, 97, 25);
			} catch (Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return this.btnAceptar;
	}

	JButton getBotonCancelar() {
		if (this.btnCancelar == null) {
			try {
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(247, 266, 97, 25);
			} catch (Throwable ivjExc) {
				ivjExc.printStackTrace();
			}
		}
		return this.btnCancelar;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getBotonAceptar()) {
			try {
				String PrimNeta ="", DerPoliza="", PrimTotal="", TotalPagar="",ImportePrem="";
				PrimNeta = "$ " + txtPrimaNeta.getText().toString();
				DerPoliza ="$ " + txtDerPol.getText().toString();
				PrimTotal ="$ " + txtPimTot.getText().toString();
				TotalPagar ="$ " + txtTotPag.getText().toString();
				ImportePrem ="$ " + txtImportePrem.getText().toString();
				this.setVisible(false);
				Principal p = new Principal();
				p.generaDocs(PrimNeta, DerPoliza, PrimTotal, TotalPagar, ImportePrem);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource() == this.getBotonCancelar()) {
			this.setVisible(false);
		}
	}
}
