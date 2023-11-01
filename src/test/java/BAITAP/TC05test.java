//1. Go to http://live.techpanda.org/
//
//        2. Click on my account link
//
//        3. Click Create an Account link and fill New User information excluding the registered Email ID.
//
//        4. Click Register
//
//        5. Verify Registration is done. Expected account registration done.
//
//        6. Go to TV menu
//
//        7. Add product in your wish list - use product - LG LCD
//
//        8. Click SHARE WISHLIST
//
//        9. In next page enter Email and a message and click SHARE WISHLIST
//
//        10.Check wishlist is shared. Expected wishlist shared successfully.

package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05test {
    @Test
    public static void TestTC05(){
        WebDriver driver = driverFactory.getChromeDriver();
        String RegisterName="Phuc";
        String RegisterMiddleName="Ngoc";
        String RegisterLastName="Tran";
        String RegisterEmail="phuctmnse172047@fpt.edu.vn";
        String RegisterPassword="123456";
        String RegisterConfirmPassword="123456";
        String emails="phuctmnse172099@fpt.edu.vn,tranminhngocphuc16@gmail.com";
        String messages="";


        String eleMyaccountlink="div[class='footer'] a[title='My Account']";
        String elebtnCreateAccount="//a[@title='Create an Account']";
        String elebtnRegister="//button[@title='Register']";
        String eleCheckRegistration="//span[normalize-space()='Thank you for registering with Main Website Store.']";
        String elebtnTV="//a[normalize-space()='TV']";
        String eleAddtpWishlistLCD="//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]";
        String eleshareWishList ="//span[contains(text(),'Share Wishlist')]";
        String eleemailshared ="//textarea[@id='email_address']";
        String eleMessageshared="//textarea[@id='message']";
        String elebtnShareWishlist="//span[contains(text(),'Share Wishlist')]";
        String elecheckShareWishlist="//li[@class='success-msg']//ul//li";
        try{
//            1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org");
//            2. Click on my account link
            WebElement myAccountlink = driver.findElement(By.cssSelector(eleMyaccountlink));
            myAccountlink.click();
//            3. Click Create an Account link and fill New User information excluding the registered Email ID.
            WebElement btnCreateAccount =driver.findElement(By.xpath(elebtnCreateAccount));
            btnCreateAccount.click();
            Thread.sleep(2000);
//            fill New User information excluding the registered Email ID.
                WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
                WebElement middleName = driver.findElement(By.xpath("//input[@id='middlename']"));
                WebElement  lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
                WebElement email  =driver.findElement(By.xpath("//input[@id='email_address']"));
                WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
                WebElement confirmPass =driver.findElement(By.xpath("//input[@id='confirmation']"));

                firstName.sendKeys(RegisterName);
                middleName.sendKeys(RegisterMiddleName);
                lastName.sendKeys(RegisterLastName);
                email.sendKeys(RegisterEmail);
                password.sendKeys(RegisterPassword);
                confirmPass.sendKeys(RegisterConfirmPassword);

            Thread.sleep(3000);
//            4. Click Register
            WebElement btnRegister=driver.findElement(By.xpath(elebtnRegister));
            btnRegister.click();
//            5. Verify Registration is done. Expected account registration done.

           Assert.assertEquals(driver.findElement(By.xpath(eleCheckRegistration)).getText(),"Thank you for registering with Main Website Store.","errpr");

            Thread.sleep(2000);
//        6. Go to TV menu
            WebElement btnTV= driver.findElement(By.xpath(elebtnTV));
            btnTV.click();
//        7. Add product in your wish list - use product - LG LCD
            WebElement AddtoWishlistLCD=driver.findElement(By.xpath(eleAddtpWishlistLCD));
            AddtoWishlistLCD.click();
            Thread.sleep(2000);
//        8. Click SHARE WISHLIST
            WebElement ChooseshareWishList= driver.findElement(By.xpath(eleshareWishList));
            ChooseshareWishList.click();
//        9. In next page enter Email and a message and click SHARE WISHLIST
            WebElement  emailshared = driver.findElement(By.xpath(eleemailshared));
             WebElement messageshared= driver.findElement(By.xpath(eleMessageshared));

             emailshared.sendKeys(emails);
             messageshared.sendKeys(messages);

             WebElement btnShareWishlist=driver.findElement(By.xpath(elebtnShareWishlist));
             btnShareWishlist.click();
             //        10.Check wishlist is shared. Expected wishlist shared successfully.
            WebElement checkShareWishlist=driver.findElement(By.xpath(elecheckShareWishlist));
            Assert.assertEquals(checkShareWishlist.getText(),"Your Wishlist has been shared.","errror");
             Thread.sleep(4000);
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
