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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logic.Result;
import logic.User;

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

		resultTableModel = new DefaultTableModel();
		result = new JTable(resultTableModel);
		resultHeader = result.getTableHeader();

		resultPane = new JPanel(new BorderLayout());
		resultPane.add(result.getTableHeader(), BorderLayout.NORTH);
		resultPane.add(result, BorderLayout.CENTER);

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
		Result res = me.execQuery(queryText.getText());

		resultTableModel.setColumnCount(0);
		resultTableModel.setRowCount(0);

		resultTableModel.setColumnCount(res.getColumnCount());
		resultTableModel.setColumnIdentifiers(res.getColumnLabels());

		for (String[] row : res) {
			resultTableModel.addRow(row);
		}

		res.closeQuery();
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

	// Panel de tablas de atributos
	JPanel tablesPane;
	JList tableList;
	JList tableAttrs;
}
