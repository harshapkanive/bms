package com.cruds.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Student {
	
	
	private String usn;
	private String name;

	public Student(String usn) {
		super();
		this.usn = usn;
	}

	public Student(String usn, String name) {
		super();
		this.usn = usn;
		this.name = name;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [usn=" + usn + ", name=" + name + "]";
	}
	

	private static final SimpleDateFormat dateTimeFormatter =
			new SimpleDateFormat("dd-MM-yyyy");
	
	public static java.sql.Date strToSQLDate(String strDate)
	{
		java.util.Date date = null;
		try {
			date = dateTimeFormatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}

	public boolean create(Student s1) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
