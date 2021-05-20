package com.TestShop;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BasicClass.ClassDatHang;
import com.BasicClass.User;
import com.WebDriver.webDriver;
import com.WorkWithExcel.DocExcel;
import com.WorkWithExcel.XuatExcel;

public class testDatHang {
	public webDriver classDriver;
	
	public void setWebDriver() {
		if(this.classDriver == null) {
			this.classDriver = new webDriver();
			this.classDriver.setWebDriverShop();
		}
		else {
			this.classDriver.setWebDriverShop();
		}
	}
	
	// Test chọn danh mục sản phẩm
	@Test(priority = 1)
	public void test_DatHang() {
		
		DocExcel docExcel = new DocExcel();
		ArrayList<ClassDatHang> list = docExcel.DocExcelDatHang();
		
		setWebDriver();
		classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String errorUser = "", errorPass = "", actual = "", errorSweet = "", successSweet = "", errorSweetNone = "", errorSweetLogin = "";
		String temp = "";
		int statusLogin = -1;
		int index = 0;
		for(ClassDatHang U : list) {
			++index;
			System.out.println("Index: " + index);
			temp = "";
			statusLogin = -1;
			// Test đăng nhập có thành công không - có lỗi khi đăng nhập hay không
			if(!U.getUser().equals("") && !U.getPass().equals("")) {
				classDriver.driver.findElement(By.xpath("//*[@id=\"dn\"]/a")).click();
				
				classDriver.driver.findElement(By.id("user")).sendKeys(U.getUser());
				classDriver.driver.findElement(By.id("pass")).sendKeys(U.getPass());
				classDriver.driver.findElement(By.className("single-login-2")).click();
				
				errorUser = classDriver.driver.findElement(By.id("note_user")).getText();
				errorPass = classDriver.driver.findElement(By.id("note_pass")).getText();
				
				if(errorUser.equals("*") && errorPass.equals("*")) {
					actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
					classDriver.driver.findElement(By.className("swal2-confirm")).click();
					
					errorSweet = "Tài khoản hoặc mật khẩu không đúng";
					successSweet = "Đăng nhập thành công!";
					
					if(actual.equals(successSweet)) {
						statusLogin = 1;
					}
					else if(actual.equals(errorSweet)) {
						U.setError(errorSweet);
						statusLogin = 0;
					}
				}
				else {
					statusLogin = 0;
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
					U.setError(temp);
				}
				classDriver.driver.navigate().back();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			switch(statusLogin) {
				case -1 : {
				}
				case 1: {
					try {
						// click vào loại sản phẩm
						classDriver.driver.findElement(By.linkText(U.getTypeProduct())).click();
					}
					catch (Exception e) {
					}
					
					// Tiến hành các hành động chọn sản phẩm và thêm vào giỏ
					ArrayList<Integer> listMASPRemove = new ArrayList<>();
					ArrayList<Integer> listMASP = new ArrayList<>();
					String txtMasp = "";
					if(!U.getProduct().equals("")) {
						String[] dauVa = U.getProduct().split("&");
						System.out.println("dauVa: " + dauVa.length);
						for(String q : dauVa) {
							String[] dauNgang = q.split("-");
							classDriver.driver.findElement(By.xpath("//*[@id=\"show_sp\"]/div["+ dauNgang[0] +"]/div/div[2]/h4/a")).click();
							classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							classDriver.driver.findElement(By.id("soluong")).sendKeys(dauNgang[1]);
							
							txtMasp = classDriver.driver.findElement(By.id("data_masp")).getText();
							listMASP.add(Integer.parseInt(txtMasp));
							if(U.getRemove().contains(dauNgang[0])) {
								listMASPRemove.add(Integer.parseInt(txtMasp));
							}
							System.out.println("dauNgang 1: " + dauNgang[1]);

							classDriver.driver.findElement(By.xpath("//*[@id=\"load_detail_sp\"]/div[2]/div/div[3]/form/a")).click();
							classDriver.driver.findElement(By.className("swal2-confirm")).click();
							classDriver.driver.navigate().back();
						}
						
					}
					// Tiến hành vào trang giỏ hàng
					classDriver.driver.findElement(By.linkText("GIỎ HÀNG")).click();
					for(Integer qq : listMASPRemove) {
						classDriver.driver.findElement(By.id("xoa_sp" + qq)).click();
					}
					
					if(U.getTypeAddress()) {
						classDriver.driver.findElement(By.id("thay_doi_dia_chi")).sendKeys("Chọn địa chỉ nhận hàng khác");
						classDriver.driver.findElement(By.id("dc_tt_khac")).sendKeys(U.getAddress());
					}
					
					// Đặt hàng
					classDriver.driver.findElement(By.xpath("//*[@id=\"khung_thanh_toan\"]/div/a")).click();
					
					classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if(classDriver.driver.findElement(By.id("total_thanh_tien")).getText().equals("KHÔNG TÍNH TOÁN ĐƯỢC")) {
						U.setError("Chưa có sản phẩm nào cần đặt hàng");
						U.setResult(false);
					}
					else {
						actual = classDriver.driver.findElement(By.id("swal2-title")).getText();
						classDriver.driver.findElement(By.className("swal2-confirm")).click();
						successSweet = "Đặt hàng thành công!";
						errorSweet = "Bạn chưa chọn địa chỉ giao hàng!";
						errorSweetNone = "Chưa có sản phẩm nào cần đặt hàng";
						errorSweetLogin = "Bạn chưa đăng nhập. Hãy đăng nhập trước khi đặt hàng!";
						
						if(actual.equals(successSweet)) {
							U.setResult(true);
						}
						else if(actual.equals(errorSweet)){
							U.setError(errorSweet);
							for(Integer qq : listMASP) {
								for(Integer qqq : listMASPRemove) {
									if(qq != qqq) {
										classDriver.driver.findElement(By.id("xoa_sp" + qq)).click();
									}
								}
							}
							U.setResult(false);
						}
						else if(actual.equals(errorSweetNone)) {
							U.setError(errorSweetNone);
							U.setResult(false);
						}
						else if(actual.equals(errorSweetLogin)) {
							U.setError(errorSweetLogin);
							for(Integer qq : listMASP) {
								for(Integer qqq : listMASPRemove) {
									if(qq != qqq) {
										classDriver.driver.findElement(By.id("xoa_sp" + qq)).click();
									}
								}
							}
							U.setResult(false);
						}
					}
					
					classDriver.driver.navigate().back();
					classDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						// click vào loại sản phẩm
						classDriver.driver.findElement(By.linkText("Đăng Xuất")).click();
						classDriver.driver.findElement(By.className("swal2-confirm")).click();
						try {
							classDriver.driver.findElement(By.className("swal2-confirm")).click();
						}catch(Exception e) {}
					}
					catch (Exception e) {
					}
					break;
				}
				case 0 : {
					U.setResult(false);
					break;
				}
				default : break;
			}
		}
		
		classDriver.driver.close();
		XuatExcel xuatExcel = new XuatExcel();
		xuatExcel.resultDatHang(list);
	}
	
	
	
}
