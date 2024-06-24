package com.example;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("https://www.google.com");
        System.out.println("Test Init");
    }

    // @BeforeMethod
    // public void init() {
    // System.out.println("Driver Init");
    // }

    @Test(priority = 0)
    public void Google() {
        driver.get("https://www.google.com");
        System.out.println("LOGIN");
    }

    @Test(priority = 1)
    public void Bing() {
        driver.get("https://www.bing.com");
        System.out.println("REGISTER");
    }
    // @Test()
    // public void Login() {
    // driver.get("https://www.google.com");
    // System.out.println("LOGIN");
    // }

    // @Test()
    // public void Register() {
    // System.out.println("REGISTER");
    // }

    // @AfterMethod
    // public void closeDriver() {
    // System.out.println("Driver Quit");
    // }

    @AfterTest
    public void closeTest() {
        // System.out.println("End");
        driver.quit();
    }

}