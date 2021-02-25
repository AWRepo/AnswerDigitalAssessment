package tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MenuPage;

public class BaseTest {
	
	static MenuPage menuPage;
	static WebDriver driver;
	
	public final static String CHROME_DRIVER_DIRECTORY = "drivers/chromedriver.exe";
	public final static String FIREFOX_DRIVER_DIRECTORY = "drivers/geckodriver.exe";
	/**
	 * Initialises the driver for each test to the default webpage.
	 * Default: http://the-internet.herokuapp.com
	 */
	protected static void initialise() {
		initialise("http://the-internet.herokuapp.com");
	}
	
	/**
	 * Initialises the driver to a specific webpage base on the given link
	 * @param webLink starting page
	 */
	protected static void initialise(String webLink) {
		System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_DIRECTORY);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		menuPage = new MenuPage(driver);
		driver.get(webLink);

		
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		driver.quit();
	}

}
