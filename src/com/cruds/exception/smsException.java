package com.cruds.exception;

public class smsException extends RuntimeException{
	
	private String info;

	public smsException(String info) {
		super();
		this.info = info;
	}

	public String getInfo() {
		return info;
	}


}
