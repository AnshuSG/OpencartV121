package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement lnkMyaccount;






@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement lnkRegister;

@FindBy(linkText="Login")
WebElement linkLogin;

public void clickMyAccount()
{
	
	
	
	 WebDriverWait waitPresence = new WebDriverWait(driver, Duration.ofSeconds(60));
	    WebDriverWait waitVisibility = new WebDriverWait(driver, Duration.ofSeconds(70));

	    // Make sure the @FindBy-initialized element is available before using it
	    waitPresence.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='My Account']")));
	    waitVisibility.until(ExpectedConditions.visibilityOf(lnkMyaccount));

	    lnkMyaccount.click();
	

	
	
	
	
	
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	// WebElement lnkMyaccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='My Account']")));
		
	
	
	// wait.until(ExpectedConditions.visibilityOfElementLocated(lnkMyaccount)).click();
	 
	 // Wait until element is visible
     //wait.until(ExpectedConditions.visibilityOf(lnkMyaccount));


     //wait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount)).click();
 

	//lnkMyaccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin()
{
	linkLogin.click();
}





}
