//        1. Go to http://live.techpanda.org/
//
//        2. Click on My Account link
//
//        3. Login in application using previously created credential
//
//        4. Click on 'My Orders'
//
//        5. Click on 'View Order'
//
//        6. Click on 'Print Order' link
package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC07 {

    @Test
    public static void TestTC07(){
        WebDriver driver = driverFactory.getChromeDriver();
        String webtest="http://live.techpanda.org";
        String emaillAddress= "tranminhngocphuc16@gmail.com";
        String password="123456";

        String eleaccountDropdown = "//span[@class='label'][normalize-space()='Account']";
        String elemyAccoutnDropdown="div[id='header-account'] a[title='My Account']";
        String eleemailAddr="//input[@id='email']";
        String elepassword="//input[@id='pass']";
        String elebtnLogin="//button[@id='send2']";
        String elemyOrder="//a[normalize-space()='My Orders']";
        String eleviewOrder="//a[normalize-space()='View Order']";
        String eleprintOrderlink="//a[normalize-space()='Print Order']";
        try{
//         1. Go to http://live.techpanda.org/
            driver.get(webtest);
//         2. Click on my account link
            WebElement accountDropdown = driver.findElement(By.xpath(eleaccountDropdown));
            accountDropdown.click();
            WebElement myAccountlink = driver.findElement(By.cssSelector(elemyAccoutnDropdown));
            myAccountlink.click();
//            3. Login in application using previously created credential
            WebElement emailAddr= driver.findElement(By.xpath(eleemailAddr));
            WebElement passwr= driver.findElement(By.xpath(elepassword));
            emailAddr.sendKeys(emaillAddress);
            passwr.sendKeys(password);
            WebElement btnLogin =driver.findElement(By.xpath(elebtnLogin));
            btnLogin.click();
//        4. Click on 'My Orders'
            WebElement myOrderlink = driver.findElement(By.xpath(elemyOrder));
            myOrderlink.click();
            Thread.sleep(2000);
//        5. Click on 'View Order'
            WebElement viewOrder=driver.findElement(By.xpath(eleviewOrder));
            viewOrder.click();
            Thread.sleep(3000);
//        6. Click on 'Print Order' link
            WebElement prinOrderlink= driver.findElement(By.xpath(eleprintOrderlink));
            prinOrderlink.click();
            Thread.sleep(3000);
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
