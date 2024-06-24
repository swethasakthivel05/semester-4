// // // package com.example;

// // // import org.junit.Test;
// // // import org.openqa.selenium.By;
// // // import org.openqa.selenium.WebDriver;
// // // import org.openqa.selenium.chrome.ChromeDriver;
// // // import org.testng.annotations.AfterMethod;
// // // import org.testng.annotations.BeforeMethod;

// // // import io.github.bonigarcia.wdm.WebDriverManager;

// // // /**
// // //  * Unit test for simple App.
// // //  */
// // // public class Sample {
// // //     /**
// // //      * Rigorous Test :-)
// // //      * 
// // //      * @throws InterruptedException
// // //      */
// // //     WebDriver driver;

// // //     @BeforeMethod
// // //     public void Testsetup() throws Exception {

// // //         WebDriverManager.chromedriver().setup();
// // //         driver = new ChromeDriver();
// // //         driver.manage().window().maximize();
// // //         driver.get("https://www.demoblaze.com/");
// // //         // FileInputStream fs=new FileInputStream("iiiy");
// // //     }

// // //     @Test
// // //     public void shouldAnswerWithTrue() throws InterruptedException {
// // //         driver.get("https://www.demoblaze.com/");
// // //         Thread.sleep(3000);
// // //         driver.findElement(By.linkText("Laptops")).click();
// // //         Thread.sleep(3000);
// // //         driver.findElement(By.xpath("//*[@id='tbodyid']/div[3]/div/div/h4/a")).click();
// // //         Thread.sleep(3000);
// // //         driver.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/a")).click();
// // //         Thread.sleep(2000);
// // //         driver.switchTo().alert().accept();
// // //         Thread.sleep(3000);
// // //         driver.findElement(By.linkText("Cart")).click();
// // //         Thread.sleep(3000);
// // //         String title = driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]")).getText();
// // //         System.out.println("Title : " + title);
// // //         String price = driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[3]")).getText();
// // //         System.out.println("Price : " + price);
// // //         Thread.sleep(2000);
// // //         driver.quit();
// // //     }

// // //     @AfterMethod
// // //     public void afterMethod() {
// // //         driver.quit();
// // //     }
// // // }

// // import org.junit.After;
// // import org.junit.Before;
// // import org.junit.Test;
// // import org.openqa.selenium.By;
// // import org.openqa.selenium.WebDriver;
// // import org.openqa.selenium.chrome.ChromeDriver;
// // import org.openqa.selenium.chrome.ChromeOptions;
// // import org.openqa.selenium.support.ui.ExpectedConditions;
// // import org.openqa.selenium.support.ui.WebDriverWait;

// // import io.github.bonigarcia.wdm.WebDriverManager;

// // public class SampleTest {

// //     WebDriver driver;

// //     @Before
// //     public void setUp() {
// //         ChromeOptions options = new ChromeOptions();
// //         options.addArguments("--start-maximized");

// //         WebDriverManager.chromedriver().setup();
// //         driver = new ChromeDriver(options);
// //         driver.get("https://www.demoblaze.com/");
// //     }

// //     @Test
// //     public void testAddToCart() {
// //         WebDriverWait wait = new WebDriverWait(driver, 10);

// //         // Navigate to Laptops section
// //         driver.findElement(By.linkText("Laptops")).click();

// //         // Add a laptop to cart
// //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/div[3]/div/div/h4/a")))
// //                 .click();
// //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))).click();
// //         wait.until(ExpectedConditions.alertIsPresent()).accept();

// //         // View cart and get item details
// //         driver.findElement(By.linkText("Cart")).click();
// //         String title = wait
// //                 .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr/td[2]")))
// //                 .getText();
// //         String price = wait
// //                 .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr/td[3]")))
// //                 .getText();

// //         System.out.println("Title : " + title);
// //         System.out.println("Price : " + price);
// //     }

// //     @After
// //     public void tearDown() {
// //         if (driver != null) {
// //             driver.quit();
// //         }
// //     }
// // }


// package com.example;

// //import static org.junit.Assert.assertTrue;

// import java.io.FileInputStream;
// import java.time.Duration;

// import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
// //import org.junit.Test;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.Select;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.DataProvider;
// import org.testng.annotations.Test;
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.ss.usermodel.Sheet;
// import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class SampleTest {
//     WebDriver driver;

//     @BeforeMethod
//     public void Testsetup() throws Exception {
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.get("http://dbankdemo.com/bank/login");
//         // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//     }

//     @Test
//     public void Test() throws Exception {
//         FileInputStream fs = new FileInputStream("D:\\dbankdemo.xlsx");

//         Workbook workbook = new XSSFWorkbook(fs);
//         Sheet sheet = workbook.getSheetAt(0);// name of the sheet
//         Row row1 = sheet.getRow(1);// 0->heading,1->value
//         String username = row1.getCell(0).getStringCellValue();
//         String password = row1.getCell(1).getStringCellValue();
//         Thread.sleep(3000);
//         driver.findElement(By.id("username")).sendKeys(username);
//         driver.findElement(By.id("password")).sendKeys(password);
//         Thread.sleep(3000);
//         driver.findElement(By.id("submit")).click();
//         Thread.sleep(3000);
//         driver.findElement(By.id("deposit-menu-item")).click();

