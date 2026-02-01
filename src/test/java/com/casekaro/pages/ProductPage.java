package com.casekaro.pages;

import com.casekaro.context.TestContext;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;

public class ProductPage extends BasePage {

    public ProductPage(TestContext ctx) {
        super(ctx);
    }

    public void openFirstProductChooseOptions() {
        page.locator("button:has-text('Choose options')").first().click();
    }

    public void addMaterialToCart(String material) {
        Locator materialOption =
                page.locator("label:text-is('" + material + "')");

        materialOption.waitFor();
        materialOption.click();

        Locator addToCart =
                page.locator("button:has-text('Add to cart')").first();

        addToCart.waitFor();
        addToCart.click();

        Locator closeButton = page.locator(".drawer__close").first();
        closeButton.waitFor();
        closeButton.click();
    }

    public void openCart() {
        Locator cart = page.locator("a[href*='/cart']").first();
        Assertions.assertTrue(cart.count() > 0, "Cart link not found");
        cart.click();
    }
}
