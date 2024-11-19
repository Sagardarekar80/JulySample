package pom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCartPage {

	@FindBy (xpath = "//div[@class='cart_item']") private List<WebElement> cartItem;
	@FindBy (xpath = "//div[@class='inventory_item_name']") private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_price']") private List<WebElement> productPrice;;
	@FindBy (xpath = "//button[@class='btn_secondary cart_button']") private List<WebElement> remove;
	@FindBy (xpath = "//a[@class='btn_action checkout_button']") private WebElement checkout;
	
	public SwagLabCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public int getCartItem()
	{
		 
		return cartItem.size();
	
	}
	public String getProductName(int index)
	{
		return productName.get(index).getText();
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
		
	public void clickOnRemoveButton(int index)
	{
		 remove.get(index).click();
	}
	
	public boolean isProductDisplayed(int index){			
		boolean result =  remove.get(index).isDisplayed();
		return result;	
	}
	
	public void clickOnCheckoutButton()
	{
		checkout.click();
	}	
}
