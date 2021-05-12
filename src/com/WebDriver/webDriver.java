package com.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver {
	public WebDriver driver;
	private String url = "http://localhost:81/web2_doan/";
	private String chromedriver = "webdriver.chrome.driver";
	private String chrome = "D:\\student\\chromedriver.exe";
	
	public void setWebDriverHome() {
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverShop() {
		url = "http://localhost:81/web2_doan/shop.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverLogin() {
		url = "http://localhost:81/web2_doan/login.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverRegister() {
		url = "http://localhost:81/web2_doan/register.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void setWebDriverUser() {
		url = "http://localhost:81/web2_doan/user.php";
		System.setProperty(chromedriver, chrome);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void close() {
		driver.close();
	}
}
