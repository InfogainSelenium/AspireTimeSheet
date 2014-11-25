package com.jopari.testscript.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
//import org.openqa.selenium.browserlaunchers.Sleeper;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

import com.jopari.automation.selenium.browser.FirefoxBrowser;
import com.jopari.automation.selenium.browser.IInternetBrowser;
import com.jopari.automation.webdriver.util.WebDriverUtil;
import com.jopari.automation.webdriver.util.WebDriverUtilException;
import com.jopari.automation.webdriver.util.WindowHelper;
import com.jopari.testscript.testscripts.util.TestDataHome;
import com.jopari.testscript.testscripts.util.TestUtil;

/**
 * This class is a page object for PayerHomePage.java and ProviderHomePage.java
 * 
 * 
 * @author Kanika.Agarwal
 * 
 */
public class TimeSheetHomePage
{
	private static final String CLOSING_THE_POPUP_WINDOW = "Closing the Popup Window";
	private WebDriver driver;
	private IInternetBrowser browser;
	private Integer delayMultiplier;

	/**
	 * Constructor of HomePage that initialise driver
	 * 
	 * @param driver
	 */
	public TimeSheetHomePage(WebDriver driver)
	{
		this(driver, (IInternetBrowser) new FirefoxBrowser());
	}
	
	public TimeSheetHomePage(WebDriver driver, IInternetBrowser browser)
	{
		this.driver = driver;
		this.browser = browser;
		delayMultiplier = browser.getDelayMultiplier();
	}
	

	  
	  public String selectedYrFromDropDown() throws Exception {
	      Sleeper.sleepTightInSeconds(10);
	      WebDriverUtil.waitForElementByXpath("//*[@id='ctl00_contentplaceholder1_ddlYear']", 10, driver);
	                  //int yearint = Calendar.getInstance().get(Calendar.YEAR);
	                  //System.out.println("current year is "+ yearint);
	      
	                  //String year = Integer.toString(yearint);
	                  //DateFormat dateFormat = new SimpleDateFormat("yyyy");
	                   //get current date time with Date()
	                   //Date date = new Date();
	                                   
	                   //String currentdate = new String(dateFormat.format(date));
	                  // System.out.println(currentdate);
	                   //String[] currentdatefield = currentdate.split("/");
	                   //String currentYear = currentdatefield[0];
	                   //String currentMonth = currentdatefield[1];
	                   //String currentDatee = currentdatefield[2];
	                   //System.out.println("Current Year is " +currentYear);
	                   //System.out.println("Current Month is " +currentMonth);
	                   //System.out.println("Current Date is " +currentDatee);
	                   //Sleeper.sleepTightInSeconds(10);
	                   /*System.out.println("Year is about to start Executed");
	                   List<WebElement> Year = driver.findElements(By.xpath("//*[@id='ctl00_contentplaceholder1_ddlYear']"));
	                   System.out.println("Year is Executed");
	                   for (WebElement element:Year){
	                                   System.out.println(element.getText());
	                   }
	                   System.out.println(Year);*/
	                   
	                   String selectedyear = new Select(driver.findElement(By.xpath("//*[@id='ctl00_contentplaceholder1_ddlYear']"))).getFirstSelectedOption().getText();
	                   System.out.println("Selected Year is " + selectedyear);
	                   //Assert.assertEquals(selectedyear, year);
	                   //System.out.println("ActDateYear is Executed");
	                   
	                   
	                 //*[@id='ctl00_contentplaceholder1_ddlYear']
	                  return selectedyear; 
	  }
	  
	  public static Select selectDropDown(WebDriver driver)
		{
			WebElement element=driver.findElement(By.xpath("//*[@id='ctl00_contentplaceholder1_ddlWeek']"));
		   	
	        Select select =new Select(element);
	        return select;
		}
		
	

	/**
	 * This method recognise a web link by its text and clicks the web link
	 * 
	 * @param linkText
	 * @throws Exception
	 */
	public void clickLinkByLinkText(String linkText) throws Exception
	{
		try
		{
			TestUtil.infoLog(this.getClass(), "Finding Element by link text : " + linkText);
			WebDriverUtil.waitForElementByLinkText(linkText, 3, driver);
			WebDriverUtil.findElementByLinkText(linkText, driver).click();
			sleep(2);
		} catch (WebDriverUtilException webdriverexception)
		{
			TestUtil.errorLog(this.getClass(), "ElementNotFoundException by link text " + webdriverexception.getMessage());
			throw webdriverexception;
		}
	}

