package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import logic.Result;
import logic.User;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SellerScreen extends JFrame {

	public SellerScreen(User user) {

		me = user;
		initGui();
	}

	private User me;

	private JPanel panel;
	private JLabel imageLabel;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JTextArea mensajeArea;
	private JScrollPane scrollPanel;
	private JTextArea textSaldo;
	private JLabel jLabel1;
	private JPanel panelMensajes;
	private JComboBox boxTipoCospel;
	private JButton botonCargar;
	private JComboBox boxPatente;
	private JLabel labelPatente;

	private void initGui() {

		setTitle("Sistema de Parquimetros - Usuario: Vendedor");
		this.setPreferredSize(new java.awt.Dimension(514, 501));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			BorderLayout panelLayout = new BorderLayout();
			panel.setLayout(panelLayout);
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				panelMensajes = new JPanel();
				panel.add(panelMensajes, BorderLayout.CENTER);
				panel.add(getJPanel1(), BorderLayout.NORTH);
				BorderLayout panelMensajesLayout = new BorderLayout();
				panelMensajes.setLayout(panelMensajesLayout);
				panelMensajes.setPreferredSize(new java.awt.Dimension(486,
						113));
				panelMensajes.add(getScrollPanel(), BorderLayout.CENTER);
			}
		}

		pack();
		this.setSize(514, 501);
	}

	private JButton getBotonCargar() {
		if (botonCargar == null) {
			botonCargar = new JButton();
			botonCargar.setText("Crear Cospel");
			botonCargar.setPreferredSize(new java.awt.Dimension(136, 22));
			botonCargar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					botonCargarAction(evt);
				}
			});
		}
		{
			boxTipoCospel = new JComboBox();
			jPanel1.add(boxTipoCospel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			jPanel1.add(getJLabel2(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			iniciarCospelTipo();
			boxTipoCospel.setPreferredSize(new java.awt.Dimension(512, 155));
		}
		return botonCargar;
	}

	/*
	 * Lista de posibles tipos de cospeles en la base de dato.
	 */
	private void iniciarCospelTipo() {
		Result res = me.execute("SELECT tipo FROM tipos_cospeles;");

		DefaultComboBoxModel cbm = new DefaultComboBoxModel();

		for (String[] row : res) {
			cbm.addElement(row[0]);
		}
		boxTipoCospel.setModel(cbm);

		res.closeQuery();
	}

	/*
	 * Lista de patentes de los autos cargados en la base de datos
	 */
	private void iniciarPatentes() {
		Result res = me.execute("SELECT patente FROM automoviles;");

		DefaultComboBoxModel cbm = new DefaultComboBoxModel();

		for (String[] row : res) {
			cbm.addElement(row[0]);
		}

		boxPatente.setModel(cbm);

		res.closeQuery();
	}

	public void botonCargarAction(ActionEvent evt) {
		// me ingresaron un número?
		boolean es;
		float saldo = 0;
		try {
			saldo = Float.parseFloat(textSaldo.getText());
			es = true;
		} catch (NumberFormatException e) {
			es = false;
		}
		if (es) {
			if (saldo < 100 && saldo > 0) {
				String sql = "INSERT INTO `cospeles` (`id_cospel`, `saldo`, `tipo`, `patente`) VALUES (NULL, '"
						+ saldo
						+ "', '"
						+ (String) boxTipoCospel.getSelectedItem()
						+ "', '"
						+ (String) boxPatente.getSelectedItem() + "');";

				me.execute(sql);
				mensajeArea.setText(mensajeArea.getText() + "\n"
						+ "Ha creado un nuevo cospel con saldo de " + saldo
						+ " de tipo "
						+ (String) boxTipoCospel.getSelectedItem()
						+ " a la patente "
						+ (String) boxPatente.getSelectedItem() + ".\n");
			}
		} else
			mensajeArea.setText(mensajeArea.getText()
					+ "No puede ingresar ese saldo.\n");

	}

	private JScrollPane getScrollPanel() {
		if (scrollPanel == null) {
			scrollPanel = new JScrollPane();
			scrollPanel.setPreferredSize(new java.awt.Dimension(512, 223));
			scrollPanel.setViewportView(getMensajeArea());
		}
		return scrollPanel;
	}

	private JTextArea getMensajeArea() {
		if (mensajeArea == null) {
			mensajeArea = new JTextArea();
			mensajeArea.setEditable(false);
		}
		return mensajeArea;
	}
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			GridBagLayout jPanel1Layout = new GridBagLayout();
			jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
			jPanel1Layout.rowHeights = new int[] {7, 7, 7};
			jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7};
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.setPreferredSize(new java.awt.Dimension(512, 175));
			{
				jLabel1 = new JLabel();
				jPanel1.add(jLabel1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabel1.setText("Saldo");
				jLabel1.setPreferredSize(new java.awt.Dimension(124, 40));
			}
			{
				textSaldo = new JTextArea();
				jPanel1.add(textSaldo, new GridBagConstraints(2, 2, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				textSaldo.setPreferredSize(new java.awt.Dimension(42, 17));
				textSaldo.setBorder(new LineBorder(
						new java.awt.Color(0, 0, 0), 1, false));
			}
			{
				labelPatente = new JLabel();
				jPanel1.add(labelPatente, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				labelPatente.setText("Patente del cospel");
				labelPatente.setPreferredSize(new java.awt.Dimension(253, 40));
			}
			{
				boxPatente = new JComboBox();
				jPanel1.add(boxPatente, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				jPanel1.add(getBotonCargar(), new GridBagConstraints(3, 0, 1, 3, 0.0, 0.0, GridBagConstraints.LAST_LINE_END, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
				jPanel1.add(getImageLabel(), new GridBagConstraints(0, 0, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				iniciarPatentes();
				boxPatente.setPreferredSize(new java.awt.Dimension(103, 25));
			}
		}
		return jPanel1;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Tipo Cospel");
			jLabel2.setPreferredSize(new java.awt.Dimension(253, 40));
		}
		return jLabel2;
	}
	
	private JLabel getImageLabel() {
		if(imageLabel == null) {
			imageLabel = new JLabel();
			imageLabel.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
			imageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/cospel-altec.png")));
		}
		return imageLabel;
	}

}
