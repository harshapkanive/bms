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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cruds.db.BookDAO;
import com.cruds.demo.Student;
import com.cruds.exception.smsException;


public class StudentPanel extends JPanel {
	
	private JLabel lblUsn;
	private JLabel lblName;
	private JTextField txtUsn;
	private JTextField txtName;
	private JButton btnCreate;
	private JButton btnHome;
	private Container parent;                           
	private CardLayout layout;
	private JPanel panel;
	private JTable table;
	private JScrollPane pane;
	
	Vector<String> column = new Vector<String>();
	BookDAO dao = null;
	
	public StudentPanel(Container parent, CardLayout layout) {
		
		column.add("Usn");
		column.add("Name");
		dao = new BookDAO();
		
		panel = this;
		this.parent = parent;
		this.layout = layout;
		
		lblUsn = new JLabel("Usn");
		lblName = new JLabel("Name");
		
		txtUsn = new JTextField(8);
		txtName = new JTextField(8);
		table = new JTable(new DefaultTableModel(dao.getStudentData(), column));
		pane = new JScrollPane(table);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strUsn = txtUsn.getText();
				String strName = txtName.getText();
				
				if(strName.trim().equals("") || strUsn.trim().equals(""))
				{
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel, "Student details cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					Student s = new Student(strUsn, strName);
					BookDAO dao = new BookDAO();
					if(dao.create(s))
					{
						JOptionPane.showMessageDialog(panel,"Student created successfully" , "Success", JOptionPane.INFORMATION_MESSAGE);
						txtUsn.setText("");
						txtName.setText("");
						
						layout.show(parent, "STUDENT");
					}
					table.setModel(new DefaultTableModel(dao.getStudentData(),column));
					
				} catch (smsException sms) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(panel,sms.getInfo(),"Error", JOptionPane.ERROR_MESSAGE);
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
				add(lblName);
				add(txtName);
				add(btnCreate);
				add(btnHome);
				add(pane);
				
			}
	
}

