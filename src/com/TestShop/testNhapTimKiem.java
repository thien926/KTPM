package com.TestShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.WebDriver.webDriver;

public class testNhapTimKiem {
public webDriver classDriver;
	
	public void setWebDriver() {
		if(this.classDriver == null) {
			this.classDriver = new webDriver();
			this.classDriver.setWebDriverHome();
		}
		else {
			this.classDriver.setWebDriverLogin();
		}
	}
	
	// Nhập thanh tìm kiếm
	@Test(priority = 1)
	public void testNhapThanhTimKiem() {
		setWebDriver();
		
		classDriver.driver.findElement(By.id("input_search")).sendKeys("Lê Minh Loan");
		classDriver.driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[1]/div/form/a")).click();
		
		String actual = classDriver.driver.getTitle();
		String expected = "Koparion | Shop";
		
		// Kiểm tra đã qua trang shop chưa
		Assert.assertEquals(actual, expected);
		
		// Kiểm tra kết quả tìm kiếm
		actual = classDriver.driver.findElement(By.id("tieu_de")).getText();
		expected = "KẾT QUẢ TÌM KIẾM: LÊ MINH LOAN";
		classDriver.driver.close();
		Assert.assertEquals(actual, expected);
	}
}
