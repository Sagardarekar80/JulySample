package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabCheckoutOverviewPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import utility.Parameterization;
import pom.SwagLabCheckoutStepOnePage;

@Listeners(test.Listeners.class)
public class SwagLabOrderProductTest extends BaseTest{

	@BeforeMethod		
	public void LaunchApplication() {
		
		driver = Browser.OpenBrowser();
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();		
	}
	
	@Test
	public void verifyIfUserOrderProductSuccessfully() throws InterruptedException, EncryptedDocumentException, IOException{	
		test = reports.createTest("verifyIfUserOrderProductSuccessfully");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);				
		swagLabHomePage.clickOnAddTOCart(0); // Product one
		swagLabHomePage.clickOnAddTOCart(0); // Product two
		
		swagLabHomePage.clickOnCart();
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		String Product1Price = swagLabCartPage.getProductPrice(0);
		double value1 = Double.parseDouble(Product1Price);
		String Product2Price = swagLabCartPage.getProductPrice(1);
		double value2 = Double.parseDouble(Product2Price);
				
		Assert.assertEquals(swagLabHomePage.getProductName(0), swagLabCartPage.getProductName(0));	
		Assert.assertEquals(swagLabHomePage.getProductPrice(0), Product1Price);
		Assert.assertEquals(swagLabHomePage.getProductName(1), swagLabCartPage.getProductName(1));
		Assert.assertEquals(swagLabHomePage.getProductPrice(1), Product2Price);
		swagLabCartPage.clickOnCheckoutButton();
		SwagLabCheckoutStepOnePage swaglabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		swaglabCheckoutStepOnePage.enterFirstName(Parameterization.getStringData("Sheet3", 0, 0));		
		swaglabCheckoutStepOnePage.enterLastName(Parameterization.getStringData("Sheet3", 1, 0));
		swaglabCheckoutStepOnePage.enterPostalCode(Parameterization.getStringData("Sheet3", 2, 0));
		swaglabCheckoutStepOnePage.clickOnContinueButton();	
				
		SwagLabCheckoutOverviewPage swagLabCheckoutOverviewPage = new SwagLabCheckoutOverviewPage(driver);
		double [] price = swagLabCheckoutOverviewPage.getAllProductPrice();
		double CPValue1 = price[0];
		double CPValue2 = price[1];		
		double TotalCheckOutPrice = CPValue1 + CPValue2;
		double TotalPrice = value1 + value2;
		
		Assert.assertEquals(TotalPrice, TotalCheckOutPrice);
		swagLabCheckoutOverviewPage.clickOnFinish();		
		Assert.assertEquals(swagLabCheckoutOverviewPage.getThankYouMessage(), "THANK YOU FOR YOUR ORDER");						
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
	
}
