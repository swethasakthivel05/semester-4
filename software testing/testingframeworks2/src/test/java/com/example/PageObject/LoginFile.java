package com.example.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFile {
    WebDriver driver;

    @FindBy(name = "uid")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement loginBtn;

    public LoginFile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String user) {
        userName.sendKeys(user);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickButton() {
        loginBtn.click();
    }
}
