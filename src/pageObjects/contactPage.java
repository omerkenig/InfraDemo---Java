package pageObjects;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.extentReportManager;
import utilities.utils;

public class contactPage extends utils
{
	public WebDriver driver;
	
	@FindBy(how = How.NAME, using = "your-name") 
	public WebElement Name;
	
	@FindBy(how = How.NAME, using = "your-email") 
	public WebElement Email;
	
	@FindBy(how = How.NAME, using = "your-subject") 
	public WebElement Subject;
	
	@FindBy(how = How.NAME, using = "your-message") 
	public WebElement Message;
	
	@FindBy(how = How.CSS, using = "input[type='submit']") 
	public WebElement Send;
	
	@FindBy(how = How.CLASS_NAME, using = "ajax-loader") 
	public WebElement Load;
	
	public contactPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// This Function Fill up the Contact Form 
	// Parameters: sName - Name , sEmail - Email , sSubject - Subject, sMessage - Message
	// Return: None
	public void fillContactForm(String sName, String sEmail, String sSubject, String sMessage) throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			Name.clear();
			Name.sendKeys(sName);
			Email.clear();
			Email.sendKeys(sEmail);
			Subject.clear();
			Subject.sendKeys(sSubject);
			Message.clear();
			Message.sendKeys(sMessage);
			Send.click();
			test.log(LogStatus.PASS, "fill Contact Form Was Finished Successfully");
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Filling Contact Form, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Filling Contact Form, See Report for more Details");
		}
	}
}
