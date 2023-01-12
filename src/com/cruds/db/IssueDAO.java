package com.cruds.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.cruds.demo.Issue;
import com.cruds.demo.Student;
import com.cruds.Date.DateConvertor;


public class IssueDAO {
	
	public Vector<Vector<String>> getIssueBookData()
	{
		String sql ="select s.USN,i.issueDate,i.returnDate,b.ISBN from student s, book b, bookissue i where i.ISBN = b.ISBN and i.USN = s.USN";
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs !=null && rs.next())
			{
				row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return data;
		
	}
	
	public Vector<Vector<String>> getStudentIssueBookData()
	{
		String sql ="select s.name,b.title,i.returnDate,i.issueID,s.usn from student s, book b, bookissue i where i.ISBN = b.ISBN and i.USN = s.USN";
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs !=null && rs.next())
			{
				row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				row.add(rs.getString(5));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return data;
		
	}
	
	public Vector<Vector<String>> getReturnBooksData()
	{
		String sql ="select s.name,b.title,b.ISBN,i.issueID,i.returnDate from student s, book b,bookissue i where i.ISBN = b.ISBN and i.usn = s.usn";
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs !=null && rs.next())
			{
				row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(String.valueOf(rs.getInt(3)));
				row.add(String.valueOf(rs.getInt(4)));
				row.add(rs.getString(5));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return data;
		
	}
	
	public List<Issue> listBooks(String usn)
	{
		String sql ="select s.name,b.title,i.returnDate,i.issueID from student s, book b, bookissue i where i.ISBN = b.ISBN and i.usn = s.usn and s.usn = ? ";
		List<Issue> list1 = new ArrayList<Issue>();
		
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usn);
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Issue i = new Issue(rs.getInt(4), rs.getString(3), rs.getString(2), rs.getString(1));
				list1.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;
	}

	public List<Issue> returnBooks()
	{
		String sql = "select s.name,b.title,b.ISBN,i.issueID from student s, book b,bookissue i where i.ISBN = b.ISBN and i.usn = s.usn  and i.returnDate = ?";
		List<Issue> list2  = new ArrayList<Issue>();

			
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1 , DateConvertor.getCurrDateAsSQLDate());
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Issue i = new Issue(rs.getInt(4), rs.getInt(3), rs.getString(2), rs.getString(1));
				list2.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list2 ;
	}

	public Vector<Vector<String>> getBookISBNData(int ISBN)
	{
		String sql ="select b.ISBN, b.title, b.category, b.NoOfBooks , a.authorname , a.mailID from book b ,author a where b.ISBN = a.ISBN and b.ISBN = ?"; 
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ISBN);
			ResultSet rs = ps.executeQuery();
			
			while(rs !=null && rs.next())
			{
				row = new Vector<String>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return data;
		
	}	

	public Vector<Vector<String>> getStudentUsnData(String usn)
	{
		String sql ="select usn,name from Student where usn = ?"; 
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> row = null;
		
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usn);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs !=null && rs.next())
			{
				row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return data;
		
	}

	public boolean issueBook(Student student,Date issueDate,int ISBN )
	{
		String sql1 = "select USN from Student where USN = ?";
		String sql2 = "insert into bookissue(USN,issueDate,returnDate,ISBN) values (?,?,?,?) ";
		String sql3 = "update book set NoOfBooks = NoOfBooks-?  where ISBN = ? ";
		
	    int  row2 = 0 ,row3 = 0;
	    int Book1 = 1;
	    String USN = null;
	    
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(issueDate);
	    cal.add(Calendar.DATE, 7);
	    Date returnDate = cal.getTime();
	    
	    java.sql.Date rDate = new java.sql.Date(returnDate.getTime());
	    java.sql.Date iDate = new java.sql.Date(issueDate.getTime());
	    
		try(Connection conn = DBconnectionmanager.getConnection())
		{
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, student.getUsn());
			ResultSet rs = ps1.executeQuery();
			if(rs != null && rs.next())
			{
				USN = rs.getString(1);
			}
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1,student.getUsn());
			ps2.setDate(2, iDate);
			ps2.setDate(3, rDate);
			ps2.setInt(4, ISBN);
			row2 = ps2.executeUpdate();
			
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setInt(1, Book1);
			ps3.setInt(2, ISBN);
	
			row3 = ps3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row2 > 0 && row3 > 0 );
	}

}
