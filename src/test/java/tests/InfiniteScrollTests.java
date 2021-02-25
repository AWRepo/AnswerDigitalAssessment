package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.InfiniteScrollPage;

public class InfiniteScrollTests extends BaseTest{

	private static InfiniteScrollPage infiniteScrollPage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initialise();
		menuPage.navigateToInfiniteScroll();
		infiniteScrollPage = new InfiniteScrollPage(driver);
		
	}
	
	
	@Test
	public void InfiniteScroll_Allows_DynamicScrolling() {
		String searchText = "Infinite Scroll";
		int waitTime = 1000;
		
		//Using Thread.sleep / fixed time waits isn't ideal as it's unstable across slower connections / browsers.
		//However attempts to implement a suitable explicit wait isn't working for all cases.
		//As varying resolutions / window sizes alter the default elements to work with.
		//So it's hard to ensure the page is fully loaded before / after each scroll attempt.
		//Probably is a solution without using sleep, however most info I can find resorts to Thread.sleep.
		infiniteScrollPage.initialiseHeight();
		
		try {
			Thread.sleep(waitTime);
			infiniteScrollPage.scrollToBottomOfPage();
			Thread.sleep(waitTime);
			infiniteScrollPage.scrollToBottomOfPage();
			Thread.sleep(waitTime);
			infiniteScrollPage.scrollToTopOfPage();
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		
		assertTrue(infiniteScrollPage.isExactTextOnPage(searchText));
	}

}
