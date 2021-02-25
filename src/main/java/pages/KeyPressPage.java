package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage extends BasePage{

	By keyResult = By.id("result");
	By targetField = By.id("target");
	
	public KeyPressPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Retrieves the last key pressed according to the results field.
	 * @return last key pressed.
	 */
	public String getLastPressedKey() {
		try {
			String lastTypedKey = driver.findElement(keyResult).getText().split(":")[1];
			return lastTypedKey.stripLeading();
		}catch(IndexOutOfBoundsException ioobe) {
			//Certain keys fail to output a result causing an IndexOutOfBoundsException on the array.
			//In this case an empty string matches the result as displayed on the website.
			return "";
		}
		
		
	}
	/**
	 * Sends specified string to the target field.
	 * @param key
	 */
	public void sendKeyToTargetField(String key) {
		driver.findElement(targetField).sendKeys(key);
	}
	/**
	 * Sends specified selenium key to the target field.
	 * @param key
	 */
	public void sendKeyToTargetField(Keys key) {
		driver.findElement(targetField).sendKeys(key);
	}
	
	

}
