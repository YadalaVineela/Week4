package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Testng_CreateOpp extends BaseClass{

	@Test
	public void Create_Opp() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click()", element);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("24/04/2023");
		driver.findElement(By.xpath("(//li[@class='slds-button-group-item visible'])[3]")).click();
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//div[@class='genericNotification']")).getText();
		System.out.println("message displayed is"+":"+text2);
		
		

	}

}
