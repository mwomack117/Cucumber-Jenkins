package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CartPage;
import utilities.TestContext;

public class CartPageSteps {
	CartPage cartPage;
	TestContext context; 
	
	public CartPageSteps(TestContext context) {
		this.context = context;
		cartPage = context.getPageObjectManager().getCartPage();
	}
	
	@Then("verifiy user has ability to enter promo code place order")
	public void verifiy_user_has_ability_to_enter_promo_code_place_order() {
		Assert.assertTrue(cartPage.isPlaceOrderBtnDisplayed());
		Assert.assertTrue(cartPage.isPromoBtnDisplayed());
	}
	
	@Then("{string} is in the cart with quantity of {int}")
	public void is_in_the_cart_with_quatity_of(String productName, Integer count) {
	    Assert.assertEquals(cartPage.getCartPoductName(), context.landingPageProductName);
	    Assert.assertEquals(cartPage.getCartProductCount(), count);
	}

}
