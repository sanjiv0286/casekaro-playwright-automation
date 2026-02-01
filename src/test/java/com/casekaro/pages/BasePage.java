package com.casekaro.pages;

import com.casekaro.context.TestContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public abstract class BasePage {
    protected final TestContext ctx;
    protected final Page page;

    protected BasePage(TestContext ctx) {
        this.ctx = ctx;
        this.page = ctx.page;
    }
}
