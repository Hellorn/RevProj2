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
	
//	@Test
	@Order(1)
	void ClickUserLogin() throws InterruptedException {
		driver.get("localhost:4200/");
//	@FindBy(css="div[lang='en']")
		WebElement loginBtn = driver.findElement(By.cssSelector("button.log"));
		loginBtn.click();
		Thread.sleep(4000);
	}

	static void loginUser() throws InterruptedException {
		driver.get("localhost:4200/");

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("button.log"));
		username.sendKeys("Elie");
		password.sendKeys("zer");
		loginBtn.click();
		
		Thread.sleep(1000);
	}

	@Test
	@Order(2)
	void getMeals500cals20budget() throws InterruptedException {
		loginUser();
		WebElement calories = driver.findElement(By.id("calories"));
		WebElement budget   = driver.findElement(By.id("cost"));
		WebElement dropdown = driver.findElement(By.id("cuisine"));
		WebElement submit   = driver.findElement(By.xpath("//*[@id=\"mid\"]/button"));
		calories.sendKeys("500");
		budget.sendKeys("20");
		dropdown.click();
		Thread.sleep(1000);

		List<WebElement> allCheckboxes = driver.findElements(By.className("multiselect-item-checkbox"));
		System.out.println(allCheckboxes.size());
		WebElement AmericanCheckbox = allCheckboxes.get(3);
		AmericanCheckbox.click();
		dropdown.click();
		Thread.sleep(1000);
		submit.click();
		
		Thread.sleep(4000);
	}
// Click preferences
// Sign up for a manager

//	@Test
	@Order(3)
	void loginManager() throws InterruptedException {
		driver.get("http://localhost:4200/managerlogin");

		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("button.log"));
		username.sendKeys("y");
		password.sendKeys("z");
		loginBtn.click();

		Thread.sleep(12000);
	}

	@AfterAll
	static void closeDriver() {
		driver.quit();
	}
}
