package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

// Base Page Object provides global elements and utility functions available for all pages
public class BasePageObject extends GenericUtils{

	WebDriver driver;
	
	public BasePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void goToLandingPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
//	public void switchToChildWindow(String url) {
//		Set<String> allWindowHandles = driver.getWindowHandles();
//		for (String handle : allWindowHandles) {
//			driver.switchTo().window(handle);
//			String currentUrl = driver.getCurrentUrl();
//			if (currentUrl.equals(url)) {
//				break;
//			}
//		}
//	}
	

}
