package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
	
public class PageObjectManager {
	
	private WebDriver driver;
	private LandingPage landingPage;
	private OffersPage offersPage;
	private CartPage cartPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		return (landingPage == null) ? new LandingPage(driver) : landingPage; 
	}
	
	public OffersPage getOffersPage() {
		return (offersPage == null) ? new OffersPage(driver) : offersPage;
	}

	public CartPage getCartPage() {
		return (cartPage == null) ? new CartPage(driver) : cartPage;
	}

}