//         Thread.sleep(3000);

//         WebElement dropdownElement = driver.findElement(By.id("selectedAccount"));
//         Select dropdown = new Select(dropdownElement);
//         dropdown.selectByVisibleText("Individual Checking(standard checking) (Savings)");
//         Thread.sleep(3000);
//         driver.findElement(By.id("amount")).sendKeys("5000");
//         Thread.sleep(3000);
//         driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
//         Thread.sleep(3000);
//         JavascriptExecutor js = (JavascriptExecutor) driver;
//         js.executeScript("window.scrollBy(0,1000)");

//         WebElement cell = driver.findElement(By.xpath("//td[@class='text-danger']"));
//         String amount = cell.getText();

//         // Check if the deposited amount is correct
//         if ("$5000.00".equals(amount.trim())) {
//             System.out.println("Deposited amount is correct.");
//         } else {
//             System.out.println("Deposited amount is incorrect.");
//         }

//         driver.navigate().to("http://dbankdemo.com/bank/home");
//         Thread.sleep(2000);
//         driver.findElement(By.id("withdraw-menu-item")).click();

//         Thread.sleep(3000);

//         WebElement dropdownElement1 = driver.findElement(By.id("selectedAccount"));
//         Select dropdown1 = new Select(dropdownElement1);
//         dropdown1.selectByVisibleText("Individual Checking(standard checking) (Savings)");
//         Thread.sleep(3000);

//         driver.findElement(By.id("amount")).sendKeys("3000");
//         Thread.sleep(3000);
//         driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
//         Thread.sleep(3000);
//         JavascriptExecutor jss = (JavascriptExecutor) driver;
//         jss.executeScript("window.scrollBy(0,1000)");
//         Thread.sleep(3000);
//         WebElement withdrawAmountCell = driver.findElement(By.xpath("//td[@class='text-danger']"));
//         String withdrawAmount = withdrawAmountCell.getText();
//         if ("$-3000.00".equals(withdrawAmount.trim())) {
//             System.out.println("Withdraw amount is correct.");
//         } else {
//             System.out.println("Withdraw amount is incorrect.");
//         }

//     }

//     @AfterMethod
//     public void Testend() {
//         driver.quit();
//     }
// // }4
// package com.example;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;

// import org.apache.commons.io.FileUtils;
// import org.apache.poi.xssf.usermodel.XSSFRow;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.openqa.selenium.By;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Test;

// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.reporter.ExtentSparkReporter;

// import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
//  */
// public class SampleTest 
// {
//     WebDriver driver;
//     ExtentReports reports;
//     ExtentTest test;
//     @BeforeTest
//     public void setup() {
//         reports = new ExtentReports();
//         ExtentSparkReporter spark = new ExtentSparkReporter(
//                 "C:\\Users\\91701\\Desktop\\it sckcet\\softwareTesting-1\\ExtentReports\\exercise1\\report.html");
//         reports.attachReporter(spark);
//         test = reports.createTest("Demo Result");
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.get("https://groww.in/");
//     }
//     @Test(priority = 1)
//     public void test() throws IOException, InterruptedException {
//         driver.findElement(By.linkText("Calculators")).click();
//         Thread.sleep(2000);
//         File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//         String path = "C:\\Users\\91701\\Desktop\\it sckcet\\softwareTesting-1\\ExtentReports\\exercise1\\calculator.png";
//         FileUtils.copyFile(screen, new File(path));
//         test.addScreenCaptureFromPath(path);
//         reports.flush();
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/a[15]")).click();
//         Thread.sleep(2000);
//         WebElement loanAmount = driver.findElement(By.xpath("//*[@id=\"LOAN_AMOUNT\"]"));
//         Thread.sleep(2000);
//         loanAmount.clear();
//         Thread.sleep(2000);
//         FileInputStream fs = new FileInputStream("C:\\Users\\91701\\Downloads\\input for websites.xlsx");
//         Thread.sleep(2000);
//         XSSFWorkbook workBook = new XSSFWorkbook(fs);
//         XSSFSheet sheet = workBook.getSheet("Bank login");
//         XSSFRow row = sheet.getRow(4);
//         String amt = row.getCell(0).toString();
//         loanAmount.sendKeys(amt);
//         Thread.sleep(2000);
//         WebElement interest = driver.findElement(By.xpath("//*[@id=\"RATE_OF_INTEREST\"]"));
//         interest.clear();
//         Thread.sleep(2000);
//         String in = row.getCell(1).toString();
//         interest.sendKeys(in);
//         Thread.sleep(2000);
//         WebElement loanTenure = driver.findElement(By.xpath("//*[@id=\"LOAN_TENURE\"]"));
//         loanTenure.clear();
//         Thread.sleep(2000);
//         String ten = row.getCell(2).toString();
//         interest.sendKeys(ten);
//         Thread.sleep(2000);
//         String ver = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p")).getText();
//         if(ver.equals("Your Amortization Details (Yearly/Monthly)")) {
//             System.out.println("Successful");
//         }
//         else {
//             System.out.println("Unsuccessful");
//         }
//     }
//     @AfterTest
//     public void quitDriver() {
//         driver.quit();
//     }
// }


