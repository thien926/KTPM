package com.BasicClass;

public class Product {
	protected int product_id;
	protected String name;
	protected String product_type;
	protected String author;
	protected String nxb;
	protected String img;
	protected int amount;
	protected long price;
	protected String sail;
	protected String descript;
	protected String status;
	
	protected String error;
	protected boolean result;
	
	public Product() {
		this.product_id = -1;
		this.name = "";
		this.product_type = "";
		this.author = "";
		this.nxb = "";
		this.img = "";
		this.amount = 0;
		this.price = 0;
		this.sail = "";
		this.descript = "";
		this.status = "";
		
		this.error = "";
		this.result = false;
	}
	
	public Product(int product_id, String name, String product_type, String author, String nxb, String img, int amount, long price, String sail, String descript, String status) {
		this.product_id = product_id;
		this.name = name;
		this.product_type = product_type;
		this.author = author;
		this.nxb = nxb;
		this.img = img;
		this.amount = amount;
		this.price = price;
		this.sail = sail;
		this.descript = descript;
		this.status = status;
		
		this.error = "";
		this.result = false;
	}

	public Product(String name, String product_type, String author, String nxb, String img, int amount, long price, String sail, String descript, String status) {
		this.product_id = -1;
		this.name = name;
		this.product_type = product_type;
		this.author = author;
		this.nxb = nxb;
		this.img = img;
		this.amount = amount;
		this.price = price;
		this.sail = sail;
		this.descript = descript;
		this.status = status;
		
		this.error = "";
		this.result = false;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNxb() {
		return nxb;
	}

	public void setNxb(String nxb) {
		this.nxb = nxb;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getSail() {
		return sail;
	}

	public void setSail(String sail) {
		this.sail = sail;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
