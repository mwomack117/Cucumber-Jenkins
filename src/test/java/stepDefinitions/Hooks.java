package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.TestContext;

public class Hooks {
	TestContext context;
	WebDriver driver;
	
	public Hooks(TestContext context) {
		this.context = context;
		this.driver = context.getWebDriverManager().getDriver();
	}
	
	@After
	public void tearDown() {
		context.getWebDriverManager().quitDriver();
	}
	
	@AfterStep
	public void addScreenShotOnFailedStep(Scenario scenario) {
		if(scenario.isFailed()) {
			// take a screenshot
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