	/**
	 * This method recognise a web link by its xpath and clicks the web link
	 * 
	 * @param xpath
	 * @throws Exception
	 */
	public void clickLinkByXpath(String xpath) throws Exception
	{
		try
		{
			TestUtil.infoLog(this.getClass(), "Finding Element by Xpath : ");
			//WebDriverUtil.waitForElementByXpath(xpath, 3, driver);
			WebDriverUtil.findElementByXpath(xpath, driver).click();

		} catch (WebDriverUtilException webdriverexception)
		{
			TestUtil.errorLog(this.getClass(), "ElementNotFoundException by link text " + webdriverexception.getMessage());
			throw webdriverexception;
		}

	}

	/**
	 * This method switches to the new popup window by switching the driver to
	 * new popup window
	 * 
	 * @param driver
	 * @throws WebDriverUtilException
	 */
	public void switchToPopupWindow(WebDriver driver) throws WebDriverUtilException
	{
		WebDriverUtil.waitForJavaScript(driver);
		WebDriverUtil.handlePopupWindow(driver);
	}

	/**
	 * This method gets the title of current web page
	 * 
	 * @param driver
	 * @return
	 */
	public String popupHandleGetTitle(WebDriver driver)
	{
		return driver.getTitle();
	}

	/**
	 * This method closes the popup window
	 * 
	 * @param driver
	 * @param homePageHandler
	 */
	public void closePopup(WebDriver driver, String homePageHandler)
	{
		TestUtil.infoLog(this.getClass(), CLOSING_THE_POPUP_WINDOW);
		driver.switchTo().defaultContent().close();
		driver.switchTo().window(homePageHandler);
	}

	/**
	 * This method identifies the close button on web page. It clicks the button
	 * to close the window.
	 * 
	 * @param homePageHandler
	 * @throws WebDriverUtilException
	 */
	public void clickCloseButton(String homePageHandler) throws WebDriverUtilException
	{
		String xpath = "//input[@value='Close Window']";
		WebDriverUtil.findElementByXpath(xpath, driver).click();
		driver.switchTo().window(homePageHandler);

	}

	/**
	 * This method switches the driver to a given handler
	 * 
	 * @param homePageHandler
	 */
	public void switchToHandler(String homePageHandler)
	{
		driver.switchTo().window(homePageHandler);
	}

	/**
	 * This method closes any alert that pops up
	 * 
	 * @throws WebDriverUtilException
	 */
	public void closeAlert() throws WebDriverUtilException
	{
		WebDriverUtil.acceptAlert(driver);
	}

	/**
	 * This method switches the driver to an iframe
	 * 
	 * @param iframe_id
	 * @throws WebDriverUtilException
	 */
	public void switchToIframe(String iframe_id) throws WebDriverUtilException
	{
		driver.switchTo().frame(WebDriverUtil.findElementByID(iframe_id, driver));
	}

	/**
	 * This method finds link View/Update security Info on home page and clicks
	 * it
	 * 
	 * @throws WebDriverUtilException
	 */
	public void viewUpdateSecurityInfo() throws WebDriverUtilException
	{
		TestUtil.infoLog(this.getClass(), "Switching to View/Update security Info");
		sleep(6);
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ifra_home' or @name='ifra_home']")));
		driver.switchTo().frame(driver.findElement(By.id("ifra_home")));
		TestUtil.infoLog(this.getClass(), "===-------------clicking on View/Update security Info-------------===");
		sleep(6);
		driver.findElement(
				By.xpath("//a[contains(@href,'/PNCGH/menu.do?forward=changePassword&flow=f_changePassword&param.src=mbt')]")).click();
		sleep(4);
	}

	/**
	 * This method returns a text found on web page identified by a given xpath
	 * 
	 * @param xpath
	 * @return String
	 * @throws WebDriverUtilException
	 */
	public String getTextByXpath(String xpath) throws WebDriverUtilException
	{
		String text = WebDriverUtil.findElementByXpath(xpath, driver).getText();
		return text;

	}

	/**
	 * This method returns a text found on web page identified by a given
	 * className
	 * 
	 * @param className
	 * @return
	 * @throws WebDriverUtilException
	 */
	public String getTextByClassName(String className) throws WebDriverUtilException
	{
		String text = WebDriverUtil.findElementByClassName(className, driver).getText();
		return text;
	}

