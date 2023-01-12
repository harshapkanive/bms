package com.cruds.demo;



public class Issue {
	
	private int issueID;
	private String usn;
	private String issueddate;
	private String returndate;
	private int ISBN;
	
	private String title;
	private String name;
	
	public Issue(int issueID, String returndate, int iSBN, String title, String name) {
		super();
		this.issueID = issueID;
		this.returndate = returndate;
		ISBN = iSBN;
		this.title = title;
		this.name = name;
	}

	public Issue(int issueID, String usn, String issueddate, String returndate, int iSBN, String name) {
		super();
		this.issueID = issueID;
		this.usn = usn;
		this.issueddate = issueddate;
		this.returndate = returndate;
		ISBN = iSBN;
		this.name = name;
	}

	public Issue(int issueID, int iSBN, String title, String name) {
		super();
		this.issueID = issueID;
		ISBN = iSBN;
		this.title = title;
		this.name = name;
	}

	public Issue(int issueID, String returndate, String title, String name) {
		super();
		this.issueID = issueID;
		this.returndate = returndate;
		this.title = title;
		this.name = name;
	}

	public Issue(String usn, String issueddate, String returndate, int iSBN) {
		super();
		this.usn = usn;
		this.issueddate = issueddate;
		this.returndate = returndate;
		ISBN = iSBN;
	}

	public Issue(int issueID, String usn, String issueddate, String returndate, int iSBN) {
		super();
		this.issueID = issueID;
		this.usn = usn;
		this.issueddate = issueddate;
		this.returndate = returndate;
		ISBN = iSBN;
	}

	public int getIssueID() {
		return issueID;
	}

	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(String issueddate) {
		this.issueddate = issueddate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Issue [issueID=" + issueID + ", usn=" + usn + ", issueddate=" + issueddate + ", returndate="
				+ returndate + ", ISBN=" + ISBN + "]";
	}

	public boolean create(Book b) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
	

