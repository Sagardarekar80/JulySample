package test;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)

public class SwagLabHomePageTest extends BaseTest {
	
	@BeforeMethod
	public void launchApplication()
	{
		driver = Browser.OpenBrowser();
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	}
	
	
	@Test   //6 (1 of 4)
	public void VerifySortFeatureForAtoZ()
	{
		test = reports.createTest("VerifySortFeatureForAtoZ");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.sortProduct("Name (Z to A)");
		String [] names = swagLabHomePage.getAllProductName();
		swagLabHomePage.sortProduct("Name (A to Z)");
		String [] sortednames = swagLabHomePage.getAllProductName();
		Assert.assertEquals(names[0],sortednames[5]);
		Assert.assertEquals(names[1],sortednames[4]);
		Assert.assertEquals(names[2],sortednames[3]);
		Assert.assertEquals(names[3],sortednames[2]);
		Assert.assertEquals(names[4],sortednames[1]);
		Assert.assertEquals(names[5],sortednames[0]);		
	}
	
	@Test   //6 (2 of 4)
	public void VerifySortFeatureForZtoA()
	{
		test = reports.createTest("VerifySortFeatureForZtoA");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);				
		String [] sortednames = swagLabHomePage.getAllProductName();		
		swagLabHomePage.sortProduct("Name (Z to A)");
		String [] names = swagLabHomePage.getAllProductName();		
		Assert.assertEquals(names[0],sortednames[5]);
		Assert.assertEquals(names[1],sortednames[4]);
		Assert.assertEquals(names[2],sortednames[3]);
		Assert.assertEquals(names[3],sortednames[2]);
		Assert.assertEquals(names[4],sortednames[1]);
		Assert.assertEquals(names[5],sortednames[0]);		
	}
			
	@Test  //6 (3 of 4)
	public void VerifySortFeatureForPriceLowToHigh()
	{
		test = reports.createTest("VerifySortFeatureForPriceLowToHigh");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.sortProduct("Price (low to high)");
		double [] price = swagLabHomePage.getAllProductPrice();
		Assert.assertTrue((price[0]<=price[1] && price[1]<=price[2] && price[2]<=price[3] && price[3]<=price[4] && price[4]<=price[5]));
	}
	
	@Test //6 (4 of 4)
	public void VerifySortFeatureForPriceHighToLow()
	{
		test = reports.createTest("VerifySortFeatureForPriceHighToLow");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.sortProduct("Price (high to low)");
		double [] price = swagLabHomePage.getAllProductPrice();
		Assert.assertTrue((price[0]>=price[1] && price[1]>=price[2] && price[2]>=price[3] && price[3]>=price[4] && price[4]>=price[5]));
	}
	
	
	@Test    //1
	public void VerifyOnClickingAddToCartButtonTheRemoveButtonIsDislayedInteadOfAddToCart() throws InterruptedException
	{
		test = reports.createTest("VerifyOnClickingAddToCartButtonTheRemoveButtonIsDislayedInteadOfAddToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);		
		swagLabHomePage.clickOnAddTOCart(0);						
		Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));
				
		swagLabHomePage.clickOnAddTOCart(0);		
		Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));
		
		swagLabHomePage.clickOnAddTOCart(0);
		Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));
		
		swagLabHomePage.clickOnAddTOCart(0);
		Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));
		
		swagLabHomePage.clickOnAddTOCart(0);
		Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));
	
		swagLabHomePage.clickOnAddTOCart(0);
		Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));				 
	}
			
	@Test  //4
	public void VerifyOnClickAboutUserIsRedirectedToSwaglabExternalPage() throws InterruptedException
	{
		test = reports.createTest("VerifyOnClickAboutUserIsRedirectedToSwaglabExternalPage");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnOpenMenu();
		Thread.sleep(2000);
		swagLabHomePage.clickOnAbout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
	}
	
	@Test  // 5
	public void VerifyOnClickingLogoutUserIsSuccessfullyLoggedOutFromApplication() throws InterruptedException
	{
		test = reports.createTest("VerifyOnClickingLogoutUserIsSuccessfullyLoggedOutFromApplication");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnOpenMenu();
		Thread.sleep(2000);
		swagLabHomePage.clickOnLogout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
	}
	
	@Test   //3
	public void VeriftOnClickingOnMenuAllTheMenuOptionsAreDisplayed()
	{
		test = reports.createTest("VeriftOnClickingOnMenuAllTheMenuOptionsAreDisplayed");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnOpenMenu();
		String [] items = swagLabHomePage.getAllMenuItem();
		Assert.assertEquals(items [0], "All Items");
		Assert.assertEquals(items [1], "About");
		Assert.assertEquals(items [2], "Logout");
		Assert.assertEquals(items [3], "Reset App State");				
	}
		
	@Test  //2
	public void VerifyOnClickingRemoveProductTheButtonIsAgainChangedToAddToCart() throws InterruptedException
	{
		
		test = reports.createTest("VerifyOnClickingRemoveProductTheButtonIsAgainChangedToAddToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);			
		swagLabHomePage.clickOnAddTOCart(0);	
		Thread.sleep(2000);	
		swagLabHomePage.clickOnRemoveButton(0);
		Assert.assertTrue(swagLabHomePage.isAddToCartButtonDisplayed(0));
								
		swagLabHomePage.clickOnAddTOCart(1);	
		Thread.sleep(2000);	
		swagLabHomePage.clickOnRemoveButton(0);
		Assert.assertTrue(swagLabHomePage.isAddToCartButtonDisplayed(1));
					
		swagLabHomePage.clickOnAddTOCart(2);
		Thread.sleep(2000);	
		swagLabHomePage.clickOnRemoveButton(0);
		Assert.assertTrue(swagLabHomePage.isAddToCartButtonDisplayed(2));		
				
		swagLabHomePage.clickOnAddTOCart(3);	
		Thread.sleep(2000);	
		swagLabHomePage.clickOnRemoveButton(0);
		Assert.assertTrue(swagLabHomePage.isAddToCartButtonDisplayed(3));
		
				
		swagLabHomePage.clickOnAddTOCart(4);
		Thread.sleep(2000);	
		swagLabHomePage.clickOnRemoveButton(0);
		Assert.assertTrue(swagLabHomePage.isAddToCartButtonDisplayed(4));
	
				
		swagLabHomePage.clickOnAddTOCart(5);	
		Thread.sleep(2000);	
		swagLabHomePage.clickOnRemoveButton(0);
		Assert.assertTrue(swagLabHomePage.isAddToCartButtonDisplayed(5));
			
	}		
	
	@Test
	public void VerifyOnClickingAllItemsMenuBarIsClosingAndAllProductsAreDisplayed() throws InterruptedException
	{
		test = reports.createTest("VerifyOnClickingAllItemsMenuBarIsClosingAndAllProductsAreDisplayed");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnOpenMenu();
		Thread.sleep(2000);
		swagLabHomePage.clickOnAllItems();
		try {
			 Assert.assertFalse(swagLabHomePage.isMenuBarDisplayed());
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Menu bar closed");
			
		}
		
		Assert.assertEquals(swagLabHomePage.getProductName(0),"Sauce Labs Backpack");
		Assert.assertEquals(swagLabHomePage.getProductName(1),"Sauce Labs Bike Light");
		Assert.assertEquals(swagLabHomePage.getProductName(2),"Sauce Labs Bolt T-Shirt");
		Assert.assertEquals(swagLabHomePage.getProductName(3),"Sauce Labs Fleece Jacket");
		Assert.assertEquals(swagLabHomePage.getProductName(4),"Sauce Labs Onesie");
		Assert.assertEquals(swagLabHomePage.getProductName(5),"Test.allTheThings() T-Shirt (Red)");				
	}		
	
	
	@Test
	public void clickOnResetAppState()
	{
		test = reports.createTest("clickOnResetAppState");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnOpenMenu();
						
		try {
			
			swagLabHomePage.clickOnResetAppState(); 
		} 
		catch (ElementNotInteractableException e) 
		{
		  System.out.println("Reset App State is not clickable");
		}		 
	}
		
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
}
