package com.BasicClass;

public class User {
	protected String user;
	protected String pass;
	protected String error;
	protected boolean result;
	
	public User() {
		this.user = "";
		this.pass = "";
		this.error = "";
		this.result = false;
	}
	 
	public User(String user, String pass) {
		this.user = user;
		this.pass = pass;
		this.error = "";
		this.result = false;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setResult(boolean t) {
		this.result = t;
	}
	
	
	public String getUser() {
		return this.user;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public String getError() {
		return this.error;
	}
	
	public boolean getResult() {
		return this.result;
	}
}
