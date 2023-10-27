package utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToChildWindow(String url) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			driver.switchTo().window(handle);
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.equals(url)) {
				break;
			}
		}
	}

}
