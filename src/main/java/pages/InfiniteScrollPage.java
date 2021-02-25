package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfiniteScrollPage extends BasePage {

	private long pageHeight;
	
	public InfiniteScrollPage(WebDriver driver) {
		super(driver);
		setPageHeight(0);
		
	}
	
	/**
	 * Used to initialise pageHeight to the document's current height.
	 */
	public void initialiseHeight() {
		setPageHeight((long)((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight"));
	}
	/**
	 * Used to set pageHeight to a specified height.
	 * Sets to a minimum value of 0.
	 * @param pageHeight the height of the InfiniteScroll webpage.
	 */
	private void setPageHeight(long pageHeight) {
		this.pageHeight = Math.max(pageHeight,0);
	}
	
	/**
	 * Expands on BasePage.scrollToBottomOfPage()
	 * Waits until the current pageHeight is greater than the previous pageHeight before calling BasePage.scrollToBottomOfPage();
	 */
	@Override
	public void scrollToBottomOfPage() {
		//An attempt to implement an explicit wait so that Thread.sleep doesn't have to be used.
		//However using with By.className(jscroll-added) and waiting until the number of elements increase,
		//as well as this page height method, both have problems in where values change before the base is fully loaded.
		//Given resolution and window size impact the defaults for both of these values, fine tuning preset values will result in flaky tests.
		new WebDriverWait(driver,5).until(driver -> 
			((long)((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight")) > pageHeight);
		initialiseHeight();
		super.scrollToBottomOfPage();
	}

}
