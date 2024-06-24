package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class TestNg2 {
        /**
         * Rigorous Test :-)
         */
        WebDriver driver;
        WebDriverWait wait;

        @BeforeMethod
        public void setup() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get("https://www.moneycontrol.com/");
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }

        @Test
        public void shouldAnswerWithTrue() throws InterruptedException {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body"))));
                Thread.sleep(10000);
                WebElement element = driver.findElement(By
                                .xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/input[5]"));
                element.click();
                element.sendKeys("Reliance Industries");
                Thread.sleep(5000);
                element.sendKeys(Keys.ENTER);
                driver.findElement(By.xpath("/html/body/div[8]/div[3]/div[2]/div/table/tbody/tr[4]/td[1]/p/a/strong"))
                                .click();
                JavascriptExecutor j = (JavascriptExecutor) driver;
                j.executeScript("window.scrollBy(0,300)");

                Thread.sleep(5000);
                WebElement mutualfunds = driver.findElement(By.linkText("Mutual Funds"));
                Actions actions = new Actions(driver);
                actions.moveToElement(mutualfunds).perform();
                Thread.sleep(5000);

                WebElement sip = driver.findElement(By.linkText("SIP Return"));
                sip.click();
                Thread.sleep(5000);

                Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='ff_id']")));
                dropdown.selectByVisibleText("Axis Mutual Fund");
                Select drop = new Select(driver.findElement(By.xpath("//*[@id='im_id']")));
                drop.selectByIndex(3);

                driver.findElement(By.xpath("//*[@id='invamt']")).sendKeys("100000");

                Select period = new Select(driver.findElement(By.xpath("//*[@id='frq']")));
                period.selectByVisibleText("Monthly");

                driver.findElement(By.xpath("//*[@id='stdt']")).sendKeys("2021-08-02");
                driver.findElement(By.xpath("//*[@id='endt']")).sendKeys("2023-08-17");

                driver.findElement(
                                By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input"))
                                .click();

                WebElement r1 = driver.findElement(By
                                .xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]"));
                System.out.println(r1.getText());

                WebElement r2 = driver.findElement(By
                                .xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[3]"));
                System.out.println(r2.getText());
        }

        @AfterMethod
        public void closemethod() {
                driver.quit();
        }
}