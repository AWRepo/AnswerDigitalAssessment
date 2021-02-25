package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginAuthenticationPage extends BasePage {


	//Locators
	By flashMessage = By.className("flash");
	By errorMessage = By.className("error");
	By successMessage = By.className("success");
	By loginForm = By.id("login");
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By logoutButton = By.className("button");
	
	public final static String SUCCESS_URL = "http://the-internet.herokuapp.com/secure";
	public final static String LOGIN_URL = "http://the-internet.herokuapp.com/login";
	
	
	public LoginAuthenticationPage(WebDriver driver) {
            super(driver);
	}
	

	
	
	/**
	 * Sets the value of the username field on logic authentication page to specified username.
	 * @param username
	 */
	public void setUsername(String username) {
            driver.findElement(usernameField).clear();
            driver.findElement(usernameField).sendKeys(username);	
	}
	
	
	/**
	 * Sets the value of the password field on Logic Authentication page to specified password.
	 * @param password
	 */
	public void setPassword(String password) {
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(password);
	}
	/**
	 * Submits login.
	 */
	public void login() {
            driver.findElement(loginForm).submit();
	}
	/**
	 * Submits login using specified username and password inputs.
	 * @param username input for username field.
	 * @param password input for password field.
	 */
	public void loginWith(String username, String password) {
            setUsername(username);
            setPassword(password);
            login();
	}
	
	/**
	 * Triggers logout behaviours whilst logged in.
	 */
	public void logout() {
            driver.findElement(logoutButton).click();
	}
	
	/**
	 * Retrieves the current flash message, returns an empty string if no flash message exists.
	 * @return current displayed flash message, returns an empty string if there's no current flash message.
	 */
	public String getFlashMessage() {
            
            try {
                return driver.findElement(flashMessage).getText().split("\n")[0];
            }catch(NoSuchElementException nsee) {
                return "";
            }
	}
	/**
	 * Checks if the user has successfully logged in by looking for a successFlashMessage.
	 * @return true if a successFlashMessage is present on page.
	 */
	public boolean isSuccessfulLogin() {
		try {
                    driver.findElement(successMessage);
                    return true;
		}catch (NoSuchElementException nsee) {
                    return false;
		}
	}
	
	/**
	 * Returns the type of flash message. Returns "" if no type is specified.
	 * If no flash element is present returns null. 
	 * @return type of flash message.
	 */
	public String getFlashType() {
		try {
                    String[] flashClasses = driver.findElement(flashMessage).getAttribute("class").split(" ");
                    
                    for (String flashClass : flashClasses) {
                        if(!flashClass.equalsIgnoreCase("flash")) {
                            return flashClass;
			}
                    }
                    //Returns "" when no class other than the flash identifier is listed.
                    return "";
		}catch(NoSuchElementException nsee) {			
                    return null;
		}
		

	}
	
	
}
