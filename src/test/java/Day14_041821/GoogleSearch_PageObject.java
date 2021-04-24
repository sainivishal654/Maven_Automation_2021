package Day14_041821;

import Express_Page_Object.Express_BaseClass;
import Google_Page_Object.Base_Class;
import Reusable_library.Abstract_Class;
import org.testng.annotations.Test;

public class GoogleSearch_PageObject extends Abstract_Class {


    @Test
    public void googleSearch(){
        driver.navigate().to("https://www.google.com");
        Base_Class.googleHomePage().EnterKeywordOnGoogleSearch("cars");
        Base_Class.googleHomePage().SubmitOnGoogleSearchButton();
    }//end of test

}//end of java class
