package gui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
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

	private final int width = 500;
	private final int height = 300;
	private JPanel panel;
	private JTextArea mensajeArea;
	private JScrollPane scrollPanel;
	private JTextArea textSaldo;
	private JLabel jLabel1;
	private JPanel panelTextSaldo;
	private JPanel labelSaldo;
	private JPanel panelMensajes;
	private JPanel panelSaldosaldo;
	private JComboBox boxTipoCospel;
	private JPanel panelPatente;
	private JPanel panelLabelCospel;
	private JButton botonCargar;
	private JPanel panelBoton;
	private JLabel labelCospel;
	private JPanel panelBoxCospel;
	private JComboBox boxPatente;
	private JLabel labelPatente;
	private JPanel panelBoxPatente;
	private JPanel panelLabelPatente;
	private JPanel panelSaldo;
	private JPanel panelCospel;

	private void initGui() {

		setTitle("Sistema de Parquimetros - Usuario: Vendedor");
		this.setPreferredSize(new java.awt.Dimension(496, 293));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			BorderLayout panelLayout = new BorderLayout();
			panel.setLayout(panelLayout);
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				panelSaldo = new JPanel();
				BorderLayout panelSaldoLayout = new BorderLayout();
				panelSaldo.setLayout(panelSaldoLayout);
				panel.add(panelSaldo, BorderLayout.SOUTH);
				panelSaldo.setPreferredSize(new java.awt.Dimension(490, 179));
				{
					panelSaldosaldo = new JPanel();
					BorderLayout panelSaldosaldoLayout = new BorderLayout();
					panelSaldosaldo.setLayout(panelSaldosaldoLayout);
					panelSaldo.add(panelSaldosaldo, BorderLayout.NORTH);
					panelSaldosaldo.setPreferredSize(new java.awt.Dimension(
							490, 38));
					panelSaldosaldo.setBorder(BorderFactory
							.createBevelBorder(BevelBorder.LOWERED));
					{
						labelSaldo = new JPanel();
						BorderLayout labelSaldoLayout = new BorderLayout();
						labelSaldo.setLayout(labelSaldoLayout);
						panelSaldosaldo.add(labelSaldo, BorderLayout.WEST);
						labelSaldo.setPreferredSize(new java.awt.Dimension(240,
								48));
						{
							jLabel1 = new JLabel();
							labelSaldo.add(jLabel1, BorderLayout.EAST);
							jLabel1.setText("Saldo");
							jLabel1.setPreferredSize(new java.awt.Dimension(
									194, 38));
						}
					}
					{
						panelTextSaldo = new JPanel();
						panelSaldosaldo.add(panelTextSaldo, BorderLayout.EAST);
						panelTextSaldo.setPreferredSize(new java.awt.Dimension(
								240, 48));
						{
							textSaldo = new JTextArea();
							panelTextSaldo.add(textSaldo);
							textSaldo.setPreferredSize(new java.awt.Dimension(
									87, 19));
							textSaldo.setBorder(new LineBorder(
									new java.awt.Color(0, 0, 0), 1, false));
						}
					}
				}
				{
					panelMensajes = new JPanel();
					BorderLayout panelMensajesLayout = new BorderLayout();
					panelMensajes.setLayout(panelMensajesLayout);
					panelSaldo.add(panelMensajes, BorderLayout.SOUTH);
					panelSaldo.add(getPanelBoton(), BorderLayout.CENTER);
					panelMensajes.setPreferredSize(new java.awt.Dimension(486,
							113));
					panelMensajes.add(getScrollPanel(), BorderLayout.CENTER);
				}
			}
			{
				panelPatente = new JPanel();
				panel.add(panelPatente, BorderLayout.NORTH);
				BorderLayout panelPatenteLayout = new BorderLayout();
				panelPatente.setLayout(panelPatenteLayout);
				panelPatente.setPreferredSize(new java.awt.Dimension(490, 42));
				panelPatente.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.LOWERED));
				{
					panelLabelPatente = new JPanel();
					BorderLayout panelLabelPatenteLayout = new BorderLayout();
					panelLabelPatente.setLayout(panelLabelPatenteLayout);
					panelPatente.add(panelLabelPatente, BorderLayout.WEST);
					panelLabelPatente.setPreferredSize(new java.awt.Dimension(
							234, 42));
					{
						labelPatente = new JLabel();
						panelLabelPatente.add(labelPatente, BorderLayout.EAST);
						labelPatente.setText("Patente del cospel");
						labelPatente.setPreferredSize(new java.awt.Dimension(
								184, 42));
					}
				}
				{
					panelBoxPatente = new JPanel();
					panelPatente.add(panelBoxPatente, BorderLayout.EAST);
					panelBoxPatente.setPreferredSize(new java.awt.Dimension(
							229, 42));
					{
						boxPatente = new JComboBox();
						panelBoxPatente.add(boxPatente);
						iniciarPatentes();
						boxPatente.setPreferredSize(new java.awt.Dimension(103,
								25));
					}
				}
			}
			{
				panelCospel = new JPanel();
				BorderLayout panelCospelLayout = new BorderLayout();
				panelCospel.setLayout(panelCospelLayout);
				panel.add(panelCospel, BorderLayout.CENTER);
				panelCospel.setPreferredSize(new java.awt.Dimension(490, 48));
				{
					panelLabelCospel = new JPanel();
					BorderLayout panelLabelCospelLayout = new BorderLayout();
					panelLabelCospel.setLayout(panelLabelCospelLayout);
					panelCospel.add(panelLabelCospel, BorderLayout.WEST);
					panelLabelCospel.setPreferredSize(new java.awt.Dimension(
							232, 54));
					{
						labelCospel = new JLabel();
						panelLabelCospel.add(labelCospel, BorderLayout.EAST);
						labelCospel.setText("Tipo de cospel");
						labelCospel.setPreferredSize(new java.awt.Dimension(
								185, 42));
					}
				}

				{
					panelBoxCospel = new JPanel();
					panelCospel.add(panelBoxCospel, BorderLayout.EAST);
					panelBoxCospel.setPreferredSize(new java.awt.Dimension(229,
							54));
					{
						boxTipoCospel = new JComboBox();
						panelBoxCospel.add(boxTipoCospel);
						iniciarCospelTipo();
						boxTipoCospel.setPreferredSize(new java.awt.Dimension(
								104, 26));
					}
				}
			}
		}

		pack();
		this.setSize(496, 293);
	}

	private JPanel getPanelBoton() {
		if (panelBoton == null) {
			panelBoton = new JPanel();
			panelBoton.add(getBotonCargar());
		}
		return panelBoton;
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
		return botonCargar;
	}

	/*
	 * Lista de posibles tipos de cospeles en la base de dato.
	 */
	private void iniciarCospelTipo() {
		Result res = me.execQuery("SELECT tipo FROM tipos_cospeles;");

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
		Result res = me.execQuery("SELECT patente FROM automoviles;");

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

				me.execInsert(sql);
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

}
