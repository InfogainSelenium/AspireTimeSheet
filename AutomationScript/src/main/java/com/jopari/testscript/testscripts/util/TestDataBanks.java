package com.jopari.testscript.testscripts.util;

import java.io.IOException;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.exception.ColumnNotFoundException;
import com.jopari.automation.selenium.exception.MalformedFileException;
import com.jopari.automation.selenium.exception.RowNotFoundException;
import com.jopari.automation.util.io.ExcelReader;

/**
 * TestDataBanks class will have the methods 
 * which provides us the functionality to pick the data 
 * from the specific cells of the test data excel sheet 
 * and pass them onto the AUT Banks page related specific 
 * fields  
 * @author 
 *
 */

public class TestDataBanks
{
	private static int bankSheet = 5;
	public static ExcelReader exReaderBanks;
	private static String validRoutingNo;
	private static String invalidRoutingNo;
	private static String validAccountNo;
	private static String existingRoutingNo;
	private static String invalidRoutingNoOneDigit;
	private static String invalidRoutingNoNineDigit;
	private static String invalidRoutingNoAplhaNumeric;
	private static String invalidRoutingNoSpecialCharacters;
	private static String existingAccountNo;
	private static String existingAccountName;
	private static String validTin;
	private static String invalidTinSpecialCharacters;
	private static String invalidTinAlphabets;
	private static String invalidTinTenDigits;
	private static String invalidTinSingleDigit;
	private static String invalidTinHyphens;
	private static String validNpi;
	private static String invalidNpiSpecialCharacters;
	private static String invalidNpiAlphabets;
	private static String invalidNpiNineDigit;
	private static String invalidNpiSingleDigit;
	private static String invalidNpiHyphens;
	private static String routingNoForRejection;
	private static String accountNoForRejection;
	private static String TINNoForRejection;
	private static String accountNoForViewScheduleLink;
	private static String accountNotoVerifyLeftPanel;
	private static String routingNotoVerifyLeftPanel;
	private static String accountNoForSelectDiffBankNCancel;
	static
	{
		try
		{
			exReaderBanks = new ExcelReader(Constants.TEST_DATA, bankSheet);
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

		validRoutingNo = exReaderBanks.getNumValue(1, 2);
		invalidRoutingNo = exReaderBanks.getNumValue(2, 3);
		invalidRoutingNoOneDigit = exReaderBanks.getNumValue(5,3);
		invalidRoutingNoNineDigit = exReaderBanks.getNumValue(6,3);
		invalidRoutingNoAplhaNumeric = exReaderBanks.getValue(7, 3);
		invalidRoutingNoSpecialCharacters = exReaderBanks.getValue(8, 3);
		validAccountNo = exReaderBanks.getNumValue(3, 2);
		existingRoutingNo = exReaderBanks.getNumValue(4, 4);
		existingAccountNo = exReaderBanks.getNumValue(4,5);
		existingAccountName = exReaderBanks.getValue(9, 2);
		validTin = exReaderBanks.getNumValue(10, 2);
		invalidTinSpecialCharacters = exReaderBanks.getValue(11, 3);
		invalidTinAlphabets = exReaderBanks.getValue(12 , 3);
		invalidTinTenDigits = exReaderBanks.getNumValue(13, 3);
		invalidTinSingleDigit = exReaderBanks.getNumValue(14, 3);
		invalidTinHyphens = exReaderBanks.getValue(15, 3);
		validNpi = exReaderBanks.getNumValue(16, 2);
		invalidNpiSpecialCharacters = exReaderBanks.getValue(17, 3);
		invalidNpiAlphabets = exReaderBanks.getValue(18, 3);
		invalidNpiNineDigit = exReaderBanks.getNumValue(19, 3);
		invalidNpiSingleDigit = exReaderBanks.getNumValue(20, 3);
		invalidNpiHyphens = exReaderBanks.getValue(21, 3);
		routingNoForRejection = exReaderBanks.getValue(22, 2);
		accountNoForRejection = exReaderBanks.getValue(22, 5);
		TINNoForRejection = exReaderBanks.getValue(22, 6);
		accountNoForViewScheduleLink= exReaderBanks.getValue(23, 5);
		routingNotoVerifyLeftPanel= exReaderBanks.getValue(24, 4);
		accountNotoVerifyLeftPanel= exReaderBanks.getValue(24, 5);
		accountNoForSelectDiffBankNCancel= exReaderBanks.getValue(25, 5);
	}

	public static String getValidRoutingNum()
	{
		return validRoutingNo;
	}

	public static void setValidRoutingNo(String validRoutingNo)
	{
		TestDataBanks.validRoutingNo = validRoutingNo;
	}

	public static String getInvalidRoutingNum()
	{
		return invalidRoutingNo;
	}

	public static void setInvalidRoutingNo(String invalidRoutingNo)
	{
		TestDataBanks.invalidRoutingNo = invalidRoutingNo;
	}
	
	public static String getValidAccountNum()
	{
		return validAccountNo;
	}

	public static void setValidAccountNo(String validAccountNo)
	{
		TestDataBanks.validAccountNo = validAccountNo;
	}

	public static String getExistingRoutingNum()
	{
		return existingRoutingNo;
	}

	public static void setExistingRoutingNo(String existingRoutingNo)
	{
		TestDataBanks.existingRoutingNo = existingRoutingNo;
	}

	public static String getExistingAccountNum()
	{
		return existingAccountNo;
	}

	public static void setExistingAccountNo(String existingAccountNo)
	{
		TestDataBanks.existingAccountNo = existingAccountNo;
	}
	public static String getInvalidRoutingNumOneDigit()
	{
		return invalidRoutingNoOneDigit;
	}

	public static void setInvalidRoutingNoOneDigit(String invalidRoutingNoOneDigit)
	{
		TestDataBanks.invalidRoutingNoOneDigit = invalidRoutingNoOneDigit;
	}

	public static String getInvalidRoutingNumNineDigit()
	{
		return invalidRoutingNoNineDigit;
	}

	public static void setInvalidRoutingNoNineDigit(String invalidRoutingNoNineDigit)
	{
		TestDataBanks.invalidRoutingNoNineDigit = invalidRoutingNoNineDigit;
	}

	public static String getInvalidRoutingNumAplhaNumeric()
	{
		return invalidRoutingNoAplhaNumeric;
	}

	public static void setInvalidRoutingNoAplhaNumeric(String invalidRoutingNoAplhaNumeric)
	{
		TestDataBanks.invalidRoutingNoAplhaNumeric = invalidRoutingNoAplhaNumeric;
	}

	public static String getInvalidRoutingNumSpecialCharacters()
	{
		return invalidRoutingNoSpecialCharacters;
	}

	public static void setInvalidRoutingNoSpecialCharacters(String invalidRoutingNoSpecialCharacters)
	{
		TestDataBanks.invalidRoutingNoSpecialCharacters = invalidRoutingNoSpecialCharacters;
	}
	
	public static String getExistingAccountName()
	{
		return existingAccountName;
	}

	public static void setExistingAccountName(String existingAccountName)
	{
		TestDataBanks.existingAccountName = existingAccountName;
	}

	public static String getValidTin()
	{
		return validTin;
	}

	public static void setValidTin(String validTin)
	{
		TestDataBanks.validTin = validTin;
	}

	public static String getInvalidTinSpecialCharacters()
	{
		return invalidTinSpecialCharacters;
	}

	public static void setInvalidTinSpecialCharacters(String invalidTinSpecialCharacters)
	{
		TestDataBanks.invalidTinSpecialCharacters = invalidTinSpecialCharacters;
	}

	public static String getInvalidTinAlphabets()
	{
		return invalidTinAlphabets;
	}

	public static void setInvalidTinAlphabets(String invalidTinAlphabets)
	{
		TestDataBanks.invalidTinAlphabets = invalidTinAlphabets;
	}

	public static String getInvalidTinTenDigits()
	{
		return invalidTinTenDigits;
	}

	public static void setInvalidTinTenDigits(String invalidTinTenDigits)
	{
		TestDataBanks.invalidTinTenDigits = invalidTinTenDigits;
	}

	public static String getInvalidTinSingleDigit()
	{
		return invalidTinSingleDigit;
	}

	public static void setInvalidTinSingleDigit(String invalidTinSingleDigit)
	{
		TestDataBanks.invalidTinSingleDigit = invalidTinSingleDigit;
	}

	public static String getInvalidTinHyphens()
	{
		return invalidTinHyphens;
	}

	public static void setInvalidTinHyphens(String invalidTinHyphens)
	{
		TestDataBanks.invalidTinHyphens = invalidTinHyphens;
	}

	public static String getValidNpi()
	{
		return validNpi;
	}

	public static void setValidNpi(String validNpi)
	{
		TestDataBanks.validNpi = validNpi;
	}

	public static String getInvalidNpiSpecialCharacters()
	{
		return invalidNpiSpecialCharacters;
	}

	public static void setInvalidNpiSpecialCharacters(String invalidNpiSpecialCharacters)
	{
		TestDataBanks.invalidNpiSpecialCharacters = invalidNpiSpecialCharacters;
	}

	public static String getInvalidNpiAlphabets()
	{
		return invalidNpiAlphabets;
	}

	public static void setInvalidNpiAlphabets(String invalidNpiAlphabets)
	{
		TestDataBanks.invalidNpiAlphabets = invalidNpiAlphabets;
	}

	public static String getInvalidNpiNineDigit()
	{
		return invalidNpiNineDigit;
	}

	public static void setInvalidNpiNineDigit(String invalidNpiNineDigit)
	{
		TestDataBanks.invalidNpiNineDigit = invalidNpiNineDigit;
	}

	public static String getInvalidNpiSingleDigit()
	{
		return invalidNpiSingleDigit;
	}

	public static void setInvalidNpiSingleDigit(String invalidNpiSingleDigit)
	{
		TestDataBanks.invalidNpiSingleDigit = invalidNpiSingleDigit;
	}

	public static String getInvalidNpiHyphens()
	{
		return invalidNpiHyphens;
	}

	public static void setInvalidNpiHyphens(String invalidNpiHyphens)
	{
		TestDataBanks.invalidNpiHyphens = invalidNpiHyphens;
	}
	public static String getRoutingNumForRejection()
	{
		return routingNoForRejection;
	}

	public static void setRoutingNoForRejection(String routingNoForRejection)
	{
		TestDataBanks.routingNoForRejection = routingNoForRejection;
	}
	public static String getAccountNumForRejection()
	{
		return accountNoForRejection;
	}

	public static void setAccountNoForRejection(String accountNoForRejection)
	{
		TestDataBanks.accountNoForRejection = accountNoForRejection;
	}
	public static String getTINNumForRejection()
	{
		return TINNoForRejection;
	}

	public static void setTINNoForRejection(String TINNoForRejection)
	{
		TestDataBanks.TINNoForRejection = TINNoForRejection;
	}
	public static String getAccountNumForViewScheduleLink()
	{
		return accountNoForViewScheduleLink;
	}

	public static void setAccountNoForViewScheduleLink(String accountNoForViewScheduleLink)
	{
		TestDataBanks.accountNoForViewScheduleLink = accountNoForViewScheduleLink;
	}
	public static String getroutingNumtoVerifyLeftPanel()
	{
		return routingNotoVerifyLeftPanel;
	}

	public static void setroutingNotoVerifyLeftPanel(String routingNotoVerifyLeftPanel)
	{
		TestDataBanks.routingNotoVerifyLeftPanel = routingNotoVerifyLeftPanel;
	}
	public static String getaccountNumtoVerifyLeftPanel()
	{
		return accountNotoVerifyLeftPanel;
	}

	public static void setaccountNotoVerifyLeftPanel(String accountNotoVerifyLeftPanel)
	{
		TestDataBanks.accountNotoVerifyLeftPanel = accountNotoVerifyLeftPanel;
	}
	public static String getaccountNumForSelectDiffBankNCancel()
	{
		return accountNoForSelectDiffBankNCancel;
	}

	public static void setaccountNoForSelectDiffBankNCancel(String accountNoForSelectDiffBankNCancel)
	{
		TestDataBanks.accountNoForSelectDiffBankNCancel = accountNoForSelectDiffBankNCancel;
	}
}