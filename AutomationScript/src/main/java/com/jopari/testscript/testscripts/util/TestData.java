package com.jopari.testscript.testscripts.util;

import java.io.IOException;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.exception.ColumnNotFoundException;
import com.jopari.automation.selenium.exception.MalformedFileException;
import com.jopari.automation.selenium.exception.RowNotFoundException;
import com.jopari.automation.util.io.ExcelReader;

/**
 * This Class TestData will help in the data parameterization
 * of the test suites with their respective test data
 * by the help of the getter, setter method. It reads data specific 
 * to usernames and passwords.
 * @author 
 *
 */
public class TestData
{
	
	private static String userNameTestUser1Provider;
	private static String passwordTestUser1Provider;
	private static String userNameLfgUserProvider;
	private static String passwordLfgUserProvider;
	private static String userNameHcPcsPayer;
	private static String passwordHcPcsPayer;
	private static String userNameEmblemPayer;
	private static String passwordEmblemPayer;
	private static String userNameMmoPayer;
	private static String passwordMmoPayer;
	private static String userNameMooPayer; 
	private static String passwordMooPayer;
	private static String userNameLfgPayer;
	private static String passwordLfgPayer;
	private static String userNameNalcPayer;
	private static String passwordNalcPayer;
	private static String userNameCciPayer;
	private static String passwordCciPayer;
	private static String userNameRepoPortal;
	private static String passwordRepoPortal;
	private static int commonSheet = 0;

	public static ExcelReader exReaderCommon;

