package com.casekaro.pages;

import com.casekaro.context.TestContext;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public static class CartItem {
        public final String material;
        public final String price;
        public final String link;

        public CartItem(String material, String price, String link) {
            this.material = material;
            this.price = price;
            this.link = link;
        }
    }

    public CartPage(TestContext ctx) {
        super(ctx);
    }

    public List<CartItem> readCartItems() {

        Locator rows = page.locator("tr.cart-item");
        rows.first().waitFor();

        Assertions.assertTrue(rows.count() > 0, "No cart items found in cart drawer.");

        List<CartItem> items = new ArrayList<>();

        for (int i = 0; i < rows.count(); i++) {
            Locator row = rows.nth(i);

            Locator productLink = row.locator("a.cart-item__name");
            String link = productLink.getAttribute("href");
            if (link != null && link.startsWith("/")) {
                link = "https://casekaro.com" + link;
            }

            Locator materialLocator =
                    row.locator("dt:text-is('Material:') + dd");

            String material = materialLocator.count() > 0
                    ? materialLocator.innerText().trim()
                    : "";

            Locator priceLocator =
                    row.locator(".cart-item__price-wrapper .price.price--end");

            String price = priceLocator.count() > 0
                    ? priceLocator.innerText().trim()
                    : "";

            items.add(new CartItem(material, price, link));
        }

        return items;
    }


    public void assertMaterialsPresent(List<CartItem> items) {

        Assertions.assertTrue(items.size() >= 3,
                "Expected at least 3 items in cart. Found: " + items.size());

        List<String> materials = items.stream()
                .map(item -> item.material.toLowerCase())
                .toList();

        Assertions.assertTrue(materials.contains("hard"),
                "Hard material not found in cart");
        Assertions.assertTrue(
                materials.stream().anyMatch(m -> m.contains("soft")),
                "Soft material not found in cart");
        Assertions.assertTrue(materials.contains("glass"),
                "Glass material not found in cart");
    }

}

