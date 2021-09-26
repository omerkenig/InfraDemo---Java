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

public class upperMenuPage extends utils
{
	public WebDriver driver;
		
	@FindBy(how = How.CLASS_NAME, using = "site-anchor")	
	public WebElement demoSite;
	
	@FindBy(how = How.ID, using = "menu-item-38")
	public WebElement homePage;
 
	@FindBy(how = How.ID, using = "menu-item-158")
	public WebElement aboutUS ;

	@FindBy(how = How.ID, using = "menu-item-155aa")
	public WebElement services ;
	
	@FindBy(how = How.ID, using = "menu-item-66")
	public WebElement demo ;
	
	@FindBy(how = How.ID, using = "menu-item-73")
	public WebElement demo_draggable ;
	
	@FindBy(how = How.ID, using = "menu-item-153")
	public WebElement demo_tabs ;
	
	@FindBy(how = How.ID, using = "menu-item-65")
	public WebElement blog ;
	
	@FindBy(how = How.ID, using = "menu-item-64")
	public WebElement contact ;
 
	public upperMenuPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void clickOnDemoSite() throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			demoSite.click();
			test.log(LogStatus.PASS, "DemoSite Was Selected Successfully");
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Clicking on DemoSite, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Clicking on DemoSite, See Report for more Details");
		}
	}
	
	public void clickOnHome() throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			homePage.click();
			test.log(LogStatus.PASS, "Home Was Selected Successfully");
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Clicking on Home, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Clicking on Home, See Report for more Details");
		}
	}
	
	public void clickOnAboutUs() throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			aboutUS.click();
			test.log(LogStatus.PASS, "About Us Was Selected Successfully");
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Clicking on About Us, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Clicking on About Us, See Report for more Details");
		}
	}
	
	public void clickOnServices() throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			services.click();
			test.log(LogStatus.PASS, "Services Was Selected Successfully");
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Clicking on Services, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Clicking on Services, See Report for more Details");
		}
	}
	
	public void clickOnBlog() throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			blog.click();
			test.log(LogStatus.PASS, "Blog Was Selected Successfully");
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Clicking on Blog, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Clicking on Blog, See Report for more Details");
		}
	}
	
	public void clickOnContact() throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			contact.click();
			test.log(LogStatus.PASS, "Contact Was Selected Successfully");
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Clicking on Contact, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Clicking on Contact, See Report for more Details");
		}
	}
	
	
	public void demoMenu(String option)
	{	
		demo.click();
		if (option.toLowerCase().equals("draggable"))		
			demo_draggable.click();
		else if (option.toLowerCase().equals("tabs"))
			demo_tabs.click();		
	}	
}
