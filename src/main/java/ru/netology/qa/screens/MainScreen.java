package ru.netology.qa.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen {

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement changeText;

    @AndroidFindBy(id = "userInput")
    public MobileElement inputText;

    @AndroidFindBy (id = "buttonChange")
    public MobileElement changeButton;

    @AndroidFindBy (id = "buttonActivity")
    public MobileElement activityButton;

    @AndroidFindBy (id ="text")
    public MobileElement textTitle;

    private AppiumDriver driver;

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}


