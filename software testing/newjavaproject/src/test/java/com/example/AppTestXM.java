package com.example;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTestXM {
    WebDriver driver;

    @BeforeMethod
    public void Testsetup() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        // FileInputStream fs=new FileInputStream("iiiy");
    }

    @Test
    public void Test() throws Exception {
        FileInputStream fs = new FileInputStream("E:\\dbankdemo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet1 = workbook.getSheet("login");
        XSSFRow row1 = sheet1.getRow(1);

        String username = row1.getCell(0).getStringCellValue();
        String password = row1.getCell(1).getStringCellValue();

        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("S@gmail.com");
        driver.findElement(By.id("password")).sendKeys("P@ssword12");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void Testquit() {
        driver.quit();
    }
}
