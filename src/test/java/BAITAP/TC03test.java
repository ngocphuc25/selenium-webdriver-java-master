//Test Steps:
//
//        1. Go to http://live.techpanda.org/
//
//        2. Click on �MOBILE� menu
//
//        3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
//
//        4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
//
//        "The requested quantity for "Sony Xperia" is not available.
//
//        5. Verify the error message
//
//        6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
//
//        7. Verify cart is empty
package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03test {
    @Test
    public static void TestTC03(){
        WebDriver driver = driverFactory.getChromeDriver();
        try{
//            1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org");

//            2. Click on �MOBILE� menu
            WebElement btnMobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
            btnMobile.click();
//            3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
            WebElement btnAddToCartXperia = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button"));
            btnAddToCartXperia.click();
//            4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
            WebElement qTYElem = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]"));
            qTYElem.sendKeys("000");

            Thread.sleep(2000);
            WebElement btnUpdate = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span"));
            btnUpdate.click();
//            Expected that an error is displayed
            WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(),'Some of the products cannot be ordered in requeste')]"));
//

            Assert.assertTrue(errorMessage.getText().equals("Some of the products cannot be ordered in requested quantity."),"The requested quantity for Sony Xperia is not available.");
            WebElement btnEmptyCard = driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]"));
            btnEmptyCard.click();

            WebElement emptyCartMessage = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1"));


            Assert.assertTrue(emptyCartMessage.getText().equals("SHOPPING CART IS EMPTY"),"Not equals empty cart");
            Thread.sleep(2000);
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
