package dev.teamname.app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeleniumTests {

	static WebDriver driver;
	
	static {
		// Specify where your Chrome driver is
		File f = new File("src/main/resources/chromedriver.exe");
		
		// Set this file as a system property so
		// Selenium knows where to find this file
		System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
		
		// Create a driver and start automating stuff
		driver = new ChromeDriver();
	}
	@Test
	@Order(9)
	void regRestaurant() throws InterruptedException {
		driver.get("localhost:4200/");
		// Click "Sign up"
		WebElement managerLogin = driver.findElement(By.xpath("//span[contains(.,'Sign Up')]"));
		managerLogin.click();
		Thread.sleep(1000);

		// Register as a restaurant
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement checkbox = driver.findElement(By.className("mat-checkbox"));
		WebElement submitBtn = driver.findElement(By.cssSelector("button.log"));
		username.sendKeys("Sonic");
		password.sendKeys("gottagofast");
		checkbox.click();
		submitBtn.click();

		Thread.sleep(2000);
	}

	@Test
	@Order(10)
	void loginNewRest() throws InterruptedException {

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("button.log"));
		username.sendKeys("Sonic");
		password.sendKeys("gottagofast");
		loginBtn.click();
		
		Thread.sleep(2000);
	}

	@Test
	@Order(11)
	void manageRest() throws InterruptedException {
		WebElement restname = driver.findElement(By.id("name"));
		WebElement address  = driver.findElement(By.id("address"));
		restname.sendKeys("Sonic Drive In");
		address.sendKeys("361 Suncrest Towne Centre Drive, Morgantown, WV 26505");
		WebElement dropdown = driver.findElement(By.className("dropdown-btn"));
		dropdown.click();
		Thread.sleep(1000);

		List<WebElement> allCheckboxes = driver.findElements(By.className("multiselect-item-checkbox"));
		WebElement AmericanCheckbox = allCheckboxes.get(3);
		AmericanCheckbox.click();
		dropdown.click();
		
		WebElement submitBtn = driver.findElement(By.cssSelector("button.log"));
		submitBtn.click();
		Thread.sleep(2000);
	}

	@Test
	@Order(12)
	void addChiliDog() throws InterruptedException {
		WebElement item = driver.findElement(By.id("item"));
		WebElement cost = driver.findElement(By.id("cost"));
		WebElement cals = driver.findElement(By.id("cal"));
		
		item.sendKeys("Chili Dog");
		cost.sendKeys("5");
		cals.sendKeys("420");

		WebElement submitBtn = driver.findElement(By.cssSelector("button.log"));
		submitBtn.click();
		Thread.sleep(2000);
		item.clear();
		cost.clear();
		cals.clear();
}
	
	@Test
	@Order(13)
	void addMozz() throws InterruptedException {
		WebElement item = driver.findElement(By.id("item"));
		WebElement cost = driver.findElement(By.id("cost"));
		WebElement cals = driver.findElement(By.id("cal"));
		
		item.sendKeys("Mozzerella Sticks");
		cost.sendKeys("5");
		cals.sendKeys("750");

		WebElement submitBtn = driver.findElement(By.cssSelector("button.log"));
		submitBtn.click();
		Thread.sleep(2000);
}
	
	@Test
	@Order(14)
	void logoutRest() throws InterruptedException {
		WebElement result = driver.findElement(By.xpath("//span[contains(.,'Logout')]"));
		result.click();
		
		Thread.sleep(1000);
	}

	
	@Test
	@Order(15)
	void clickUserLogin() throws InterruptedException {
		WebElement userLoginLink = driver.findElement(By.id("log"));
		userLoginLink.click();
		Thread.sleep(1000);
	}

	@Test
	@Order(16)
	void deniedLogin() throws InterruptedException {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys("Feed me");
		password.sendKeys("seymour");
		WebElement loginBtn = driver.findElement(By.cssSelector("button.log"));
		loginBtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}
	
//	@Test
//	@Order(17)
//	void loginUser() throws InterruptedException {
//
//		WebElement username = driver.findElement(By.id("username"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement loginBtn = driver.findElement(By.cssSelector("button.log"));
//		username.sendKeys("User");
//		password.sendKeys("password");
//		loginBtn.click();
//		
//		Thread.sleep(1000);
//	}

	@Test
	@Order(18)
	void clickRegister() throws InterruptedException {
		WebElement registerBtn = driver.findElement(By.cssSelector("[ng-reflect-router-link='register']"));
		registerBtn.click();
		
		Thread.sleep(2000);
	}
	
	@Test
	@Order(19)
	void regUserSarah() throws InterruptedException {

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement registerBtn = driver.findElement(By.cssSelector("button.log"));
		username.sendKeys("Sarah");
		password.sendKeys("shinespark");
		registerBtn.click();

		Thread.sleep(2000);
	}
	
	@Test
	@Order(20)
	void loginSarah() throws InterruptedException {

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("button.log"));
		username.sendKeys("Sarah");
		password.sendKeys("shinespark");
		loginBtn.click();
		
		Thread.sleep(1000);
	}

	@Test
	@Order(21)
	void getMeals770cals10budget() throws InterruptedException {
		WebElement calories = driver.findElement(By.id("calories"));
		WebElement budget   = driver.findElement(By.id("cost"));
		WebElement dropdown = driver.findElement(By.id("cuisine"));
		WebElement submit   = driver.findElement(By.className("log"));
		calories.sendKeys("770");
		budget.sendKeys("10");
//		dropdown.click();
//		Thread.sleep(1000);
//
//		List<WebElement> allCheckboxes = driver.findElements(By.className("multiselect-item-checkbox"));
//		WebElement AmericanCheckbox = allCheckboxes.get(3);
//		AmericanCheckbox.click();
//		dropdown.click(); //Close dropdown
//		Thread.sleep(1000);
		submit.click();
		
		Thread.sleep(2000);
	}

	@Test
	@Order(22)
	void selectItem() throws InterruptedException {
		WebElement result = driver.findElement(By.xpath("//td[contains(.,'Chili Dog')]"));
		result.click();
		
		Thread.sleep(4000);
	}

//	@Test
//	@Order(23)
//	void clickLogout() throws InterruptedException {
//		WebElement logout = driver.findElement(By.className("mat-button"));
//		logout.click();
//		
//		Thread.sleep(4000);
//	}
		
	@Test
	@Order(24)
	void logoutUser() throws InterruptedException {
		WebElement result = driver.findElement(By.xpath("//span[contains(.,'Logout')]"));
		result.click();
		
		Thread.sleep(1000);
	}

	
	@AfterAll
	static void closeDriver() {
		driver.quit();
	}
}
