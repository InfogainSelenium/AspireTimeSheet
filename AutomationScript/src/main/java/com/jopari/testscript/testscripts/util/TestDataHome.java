package com.jopari.testscript.testscripts.util;

import java.io.IOException;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.exception.ColumnNotFoundException;
import com.jopari.automation.selenium.exception.MalformedFileException;
import com.jopari.automation.selenium.exception.RowNotFoundException;
import com.jopari.automation.util.io.ExcelReader;

/**
 * TestDataHome class will have the methods 
 * which provides us the functionality to pick the data 
 * from the specific cells of the test data excel sheet 
 * and pass them onto the AUT Home page related specific 
 * fields  
 * @author 
 *
 */

public class TestDataHome
{
	private static int homeSheet = 2;
	public static ExcelReader exReaderHome;
	public static String validAlphaPassword;
	public static String invalidAlphaPassword;
	public static String invalidNumericPassword;
	public static String differentrepeatPassword;
	public static String invalidrepeatPassword;
	public static String securityAnswer;
	public static int securityquestionnumber;
	public static String securityquestion;

	static
	{
		try
		{
			exReaderHome = new ExcelReader(Constants.TEST_DATA, homeSheet);
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
	 * to set inside a desired webelement of a Application
	 * under test
	 * @throws ColumnNotFoundException
	 * @throws RowNotFoundException
	 */
	private static void setAllValue() throws ColumnNotFoundException,
			RowNotFoundException
	{

		validAlphaPassword = exReaderHome.getValue(1, 3);
		invalidAlphaPassword = exReaderHome.getValue(2, 3);
		invalidNumericPassword = exReaderHome.getNumValue(3, 3);
		differentrepeatPassword = exReaderHome.getValue(4, 3);
		invalidrepeatPassword = exReaderHome.getValue(5, 3);
		securityAnswer = exReaderHome.getValue(1, 2);
		String s = exReaderHome.getNumValue(6, 2);
		securityquestionnumber = Integer.parseInt(s);
		securityquestion = exReaderHome.getValue(6, 3);

	}

	/**
	 * Method to get the Security question
	 * @return
	 */
	public static String getSecurityquestion()
	{
		return securityquestion;
	}

	/**
	 * Method to set the Security question
	 * @param securityquestion
	 */
	public static void setSecurityquestion(String securityquestion)
	{
		TestDataHome.securityquestion = securityquestion;
	}

	/**
	 * Method to get the security question number
	 * @return
	 */
	public static int getSecurityquestionnumber()
	{
		return securityquestionnumber;
	}

	/**
	 * Method to set the Security question number
	 * @param securityquestionnumber
	 */
	public static void setSecurityquestionnumber(int securityquestionnumber)
	{
		TestDataHome.securityquestionnumber = securityquestionnumber;
	}

	/**
	 * Method to get the valid alpha password
	 * @return
	 */
	public static String getValidAlphaPassword()
	{
		return validAlphaPassword;
	}

	/**
	 * Method to set the Valid Alpha Password
	 * @param validAlphaPassword
	 */
	public static void setValidAlphaPassword(String validAlphaPassword)
	{
		TestDataHome.validAlphaPassword = validAlphaPassword;
	}

	/**
	 * Method to get the Invalid Alpha Password
	 * @return
	 */
	public static String getInvalidAlphaPassword()
	{
		return invalidAlphaPassword;
	}

	/**
	 * Method to set the Invalid Alpha Password
	 * @param invalidAlphaPassword
	 */
	public static void setInvalidAlphaPassword(String invalidAlphaPassword)
	{
		TestDataHome.invalidAlphaPassword = invalidAlphaPassword;
	}

	/**
	 * Method to get the Invalid Numeric Password
	 * @return
	 */
	public static String getInvalidNumericPassword()
	{
		return invalidNumericPassword;
	}

	/**
	 * Method to set the Invalid Numeric Password
	 * @param invalidNumericPassword
	 */
	public static void setInvalidNumericPassword(String invalidNumericPassword)
	{
		TestDataHome.invalidNumericPassword = invalidNumericPassword;
	}

	/**
	 * Method to get the Different repeat Password
	 * @return
	 */
	public static String getDifferentrepeatPassword()
	{
		return differentrepeatPassword;
	}

	/**
	 * Method to set the Different repeat Password
	 * @param differentrepeatPassword
	 */
	public static void setDifferentrepeatPassword(String differentrepeatPassword)
	{
		TestDataHome.differentrepeatPassword = differentrepeatPassword;
	}

	/**
	 * Method to get the invalid repeat password
	 * @return
	 */
	public static String getInvalidrepeatPassword()
	{
		return invalidrepeatPassword;
	}

	/**
	 * Method to set the invalid repeat password
	 * @param invalidrepeatPassword
	 */
	public static void setInvalidrepeatPassword(String invalidrepeatPassword)
	{
		TestDataHome.invalidrepeatPassword = invalidrepeatPassword;
	}

	
	/**
	 * Method to get the security answer
	 * @return
	 */
	public static String getSecurityAnswer()
	{
		return securityAnswer;
	}

	/**
	 * Method to set the Security Answer
	 * @param securityAnswer
	 */
	public static void setSecurityAnswer(String securityAnswer)
	{
		TestDataHome.securityAnswer = securityAnswer;
	}

}
