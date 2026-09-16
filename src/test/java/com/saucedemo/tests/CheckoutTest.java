package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void userShouldCompleteCheckoutSuccessfully() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        // Verify Catalog
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertTrue(
                productsPage.isCatalogDisplayed(),
                "Catalog should be displayed after successful login"
        );

        // Add product to cart
        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartBadgeCount(),
                "1",
                "Cart badge should display 1 after adding the backpack"
        );

        // Open cart
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isBackpackDisplayed(),
                "Sauce Labs Backpack should be displayed in the cart"
        );

        // Start checkout
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Enter shipping information
        checkoutPage.enterShippingInformation(
                ConfigReader.get("first.name"),
                ConfigReader.get("last.name"),
                ConfigReader.get("zip.code")
        );

        // Continue to overview
        checkoutPage.clickContinue();

        // Finish order
        checkoutPage.clickFinish();

        // Verify confirmation
        Assert.assertTrue(
                checkoutPage.isOrderConfirmationDisplayed(),
                "Order confirmation should be displayed after completing checkout"
        );
    }
}