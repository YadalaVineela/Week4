package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonWindowHandling {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro mobile");
		driver.findElement(By.xpath("(//div[text()='oneplus 9 pro mobile'])[1]")).click();
		String price_of_mobile = driver.findElement(By.xpath("//div[@class='a-icon-row a-spacing-small a-padding-none']")).getText();
		System.out.println("Price of mobile is"+":"+price_of_mobile);
		String noof_customers = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("Number of customers is"+":"+noof_customers);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> mobileWindows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(mobileWindows.get(1));
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshots/AmazonWindowhandling.png");
		FileUtils.copyFile(src, dst);	
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		String subcart_total = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		if(price_of_mobile.equals(subcart_total))
		{
			System.out.println("price matchs");
		}
		else
		{
			System.out.println("price doesn't match");
		}
	}

}
