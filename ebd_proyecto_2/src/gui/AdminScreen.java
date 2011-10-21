package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
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

		queryText = new JTextArea();
		queryText.setText("select * from automoviles");
		queryText.setRows(5);
		queryText.setBorder(new LineBorder(Color.black));

		runQuery = new JButton("Ejecutar");
		runQuery.addActionListener(this);

		queryPane = new JPanel(new BorderLayout());
		queryPane.add(queryText, BorderLayout.CENTER);
		queryPane.add(runQuery, BorderLayout.EAST);

		resultPane = new JPanel(new BorderLayout());

		resultTableModel = new DefaultTableModel();

		

		tablesPane = new JPanel(new BorderLayout());

		tablesListModel = new DefaultListModel();
		tableList = new JList();

		refreshTables();
		tableList.addListSelectionListener(this);
		tableList.setModel(tablesListModel);
		tableList.setBorder(new LineBorder(Color.black));

		tablesAttrListModel = new DefaultListModel();
		tableAttrs = new JList();
		tableAttrs.setBorder(new LineBorder(Color.black));
		tableAttrs.setModel(tablesAttrListModel);

		tableList.setSelectedIndex(0);
		refreshAttributes();

		tablesPane.add(tableList, BorderLayout.WEST);
		tablesPane.add(tableAttrs, BorderLayout.CENTER);

		setLayout(new BorderLayout());

		add(queryPane, BorderLayout.NORTH);
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
		
		add(tablesPane, BorderLayout.SOUTH);

		setTitle("Sistema de Parquimetros - Usuario: admin");
		setPreferredSize(new Dimension(width, height));
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public void refreshAttributes() {
		Result res = me.execQuery("describe "
				+ tableList.getSelectedValue().toString());

		tablesAttrListModel.removeAllElements();

		for (String[] strings : res) {
			tablesAttrListModel.addElement(strings[0]);
		}
		res.closeQuery();
	}

	public void refreshTables() {
		Result r = me.execQuery("show tables");
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
		if (consulta.startsWith("INSERT")||consulta.startsWith("Insert") || consulta.startsWith("insert")){
			me.execInsert(consulta);
		}else{
			Result res = me.execQuery(consulta);
	
			resultTableModel.setColumnCount(0);
			resultTableModel.setRowCount(0);
	
			resultTableModel.setColumnCount(res.getColumnCount());
			resultTableModel.setColumnIdentifiers(res.getColumnLabels());
	
			for (String[] row : res) {
				resultTableModel.addRow(row);
			}
	
			res.closeQuery();
		}
	}

	private final int width = 500;
	private final int height = 300;

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
	private JScrollPane panelScroll;

	// Panel de tablas de atributos
	JPanel tablesPane;
	JList tableList;
	JList tableAttrs;
}
