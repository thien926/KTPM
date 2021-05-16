package com.BasicClass;

public class NewUser {
	protected String user;
	protected String pass;
	protected String repass;
	protected String fullname;
	protected String email;
	protected String phone;
	protected String address;
	protected String gender;
	protected String born;
	
	public String error;
	public boolean result;
	
	public NewUser() {
		this.user = "";
		this.pass = "";
		this.repass = "";
		this.fullname = "";
		this.email = "";
		this.phone = "";
		this.address = "";
		this.gender = "";
		this.born = "";
		
		this.error = "";
		this.result = false;
	}
	 
	public NewUser(String user, String pass, String repass, String fullname, String email, String phone, String address, String gender, String born) {
		this.user = user;
		this.pass = pass;
		this.repass = repass;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.born = born;
		
		this.error = "";
		this.result = false;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setRePass(String repass) {
		this.repass = repass;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBorn(String born) {
		this.born = born;
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

	public String getRepass() {
		return this.repass;
	}

	public String getFullname() {
		return this.fullname;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return this.address;
	}

	public String getGender() {
		return this.gender;
	}

	public String getBorn() {
		return this.born;
	}
	
	public String getError() {
		return this.error;
	}
	
	public boolean getResult() {
		return this.result;
	}
}
