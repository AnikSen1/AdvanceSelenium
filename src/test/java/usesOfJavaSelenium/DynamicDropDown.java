package usesOfJavaSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDown {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		DynamicDropDown obj=new DynamicDropDown();
		
	WebElement dropDownAll=driver.findElement(By.cssSelector("select#searchDropdownBox"));
	WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
    obj.chooseDropDown(dropDownAll, searchIcon, "Baby");
   

	}

   public void chooseDropDown(WebElement dropDown, WebElement search, String text) {
	   Select sel = new Select (dropDown);
	List <WebElement> options = sel.getOptions();
	
	for(WebElement option:options) {
		
		if(option.getText().equalsIgnoreCase(text)) {
			
			option.click();
			search.click();
			break;
		}
		
	}
	
	
	
	
   }
	
	
}
