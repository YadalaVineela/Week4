package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeaftapsWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCsr");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");		
		driver.findElement(By.xpath("//input[contains(@class,'decorative')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//a[contains(@href,'fieldlookup2')])[1]")).click();
		Thread.sleep(3000);
		Set<String> windowHandlesfrom = driver.getWindowHandles();
		List<String> openwindowsfrom= new ArrayList<String>(windowHandlesfrom);
		driver.switchTo().window(openwindowsfrom.get(1));
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a")).click();
		driver.switchTo().window(openwindowsfrom.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(@href,'fieldlookup')])[2]")).click();
		Set<String> windowHandlesto = driver.getWindowHandles();
		List<String> openwindowsto= new ArrayList<String>(windowHandlesto);
		driver.switchTo().window(openwindowsto.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a)[2]")).click();
		driver.switchTo().window(openwindowsto.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		String title = driver.getTitle();
		System.out.println("Title of page is"+":"+title);
		driver.close();

	}

}
