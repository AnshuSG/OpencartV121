package testCases;

//import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/
public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class,groups = "Datadriven")
	public void verify_LoginDDT(String email,String pwd,String exp) 
	{
		logger.info("Starting loginDDT");
		try
		{
		//Homepage
				HomePage hp= new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				
				//LoginPage
				LoginPage lp=new LoginPage(driver);
				
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				
				
				//MyAccountpage
				MyAccountPage macc= new MyAccountPage(driver);
				boolean targetpage = macc.isMyAccountPageExists();
	


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/
				
				
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetpage == true)
					{
						Assert.assertTrue(true);
						macc.clickLogout();
					}
					else
					{
					  Assert.assertTrue(false);	
					}
								
				}
				
				if(exp.equalsIgnoreCase("InValid"))
				{
					if(targetpage == true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
						
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
		
		}
		
		catch(Exception e)
		{
			Assert.fail("An Exception occured :"  + e.getMessage());
		}
		logger.info("Finished loginDDT");
	}
	
	
	
}
