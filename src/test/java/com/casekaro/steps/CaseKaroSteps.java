package com.casekaro.steps;

import com.casekaro.context.TestContext;
import com.casekaro.pages.*;
import com.casekaro.utils.CartConsolePrinter;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class CaseKaroSteps {

    private final TestContext ctx;
    private final HomePage homePage;
    private final MobileCoversPage mobileCoversPage;
    private final ProductPage productPage;
    private final CartPage cartPage;

    private List<CartPage.CartItem> cartItems;

    public CaseKaroSteps(TestContext ctx) {
        this.ctx = ctx;
        this.homePage = new HomePage(ctx);
        this.mobileCoversPage = new MobileCoversPage(ctx);
        this.productPage = new ProductPage(ctx);
        this.cartPage = new CartPage(ctx);
    }

    @Given("I open CaseKaro website")
    public void openCaseKaroWebsite() {
        homePage.open();
    }

    @When("I navigate to Mobile covers")
    public void navigateToMobileCovers() {
        mobileCoversPage.openFromHeaderMenu();
    }

    @When("I search for brand {string}")
    public void searchForBrand(String brand) {
        mobileCoversPage.typeInCoverSearch(brand);
    }

    @Then("I should not see other brands after iPhone search")
    public void validateOtherBrandsNotVisibleAfterAppleSearch() {
        mobileCoversPage.assertOtherBrandsNotVisible(
                List.of("Samsung", "OnePlus", "Vivo", "Oppo", "Realme", "Xiaomi", "Redmi", "Moto", "Pixel", "Nothing")
        );
    }

    @When("I search for model {string}")
    public void searchForModel(String model) {
        mobileCoversPage.typeInCoverSearch(model);
        mobileCoversPage.verifyBrandName(model);
    }

    @When("I select model from results {string}")
    public void selectModelFromResults(String modelText) throws InterruptedException {
        mobileCoversPage.clickModelFromTiles(modelText);
    }

    @When("I open first product using Choose options")
    public void openFirstProductUsingChooseOptions() {
        productPage.openFirstProductChooseOptions();
    }

    @When("I add all materials to cart")
    public void addAllMaterialsToCart() {
        productPage.addMaterialToCart("Soft");
        productPage.openFirstProductChooseOptions();
        productPage.addMaterialToCart("Hard");
        productPage.openFirstProductChooseOptions();
        productPage.addMaterialToCart("Black Soft");
        productPage.openFirstProductChooseOptions();
        productPage.addMaterialToCart("Glass");
    }

    @Then("I open cart and validate three materials")
    public void openCartAndValidateThreeMaterials() throws InterruptedException {
        productPage.openCart();
        cartItems = cartPage.readCartItems();
        cartPage.assertMaterialsPresent(cartItems);
    }

    @Then("I print cart details to console")
    public void printCartDetailsToConsole() {
        Assertions.assertNotNull(cartItems, "Cart items not available to print");
        CartConsolePrinter.printItems(cartItems);
    }
}
