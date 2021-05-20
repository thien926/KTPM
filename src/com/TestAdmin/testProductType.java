package com.TestAdmin;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BasicClass.ProductType;
import com.BasicClass.User;
import com.WebDriver.webDriver;
import com.WorkWithExcel.DocExcel;
import com.WorkWithExcel.XuatExcel;

public class testProductType {
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
	
	public void DangNhapAdmin() {
		classDriver.driver.findElement(By.name("user")).sendKeys("admin");
		classDriver.driver.findElement(By.name("pass")).sendKeys("admin");
		classDriver.driver.findElement(By.name("commit")).click();
		
		classDriver.driver.findElement(By.className("swal2-confirm")).click();
		waitWeb(1000);
	}
	
	@Test(priority = 1)
	public void testThemLoaiSanPham() {
		DocExcel docExcel = new DocExcel();
		ArrayList<ProductType> list = docExcel.DocExcelThemLoaiSanPham();
		setWebDriver();
		
		DangNhapAdmin();
		
		classDriver.driver.findElement(By.id("menuLoaiSanPham")).click();
		
		String error = "", actual = "";
		
		
		for(ProductType p : list) {
			
			classDriver.driver.findElement(By.id("btnThemLoaiSanPham")).click();
//			waitWeb(1000);
			System.out.println("Mã loại sản phẩm: " + classDriver.driver.findElement(By.id("maloaiSua")).getAttribute("value"));
			p.setId(Integer.parseInt(classDriver.driver.findElement(By.id("maloaiSua")).getAttribute("value")));
			classDriver.driver.findElement(By.id("tenloaiSua")).sendKeys(p.getname());
			classDriver.driver.findElement(By.id("motaSua")).sendKeys(p.getdescribe());
			classDriver.driver.findElement(By.id("buttonkhungLoaiSanPham")).click();
			
			actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
			if(actual.equals("Thêm thành công")) {
				p.setResult(true);
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
			}
			else {
				error = classDriver.driver.findElement(By.id("swal2-content")).getText();
				p.setError(error);
				p.setResult(false);
				
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
				classDriver.driver.findElement(By.id("closekhungLoaiSanPham")).click();
			}
		}
		
		classDriver.driver.close();
		
		XuatExcel xuatExcel = new XuatExcel();
		xuatExcel.resultThemLoaiSanPham(list);
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
