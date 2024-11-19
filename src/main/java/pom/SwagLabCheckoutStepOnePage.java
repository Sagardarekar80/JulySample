package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutStepOnePage {


	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalcode;
	@FindBy(xpath = "//input[@type='submit']") private WebElement continueButton;
	@FindBy(xpath = "//div[@class='inventory_item_name']") private List<WebElement> productName;
	@FindBy(xpath = "//div[@class='inventory_item_price']") private List<WebElement> productPrice;
	
	
	public SwagLabCheckoutStepOnePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void  enterFirstName(String FName)
	{
		firstName.sendKeys(FName);		
	}
	
	public void enterLastName(String LName)
	{
		lastName.sendKeys(LName);
	}
	
	public void enterPostalCode(String PCode)
	{
		postalcode.sendKeys(PCode);
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
		
	


}
