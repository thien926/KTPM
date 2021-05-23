package com.TestAdmin;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BasicClass.Product;
import com.BasicClass.ProductType;
import com.WebDriver.webDriver;
import com.WorkWithExcel.DocExcel;
import com.WorkWithExcel.XuatExcel;

public class testSanPham {
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
	
//	@Test(priority = 1)
//	public void testAddSanPham() {
//		DocExcel docExcel = new DocExcel();
//		ArrayList<Product> list = docExcel.DocExcelThemSanPham();
//		setWebDriver();
//		
//		DangNhapAdmin();
//		
//		String error = "", actual = "";
//		for(Product p : list) {
//			classDriver.driver.findElement(By.id("menuSanPham")).click();
//			classDriver.driver.findElement(By.id("btnThemSanPham")).click();
//			waitWeb(500);
//			classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			p.setProduct_id(Integer.parseInt(classDriver.driver.findElement(By.id("maspThem")).getAttribute("value")));
//			
////			classDriver.driver.findElement(By.id("tenspThem")).clear();
//			classDriver.driver.findElement(By.id("tenspThem")).sendKeys(p.getName());
//			
//			classDriver.driver.findElement(By.id("chonCompany")).sendKeys(p.getProduct_type());
//			
////			classDriver.driver.findElement(By.id("authorThem")).clear();
//			classDriver.driver.findElement(By.id("authorThem")).sendKeys(p.getAuthor());
//			
////			classDriver.driver.findElement(By.id("nxbThem")).clear();
//			classDriver.driver.findElement(By.id("nxbThem")).sendKeys(p.getNxb());
//			
////			classDriver.driver.findElement(By.id("inputimg")).clear();
//			if(!p.getImg().equals("")) {
//				classDriver.driver.findElement(By.id("inputimg")).sendKeys(p.getImg());
//
//			}
//			
//			classDriver.driver.findElement(By.id("amountThem")).clear();
//			classDriver.driver.findElement(By.id("amountThem")).sendKeys(Integer.toString(p.getAmount()));
//			
////			classDriver.driver.findElement(By.id("priceThem")).clear();
//			classDriver.driver.findElement(By.id("priceThem")).sendKeys(Long.toString(p.getPrice()));
//			
//			classDriver.driver.findElement(By.id("sailThem")).sendKeys(p.getSail());
//			
////			classDriver.driver.findElement(By.id("descriptThem")).clear();
//			classDriver.driver.findElement(By.id("descriptThem")).sendKeys(p.getDescript());
//			
//			classDriver.driver.findElement(By.id("statusThem")).sendKeys(p.getStatus());
//			
//			classDriver.driver.findElement(By.id("btnSubmitThemSanPham")).click();
//			
//			
//			waitWeb(500);
//			classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
//			if(actual.equals("Thêm thành công!")) {
//				p.setResult(true);
//				classDriver.driver.findElement(By.className("swal2-confirm")).click();
//			}
//			else {
//				error = classDriver.driver.findElement(By.id("swal2-content")).getText();
//				p.setError(error);
//				p.setResult(false);
//				
//				classDriver.driver.findElement(By.className("swal2-confirm")).click();
//			}
//			classDriver.driver.navigate().refresh();
//			waitWeb(1000);
//		}
//		
//		classDriver.driver.close();
//		
//		XuatExcel xuatExcel = new XuatExcel();
//		xuatExcel.resultThemSanPham(list);
//	}
	
	@Test(priority = 2)
	public void testRepairSanPham() {
		DocExcel docExcel = new DocExcel();
		ArrayList<Product> list = docExcel.DocExcelSuaSanPham();
		setWebDriver();
		
		DangNhapAdmin();
		
		String error = "", actual = "";
		for(Product p : list) {
			classDriver.driver.findElement(By.id("menuSanPham")).click();
			classDriver.driver.findElement(By.id("toolSuaSP" + p.getProduct_id())).click();
			waitWeb(500);
			classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			classDriver.driver.findElement(By.id("tensp1")).clear();
			classDriver.driver.findElement(By.id("tensp1")).sendKeys(p.getName());
			
			classDriver.driver.findElement(By.id("suachonCompany")).sendKeys(p.getProduct_type());
			
			classDriver.driver.findElement(By.xpath("//*[@id=\"tacgia\"]/input")).clear();
			classDriver.driver.findElement(By.xpath("//*[@id=\"tacgia\"]/input")).sendKeys(p.getAuthor());
			
			classDriver.driver.findElement(By.xpath("//*[@id=\"nxb\"]/input")).clear();
			classDriver.driver.findElement(By.xpath("//*[@id=\"nxb\"]/input")).sendKeys(p.getNxb());
			
			classDriver.driver.findElement(By.id("inputimg1")).clear();
			if(!p.getImg().equals("")) {
				classDriver.driver.findElement(By.id("inputimg1")).sendKeys(p.getImg());

			}
			
			classDriver.driver.findElement(By.id("soluong")).clear();
			classDriver.driver.findElement(By.id("soluong")).sendKeys(Integer.toString(p.getAmount()));
			
			classDriver.driver.findElement(By.id("giatien")).clear();
			classDriver.driver.findElement(By.id("giatien")).sendKeys(Long.toString(p.getPrice()));
			
			classDriver.driver.findElement(By.id("chonKhuyenMai")).sendKeys(p.getSail());
			
			classDriver.driver.findElement(By.id("mota")).clear();
			classDriver.driver.findElement(By.id("mota")).sendKeys(p.getDescript());
			
			classDriver.driver.findElement(By.id("ttsua")).sendKeys(p.getStatus());
			
			classDriver.driver.findElement(By.id("btnSubmitSuaSanPham")).click();
			
			
			waitWeb(500);
			classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
			if(actual.equals("Sửa thành công")) {
				p.setResult(true);
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
			}
			else {
				error = classDriver.driver.findElement(By.id("swal2-content")).getText();
				p.setError(error);
				p.setResult(false);
				
				classDriver.driver.findElement(By.className("swal2-confirm")).click();
			}
			classDriver.driver.navigate().refresh();
			waitWeb(1000);
		}
		
		classDriver.driver.close();
		
		XuatExcel xuatExcel = new XuatExcel();
		xuatExcel.resultSuaSanPham(list);
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
