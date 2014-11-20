package com.jopari.testscript.testscripts;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jopari.automation.selenium.test.BaseTestCase;
import com.jopari.testscript.pageobjects.AspireHomePage;
import com.jopari.testscript.pageobjects.LoginPage;
import com.jopari.testscript.pageobjects.TimeSheetHomePage;
import com.jopari.testscript.testscripts.util.TestUtil;

public class TimeSheetHome extends BaseTestCase
{

	private WebDriver driver;
	private LoginPage loginpage;
	
	private TimeSheetHomePage timeSheetHomePage;
	private AspireHomePage aspireHomePage;
	private static final String MSG_GETTING_ERROR_IN_TEST_METHOD = "Getting error in test method :";
	private static final String MSG_ENTERING_TEST_METHOD = "Entering test method :";
	private static final String MSG_EXITING_TEST_METHOD = "Exiting method successfully :";
	private static String MSG_TEST_METHOD_NAME = "";
	private static final String MSB_PARITION = "------------------------------------------------------------------------";
	private static String currentProjectDirectory;

	@BeforeTest
	public void login() throws Exception
	{
		try
		{
			driver = getDriver();
			aspireHomePage= new AspireHomePage(driver);
			loginpage= aspireHomePage.clickTimeSheetImg();
			
			
			timeSheetHomePage= loginpage.loginTimeSheet("nayan.banerjee","Chayan@123!");
			
			currentProjectDirectory = System.getProperty("user.dir");
			TestUtil.infoLog(this.getClass(), "Successfully Login into the TimeSheet Portal!!");
		} catch (Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Error in test testLogin");
			throw e;
		}
	}
	
	/*@AfterMethod
	public void logout() throws Exception
	{
		try
		{
			loginpage = bankspage.logout();
			loginpage.isLoginPage();
		} catch (Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Ignore no logout error");
		}
	}*/
	
	@Test
	public void show()
	{
		Sleeper.sleepTightInSeconds(5);
	}
	
	@Test 
	public void isSelectedYearpresentYear()  throws Exception{
		MSG_TEST_METHOD_NAME ="isSelectedYearpresentYear";
		int yearint = Calendar.getInstance().get(Calendar.YEAR);
		String year = Integer.toString(yearint);
		try
		{
			TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
			
			System.out.println("current year is "+ yearint);
			Sleeper.sleepTightInSeconds(10);
			String selectedYear= timeSheetHomePage.selectedYrFromDropDown();
			Assert.assertEquals(selectedYear, year);
			
			TestUtil.infoLog(this.getClass(),MSG_EXITING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		} catch (Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Error in test testLogin");
			throw e;
		}
		
		
	}

	
	
	
	

	
	
	

}
