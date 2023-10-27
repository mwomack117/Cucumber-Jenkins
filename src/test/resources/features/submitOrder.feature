Feature: Place the order for products
	
	@end2End
 	Scenario Outline: Add item to cart and complete checkout
		Given user is on GreenCart landing page 
		When user searches for "<name>" 
		And user add 3 items to cart
		And user goes to cart page
		Then "<name>" is in the cart with quantity of <quantity>
		Then verifiy user has ability to enter promo code place order

	Examples: 
	|name   | quantity  |
	|banana |    3      |
	
