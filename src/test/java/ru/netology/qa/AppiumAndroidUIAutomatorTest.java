package ru.netology.qa;

import io.appium.java_client.AppiumDriver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.netology.qa.screens.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@TestInstance(Lifecycle.PER_CLASS)
public class AppiumAndroidUIAutomatorTest {

    private AppiumDriver driver;

    @BeforeAll
    public void createDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(DEVICE_NAME, "any name");
        desiredCapabilities.setCapability(APP_PACKAGE, "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability(APP_ACTIVITY, "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
    }

    @Test
    public void inputEmptyTextTest() {
        MainScreen mainScreen = new MainScreen(driver);
        String prevText = mainScreen.changeText.getText();
        mainScreen.inputText.setValue(" ");
        mainScreen.changeButton.click();
        Assertions.assertEquals(prevText, mainScreen.changeText.getText());
    }

    @Test
    public void inputTexOnNewActivityTest() {
        String text = "Netology.ru";
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.inputText.setValue(text);
        mainScreen.activityButton.click();
        Assertions.assertEquals(text, mainScreen.textTitle.getText());
    }

    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
