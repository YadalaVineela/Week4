package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		cd.get("https://www.nykaa.com/");
		WebElement brands_ele = cd.findElement(By.xpath("//a[text()='brands']"));
		Actions a= new Actions(cd);
		a.moveToElement(brands_ele).perform();
		cd.findElement(By.xpath("//div[@id='brandCont_Popular']/ul/li[5]/a")).click();
		String title = cd.getTitle();
		System.out.println(title);
		cd.findElement(By.xpath("//button[contains(@class,'1aucgde')]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[contains(text(),'top rated')]")).click();
		cd.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[text()='Hair']/following::span")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("(//span[text()='Hair Care'])[2]/following-sibling::span")).click();
		cd.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']//div[2]")).click();
		cd.findElement(By.xpath("//span[text()='Concern']/following-sibling::div")).click();
		cd.findElement(By.xpath("//input[contains(@id,'checkbox_Color Protection')]/following-sibling::label")).click();
		String filter_text = cd.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
		if(filter_text.equals("Shampoo"))
		{
			System.out.println("shampoo is in filter");
			
		}
		else
		{
			System.out.println("filter is "+":"+filter_text);
		}
		cd.findElement(By.xpath("//a[contains(@href,'color-protect-shampoo')]")).click();
		Set<String> windowHandles = cd.getWindowHandles();
		List<String>windows_open= new ArrayList<String>(windowHandles);
		cd.switchTo().window(windows_open.get(1));
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[text()='704ml']")).click();
		String price = cd.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
		System.out.println("price of shampoo is"+":"+price);
		cd.findElement(By.xpath("(//span[text()='Add to Bag']/parent::button)[1]")).click();
		cd.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(3000);
		cd.switchTo().frame(cd.findElement(By.xpath("//iframe[@class='css-acpm4k']")));
		String grand_Total = cd.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
	    System.out.println("Grand total is "+":"+grand_Total);
		cd.findElement(By.xpath("(//button[@class='css-1j2bj5f e8tshxd0'])[2]")).click();
		Thread.sleep(2000);
		cd.switchTo().defaultContent();
	    //cd.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']//img")).click();
	    cd.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	    cd.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']//img")).click();
	    String price_to_pay = cd.findElement(By.xpath("(//p[text()='Price Details']/following::p)[1]")).getText();
	    if(grand_Total.equals(price_to_pay))
	    {
	    	System.out.println("grand total is same as price to pay");
	    }
	    cd.quit();
	
	
	}

}
