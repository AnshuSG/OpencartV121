package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("*****Starting  TC002_LoginTest ****** ");
		logger.debug("capturing application debug logs....");
		try
		{
		//Homepage
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.clickLogin();
		logger.info("clicked on login link under myaccount..");
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on ligin button..");
		
		
		//MyAccountpage
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		//Assert.assertEquals(targetpage, true,"Login Failed");
		Assert.assertTrue(targetpage);
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****Finished TC002_LoginTest *****");
		
		
		
		
		
		
		
	}
	
	
}
