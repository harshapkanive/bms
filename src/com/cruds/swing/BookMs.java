package com.cruds.swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.cruds.db.BookDAO;
import com.cruds.demo.Author;
import com.cruds.demo.Book;

public class BookMs extends JFrame {
	
	JTextField txtAuthorname;
	JTextField txtMailID;
	JTextField txtISBN;
	JTextField txtTitle;
	JTextField txtCategory;
	JTextField txtNoOfBooks;
	JButton btnCreate;
	JPanel panel;
	
	public BookMs() {
		
		setTitle("Book Management");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		txtAuthorname = new JTextField(5);
		txtMailID = new JTextField(5);
		txtISBN = new JTextField(4);
		txtTitle = new JTextField(8);
		txtCategory = new JTextField(5);
		txtNoOfBooks = new JTextField(3);
		btnCreate = new JButton("Create");
		
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String strAuthorname = txtAuthorname.getText();
				String strMailID = txtMailID.getText();
				String strISBN = txtISBN.getText();
				String strTitle = txtTitle.getText();
				String strCategory = txtCategory.getText();
				String strNoOfBooks = txtNoOfBooks.getText();
				
				Author a = new Author(strAuthorname, strMailID);
				Book b = new Book(Integer.parseInt(strISBN), strTitle, strCategory, Integer.parseInt(strNoOfBooks),a);
				BookDAO dao = new BookDAO();
				dao.create(b);
				
			}
		});
		
		panel.add(txtAuthorname);
		panel.add(txtMailID);
		panel.add(txtISBN);
		panel.add(txtTitle);
		panel.add(txtCategory);
		panel.add(txtNoOfBooks);
		panel.add(btnCreate);
		
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new BookMs();
				
			}
		});
	}
}
