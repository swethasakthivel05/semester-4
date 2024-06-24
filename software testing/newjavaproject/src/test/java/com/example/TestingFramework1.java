// package com.example;

// import java.io.FileInputStream;

// import org.apache.poi.ss.usermodel.Workbook;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Test;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class TestingFramework1 {
//     WebDriver driver;

//     @BeforeTest
//     public void BeforeTest() throws Exception
//     {
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.get("https://www.google.com/");
//         driver.manage().window().maximize();
//     }

//     @Test
//     public void Testcase1() throws Exception
//     {
//         driver.get("http://dbankdemo.com/bank/login");

//         FileInputStream fs= new FileInputStream("E:\\dbankdemo.xlsx");
//         Workbook 
//     }
// }


package com.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class TestingFramework1 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.demoblaze.com/");
        // driver.manage().window().maximize();
        //driver.findElement(By.id("email")).sendKeys("uehjhasbdghw");
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("MacBook air")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(5000);
        String title = driver.findElement(By.xpath("//*[@id='tbodyid']/tr[1]/td[2]")).getText();
        System.out.println(title);
        String price = driver.findElement(By.xpath("//*[@id='tbodyid']/tr[1]/td[3]")).getText();
        System.out.println(price);
        Thread.sleep(2000);
        driver.quit();
    }
}