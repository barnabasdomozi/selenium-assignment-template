package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait; 
    public final By bodyLocator = By.tagName("body");

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public static void sleepWait(int secs) {
    	try {
	    Thread.sleep(secs * 1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public WebElement waitVisibilityAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void clickCookieAccept()
    {
	this.waitVisibilityAndFindElement(By.xpath("//button[@id='accept-btn']")).click();
    }

    public void clickIgnoreButton()
    {
	this.waitVisibilityAndFindElement(By.xpath("//button[@id='onesignal-slidedown-cancel-button']")).click();
    }
}
