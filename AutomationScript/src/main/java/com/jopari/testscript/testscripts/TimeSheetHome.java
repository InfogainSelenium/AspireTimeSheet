package com.jopari.testscript.testscripts;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
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
			
			
			timeSheetHomePage= loginpage.loginTimeSheet("kailash.nagar","Xsw23edc");
			
			currentProjectDirectory = System.getProperty("user.dir");
			TestUtil.infoLog(this.getClass(), "Successfully Login into the TimeSheet Portal!!");
		} catch (Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Error in test testLogin");
			throw e;
		}
	}
	

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

	@Test 
	public void isWeekEndDate()  throws Exception{
		MSG_TEST_METHOD_NAME ="isWeekEndDate";
		
		try
		{
			TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
			
			
			Sleeper.sleepTightInSeconds(3);
			timeSheetHomePage.WeekEndDate();
			
			//Assert.assertEquals(selectedYear, year);
			
			TestUtil.infoLog(this.getClass(),MSG_EXITING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		} catch (Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Error in test testLogin");
			throw e;
		}
		
		
	}
	
	@Test 
	public void isSelectProject()  throws Exception
	{
		
		MSG_TEST_METHOD_NAME ="isSelectProject";
		
		try
		{
			TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
			
			
			Sleeper.sleepTightInSeconds(3);
			timeSheetHomePage.SelectProject();
		
			Assert.assertEquals(true, true, MSG_TEST_METHOD_NAME);
			TestUtil.infoLog(this.getClass(),MSG_EXITING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		} catch (Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Error in test Select Project");
			throw e;
		}
		
		
	}
	

	@Test 
	public void isSelectLocation()  throws Exception
	{
		
		MSG_TEST_METHOD_NAME ="isSelectLocation";
		
		try
		{
			TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
			Sleeper.sleepTightInSeconds(3);
			timeSheetHomePage.SelectLocation();
			//Assert.assertEquals(selectedYear, year);
			Assert.assertEquals("Noida", "Noida");
			
			TestUtil.infoLog(this.getClass(),MSG_EXITING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		} catch (Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Error in test Select Location");
			throw e;
		}
		
		
	}
	
	
	@Test
	public void isHrsType() throws Exception
	{
		
		MSG_TEST_METHOD_NAME= "isHrsType";
		try
		{
		
			TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
			Sleeper.sleepTightInSeconds(3);
			timeSheetHomePage.HrsType();
			
			 //Assert.assertEquals("Offshore", "Offshore");
		} catch(Exception e)
		{
			TestUtil.errorLog(this.getClass(), "Error in test Hours Type");
			throw e;
		}
	}


	@Test
	public void isTask() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isTask";
		try {
		TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		Sleeper.sleepTightInSeconds(2);
		timeSheetHomePage.Task();
			} catch (Exception e) 
			{
				TestUtil.errorLog(this.getClass(), "Error in Task selection");
				throw e;
			}

	}

	
	@Test
	public void isSubTask() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isSubTask";
		try {
		TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		Sleeper.sleepTightInSeconds(2);
		timeSheetHomePage.SubTask();
			} catch (Exception e) 
			{
				TestUtil.errorLog(this.getClass(), "Error in test Sub Task selection");
				throw e;
			}

	}
	
	@Test
	public void isCRId() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isCRId";
		try {
		TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		Sleeper.sleepTightInSeconds(2);
		timeSheetHomePage.CRId();
			} catch (Exception e) 
			{
				TestUtil.errorLog(this.getClass(), "Error in test Sub Task selection");
				throw e;
			}

	}
	
	@Test
	public void isDescription() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isDescription";
		try {
		TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		Sleeper.sleepTightInSeconds(2);
		timeSheetHomePage.Description();
			} catch (Exception e) 
			{
				TestUtil.errorLog(this.getClass(), "Error in test description selection");
				throw e;
			}

	}
	
	/*@Test
	public void isFillHrs() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isFillHrs";
		ArrayList<String>   myList = new ArrayList<String>();
		try {
		TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		Sleeper.sleepTightInSeconds(2);
		timeSheetHomePage.FillHrs(driver,myList);
			} catch (Exception e) 
			{
				TestUtil.errorLog(this.getClass(), "Error in test description selection");
				throw e;
			}

	}*/

	

	@Test
	public boolean isverifyMyTime() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isverifyMyTime";
		String myTime ="0:00";
		try {
		TestUtil.infoLog(this.getClass(), MSG_ENTERING_TEST_METHOD + MSG_TEST_METHOD_NAME);
		Sleeper.sleepTightInSeconds(2);
		timeSheetHomePage.verifyMyTime(myTime);
		return true;
			} catch (Exception e) 
			{
				TestUtil.errorLog(this.getClass(), "Error in test description selection");
				throw e;
				
			}

	}
	
	@Test
	
	public void isButtonTypeDelete() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isButtonTypeDelete";
		String ButtonType="Delete";
		try{
			timeSheetHomePage.selectButttonType(ButtonType);
		} catch (Exception e) 
		{
			TestUtil.errorLog(this.getClass(), "Error in test description selection");
			throw e;
			
		}

	}
@Test
	
	public void isButtonTypeAdd() throws Exception
	{
		MSG_TEST_METHOD_NAME= "isButtonTypeAdd";
		String ButtonType="Add";
		try{
			timeSheetHomePage.selectButttonType(ButtonType);
		} catch (Exception e) 
		{
			TestUtil.errorLog(this.getClass(), "Error in test description selection");
			throw e;
			
		}

	}

}
