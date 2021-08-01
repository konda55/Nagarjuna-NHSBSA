package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NHSBSAPage {
	
	@FindBy(xpath = "//button[@id='nhsuk-cookie-banner__link_accept']")
	public WebElement disableCookieBtn;

	@FindBy(xpath = "//input[@id='next-button']")
	public WebElement nextButton;
	
	@FindBy(xpath = "//label[@id='label-england']")
	public WebElement country;
	
	@FindBy(xpath = "//label[@id='label-no']")
	public WebElement noRadioBtn;
	
	@FindBy(xpath = "//input[@id='dob-day']")
	public WebElement dobDayText;
	
	@FindBy(xpath = "//input[@id='dob-month']")
	public WebElement dobMonText;
	
	@FindBy(xpath = "//input[@id='dob-year']")
	public WebElement dobYrText;
	
	@FindBy(xpath = "//span[contains(text(),'help')]")
	public WebElement finalpghlpText;
	
	public NHSBSAPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
