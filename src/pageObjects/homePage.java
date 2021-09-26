package pageObjects;

import java.awt.AWTException;
import java.io.IOException;
import static org.junit.Assert.*;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.extentReportManager;
import utilities.utils;

public class homePage extends utils
{
	public WebDriver driver;
	 
	@FindBy(how = How.ID, using = "ui-id-1") 
	public WebElement tab1;
	
	@FindBy(how = How.ID, using = "ui-id-2") 
	public WebElement tab2;
	
	@FindBy(how = How.ID, using = "ui-id-3")
	public WebElement tab3;
	
	@FindBy(how = How.ID, using = "ui-id-4")
	public WebElement tab4;
	
	@FindBy(how = How.ID, using = "ui-id-5")
	public WebElement tab5;
 
	@FindBy(how = How.CSS, using = "img[src='images/nature1.jpg']")
	public WebElement img1;
	
	@FindBy(how = How.CSS, using = "img[src='images/nature5.jpg']")
	public WebElement img2;
	
	@FindBy(how = How.CSS, using = "img[src='images/nature3.jpg']")
	public WebElement img3;
	
	@FindBy(how = How.NAME, using = "tab1text")
	public WebElement tabText1;
	
	@FindBy(how = How.NAME, using = "tab2text")
	public WebElement tabText2;
	
	@FindBy(how = How.NAME, using = "tab3text")
	public WebElement tabText3;
	
	@FindBy(how = How.NAME, using = "tab4text")
	public WebElement tabText4;
	
	@FindBy(how = How.NAME, using = "tab5text")
	public WebElement tabText5;
	
	
	public homePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	// This Function Select the desired Tab
	// Parameters: Tab Name 
	// Return Value: None
	public void selectTab(String tabName) throws ParserConfigurationException, SAXException, IOException, AWTException
	{
		try
		{
			switch (tabName.toLowerCase())
			{
	        case "tab 1":
	        	tab1.click();
	        	break;
	        case "tab 2":
	        	tab2.click();
	        	break;
	        case "tab 3":
	        	tab3.click();
	        	break;
	        case "tab 4":
	        	tab4.click();
	        	break;
	        case "tab 5":
	        	tab5.click();
	        	break;
	        default:
	        	test.log(LogStatus.FAIL, tabName + " : Wrong Selection");	
	        	fail("Problem with Selecting Tab, See Report for more Details");
	        	break;
			}			
			test.log(LogStatus.PASS, tabName + " Was Selected Successfully");	
		}
		catch (Exception exp)
		{
			test.log(LogStatus.FAIL, "Problem with Selecting Tab, Error Message: " + exp.getMessage() + test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with Selecting Tab, See Report for more Details");
		}
	}

}
