package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Testng_Salesforce extends BaseClass{

	@Test
	public void Newrun() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[1]")).click();
		Thread.sleep(2000);
		WebElement webElement = driver.findElement(By.xpath("//span[text()='New Opportunity']"));
		driver.executeScript("arguments[0].click()", webElement);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("Salesforce Automation by Vinee");
		String name_in_opportunity = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).getText();
		System.out.println("name entered is"+":"+name_in_opportunity);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/07/1994");
		driver.findElement(By.xpath("(//button[contains(@class,'combobox__input ')])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Needs Analysis']")).click();
		driver.findElement(By.xpath("(//li[@class='slds-button-group-item visible'])[3]")).click();
		WebElement element = driver.findElement(By.xpath("(//div[@class='entityNameTitle slds-line-height--reset']/following-sibling::slot)[1]"));
		System.out.println("Opportunity created is"+":"+element.getText());

	}

}
