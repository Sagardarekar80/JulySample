package test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.SwagLabLoginPage;
import org.testng.annotations.Listeners;

@Listeners(test.Listeners.class)
public class SwagLabLoginTest extends BaseTest  {

	
	@BeforeMethod
	public void launchApplication()
	{
		driver = Browser.OpenBrowser();
	}
	
	@Test
	public void verifyIfUserAbleToLoginWithValidCreadentials()
	{
		test = reports.createTest("verifyIfUserAbleToLoginWithValidCreadentials");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver); 
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	}
	
	@Test
	
	public void verifyIfWarningMessageIsDisplyedForLockedUser()
	{
		test = reports.createTest("verifyIfWarningMessageIsDisplyedForLockedUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("locked_out_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		Assert.assertEquals(swagLabLoginPage.getWarningMessage(), "Epic sadface: Sorry, this user has been locked out.");		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}		
	
}	
