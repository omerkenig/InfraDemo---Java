package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.utils;

public class loginPage extends utils
{
	final WebDriver driver;
	 
	@FindBy(how = How.NAME, using = "username") 
	public WebElement userName;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement Password;
 
	@FindBy(how = How.ID, using = "submit")
	public WebElement submit ;
 
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// This FUnction Login to Main Page
	// Parameter: sUserName - User Name , sPassword - Password
	// Returned Value - None
	public void action(String sUserName, String sPassword)
	{		
		userName.sendKeys(sUserName);
		Password.sendKeys(sPassword);
		submit.click();
	}	
}


