package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePageObject;

public class LandingPage extends BasePageObject {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@placeholder='Search for Vegetables and Fruits']")
	private WebElement inputProductSearch;

	@FindBy(className = "product-name")
	private WebElement productResultName;

	@FindBy(linkText = "Top Deals")
	private WebElement linkTopDeals;
	
	@FindBy(className="increment")
	private WebElement btnIncrementItem;
	
	@FindBy(xpath="//button[normalize-space()='ADD TO CART']")
	private WebElement btnAddToCart;
	
	@FindBy(xpath="//img[@alt='Cart']")
	private WebElement btnCart;
	
	@FindBy(xpath="//button[normalize-space()='PROCEED TO CHECKOUT']")
	private WebElement btnCheckout;
	
	public void viewCart() {
		btnCart.click();
	}
	
	public void goToCartPage() {
		viewCart();
		btnCheckout.click();
	}

	public void searchProductByName(String productName) {
		inputProductSearch.sendKeys(productName);
	}
	
	public void increaseItem(int count) {
		for (int i = 1; i < count; i++) {
			btnIncrementItem.click();
		}
	}
	
	public void addItemToCart() {
		btnAddToCart.click();
	}

	public String getResultProductName() {
		return productResultName.getText().split("-")[0].trim();
	}

	public void clickOffersPageLink() {
		linkTopDeals.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
