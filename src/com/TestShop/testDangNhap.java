package com.TestShop;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BasicClass.User;
import com.WebDriver.webDriver;
import com.WorkWithExcel.DocExcel;
import com.WorkWithExcel.XuatExcel;

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
	
	// Test đăng nhập
	@Test(priority = 1)
	public void test_DangNhap() {
		DocExcel docExcel = new DocExcel();
		ArrayList<User> list = docExcel.DocExcelTaiKhoanDangNhap();
		setWebDriver();
		
		String errorUser = "", errorPass = "", actual = "", errorSweet = "", successSweet = "";
		String temp = "";
		
		
		for(User user : list) {
			temp = "";
			classDriver.driver.findElement(By.id("user")).sendKeys(user.getUser());
			classDriver.driver.findElement(By.id("pass")).sendKeys(user.getPass());
			classDriver.driver.findElement(By.className("single-login-2")).click();
			
			errorUser = classDriver.driver.findElement(By.id("note_user")).getText();
			errorPass = classDriver.driver.findElement(By.id("note_pass")).getText();
			
			if(errorUser.equals("*") && errorPass.equals("*")) {
				actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
				
				errorSweet = "Tài khoản hoặc mật khẩu không đúng";
				successSweet = "Đăng nhập thành công!";
				
				if(actual.equals(successSweet)) {
					user.setResult(true);
				}
				else if(actual.equals(errorSweet)) {
					user.setResult(false);
					user.setError(errorSweet);
				}
			}
			else {
				user.setResult(false);
				if(!errorUser.equals("*")) {
					temp = errorUser;
					if(!errorPass.equals("*")) {
						temp = temp + " && " + errorPass;
					}
				}
				else {
					if(!errorPass.equals("*")) {
						temp = errorPass;
					}
				}
				user.setError(temp);
				
			}
			classDriver.driver.navigate().refresh();
		}
		
		classDriver.driver.close();
		
		XuatExcel xuatExcel = new XuatExcel();
		xuatExcel.resultDangNhap(list);
	}
		
}
