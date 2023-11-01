//Test Steps:
//
//        1. Go to http://live.techpanda.org/
//
//        2. Click on my account link
//
//        3. Login in application using previously created credential
//
//        4. Click on MY WISHLIST link
//
//        5. In next page, Click ADD TO CART link
//
//        6. Enter general shipping country, state/province and zip for the shipping cost estimate
//
//        7. Click Estimate
//
//        8. Verify Shipping cost generated
//
//        9. Select Shipping Cost, Update Total
//
//        10. Verify shipping cost is added to total
//
//        11. Click "Proceed to Checkout"
//
//        12a. Enter Billing Information, and click Continue
//
//        12b. Enter Shipping Information, and click Continue
//
//        13. In Shipping Method, Click Continue
//
//        14. In Payment Information select 'Check/Money Order' radio button. Click Continue
//
//        15. Click 'PLACE ORDER' button
//
//        16. Verify Order is generated. Note the order number


        package BAITAP;

import com.beust.ah.A;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 {

    @Test
    public static void TestTC06(){
        WebDriver driver = driverFactory.getChromeDriver();
        String emaillAddress= "phuctmnse172099@fpt.edu.vn";
        String password="123456";
        String CODE ="6666";
        String chooseOption ="Alabama";
        String inputAddressBilling="aaaaaaaaaaaaaaaaaa";
        String inputZipBilling= CODE;
        String inputTelephoneBilling="123456789";
        String inputCityBillings="thanh pho HCM";

        String webtest="http://live.techpanda.org";
        String eleaccountDropdown = "//span[@class='label'][normalize-space()='Account']";
        String elemyAccoutnDropdown="div[id='header-account'] a[title='My Account']";
        String eleemailAddr="//input[@id='email']";
        String elepassword="//input[@id='pass']";
        String elebtnLogin="//button[@id='send2']";
        String elemyWishlist="//div[@class='block-content']//a[normalize-space()='My Wishlist']";
        String eleaddTocCart="//span[contains(text(),'Add to Cart')]";
        String eledropdwnProvince="//select[@id='region_id']";
        String elepostCode="//input[@id='postcode']";
        String eleestimate="//span[contains(text(),'Estimate')]";
        String eleshippingcost="//label[contains(text(),'Fixed')]";
        String elefixed="//input[@id='s_method_flatrate_flatrate']";
        String eleupdateTotal ="//span[contains(text(),'Update Total')]";
        String eleshipcost ="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]";
        String eleproductcost="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]";
        String eletotalcost ="//td[2]//strong[1]";
        String eleproceedtoCheckout="//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]";
        String eleAddressBilling ="//input[@id='billing:street1']";
        String eledropdwnRegionBilling ="//select[@id='billing:region_id']";
        String eleZipBilling="//input[@id='billing:postcode']";
        String eletelephoneBilling ="//input[@id='billing:telephone']";
        String elecityBilling ="//input[@id='billing:city']";
        String elebtnBilling="//button[@onclick='billing.save()']";
        String elebtnShippingmethod="button[onclick='shippingMethod.save()'] span span";
        String eleradioMoneyOrder="//input[@id='p_method_checkmo']";
        String elebtnpaymentgInfo="//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]";
        String elebtnPlaceOrder="//button[@title='Place Order']";
        String eleResultCreatORder="div[class='page-title'] h1";
        try{

//        1. Go to http://live.techpanda.org/
            driver.get(webtest);
//        2. Click on my account link
            WebElement accountDropdown = driver.findElement(By.xpath(eleaccountDropdown));
            accountDropdown.click();
            WebElement myAccountlink = driver.findElement(By.cssSelector(elemyAccoutnDropdown));
            myAccountlink.click();
//        3. Login in application using previously created credential
            WebElement emailAddr= driver.findElement(By.xpath(eleemailAddr));
            WebElement passwr= driver.findElement(By.xpath(elepassword));
            emailAddr.sendKeys(emaillAddress);
            passwr.sendKeys(password);
            WebElement btnLogin =driver.findElement(By.xpath(elebtnLogin));
            btnLogin.click();
//        4. Click on MY WISHLIST link
            WebElement myWishlist = driver.findElement(By.xpath(elemyWishlist));
            myWishlist.click();
//         5. In next page, Click ADD TO CART link
            WebElement addTocCart = driver.findElement(By.xpath(eleaddTocCart));
            addTocCart.click();
//        6. Enter general shipping country, state/province and zip for the shipping cost estimate

            WebElement dropdwnProvince = driver.findElement(By.xpath(eledropdwnProvince));
            Select selectOption1 = new Select(dropdwnProvince);
            selectOption1.selectByVisibleText(chooseOption);
            WebElement postCode = driver.findElement(By.xpath(elepostCode));
            postCode.sendKeys(CODE);
//        7. Click Estimate
            WebElement estimate =driver.findElement(By.xpath(eleestimate));
            estimate.click();
//        8. Verify Shipping cost generated
            WebElement shippingcost=driver.findElement(By.xpath(eleshippingcost));

            Assert.assertTrue(shippingcost.isDisplayed(), "Not Created");
//        9. Select Shipping Cost, Update Total
            WebElement fixed =driver.findElement(By.xpath(elefixed));
            fixed.click();
            Thread.sleep(3000);

            WebElement updateTotal=driver.findElement(By.xpath(eleupdateTotal));
            updateTotal.click();
            Thread.sleep(3000);
//        10. Verify shipping cost is added to total
            WebElement shipcost =driver.findElement(By.xpath(eleshipcost));
            WebElement productcost= driver.findElement(By.xpath(eleproductcost));
            WebElement totalcost =driver.findElement(By.xpath(eletotalcost));
            float shipvalue = Float.parseFloat(shipcost.getText().substring(1));
            float productvalue = Float.parseFloat(productcost.getText().substring(1));
            float totalvalue = Float.parseFloat(totalcost.getText().substring(1));

            Assert.assertTrue(shipvalue+productvalue==totalvalue,"Not Added");
//        11. Click "Proceed to Checkout"
            WebElement proceedtoCheckout=driver.findElement(By.xpath(eleproceedtoCheckout));
            proceedtoCheckout.click();
//        12a. Enter Billing Information, and click Continue
            WebElement AddressBilling =driver.findElement(By.xpath(eleAddressBilling));
            WebElement dropdwnRegionBilling =driver.findElement(By.xpath(eledropdwnRegionBilling));
            WebElement ZipBilling=driver.findElement(By.xpath(eleZipBilling));
            WebElement telephoneBilling =driver.findElement(By.xpath(eletelephoneBilling));
            WebElement cityBilling =driver.findElement(By.xpath(elecityBilling));
            AddressBilling.clear();
            ZipBilling.clear();
            cityBilling.clear();
            telephoneBilling.clear();
            AddressBilling.sendKeys(inputAddressBilling);
            ZipBilling.sendKeys(inputZipBilling);
            cityBilling.sendKeys(inputCityBillings);
            telephoneBilling.sendKeys(inputTelephoneBilling);
            Select selectOption2 = new Select(dropdwnRegionBilling);
            selectOption2.selectByVisibleText(chooseOption);
            Thread.sleep(3000);
//          , and click Continue
            WebElement btnBilling = driver.findElement(By.xpath(elebtnBilling));
            btnBilling.click();
            Thread.sleep(3000);
//        13. In Shipping Method, Click Continue
            Thread.sleep(2000);
            WebElement btnShippingmethod = driver.findElement(By.cssSelector(elebtnShippingmethod));
            btnShippingmethod.click();
            Thread.sleep(4000);
//        14. In Payment Information select 'Check/Money Order' radio button. Click Continue
            WebElement radioMoneyOrder = driver.findElement(By.xpath(eleradioMoneyOrder));
            WebElement btnpaymentgInfo = driver.findElement(By.xpath(elebtnpaymentgInfo));
            radioMoneyOrder.click();
            Thread.sleep(2000);
            btnpaymentgInfo.click();
            Thread.sleep(3000);
////        15. Click 'PLACE ORDER' button
            WebElement btnPlaceOrder = driver.findElement(By.xpath(elebtnPlaceOrder));
            btnPlaceOrder.click();
            Thread.sleep(3000);
////        16. Verify Order is generated. Note the order number
            WebElement ResutlCreateOrder =driver.findElement(By.cssSelector(eleResultCreatORder));
            Assert.assertTrue(ResutlCreateOrder.getText().equals("YOUR ORDER HAS BEEN RECEIVED."),"Not Created");
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
