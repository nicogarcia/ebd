package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logic.InspectorUser;
import logic.Result;
import logic.ThreadHorayFecha;
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
public class InspectorScreen extends JFrame {

	private final int width = 500;
	private final int height = 300;
	private JButton botonConectar;
	private JComboBox boxParquimetro;
	private JLabel labelParquimetro;
	private JButton BotonIngresar;
	private JTextField textLetras;
	private JPanel panelTextos;
	private JLabel labelDia;
	private JLabel labelHora;
	private JPanel panelFecha;
	private JPanel panelHora;
	private JPanel panelFechaHora;
	private JPanel panelParquimetro;
	private JPanel panelIngreso;
	private JTextArea mensajeTexto;
	private JScrollPane panelScrollTexto;
	private JPanel panelTexto;
	private JPanel panelOperaciones;
	private JPanel panelPrincipal;
	private InspectorUser me;
	private ThreadHorayFecha thread;
	private Hashtable<String, Integer> listaPatentes;

	private final int ESTA = 7;
	private final int NOESTA = 9;

	public InspectorScreen(User user) {
		me = (InspectorUser) user;
		listaPatentes = new Hashtable<String, Integer>();
		initGui();
		thread = new ThreadHorayFecha(labelHora, labelDia);
		thread.start();
	}

