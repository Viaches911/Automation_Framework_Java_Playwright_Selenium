package pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }

    public String getHomePageTitle() {
        return getPageTitle();
    }
}
