package HW;

import Express_Page_Object.Express_Bag;
import Express_Page_Object.Express_BaseClass;
import Reusable_library.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Express_PageObject extends Abstract_Class {

    @Test

    public void Express_Shopping() throws InterruptedException {
        driver.navigate().to("https://www.express.com");
        Thread.sleep(3000);

        Express_BaseClass.express_homePage().closePopup();
        Express_BaseClass.express_homePage().HoverOverMenSection();
        Express_BaseClass.express_homePage().clickonSweatshirtAndHoodies();
        Thread.sleep(3000);


        Express_BaseClass.express_sweatShirtandHoodies().clickonSweaters();

        Express_BaseClass.express_sweaters().clickonFirstSweater();
        Express_BaseClass.express_sweaters().clickonMsize();
        Express_BaseClass.express_sweaters().clickonAddtoBag();
        Thread.sleep(1500);
        Express_BaseClass.express_sweaters().clickonViewbag();
        Thread.sleep(1500);

        Express_BaseClass.express_bag().selectQuantity("2");
        Express_BaseClass.express_bag().clickonCheckout();
        Express_BaseClass.express_bag().clickonGuestCheckout();
        Thread.sleep(1500);

        Express_BaseClass.express_checkout().enterFirstName("Vishal");
        Express_BaseClass.express_checkout().enterLastName("Saini");
        Express_BaseClass.express_checkout().enterEmail("sainivish@gmail.com");
        Express_BaseClass.express_checkout().confirmEmailAddres("sainivish@gmail.com");
        Express_BaseClass.express_checkout().enterPhoneNumber("8563080763");
        Express_BaseClass.express_checkout().clickonContinue();
        Express_BaseClass.express_checkout().selectCountry("United States");
        Express_BaseClass.express_checkout().enterAddress("5643 Magnolia ave");
        Express_BaseClass.express_checkout().enterZipcode("08109");
        Express_BaseClass.express_checkout().enterCity("Pennsauken");
        Express_BaseClass.express_checkout().selectState("NJ");
        Express_BaseClass.express_checkout().clickonContinue1();

        Express_BaseClass.express_checkout().clickonConfirmShippingMethod();
        Express_BaseClass.express_checkout().enterCreditCardNumber("4737564754782345");
        Express_BaseClass.express_checkout().enterExpMonth("12");
        Express_BaseClass.express_checkout().enterExpYear("24");
        Express_BaseClass.express_checkout().enterCVV("213");
        Express_BaseClass.express_checkout().clickonPlaceOrder();
        Express_BaseClass.express_checkout().CaptureErrorMessage();


    }//end of express checkout
    }//end of java class
