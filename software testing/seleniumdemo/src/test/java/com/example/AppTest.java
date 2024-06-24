package com.example;

// import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(5000);
        // driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]")).click();
        // boolean str =
        // driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]")).isSelected();
        // System.out.println(str);
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,1000)");
        WebElement element = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1] "));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(5000);
        // driver.findElement(By.id("firstName")).sendKeys("subesha");
        // Thread.sleep(5000);
        // driver.findElement(By.linkText("Laptops")).click();
        // Thread.sleep(5000);
        // driver.findElement(By.linkText("MacBook air")).click();
        // Thread.sleep(5000);
        // driver.findElement(By.linkText("Add to cart")).click();
        // Thread.sleep(5000);
        // String title=driver.getTitle();
        // System.out.println(title);
        // String curl=driver.getCurrentUrl();
        // System.out.println(curl);
        // String page = driver.getPageSource();
        // System.out.println(page);

        // driver.findElement(By.linkText("Laptops")).click();
        // Thread.sleep(2000);
        // driver.findElement(By.linkText("MacBook air")).click();
        // Thread.sleep(2000);
        // driver.findElement(By.linkText("Add to cart")).click();
        // Thread.sleep(2000);
        // driver.switchTo().alert().accept();
        // Thread.sleep(2000);
        // driver.findElement(By.linkText("Cart")).click();
        // Thread.sleep(2000);

        driver.quit();
    }
}