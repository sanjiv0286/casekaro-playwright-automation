package com.casekaro.hooks;

import com.casekaro.context.TestContext;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class PlaywrightHooks {

    private final TestContext ctx;

    public PlaywrightHooks(TestContext ctx) {
        this.ctx = ctx;
    }

    @Before
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        ctx.playwright = Playwright.create();
        ctx.browser = ctx.playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setTimeout(30000)
        );

        ctx.browserContext = ctx.browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1440, 900)
        );

        ctx.page = ctx.browserContext.newPage();
        ctx.page.setDefaultTimeout(30000);
        ctx.page.setDefaultNavigationTimeout(45000);
    }

    @After
    public void tearDown() {
        if (ctx.browserContext != null) ctx.browserContext.close();
        if (ctx.browser != null) ctx.browser.close();
        if (ctx.playwright != null) ctx.playwright.close();
    }
}
