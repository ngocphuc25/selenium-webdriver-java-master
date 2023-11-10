//         1. Go to http://live.techpanda.org/
//
//        2. Go to Mobile and add IPHONE to cart
//
//        3. Enter Coupon Code
//
//        4. Verify the discount generated
//
//        TestData:  Coupon Code: GURU50
//
//        Expected result:
//
//        1) Price is discounted by 5%
package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 {
    @Test
    public static void TestTC06(){
        WebDriver driver = driverFactory.getChromeDriver();
        String webtest="http://live.techpanda.org";
        String discountvalue="GURU50";
        String eleMobile ="//a[normalize-space()='Mobile']";
        String eleIphoneAddtoCart="//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]";
        String eleDiscount="//input[@id='coupon_code']";
        String elebtnaplly="//span[contains(text(),'Apply')]";
        String eleVerifyDiscount="li[class='success-msg'] ul li span";
        String eletotalbeforeuseDiscount="strong span[class='price']";
        String eletotalafteruseDiscount="strong span[class='price']";
        try{
//         1. Go to http://live.techpanda.org//
            driver.get(webtest);
            //        2. Go to Mobile and add IPHONE to cart
            WebElement linkmobile= driver.findElement(By.xpath(eleMobile));
            linkmobile.click();
            WebElement iphoneAddtoCart= driver.findElement(By.xpath(eleIphoneAddtoCart));
             iphoneAddtoCart.click();
            WebElement totalbeforeuseDiscount= driver.findElement(By.cssSelector(eletotalbeforeuseDiscount));
            //        3. Enter Coupon Code
            WebElement discount=driver.findElement(By.xpath(eleDiscount));
            discount.sendKeys(discountvalue);
            WebElement btnapply= driver.findElement(By.xpath(elebtnaplly));
            btnapply.click();
            Thread.sleep(3000);
            WebElement verifyDiscountgenerated= driver.findElement(By.cssSelector(eleVerifyDiscount));
//            System.out.println(verifyDiscountgenerated.getText());
//            System.out.println("Coupon code \"GURU50\" was applied.");
            Assert.assertTrue(verifyDiscountgenerated.getText().equals("Coupon code \"GURU50\" was applied."),"not aplly discount");
            WebElement totalafteruseDiscount= driver.findElement(By.cssSelector(eletotalbeforeuseDiscount));
            Assert.assertFalse(eletotalafteruseDiscount==eletotalbeforeuseDiscount,"total is not discounted");
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
