package com.TestShop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebDriver.webDriver;

public class testDangNhap {
	public webDriver classDriver;
	
	public void setWebDriver() {
		if(this.classDriver == null) {
			this.classDriver = new webDriver();
			this.classDriver.setWebDriverLogin();
		}
		else {
			this.classDriver.setWebDriverLogin();
		}
	}
	
	// Đăng nhập chính xác tài khoản và mật khẩu
	@Test(priority = 1)
	public void testTrueTKMK() {
		setWebDriver();
		
		classDriver.driver.findElement(By.id("user")).sendKeys("thien");
		classDriver.driver.findElement(By.id("pass")).sendKeys("12345");
		classDriver.driver.findElement(By.className("single-login-2")).click();
		
		String actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
		classDriver.driver.findElement(By.className("swal2-actions")).click();
		String expected = "Đăng nhập thành công!";
		
		classDriver.driver.close();
		Assert.assertEquals(actual, expected);
	}
	
//	Đăng nhập sai tài khoản và mật khẩu
	@Test(priority = 2)
	public void testFalseTKMK() {
		setWebDriver();
		
		classDriver.driver.findElement(By.id("user")).sendKeys("thien1");
		classDriver.driver.findElement(By.id("pass")).sendKeys("12345");
		classDriver.driver.findElement(By.className("single-login-2")).click();
		
		String actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
		classDriver.driver.findElement(By.className("swal2-actions")).click();
		String expected = "Tài khoản hoặc mật khẩu không đúng";
		
		
		classDriver.driver.close();
		Assert.assertEquals(actual, expected);
	}
}
