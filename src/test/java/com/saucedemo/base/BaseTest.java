package com.saucedemo.base;

import com.saucedemo.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URI;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        // Device configuration
        options.setPlatformName(
                ConfigReader.get("platform.name")
        );

        options.setAutomationName(
                ConfigReader.get("automation.name")
        );

        options.setDeviceName(
                ConfigReader.get("device.name")
        );

        // Application configuration
        options.setAppPackage(
                ConfigReader.get("app.package")
        );

        options.setAppActivity(
                ConfigReader.get("app.activity")
        );

        options.setAppWaitActivity("*");

        options.setApp(
                System.getProperty("user.dir")
                        + "/"
                        + ConfigReader.get("app.path")
        );

        // Appium launch configuration
        options.setAppWaitDuration(
                Duration.ofSeconds(30)
        );

        options.setCapability(
                "appium:forceAppLaunch",
                true
        );

        options.setCapability(
                "appium:noReset",
                false
        );

        // Start Appium session
        driver = new AndroidDriver(
                URI.create(
                        ConfigReader.get("appium.server.url")
                ).toURL(),
                options
        );

        // Default implicit wait
        driver.manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(10)
                );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}