package com.casekaro.pages;

import com.casekaro.context.TestContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class MobileCoversPage extends BasePage {

    private final String mobileCoversMenu = "a:has-text('Mobile Cases & Covers')";
    private final String coverSearchBox = "input#modelSearch";
    private final String brandTile = ".search-results";

    public MobileCoversPage(TestContext ctx) {
        super(ctx);
    }

    public void openFromHeaderMenu() {
        page.waitForSelector(mobileCoversMenu, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(10000));

        page.click(mobileCoversMenu);

        String url = page.url().toLowerCase();
        Assertions.assertTrue(url.contains("phone-cases"),
                "Mobile covers page not loaded. Current URL: " + url
        );
    }

    public void typeInCoverSearch(String value) {
        Locator search = page.locator(coverSearchBox);
        search.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        search.fill(value);
    }

    public void assertOtherBrandsNotVisible(List<String> otherBrands) {
        Locator brandCards = page.locator(brandTile);
        Assertions.assertTrue(brandCards.count() > 0, "Brand tiles are not visible after search.");

        String visibleText = brandCards.allInnerTexts().toString().toLowerCase();

        for (String brand : otherBrands) {
            Assertions.assertFalse(
                    visibleText.contains(brand.toLowerCase()),
                    "Other brand should not be visible after Apple search: " + brand
            );
        }
    }

    public void verifyBrandName(String brandName) {
        Locator brand = page.locator(brandTile + " a:has-text('" + brandName + "')").first();
        Assertions.assertTrue(brand.count() > 0, "Brand not found in results: " + brandName);
    }

    public void clickModelFromTiles(String modelText) {
        Locator model = page.locator(brandTile + " a:has-text('" + modelText + "')").first();
        model.click();
    }
}
