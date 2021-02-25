package tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import pages.KeyPressPage;

public class KeyPressTests extends BaseTest {
	
	private static KeyPressPage keyPressPage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
            initialise();
            menuPage.navigateTokeyPresses();
            keyPressPage = new KeyPressPage(driver);
	}

	@Test
	public void KeyPress_Returns_LastKeyPressed(){
            //Message field logs the most recent key pressed, rather than combination keys. % displays as 5.
            keyPressPage.sendKeyToTargetField("%");
            assertEquals(keyPressPage.getLastPressedKey(),"5");
		
            keyPressPage.sendKeyToTargetField(Keys.ALT);
            assertEquals(keyPressPage.getLastPressedKey(),"ALT");
            
            keyPressPage.sendKeyToTargetField(Keys.ARROW_UP);	
            assertEquals(keyPressPage.getLastPressedKey(),"UP");
            
            keyPressPage.sendKeyToTargetField(Keys.F3);
            assertEquals(keyPressPage.getLastPressedKey(),"F3");
		
	}

}
