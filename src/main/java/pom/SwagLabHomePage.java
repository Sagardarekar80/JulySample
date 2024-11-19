package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabHomePage {

	
	@FindBy (xpath = "//button[.='Open Menu']") private WebElement menu;
	@FindBy (xpath = "//a[@id='about_sidebar_link']") private WebElement about;
	@FindBy (xpath = "//a[@id='logout_sidebar_link']") private WebElement logout;
	@FindBy (xpath = "//a[@id='inventory_sidebar_link']") private WebElement AllItems;
	@FindBy (xpath = "//a[@id='reset_sidebar_link']") private WebElement ResetAppState;
	@FindBy (xpath = "//div[@class='inventory_item_name']") private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_price']") private List<WebElement> productPrice;
	@FindBy (xpath = "//button[@class='btn_primary btn_inventory']") private List<WebElement> addToCart;
	@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement sort;
	@FindBy (xpath = "//button[@class='btn_secondary btn_inventory']") private List<WebElement> remove;
	@FindBy (xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']") private WebElement cart;
	@FindBy (xpath = "//a[@class='bm-item menu-item']") private List<WebElement> menuItem;
	@FindBy (xpath = "//div[@style='position: fixed; right: inherit; z-index: 1100; width: 300px; height: 100%; transition: 0.5s;']") private WebElement menuBar;
	
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnOpenMenu()
	{
		menu.click();
	}
	
	public void clickOnAbout()
	{
		about.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
	
	public void clickOnAllItems()
	{
		AllItems.click();
		
	}
	
	public boolean isMenuBarDisplayed()
	{
		return menuBar.isDisplayed();
	}
	
	public void clickOnResetAppState()
	{
		ResetAppState.click();
	}
	
		
	public String getProductName(int index)
	{
		return productName.get(index).getText();
	}

	public String[] getAllProductName()
	{
		String [] names = new String [productName.size()]; 
		for(int i=0; i<productName.size();i++)
		{
			names [i] = productName.get(i).getText();
		}		
		return names;
	}
			
	
	
	public String getProductPrice(int index)
	{
		return productPrice.get(index).getText();
	}
	
	public double[] getAllProductPrice() 
	{
		double [] price =  new double[productName.size()];
		for(int i=0;i<productPrice.size();i++)
		{
			String amount = productPrice.get(i).getText().substring(1);
			price[i] = Double.parseDouble(amount);
		}
		
		return price;
	}
	
	
	public void clickOnAddTOCart(int index) throws InterruptedException
	{
		Thread.sleep(1000);
		addToCart.get(index).click();
		
	}
	
	public boolean isAddToCartButtonDisplayed(int index){			
		return  addToCart.get(index).isDisplayed();		
	}
	

	
	public void sortProduct(String text)//WebDriver driver
	{
		/*
		 * FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 * wait.withTimeout(Duration.ofMillis(30000));
		 * wait.pollingEvery(Duration.ofMillis(10000)); wait.ignoring(Exception.class);
		 * wait.until(ExpectedConditions.visibilityOf(sort));
		 */		
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOf(sort));
				
		Select select = new Select(sort);
		select.selectByVisibleText(text);	
	}
	
	public boolean isRemoveButtonDisplayed(int index){			
		boolean result =  remove.get(index).isDisplayed();
		return result;	
	}
					
	public void clickOnRemoveButton(int index)
	{
		remove.get(index).click();
	}
	
	public void clickOnCart()
	{
		cart.click();
	}
	
	public String getMenuItem(int index)
	{
		return menuItem.get(index).getText();
	}
	
	public String[] getAllMenuItem()
	{
		String [] items = new String [menuItem.size()]; 
		for(int i=0; i<menuItem.size();i++)
		{
			items [i] = menuItem.get(i).getText();
		}		
		return items;
	}		
}
