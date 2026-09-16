package com.saucedemo.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class LoginPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By usernameField =
            AppiumBy.accessibilityId("test-Username");

    private final By passwordField =
            AppiumBy.accessibilityId("test-Password");

    private final By loginButton =
            AppiumBy.accessibilityId("test-Login");

    private final By errorMessage =
            AppiumBy.accessibilityId("test-Error message");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public void enterUsername(String username) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameField
                )
        );

        field.clear();
        field.sendKeys(username);
    }

    public void enterPassword(String password) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordField
                )
        );

        field.clear();
        field.sendKeys(password);
    }

    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        );

        /*
         * The Sauce Labs Demo App exposes the LOGIN control as an
         * accessible ViewGroup. On the configured emulator,
         * WebDriver's element click does not reliably trigger the
         * navigation. Android's native click gesture does.
         */
        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "x", 540,
                        "y", 1096
                )
        );
    }

    public void login(
            String username,
            String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {

        WebElement errorContainer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        errorMessage
                )
        );

        WebElement errorText = errorContainer.findElement(
                By.className("android.widget.TextView")
        );

        return errorText.getText();
    }
}