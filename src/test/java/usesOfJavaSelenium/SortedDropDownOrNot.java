package usesOfJavaSelenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedDropDownOrNot {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		
		//List<WebElement> menu=driver.findElements(By.tagName("select"));
		//System.out.println(menu.size());
		
    Select dropDown=new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
    List<WebElement> allOptions= dropDown.getOptions();
    List<String> originalOptions= new ArrayList<String>();
    List<String> tempOptions= new ArrayList<String>();

    for(WebElement option: allOptions){
    originalOptions.add(option.getText());
    tempOptions.add(option.getText());
    }

    Collections.sort(tempOptions);

    if(originalOptions.equals(tempOptions))
    {
   System.out.println("products are sorted");
    }
    else
    { 
    	 System.out.println("products are not sorted");
    }

	
   }
	
	
}
