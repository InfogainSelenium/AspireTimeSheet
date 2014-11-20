package com.jopari.testscript.testscripts.util;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.logging.ErrorEvent;
import com.jopari.automation.selenium.logging.InfoEvent;
import com.jopari.automation.selenium.logging.TestLogger;
import com.jopari.automation.webdriver.util.WebDriverUtil;
import com.jopari.automation.webdriver.util.WebDriverUtilException;

import org.openqa.selenium.WebDriver;

/**
 * This class TestUtil class provides the functionality to
 * implement the informational log and error log 
 * feature   
 * @author 
 *
 */
public class TestUtil
{

	/**
	 * Method to login to the PNC website http://10.25.1.95:8008/PNCGH/
	 * @param driver
	 * @throws Exception
	 */
	public void login(WebDriver driver) throws Exception
	{
		try
		{
			TestLogger.log(new InfoEvent(TestUtil.class, "Entering Login"));
			TestLogger.log(new InfoEvent(TestUtil.class, "Reading username and password from excel sheet :" + Constants.TEST_DATA));
			TestLogger.log(new InfoEvent(TestUtil.class, "Logging with username :" + TestData.getUserNameTestUser1Provider() + " and password:"
					+ TestData.getPasswordTestUser1Provider()));
			WebDriverUtil.findElementByID("i_u", driver).sendKeys(TestData.getUserNameTestUser1Provider());
			WebDriverUtil.findElementByID("i_p", driver).sendKeys(TestData.getPasswordTestUser1Provider());
			WebDriverUtil.findElementByName("LogonForm", driver).submit();
			TestLogger.log(new InfoEvent(TestUtil.class, "Exiting Logging"));
		} catch (WebDriverUtilException e)
		{

			TestLogger.log(new ErrorEvent(TestUtil.class, "Driver Exception while login:" + e.getStackTrace()));
			throw e;
		} catch (Exception e)
		{
			TestLogger.log(new ErrorEvent(TestUtil.class, "General Exception while login:" + e.getStackTrace()));
			throw e;
		}
	}



	/**
	 * Method to implement and provides us the informational logging
	 * feature to get the information run status of statements for 
	 * a method 
	 * @param className
	 * @param message
	 */
	public static void infoLog(Class<?> className, String message)
	{
		TestLogger.log(new InfoEvent(className, message));
	}

	

	/**
	 * Method to implement the error logging feature to provide
	 * the error log in case any exception occurred in the 
	 * method and should be called inside the catch block.
	 * @param className
	 * @param msg
	 */
	public static void errorLog(Class<?> className, String msg)
	{

		TestLogger.log(new ErrorEvent(className, msg));
	}
}
