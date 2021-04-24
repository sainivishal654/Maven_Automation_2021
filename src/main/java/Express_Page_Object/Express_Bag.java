package Express_Page_Object;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Bag extends Abstract_Class {
    ExtentTest logger;
    public Express_Bag(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of logger

    //define all the elements
    @FindBy(xpath = "//*[@id='qdd-0-quantity']")
    WebElement quantity;
    @FindBy(xpath = "//button[@class='btn _9yfmt _194FD _2tFXQ _1s_-v']")
    WebElement checkout;
    @FindBy(xpath = "//*[text()='Checkout as Guest']")
    WebElement guestcheckout;


    //create a method to add quantity
    public void selectQuantity(String userValue){
        Reusable_Actions_PageObject.dropdownByText(driver,quantity,userValue,logger,"Quantity");
    }//end of selecting quantity

    //create a method to click on checkout
    public void clickonCheckout(){
        Reusable_Actions_PageObject.clickOnElement(driver,checkout,logger,"Checkout");
    }//end of selecting quantity

    //create a method to click on checkout as guest
    public void clickonGuestCheckout(){
        Reusable_Actions_PageObject.clickOnElement(driver,guestcheckout,logger,"Guest Checkout");
    }//end of guest checkout
}//end of java class
