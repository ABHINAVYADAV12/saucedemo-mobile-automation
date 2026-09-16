package com.saucedemo.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By checkoutButton =
            AppiumBy.accessibilityId("test-CHECKOUT");

    private final By backpackInCart =
            AppiumBy.xpath("//*[@text='Sauce Labs Backpack']");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public boolean isBackpackDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        backpackInCart
                )
        ).isDisplayed();
    }

    public void clickCheckout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        checkoutButton
                )
        ).click();
    }
}