package com.cruds.ui;


import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class ReturnBooksPanel extends JPanel{

	private JTextField txtReturnDate;
	private JLabel lblReturnDate;
	private TableModel model;
	private JTable table;
	private TableRowSorter sorter;
	private JScrollPane pane;
	private JButton btnHome;
	private JPanel panel;

	Vector<String> column = new Vector<String>();
	IssueDAO dao = null;

	public ReturnBooksPanel(Container parent, CardLayout layout) {

		panel = this;

		txtReturnDate = new JTextField(7);
		lblReturnDate = new JLabel("ReturnDate");

		column.add("Name");
		column.add("Title");
		column.add("ISBN");
		column.add("IssueID");
		column.add("ReturnDate");

		dao = new IssueDAO();
		model = new DefaultTableModel(dao.getReturnBooksData(), column);
		sorter = new TableRowSorter<>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
		pane = new JScrollPane(table);

		add(lblReturnDate);
		add(txtReturnDate);
		add(pane);

		txtReturnDate.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				list(txtReturnDate.getText());

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				list(txtReturnDate.getText());

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				list(txtReturnDate.getText());

			}

			private void list(String text) {
				if (text.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}


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
		add(pane);

	}

}


