package BAITAP;

//1. Goto http://live.techpanda.org/
//
//        2. Click on �MOBILE� menu
//
//        3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
//
//        4. Click on Sony Xperia mobile
//
//        5. Read the Sony Xperia mobile from detail page.
//
//        6. Compare Product value in list and details page should be equal ($100).
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TC02test {



@Test
    public static void TestTC02(){
        WebDriver driver = driverFactory.getChromeDriver();
        try
        {
            driver.get("http://live.techpanda.org");


//               2. Click on �MOBILE� menu

            WebElement btnMobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
            btnMobile.click();
            //debug purpose only
            //       3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
            WebElement sonyXperiaPriceListPage = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span"));
            String priceInListPage = sonyXperiaPriceListPage.getText();
//            4. Click on Sony Xperia mobile
            WebElement btnSonyXperia = driver.findElement(By.linkText("SONY XPERIA"));
            btnSonyXperia.click();
//        5. Read the Sony Xperia mobile from detail page.
            WebElement sonyXperiaPriceDetailPage = driver.findElement(By.className("price"));
            String priceInDetailPage = sonyXperiaPriceDetailPage.getText();
//            6. Compare Product value in list and details page should be equal ($100).
            assert priceInListPage.equals(priceInDetailPage) : "Not equal";
            //debug purpose only
            Thread.sleep(2000);
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}
