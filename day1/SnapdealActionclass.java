package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealActionclass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.snapdeal.com/");
		WebElement men_fashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
		Actions ac= new Actions(driver);
		ac.moveToElement(men_fashion).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String countOfShoes = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'sort-drop')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("500");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		//driver.findElement(By.xpath("//label[@for='Color_s-Yellow']")).click();
		WebElement img = driver.findElement(By.xpath("//img[@title='ASIAN Black Training Shoes']"));
		Actions a= new Actions(driver);
		a.moveToElement(img).perform();
		driver.findElement(By.xpath("//div[@pogid='680551486989']")).click();
		
		

	}

}
