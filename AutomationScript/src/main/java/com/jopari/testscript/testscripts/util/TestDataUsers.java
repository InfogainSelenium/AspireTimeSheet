package com.jopari.testscript.testscripts.util;

import java.io.IOException;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.exception.ColumnNotFoundException;
import com.jopari.automation.selenium.exception.MalformedFileException;
import com.jopari.automation.selenium.exception.RowNotFoundException;
import com.jopari.automation.util.io.ExcelReader;

/**
 * TestDataUsers class will have the methods 
 * which provides us the functionality to data parameterization the data 
 * from the specific cells of the test data excel sheet 
 * and pass them onto the AUT Provider Users page related specific 
 * fields  
 * @author 
 *
 */
public class TestDataUsers
{
	private static String email;
	private static String fullName;
	private static String searchInvalidFullName;
	private static String shortName;
	private static String phone;
	private static String correctEmailId;
	private static String incorrectEmailId;
	private static String validShortName;	
	private static int userSheet = 1;
	public static ExcelReader exReaderUsers;
	public static String invalidPhone;
	public static String invalidPhonewithAlphabets;
	public static String validLogin;
	public static String inValidLogin;
	public static String loginEmail;
	public static String loginFullName;
	public static String validUserLogin;
	public static String invalidUserLogin;
	public static String searchFullName;
	public static String invalidFullName;
	

	static
	{
		try
		{
			exReaderUsers = new ExcelReader(Constants.TEST_DATA, userSheet);
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

		email = exReaderUsers.getValue(7, 2);
		shortName = exReaderUsers.getValue(7, 4);
		fullName = exReaderUsers.getValue(7, 6);
		phone = exReaderUsers.getNumValue(7, 8);
		correctEmailId = exReaderUsers.getValue(1, 2);
		incorrectEmailId = exReaderUsers.getValue(1, 3);
		validShortName = exReaderUsers.getValue(3, 4);
		invalidPhone = exReaderUsers.getNumValue(6, 9);
		invalidPhonewithAlphabets = exReaderUsers.getValue(6, 12);
		validLogin = exReaderUsers.getValue(8, 10);
		inValidLogin = exReaderUsers.getValue(9, 11);
		loginEmail = exReaderUsers.getValue(10, 2);
		loginFullName = exReaderUsers.getValue(12, 6);
		searchInvalidFullName = exReaderUsers.getValue(13, 7);
		validUserLogin = exReaderUsers.getValue(14, 10);
		invalidUserLogin = exReaderUsers.getValue(15, 11);
		searchFullName = exReaderUsers.getValue(18, 6);
		invalidFullName = exReaderUsers.getValue(19, 7);

	}

	public static String getValidShortName()
	{
		return validShortName;
	}

	public static void setValidShortName(String invalidShortName)
	{
		TestDataUsers.validShortName = invalidShortName;
	}

	
	public static String getEmail()
	{
		return email;
	}

	public static void setEmail(String email)
	{
		TestDataUsers.email = email;
	}

	public static String getFullName()
	{
		return fullName;
	}

	public static void setFullName(String fullName)
	{
		TestDataUsers.fullName = fullName;
	}

	public static String getShortName()
	{
		return shortName;
	}

	public static void setShortName(String shortName)
	{
		TestDataUsers.shortName = shortName;
	}

	public static String getPhone()
	{
		return phone;
	}

	public static void setPhone(String phone)
	{
		TestDataUsers.phone = phone;
	}

	public static String getCorrectEmailId()
	{
		return correctEmailId;
	}

	public static void setCorrectEmailId(String correctEmailId)
	{
		TestDataUsers.correctEmailId = correctEmailId;
	}

	public static String getIncorrectEmailId()
	{
		return incorrectEmailId;
	}

	public static void setIncorrectEmailId(String incorrectEmailId)
	{
		TestDataUsers.incorrectEmailId = incorrectEmailId;
	}

	
	public static int getUserSheet()
	{
		return userSheet;
	}

	public static void setUserSheet(int userSheet)
	{
		TestDataUsers.userSheet = userSheet;
	}

	public static ExcelReader getExReaderUsers()
	{
		return exReaderUsers;
	}

	public static void setExReaderUsers(ExcelReader exReaderUsers)
	{
		TestDataUsers.exReaderUsers = exReaderUsers;
	}


	public static String getInvalidPhone()
	{
		return invalidPhone;
	}

	public static void setInvalidPhone(String invalidPhone)
	{
		TestDataUsers.invalidPhone = invalidPhone;
	}

	public static String getInvalidPhonewithAlphabets()
	{
		return invalidPhonewithAlphabets;
	}

	public static void setInvalidPhonewithAlphabets(
			String invalidPhonewithAlphabets)
	{
		TestDataUsers.invalidPhonewithAlphabets = invalidPhonewithAlphabets;
	}

	public static String getValidLogin()
	{
		return validLogin;
	}

	public static void setValidLogin(String validLogin)
	{
		TestDataUsers.validLogin = validLogin;
	}

	public static String getInValidLogin()
	{
		return inValidLogin;
	}

	public static void setInValidLogin(String inValidLogin)
	{
		TestDataUsers.inValidLogin = inValidLogin;
	}

	public static String getLoginEmail()
	{
		return loginEmail;
	}

	public static void setLoginEmail(String loginEmail)
	{
		TestDataUsers.loginEmail = loginEmail;
	}

	public static String getLoginFullName()
	{
		return loginFullName;
	}

	public static void setLoginFullName(String loginFullName)
	{
		TestDataUsers.loginFullName = loginFullName;
	}

	public static String getSearchInvalidFullName()
	{
		return searchInvalidFullName;
	}

	public static void setsearchInvalidFullName(String searchInvalidFullName)
	{
		TestDataUsers.searchInvalidFullName = searchInvalidFullName;
	}

	public static String getValidUserLogin()
	{
		return validUserLogin;
	}

	public static void setValidUserLogin(String validUserLogin)
	{
		TestDataUsers.validUserLogin = validUserLogin;
	}

	public static String getInvalidUserLogin()
	{
		return invalidUserLogin;
	}

	public static void setInvalidUserLogin(String invalidUserLogin)
	{
		TestDataUsers.invalidUserLogin = invalidUserLogin;
	}

	public static String getSearchFullName()
	{
		return searchFullName;
	}

	public static void setSearchFullName(String searchFullName)
	{
		TestDataUsers.searchFullName = searchFullName;
	}

	public static String getInvalidFullName()
	{
		return invalidFullName;
	}

	public static void setInvalidFullName(String invalidFullName)
	{
		TestDataUsers.invalidFullName = invalidFullName;
	}

	

}