	/**
	 * This method fetches a list of the security questions available on
	 * View/Update security info
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSecurityQuestion() throws Exception
	{
		Sleeper.sleepTightInSeconds(3);
		WebDriverUtil.findElementByID("qlist", driver);
		WebDriverUtil.SelectfromDropDown(TestDataHome.getSecurityquestionnumber(), driver, "qlist");
		String text = WebDriverUtil.findElementByID("qlist", driver).getText();
		return text;

	}

	/**
	 * This method enters passsword on View/Update security info page and checks
	 * if password entered is valid or invalid
	 * 
	 * @param passwordType
	 * @return boolean
	 * @throws WebDriverUtilException
	 */
	public boolean checkpassword(String passwordType) throws WebDriverUtilException
	{
		boolean checkIfPresent = false;
		Sleeper.sleepTightInSeconds(5);
		//WebDriverUtil.findElementByID("qlist", driver);
		WebDriverUtil.SelectfromDropDown(1, driver, "qlist");
		WebDriverUtil.findElementByName("req.param.answer1.val", driver).clear();
		sleep(4);
		WebDriverUtil.findElementByName("req.param.answer1.val", driver).sendKeys(TestDataHome.getSecurityAnswer());
		TestUtil.infoLog(this.getClass(),
				"Finding textbox for New password to fill in alphanumeric value of password");
		if (passwordType.equals("valid"))
		{
			typePassword(TestDataHome.getValidAlphaPassword(), TestDataHome.getValidAlphaPassword());
			TestUtil.infoLog(this.getClass(), "Finding Update Button by ID 'update' ");
			WebDriverUtil.waitForJavaScript(driver);
			checkIfPresent = WindowHelper.isTextPresentOnPage("Your security info has been updated", driver);
		}
		else if (passwordType.equals("invalid"))
		{
			typePassword(TestDataHome.getInvalidAlphaPassword(), TestDataHome.getInvalidAlphaPassword());
			WebDriverUtil.waitForJavaScript(driver);
			checkIfPresent = WindowHelper.isTextPresentOnPage("Password must be at least 8 character", driver);

		}
		else if (passwordType.equals("invalidnumeric"))
		{
			typePassword(TestDataHome.getInvalidNumericPassword(), TestDataHome.getInvalidNumericPassword());
			WebDriverUtil.waitForJavaScript(driver);
			checkIfPresent = WindowHelper.isTextPresentOnPage("Password must be at least 8 character", driver);

		}
		else if (passwordType.equals("validrepeatpassword"))
		{
			WebDriverUtil.findElementByID("req.param.newpassword1.val", driver).sendKeys(TestDataHome.getValidAlphaPassword());
			WebDriverUtil.findElementByID("req.param.newpassword2.val", driver).sendKeys(TestDataHome.getValidAlphaPassword());
			WebDriverUtil.findElementByID("update", driver).click();
			WebDriverUtil.waitForJavaScript(driver);
			checkIfPresent = WindowHelper.isTextPresentOnPage("Your security info has been updated", driver);
		} 
		else if (passwordType.equals("differentrepeatpassword"))
		{
			typePassword(TestDataHome.getValidAlphaPassword(), TestDataHome.getDifferentrepeatPassword());
			String text = WebDriverUtil.getAlertContents(driver);
			checkIfPresent = text.contains("'Repeat New Password' does not match 'New Password'");
		} 
		
		else if (passwordType.equals("invalidrepeatpassword"))
		{
			typePassword(TestDataHome.getInvalidrepeatPassword(), TestDataHome.getInvalidrepeatPassword());
			String text = WebDriverUtil.getAlertContents(driver);
			checkIfPresent = text.contains("Password must be at least 8 characters long.");
		}

		else if (passwordType.equals("update"))
		{
			typePassword(TestDataHome.getValidAlphaPassword(), TestDataHome.getValidAlphaPassword());
			WebDriverUtil.waitForJavaScript(driver);
			checkIfPresent = WindowHelper.isTextPresentOnPage("Your security info has been updated", driver);
			driver.findElement(By.id("cancel")).submit();
			driver.get(System.getProperty("webdriver.pnc.url"));
		}

		else if (passwordType.equals("copypaste"))
		{
			TestUtil.infoLog(this.getClass(), "Finding textbox for New password");
			WebDriverUtil.findElementByID("req.param.newpassword1.val", driver).sendKeys(TestDataHome.getValidAlphaPassword());
			WebDriverUtil.select();
			WebDriverUtil.copy();
			WebDriverUtil.findElementByID("req.param.newpassword2.val", driver).click();
			WebDriverUtil.paste();
			WebDriverUtil.findElementByID("update", driver).click();
			String text = WebDriverUtil.getAlertContents(driver);
			WebDriverUtil.acceptAlert(driver);
			checkIfPresent = text.contains("'Repeat New Password' does not match 'New Password'");
			driver.get(System.getProperty("webdriver.pnc.url"));
		}
		sleep(4);
		return checkIfPresent;

	}

