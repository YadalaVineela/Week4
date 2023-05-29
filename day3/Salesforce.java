package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
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
		driver.close();
	}

}
