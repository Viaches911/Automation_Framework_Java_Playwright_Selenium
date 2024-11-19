package config;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Page initBrowser(String browserType) {
        playwright = Playwright.create();

        switch (browserType.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
        }

        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
