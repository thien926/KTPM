package com.TestAdmin;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BasicClass.User;
import com.WebDriver.webDriver;
import com.WorkWithExcel.DocExcel;
import com.WorkWithExcel.XuatExcel;

public class testDangNhapAdmin {
public webDriver classDriver;
	
	public void setWebDriver() {
		if(this.classDriver == null) {
			this.classDriver = new webDriver();
			this.classDriver.setWebDriverLoginAdmin();
		}
		else {
			this.classDriver.setWebDriverLoginAdmin();
		}
	}
	
	// Test đăng nhập
	@Test(priority = 1)
	public void test_DangNhapAdmin() {
		DocExcel docExcel = new DocExcel();
		ArrayList<User> list = docExcel.DocExcelTaiKhoanDangNhapAdmin();
		setWebDriver();
		
		String actual = "", error = "";
		
		
		for(User user : list) {
			classDriver.driver.findElement(By.name("user")).sendKeys(user.getUser());
			classDriver.driver.findElement(By.name("pass")).sendKeys(user.getPass());
			classDriver.driver.findElement(By.name("commit")).click();
			waitWeb(1000);
			
			actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
			classDriver.driver.findElement(By.className("swal2-confirm")).click();
			
			if(actual.equals("Đăng nhập thành công!")) {
				user.setResult(true);
				classDriver.driver.findElement(By.id("btnDangXuat")).click();
				waitWeb(1000);
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
				waitWeb(1000);
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
			}
			else {
				error = classDriver.driver.findElement(By.id("swal2-content")).getText();
				user.setResult(false);
				user.setError(error);
			}
			
			
			classDriver.driver.navigate().refresh();
			waitWeb(1000);
		}
		
		classDriver.driver.close();
		
		XuatExcel xuatExcel = new XuatExcel();
		xuatExcel.resultDangNhapAdmin(list);
	}
	
	public void waitWeb(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
