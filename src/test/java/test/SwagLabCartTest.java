package test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

@Listeners(test.Listeners.class)

public class SwagLabCartTest extends BaseTest{
	
	@BeforeMethod
	public void LaunchApplication()
	{
		driver = Browser.OpenBrowser();			
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver); 
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		
	}			
	@Test
	public void verifyIfUserAbleToAddProductToCart() throws InterruptedException
	{
		test = reports.createTest("verifyIfUserAbleToAddProductToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
				
		swagLabHomePage.clickOnAddTOCart(0);
		String ProductName1 = swagLabHomePage.getProductName(0);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(swagLabCartPage.getCartItem(), 1);
		Assert.assertEquals(swagLabCartPage.getProductName(0),ProductName1);
				
		driver.navigate().back();
		swagLabHomePage.clickOnAddTOCart(0);
		String ProductName2 = swagLabHomePage.getProductName(1);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(swagLabCartPage.getCartItem(), 2);
		Assert.assertEquals(swagLabCartPage.getProductName(1),ProductName2);
		
		driver.navigate().back();
		swagLabHomePage.clickOnAddTOCart(0);
		String ProductName3 = swagLabHomePage.getProductName(2);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(swagLabCartPage.getCartItem(), 3);
		Assert.assertEquals(swagLabCartPage.getProductName(2),ProductName3);
				
		driver.navigate().back();
		swagLabHomePage.clickOnAddTOCart(0);
		String ProductName4 = swagLabHomePage.getProductName(3);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(swagLabCartPage.getCartItem(), 4);
		Assert.assertEquals(swagLabCartPage.getProductName(3),ProductName4);
		
		driver.navigate().back();
		swagLabHomePage.clickOnAddTOCart(0);
		String ProductName5 = swagLabHomePage.getProductName(4);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(swagLabCartPage.getCartItem(), 5);
		Assert.assertEquals(swagLabCartPage.getProductName(4),ProductName5);
		
		driver.navigate().back();
		swagLabHomePage.clickOnAddTOCart(0);
		String ProductName6 = swagLabHomePage.getProductName(5);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(swagLabCartPage.getCartItem(), 6);
		Assert.assertEquals(swagLabCartPage.getProductName(5),ProductName6);		
			
	}			
	@Test //1
	public void VerifyOnClickingCartIconCartIsDisplyed() 
	{
		test = reports.createTest("VerifyOnClickingCartIconCartIsDisplyed");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/cart.html");		
	}	
	@Test  //2
	public void VerfiyIfUserIsAbleToAddSingleProductToCart() throws InterruptedException
	{
		test = reports.createTest("VerfiyIfUserIsAbleToAddSingleProductToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		String HomeProductName =  swagLabHomePage.getProductName(0);
		swagLabHomePage.clickOnAddTOCart(0);		
		swagLabHomePage.clickOnCart();
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);		
		String cartProductname = swagLabCartPage.getProductName(0);			
		Assert.assertEquals(HomeProductName,cartProductname);		
	}
	
	@Test   // 3
	public void VerifyIsIfUserIsAbleToAddMultipleProductToCart() throws InterruptedException
	{
		test = reports.createTest("VerifyIsIfUserIsAbleToAddMultipleProductToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		
		String HProduct1 = swagLabHomePage.getProductName(0);
		String HProduct2 = swagLabHomePage.getProductName(0);
		String HProduct3 = swagLabHomePage.getProductName(0);
		String HProduct4 = swagLabHomePage.getProductName(0);
		String HProduct5 = swagLabHomePage.getProductName(0);
		String HProduct6 = swagLabHomePage.getProductName(0);
		
		swagLabHomePage.clickOnCart();
		
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		String CPtoduct1 = swagLabCartPage.getProductName(0);
		String CPtoduct2 = swagLabCartPage.getProductName(0);
		String CPtoduct3 = swagLabCartPage.getProductName(0);
		String CPtoduct4 = swagLabCartPage.getProductName(0);
		String CPtoduct5 = swagLabCartPage.getProductName(0);
		String CPtoduct6 = swagLabCartPage.getProductName(0);
		
		Assert.assertEquals(HProduct1, CPtoduct1);
		Assert.assertEquals(HProduct2, CPtoduct2);
		Assert.assertEquals(HProduct3, CPtoduct3);
		Assert.assertEquals(HProduct4, CPtoduct4);
		Assert.assertEquals(HProduct5, CPtoduct5);
		Assert.assertEquals(HProduct6, CPtoduct6);		
	}	
	@Test  //4
	public void VerifyIfUserIsAbleToRemoveProductFromCart() throws InterruptedException 
	{
		test = reports.createTest("VerifyIfUserIsAbleToRemoveProductFromCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnAddTOCart(0);
		swagLabHomePage.clickOnCart();
		
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		swagLabCartPage.clickOnRemoveButton(0);
		
		Assert.assertEquals(swagLabCartPage.getCartItem(),5);		
		swagLabCartPage.clickOnRemoveButton(0);
		Assert.assertEquals(swagLabCartPage.getCartItem(),4);
		swagLabCartPage.clickOnRemoveButton(0);
		Assert.assertEquals(swagLabCartPage.getCartItem(),3);
		swagLabCartPage.clickOnRemoveButton(0);
		Assert.assertEquals(swagLabCartPage.getCartItem(),2);
		swagLabCartPage.clickOnRemoveButton(0);
		Assert.assertEquals(swagLabCartPage.getCartItem(),1);
		swagLabCartPage.clickOnRemoveButton(0);
		Assert.assertEquals(swagLabCartPage.getCartItem(),0);		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}			
}
