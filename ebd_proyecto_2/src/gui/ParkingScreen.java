package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.SwingUtilities;

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
public class ParkingScreen extends javax.swing.JFrame {
	private JPanel panelControles;
	private JPanel jPanel1;
	private JComboBox comboCospel;
	private JComboBox comboNroParq;
	private JComboBox comboCalle;
	private JLabel jLabel3;
	private JComboBox comboAltura;
	private JPanel jPanel5;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel panelParq;
	private ParkPanel parkPanel;
	private User me;
	private String calle;
	private String altura;

	public ParkingScreen(User user) {
		super();
		me = user;
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				panelParq = new JPanel();
				BorderLayout panelParqLayout = new BorderLayout();
				panelParq.setLayout(panelParqLayout);
				getContentPane().add(panelParq, BorderLayout.CENTER);
				panelParq.setBorder(BorderFactory.createTitledBorder(null,
						"Parquimetro", TitledBorder.LEADING,
						TitledBorder.DEFAULT_POSITION));

				parkPanel = new ParkPanel(this);
				panelParq.add(parkPanel, BorderLayout.CENTER);
				parkPanel.addMouseMotionListener(parkPanel);
				parkPanel.addMouseListener(parkPanel);
			}
			{
				panelControles = new JPanel();
				getContentPane().add(panelControles, BorderLayout.WEST);
				panelControles
						.setPreferredSize(new java.awt.Dimension(246, 670));
				panelControles.setBorder(BorderFactory
						.createTitledBorder("Controles"));
				{
					jPanel2 = new JPanel();
					panelControles.add(jPanel2);
					jPanel2.setPreferredSize(new java.awt.Dimension(230, 141));
					jPanel2.setBorder(BorderFactory
							.createTitledBorder("Seleccione parquimetro"));
					{
						jPanel3 = new JPanel();
						jPanel2.add(jPanel3);
						{
							jLabel1 = new JLabel();
							jPanel3.add(jLabel1);
							jLabel1.setText("Calle");
						}
						{
							comboCalle = new JComboBox();
							jPanel3.add(comboCalle);
							comboCalle.setPreferredSize(new java.awt.Dimension(
									70, 22));
							comboCalle.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									llenarAltura();
									llenarNroParq((String) comboCalle
											.getSelectedItem(),
											(String) comboAltura
													.getSelectedItem());
								}
							});
						}
					}
					{
						jPanel5 = new JPanel();
						jPanel2.add(jPanel5);
						{
							jLabel3 = new JLabel();
							jPanel5.add(jLabel3);
							jLabel3.setText("Altura");
						}
						{
							comboAltura = new JComboBox();
							comboAltura.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									llenarNroParq((String) comboCalle
											.getSelectedItem(),
											(String) comboAltura
													.getSelectedItem());
								}
							});
							jPanel5.add(comboAltura);
						}
					}
					{
						jPanel4 = new JPanel();
						jPanel2.add(jPanel4);
						{
							jLabel2 = new JLabel();
							jPanel4.add(jLabel2);
							jLabel2.setText("N° Parquimetro");
						}
						{
							comboNroParq = new JComboBox();
							jPanel4.add(comboNroParq);
						}
					}
				}
				{
					jPanel1 = new JPanel();
					panelControles.add(jPanel1);
					jPanel1.setBorder(BorderFactory
							.createTitledBorder("Seleccione cospel"));
					jPanel1.setPreferredSize(new java.awt.Dimension(229, 53));
					{
						ComboBoxModel comboCospelModel = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
						comboCospel = new JComboBox();
						jPanel1.add(comboCospel);
						comboCospel.setModel(comboCospelModel);
					}
				}
			}
			llenarCospeles();
			llenarCalle();
			llenarAltura();
			llenarNroParq((String) comboCalle.getSelectedItem(),
					(String) comboAltura.getSelectedItem());
			pack();
			setVisible(true);
			setSize(750, 700);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void llenarCospeles() {
		Result resu = me.execute("SELECT id_cospel FROM cospeles");
		DefaultComboBoxModel comb = new DefaultComboBoxModel();
		for (String[] row : resu) {
			comb.addElement(row[0]);
		}
		comboCospel.setModel(comb);
	}

	private void llenarCalle() {
		Result resu = me.execute("SELECT DISTINCT calle FROM ubicaciones");
		DefaultComboBoxModel comb = new DefaultComboBoxModel();
		for (String[] row : resu) {
			comb.addElement(row[0]);
		}
		comboCalle.setModel(comb);
	}

	private void llenarAltura() {
		Result resu = me
				.execute("SELECT altura FROM ubicaciones WHERE calle = '"
						+ comboCalle.getSelectedItem() + "'");
		DefaultComboBoxModel comb = new DefaultComboBoxModel();
		for (String[] row : resu) {
			comb.addElement(row[0]);
		}
		comboAltura.setModel(comb);
	}

	public void llenarNroParq(String calle, String alt) {
		Result resu = me
				.execute("SELECT id_parq FROM parquimetros where calle = '"
						+ calle + "' AND altura ='" + alt + "'");
		DefaultComboBoxModel comb = new DefaultComboBoxModel();
		for (String[] row : resu) {
			comb.addElement(row[0]);
		}
		comboNroParq.setModel(comb);
	}

	public void conectar() {
		Result res = me.execute("call conectar("
				+ comboCospel.getSelectedItem() + " ,"
				+ comboNroParq.getSelectedItem() + ")");
		String[] row = res.getCurrentRow();
		String msg = "";
		int msgtype = JOptionPane.INFORMATION_MESSAGE;
		if (row[0].equals("Apertura")) {
			if (row[1].equals("1")) {
				msg += "Entrada al estacionamiento.\nTiempo maximo: " + row[2]
						+ " minutos.";
			} else {
				msg += "No tiene suficiente saldo para estacionar";
				msgtype = JOptionPane.ERROR_MESSAGE;
			}
		} else {
			msg += "Salida del estacionamiento.\nTiempo transcurrido: "
					+ row[1] + " minutos.\nSu saldo es: $" + row[2] + ".";
		}
		JOptionPane.showMessageDialog(this, msg, "Parquimetro", msgtype);
	}

}
