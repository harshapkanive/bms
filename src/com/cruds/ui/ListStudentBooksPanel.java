package com.cruds.ui;




import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.cruds.db.IssueDAO;

public class ListStudentBooksPanel extends JPanel{

	private JTextField txtUsn;
	private JLabel lblUsn;
	private TableModel model;
	private JTable table;
	private TableRowSorter sorter;
	private JScrollPane pane;
	private JButton btnHome;
	private JPanel panel;

	Vector<String> column = new Vector<String>();
	IssueDAO dao = null;

	public ListStudentBooksPanel(Container parent, CardLayout layout) {

		panel = this;

		txtUsn = new JTextField(7);
		lblUsn = new JLabel("Student Usn");

		column.add("Name");
		column.add("Title");
		column.add("ReturnDate");
		column.add("IssueID");
		column.add("Usn");

		dao = new IssueDAO();
		model = new DefaultTableModel(dao.getStudentIssueBookData(), column);
		sorter = new TableRowSorter<>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
		pane = new JScrollPane(table);

		add(lblUsn);
		add(txtUsn);
		add(pane);

		txtUsn.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				list(txtUsn.getText());

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				list(txtUsn.getText());

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				list(txtUsn.getText());

			}

			private void list(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent e) {

				table.setModel(new DefaultTableModel(dao.getStudentIssueBookData(), column));
			}
		});

		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(parent,"HOME");

			}
		});
		add(btnHome);

	}

}
