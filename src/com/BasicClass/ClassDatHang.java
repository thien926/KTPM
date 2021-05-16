package com.BasicClass;

public class ClassDatHang {
	protected String user;
	protected String pass;
	protected String typeProduct;
	protected String product;
	protected boolean typeAddress;
	protected String address;
	protected String remove;

	protected String error;
	protected boolean result;
	
	public ClassDatHang(String user, String pass, String typeProduct, String product, boolean typeAddress, String address, String remove) {
		this.user = user;
		this.pass = pass;
		this.typeProduct = typeProduct;
		this.product = product;
		this.typeAddress = typeAddress;
		this.address = address;
		this.remove = remove;

		this.error = "";
		this.result = false;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public void setTypeAddress(boolean typeAddress) {
		this.typeAddress = typeAddress;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setRemove(String remove) {
		this.remove = remove;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public String getTypeProduct() {
		return this.typeProduct;
	}
	
	public String getProduct() {
		return this.product;
	}
	
	public boolean getTypeAddress() {
		return this.typeAddress;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getRemove() {
		return this.remove;
	}
	
	public String getError() {
		return this.error;
	}
	
	public boolean getResult() {
		return this.result;
	}
}
