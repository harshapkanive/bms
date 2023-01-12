package com.cruds.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.cruds.db.BookDAO;
import com.cruds.demo.Issue;
import com.cruds.demo.Student;


public class IssueBMS extends JFrame {
	
	JTextField txtUsn;
	JTextField txtName;
	JTextField txtIssueDate;
	JTextField txtReturnDate;
	JTextField txtISBN;
	JButton btnCreate;
	JPanel panel;
	
	public IssueBMS() {
		
		setTitle("Book Management");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		txtUsn = new JTextField(4);
		txtName = new JTextField(5);
		txtIssueDate = new JTextField(7);
		txtReturnDate = new JTextField(7);
		txtISBN = new JTextField(4);
		btnCreate = new JButton("Create");
		
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String strUsn = txtUsn.getText();
				String strName = txtName.getText();
				String strIssueDate = txtIssueDate.getText();
				String strReturnDate = txtReturnDate.getText();
				String strISBN = txtISBN.getText();
				
				Student s = new Student(strUsn, strName);
				Issue i = new Issue(strUsn, strIssueDate, strReturnDate, Integer.parseInt(strISBN));
				BookDAO dao = new BookDAO();
				dao.create(s);
				//dao.issueBook(s, null, ABORT);
				
				panel.add(txtUsn);
				panel.add(txtName);
				panel.add(txtIssueDate);
				panel.add(txtReturnDate);
				panel.add(txtISBN);
				panel.add(btnCreate);
				
				add(panel);
				setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new IssueBMS();
			}
		});
	}
}


