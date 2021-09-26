package businessScenarios;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import utilities.commonOps;
import utilities.utils;

import java.awt.AWTException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sanityTests extends utils
{      
     private static commonOps comOps = new commonOps();
     private static WebDriverWait wait;
     private static String mainWindowHandle;     
     private static pageObjects.loginPage Login = new pageObjects.loginPage(driver);
     private static pageObjects.homePage home = new pageObjects.homePage(driver);
     private static pageObjects.upperMenuPage upperMenu = new pageObjects.upperMenuPage(driver);
     private static pageObjects.contactPage contact = new pageObjects.contactPage(driver);
     
     // Test 01: Verify Tabs in Main Page
     @Test
     public void test01_tabVerification() throws ParserConfigurationException, SAXException, IOException, AWTException
     {
    	 initTest(testName.getMethodName(), "This is Test Number 1");
    	 home.selectTab("Tab 3");
    	 comOps.verifyElementExists(home.tabText1);
    	 comOps.verifyElementExists(home.tabText2);
    	 comOps.verifyElementExists(home.tabText3);
    	 comOps.verifyElementExists(home.tabText4);
    	 comOps.verifyElementExists(home.tabText5);; 
    	 comOps.verifyElementDisplay(home.tabText3);
    	 comOps.verifyElementNotDisplay(home.tabText1); 
    	 comOps.verifyElementNotDisplay(home.tabText2);
    	 comOps.verifyElementNotDisplay(home.tabText4);
    	 comOps.verifyElementNotDisplay(home.tabText5);
     }
     
     // Test 02: Verify Load Image After Filling up the Contact Form     
     @Test
     public void test02_contactForm() throws ParserConfigurationException, SAXException, IOException, AWTException
     {
    	 initTest(testName.getMethodName(), "This is Test Number 2");
    	 upperMenu.clickOnContact();
    	 contact.fillContactForm("Yoni Flenner", "yonif@gmail.com", "Hello Yoni", "Hi, This is a Test...");
    	 comOps.verifyElementDisplay(contact.Load);
     }
     
     
     @BeforeClass
     public static void openBrowser() throws ParserConfigurationException, SAXException, IOException
     {
    	 initBrowser(getData("BrowserType"));
    	 mainWindowHandle = driver.getWindowHandle();
    	 wait = new WebDriverWait(driver, Long.parseLong(getData("WaitTime")));
    	 initExtentReport();
         initElements();
         Login.action(getData("User"), getData("Pass"));
     }
     
     
     @After
     public void finalizingTest() throws ParserConfigurationException, SAXException, IOException
     {
    	 recoveryTest(driver);
         finilizeExtentReportTest();
     }
     
     
     @AfterClass
     public static void closeBrowser() throws ParserConfigurationException, SAXException, IOException
     {
    	 finilizeExtentReport();
    	 driver.quit();   
     }
     
     
    // Rule that Handles test name for logs
 	@Rule
     public TestName testName = new TestName();

     @Rule
     public TestWatcher testWatcher = new TestWatcher()
     {
         @Override
         protected void starting(final Description description)
         {
             String methodName = description.getMethodName();
             String className = description.getClassName();
             className = className.substring(className.lastIndexOf('.') + 1);
             System.err.println("Starting JUnit-test: " + className + " " + methodName);
         }
     };
     
     
     public static void initElements()
     {
         PageFactory.initElements(driver, Login);
         PageFactory.initElements(driver, home);
         PageFactory.initElements(driver, upperMenu);
         PageFactory.initElements(driver, contact);
     }
     
}
