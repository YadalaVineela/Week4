package week4.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class AdminCertify {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> openWindows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(openWindows.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow sh= new Shadow(driver);
		sh.setImplicitWait(10);
		sh.findElementByXPath("//span[text()='Learning']").click();
		Thread.sleep(2000);
		Actions ac= new Actions(driver);
		WebElement learningTrailHead = sh.findElementByXPath("//span[text()='Learning on Trailhead']");
		ac.moveToElement(learningTrailHead).perform();
		Thread.sleep(2000);
		sh.findElementByXPath("//a[text()='Salesforce Certification']").click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		List<WebElement> certificates = driver.findElements(By.xpath("//div[text()='Certification']/following::a"));
		System.out.println("number of certificates is"+":"+certificates.size());
		for (WebElement certi : certificates)
		{
			System.out.println("Certificate name is"+":"+certi.getText());
		}
		
		

	}

}
