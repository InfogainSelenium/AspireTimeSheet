package com.jopari.testscript.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.browser.FirefoxBrowser;
import com.jopari.automation.selenium.browser.IInternetBrowser;
import com.jopari.automation.selenium.logging.ErrorEvent;
import com.jopari.automation.selenium.logging.InfoEvent;
import com.jopari.automation.selenium.logging.TestLogger;
import com.jopari.automation.webdriver.util.WebDriverUtil;
import com.jopari.automation.webdriver.util.WebDriverUtilException;
import com.jopari.testscript.testscripts.util.TestUtil;
//import org.openqa.selenium.browserlaunchers.Sleeper;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class LoginPage
{
	private WebDriver driver;
	private IInternetBrowser browser;
	private Integer delayMultiplier;

	public LoginPage(WebDriver driver)
	{
		this(driver, (IInternetBrowser) new FirefoxBrowser());
	}
	
	public LoginPage(WebDriver driver, IInternetBrowser browser)
	{
		this.driver = driver;
		this.browser = browser;
		delayMultiplier = browser.getDelayMultiplier();
	}

	
	
	/**
	 * This method performs and invalid login to AUT .It initialises and returns
	 * the InvalidLoginPage object
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public InvalidLoginPage invalidLogin(String username, String password)
			throws Exception
	{
		try
		{
			TestLogger.log(new InfoEvent(TestUtil.class, "Entering Login"));
			TestLogger.log(new InfoEvent(TestUtil.class,
					"Reading username and password from excel sheet :"
							+ Constants.TEST_DATA));
			TestLogger.log(new InfoEvent(TestUtil.class,
					"Logging with username :" + username + " and password:"
							+ password));
			WebDriverUtil.findElementByID("i_u", driver).sendKeys(username);
			WebDriverUtil.findElementByID("i_p", driver).sendKeys(password);
			WebDriverUtil.findElementByName("LogonForm", driver).submit();
			//return PageFactory.initElements(driver, InvalidLoginPage.class);
			return new InvalidLoginPage(driver, browser);

		} catch (WebDriverUtilException e)
		{

			TestLogger.log(new ErrorEvent(TestUtil.class,
					"Driver Exception while login:" + e.getStackTrace()));
			throw e;
		} catch (Exception e)
		{
			TestLogger.log(new ErrorEvent(TestUtil.class,
					"General Exception while login:" + e.getStackTrace()));
			throw e;
		}
	}

	/**
	 * This method checks presence of PNC logo on login page and returns the
	 * result
	 * 
	 * @return
	 * @throws WebDriverUtilException
	 */
	public boolean isLogoDisplayed() throws WebDriverUtilException
	{
		WebElement logo = WebDriverUtil.findElementByClassName("toplogo",
				driver);
		return logo.isDisplayed();

	}

	
	
	
	

		
	public TimeSheetHomePage loginTimeSheet(String username, String password)
			throws Exception
	{
		try
		{
			TestLogger.log(new InfoEvent(TestUtil.class,
					"Entering login for TimeSheet Portal"));
			TestLogger.log(new InfoEvent(TestUtil.class,
					"Logging with username :" + username + " and password:"
							+ password));
			WebDriverUtil.findElementByXpath("//*[@id='tun']", driver)
			.clear();
			WebDriverUtil.findElementByXpath("//*[@id='tun']", driver)
					.sendKeys(username);
			sleep(2);
			WebDriverUtil.findElementByXpath("//*[@id='tp']", driver)
			.clear();
			WebDriverUtil.findElementByXpath("//*[@id='tp']", driver)
					.sendKeys(password);
			sleep(2);
			WebDriverUtil.findElementByXpath("//*[@id='bl']", driver).click();
			sleep(5);
			TestUtil.infoLog(this.getClass(),
					"Loggin into TimeSheet Portal with  its credentials");

			//return PageFactory.initElements(driver, HomePageRepoPortal.class);
			return new TimeSheetHomePage(driver, browser);

		} catch (WebDriverUtilException e)
		{

			TestLogger.log(new ErrorEvent(TestUtil.class,
					"Driver Exception while login:" + e.getStackTrace()));
			throw e;
		} catch (Exception e)
		{
			TestLogger.log(new ErrorEvent(TestUtil.class,
					"General Exception while login:" + e.getStackTrace()));
			throw e;
		}
	}
	
	public void sleep(int timeDelay)
	{
		Sleeper.sleepTightInSeconds(timeDelay * delayMultiplier.intValue());
	}

	public void isLoginPage() throws Exception
	{
		TestLogger.log(new InfoEvent(TestUtil.class, "checking for \"Forgor password?\" link"));
		WebDriverUtil.findElementByLinkText("Forgot password?", driver);
	}

}
