package com.casekaro.pages;

import com.casekaro.context.TestContext;
import org.junit.jupiter.api.Assertions;

public class HomePage extends BasePage {

    private static final String BASE_URL = "https://casekaro.com/";

    public HomePage(TestContext ctx) {
        super(ctx);
    }

    public void open() {
        page.navigate(BASE_URL);

        String title = page.title();
        Assertions.assertTrue(
                title.contains("Casekaro") || title.contains("Case Karo") || title.contains("Phone Back Cover"),
                "Homepage did not load successfully. Current title: " + title
        );
    }
}
