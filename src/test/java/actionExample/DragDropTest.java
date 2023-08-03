package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(8000);
		driver.close();
		
	}

	@Test
	public void verifyWishList() throws Exception {
		
		WebElement photoframe = driver.findElement(By.cssSelector("iframe[data-src*='photo-manager']"));
		driver.switchTo().frame(photoframe);
		
		
		
		WebElement img3 = driver.findElement(By.cssSelector("img[src*='tatras3']"));
		WebElement img4 = driver.findElement(By.cssSelector("img[src*='tatras4']"));
		
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
	
		Actions act = new Actions(driver);
		
		//app1
		act.dragAndDrop(img3, trash).perform();
		//act.dragAndDrop(img4, trash).perform();
		
		
		Thread.sleep(4000);
		
		//app2
		//A convenience method that performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, then releases the mouse.
		
		act.clickAndHold(img4).moveToElement(trash).release().perform();
		
		
	}
	
	
}
