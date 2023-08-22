package stepDefinition;

import org.junit.Assert;


//import io.cucumber.java.en.*;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

public class SignIn {

 WebDriver driver = null;
 

 @Given("browser is open")
	public void browser_is_open() {
		// Initiate the Chrome-driver and open the browser.
		System.setProperty("webdriver.chrome.driver", "/Users/amitbarua/Downloads/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}



 @And("User is on google search page")
 public void user_is_on_google_search_page() {
  // Navigate to google.com
  driver.navigate().to("https://google.com");
 }


 @When("User enters a text in a search box")
 public void user_enters_a_text_in_a_search_box() {
  // In the google search box, enter any text - Say "Cucumber Test"
  driver.findElement(By.name("q")).sendKeys("Gmail");
 }

 @And("User waits {int} seconds")
	public static void user_wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 @And("hits Enter")
 public void hits_enter() {
 // Simulate the clicking of enter key
 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
 }


 /*@Then("User is navigated to search feature")
 public void user_is_navigated_to_search_feature() {
 // The test case should pass if the resulting page 
 // contains an expected text - Say ""What is Cucumber Test"
 driver.getPageSource().contains("Test automation Software"); 
 
 // Finally, closing driver after test is complete
   //driver.close(); 
 
 }*/
 
 @Then("User is navigated to search feature")
 public void verifyNavigatedToSearchFeature() {
     // Verify that the page title or a specific element indicates successful navigation
     String expectedTitle = "Gmail - Google Search";
     String actualTitle = driver.getTitle();
     
     Assert.assertEquals("Page title mismatch", expectedTitle, actualTitle);
 }
 
 /*@And("User clicks on Gmail sign in")
 public void clickOnGmailSignIn() {
     WebElement gmailSignInButton = driver.findElement(By.linkText("Google Accounts: Sign in"));
     gmailSignInButton.click();
 }*/
 
 @And("User clicks on Gmail sign in")
 public void clickOnGmailSignIn() {
     WebDriverWait wait = new WebDriverWait(driver, 10);
     WebElement gmailSignInButton = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign in")));
     gmailSignInButton.click();
 }

 @Then("User signs on")
 public void signInToGmail() {
     // Assuming you have a Gmail test account for automation purposes
     WebElement emailInput = driver.findElement(By.id("identifierId"));
     emailInput.sendKeys("barua.amit.himel@gmail.com");
     
     WebElement nextButton = driver.findElement(By.id("identifierNext"));
     nextButton.click();
     
     // Wait for password input field to be visible
     WebDriverWait wait = new WebDriverWait(driver, 10);
    // WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Enter your password")));
     //WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
     WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
 
     passwordInput.sendKeys("baruaamit11");
     
     WebElement signInButton = driver.findElement(By.id("passwordNext"));
     signInButton.click();
 }
 
 @And("User clicks on Dots")
 public void clickOnDots() {
     WebDriverWait wait = new WebDriverWait(driver, 10);

     // Find the element using the provided XPath
     WebElement gmailAppsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gbwa\"]/div/a")));
     gmailAppsButton.click();
 }

 @Then("User clicks on app")
 public void clickOnapp() {
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    
		    // Click on the Gmail link within the opened menu
		    WebElement gmailLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'mail.google.com')]")));
		    gmailLink.click();
		    //throw new io.cucumber.java.PendingException();
}

 @And("User clicks on Compose button")
 public void clickOnComposeButton() {
     WebDriverWait wait = new WebDriverWait(driver, 10);
     
     // Find and click the Compose button
     WebElement composeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Compose']")));
     composeButton.click();
 }

 @Then("User sends an email with subject {string} and body {string}")
 public void sendEmail(String subject, String body) {
     WebDriverWait wait = new WebDriverWait(driver, 20);
     
     // Fill in recipient, subject, and email body fields
     
    // WebElement toField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Recipients")));
    // WebElement tosecondField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("To")));
     //WebElement recipientField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='To']/following::textarea")));
     
     //WebElement recipientField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='to']")));
     //driver.findElement(By.xpath("//*[@id=\":ud\"]\n")).click();
     //driver.findElement(By.xpath("//textarea[contains(@aria-label, 'Select contacts')]")).sendKeys("driver.findElement(By.name("q")).sendKeys("Gmail");");
     //driver.findElement(By.name("to")).sendKeys("amit.himel@gmail.com");
     //recipientField.sendKeys("amit.himel@gmail.com");
     
   
     //WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.(":ud")));

     //toInput.sendKeys("amit.himel@gmail.com");
     
     WebElement element = driver.findElement(By.xpath("//*[@id=\":8c\"]/td[1]"));
     element.sendKeys("amit.himel@gmail.com");
     
     
     WebElement subjectField = driver.findElement(By.xpath("//input[@name='subjectbox']"));
     subjectField.sendKeys(subject);
     
     WebElement bodyField = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
     bodyField.sendKeys(body);
     
     WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='Send ‪(Ctrl-Enter)‬']")));
     sendButton.click();
     
   
   
 }
 

 @Then("User closes the browser")
 public void closeBrowser() {
     driver.quit();
 }


 
}
