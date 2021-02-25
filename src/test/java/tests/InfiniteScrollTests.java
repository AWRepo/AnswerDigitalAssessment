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
