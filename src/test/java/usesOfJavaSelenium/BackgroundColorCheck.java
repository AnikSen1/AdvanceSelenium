package usesOfJavaSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackgroundColorCheck {
	public static void main(String[] args) throws InterruptedException { 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.get("https://www.google.co.in/?gfe_rd=ctrl&amp;ei=bXAwU8jYN4W6iAf8zIDgDA&amp;gws_rd=cr"); 
		Thread.sleep(5000);
	
		WebElement eleSignin=driver.findElement(By.xpath("//*[contains(text(),'Sign in')]"));
		String cssValue_1=eleSignin.getCssValue("color"); 
		String cssValue_2=eleSignin.getCssValue("background"); 
		if(cssValue_1.equalsIgnoreCase(cssValue_2)) {
			System.out.println("Sign in button doesn't have background color");
		}
		else {
			System.out.println("Sign in button has background color");
		}
		
		//driver.close(); 
		 }
}
