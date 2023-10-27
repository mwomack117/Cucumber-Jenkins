package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePageObject;

public class CartPage extends BasePageObject{

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="product-name")
	private WebElement productName;
	
	@FindBy(className="quantity")
	private WebElement quantity;
	
	@FindBy(className="promoBtn")
	private WebElement btnApplyDiscount;
	
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	private WebElement btnPlaceOrder;
	
	public boolean isPromoBtnDisplayed() {
		System.out.println("product name: " + productName.getText() + " quantity: " + quantity.getText());
		return btnApplyDiscount.isDisplayed();
	}
	
	public boolean isPlaceOrderBtnDisplayed() {
		return btnPlaceOrder.isDisplayed();
	}
	
	public String getCartPoductName() {
		System.out.println(productName.getText());
		return productName.getText().split("-")[0].trim();
	}
	
	public int getCartProductCount() {
		return Integer.parseInt(quantity.getText().split(" ")[0].trim());
	}

}