	private void typePassword(String password, String repeatPassword) throws WebDriverUtilException
	{
		WebDriverUtil.findElementByID("req.param.newpassword1.val", driver).sendKeys(password);
		WebDriverUtil.findElementByID("req.param.newpassword2.val", driver).sendKeys(repeatPassword);
		WebDriverUtil.findElementByID("update", driver).click();
	}

	/**
	 * This method sets the security password on View/Update security info page
	 * 
	 * @throws WebDriverUtilException
	 */
	public void setSecurityPassword() throws WebDriverUtilException
	{
		WebDriverUtil.findElementByXpath("//input[@name='req.param.answer1.val']", driver).sendKeys(TestDataHome.getSecurityAnswer());
		
	}

	/**
	 * This method helps to logout of the PNC portal
	 * 
	 * @return
	 * @throws WebDriverUtilException
	 */
	public String logout() throws WebDriverUtilException
	{
		WebDriverUtil.findElementByID("menuLogout", driver).click();
		TestUtil.infoLog(this.getClass(), "Checking for 'Forgot Pasword' link on login page to verify that logout has happened");
		String forgotpassword = WebDriverUtil.findElementByLinkText("Forgot password?", driver).getText();
		return forgotpassword;

	}

	/**
	 * This method finds an element on a webpage by its id and clicks it
	 * 
	 * @param id
	 * @throws WebDriverUtilException
	 */
	public void clickButtonByID(String id) throws WebDriverUtilException
	{
		WebDriverUtil.findElementByID(id, driver).click();

	}

	/**
	 * This method finds Subscribe link on web page
	 * 
	 * @return
	 */
	public boolean subscribe()
	{
		try
		{
			WebDriverUtil.findElementByLinkText("Subscribe", driver);
		} catch (WebDriverUtilException e)
		{
			return false;
		}
		return true;

	}

	/**
	 * Clicks the link Training Schedule
	 * 
	 * @return
	 */
	public String clickTrainingSchedule() throws Exception
	{
		clickLinkByXpath("//a[contains(text(),'Training Schedule')]");
		TestUtil.infoLog(this.getClass(), "Switching onto popup window openedby clicking link Training Schedule");
		switchToPopupWindow(driver);
		sleep(3);
		return popupHandleGetTitle(driver);
	}

	/**
	 * Gets the copyrite value from Web page
	 * 
	 * @return String
	 * @throws WebDriverUtilException
	 */
	public String getCopyrite() throws WebDriverUtilException
	{
		return getTextByXpath("/html/body/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[3]");
	}

	/**
	 * Method to check if username is present on the web page
	 * 
	 * @return boolean
	 * @throws WebDriverUtilException
	 */
	public boolean isUsernamePresent() throws WebDriverUtilException
	{
		String text = WebDriverUtil.findElementByXpath(
				"//table[@id = 'mbtab1']/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td[4]", driver).getText();
		boolean isusernamepresent = false;
		if (!text.isEmpty())
		{
			isusernamepresent = true;
		}
		return isusernamepresent;
	}

	/**
	 * This method checks if ***** is present corresponding to Name for link
	 * View/update Security Info
	 * 
	 * @return
	 * @throws WebDriverUtilException
	 */
	public boolean isNameTextPresent() throws WebDriverUtilException
	{
		String text = getTextByXpath("//tr[2]/td[2]");
		TestUtil.infoLog(this.getClass(), "Fetched text :" + text);
		return text.contains("********");

	}

	/**
	 * This method checks if text 'Login ID' is present on page for link
	 * View/update Security Info
	 * 
	 * @return
	 * @throws WebDriverUtilException
	 */
	public boolean isLoginPresent() throws WebDriverUtilException
	{
		TestUtil.infoLog(this.getClass(), "Checking if text 'Login ID' is present on page ");
		String text = getTextByXpath("//td/table/tbody/tr/td");
		TestUtil.infoLog(this.getClass(), "Fetched text from xpath:" + text);
		return text.contains("Login ID");
	}

