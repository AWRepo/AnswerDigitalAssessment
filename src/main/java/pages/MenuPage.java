package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

	By loginAuthenticationLink = By.linkText("Form Authentication");
	By infiniteScrollLink = By.linkText("Infinite Scroll");
	By keyPressesLink = By.linkText("Key Presses");
	
	/**
	 * Used to navigate to the Login Authentication page from the main menu.
	 */
	public void navigateToLoginAuthentication() {
		driver.findElement(loginAuthenticationLink).click();
	}
	/**
	 * Used to navigate to the Infinite Scroll page from the main menu.
	 */
	public void navigateToInfiniteScroll() {
		driver.findElement(infiniteScrollLink).click();
	}
	
	/**
	 * Used to navigate to the Key Presses page from the main menu.
	 */
	public void navigateTokeyPresses() {
		driver.findElement(keyPressesLink).click();
	}
	
	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	

}