	static
	{
		try
		{

			exReaderCommon = new ExcelReader(Constants.TEST_DATA,
					commonSheet);
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
		userNameTestUser1Provider = exReaderCommon.getValue(1, 1);
		passwordTestUser1Provider = exReaderCommon.getValue(1, 2);
		userNameLfgUserProvider = exReaderCommon.getValue(2, 1);
		passwordLfgUserProvider = exReaderCommon.getValue(2, 2);
		userNameHcPcsPayer = exReaderCommon.getValue(3, 1);
		passwordHcPcsPayer = exReaderCommon.getValue(3, 2);
		userNameEmblemPayer = exReaderCommon.getValue(4, 1);
		passwordEmblemPayer = exReaderCommon.getValue(4, 2);
		userNameMmoPayer = exReaderCommon.getValue(5, 1);
		passwordMmoPayer = exReaderCommon.getValue(5, 2);
		userNameMooPayer = exReaderCommon.getValue(6, 1);
		passwordMooPayer = exReaderCommon.getValue(6, 2);
		userNameLfgPayer = exReaderCommon.getValue(7, 1);
		passwordLfgPayer = exReaderCommon.getValue(7, 2);
		userNameNalcPayer = exReaderCommon.getValue(8, 1);
		passwordNalcPayer = exReaderCommon.getValue(8, 2);
		userNameCciPayer = exReaderCommon.getValue(9, 1);
		passwordCciPayer = exReaderCommon.getValue(9, 2);
		userNameRepoPortal= exReaderCommon.getValue(10, 1);
		passwordRepoPortal= exReaderCommon.getValue(10, 2);
	}

	
	public static int getCommonSheet()
	{
		return commonSheet;
	}

	public static void setCommonSheet(int commonSheet)
	{
		TestData.commonSheet = commonSheet;
	}

	public static ExcelReader getExReaderCommon()
	{
		return exReaderCommon;
	}

	public static void setExReaderCommon(ExcelReader exReaderCommon)
	{
		TestData.exReaderCommon = exReaderCommon;
	}
	
	public static String getUserNameTestUser1Provider()
	{
		return userNameTestUser1Provider;
	}


	public static void setUserNameTestUser1Provider(String userNameTestUser1Provider)
	{
		TestData.userNameTestUser1Provider = userNameTestUser1Provider;
	}


	public static String getPasswordTestUser1Provider()
	{
		return passwordTestUser1Provider;
	}


	public static void setPasswordTestUser1Provider(String passwordTestUser1Provider)
	{
		TestData.passwordTestUser1Provider = passwordTestUser1Provider;
	}


	public static String getUserNameLfgUserProvider()
	{
		return userNameLfgUserProvider;
	}


	public static void setUserNameLfgUserProvider(String userNameLfgUserProvider)
	{
		TestData.userNameLfgUserProvider = userNameLfgUserProvider;
	}


	public static String getPasswordLfgUserProvider()
	{
		return passwordLfgUserProvider;
	}


	public static void setPasswordLfgUserProvider(String passwordLfgUserProvider)
	{
		TestData.passwordLfgUserProvider = passwordLfgUserProvider;
	}


	public static String getUserNameHcPcsPayer()
	{
		return userNameHcPcsPayer;
	}


	public static void setUserNameHcPcsPayer(String userNameHcPcsPayer)
	{
		TestData.userNameHcPcsPayer = userNameHcPcsPayer;
	}


	public static String getPasswordHcPcsPayer()
	{
		return passwordHcPcsPayer;
	}


	public static void setPasswordHcPcsPayer(String passwordHcPcsPayer)
	{
		TestData.passwordHcPcsPayer = passwordHcPcsPayer;
	}


	public static String getUserNameEmblemPayer()
	{
		return userNameEmblemPayer;
	}


	public static void setUserNameEmblemPayer(String userNameEmblemPayer)
	{
		TestData.userNameEmblemPayer = userNameEmblemPayer;
	}


	public static String getPasswordEmblemPayer()
	{
		return passwordEmblemPayer;
	}


	public static void setPasswordEmblemPayer(String passwordEmblemPayer)
	{
		TestData.passwordEmblemPayer = passwordEmblemPayer;
	}


	public static String getUserNameMmoPayer()
	{
		return userNameMmoPayer;
	}


	public static void setUserNameMmoPayer(String userNameMmoPayer)
	{
		TestData.userNameMmoPayer = userNameMmoPayer;
	}


	public static String getPasswordMmoPayer()
	{
		return passwordMmoPayer;
	}


	public static void setPasswordMmoPayer(String passwordMmoPayer)
	{
		TestData.passwordMmoPayer = passwordMmoPayer;
	}


	public static String getUserNameMooPayer()
	{
		return userNameMooPayer;
	}


	public static void setUserNameMooPayer(String userNameMooPayer)
	{
		TestData.userNameMooPayer = userNameMooPayer;
	}


	public static String getPasswordMooPayer()
	{
		return passwordMooPayer;
	}


	public static void setPasswordMooPayer(String passwordMooPayer)
	{
		TestData.passwordMooPayer = passwordMooPayer;
	}


	public static String getUserNameLfgPayer()
	{
		return userNameLfgPayer;
	}


	public static void setUserNameLfgPayer(String userNameLfgPayer)
	{
		TestData.userNameLfgPayer = userNameLfgPayer;
	}


	public static String getPasswordLfgPayer()
	{
		return passwordLfgPayer;
	}


	public static void setPasswordLfgPayer(String passwordLfgPayer)
	{
		TestData.passwordLfgPayer = passwordLfgPayer;
	}


	public static String getUserNameNalcPayer()
	{
		return userNameNalcPayer;
	}


	public static void setUserNameNalcPayer(String userNameNalcPayer)
	{
		TestData.userNameNalcPayer = userNameNalcPayer;
	}


	public static String getPasswordNalcPayer()
	{
		return passwordNalcPayer;
	}


	public static void setPasswordNalcPayer(String passwordNalcPayer)
	{
		TestData.passwordNalcPayer = passwordNalcPayer;
	}


	public static String getUserNameCciPayer()
	{
		return userNameCciPayer;
	}


	public static void setUserNameCciPayer(String userNameCciPayer)
	{
		TestData.userNameCciPayer = userNameCciPayer;
	}
	public static String getPasswordCciPayer()
	{
		return passwordCciPayer;
	}


	public static void setPasswordCciPayer(String passwordCciPayer)
	{
		TestData.passwordCciPayer = passwordCciPayer;
	}


	public static String getUserNameRepoPortal()
	{
		return userNameRepoPortal;
	}


	public static void setUserNameRepoPortal(String userNameRepoPortal)
	{
		TestData.userNameRepoPortal = userNameRepoPortal;
	}
	public static String getPasswordRepoPortal()
	{
		return passwordRepoPortal;
	}


	public static void setPasswordRepoPortal(String passwordRepoPortal)
	{
		TestData.passwordRepoPortal = passwordRepoPortal;
	}

}
