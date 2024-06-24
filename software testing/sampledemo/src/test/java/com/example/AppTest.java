package com.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        // WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();
        // driver.get("https://www.demoblaze.com/");
        // Thread.sleep(5000);
        // driver.findElement(By.linkText("Laptops")).click();
        // Thread.sleep(5000);
        // driver.findElement(By.linkText("MacBook air")).click();
        // Thread.sleep(5000);
        // driver.findElement(By.linkText("Add to cart")).click();
        // Thread.sleep(5000);
        // driver.switchTo().alert().accept();
        // Thread.sleep(5000);
        // driver.findElement(By.linkText("Cart")).click();
        // driver.quit();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='withOptGroup']/div/div[1]")).click();
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

        // driver.selectByVisibleText("Another root option")
        // Select dropdown = new
        // Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
        // dropdown.selectByVisibleText("Purple");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        driver.quit();
    }

}