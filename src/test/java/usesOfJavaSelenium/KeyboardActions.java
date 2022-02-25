package usesOfJavaSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("java");
		String press1 = Keys.chord(Keys.CONTROL,"A"); 
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(press1);
		Thread.sleep(4000);
		String press2 = Keys.chord(Keys.CONTROL+"x");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(press2);
		
      
		
		WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
		Actions ac=new Actions(driver);
		ac.keyDown(search,Keys.SHIFT)
		.sendKeys("Selenium")
		.keyUp(search,Keys.SHIFT)
		.keyDown(search, Keys.CONTROL)
		.sendKeys("a")
		.keyDown(search, Keys.CONTROL)
		.sendKeys("x")
		.keyDown(search, Keys.CONTROL)
		.sendKeys("v")
		.sendKeys(Keys.ENTER)
		.build()
		.perform();
		
		
		//driver.close();
		

	}

}
