package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TC01test {
        @Test
        public static void TestTC01(){
        WebDriver driver = driverFactory.getChromeDriver();
        try

        {
            driver.get("http://live.techpanda.org");

            //        Step 2. Verify Title of the page
            String pageURL = driver.getCurrentUrl();
            String pageTitle = driver.getTitle();

            System.out.println(pageURL);
            System.out.println(pageTitle);
//            Step 3. Click on -> MOBILE -> menu
            WebElement clickMobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
            clickMobile.click();
            //debug purpose only
            //        Step 4. In the list of all mobile , select SORT BY -> dropdown as name
            WebElement clickSort = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
            //4. Init a Select Option instance
            clickSort.click();
            WebElement sortName = driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select > option:nth-child(2)"));
            sortName.click();
            //select options in dropdown list by Text

            //        Step 5. Verify all products are sorted by name
            List<WebElement> ElementList = driver.findElements(By.className("product-name"));
            for (WebElement o : ElementList){
                System.out.println(o.getText());
            }
            //Or select option in dropdown list by value
            //debug purpose only



            //debug purpose only
            Thread.sleep(2000);
        }catch(Exception e) {
            e.printStackTrace();

        }
        driver.quit();
    }


}
