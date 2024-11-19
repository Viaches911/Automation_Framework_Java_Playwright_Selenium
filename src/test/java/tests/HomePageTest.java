package tests;

import config.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import com.microsoft.playwright.Page;

public class HomePageTest {
    private PlaywrightFactory playwrightFactory;
    private Page page;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initBrowser("chromium");
        homePage = new HomePage(page);
    }

    @Test
    public void verifyHomePageTitle() {
        homePage.navigateTo("https://www.example.com");
        String title = homePage.getHomePageTitle();
        System.out.println("Home Page Title: " + title);
        Assert.assertTrue(title.contains("Example Domain"));
    }

    @AfterClass
    public void tearDown() {
        playwrightFactory.tearDown();
    }
}
