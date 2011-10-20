package gui;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import logic.Result;
import logic.User;
import logic.ThreadHorayFecha;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class InspectorScreen extends JFrame {
	
	
	private final int width = 500;
	private final int height = 300;
	private JPanel panelLogin;
	private JButton botonSalirSecion;
	private JButton botonConectar;
	private JComboBox boxParquimetro;
	private JLabel labelParquimetro;
	private JPanel panelParquimetroOtro;
	private JPanel panelOtro;
	private JButton BotonIngresar;
	private JTextField textNumeros;
	private JTextField textLetras;
	private JPanel panelBotonAgregar;
	private JLabel labelNumerosPatente;
	private JLabel labelLetrasPatente;
	private JPanel panelTextos;
	private JPanel panelCampos;
	private JLabel labelDia;
	private JLabel labelHora;
	private JPanel panelFecha;
	private JPanel panelHora;
	private JPanel panelFechaHora;
	private JPanel panelParquimetro;
	private JPanel panelIngreso;
	private JTextArea mensajeTexto;
	private JScrollPane panelScrollTexto;
	private JButton botonLogin;
	private JPasswordField textPass;
	private JLabel labelPassword;
	private JPanel panelTextoContra;
	private JPanel panelSeparadorContraseña;
	private JPanel panelSeparadorUsuario;
	private JPanel panelLabelContra;
	private JTextField textUsuario;
	private JLabel labelUsuario;
	private JPanel panelBotonUsuario;
	private JPanel panelContrasenia;
	private JPanel panelUsuario;
	private JPanel panelTexto;
	private JPanel panelOperaciones;
	private JPanel panelPrincipal;
	private User me;
	private ThreadHorayFecha thread;
	private Vector<String> patentes;
	private int legajo;
	private int IDAsociadoCon;
	
	
	public InspectorScreen(User user) {
		me = user;
		patentes = new Vector<String>();
		initGui();
		thread = new ThreadHorayFecha(labelHora,labelDia);
		thread.start();
		patentes = new Vector<String>();
	}

	private void initGui() {

		setTitle("Sistema de Parquimetros - Usuario: Inspector");
		this.setPreferredSize(new java.awt.Dimension(767, 334));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		{
			panelPrincipal = new JPanel();
			BorderLayout panelPrincipalLayout = new BorderLayout();
			getContentPane().add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setLayout(panelPrincipalLayout);
			panelPrincipal.setPreferredSize(new java.awt.Dimension(425, 242));
			{
				panelLogin = new JPanel();
				panelPrincipal.add(panelLogin, BorderLayout.WEST);
				BorderLayout panelLoginLayout = new BorderLayout();
				panelLogin.setLayout(panelLoginLayout);
				panelLogin.setPreferredSize(new java.awt.Dimension(149, 304));
				{
					panelUsuario = new JPanel();
					BorderLayout panelUsuarioLayout = new BorderLayout();
					panelUsuario.setLayout(panelUsuarioLayout);
					panelLogin.add(panelUsuario, BorderLayout.NORTH);
					panelUsuario.setPreferredSize(new java.awt.Dimension(149, 90));
					{
						textUsuario = new JTextField();
						panelUsuario.add(textUsuario, BorderLayout.CENTER);
						textUsuario.setPreferredSize(new java.awt.Dimension(149, 29));
						textUsuario.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					}
					{
						labelUsuario = new JLabel();
						panelUsuario.add(labelUsuario, BorderLayout.NORTH);
						labelUsuario.setPreferredSize(new java.awt.Dimension(149, 31));
						labelUsuario.setText("Legajo");
						labelUsuario.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					}
					{
						panelSeparadorUsuario = new JPanel();
						panelUsuario.add(panelSeparadorUsuario, BorderLayout.SOUTH);
						panelSeparadorUsuario.setPreferredSize(new java.awt.Dimension(149, 28));
					}
				}
				{
					panelContrasenia = new JPanel();
					BorderLayout panelContraseniaLayout = new BorderLayout();
					panelContrasenia.setLayout(panelContraseniaLayout);
					panelLogin.add(panelContrasenia, BorderLayout.CENTER);
					panelContrasenia.setPreferredSize(new java.awt.Dimension(149, 110));
					{
						panelLabelContra = new JPanel();
						BorderLayout panelLabelContraLayout = new BorderLayout();
						panelLabelContra.setLayout(panelLabelContraLayout);
						panelContrasenia.add(panelLabelContra, BorderLayout.NORTH);
						panelLabelContra.setPreferredSize(new java.awt.Dimension(149, 36));
						{
							labelPassword = new JLabel();
							panelLabelContra.add(labelPassword, BorderLayout.CENTER);
							labelPassword.setText("Contraseña");
							labelPassword.setPreferredSize(new java.awt.Dimension(149, 34));
							labelPassword.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						}
					}
					{
						panelSeparadorContraseña = new JPanel();
						panelContrasenia.add(panelSeparadorContraseña, BorderLayout.SOUTH);
						panelSeparadorContraseña.setPreferredSize(new java.awt.Dimension(149, 40));
					}
					{
						panelTextoContra = new JPanel();
						BorderLayout panelTextoContraLayout = new BorderLayout();
						panelTextoContra.setLayout(panelTextoContraLayout);
						panelContrasenia.add(panelTextoContra, BorderLayout.CENTER);
						panelTextoContra.setPreferredSize(new java.awt.Dimension(149, 34));
						{
							textPass = new JPasswordField();
							panelTextoContra.add(textPass, BorderLayout.CENTER);
							textPass.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						}
					}
				}
				{
					panelBotonUsuario = new JPanel();
					FlowLayout panelBotonUsuarioLayout = new FlowLayout();
					panelLogin.add(panelBotonUsuario, BorderLayout.SOUTH);
					panelBotonUsuario.setPreferredSize(new java.awt.Dimension(149, 110));
					panelBotonUsuario.setLayout(panelBotonUsuarioLayout);
					{
						botonLogin = new JButton();
						panelBotonUsuario.add(botonLogin);
						botonLogin.setText("Ingresar");
						botonLogin.setPreferredSize(new java.awt.Dimension(97, 31));
						botonLogin.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
		                    botonIniciarSesion(evt);} });
					}
					{
						botonSalirSecion = new JButton();
						panelBotonUsuario.add(botonSalirSecion);
						botonSalirSecion.setText("Salir de la secion");
						botonSalirSecion.setPreferredSize(new java.awt.Dimension(161, 22));
						botonSalirSecion.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
		                    botonCerrarSecion(evt);
		                 } });
					}
				}
			}
			{
				panelOperaciones = new JPanel();
				panelPrincipal.add(panelOperaciones, BorderLayout.CENTER);
				BorderLayout panelOperacionesLayout = new BorderLayout();
				panelOperaciones.setLayout(panelOperacionesLayout);
				panelOperaciones.setPreferredSize(new java.awt.Dimension(291, 182));
				{
					panelIngreso = new JPanel();
					BorderLayout panelIngresoLayout = new BorderLayout();
					panelIngreso.setLayout(panelIngresoLayout);
					panelOperaciones.add(panelIngreso, BorderLayout.CENTER);
					panelIngreso.setPreferredSize(new java.awt.Dimension(396, 140));
					{
						panelCampos = new JPanel();
						FlowLayout panelCamposLayout = new FlowLayout();
						panelIngreso.add(panelCampos, BorderLayout.NORTH);
						panelCampos.setPreferredSize(new java.awt.Dimension(396, 29));
						panelCampos.setLayout(panelCamposLayout);
						{
							labelLetrasPatente = new JLabel();
							panelCampos.add(labelLetrasPatente);
							labelLetrasPatente.setText("Letras");
							labelLetrasPatente.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
							labelLetrasPatente.setPreferredSize(new java.awt.Dimension(58, 19));
						}
						{
							labelNumerosPatente = new JLabel();
							panelCampos.add(labelNumerosPatente);
							labelNumerosPatente.setText("Numeros");
							labelNumerosPatente.setPreferredSize(new java.awt.Dimension(72, 19));
							labelNumerosPatente.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						}
					}
					{
						panelTextos = new JPanel();
						panelIngreso.add(panelTextos, BorderLayout.CENTER);
						panelTextos.setPreferredSize(new java.awt.Dimension(396, 31));
						{
							textLetras = new JTextField();
							panelTextos.add(textLetras);
							textLetras.setPreferredSize(new java.awt.Dimension(77, 22));
						}
						{
							textNumeros = new JTextField();
							panelTextos.add(textNumeros);
							textNumeros.setPreferredSize(new java.awt.Dimension(73, 22));
						}
					}
					{
						panelBotonAgregar = new JPanel();
						panelIngreso.add(panelBotonAgregar, BorderLayout.SOUTH);
						panelBotonAgregar.setPreferredSize(new java.awt.Dimension(396, 29));
						{
							BotonIngresar = new JButton();
							panelBotonAgregar.add(BotonIngresar);
							BotonIngresar.setText("Ingresar Patente");
							BotonIngresar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
			                    ingresarPatente(evt);} });
							
						}
					}
				}
				{
					panelFechaHora = new JPanel();
					FlowLayout panelFechaHoraLayout = new FlowLayout();
					panelOperaciones.add(panelFechaHora, BorderLayout.NORTH);
					panelFechaHora.setPreferredSize(new java.awt.Dimension(396, 46));
					panelFechaHora.setLayout(panelFechaHoraLayout);
					panelFechaHora.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					{
						panelHora = new JPanel();
						panelFechaHora.add(panelHora);
						panelHora.setPreferredSize(new java.awt.Dimension(134, 39));
						{
							labelHora = new JLabel();
							panelHora.add(labelHora);
							labelHora.setPreferredSize(new java.awt.Dimension(78, 30));
							labelHora.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
						}
					}
					{
						panelFecha = new JPanel();
						FlowLayout panelFechaLayout = new FlowLayout();
						panelFechaHora.add(panelFecha);
						panelFecha.setPreferredSize(new java.awt.Dimension(135, 37));
						panelFecha.setLayout(panelFechaLayout);
						{
							labelDia = new JLabel();
							panelFecha.add(labelDia);
							labelDia.setPreferredSize(new java.awt.Dimension(98, 29));
							labelDia.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
						}
					}
				}
				{
					panelParquimetro = new JPanel();
					BorderLayout panelParquimetroLayout = new BorderLayout();
					panelParquimetro.setLayout(panelParquimetroLayout);
					panelOperaciones.add(panelParquimetro, BorderLayout.SOUTH);
					panelParquimetro.setPreferredSize(new java.awt.Dimension(396, 167));
					{
						panelOtro = new JPanel();
						panelParquimetro.add(panelOtro, BorderLayout.NORTH);
						panelOtro.setPreferredSize(new java.awt.Dimension(396, 77));
						panelOtro.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						{
							labelParquimetro = new JLabel();
							panelOtro.add(labelParquimetro);
							labelParquimetro.setText("conección a parquimetro");
							labelParquimetro.setPreferredSize(new java.awt.Dimension(205, 21));
							labelParquimetro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
						}
						{
							ComboBoxModel boxParquimetroModel = new DefaultComboBoxModel(llenarParquimetros());
							boxParquimetro = new JComboBox();
							panelOtro.add(boxParquimetro);
							boxParquimetro.setModel(boxParquimetroModel);
							boxParquimetro.setPreferredSize(new java.awt.Dimension(95, 22));
						}
						{
							botonConectar = new JButton();
							panelOtro.add(botonConectar);
							botonConectar.setText("Conectar con parquimetro");
							botonConectar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
				                    botonConectarParquimetro(evt);
				                 }
				              });
						}
					}
					{
						panelParquimetroOtro = new JPanel();
						panelParquimetro.add(panelParquimetroOtro, BorderLayout.CENTER);
						panelParquimetroOtro.setPreferredSize(new java.awt.Dimension(396, 88));
					}
				}
			}
			{
				panelTexto = new JPanel();
				panelPrincipal.add(panelTexto, BorderLayout.EAST);
				BorderLayout panelTextoLayout = new BorderLayout();
				panelTexto.setLayout(panelTextoLayout);
				panelTexto.setPreferredSize(new java.awt.Dimension(212, 304));
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
		}

		pack();
		this.setSize(767, 334);
		habilitar(false);
	}
	
	
	public void ingresarPatente(ActionEvent evt){
		String numero,letra;
		if (textNumeros.getText()!=null && !textNumeros.getText().equals("") && textLetras.getText()!=null && !textLetras.getText().equals("") ){
			numero = textNumeros.getText();
			letra = textLetras.getText();
			//verifico que haya ingresado bien las letras de la patente
			if (letra.length()==3){
				//verifico que haya tres numeros
				if (numero.length()==3 && esNumero(numero)){
					patentes.add(letra.concat(numero));
					textNumeros.setText("");
					textLetras.setText("");
					mensajeTexto.setText(mensajeTexto.getText()+"Ingreso la patente "+letra.concat(numero)+".\n");
				}else{mensajeTexto.setText(mensajeTexto.getText()+"Ingreso mal el numero de la patente.\n"); textNumeros.setText(""); }
			}else{mensajeTexto.setText(mensajeTexto.getText()+"Ingreso mal las letras de la patente.\n"); textLetras.setText(""); }
			
		}else {mensajeTexto.setText(mensajeTexto.getText()+"Ingreso mal las letras y el número de la patente.\n"); textNumeros.setText(""); textLetras.setText("");}
	}
	
	//verificador de numeros
	private boolean esNumero(String n){
		try{
			int num = Integer.parseInt(n);
			return true;
		}catch(NumberFormatException e){
			return false;}
	}
	
	//verifica los estacionados y labra las multas
	public void botonConectarParquimetro(ActionEvent evt){
		String parquimetro = (String) boxParquimetro.getSelectedItem();
		int parquiId = Integer.parseInt(parquimetro);
		System.out.println("Paso por aca 1");System.out.println("Parquimetro "+parquiId);
		registrarAcceso(parquiId);
		 System.out.println("Paso por aca 5");
		determinarNoRegistrados(parquiId);
		patentes.clear();
	}
	
	
	private void registrarAcceso(int parq){
		 try
	      {
			 String fecha,hora;
			 fecha = labelDia.getText();
			 hora = labelHora.getText();
			 System.out.println("Paso por aca 2");
			 String sql = "INSERT INTO `accede` (`legajo`, `id_parq`, `fecha`, `hora`) VALUES ("+legajo+", "+parq+", '"+fecha+"', '"+hora+":00');";
	         me.insertar(sql);
	         System.out.println("Paso por aca 3");
	         //obtengo el asociado con el inspector
	         Result re = me.execQuery("SELECT id_asociado_con  FROM asociado_con WHERE legajo= '"+legajo+"';");
	         Vector<String> IDasociado = new Vector<String>();
	         System.out.println("Paso por aca 4");
	         for (String[] row:re){
	        	 for (int j=0;j<row.length;j++)
	 				IDasociado.add(row[j]);
	         }
	         IDAsociadoCon =Integer.parseInt(IDasociado.lastElement());
	         mensajeTexto.setText(mensajeTexto.getText()+"Ha ingresado en el parquímetro "+parq+" a las "+hora+" del día "+fecha+".\n");
	      }
	      catch (SQLException ex){
	    	  System.out.println("El error está aca.");
	      }
	}
	
	private void determinarNoRegistrados(int id_parq){
		System.out.println("Paso por aca 6");
		String fecha,hora;
		fecha = labelDia.getText();
		hora = labelHora.getText();		
		System.out.println("Paso por aca 7");
		for (String pat: patentes){
			if(me.execQuery("SELECT patente FROM estacionados NATURAL JOIN parquimetros WHERE id_parq =  '"+id_parq+"' AND patente = '"+pat+"';").isEmpty())
				generarMulta (pat,id_parq,fecha,hora);
		}		
	}
	
	
	private void generarMulta(String patente,int parq,String fecha,String hora){
		System.out.println("Paso por aca 8");
		String sql = "INSERT INTO `multa` (`numero`, `fecha`, `hora`, `patente`, `id_asociado_con`) VALUES (NULL, '"+fecha+"', '"+hora+":00', '"+patente+"', "+IDAsociadoCon+");";
		try {
			me.insertar(sql);
			//obtengo la multa recien insertada con la calle y altura
			Result res = me.execQuery("SELECT max(numero) FROM multa;");
			Result res2 = me.execQuery("SELECT calle,altura FROM parquimetros WHERE id_parq= '"+parq+"';");
			Vector<String> multavec= new Vector<String>();
			for (String[] row: res){
				for (int j=0;j<row.length;j++)
					multavec.add(row[j]);
			} Vector<String> callAlVec= new Vector<String>();
			for (String[] row: res2){
				for (int j=0;j<row.length;j++)
					callAlVec.add(row[j]);
			}
			mensajeTexto.setText(mensajeTexto.getText()+"Multa numero "+multavec.firstElement()+" en el vehiculo con patente "+patente+" a las "+hora+" del día "+fecha+" en la calle "+callAlVec.get(0)+" altura "+callAlVec.get(1)+".\n");
		} catch (SQLException e) {
			mensajeTexto.setText(mensajeTexto.getText()+"Error al labrar la multa de la patente "+patente+".\n");
		}
	}
	
	public void botonIniciarSesion(ActionEvent evt){		
		if (textUsuario.getText()!=null && !textUsuario.getText().equals("") ){
			String leg,pass;
			leg=textUsuario.getText();
			pass=textPass.getText();
			 Result re = me.execQuery("SELECT PASSWORD FROM inspectores WHERE legajo = '"+leg+"'");
	         Vector<String> contra = new Vector<String>();
	         for (String[] row:re){
	        	 for (int j=0;j<row.length;j++)
	 				contra.add(row[j]);
	         }
	         if (contra.lastElement().equals(pass)){
	        	habilitar(true);
	        	mensajeTexto.setText(mensajeTexto.getText()+"Ha ingresa con el legajo "+leg+".\n");
	        	legajo=Integer.parseInt(leg);
	         }else {
	        	 mensajeTexto.setText(mensajeTexto.getText()+"Ha ingresa mal el legajo o contraseña .\n");
	        	 textPass.setText("");
	         }
		}else {
			mensajeTexto.setText(mensajeTexto.getText()+"Ha ingresa mal el legajo o contraseña .\n");
       	 	textPass.setText("");
		}
	}
	
	private void habilitar(boolean h) {		
			textLetras.setEnabled(h);
			textNumeros.setEnabled(h);
			BotonIngresar.setEnabled(h);
			boxParquimetro.setEnabled(h);
			botonConectar.setEnabled(h);
			botonSalirSecion.setEnabled(h);
			textUsuario.setEnabled(!h);
			textPass.setEnabled(!h);
			botonLogin.setEnabled(!h);		
	}
	
	public void botonCerrarSecion(ActionEvent evt){
		habilitar(false);
		patentes.clear();
		IDAsociadoCon=0;
	}
	
	private String [] llenarParquimetros(){
		Result res = me.execQuery("SELECT id_parq FROM parquimetros;");
		Vector<String> vector= new Vector<String>();
		for (String[] row: res){
			for (int j=0;j<row.length;j++)
				vector.add(row[j]);
		}
		String[] stringParquimetros = new String[vector.size()];
		int i=0;
		for (String row: vector){
			stringParquimetros[i]=row;
			i++;
		}
		return stringParquimetros;
}
	

}
