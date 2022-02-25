package usesOfJavaSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnderlineCheck {
	public static void main(String[] args) throws InterruptedException { 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.get("https://www.google.co.in/?gfe_rd=ctrl&amp;ei=bXAwU8jYN4W6iAf8zIDgDA&amp;gws_rd=cr"); 
		Thread.sleep(5000);
	
		
		String cssValue_1= driver.findElement(By.xpath("//*[contains(text(),'Terms')]")).getCssValue("text-decoration"); 
		System.out.println("get Css Value: "+cssValue_1); 
		Actions act = new Actions(driver); 
		act.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Terms')]"))).build().perform(); 
		
		String cssValue_2= driver.findElement(By.xpath("//*[contains(text(),'Terms')]")).getCssValue("text-decoration"); 
		System.out.println("get Css Value after mouse hover: "+cssValue_2); 
		
		
		
		//driver.close(); 
		 }
}
