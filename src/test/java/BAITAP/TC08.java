//        1. Go to http://live.techpanda.org/
//
//        2. Click on my account link
//
//        3. Login in application using previously created credential
//
//        4. Click on 'REORDER' link , change QTY & click Update
//
//        5. Verify Grand Total is changed
//
//        6. Complete Billing & Shipping Information
//
//        7. Verify order is generated and note the order number
package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 {
    @Test
    public static void TestTC06(){
        WebDriver driver = driverFactory.getChromeDriver();
        String webtest="http://live.techpanda.org";
        String emaillAddress= "tranminhngocphuc16@gmail.com";
        String password="123456";
        String quanityvalue="10";

        String eleaccountDropdown = "//span[@class='label'][normalize-space()='Account']";
        String elemyAccoutnDropdown="div[id='header-account'] a[title='My Account']";
        String eleemailAddr="//input[@id='email']";
        String elepassword="//input[@id='pass']";
        String elebtnLogin="//button[@id='send2']";
        String eleReorder="//a[normalize-space()='Reorder']";
        String elequantity="input[title='Qty']";
        String eleUpdate="//tr[@class='first odd']//td[@class='product-cart-actions']//button[@title='Update']//span//span[contains(text(),'Update')]";
        String elegrandtotal ="strong span[class='price']";
        String eleproceedtoCheckout="//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']";
        String elebtnBilling="//button[@onclick='billing.save()']";
        String elebtnShippingmethod="//button[@onclick='shippingMethod.save()']";
        String eleradioMoneyOrder="//input[@id='p_method_checkmo']";
        String elebtnpaymentgInfo="//button[@onclick='payment.save()']";
        String elebtnPlaceOrder="//button[@title='Place Order']";
        String elecheckcreatedOrder="//h1[normalize-space()='Your order has been received.']";
        try{
//         1. Go to http://live.techpanda.org//
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
//        4. Click on 'REORDER' link , change QTY & click Update
            WebElement reodrder= driver.findElement(By.xpath(eleReorder));
            reodrder.click();
//            change QTY & click Update
            WebElement quanity= driver.findElement(By.cssSelector(elequantity));
            quanity.click();
            quanity.clear();
            Thread.sleep(2000);
            quanity.sendKeys(quanityvalue);
            WebElement grandtotalBefore =driver.findElement(By.cssSelector(elegrandtotal));
            String grandtotalvaluebefore=grandtotalBefore.getText();
            WebElement update =driver.findElement(By.xpath(eleUpdate));
            update.click();
            WebElement grandtotalAfter =driver.findElement(By.cssSelector(elegrandtotal));
            String grandtotalvalueAfter=grandtotalAfter.getText();
            System.out.println(grandtotalvalueAfter + "!="+ grandtotalvaluebefore);
            //        5. Verify Grand Total is changed
            Assert.assertTrue(grandtotalvaluebefore != grandtotalvalueAfter ,"Not changed");
            Thread.sleep(3000);

            //        6. Complete Billing & Shipping Information
            WebElement proceedtoCheckout=driver.findElement(By.xpath(eleproceedtoCheckout));
            proceedtoCheckout.click();
            WebElement btnBilling= driver.findElement(By.xpath(elebtnBilling));
            btnBilling.click();
            Thread.sleep(4000);
//            WebElement btnShippinginfo= driver.findElement(By.xpath("//button[@onclick='shipping.save()']"));
//            btnShippinginfo.click();

            WebElement btnShippingmethod = driver.findElement(By.xpath(elebtnShippingmethod));
            btnShippingmethod.click();
            Thread.sleep(4000);
            WebElement radioMoneyOrder = driver.findElement(By.xpath(eleradioMoneyOrder));
            WebElement btnpaymentgInfo = driver.findElement(By.xpath(elebtnpaymentgInfo));
            radioMoneyOrder.click();
            Thread.sleep(2000);
        ;
            btnpaymentgInfo.click();
            Thread.sleep(7000);

            WebElement btnplaceOrder =driver.findElement(By.xpath(elebtnPlaceOrder));
            btnplaceOrder.click();
            Thread.sleep(5000);
            WebElement checkCreatedOrder=driver.findElement(By.xpath(elecheckcreatedOrder));
            Assert.assertTrue(checkCreatedOrder.getText().equals("YOUR ORDER HAS BEEN RECEIVED."),"NOT CREATED");

        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
