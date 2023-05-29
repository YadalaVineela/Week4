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

public class WindowAndScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/");
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();		
		String title = driver.getTitle();
		System.out.println("Title of page is"+":"+title);
		List<String> window_names= new ArrayList<String>(windowHandles);
		 File scr1 = driver.getScreenshotAs(OutputType.FILE);
	     File dst1=new File("./Screenshots/s1.png");
	     FileUtils.copyFile(scr1, dst1);
         driver.close();	
         driver.switchTo().window(window_names.get(1));
         String parent_title = driver.getTitle();
         System.out.println(parent_title);
         driver.close();	
		
	}

}
