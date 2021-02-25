package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	
	private JavascriptExecutor js;
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
	/**
	 * Scrolls browser to the bottom of the current page.
	 */
	public void scrollToBottomOfPage() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	/**
	 * Scrolls browser to the top of the current page.
	 */
	public void scrollToTopOfPage() {
		js.executeScript("window.scrollTo(0,0)");
	}
	
	/**
	 * Scrolls the browser to the specified x,y coordinates of the current page.
	 * @param x pixel to scroll to.
	 * @param y pixel to scroll to.
	 */
	public void scrollToXY(int x, int y) {
		js.executeScript(String.format("window.scrollTo(%s,%s)",x,y));
	}
	
	
	/**
	 * Checks text() results of each element on the page, if if the text exists anywhere on the page, returns true.
	 * @param textToSearch
	 * @return true if found
	 */
	public boolean isPartialTextOnPage(String textToSearch) {
		try {
			driver.findElement(By.xpath(String.format(".//*[contains(text(),'%s')]",textToSearch)));
			return true;
		} catch (NoSuchElementException nsee) {
			return false;
		}
	}
	/**
	 * Checks text() results of each element on the page, if an exact match is found, returns true.
	 * @param textToSearch 
	 * @return true if found
	 */
	public boolean isExactTextOnPage(String textToSearch) {
		try {
			driver.findElement(By.xpath(String.format(".//*[text() ='%s']",textToSearch)));
			return true;
		} catch (NoSuchElementException nsee) {
			return false;
		}
	}
	/**
	 * Call to explicitly wait until the current page has fully loaded.
	 */
	public void waitUntilLoaded() {
		new WebDriverWait(driver,5).until(driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete"));
	}
	
	/**
	 * Returns the URL of the active page.
	 * @return
	 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
}
