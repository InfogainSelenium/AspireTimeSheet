package com.jopari.testscript.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

//import org.openqa.selenium.browserlaunchers.Sleeper;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;
import com.jopari.automation.selenium.browser.FirefoxBrowser;
import com.jopari.automation.selenium.browser.IInternetBrowser;
import com.jopari.automation.webdriver.util.WebDriverUtil;
import com.jopari.automation.webdriver.util.WebDriverUtilException;

public class InvalidLoginPage
{

	private WebDriver driver;
	private IInternetBrowser browser;
	private Integer delayMultiplier;

	/**
	 * Constructor of InvalidLoginPage that initialize driver
	 * 
	 * @param driver
	 */
	public InvalidLoginPage(WebDriver driver)
	{
		this(driver, (IInternetBrowser) new FirefoxBrowser());
	}
	
	public InvalidLoginPage(WebDriver driver, IInternetBrowser browser)
	{
		this.driver = driver;
		this.browser = browser;
		delayMultiplier = browser.getDelayMultiplier();
	}

	/**
	 * This method returns the current driver handler
	 * 
	 * @param driver
	 * @return
	 */
	public String getCurrentdriverHandler(WebDriver driver)
	{
		return WebDriverUtil.getCurrentdriverHandler(driver);
	}

	/**
	 * This method returns the text that appears on 
	 * invalid login
	 * 
	 * @param driver
	 * @return
	 * @throws WebDriverUtilException 
	 */
	public String getInvalidLoginText() throws WebDriverUtilException
	{
		//return WebDriverUtil.findElementByXpath("//div[@id='logn']/h3/font", driver).getText();
		return WebDriverUtil.findElementByID("logn", driver).getText();
	}
	
	public void sleep(int timeDelay)
	{
		Sleeper.sleepTightInSeconds(timeDelay * delayMultiplier.intValue());
	}
}
