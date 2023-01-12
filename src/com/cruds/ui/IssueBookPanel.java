package com.cruds.ui;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.cruds.Date.DateConvertor;
import com.cruds.db.BookDAO;
import com.cruds.db.IssueDAO;
import com.cruds.demo.Student;



public class IssueBookPanel extends JPanel {

	private JTextField txtUsn;
	private JLabel lblUsn;
	private JTextField txtISBN;
	private JLabel lblISBN;
	private JScrollPane paneUsn;
	private JScrollPane paneISBN;
	private JPanel panel;
	private JTable table;
	private JTable tableISBN;
	private JButton btnSearchUsn;
	private JButton btnSearchISBN;
	private JButton btnIssue;
	private JButton btnHome;

	Vector<String> columnUsn = new Vector<String>();
	Vector<String> columnISBN = new Vector<String>();
	IssueDAO dao = null;
	BookDAO dao1 = null;

	public IssueBookPanel(Container parent, CardLayout layout) {

		panel = this;

		lblUsn = new JLabel("Student Usn");
		txtUsn = new JTextField(7);
		columnUsn.add("Usn");
		columnUsn.add("Name");

		lblISBN = new JLabel("Book ISBN");
		txtISBN = new JTextField(7);
		columnISBN.add("ISBN");
		columnISBN.add("Title");
		columnISBN.add("Category");
		columnISBN.add("NoOfBooks");
		columnISBN.add("Authorname");
		columnISBN.add("MailID");

		dao = new IssueDAO();
		dao1 = new BookDAO();
		table = new JTable(null, columnUsn);
		paneUsn = new JScrollPane(table);

		btnSearchUsn = new JButton("Search");
		btnSearchUsn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strUsn = txtUsn.getText();

				IssueDAO dao = new IssueDAO();

				table.setModel(new DefaultTableModel(dao.getStudentUsnData(strUsn), columnUsn));
			}
		});

		tableISBN = new JTable(null, columnISBN);
		paneISBN = new JScrollPane(tableISBN);

		btnSearchISBN = new JButton("Search");
		btnSearchISBN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String strISBN = txtISBN.getText();
				try {
					IssueDAO dao = new IssueDAO();
					tableISBN.setModel(new DefaultTableModel(dao.getBookISBNData(Integer.parseInt(strISBN)),columnISBN));
				} catch (NumberFormatException nfe) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel,"Invalid ID","Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int rowidx = table.getSelectedRow();
					String strUsn =  (String) table.getModel().getValueAt(rowidx, 0);
					String strISBN =  (String) tableISBN.getModel().getValueAt(rowidx, 0);

					if(dao.issueBook(new Student(strUsn),DateConvertor.getCurrDateAsSQLDate(), Integer.parseInt(strISBN)))
					{
						JOptionPane.showMessageDialog(parent, "Book Issued", "Success",JOptionPane.INFORMATION_MESSAGE);

						layout.show(parent, "LIST STUDENT BOOKS");
					}

				} catch (ArrayIndexOutOfBoundsException ex) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel,"Invalid","Error", JOptionPane.ERROR_MESSAGE);
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

		add(lblUsn);
		add(txtUsn);
		add(btnSearchUsn);
		add(paneUsn);
		add(lblISBN);
		add(txtISBN);
		add(btnSearchISBN);
		add(btnHome);
		add(btnIssue);
		add(paneISBN);

	}
}



