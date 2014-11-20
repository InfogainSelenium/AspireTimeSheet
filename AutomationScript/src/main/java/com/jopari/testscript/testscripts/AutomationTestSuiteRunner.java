package com.jopari.testscript.testscripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import com.jopari.automation.selenium.base.Constants;
import com.jopari.automation.selenium.logging.ErrorEvent;
import com.jopari.automation.selenium.logging.InfoEvent;
import com.jopari.automation.selenium.logging.TestLogger;
import com.jopari.automation.testng.util.TestNGHelper;
import com.jopari.automation.util.exception.ExceptionUtil;
import com.jopari.automation.util.io.IOUtilities;

/**
 * @author Bharat Mehta
 * 
 */
public class AutomationTestSuiteRunner
{

	public static SeleniumServer server;

	/**
	 * This method will start the selenium server automatically when any test
	 * suite will be run
	 * 
	 * @throws Exception
	 */
	public void startSeleniumServer() throws Exception
	{

		try
		{
			ServerSocket serverSocket = new ServerSocket(
					RemoteControlConfiguration.DEFAULT_PORT);
			serverSocket.close();
			// Server not up, start it
			try
			{
				RemoteControlConfiguration rcc = new RemoteControlConfiguration();
				rcc.setSingleWindow(true);
				rcc.setPort(RemoteControlConfiguration.DEFAULT_PORT);
				server = new SeleniumServer(false, rcc);
			} catch (Exception e)
			{
				TestLogger.log(new ErrorEvent(this.getClass(),
						"Failed in executing updateSQLs:"
								+ ExceptionUtil.stackTraceToString(e)));
			}
			try
			{
				server.boot();
				TestLogger
						.log(new InfoEvent(this.getClass(), "Server started"));
			} catch (Exception e)
			{
				TestLogger.log(new ErrorEvent(this.getClass(),
						"Could not start Selenium Server because of: "
								+ ExceptionUtil.stackTraceToString(e)));
			}
		} catch (BindException e)
		{
			TestLogger.log(new InfoEvent(this.getClass(),
					"Selenium server already up, will reuse..."));
		}
	}

	/**
	 * This method will be responsible for below task:
	 * <ul>
	 * <li>Load runnableTeseCases file
	 * <li>Then checks all XML file name with path in that file
	 * <li>If not present or a directory then log error message, but will
	 * continue with fine ones
	 * <li>Create XML Suites from XML file
	 * <li>Execute that all XMLSuites through TestNG
	 * 
	 * @throws IOException
	 */
	private void run(List<String> runnableTestSuiteFileNames)
			throws IOException
	{

		System.out.println("run called");
		String browser = System.getProperty("browser");
		if (runnableTestSuiteFileNames == null)// Means command line
			runnableTestSuiteFileNames = IOUtilities
					.readTextLinesInFile(Constants.RUNNABLE_TEST_CASES);
		List<XmlSuite> listOfXMLSuitesToExecute = new ArrayList<XmlSuite>();
		if ((runnableTestSuiteFileNames != null)
				&& (!runnableTestSuiteFileNames.isEmpty()))
		{
			for (String fileName : runnableTestSuiteFileNames)
			{
				System.out.println("File name " + fileName);

				File file = new File(fileName);
				// For logging purpose
				if (!file.exists())
				{
					TestLogger.log(new ErrorEvent(this.getClass(),
							"File not reachable: " + fileName));
					continue;
				} else if (file.isDirectory())
				{
					TestLogger.log(new ErrorEvent(this.getClass(),
							"Not a file: " + fileName));
					continue;
				}
				try
				{
					List<XmlSuite> xmlSuiteList = TestNGHelper.parse(fileName);
					if (xmlSuiteList == null)
					{
						throw new ParserConfigurationException(
								"Not able to parse file: " + fileName);
					}
					TestLogger.log(new InfoEvent(this.getClass(),
							"Adding XMLSuites for file: " + fileName
									+ ", into list to execute"));

					// Add XML Suites object to final list, which will be run
					listOfXMLSuitesToExecute.add(xmlSuiteList.get(0));
				} catch (ParserConfigurationException e)
				{
					TestLogger.log(new ErrorEvent(this.getClass(),
							"Parsing error in file: " + fileName));
					TestLogger.log(new ErrorEvent(this.getClass(),
							ExceptionUtil.stackTraceToString(e)));
				} catch (SAXException e)
				{
					TestLogger.log(new ErrorEvent(this.getClass(),
							"Parsing error in file: " + fileName));
					TestLogger.log(new ErrorEvent(this.getClass(),
							ExceptionUtil.stackTraceToString(e)));
				}
			}
			TestNGHelper.executesTest(listOfXMLSuitesToExecute, browser);
		}
	}

	public static void initiateRun(List<String> runnableTestSuiteFileNames)
	{
		AutomationTestSuiteRunner runner = new AutomationTestSuiteRunner();
		try
		{
			runner.run(runnableTestSuiteFileNames);
		} catch (IOException e)
		{
			TestLogger.log(new ErrorEvent(AutomationTestSuiteRunner.class,
					ExceptionUtil.stackTraceToString(e)));
		}
	}

	public static void main(String args[]) throws FileNotFoundException,
			IOException
	{
		AutomationTestSuiteRunner runner = new AutomationTestSuiteRunner();
		List<String> listofXMLSuitesToExecute = new ArrayList<String>();
		int argslength = args.length;
		String xmlSuiteFileNames[] = null;
		/*
		 * Properties property = IOUtilities
		 * .loadProperties(Constants.TEST_DETAIL_PROPERTIES);
		 */
		String fileNames = System.getProperty("file");
		// if(argslength==1)
		// xmlSuiteFileNames=args[0].split(" ");
		// else
		String token[] = fileNames.split(",");
		xmlSuiteFileNames = token;
		int xmlCount;
		int filesCount = xmlSuiteFileNames.length;
		System.out.println("File Count " + filesCount);
		try
		{
			if (filesCount == 0)
				runner.run(null);
			else
			{
				for (xmlCount = 0; xmlCount < filesCount; xmlCount++)
					listofXMLSuitesToExecute.add(xmlSuiteFileNames[xmlCount]);
				runner.run(listofXMLSuitesToExecute);

			}

		} catch (IOException e)
		{
			TestLogger.log(new ErrorEvent(AutomationTestSuiteRunner.class,
					ExceptionUtil.stackTraceToString(e)));
		}

	}
}
