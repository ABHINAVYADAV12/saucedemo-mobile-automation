# SauceDemo Mobile Automation

Mobile automation testing framework for the **Sauce Labs Demo Android App** using Appium, Java, TestNG, Maven, and Page Object Model (POM).

## Project Overview

This project automates key user flows of the SauceDemo Android application.

The framework is designed using the **Page Object Model (POM)** to keep test cases clean, maintainable, and independent of UI locator implementation.

## Tech Stack

- Java 21
- Appium
- Appium Java Client
- UiAutomator2
- TestNG
- Maven
- Android Emulator
- Page Object Model (POM)

## Test Scenarios

### 1. Valid Login & Catalog

**Test:** `LoginTest`

Steps:
1. Launch the SauceDemo Android application.
2. Enter valid username and password.
3. Click Login.
4. Verify that the Catalog/Products screen is displayed.

**Test Data:**
- Username: `standard_user`
- Password: `secret_sauce`

### 2. End-to-End Checkout

**Test:** `CheckoutTest`

Steps:
1. Login with valid credentials.
2. Verify the Catalog screen.
3. Add Sauce Labs Backpack to the cart.
4. Verify that the cart badge is updated to `1`.
5. Open the cart.
6. Verify that the Sauce Labs Backpack is present.
7. Proceed to checkout.
8. Enter shipping information.
9. Continue to the checkout overview.
10. Finish the order.
11. Verify the order confirmation screen.

### 3. Negative Login

**Test:** `NegativeLoginTest`

Steps:
1. Launch the application.
2. Enter invalid login credentials.
3. Click Login.
4. Verify the expected error message.

Expected error message:

`Username and password do not match any user in this service.`

## Project Structure

```text
saucedemo-mobile-automation/
│
├── pom.xml
├── .gitignore
│
└── src/
    └── test/
        ├── java/
        │   └── com/
        │       └── saucedemo/
        │           ├── base/
        │           │   └── BaseTest.java
        │           │
        │           ├── pages/
        │           │   ├── LoginPage.java
        │           │   ├── ProductsPage.java
        │           │   ├── CartPage.java
        │           │   └── CheckoutPage.java
        │           │
        │           ├── tests/
        │           │   ├── LoginTest.java
        │           │   ├── CheckoutTest.java
        │           │   └── NegativeLoginTest.java
        │           │
        │           └── utils/
        │               └── ConfigReader.java
        │
        └── resources/
            └── config.properties