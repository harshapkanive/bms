package com.cruds.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cruds.db.BookDAO;
import com.cruds.db.IssueDAO;
import com.cruds.demo.Author;
import com.cruds.demo.Book;
import com.cruds.demo.Issue;
import com.cruds.demo.Student;

public class TestBMS {

	public static void main(String[] args ) {

		Scanner sc = new Scanner(System.in);
		BookDAO dao = new BookDAO();
		IssueDAO dao1 = new IssueDAO();
		String choice = "";

		do {
			System.out.println("Select a choice");
			System.out.println("1.Add a book:");
			System.out.println("2.Search a book based on book title");
			System.out.println("3.Search a book based on book category");
			System.out.println("4.Search a book based on book author");
			System.out.println("5.List all the books:");
			System.out.println("6.Add Student");
			System.out.println("7.Issue book to a student:");
			System.out.println("8.List books issued to student based on USN number:");
			System.out.println("9.List books which are to be returned for current date:");
			System.out.println("10.Exiting application");

			choice = sc.nextLine();

			switch (choice) {
			case "1":
				int ISBN = 0;

				while(true) {
					try {
						System.out.println("Please enter the book ISBN ");
						ISBN = sc.nextInt(); sc.nextLine();

						if(ISBN <= 0)
						{
							System.out.println("Invalid input ,Please enter the ISBN" );
							ISBN = sc.nextInt(); sc.nextLine();
						}

						break;

					} catch (InputMismatchException e) {
						System.out.println("Invalid input");
						sc.nextLine();
					}
				}	

				System.out.println("Please enter the book title ");
				String title = sc.nextLine();
				System.out.println("Please enter the book category ");
				String category = sc.nextLine();
				System.out.println("Please enter the number of books being added ");
				int NoOfBooks = sc.nextInt(); sc.nextLine();
				System.out.println("Please enter the book authorname ");
				String authorname = sc.nextLine();
				System.out.println("Please enter the author mailID ");
				String mailID = sc.nextLine();

				Author a = new Author( authorname ,mailID);
				Book b = new Book(ISBN, title, category, NoOfBooks, a);

				if(dao.create(b))
				{
					System.out.println("Book added successfully");
				}
				break;

			case "2":
				System.out.println("Please enter book title to search ");
				String searchTitle = sc.nextLine();
				Book result = dao.getTitle(searchTitle);
				if(result == null)
				{
					System.out.println(" Sorry could not find the book  " + searchTitle  );
				}
				else
				{
					System.out.println(result.getTitle() + " = " + result.getAuthor());
				}
				break;

			case"3":
				System.out.println("Please enter book category to search ");
				String searchCategory = sc.nextLine();
				Book result2 = dao.getCategory( searchCategory);
				if(result2 == null)
				{
					System.out.println(  "Could not find the category " + searchCategory);
				}
				else
				{
					System.out.println(result2.getCategory() + " == " + result2.getAuthor());
				}
				break;

			case"4":
				System.out.println("Please enter book author to search ");
				String searchAuthor = sc.nextLine();
				Book result3 = dao.getAuthorname(searchAuthor);
				if(result3 == null)
				{
					System.out.println(searchAuthor + ",Sorry book author not found ");
				}
				else
				{
					System.out.println(result3.getAuthor());
				}
				break;

			case "5":
				List<Book> list = dao.getAll();

				for(Book bk : list)
				{
					System.out.println(bk.getAuthor() + " ,Title = " + bk.getTitle() + " ,Category= " + bk.getCategory()+ " ,ISBN= " + bk.getISBN() + " ,Number = " + bk.getNoOfBooks());
					//System.out.println(bk);
				}
				break;

			case"6":
				System.out.println("Please enter the student usn ");
				String usn = sc.nextLine();
				System.out.println("Please enter the student name");
				String name = sc.nextLine();

				Student s = new Student(usn, name);
				if(dao.create(s))
				{
					System.out.println("Student created");
				}
				break;

			case"7":
				Date iDate = null;
				System.out.println("Please enter the student usn to issue book");
				usn = sc.nextLine();			

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				Date date = new Date();  
				System.out.println(formatter.format(date)); 
				try{
					System.out.println("Please enter the book ISBN to issue");
					int searchISBN = sc.nextInt(); sc.nextLine();

					Book result4 = dao.getBook(searchISBN);
					if(result4 == null)
					{
						System.out.println("Sorry book not found " + searchISBN);
					}
					else
					{
						System.out.println(result4.getISBN() +" ==" + result4.getTitle()+ " ==" + result4.getAuthor());
					}

					dao1.issueBook(new Student(usn), date, searchISBN);
					System.out.println("Book issued");
				}catch (InputMismatchException e) {
					System.out.println("Invalid input");
				}
				break;

			case"8":
				System.out.println("Enter the student USN");
				usn = sc.nextLine();

				dao1.listBooks(usn);
				List<Issue> list1 = dao1.listBooks(usn);

				for(Issue i : list1)
				{
					System.out.println(i.getName() + " == " + i.getTitle()+ " == "+ i.getReturndate() + " == " +i.getIssueID());
				}

				break;

			case"9":
				System.out.println("Enter the current date (yyyy-MM-dd)");

				Date returnDate = null;

				List<Issue> list2 = dao1.returnBooks();
				for(Issue i1 : list2)
				{
					System.out.println(i1.getName() + " == " + i1.getTitle() + " == " +   i1.getISBN() + " == " + i1.getIssueID());
				}

				break;

			case "10":
				System.out.println("Exiting application");
				break;
			default:
				break;
			}

		} while (!choice.equals("10"));
		sc.close();
	}

}
