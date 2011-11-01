package gui;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.SwingUtilities;


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
public class ParkingScreen extends javax.swing.JFrame {
	private JPanel panelControles;
	private JPanel jPanel1;
	private JComboBox comboCospel;
	private JComboBox comboNroParq;
	private JComboBox comboUbicacion;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel panelParq;
	private ParkPanel parkPanel;

	public ParkingScreen() {
		super();
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
				panelParq.setBorder(BorderFactory.createTitledBorder(null, "Parquimetro", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				
				parkPanel = new ParkPanel();
				panelParq.add(parkPanel, BorderLayout.CENTER);
				parkPanel.addMouseMotionListener(parkPanel);
				parkPanel.addMouseListener(parkPanel);
			}
			{
				panelControles = new JPanel();
				getContentPane().add(panelControles, BorderLayout.WEST);
				panelControles.setPreferredSize(new java.awt.Dimension(246, 670));
				panelControles.setBorder(BorderFactory.createTitledBorder("Controles"));
				{
					jPanel2 = new JPanel();
					panelControles.add(jPanel2);
					jPanel2.setPreferredSize(new java.awt.Dimension(230, 110));
					jPanel2.setBorder(BorderFactory.createTitledBorder("Seleccione parquimetro"));
					{
						jPanel3 = new JPanel();
						jPanel2.add(jPanel3);
						{
							jLabel1 = new JLabel();
							jPanel3.add(jLabel1);
							jLabel1.setText("Calle y Altura");
						}
						{
							ComboBoxModel comboUbicacionModel = 
									new DefaultComboBoxModel(
											new String[] { "Item One", "Item Two" });
							comboUbicacion = new JComboBox();
							jPanel3.add(comboUbicacion);
							comboUbicacion.setModel(comboUbicacionModel);
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
							ComboBoxModel comboNroParqModel = 
									new DefaultComboBoxModel(
											new String[] { "Item One", "Item Two" });
							comboNroParq = new JComboBox();
							jPanel4.add(comboNroParq);
							comboNroParq.setModel(comboNroParqModel);
						}
					}
				}
				{
					jPanel1 = new JPanel();
					panelControles.add(jPanel1);
					jPanel1.setBorder(BorderFactory.createTitledBorder("Seleccione cospel"));
					jPanel1.setPreferredSize(new java.awt.Dimension(229, 53));
					{
						ComboBoxModel comboCospelModel = 
								new DefaultComboBoxModel(
										new String[] { "Item One", "Item Two" });
						comboCospel = new JComboBox();
						jPanel1.add(comboCospel);
						comboCospel.setModel(comboCospelModel);
					}
				}
			}
			pack();
			setVisible(true);
			setSize(750, 700);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
