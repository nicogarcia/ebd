package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
public class AdminScreen extends JFrame implements ActionListener,
		ListSelectionListener {

	User me;

	public AdminScreen(User user) {
		me = user;
		initGui();
	}

	private void initGui() {

		runQuery = new JButton("Ejecutar");
		runQuery.addActionListener(this);

		queryPane = new JPanel(new BorderLayout());
		queryPane.add(runQuery, BorderLayout.EAST);
		addWindowListener(new CloseListener());
		{
			jPanel1 = new JPanel();
			BorderLayout jPanel1Layout = new BorderLayout();
			jPanel1.setLayout(jPanel1Layout);
			queryPane.add(jPanel1, BorderLayout.CENTER);
			{
				jScrollPane1 = new JScrollPane();
				jPanel1.add(jScrollPane1, BorderLayout.CENTER);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(610, 80));
				jScrollPane1.setAutoscrolls(true);
				{
					queryText = new JTextArea();
					queryText.setText("select * from automoviles");
					jScrollPane1.setViewportView(queryText);
				}
			}
		}

		resultPane = new JPanel(new BorderLayout());

		resultTableModel = new DefaultTableModel();

		tablesPane = new JPanel(new BorderLayout());
		BorderLayout tablesPaneLayout = new BorderLayout();

		setLayout(new BorderLayout());

		add(queryPane, BorderLayout.NORTH);
		queryPane.setBorder(BorderFactory.createTitledBorder("Consultas SQL"));
		queryPane.setPreferredSize(new java.awt.Dimension(686, 115));
		add(resultPane, BorderLayout.CENTER);
		{
			panelScroll = new JScrollPane();
			resultPane.add(panelScroll, BorderLayout.CENTER);
			{
				result = new JTable(resultTableModel);
				panelScroll.setViewportView(result);
			}
		}
		resultHeader = result.getTableHeader();
		resultPane.add(result.getTableHeader(), BorderLayout.NORTH);
		resultPane.setBorder(BorderFactory.createTitledBorder("Resultado de la consulta SQL"));

		add(tablesPane, BorderLayout.SOUTH);
		tablesPane.setLayout(tablesPaneLayout);
		{
			panel11 = new JScrollPane();
			tablesPane.add(panel11, BorderLayout.WEST);
			panel11.setBorder(BorderFactory.createTitledBorder("Tablas"));
			{
				tableList = new JList();
				panel11.setViewportView(tableList);
				tablesListModel = new DefaultListModel();
				refreshTables();
				tableList.addListSelectionListener(this);
				tableList.setModel(tablesListModel);
			}
		}
		{
			panel2 = new JScrollPane();
			tablesPane.add(panel2, BorderLayout.CENTER);
			panel2.setBorder(BorderFactory.createTitledBorder(null,
					"Atributos", TitledBorder.LEADING,
					TitledBorder.DEFAULT_POSITION));
			{
				tableAttrs = new JList();
				panel2.setViewportView(tableAttrs);
				tablesAttrListModel = new DefaultListModel();
				tableList.setSelectedIndex(0);
				refreshAttributes();
				tableAttrs.setModel(tablesAttrListModel);
			}
		}


		this.setIconImage(new ImageIcon(getClass().getClassLoader()
				.getResource("img/cartel.jpg")).getImage());
		setTitle("Sistema de Parquimetros - Usuario: admin");
		this.setPreferredSize(new java.awt.Dimension(696, 542));
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}

	public void refreshAttributes() {
		Result res = me.execute("describe "
				+ tableList.getSelectedValue().toString());

		tablesAttrListModel.clear();

		for (String[] strings : res) {
			tablesAttrListModel.addElement(strings[0]);
		}

		res.closeQuery();
	}

	public void refreshTables() {
		Result r = me.execute("show tables");
		for (String[] strings : r) {
			tablesListModel.addElement(strings[0]);
		}
		r.closeQuery();
	}

	public void valueChanged(ListSelectionEvent arg0) {
		refreshAttributes();
	}

	public void actionPerformed(ActionEvent arg0) {
		String consulta = queryText.getText();
		Result res = me.execute(consulta);

		if (!res.isUpdateCommand()) {
			if (res.hasFailed()) {
				JOptionPane.showMessageDialog(this, "Error de sintaxis.\n\n"
						+ "Detalle:\n" + res.getErrorDetail(), "",
						JOptionPane.ERROR_MESSAGE, null);

			} else {
				resultTableModel.setColumnCount(0);
				resultTableModel.setRowCount(0);

				resultTableModel.setColumnCount(res.getColumnCount());
				resultTableModel.setColumnIdentifiers(res.getColumnLabels());

				for (String[] row : res) {
					resultTableModel.addRow(row);
				}
			}
		} else {
			if (res.hasFailed()) {
				JOptionPane.showMessageDialog(this,
						"La operacion de actualizacion no se pudo completar.",
						"", JOptionPane.ERROR_MESSAGE, null);
			} else {
				JOptionPane.showMessageDialog(this,
						"Operacion de actualizacion ejecutada correctamente",
						"", JOptionPane.INFORMATION_MESSAGE, null);
			}
		}

		res.closeQuery();
	}

	DefaultTableModel resultTableModel;
	DefaultListModel tablesListModel;
	DefaultListModel tablesAttrListModel;

	// Panel de consultas
	JPanel queryPane;
	JTextArea queryText;
	JButton runQuery;

	// Panel de tabla de resultados
	JPanel resultPane;
	JTableHeader resultHeader;
	JTable result;
	private JScrollPane jScrollPane1;
	private JPanel jPanel1;
	private JScrollPane panel2;
	private JScrollPane panel11;
	private JScrollPane panelScroll;

	// Panel de tablas de atributos
	JPanel tablesPane;
	JList tableList;
	JList tableAttrs;
}
