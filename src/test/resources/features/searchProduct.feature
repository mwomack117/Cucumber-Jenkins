Feature: Search products and offers
	
	@offers
  Scenario Outline: Search experience for product search in both home and top deals page
    Given user is on GreenCart landing page
    When user searched with shortname <searchItem> and extracted actual name of product
    And user navigates to offers page
    And user searched for same <searchItem> shortname in offers page
    Then validate product result name matches with landing page result name

	Examples: 
	| searchItem |
	| tom |
	| bea |
	

