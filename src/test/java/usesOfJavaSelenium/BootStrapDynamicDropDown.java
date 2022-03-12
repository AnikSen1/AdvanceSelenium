package usesOfJavaSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDynamicDropDown {
	static WebDriver driver;

	

	public void chooseDropDown(String text) {
		WebElement signinBootstrap=driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[@id='nav-link-accountList-nav-line-1']"));
		Actions action=new Actions(driver);
		action.moveToElement(signinBootstrap).build().perform();
		List <WebElement> allOptions = driver.findElements(By.xpath("//div[@id='nav-al-your-account']//a"));
		for(WebElement option:allOptions) {

			if(option.getText().equalsIgnoreCase(text)) {
				option.click();
				break;
			}

		}

	}
		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.amazon.com/");
			//a[@id='nav-link-accountList']//span[@id='nav-link-accountList-nav-line-1']

			BootStrapDynamicDropDown obj=new BootStrapDynamicDropDown();
			obj.chooseDropDown("Register for a Business Account");
			Thread.sleep(5000);
			driver.navigate().back();
			obj.chooseDropDown("Music Library");
			driver.navigate().back();
			obj.chooseDropDown("Recommendations");
			obj.chooseDropDown("Browsing History");
			
			
		

	}


}
