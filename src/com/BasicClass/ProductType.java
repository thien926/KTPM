package com.BasicClass;

public class ProductType {
	protected int id;
	protected String name;
	protected String describe;
	protected String error;
	protected boolean result;
	
	public ProductType() {
		this.id = -1;
		this.name = "";
		this.describe = "";
		this.error = "";
		this.result = false;
	}
	 
	public ProductType(String name, String describe) {
		this.name = name;
		this.describe = describe;
		this.error = "";
		this.result = false;
		this.id = -1;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setdescribe(String describe) {
		this.describe = describe;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setResult(boolean t) {
		this.result = t;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getname() {
		return this.name;
	}
	
	public String getdescribe() {
		return this.describe;
	}
	
	public String getError() {
		return this.error;
	}
	
	public boolean getResult() {
		return this.result;
	}

	public int getId() {
		return this.id;
	}
}
