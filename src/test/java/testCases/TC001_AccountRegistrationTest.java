package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
//import testBase.BaseClass2;
import testBase.BaseClass3;

public class TC001_AccountRegistrationTest extends BaseClass3 {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("*********  Starting TC001_AccountRegistrationTest ***************");
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on My Account link");
		
		
		hp.clickRegister();
		logger.info("clicked on Register link");
	   
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		
	

		logger.info("Providing customer details....");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating confirmation message....");
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");


		if (confmsg.equals("Your Account Has Been Created!"))
		
		{
		Assert.assertTrue(true);	
		}
		
		else
		{
			logger.error("Test Failed....");
			logger.debug("Debug Logs....");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		
		catch(Exception e)
		{
			logger.error("Exception occurred: " + e.getMessage());
		    Assert.fail("Test failed due to exception: " + e.getMessage());

		}
		
		logger.info("*******8Finished Account Regstration Test  **********");
	}
	
		
	
}