	private void initGui() {

		setTitle("Sistema de Parquimetros - Usuario: Inspector");
		this.setPreferredSize(new java.awt.Dimension(759, 424));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		{
			panelPrincipal = new JPanel();
			BorderLayout panelPrincipalLayout = new BorderLayout();
			getContentPane().add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setLayout(panelPrincipalLayout);
			panelPrincipal.setPreferredSize(new java.awt.Dimension(757, 123));
			{
				panelTexto = new JPanel();
				panelPrincipal.add(panelTexto, BorderLayout.SOUTH);
				BorderLayout panelTextoLayout = new BorderLayout();
				panelTexto.setLayout(panelTextoLayout);
				panelTexto.setPreferredSize(new java.awt.Dimension(749, 287));
				{
					panelScrollTexto = new JScrollPane();
					panelTexto.add(panelScrollTexto, BorderLayout.CENTER);
					{
						mensajeTexto = new JTextArea();
						panelScrollTexto.setViewportView(mensajeTexto);
						mensajeTexto.setEditable(false);
					}
				}
			}
			{
				panelOperaciones = new JPanel();
				panelPrincipal.add(panelOperaciones, BorderLayout.CENTER);
				BorderLayout panelOperacionesLayout = new BorderLayout();
				panelOperaciones.setLayout(panelOperacionesLayout);
				panelOperaciones.setPreferredSize(new java.awt.Dimension(749, 218));
				{
					panelIngreso = new JPanel();
					BorderLayout panelIngresoLayout = new BorderLayout();
					panelIngreso.setLayout(panelIngresoLayout);
					panelOperaciones.add(panelIngreso, BorderLayout.EAST);
					panelIngreso.setPreferredSize(new java.awt.Dimension(161, 305));
					{
						panelTextos = new JPanel();
						panelIngreso.add(panelTextos, BorderLayout.CENTER);
						panelTextos.setPreferredSize(new java.awt.Dimension(578, 305));
						{
							textLetras = new JTextField();
							panelTextos.add(textLetras);
							textLetras.setPreferredSize(new java.awt.Dimension(
									77, 22));
							textLetras.addKeyListener(new KeyAdapter() {
								public void keyTyped(KeyEvent evt) {
									textLetrasKeyTyped(evt);
								}
							});
						}
						{
							BotonIngresar = new JButton();
							panelTextos.add(BotonIngresar);
							BotonIngresar
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent arg0) {
											ingresarPatente();
										}
									});
							BotonIngresar.setText("Ingresar Patente");
						}
					}
				}
				{
					panelFechaHora = new JPanel();
					FlowLayout panelFechaHoraLayout = new FlowLayout();
					panelOperaciones.add(panelFechaHora, BorderLayout.WEST);
					panelFechaHora.setPreferredSize(new java.awt.Dimension(126, 305));
					panelFechaHora.setLayout(panelFechaHoraLayout);
					panelFechaHora.setBorder(new LineBorder(new java.awt.Color(
							0, 0, 0), 1, false));
					{
						panelHora = new JPanel();
						panelFechaHora.add(panelHora);
						panelHora.setPreferredSize(new java.awt.Dimension(104, 39));
						{
							labelHora = new JLabel();
							panelHora.add(labelHora);
							labelHora.setPreferredSize(new java.awt.Dimension(
									78, 30));
							labelHora.setBorder(BorderFactory
									.createMatteBorder(1, 1, 1, 1,
											new java.awt.Color(0, 0, 0)));
						}
					}
					{
						panelFecha = new JPanel();
						FlowLayout panelFechaLayout = new FlowLayout();
						panelFechaHora.add(panelFecha);
						panelFecha.setPreferredSize(new java.awt.Dimension(113, 37));
						panelFecha.setLayout(panelFechaLayout);
						{
							labelDia = new JLabel();
							panelFecha.add(labelDia);
							labelDia.setPreferredSize(new java.awt.Dimension(
									98, 29));
							labelDia.setBorder(BorderFactory.createMatteBorder(
									1, 1, 1, 1, new java.awt.Color(0, 0, 0)));
						}
					}
				}
				{
					panelParquimetro = new JPanel();
					FlowLayout panelParquimetroLayout = new FlowLayout();
					panelParquimetro.setLayout(panelParquimetroLayout);
					panelOperaciones.add(panelParquimetro, BorderLayout.CENTER);
					panelParquimetro.setPreferredSize(new java.awt.Dimension(462, 233));
					{
						labelParquimetro = new JLabel();
						panelParquimetro.add(labelParquimetro);
						labelParquimetro.setText("conección a parquimetro");
						labelParquimetro.setPreferredSize(new java.awt.Dimension(170, 21));
						labelParquimetro.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					}
					{
						boxParquimetro = new JComboBox();
						panelParquimetro.add(boxParquimetro);
						llenarParquimetros();
						boxParquimetro
						.setPreferredSize(new java.awt.Dimension(
								95, 22));
					}
					{
						botonConectar = new JButton();
						panelParquimetro.add(botonConectar);
						botonConectar
						.addActionListener(new ActionListener() {
							public void actionPerformed(
									ActionEvent arg0) {
								botonConectarParquimetro(arg0);
							}
						});
						botonConectar.setText("Conectar con parquimetro");
					}
				}
			}
		}

		pack();
		this.setSize(759, 424);
	}

	public void ingresarPatente() {
		String patente = textLetras.getText();

		Pattern p = Pattern.compile("[A-Z][A-Z][A-Z][0-9][0-9][0-9]");

		// verifico que haya ingresado bien las letras de la patente
		if (p.matcher(patente).matches()) {
			listaPatentes.put(patente, NOESTA);
			mensajeTexto.setText(mensajeTexto.getText()
					+ "Ingreso la patente " + patente + " correctamente.\n\n");
		} else {
			mensajeTexto.setText(mensajeTexto.getText()
					+ "Ingreso una patente invalida. Intente nuevamente.\n\n");
		}
		textLetras.requestFocusInWindow();
		textLetras.setText("");
	}

	// verifica los estacionados y labra las multas
	public void botonConectarParquimetro(ActionEvent evt) {
		if (!listaPatentes.isEmpty()) {
			String parquimetro = (String) boxParquimetro.getSelectedItem();
			registrarAcceso(parquimetro);
			determinarNoRegistrados(parquimetro);
			listaPatentes.clear();
		}
	}

	private void registrarAcceso(String parquimetro) {
		String fecha, hora;
		fecha = labelDia.getText();
		hora = labelHora.getText();
		String sql = "INSERT INTO `accede` (`legajo`, `id_parq`, `fecha`, `hora`) VALUES ("
				+ me.getUsuario()
				+ ", "
				+ parquimetro
				+ ", '"
				+ fecha
				+ "', '"
				+ hora + ":00');";
		me.execInsert(sql);

		// FIXME asociado_con: hay q controlarlo? puede ingresar si no esta
		// asociado?
		// obtengo lo que inserté recién
		Result res = me
				.execQuery("SELECT id_asociado_con FROM asociado_con WHERE legajo = '"
						+ me.getUsuario() + "'");

		me.setIDAsociadoCon(Integer.parseInt(res.getCurrentRow()[0]));

		if (!res.hasFailed())
			mensajeTexto.setText(mensajeTexto.getText()
					+ "Ha ingresado en el parquímetro " + parquimetro
					+ " a las " + hora + " del día " + fecha + ".\n\n");
		else
			mensajeTexto.setText(mensajeTexto.getText()
					+ "Error al ingresar al parquimetro.\n\n");

		res.closeQuery();
	}

	private void determinarNoRegistrados(String parquimetro) {
		String fecha, hora;
		fecha = labelDia.getText();
		hora = labelHora.getText();

		for (Entry<String, Integer> entry : listaPatentes.entrySet()) {
			if (entry.getValue() == NOESTA) {
				Result res = me
						.execQuery("SELECT patente FROM estacionados NATURAL JOIN parquimetros WHERE id_parq =  '"
								+ parquimetro + "';");
				if (res.isEmpty())
					generarMulta(entry.getKey(), parquimetro, fecha, hora);
				res.closeQuery();
			}
		}
	}

	private void generarMulta(String patente, String parquimetro, String fecha,
			String hora) {
		String sql = "INSERT INTO `multa` (`numero`, `fecha`, `hora`, `patente`, `id_asociado_con`) VALUES (NULL, '"
				+ fecha
				+ "', '"
				+ hora
				+ ":00', '"
				+ patente
				+ "', "
				+ me.getIDAsociadoCon() + ");";

		boolean insertCorrect = me.execInsert(sql);
		Result ultimaMulta = me.execQuery("SELECT max(numero) FROM multa");
		Result direccionMulta = me
				.execQuery("SELECT calle, altura FROM parquimetros WHERE id_parq = '"
						+ parquimetro + "'");

		if (!insertCorrect) {
			mensajeTexto.setText(mensajeTexto.getText()
					+ "Error al labrar la multa de la patente " + patente + "\n\n");
		} else {
			mensajeTexto.setText(mensajeTexto.getText() + "Multa numero "
					+ ultimaMulta.getCurrentRow()[0]
					+ " en el vehiculo con patente " + patente + " a las "
					+ hora + " del día " + fecha + " en la calle "
					+ direccionMulta.getCurrentRow()[0] + " al "
					+ direccionMulta.getCurrentRow()[1] + ".\n\n");
		}

		ultimaMulta.closeQuery();
		direccionMulta.closeQuery();
	}

	private void textLetrasKeyTyped(KeyEvent evt) {
		if (textLetras.getText().length() == 6) {
			if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
				ingresarPatente();
			} else {
				evt.setKeyChar('\0');
			}
		}

		if (evt.getKeyChar() >= 'a' && evt.getKeyChar() <= 'z') {
			evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
		}
	}

	private void llenarParquimetros() {
		Result res = me.execQuery("SELECT id_parq FROM parquimetros;");
		DefaultComboBoxModel cbm = new DefaultComboBoxModel();

		for (String[] row : res) {
			cbm.addElement(row[0]);
		}

		boxParquimetro.setModel(cbm);

		res.closeQuery();
	}

	// FIXME Agregar cerrar sesion

}