	/**
	 * This Method clicks link NALC FAQ
	 * 
	 * @throws Exception
	 */
	public void clickNALCFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "clicking NALC FAQ ");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[9]");
		switchToPopupWindow(driver);

	}

	/**
	 * This Method clicks link NALC EFT
	 * 
	 * @throws Exception
	 */
	public String clickNALCEFT() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding and clicking NALC EFT ");
		clickLinkByXpath("(//a[contains(text(),'EFT Schedule')])[5]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		sleep(4);
		String pageTitle = popupHandleGetTitle(driver);
		return pageTitle;

	}

	/**
	 * This Method clicks link Oxford EFT
	 * 
	 * @throws Exception
	 */
	public String clickOxfordEFT() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding and clicking Oxford");
		sleep(2);
		//clickLinkByXpath("(//a[contains(text(),'EFT Schedule')])[6]");
		//*[@id='hometable']//table/tbody/tr[39]/td[2]/a
		clickLinkByXpath("//*[@id='hometable']//table/tbody/tr[39]/td[2]/a");
		sleep(2);
		switchToPopupWindow(driver);
		return popupHandleGetTitle(driver);

	}

	/**
	 * This Method clicks link Oxford FAQ
	 * 
	 * @throws Exception
	 */
	public String clickOxfordFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding and clicking Oxford");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[10]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);

	}

	/**
	 * This Method clicks link Mututal Ohama FAQ
	 * 
	 * @throws Exception
	 */
	public String clickMutualOhamaFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding MutualofOmahaEFT");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[8]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);

	}

	/**
	 * This Method clicks link Mutual Ohama EFT
	 * 
	 * @throws Exception
	 */
	public String clickMutualOhamaEFT() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Clicking MutualofOmahaEFT ");
		clickLinkByXpath("(//a[contains(text(),'EFT Schedule')])[4]");
		sleep(3);
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);

	}

	/**
	 * This Method clicks link FAQ of Mutual Health Services
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String clickMutualHealthServicesFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding  MutualHealth FAQ ");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[7]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);

	}

	/**
	 * This Method clicks link FAQ of MLB Players
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String clickMLBPlayersFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Clicking  MLBPlayersWelfarePlan FAQ ");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[6]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);

	}

	/**
	 * This Method clicks link FAQ of Medical Mutual
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clickMedicalMutualFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding  MedicalMutual FAQ");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[5]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);

	}

	/**
	 * This Method clicks link FAQ of Lincoln Financial
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clickLinconEftFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding  Lincoln FAQ by xpath://div[@id = 'pageContainer1']/div[2]/div[10] and clicking it");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[4]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);
	}

	/**
	 * This Method clicks link EFT of Lincoln Financial
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clickLinconEFT() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding and clicking link Lincoln EFT");
		sleep(2);
		clickLinkByXpath("(//a[contains(text(),'EFT Schedule')])[3]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		sleep(10);
		return popupHandleGetTitle(driver);
	}

	/**
	 * This Method clicks link FAQ of Emblem Health
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clickEmblemFAQ() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding and clicking Emblem-FAQ");
		clickLinkByXpath("(//a[contains(text(),'FAQ')])[3]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		return popupHandleGetTitle(driver);
	}

	/**
	 * This Method clicks link EFT of Emblem Health
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clickEmblemEFT() throws Exception
	{
		TestUtil.infoLog(this.getClass(), "Finding and clicking Emblem-EFT ");
		clickLinkByXpath("(//a[contains(text(),'EFT Schedule')])[2]");
		switchToPopupWindow(driver);
		TestUtil.infoLog(this.getClass(), "Switching onto popup window ");
		sleep(10);
		return popupHandleGetTitle(driver);
	}

	/**
	 * This Method clicks cancel button of link View/Update security info on
	 * Home page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clickCancel() throws WebDriverUtilException
	{
		//clickButtonByID("cancel");
		WebDriverUtil.findElementByXpath("//*[@id='cancel']", driver).click();
		sleep(2);
		return getTextByXpath("//*[@id='damenu']/tbody/tr[3]/td/div/span");
	}

	/**
	 * This method checks if for link View/Update security info on Home page the
	 * login value is getting displayed in asterisks
	 * 
	 * @return
	 * @throws WebDriverUtilException
	 */
	public boolean isLoginInAstericks() throws WebDriverUtilException
	{
		String text = getTextByClassName("datum");
		TestUtil.infoLog(this.getClass(), "Fetched text :" + text);
		return text.contains("********");

	}
	
	public void sleep(int timeDelay)
	{
		Sleeper.sleepTightInSeconds(timeDelay * delayMultiplier.intValue());
	}

}
