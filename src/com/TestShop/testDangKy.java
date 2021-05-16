package com.TestShop;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BasicClass.NewUser;
import com.BasicClass.User;
import com.WebDriver.webDriver;
import com.WorkWithExcel.DocExcel;
import com.WorkWithExcel.XuatExcel;

public class testDangKy {
public webDriver classDriver;
	
	public void setWebDriver() {
		if(this.classDriver == null) {
			this.classDriver = new webDriver();
			this.classDriver.setWebDriverRegister();
		}
		else {
			this.classDriver.setWebDriverRegister();
		}
	}
	
	// Test đăng ký
	@Test(priority = 1)
	public void test_DangKy() {
		// Trước khí chạy xóa các tài khoản cần test đã có trong database : DELETE FROM `nguoidung` WHERE taikhoan LIKE "%thinh%"
		DocExcel docExcel = new DocExcel();
		ArrayList<NewUser> list = docExcel.DocExcelTaiKhoanDangKy();
		setWebDriver();
		
		String actual = "", errorSweet = "", successSweet = "", errorSweet1 = "";
		String temp = "";
		boolean tError = false;
		
		for(NewUser user : list) {
			tError = false;
			
			classDriver.driver.findElement(By.id("name")).sendKeys(user.getFullname());
			classDriver.driver.findElement(By.id("user")).sendKeys(user.getUser());
			classDriver.driver.findElement(By.id("pass")).sendKeys(user.getPass());
			classDriver.driver.findElement(By.id("replay_pass")).sendKeys(user.getRepass());
			classDriver.driver.findElement(By.id("mail")).sendKeys(user.getEmail());
			classDriver.driver.findElement(By.id("phone")).sendKeys(user.getPhone());
			classDriver.driver.findElement(By.id("address")).sendKeys(user.getAddress());
			if(user.getGender().equals("Nam")) {
				classDriver.driver.findElement(By.id("nam")).click();
			}
			else if(user.getGender().equals("Nữ")) {
				classDriver.driver.findElement(By.id("nu")).click();
			}
			
			if(!user.getBorn().equals("")) {
				String[] ss = user.getBorn().split("/");
				classDriver.driver.findElement(By.id("ngay")).sendKeys(ss[0]);
				classDriver.driver.findElement(By.id("thang")).sendKeys(ss[1]);
				classDriver.driver.findElement(By.id("year")).sendKeys(ss[2]);
			}
			
			// Click đăng ký
			classDriver.driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[9]/a")).click();
			
			temp = classDriver.driver.findElement(By.id("note_name")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_user")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_pass")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_replay_pass")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_mail")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_phone")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_diachi")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_sex")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			temp = classDriver.driver.findElement(By.id("note_date")).getText();
			if(!temp.equals("*")) {
				if(!temp.equals("")) {
					tError = true;
					user.setError(user.getError() + temp + "\n");
				}
			}
			
			if(tError) {
				user.setResult(!tError);
				System.out.println("tError: " + tError + " " + user.getError() + "-" + user.getUser());
			}
			else {
				System.out.println(user.getUser());
				actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
				
				errorSweet = "Tài khoản đã tồn tại!";
				errorSweet1 = "Lỗi đăng ký tài khoản";
				successSweet = "Đăng kí thành công!";
				
				if(actual.equals(successSweet)) {
					user.setResult(true);
				}
				else if(actual.equals(errorSweet)) {
					user.setResult(false);
					user.setError(errorSweet);
				}
				else if(actual.equals(errorSweet1)) {
					user.setResult(false);
					user.setError(errorSweet1);
				}
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
			}
			
			classDriver.driver.navigate().refresh();
		}
		
		classDriver.driver.close();
		
		XuatExcel xuatExcel = new XuatExcel();
		xuatExcel.resultDangKy(list);
	}
}
