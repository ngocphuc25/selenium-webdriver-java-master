//1. Go to http://live.techpanda.org/index.php/backendlogin
//        2. Login the credentials provided
//        3. Go to Sales-> Orders menu
//        4. Input OrderId and FromDate -> ToDate
//        5. Click Search button
//        6. Screenshot capture.
package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TC10 {
    @Test
    public static void TestTC06(){
        WebDriver driver = driverFactory.getChromeDriver();
        String webtest="http://live.techpanda.org/index.php/backendlogin";
        String user="user01";
        String pwd="guru99com";
        String valuefromdate="10/17/2023";
        String valuetodate="11/7/2023";
        String valueOrderID="100021066";

        String elebtnlogin="//input[@title='Login']";
        String eleusermame="//input[@id='username']";
        String elepassword="//input[@id='login']";
        String eleclosemessage="//span[contains(text(),'close')]";
        String elebtnSale="//span[contains(text(),'Sales')]";
        String eleOrder="//span[normalize-space()='Orders']";
        String elefromdate="created_at[from]";
        String eletodate="created_at[to]";
        String elebtnSearch="//span[contains(text(),'Search')]";
        String eleOrderId="//input[@id='sales_order_grid_filter_real_order_id']";
        try{
//         1. Go to http://live.techpanda.org//
            driver.get(webtest);
//        2. Login the credentials provided
            WebElement username= driver.findElement(By.xpath(eleusermame));
            WebElement password= driver.findElement(By.xpath(elepassword));
            username.sendKeys(user);
            password.sendKeys(pwd);
            WebElement btnlogin= driver.findElement(By.xpath(elebtnlogin));
            btnlogin.click();
            Thread.sleep(3000);
            WebElement closemessage= driver.findElement(By.xpath(eleclosemessage));
            closemessage.click();
//        3. Go to Sales-> Orders menu
            WebElement btnSale= driver.findElement(By.xpath(elebtnSale));
            btnSale.click();
            WebElement btnOrder= driver.findElement(By.xpath(eleOrder));
            btnOrder.click();
            Thread.sleep(5000);
            //        4. Input OrderId and FromDate -> ToDate
            WebElement Fromdate=driver.findElement(By.name(elefromdate));
            WebElement  Todate=driver.findElement(By.name(eletodate));
            WebElement OrderId= driver.findElement(By.xpath(eleOrderId));
            OrderId.sendKeys(valueOrderID);
            Fromdate.sendKeys(valuefromdate);
            Todate.sendKeys(valuetodate);
            WebElement btnSearch= driver.findElement(By.xpath(elebtnSearch));
            btnSearch.click();
            Thread.sleep(5000);
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
                File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

                try {
                    // Specify the path where you want to save the screenshot
                    File destination = new File("path/to/save/screenshot.png");
                    FileUtils.copyFile(screenshot, destination);
                    System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Driver does not support taking screenshots.");
            }
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
