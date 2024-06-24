package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
public class AppTest {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;
    Logger logger = Logger.getLogger(AppTest.class);

    @BeforeTest
    public void setup() {
        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(
                "C:\\Users\\Swetha\\Documents\\semester 4\\software testing\\softwaretestingcc2\\report.html");
        reports.attachReporter(spark);
        test = reports.createTest("Result");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PropertyConfigurator.configure(
                "C:\\Users\\Swetha\\Documents\\semester 4\\software testing\\softwaretestingcc2\\src\\main\\java\\com\\example\\resources\\log4j.properties");
    }

    @BeforeMethod
    public void Testsetup() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.barnesandnoble.com/");
    }

    @Test(priority = 0)
    public void Testcase1() throws Exception {
        FileInputStream fs = new FileInputStream("E:\\cc1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet1 = workbook.getSheet("book");
        XSSFRow row1 = sheet1.getRow(1);

        String book = row1.getCell(0).getStringCellValue();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[2]/div/input[1]"))
                .sendKeys(book);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/span/button")).click();
        String check = driver
                .findElement(By.xpath("//*[@id='searchGrid']/div/section[1]/section[1]/div/div[1]/div[1]/h1/span"))
                .getText();
        Thread.sleep(3000);
        if (check.equals(book)) {
            System.out.println("Thus the search of Chetan Bhagat is true");
            test.log(Status.PASS, "The result is True");
            logger.info("It contains Chetan Bhagat");

        } else {
            System.out.println("The result is not True");
            test.log(Status.FAIL, "The result is False");
            logger.info("It doesn't contains Chetan Bhagat");
        }
    }

    @Test(priority = 1)
    public void Testcase2() throws Exception {
        driver.navigate().to("https://www.barnesandnoble.com/");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='rhfCategoryFlyout_Audiobooks']"))).perform();
        Thread.sleep(4000);
        driver.findElement(
                By.xpath("//*[@id='navbarSupportedContent']/div/ul/li[5]/div/div/div[1]/div/div[2]/div[1]/dd/a[1]"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Funny Story")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='otherAvailFormats']/div/div/div[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\'addToBagForm_2940159543998\'']/input[11]")).submit();
        String find = driver.switchTo().alert().getText();
        if (find.contains("Item Successfully Added To Your Cart")) {
            System.out.println("Successfully inserted into the cart");
            test.log(Status.PASS, "The item is inserted into the cart");
        } else {
            System.out.println("Item not inserted into the cart");
            test.log(Status.FAIL, "The item is not inserted in the cart");
        }
    }

    @Test(priority = 2)
    public void Testcase3() throws Exception {
        driver.navigate().to("https://www.barnesandnoble.com/");
        driver.findElement(By.xpath("//*[@id=\"footer\"]/div/dd/div/div/div[1]/div/a[5]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"rewards-modal-link\"]")).click();
        Thread.sleep(2000);
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "C:\\Users\\Swetha\\Documents\\semester 4\\software testing\\softwaretestingcc2\\screenshot.png";
        FileUtils.copyFile(screen, new File(path));
    }

    @AfterMethod
    public void Testquit() {
        driver.quit();
    }

    @AfterTest
    public void Testend() {
        reports.flush();
        driver.quit();
    }
}
