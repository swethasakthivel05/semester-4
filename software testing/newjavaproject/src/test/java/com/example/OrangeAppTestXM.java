package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeAppTestXM {
    WebDriver driver;

    // @BeforeMethod
    // public void Testsetup() throws Exception {
    // WebDriverManager.chromedriver().setup();
    // driver = new ChromeDriver();
    // driver.manage().window().maximize();
    // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    // }

    // @Test
    // public void Test() throws Exception {
    // FileInputStream fs = new FileInputStream("E:\\dbankdemo.xlsx");
    // // D:\\_Temp_2\\filename.xlsx
    // XSSFWorkbook workbook = new XSSFWorkbook(fs);
    // XSSFSheet sheet1 = workbook.getSheet("login");
    // XSSFRow row1 = sheet1.getRow(1);
    // String username = row1.getCell(0).getStringCellValue();
    // String password = row1.getCell(1).getStringCellValue();
    // Thread.sleep(3000);
    // driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
    // .sendKeys(username);
    // driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
    // .sendKeys(password);
    // driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    // System.out.println(username + " " + password);
    // Thread.sleep(3000);
    // }

    // @AfterMethod
    // public void Testquit() {
    // driver.quit();
    // }

    @Test(dataProvider = "data")
    public void test1(String username, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
                .sendKeys(username);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }

    @DataProvider(name = "data")
    public Object[][] fetchData() throws Exception {
        Object[][] data = new Object[2][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";
        data[1][0] = "Admin111";
        data[1][1] = "admin123111";
        return data;
    }
}
