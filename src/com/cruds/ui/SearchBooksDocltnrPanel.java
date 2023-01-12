package com.cruds.ui;



import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

import com.cruds.db.BookDAO;



public class SearchBooksDocltnrPanel extends JPanel{
	
	   private JTextField txtTitle;
	   private JLabel lblTitle;
	   private JTextField txtAuthor;
	   private JLabel lblAuthor;
	   private TableModel model;         
	   private JTable table;             
	   private TableRowSorter sorter;  
	   private JScrollPane pane;
	   private JComboBox cbCategory;
	   private JLabel lblCategory;
	   private JButton btnHome;
	   private JPanel panel;
	   
	   Vector<String> column = new Vector<String>();
	   BookDAO dao = null;
	   
	   public SearchBooksDocltnrPanel(Container parent, CardLayout layout) {
		
		   panel = this;
		   
		   String[] cb = {"","Action","java","textbook","Database","Crime","Crime/Drama","Sci-fi","Fiction"};
		   lblCategory = new JLabel("Search Category");
		   cbCategory = new JComboBox(cb);
		   add(cbCategory);
		   
		   txtTitle = new JTextField(5);
		   lblTitle = new JLabel("Search Title");
		   
		   txtAuthor = new JTextField(5);
		   lblAuthor = new JLabel("Search Author");
		   
		   column.add("ISBN");
		   column.add("Title");
		   column.add("Category");
		   column.add("NoOfBooks");
		   column.add("Authorname");
		   column.add("MailID");
		    
		   dao = new BookDAO();
		   model = new DefaultTableModel(dao.getSearchBooksData(), column);
		   sorter = new TableRowSorter<>(model);
		   table = new JTable(model);
		   table.setRowSorter(sorter);
		   pane = new JScrollPane(table);
		   
		   add(lblTitle);
		   add(txtTitle);
		   add(lblAuthor);
		   add(txtAuthor);
		   add(pane);
		   
		   txtTitle.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {

				 search(txtTitle.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				 search(txtTitle.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

				 search(txtTitle.getText());
			}
			
			private void search(String title) {
				 if (title.length() == 0) {
		               sorter.setRowFilter(null);
		            } else {
		               sorter.setRowFilter(RowFilter.regexFilter(title));
		            }
				
			}
		});
		   
		   txtAuthor.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {

					 search(txtAuthor.getText());
				}

				@Override
				public void insertUpdate(DocumentEvent e) {

					 search(txtAuthor.getText());
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {

					 search(txtAuthor.getText());
				}
				
				private void search(String author) {
					 if (author.length() == 0) {
			               sorter.setRowFilter(null);
			            } else {
			               sorter.setRowFilter(RowFilter.regexFilter(author));
			            }
				}
			});
		   
		   
		   
		   addComponentListener(new ComponentAdapter() {
				
				@Override
				public void componentShown(ComponentEvent e) {
					      
					table.setModel(new DefaultTableModel(dao.getSearchBooksData(), column));
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


