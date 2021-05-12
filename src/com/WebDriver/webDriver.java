package com.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver {
	public WebDriver driver;
	private String url = "http://localhost/thien/NhomKTPM/index.php";
	private String chromedriver = "webdriver.chrome.driver";
	private String chrome = "G:\\Git\\KTPM\\libs\\chromedriver.exe";
	
	public void setWebDriverHome() {
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverShop() {
		url = "http://localhost/thien/NhomKTPM/shop.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverLogin() {
		url = "http://localhost/thien/NhomKTPM/login.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverRegister() {
		url = "http://localhost/thien/NhomKTPM/register.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverUser() {
		url = "http://localhost/thien/NhomKTPM/user.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void close() {
		driver.close();
	}
}
