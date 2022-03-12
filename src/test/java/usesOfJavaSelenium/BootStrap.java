package usesOfJavaSelenium;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrap {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		clickOnText();
	}
	
	
	public static void dropDown(String text) {
		
		WebElement signInBootStrap=driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[@id='nav-link-accountList-nav-line-1']"));
		
		Actions obj=new Actions(driver);
		obj.moveToElement(signInBootStrap).build().perform();
		List<WebElement> allOptions=driver.findElements(By.xpath("//div[@id='nav-al-your-account']//a"));
		
		for(WebElement option:allOptions) {
			if(option.getText().equalsIgnoreCase(text)) {
				option.click();
				break;
			}
		}
	}

	
	
	public static void clickOnText() {
		dropDown("Register for a Business Account");
		driver.navigate().back();
		dropDown("Music Library");
		
		driver.navigate().back();
		
		dropDown("Recommendations");
		driver.navigate().back();
		
		dropDown("orders");
		
		
		
	}
	
	
	
}
