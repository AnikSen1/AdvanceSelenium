package usesOfJavaSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableWithPagination {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);//Showing 1 to 20 of 11775 (589 Pages)
        int numberOfPage=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
        
        System.out.println(numberOfPage);
        
        for(int p=1; p<=3; p++) {
        	List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
             int numberOfRow=rows.size();
             System.out.println(numberOfRow);
             for(int r=1; r<=numberOfRow; r++) {
   String orderId= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
   String customer= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();        
   String status= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();         
             
             if(status.equalsIgnoreCase("pending")) {
            	 System.out.println(orderId+"       "+customer+"        "+status);
             }
             }
        String pageNo=Integer.toString(p+1);
             driver.findElement(By.xpath("//a[normalize-space()='"+pageNo+"']")).click();
        }
        
	}

}
