package utilities;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public String landingPageProductName;
	//public int productQuantity;
	
	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
}
