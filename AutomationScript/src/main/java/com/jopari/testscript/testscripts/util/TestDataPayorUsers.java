package com.jopari.testscript.testscripts.util;

import java.io.IOException;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.exception.ColumnNotFoundException;
import com.jopari.automation.selenium.exception.MalformedFileException;
import com.jopari.automation.selenium.exception.RowNotFoundException;
import com.jopari.automation.util.io.ExcelReader;

/**
 * TestDataPayorUsers class will have the methods 
 * which provides us the functionality to data parameterization the data 
 * from the specific cells of the test data excel sheet 
 * and pass them onto the AUT Payor Users related specific 
 * fields  
 * @author 
 *
 */
public class TestDataPayorUsers
{

	private static String payorAdminValidFullName;

	private static String payorAdminValidEmail;
	private static String payorAdminValidLogin;
	private static int payorUserSheet = 3;

	public static ExcelReader exReaderPayorUsers;

	static
	{
		try
		{
			exReaderPayorUsers = new ExcelReader(Constants.TEST_DATA,
					payorUserSheet);
			setAllValue();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (MalformedFileException e)
		{
			e.printStackTrace();
		} catch (ColumnNotFoundException e)
		{
			e.printStackTrace();
		} catch (RowNotFoundException e)
		{
			e.printStackTrace();
		}

	}
	/**
	 * Method to pick the value from the excel sheet cell
	 * to set inside a desired web element of a Application
	 * under test
	 * @throws ColumnNotFoundException
	 * @throws RowNotFoundException
	 */
	private static void setAllValue() throws ColumnNotFoundException,
			RowNotFoundException
	{
		payorAdminValidFullName = exReaderPayorUsers.getValue(5, 6);
		payorAdminValidEmail = exReaderPayorUsers.getValue(4, 2);
		payorAdminValidLogin = exReaderPayorUsers.getValue(3, 10);
		;
	}

	/**
	 * Method to get  the Payor Admin Valid Full Name
	 * @return
	 */
	public static String getPayorAdminValidFullName()
	{
		return payorAdminValidFullName;
	}

	/**
	 * Method to set the Payor Admin Valid Full Name
	 * @param payorAdminValidFullName
	 */
	public static void setPayorAdminValidFullName(String payorAdminValidFullName)
	{
		TestDataPayorUsers.payorAdminValidFullName = payorAdminValidFullName;
	}

	/**
	 * Method to get the Payor Admin Valid Email
	 * @return
	 */
	public static String getPayorAdminValidEmail()
	{
		return payorAdminValidEmail;
	}

	/**
	 * Method to set the Payor Admin Valid Email
	 * @param payorAdminValidEmail
	 */
	public static void setPayorAdminValidEmail(String payorAdminValidEmail)
	{
		TestDataPayorUsers.payorAdminValidEmail = payorAdminValidEmail;
	}

	/**
	 * Method to get the Payor Admin Valid Login
	 * @return
	 */
	public static String getPayorAdminValidLogin()
	{
		return payorAdminValidLogin;
	}

	/**
	 * Method to set the Payor Admin Valid Login
	 * @param payorAdminValidLogin
	 */
	public static void setPayorAdminValidLogin(String payorAdminValidLogin)
	{
		TestDataPayorUsers.payorAdminValidLogin = payorAdminValidLogin;
	}

}
