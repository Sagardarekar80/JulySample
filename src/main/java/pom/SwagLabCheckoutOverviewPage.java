package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutOverviewPage {

	@FindBy(xpath = "//div[@class='inventory_item_price']") private List<WebElement> productPrice;
	@FindBy(xpath = "//div[@class='summary_subtotal_label']") private List<WebElement> total;
	@FindBy(xpath = "//a[@class='btn_action cart_button']") private WebElement finish;
	@FindBy (xpath = "//h2[@class='complete-header']") private WebElement thankYouSuccessMessage;
	
	
	public SwagLabCheckoutOverviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public double[] getAllProductPrice() 
	{
		double [] price =  new double[productPrice.size()];
		for(int i=0;i<productPrice.size();i++)
		{
			String amount = productPrice.get(i).getText().substring(1);
			price[i] = Double.parseDouble(amount);
		}
		
		return price;
	}
	
	public void clickOnFinish()
	{
		finish.click();
	}
	
	public String getThankYouMessage()
	{
		return thankYouSuccessMessage.getText();
	}	
}
