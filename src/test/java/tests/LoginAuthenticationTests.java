package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.LoginAuthenticationPage;

public class LoginAuthenticationTests extends BaseTest{

	private static LoginAuthenticationPage loginAuthenticationPage;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		initialise();
		menuPage.navigateToLoginAuthentication();
		loginAuthenticationPage = new LoginAuthenticationPage(driver);
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		driver.quit();
	}
	

	@Test
	public void Authentication_Failure_IncorrectPassword() {
		String username = "tomsmith";
		String password = "NotASuperSecretPassword!";
		String errorMessage = "Your password is invalid!";

		
		loginAuthenticationPage.loginWith(username, password);
		
                //Asserting whether an error prompt has appeared, and whether the error prompt has the correct message.
                
		assertEquals(loginAuthenticationPage.getFlashMessage(),errorMessage);
		assertEquals(loginAuthenticationPage.getFlashType(),"error");
		
	}
	
	@Test
	public void Authentication_Failure_IncorrectUsername() {
		String username = "johnsmith";
		String password = "SuperSecretPassword!";
		String errorMessage = "Your username is invalid!";
		
		loginAuthenticationPage.loginWith(username, password);

                //Asserting whether an error prompt has appeared, and whether the error prompt has the correct message.
                
		assertEquals(loginAuthenticationPage.getFlashMessage(),errorMessage);
		assertEquals(loginAuthenticationPage.getFlashType(),"error");
		
	}
	
	@Test
	public void Authentication_Success_CorrectUsernameAndPassword() throws InterruptedException {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		loginAuthenticationPage.loginWith(username, password);
		
		loginAuthenticationPage.logout();
	}

}
