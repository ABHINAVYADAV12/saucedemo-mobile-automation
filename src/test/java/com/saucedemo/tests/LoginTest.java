package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginShouldOpenCatalog() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertTrue(
                productsPage.isCatalogDisplayed(),
                "Catalog screen should be displayed after successful login"
        );
    }
}