package usesOfJavaSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		
		List<WebElement> allOptions=driver.findElements(By.xpath("//ul[@class='G43f7e']//span[text()='selenium']"));
	
		for(WebElement option:allOptions) {
			if(option.getText().contains("questions")) {
				option.click();
				break;
			}
		}
	
	
	
	}
}
