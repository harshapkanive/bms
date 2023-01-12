package com.cruds.ui;



import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePanel extends JPanel{

	private JButton btnCreateBook;
	private JButton btnView;
	private JButton btnSearchBook;
	private JButton btnListAllBooks;
	private JButton btnCreateStudent;
	private JButton btnIssueBook;
	private JButton btnListStudentBooks;
	private JButton btnReturnBooks;

	public HomePanel(Container parent,CardLayout layout) {

		setLayout(new GridLayout(9,1));
		btnCreateBook = new JButton("Create Book");
		btnCreateBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(parent,"BOOK");

			}
		});

		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(parent, "VIEW");
			}
		});

		btnSearchBook = new JButton("Search Book based on");
		btnSearchBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(parent, "SEARCH");

			}
		});

		btnListAllBooks = new JButton("List all the Books");
		btnListAllBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(parent, "LIST");
			}
		});

		btnCreateStudent = new JButton("Create Student");
		btnCreateStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(parent, "STUDENT");

			}
		});

		btnIssueBook = new JButton("Issue Books");
		btnIssueBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(parent, "ISSUE BOOKS");

			}
		});

		btnListStudentBooks = new JButton("List books issued to student");
		btnListStudentBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(parent, "LIST STUDENT BOOKS");
			}
		});

		btnReturnBooks = new JButton("List books which are to be returned for current date");
		btnReturnBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				layout.show(parent, "RETURN BOOKS");
			}
		});

		add(btnCreateBook);
		add(btnView);
		add(btnSearchBook);
		add(btnListAllBooks);
		add(btnCreateStudent);
		add(btnIssueBook);
		add(btnListStudentBooks);
		add(btnReturnBooks);

	}
}

