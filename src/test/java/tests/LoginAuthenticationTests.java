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
		
		//Two choices for asserting.
		//Test whether a flash message containing a specific error message appears
		//Problem with this method is any small changes to the error message breaks the test.
		//Test whether an error flash message appears.
		//Problem with this method is it doesn't specifically look for an incorrect password error.
		
		
		//assertEquals(loginAuthenticationPage.getFlashMessage(),errorMessage);
		assertEquals(loginAuthenticationPage.getFlashType(),"error");
		
	}
	
	@Test
	public void Authentication_Failure_IncorrectUsername() {
		String username = "johnsmith";
		String password = "SuperSecretPassword!";
		String errorMessage = "Your username is invalid!";
		
		//Two choices for asserting.
		//Test whether a flash message containing a specific error message appears
		//Problem with this method is any small changes to the error message breaks the test.
		//Test whether an error flash message appears.
		//Problem with this method is it doesn't specifically look for an incorrect username error.
		
		loginAuthenticationPage.loginWith(username, password);

		assertEquals(loginAuthenticationPage.getFlashMessage(),errorMessage);
		//assertEquals(loginAuthenticationPage.getFlashType(),"error");
		
	}
	
	@Test
	public void Authentication_Success_CorrectUsernameAndPassword() throws InterruptedException {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		
		loginAuthenticationPage.loginWith(username, password);
		
		//assertEquals(loginAuthenticationPage.getCurrentURL(),LoginAuthenticationPage.SUCCESS_URL);
		loginAuthenticationPage.logout();
		
		//assertEquals(loginAuthenticationPage.getCurrentURL(),LoginAuthenticationPage.LOGIN_URL);
		
		
	}

}
