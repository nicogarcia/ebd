package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

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

	private JButton botonConectar;
	private JComboBox boxParquimetro;
	private JButton BotonIngresar;
	private JTextField textLetras;
	private JPanel panelTextos;
	private JLabel labelDia;
	private JLabel labelHora;
	private JPanel panelFecha;
	private JPanel panelHora;
	private JPanel panelFechaHora;
	private JPanel panelParquimetro;
	private JPanel panelTexto;
	private JPanel panelOperaciones;
	private JLabel labelF;
	private JTextArea mensajeTexto;
	private JScrollPane jScrollPane1;
	private JLabel labelH;
	private JPanel panelPrincipal;
	private InspectorUser me;
	private ThreadHorayFecha thread;
	private Hashtable<String, Integer> listaPatentes;

	private final int NOESTA = 9;

	public InspectorScreen(User user) {
		me = (InspectorUser) user;
		listaPatentes = new Hashtable<String, Integer>();
		initGui();
		thread = new ThreadHorayFecha(labelHora, labelDia);
		thread.start();
	}

	private void initGui() {

		setTitle("Sistema de Parquimetros - Usuario: inspector");
		this.setIconImage(new ImageIcon(getClass().getClassLoader()
				.getResource("img/cartel.jpg")).getImage());
		this.setPreferredSize(new java.awt.Dimension(763, 428));

		// CENTER TO THE SCREEN
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getPreferredSize().width) / 2,
				(screenSize.height - getPreferredSize().height) / 2);

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new CloseListener());
		{
			panelPrincipal = new JPanel();
			BorderLayout panelPrincipalLayout = new BorderLayout();
			getContentPane().add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setLayout(panelPrincipalLayout);
			panelPrincipal.setPreferredSize(new java.awt.Dimension(757, 123));
			{
				panelTexto = new JPanel();
				panelPrincipal.add(panelTexto, BorderLayout.CENTER);
				BorderLayout panelTextoLayout = new BorderLayout();
				panelTexto.setLayout(panelTextoLayout);
				panelTexto.setPreferredSize(new java.awt.Dimension(749, 329));
				{
					jScrollPane1 = new JScrollPane();
					panelTexto.add(jScrollPane1, BorderLayout.CENTER);
					{
						mensajeTexto = new JTextArea();
						jScrollPane1.setViewportView(mensajeTexto);
					}
				}
			}
			{
				panelOperaciones = new JPanel();
				panelPrincipal.add(panelOperaciones, BorderLayout.NORTH);
				BorderLayout panelOperacionesLayout = new BorderLayout();
				panelOperaciones.setLayout(panelOperacionesLayout);
				panelOperaciones.setPreferredSize(new java.awt.Dimension(749,
						54));
				{
					panelTextos = new JPanel();
					panelOperaciones.add(panelTextos, BorderLayout.EAST);
					panelTextos
							.setPreferredSize(new java.awt.Dimension(226, 65));
					panelTextos.setBorder(BorderFactory
							.createTitledBorder("Ingresar patente"));
					{
						textLetras = new JTextField();
						panelTextos.add(textLetras);
						textLetras.setPreferredSize(new java.awt.Dimension(84,
								22));
						textLetras.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent evt) {
								textLetrasKeyTyped(evt);
							}
						});
					}
					{
						BotonIngresar = new JButton();
						panelTextos.add(BotonIngresar);
						BotonIngresar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ingresarPatente();
							}
						});
						BotonIngresar.setText("Ingresar");
					}
				}
				{
					panelFechaHora = new JPanel();
					FlowLayout panelFechaHoraLayout = new FlowLayout();
					panelOperaciones.add(panelFechaHora, BorderLayout.WEST);
					panelFechaHora.setPreferredSize(new java.awt.Dimension(314,
							65));
					panelFechaHora.setLayout(panelFechaHoraLayout);
					panelFechaHora.setBorder(BorderFactory
							.createBevelBorder(BevelBorder.LOWERED));
					{
						panelHora = new JPanel();
						panelFechaHora.add(panelHora);
						panelHora.setPreferredSize(new java.awt.Dimension(142,
								39));
						{
							labelH = new JLabel();
							panelHora.add(labelH);
							labelH.setText("Hora:");
							labelH.setFont(new java.awt.Font("Andale Mono", 1,
									12));
						}
						{
							labelHora = new JLabel();
							panelHora.add(labelHora);
							labelHora.setPreferredSize(new java.awt.Dimension(
									78, 30));
						}
					}
					{
						panelFecha = new JPanel();
						panelFechaHora.add(panelFecha);
						FlowLayout panelFechaLayout = new FlowLayout();
						panelFecha.setPreferredSize(new java.awt.Dimension(137,
								39));
						panelFecha.setLayout(panelFechaLayout);
						{
							labelF = new JLabel();
							panelFecha.add(labelF);
							labelF.setText("Fecha:");
							labelF.setFont(new java.awt.Font("Andale Mono", 1,
									12));
						}
						{
							labelDia = new JLabel();
							panelFecha.add(labelDia);
							labelDia.setPreferredSize(new java.awt.Dimension(
									76, 29));
						}
					}
				}
				{
					panelParquimetro = new JPanel();
					panelOperaciones.add(panelParquimetro, BorderLayout.CENTER);
					FlowLayout panelParquimetroLayout = new FlowLayout();
					panelParquimetro.setLayout(panelParquimetroLayout);
					panelParquimetro.setPreferredSize(new java.awt.Dimension(
							226, 107));
					panelParquimetro.setBorder(BorderFactory
							.createTitledBorder("Conexión a parquimetro"));
					{
						boxParquimetro = new JComboBox();
						panelParquimetro.add(boxParquimetro);
						llenarParquimetros();
						boxParquimetro.setPreferredSize(new java.awt.Dimension(
								62, 22));
					}
					{
						botonConectar = new JButton();
						panelParquimetro.add(botonConectar);
						botonConectar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								botonConectarParquimetro(arg0);
							}
						});
						botonConectar.setText("Conectar");
						botonConectar.setPreferredSize(new java.awt.Dimension(
								109, 22));
					}
				}
			}
		}

		pack();
		this.setSize(763, 428);
	}

	public void ingresarPatente() {
		String patente = textLetras.getText();

		Pattern p = Pattern.compile("[A-Z][A-Z][A-Z][0-9][0-9][0-9]");

		// verifico que haya ingresado bien las letras de la patente
		if (p.matcher(patente).matches()) {
			listaPatentes.put(patente, NOESTA);
			mensajeTexto.setText(mensajeTexto.getText() + "Ingreso la patente "
					+ patente + " correctamente.\n\n");
		} else {
			mensajeTexto.setText(mensajeTexto.getText()
					+ "Ingreso una patente invalida. Intente nuevamente.\n\n");
		}
		textLetras.requestFocusInWindow();
		textLetras.setText("");
	}

	// verifica los estacionados y labra las multas
	public void botonConectarParquimetro(ActionEvent evt) {
		String parquimetro = (String) boxParquimetro.getSelectedItem();
		if (parquimetro != null && !parquimetro.equals("")) {
			registrarAcceso(parquimetro);
			determinarNoRegistrados(parquimetro);
			listaPatentes.clear();
		} else {
			mensajeTexto.setText(mensajeTexto.getText()
					+ "No puede acceder al parquimetro." + "\n\n");
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
				+ hora + "');";
		me.execute(sql);

		Result res = me
				.execute("SELECT id_asociado_con FROM asociado_con WHERE legajo = '"
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
						.execute("SELECT patente FROM estacionados NATURAL JOIN parquimetros WHERE id_parq =  '"
								+ parquimetro
								+ "' AND patente ='"
								+ entry.getKey() + "';");
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
				+ "', '"
				+ patente
				+ "', "
				+ me.getIDAsociadoCon() + ");";

		Result insertarMulta = me.execute(sql);
		Result ultimaMulta = me.execute("SELECT max(numero) FROM multa");
		Result direccionMulta = me
				.execute("SELECT calle, altura FROM parquimetros WHERE id_parq = '"
						+ parquimetro + "'");

		if (insertarMulta.hasFailed()) {
			mensajeTexto.setText(mensajeTexto.getText()
					+ "Error al labrar la multa de la patente " + patente
					+ "\n\n");
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
		String query = "SELECT id_parq FROM parquimetros natural join asociado_con WHERE turno='"
				+ turno()
				+ "' and dia ='"
				+ diaSemana()
				+ "' and legajo='"
				+ me.getUsuario() + "' ORDER BY id_parq";
		Result res = me.execute(query);

		DefaultComboBoxModel cbm = new DefaultComboBoxModel();

		if (!res.isEmpty()) {

			res.closeQuery();

			res = me.execute(query);

			for (String[] row : res) {
				cbm.addElement(row[0]);
			}

			boxParquimetro.setModel(cbm);
		} else {
			mensajeTexto
					.setText(mensajeTexto.getText()
							+ "Actualmente no hay parquimetros habilitados para este inspector\n");
		}
		res.closeQuery();
	}

	private String diaSemana() {
		Hashtable<Integer, String> dias = new Hashtable<Integer, String>(7);
		dias.put(Calendar.SUNDAY, "DO");
		dias.put(Calendar.MONDAY, "LU");
		dias.put(Calendar.TUESDAY, "MA");
		dias.put(Calendar.WEDNESDAY, "MI");
		dias.put(Calendar.THURSDAY, "JU");
		dias.put(Calendar.FRIDAY, "VI");
		dias.put(Calendar.SATURDAY, "SA");

		Calendar c = new GregorianCalendar();
		return dias.get(c.get(Calendar.DAY_OF_WEEK));

	}

	private String turno() {
		Calendar c = new GregorianCalendar();
		if (c.get(Calendar.HOUR_OF_DAY) >= 12)
			return "T";
		return "M";
	}

}
