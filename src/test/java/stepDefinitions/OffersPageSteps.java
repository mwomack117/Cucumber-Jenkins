package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OffersPage;
import utilities.TestContext;

public class OffersPageSteps {
	OffersPage offersPage;
	TestContext context;
	
	public OffersPageSteps(TestContext context) {
		this.context = context;
		offersPage = context.getPageObjectManager().getOffersPage();
	}
	
	@When("^user searched for same (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_and_product_exists(String productName) {
		offersPage.searchProductByName(productName);
	}
	
	@Then("validate product result name matches with landing page result name")
	public void validate_product_result_name_matches_with_landing_page_result_name() throws InterruptedException {
		Thread.sleep(2000);
		String offersPageProductName = offersPage.getProductResultName();
	    Assert.assertEquals(offersPageProductName, context.landingPageProductName);
	}

}
