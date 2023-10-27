package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utilities.TestContext;

public class LandingPageSteps {
	TestContext context;
	LandingPage landingPage;

	public LandingPageSteps(TestContext context) {
		this.context = context;
		landingPage = context.getPageObjectManager().getLandingPage();
	}

	@Given("user is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		landingPage.goToLandingPage();
		Assert.assertTrue(landingPage.getPageTitle().contains("GreenKart"));
	}
	
	@When("user searches for {string}")
	public void user_searches_for(String string) throws InterruptedException {
	    landingPage.searchProductByName(string);
	    Thread.sleep(2000);
	    context.landingPageProductName = landingPage.getResultProductName();
	}
	
	@When("user add {int} items to cart")
	public void user_add_items_to_cart(Integer count) {
	    landingPage.increaseItem(count);
	    System.out.println(count);
	    landingPage.addItemToCart();
	}

	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		landingPage.searchProductByName(shortName);
		Thread.sleep(2000);
		context.landingPageProductName = landingPage.getResultProductName();
		System.out.println(context.landingPageProductName);
	}
	
	@When("user goes to cart page")
	public void user_goes_to_cart_page() {
	    landingPage.goToCartPage();
	}

	@When("user navigates to offers page")
	public void user_navigates_to_offers_page() {
		landingPage.clickOffersPageLink();
		//landingPage.switchToChildWindow("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		landingPage.switchToChildWindow("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}
	
}
