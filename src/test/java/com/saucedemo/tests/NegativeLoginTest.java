package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void invalidLoginShouldDisplayErrorMessage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("invalid.username"),
                ConfigReader.get("invalid.password")
        );

        String actualError = loginPage.getErrorMessage();

        String expectedError =
                "Username and password do not match any user in this service.";

        Assert.assertEquals(
                actualError,
                expectedError,
                "Invalid login should display the expected error message"
        );
    }
}