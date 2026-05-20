package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

public class IndexPage extends BasePage {

    private final By profileBtnLocator = By.xpath("//div[@id='passportHeader']//a[@id='icon-user']");
    private final By loginBtnLocator = By.xpath("//a[@href='https://index.hu/ident/safelogin/']");
    private final By userFieldLocator = By.xpath("//div[@class='indalogin']//input[@name='username' and @type='email']");
    private final By passwordFieldLocator = By.xpath("//div[@class='indalogin']//input[@name='password' and @type='password']");
    private final By loginFieldBtnLocator = By.xpath("//div[@class='indalogin']//input[@type='submit']");
    private final By usernameLocator = By.xpath("//div[@id='user-dropdown']/ul/li[3]/a");
    private final By logoutLocator = By.xpath("//a[text()='Kilépés']");
    private final By userDropdownLocator = By.xpath("//div[@id='user-dropdown']");
    private final By podcastLocator = By.xpath("//a[@id='podcast']");
    private final By weatherLocator = By.xpath("//div[@class='header-parts']//a[@class='weather ']");

    public IndexPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver.get("https://index.hu");
    }

    public boolean isPageLoaded() {
	return waitVisibilityAndFindElement(this.bodyLocator).getText().contains("Index.hu");
    }
    
    public void login(String user, String password) {
	this.clickCookieAccept();
	waitVisibilityAndFindElement(this.profileBtnLocator).click();
	waitVisibilityAndFindElement(this.loginBtnLocator).click();
	this.clickCookieAccept();
	waitVisibilityAndFindElement(this.userFieldLocator).sendKeys(user);
	waitVisibilityAndFindElement(this.passwordFieldLocator).sendKeys(password);
	waitVisibilityAndFindElement(this.loginFieldBtnLocator).click();
    }

    public boolean isLoggedIn(String user) 
    {
	waitVisibilityAndFindElement(this.profileBtnLocator).click();
	return waitVisibilityAndFindElement(this.usernameLocator).getText().contains(user);
    }

    public void logout() {
    	waitVisibilityAndFindElement(this.logoutLocator).click();
    }

    public boolean isLoggedOut() {
	waitVisibilityAndFindElement(this.profileBtnLocator).click();
	return waitVisibilityAndFindElement(this.userDropdownLocator).getText().contains("BELÉPÉS");
    }

    public boolean checkHoveredPodcastLinkColor()
    {
	this.clickCookieAccept();
	WebElement element = waitVisibilityAndFindElement(this.podcastLocator);
	Actions actions = new Actions(driver);
	actions.moveToElement(element).perform();    
	System.out.println(element.getCssValue("color"));
	return element.getCssValue("color").equals("rgba(255, 102, 0, 1)");
    }

    public void navigateToWeatherPage()
    {
	this.clickCookieAccept();
    	waitVisibilityAndFindElement(this.weatherLocator).click();
    }
}
