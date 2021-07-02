package StepDefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	public static WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
	}
	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		
		File file = new File("lib/chromedriver.exe");
		String filePath = file.getAbsolutePath();
		System.out.println(filePath);
		System.setProperty("webdriver.chrome.driver", filePath);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		driver =  new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	    
		WebElement loginPanelObj = driver.findElement(By.xpath("//div[text()='LOGIN Panel']"));
		if(loginPanelObj.isDisplayed()) {
			System.out.println("Login page navigation successful");
		}
		else {
			System.out.println("Login page navigation not successful");
		}
       
		
	}
	
	
	

	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();   
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("txtUsername")).sendKeys(arg1);
        driver.findElement(By.id("txtPassword")).sendKeys(arg2);
        driver.findElement(By.id("btnLogin")).click();   
	}
	
	
	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Thread.sleep(3000);
		
	}
	
	
	@Then("^validate dashboard page$")
	public void validate_dashboard_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement dashboarLblObj  = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
		if(dashboarLblObj.isDisplayed()) {
			System.out.println("Dashboard page is displayed");
		}
		else {
			System.out.println("Error displaying dashboard page");
		}
		 driver.quit();  
	}

	@Then("^validate error message$")
	public void validate_error_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement errorMsg  = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
		if(errorMsg.isDisplayed()) {
			System.out.println("Error message  is displayed");
		}
		else {
			System.out.println("Error message not displayed for invalid user");
		}
		 driver.quit();  
	}
	
	
	
	@After
	public void closeBrowser() {
		
	}
	

}
