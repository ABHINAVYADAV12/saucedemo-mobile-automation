package com.saucedemo.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By firstNameField =
            AppiumBy.accessibilityId("test-First Name");

    private final By lastNameField =
            AppiumBy.accessibilityId("test-Last Name");

    private final By zipCodeField =
            AppiumBy.accessibilityId("test-Zip/Postal Code");

    private final By continueButton =
            AppiumBy.accessibilityId("test-CONTINUE");

    private final By finishButton =
            AppiumBy.accessibilityId("test-FINISH");

    private final By checkoutCompleteTitle =
            AppiumBy.accessibilityId(
                    "test-CHECKOUT: COMPLETE!"
            );

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public void enterShippingInformation(
            String firstName,
            String lastName,
            String zipCode) {

        WebElement firstNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        firstNameField
                )
        );

        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        lastNameField
                )
        );

        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);

        WebElement zipElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        zipCodeField
                )
        );

        zipElement.clear();
        zipElement.sendKeys(zipCode);
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueButton
                )
        ).click();
    }

    public void clickFinish() {

        String finishUiSelector =
                "new UiSelector().description(\"test-FINISH\")";

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView("
                                + finishUiSelector
                                + ")"
                )
        ).click();
    }

    public boolean isOrderConfirmationDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        checkoutCompleteTitle
                )
        ).isDisplayed();
    }
}