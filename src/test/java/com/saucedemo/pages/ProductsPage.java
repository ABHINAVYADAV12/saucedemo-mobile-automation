package com.saucedemo.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By productsTitle =
            AppiumBy.accessibilityId("test-PRODUCTS");

    private final By cartButton =
            AppiumBy.accessibilityId("test-Cart");

    private final By backpackAddToCart =
            AppiumBy.xpath(
                    "//*[@text='Sauce Labs Backpack']"
                            + "/ancestor::*[@content-desc='test-Item'][1]"
                            + "//*[@content-desc='test-ADD TO CART']"
            );

    private final By cartBadge =
            AppiumBy.xpath("//*[@text='1']");

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public boolean isCatalogDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productsTitle
                )
        ).isDisplayed();
    }

    public void addBackpackToCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backpackAddToCart
                )
        ).click();
    }

    public String getCartBadgeCount() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBadge
                )
        ).getText();
    }

    public void openCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cartButton
                )
        ).click();
    }
}