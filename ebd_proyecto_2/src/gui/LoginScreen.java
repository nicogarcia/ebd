package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import logic.DBAccess;
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
public class LoginScreen extends javax.swing.JFrame {

	private static final Object USERNAME = new Object();
	private JButton selectedButton;
	private JButton botonEstacionar;
	private JPanel jPanel1;
	private JLabel labelLegajo;
	private JTextField textLegajo;
	private JLabel labelPassword;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel panelBotones;
	private JButton botonVenta;
	private JPasswordField textPassword;
	private JButton botonInspector;
	private JButton botonAdmin;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public LoginScreen() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(927, 382));

			// CENTER TO THE SCREEN
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation((screenSize.width - getPreferredSize().width) / 2,
					(screenSize.height - getPreferredSize().height) / 2);

			this.setVisible(true);
			{
				panelBotones = new JPanel();
				getContentPane().add(panelBotones, BorderLayout.CENTER);
				panelBotones.setPreferredSize(new java.awt.Dimension(969, 320));
				{
					botonAdmin = new JButton();
					panelBotones.add(botonAdmin);
					botonAdmin.setText("Administrador");
					botonAdmin.setSize(100, 22);
					botonAdmin
							.setPreferredSize(new java.awt.Dimension(200, 280));
					botonAdmin.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"img/gdu-encrypted-lock.png")));
					botonAdmin.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonClicked(evt, botonAdmin);
						}
					});
					botonAdmin.putClientProperty(USERNAME, "admin");
				}
				{
					botonInspector = new JButton();
					panelBotones.add(botonInspector);
					botonInspector.setText("Inspector");
					botonInspector.setSize(100, 22);
					botonInspector.setPreferredSize(new java.awt.Dimension(200,
							280));
					botonInspector.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/inspector.png")));
					botonInspector.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonClicked(evt, botonInspector);
						}
					});
					botonInspector.putClientProperty(USERNAME, "inspector");
				}
				{
					botonVenta = new JButton();
					panelBotones.add(botonVenta);
					botonVenta.setText("Venta");
					botonVenta.setSize(100, 22);
					botonVenta
							.setPreferredSize(new java.awt.Dimension(200, 280));
					botonVenta.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"img/emblem-sales.png")));
					botonVenta.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonClicked(evt, botonVenta);
						}
					});
					botonVenta.putClientProperty(USERNAME, "venta");
				}
				{
					botonEstacionar = new JButton();
					panelBotones.add(botonEstacionar);
					botonEstacionar.setText("Venta");
					botonEstacionar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/cartel.jpg")));
					botonEstacionar.setPreferredSize(new java.awt.Dimension(200, 280));
					botonEstacionar.setSize(100, 22);
					botonEstacionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonEstacionarActionPerformed(evt);
						}
					});
				}
				{
					jPanel1 = new JPanel();
					panelBotones.add(jPanel1);
					jPanel1.setPreferredSize(new java.awt.Dimension(457, 59));
					{
						jPanel2 = new JPanel();
						GridLayout jPanel2Layout = new GridLayout(2, 1);
						jPanel2Layout.setColumns(1);
						jPanel2Layout.setRows(2);
						jPanel2Layout.setHgap(5);
						jPanel2Layout.setVgap(5);
						jPanel1.add(jPanel2);
						jPanel2.setLayout(jPanel2Layout);
						jPanel2.setPreferredSize(new java.awt.Dimension(124, 43));
						{
							labelLegajo = new JLabel();
							jPanel2.add(labelLegajo);
							labelLegajo.setText("Legajo");
							labelLegajo
									.setPreferredSize(new java.awt.Dimension(
											103, 19));
							labelLegajo.setHorizontalAlignment(SwingConstants.CENTER);
						}
						{
							labelPassword = new JLabel();
							jPanel2.add(labelPassword);
							labelPassword.setText("Contraseña");
							labelPassword.setPreferredSize(new java.awt.Dimension(114, 19));
							labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
						}
					}
					{
						jPanel3 = new JPanel();
						GridLayout jPanel3Layout = new GridLayout(2, 1);
						jPanel3Layout.setColumns(1);
						jPanel3Layout.setRows(2);
						jPanel3Layout.setHgap(5);
						jPanel3Layout.setVgap(5);
						jPanel1.add(jPanel3);
						jPanel3.setLayout(jPanel3Layout);
						{
							textLegajo = new JTextField();
							jPanel3.add(textLegajo);
							textLegajo.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									textPasswordKeyTyped(evt);
								}
							});
							textLegajo.setPreferredSize(new java.awt.Dimension(
									152, 22));
						}
						{
							textPassword = new JPasswordField();
							jPanel3.add(textPassword);
							textPassword
									.setPreferredSize(new java.awt.Dimension(
											149, 22));
							textPassword.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									textPasswordKeyTyped(evt);
								}
							});
						}
					}
				}
			}
			buttonClicked(null, botonAdmin);
			pack();
			this.setSize(927, 382);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void buttonClicked(ActionEvent evt, JButton boton) {
		if (selectedButton != null)
			selectedButton.setBackground(null);
		hideLegajo(selectedButton == botonInspector);
		selectedButton = boton;
		selectedButton.setBackground(Color.yellow);
		textPassword.requestFocusInWindow();
		textPassword.selectAll();
		hideLegajo(selectedButton == botonInspector);
	}

	private void hideLegajo(boolean b) {
		textLegajo.setVisible(b);
		labelLegajo.setVisible(b);
		textLegajo.requestFocusInWindow();
		textLegajo.selectAll();
	}

	private void textPasswordKeyTyped(KeyEvent evt) {
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

			String username = (String) selectedButton
					.getClientProperty(USERNAME);
			boolean inspector = false;

			if (inspector = username.equals("inspector"))
				username = textLegajo.getText();

			User user = DBAccess.login(username,
					String.valueOf(textPassword.getPassword()), inspector);

			if (!user.isLogged()) {
				JOptionPane.showMessageDialog(this,
						"Nombre de usuario y/o contraseña invalidos", "Error",
						JOptionPane.ERROR_MESSAGE, null);
				textPassword.requestFocusInWindow();
				textPassword.selectAll();
			} else {
				user.startScreen();
				dispose();
			}
		}
	}
	
	private void botonEstacionarActionPerformed(ActionEvent evt) {
		new ParkingScreen(DBAccess.login("parquimetro","parq", false));
		dispose();
	}
}
