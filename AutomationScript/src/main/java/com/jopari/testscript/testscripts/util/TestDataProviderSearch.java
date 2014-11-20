package com.jopari.testscript.testscripts.util;

import java.io.IOException;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.exception.ColumnNotFoundException;
import com.jopari.automation.selenium.exception.MalformedFileException;
import com.jopari.automation.selenium.exception.RowNotFoundException;
import com.jopari.automation.util.io.ExcelReader;

/**
 * TestDataProviderSearch class will have the methods 
 * which provides us the functionality to data parameterization the data 
 * from the specific cells of the test data excel sheet 
 * and pass them onto the AUT Provider Search page related specific 
 * fields  
 * @author 
 *
 */
public class TestDataProviderSearch
{

	/*
	 * private static String userName; private static String password; private
	 * static String payorUsername; private static String payorPassword; private
	 * static String eraUserName;
	 * 
	 * private static String eraPassword;
	 */
	private static int providerSearchSheet = 4;
	private static String invalidCheckNumber;
	private static String validCheckNumber;
	private static String correctPayer;
	private static String invalidPayer;
	

	private static String uniqueAmount; 
	private static String multiplepaidamount;
	private static String invalidpaidamount;
	private static String invalidpatientaccountno;
	private static String uniquepatientaccountno;
	private static String invalidpatientlastname;
	private static String uniquepatientlastname;
	private static String multiplepatientlastname;
	private static String invalidpatientfirstname;
	private static String uniquepatientfirstname;
	private static String multiplepatientfirstname;
	private static String invalidpatientmembername;	
	private static String uniquepatientmembername;
	private static String multiplepatientmembername;
	private static String invalidclaimspayername;
	private static String uniqueclaimspayername;
	private static String invalideobpaidamount;
	private static String uniqueeobpaidamount;
	private static String multipleeobpaidamount;
	private static String validnpi;
	private static String invalidnpi;
	private static ExcelReader exReaderProviderSearch;
	
	
	static
	{
		try
		{
			exReaderProviderSearch = new ExcelReader(Constants.TEST_DATA, providerSearchSheet);
			setAllValue();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedFileException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ColumnNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowNotFoundException e)
		{
			// TODO Auto-generated catch block
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

		invalidCheckNumber = exReaderProviderSearch.getNumValue(1, 3);
		validCheckNumber = exReaderProviderSearch.getNumValue(2, 2);
		correctPayer = exReaderProviderSearch.getValue(3, 4);
		invalidPayer = exReaderProviderSearch.getValue(4,5);
		uniqueAmount = exReaderProviderSearch.getNumValue(5,6);
		multiplepaidamount = exReaderProviderSearch.getNumValue(6,7);
		invalidpatientaccountno = exReaderProviderSearch.getValue(7, 8);
		uniquepatientaccountno = exReaderProviderSearch.getValue(8, 9);
		invalidpatientlastname = exReaderProviderSearch.getValue(9, 8);
		uniquepatientlastname = exReaderProviderSearch.getValue(10, 9);
		multiplepatientlastname = exReaderProviderSearch.getValue(11, 10);
		invalidpaidamount = exReaderProviderSearch.getNumValue(12, 8);
		invalidpatientfirstname = exReaderProviderSearch.getValue(13, 8);
		uniquepatientfirstname = exReaderProviderSearch.getValue(14, 9);
		multiplepatientfirstname = exReaderProviderSearch.getValue(18, 10);
		invalidpatientmembername = exReaderProviderSearch.getValue(15, 8);
		uniquepatientmembername = exReaderProviderSearch.getNumValue(16, 9);
		multiplepatientmembername = exReaderProviderSearch.getNumValue(17, 10);
		invalidclaimspayername = exReaderProviderSearch.getValue(19, 8);
		uniqueclaimspayername = exReaderProviderSearch.getValue(20, 9);
		uniqueeobpaidamount = exReaderProviderSearch.getNumValue(21, 9);
		multipleeobpaidamount = exReaderProviderSearch.getNumValue(22, 10);
		invalideobpaidamount = exReaderProviderSearch.getNumValue(23,8);
		validnpi = exReaderProviderSearch.getNumValue(24, 10);
		invalidnpi = exReaderProviderSearch.getNumValue(25, 8);
	}
	
	public static String getInvalidnpi()
	{
		return invalidnpi;
	}

	public static void setInvalidnpi(String invalidnpi)
	{
		TestDataProviderSearch.invalidnpi = invalidnpi;
	}

	public static String getInvalidCheckNumber() {
		return invalidCheckNumber;
	}

	public static void setInvalidCheckNumber(String invalidCheckNumber) {
		TestDataProviderSearch.invalidCheckNumber = invalidCheckNumber;
	}

	public static String getValidCheckNumber() {
		return validCheckNumber;
	}

	public static void setValidCheckNumber(String validCheckNumber) {
		TestDataProviderSearch.validCheckNumber = validCheckNumber;
	}
	
	public static String getCorrectPayer()
	{
		return correctPayer;
	}

	public static void setCorrectPayer(String correctPayer)
	{
		TestDataProviderSearch.correctPayer = correctPayer;
	}

	public static String getUniqueAmount()
	{
		return uniqueAmount;
	}

	public static void setUniqueAmount(String uniqueAmount)
	{
		TestDataProviderSearch.uniqueAmount = uniqueAmount;
	}


	public static String getMultiplepaidamount()
	{
		return multiplepaidamount;
	}

	public static void setMultiplepaidamount(String multiplepaidamount)
	{
		TestDataProviderSearch.multiplepaidamount = multiplepaidamount;
	}
	public static String getInvalidpatientaccountno()
	{
		return invalidpatientaccountno;
	}

	public static void setInvalidpatientaccountno(String invalidpatientaccountno)
	{
		TestDataProviderSearch.invalidpatientaccountno = invalidpatientaccountno;
	}

	public static String getUniquepatientaccountno()
	{
		return uniquepatientaccountno;
	}

	public static void setUniquepatientaccountno(String uniquepatientaccountno)
	{
		TestDataProviderSearch.uniquepatientaccountno = uniquepatientaccountno;
	}

	public static String getInvalidpatientlastname()
	{
		return invalidpatientlastname;
	}

	public static void setInvalidpatientlastname(String invalidpatientlastname)
	{
		TestDataProviderSearch.invalidpatientlastname = invalidpatientlastname;
	}

	public static String getUniquepatientlastname()
	{
		return uniquepatientlastname;
	}

	public static void setUniquepatientlastname(String uniquepatientlastname)
	{
		TestDataProviderSearch.uniquepatientlastname = uniquepatientlastname;
	}

	public static String getMultiplepatientlastname()
	{
		return multiplepatientlastname;
	}

	public static void setMultiplepatientlastname(String multiplepatientlastname)
	{
		TestDataProviderSearch.multiplepatientlastname = multiplepatientlastname;
	}

	public static String getInvalidpaidamount()
	{
		return invalidpaidamount;
	}

	public static void setInvalidpaidamount(String invalidpaidamount)
	{
		TestDataProviderSearch.invalidpaidamount = invalidpaidamount;
	}

	public static String getInvalidpatientfirstname()
	{
		return invalidpatientfirstname;
	}

	public static void setInvalidpatientfirstname(String invalidpatientfirstname)
	{
		TestDataProviderSearch.invalidpatientfirstname = invalidpatientfirstname;
	}

	public static String getUniquepatientfirstname()
	{
		return uniquepatientfirstname;
	}

	public static void setUniquepatientfirstname(String uniquepatientfirstname)
	{
		TestDataProviderSearch.uniquepatientfirstname = uniquepatientfirstname;
	}

	public static String getMultiplepatientfirstname()
	{
		return multiplepatientfirstname;
	}

	public static void setMultiplepatientfirstname(String multiplepatientfirstname)
	{
		TestDataProviderSearch.multiplepatientfirstname = multiplepatientfirstname;
	}
	
	public static String getInvalidpatientmembername()
	{
		return invalidpatientmembername;
	}

	public static void setInvalidpatientmembername(String invalidpatientmembername)
	{
		TestDataProviderSearch.invalidpatientmembername = invalidpatientmembername;
	}

	public static String getUniquepatientmembername()
	{
		return uniquepatientmembername;
	}

	public static void setUniquepatientmembername(String uniquepatientmembername)
	{
		TestDataProviderSearch.uniquepatientmembername = uniquepatientmembername;
	}

	public static String getMultiplepatientmembername()
	{
		return multiplepatientmembername;
	}

	public static void setMultiplepatientmembername(String multiplepatientmembername)
	{
		TestDataProviderSearch.multiplepatientmembername = multiplepatientmembername;
	}
	public static String getInvalidclaimspayername()
	{
		return invalidclaimspayername;
	}

	public static void setInvalidclaimspayername(String invalidclaimspayername)
	{
		TestDataProviderSearch.invalidclaimspayername = invalidclaimspayername;
	}

	public static String getUniqueclaimspayername()
	{
		return uniqueclaimspayername;
	}

	public static void setUniqueclaimspayername(String uniqueclaimspayername)
	{
		TestDataProviderSearch.uniqueclaimspayername = uniqueclaimspayername;
	}

	public static String getUniqueeobpaidamount()
	{
		return uniqueeobpaidamount;
	}

	public static void setUniqueeobpaidamount(String uniqueeobpaidamount)
	{
		TestDataProviderSearch.uniqueeobpaidamount = uniqueeobpaidamount;
	}
	

	public static String getMultipleeobpaidamount()
	{
		return multipleeobpaidamount;
	}

	public static void setMultipleeobpaidamount(String multipleeobpaidamount)
	{
		TestDataProviderSearch.multipleeobpaidamount = multipleeobpaidamount;
	}

	public static String getInvalideobpaidamount()
	{
		return invalideobpaidamount;
	}

	public static void setInvalideobpaidamount(String invalideobpaidamount)
	{
		TestDataProviderSearch.invalideobpaidamount = invalideobpaidamount;
	}
	
	public static String getValidnpi()
	{
		return validnpi;
	}

	public static void setValidnpi(String validnpi)
	{
		TestDataProviderSearch.validnpi = validnpi;
	}

	public static String getInvalidPayer()
	{
		return invalidPayer;
	}

	public static void setInvalidPayer(String invalidPayer)
	{
		TestDataProviderSearch.invalidPayer = invalidPayer;
	}
}