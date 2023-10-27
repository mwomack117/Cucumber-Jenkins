package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePageObject;

public class OffersPage extends BasePageObject {
	
	public OffersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search-field")
	private WebElement inputProductSearch;
	
	@FindBy(xpath="//tr/td[1]")
	private WebElement productResultName;
	
	public void searchProductByName(String productName) {
		inputProductSearch.sendKeys(productName);
	}
	
	public String getProductResultName() {
		return productResultName.getText();
	}
	
}
