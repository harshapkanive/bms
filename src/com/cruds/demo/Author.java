package com.cruds.demo;

public class Author {
	
	
	
	private String authorname;
	private String mailId;
	
	public Author(String authorname, String mailId) {
		super();
		this.authorname = authorname;
		this.mailId = mailId;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "Author [authorname=" + authorname + ", mailId=" + mailId + "]";
	}
	
	
	
	
	
	

}
