package managers;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import enums.DriverType;

public class WebDriverManager {
	private WebDriver driver;
	private DriverType driverType;
	private String driverPath;

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBroswer();
		driverPath = FileReaderManager.getInstance().getConfigReader().getDriverPath();
	}

	public WebDriver getDriver() {
		if (driver == null) {
			driver = launchDriver();
		}
		return driver;
	}

	public WebDriver launchDriver() {
		String path = System.getProperty("user.dir");
		switch (driverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", path + driverPath + "/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case EDGE: 
			System.setProperty("webdriver.edge.driver", path + driverPath + "/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		// add other browsers
		default:
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}

}
