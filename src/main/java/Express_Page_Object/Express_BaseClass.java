package Express_Page_Object;

import Google_Page_Object.Google_Home;
import Reusable_library.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;

public class Express_BaseClass extends Abstract_Class {
    //this page class is a static reference for the page object classes
    //so I can use it on my test class
    public static Express_HomePage express_homePage(){
        Express_HomePage express_homePage= new Express_HomePage(driver);
        return  express_homePage;
    }//end of express_homepage method

    public static Express_SweatShirtAndHoodies express_sweatShirtandHoodies(){
        Express_SweatShirtAndHoodies express_sweatShirtandHoodies = new Express_SweatShirtAndHoodies(driver);
        return  express_sweatShirtandHoodies;
    }//end of express_sweatshirtandhoodies method

    public static Express_Sweaters express_sweaters(){
        Express_Sweaters express_sweaters = new Express_Sweaters(driver);
        return  express_sweaters;
    }//end of express_sweaters method

    public static Express_Bag express_bag(){
        Express_Bag express_bag = new Express_Bag(driver);
        return  express_bag;
    }//end of express_bag method

    public static Express_Checkout express_checkout(){
        Express_Checkout express_checkout= new Express_Checkout(driver);
        return  express_checkout;
    }//end of express_checkout method


}//end of java class
