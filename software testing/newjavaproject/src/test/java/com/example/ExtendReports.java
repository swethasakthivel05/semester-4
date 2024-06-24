package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReports {
    WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeTest
    public void Testsetup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        ExtentSparkReporter r = new ExtentSparkReporter("E:\\report.html");
        report = new ExtentReports();
        report.attachReporter(r);

    }

    @Test
    public void Test() throws Exception {
        test = report.createTest("test");

        FileInputStream fs = new FileInputStream(new File("E:\\dbankdemo.xlsx"));
        Workbook workbook = new XSSFWorkbook(fs);
        Sheet sheet = workbook.getSheetAt(0);// name of the sheet
        Row row1 = sheet.getRow(1);// 0->heading,1->value
        String username = row1.getCell(0).getStringCellValue();
        String password = row1.getCell(1).getStringCellValue();
        System.out.println(username);
        System.out.println(password);
        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys(username);
        // test.log()
        test.log(Status.PASS, "Passed");
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }


    @AfterTest
    public void Testend() {
        report.flush();
        driver.quit();
    }
}

// @BeforeMethod
// public void init() {
// System.out.println("Before the method");
// }

// @Test()
// public void Google() {
// driver.get("https://www.google.com");
// System.out.println("GOOGLE");
// }

// @Test()
// public void Bing() {
// driver.get("https://www.bing.com");
// System.out.println("BING");
// }

// @Test()
// public void Demo() {
// driver.get("https://www.demoblaze.com/");
// System.out.println("DEMO");
// }

// @Test()
// public void Demoqa() {
// driver.get("https://demoqa.com/");
// System.out.println("DEMOQA");
// }

// @Test()
// public void Github() {
// driver.get("https://github.com/");
// System.out.println("GITHUB");
// }
// @Test()
// public void Login() {
// driver.get("https://www.google.com");
// System.out.println("LOGIN");
// }

// @Test(priority = 1)
// public void Register() {
// System.out.println("REGISTER");
// }

// @AfterMethod
// public void closeDriver() {
// System.out.println("Driver Quit");
// }

// @AfterMethod
// public void closeTest() {
// System.out.println("After the method");

// }