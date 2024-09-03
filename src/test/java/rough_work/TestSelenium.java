package rough_work;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.DriverManager;

public class TestSelenium {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		System.out.println("Clicked the PIM");
		WebElement resultCount = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span"));
		wait.until(ExpectedConditions.visibilityOf(resultCount));
		driver.findElement(By.xpath("(//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input)[1]")).sendKeys("Vinoth");
		System.out.println("Enter the VInoth in employee name field");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Clicked search button");
		wait.until(ExpectedConditions.visibilityOf(resultCount));
		int size = driver.findElements(By.xpath("//div[@role='row']")).size();
		
		
		
		System.out.println(size);
		
		
	}

}
