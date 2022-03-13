package usesOfJavaSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableWithPagination {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		String text=driver.findElement(By.xpath("//*[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);
		
	  int numberOfPage=Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
	  System.out.println("numberOfPage: "+numberOfPage);
	  
	  
	  for(int p=1; p<=4; p++) {
		 List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
	      int numberOfRow=rows.size();
	      
	      for(int r=1; r<=numberOfRow; r++) {
	    	  
	    	  String orderId=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
	    	  String customer=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
	    	  String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();

	      if(status.equalsIgnoreCase("Pending")) {
	    	  System.out.println(orderId+"       "+customer+"        "+status);
	      }
	      	      }
	      
	      if(p!=numberOfPage) {
	      String nextPageNumber=Integer.toString(p+1);
	      
	      driver.findElement(By.xpath("//a[normalize-space()='"+nextPageNumber+"']")).click();
	      }
 }
	  
	  
	}

}
