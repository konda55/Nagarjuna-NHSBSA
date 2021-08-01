package stepdef;

import java.io.IOException;
import java.util.Properties;

import WebDriver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NHSBSAPage;

public class StepDefinitionFile {
	private DriverManager driverManager;
	private NHSBSAPage nhsbsaPage;
	private Properties prop;
	private static final int WAIT_TIME = 7;
		
	@Before
	public void init() {
		driverManager = new DriverManager();
		prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverManager.launchDriver(prop.getProperty("Browser"));
		nhsbsaPage = new NHSBSAPage(driverManager.getDriver());
	}
	
	@After
	public void tearDown() {
		if(driverManager.getDriver()!=null) {
			driverManager.getDriver().quit();
		}
	}
	
	@Given("^I am a citizen of the UK$")
	public void launchAPP() {
		driverManager.browseApp(prop.getProperty("AppURL"));
		driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.disableCookieBtn, WAIT_TIME));
		driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.nextButton, WAIT_TIME));
	}
	
	@When("^I put my circumstances into the Checker tool$")
	public void enterMyData() {
		driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.country, WAIT_TIME));
		driverManager.hardWait(1000);
		driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.nextButton, WAIT_TIME));
		driverManager.hardWait(1000);
		driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.noRadioBtn, WAIT_TIME));
		driverManager.hardWait(1000);
		driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.nextButton, WAIT_TIME));
		driverManager.hardWait(1000);
		driverManager.enterText(driverManager.waitUntilVisible(nhsbsaPage.dobDayText, WAIT_TIME), "01");
		driverManager.hardWait(1000);
		driverManager.enterText(driverManager.waitUntilVisible(nhsbsaPage.dobMonText, WAIT_TIME), "01");
		driverManager.hardWait(1000);
		driverManager.enterText(driverManager.waitUntilVisible(nhsbsaPage.dobYrText, WAIT_TIME), "1986");
		driverManager.hardWait(1000);
		driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.nextButton, WAIT_TIME));
		
		try {
			while(driverManager.waitUntilVisible(nhsbsaPage.noRadioBtn, WAIT_TIME).isDisplayed()) {
				driverManager.hardWait(1000);
				driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.noRadioBtn, WAIT_TIME));
				driverManager.clickOnElement(driverManager.waitUntilVisible(nhsbsaPage.nextButton, WAIT_TIME));
			}
		}
		catch(Exception e) {
			System.out.println("\n\n************** You have reached the results screen *******************\n\n");
		}
	}
	
	@Then("^I should get a result of whether I will get help or not$")
	public void results() {
		System.out.println("\n\n*******************************************************************\n\n\t"
				+ driverManager.getText(nhsbsaPage.finalpghlpText)
				+ "\n\n*******************************************************************\n\n");
	}
}
