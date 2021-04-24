package Day12_041121;

import Day9_040321.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestNg_Assertions {

    public TestNg_Assertions() throws IOException, InterruptedException {
    }

    @Test
    public void assertions() throws IOException, InterruptedException {
        WebDriver driver = Reusable_Methods.defineTheDriver();
        driver.navigate().to("http://www.google.com");

        //using hard assert verfy the google title
        //Assert.assertEquals("google",driver.getTitle());

        //soft asswert
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals("google", driver.getTitle());

        //enter something on google search
        Reusable_Methods.sendKeysMethod(driver,"//*[@name='q']","Honda","Google Search");

        //assertAll should be the last step on your test
        softassert.assertAll();
    }//end of test
}//end of java class