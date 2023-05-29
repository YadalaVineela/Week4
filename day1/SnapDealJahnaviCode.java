package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDealJahnaviCode {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		cd.get("https://www.snapdeal.com/");
		cd.findElement(By.id("pushDenied"));
		WebElement mouseHover1 = cd.findElement(By.xpath("//span[contains(text(),' Fashion')]"));
		Actions hover = new Actions(cd);
		hover.moveToElement(mouseHover1).perform();
		
		cd.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]")).click();
		String sportsShoe = cd.findElement(By.xpath("(//a[contains(@class,'child-cat-node dp')])[2]")).getText();
		System.out.println(sportsShoe);
		cd.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		cd.findElement(By.xpath("//div[contains(@class,'sort-drop')]")).click();
		Thread.sleep(5000);
		cd.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(3000);
		String firstPrice = cd.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]")).getText();
				String r1 = firstPrice.replaceAll("Rs. ", "");
				int firstPriceVal = Integer.parseInt(r1);
		String secondPrice = cd.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]")).getText();
				String s1 = secondPrice.replaceAll("Rs. ", "");
				int secondPriceVal = Integer.parseInt(s1);
				if(firstPriceVal<secondPriceVal) {
					System.out.println("The items are sorted as expected");
				}else {
					System.out.println("The items are unsorted");
				}
		WebElement inpfrom = cd.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
				inpfrom.clear();
				inpfrom.sendKeys("500");
		WebElement inpto = cd.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
				inpto.clear();
				inpto.sendKeys("1200");
		cd.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
		cd.findElement(By.xpath("//input[@value='Navy']/parent::div")).click();
		Thread.sleep(3000);
		String filters = cd.findElement(By.xpath("(//div[@class='filters'])[1]")).getText();
				if(filters.contains("Price:") && filters.contains("Navy")){
					System.out.println("All filters are successfully applied");
				}	else {
					System.out.println("Filters are not applied");
				}
		WebElement mouseHover2 = cd.findElement(By.xpath("//div[text()[normalize-space()='Quick View']]/following::p"));
		Actions quickView = new Actions(cd);
			quickView.moveToElement(mouseHover2).perform();
		Thread.sleep(3000);
		cd.findElement(By.xpath("(//div[@supc='SDL901001171'])[2]")).click();
		String price = cd.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		Thread.sleep(2000);
		String discount = cd.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("The price of the shoe is "+ price+ "with " +discount);
		cd.close();

	}

}
