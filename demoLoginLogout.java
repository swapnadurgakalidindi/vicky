package demoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoLoginLogout {
	 // WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ExcelLibrary xlib=new ExcelLibrary();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	int lastrownumb=  xlib.getLastRowNumber("Sheet1")  ;
	    
		for (int i = 1; i <=lastrownumb; i++) {
			String un=xlib.getExcelData("sheet1", i, 0);
		    String pw=xlib.getExcelData("sheet1", i, 1);
		    
		    driver.findElement(By.name("username")).sendKeys(un);
			driver.findElement(By.name("password")).sendKeys(pw);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
	    
	    driver.close();
		
	}

}
