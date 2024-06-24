package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class ExtendReportSecond {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void setup() {
        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(
                "C:\\Users\\Swetha\\Documents\\semester 4\\software testing\\n" + //
                        "ewjavaproject\\report2.html");
        reports.attachReporter(spark);
        test = reports.createTest("Demo2 Result");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ixigo.com/");
    }

    @Test(priority = 0)
    public void testCase1() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]")).click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div")).click();
        WebElement from = driver.findElement(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input"));
        FileInputStream fs = new FileInputStream("E:\\\\dbankdemo.xlsx");
        XSSFWorkbook work = new XSSFWorkbook(fs);
        XSSFSheet sheet = work.getSheet("login");
        XSSFRow row = sheet.getRow(5);
        String fromWhere = row.getCell(0).getStringCellValue();
        from.sendKeys(fromWhere);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/li"))
                .click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div")).click();
        WebElement to = driver.findElement(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input"));
        String toWhere = row.getCell(1).getStringCellValue();
        to.sendKeys(toWhere);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]/li"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div")).click();
        Thread.sleep(2000);
        while (true) {
            String curr = driver.findElement(By.xpath(
                    "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[2]/span[1]"))
                    .getText();
            System.out.println(curr);
            String s[] = curr.split(" ");
            String currMonth = s[0];
            String currYear = s[1];
            if (currMonth.equals("November") && currYear.equals("2024"))
                break;
            driver.findElement(
                    By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[3]"))
                    .click();
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[11]"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[13]"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[1]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[3]"))
                .click();
        driver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[3]"))
                .click();
        driver.findElement(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]"))
                .click();
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/button"))
                .click();
        Thread.sleep(1000);
        String returnDate = driver
                .findElement(
                        By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/div/p[2]"))
                .getText();
        if (returnDate.contains("08 Nov")) {
            System.out.println("The date was entered correctly");
            test.log(Status.PASS, "Test Passed");
        } else {
            System.out.println("The selected date was wrong");
            test.log(Status.FAIL, "Test Failed");
        }
    }

    @Test(priority = 1)
    public void testCase2() throws InterruptedException {
        driver.findElement(By.linkText("About Us")).click();
        Thread.sleep(3000);
        String currWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(currWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        String currUrl = driver.getCurrentUrl();
        if (currUrl.contains("about")) {
            System.out.println("The page has been redirected");
            test.log(Status.PASS, "Page Redirected");
        } else {
            System.out.println("The page has not been redirected");
            test.log(Status.FAIL, "Page not Redirected");
        }
    }

    @AfterTest
    public void quitDriver() {
        reports.flush();
        driver.quit();
    }
}