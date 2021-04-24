package Express_Page_Object;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_Checkout extends Abstract_Class {

    ExtentTest logger;
    public Express_Checkout(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of logger

    //define all the element
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstname;
    @FindBy(xpath = "//*[@name='lastname']")
    WebElement lastname;
    @FindBy(xpath = "//input[@name='email']")
    WebElement email;
    @FindBy(xpath = "//input[@aria-label='Confirm Email Address']")
    WebElement confirmemail;
    @FindBy(xpath = "(//input[@name='phone'])")
    WebElement phonenumber;
    @FindBy(xpath = "//button[contains(@class,'btn _9yfmt')]")
    WebElement btncontinue;
    @FindBy(xpath = "//select[@name='shipping.countryCode']")
    WebElement country;
    @FindBy(xpath = "//input[@name='shipping.line1']")
    WebElement address;
    @FindBy(xpath = "//input[@name='shipping.postalCode']")
    WebElement zipcode;
    @FindBy(xpath = "//input[@name='shipping.city']")
    WebElement city;
    @FindBy(xpath = "//select[@name='shipping.state']")
    WebElement state;
    @FindBy(xpath = "//button[@class='btn _9yfmt _194FD _2tFXQ _2SogC']")
    WebElement btncontinue1;
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement confirmshippingmethod;
    @FindBy(xpath = "//input[@id='creditCardNumberInput']")
    WebElement creditcardnumber;
    @FindBy(xpath = "//select[@name='expMonth']")
    WebElement expmonth;
    @FindBy(xpath = "//select[@name='expYear']")
    WebElement expyear;
    @FindBy(xpath = "//input[@name='cvv']")
    WebElement cvv;
    @FindBy(xpath = "//*[text()='Place Order']")
    WebElement placeorder;
    @FindBy(xpath = "//div[@class='xnY7x notification']")
    WebElement errormsg;

    //create a method to enter first name
    public void enterFirstName(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver,firstname,userValue,logger,"First Name");
    }//end of entering first name

    //create a method to enter last name
    public void enterLastName(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver,lastname,userValue,logger,"Last Name");
    }//end of entering last name

    //create a method to enter email
    public void enterEmail(String userValue){
        Reusable_Actions_PageObject.Hover_Click_Send_BYIndex(driver,email,0,userValue,logger,"Email");
    }//end of entering email

    //create a method to confirm email
    public void confirmEmailAddres(String userValue){
        Reusable_Actions_PageObject.Hover_Click_Send_BYIndex(driver,confirmemail,0,userValue,logger,"Confirm Email");
    }//end of confirming email

    //create a method to enter phone number
    public void enterPhoneNumber(String userValue){
        Reusable_Actions_PageObject.Hover_Click_Send_BYIndex(driver,phonenumber,0,userValue,logger,"Phone Number");
    }//end of entering phone number

    //create a method to click continue
    public void clickonContinue(){
        Reusable_Actions_PageObject.clickOnElement(driver,btncontinue,logger,"Continue");
    }//end of continue method

    //create a method to select country
    public void selectCountry(String userValue){
        Reusable_Actions_PageObject.dropdownByText(driver,country,userValue,logger,"Country");
    }//end of selecting country

    //create a method to enter address
    public void enterAddress(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver,address,userValue,logger,"Address");
    }//end of address method

    //create a method to enter zipcode
    public void enterZipcode(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver,zipcode,userValue,logger,"Zipcode");
    }//end of zipcode method

    //create a method to enter city
    public void enterCity(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver,city,userValue,logger,"Shipping City");
    }//end of zipcode method

    //create a method to select state
    public void selectState(String userValue){
        Reusable_Actions_PageObject.dropdownByText(driver,state,userValue,logger,"State");
    }//end of state method

    //create a method to click continue
    public void clickonContinue1(){
        Reusable_Actions_PageObject.clickOnElement(driver,btncontinue1,logger,"Continue");
    }//end of continue method

    //create a method to click confirm shipping method
    public void clickonConfirmShippingMethod(){
        Reusable_Actions_PageObject.clickOnElement(driver,confirmshippingmethod,logger,"Confirm Shipping Method");
    }//end of shipping method

    //create a method to enter credit card number
    public void enterCreditCardNumber(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver,creditcardnumber,userValue,logger,"Credit Card");
    }//end of credit card method

    //create a method to enter exp month
    public void enterExpMonth(String userValue){
        Reusable_Actions_PageObject.dropdownByText(driver,expmonth,userValue,logger,"Exp Month");
    }//end of credit card exp month

    //create a method to enter exp year
    public void enterExpYear(String userValue){
        Reusable_Actions_PageObject.dropdownByText(driver,expyear,userValue,logger,"Exp Year");
    }//end of credit card exp year

    //create a method to enter credit card cvv
    public void enterCVV(String userValue){
        Reusable_Actions_PageObject.sendKeysMethod(driver,cvv,userValue,logger,"Credit Card CVV");
    }//end of credit card cvv method

    //create a method to click on place order
    public void clickonPlaceOrder() {
        Reusable_Actions_PageObject.clickOnElement(driver, placeorder, logger, "Place Order");
    }//end of placing order method
        //create method to capture any error
        public void CaptureErrorMessage(){
           String ErrorMsg = Reusable_Actions_PageObject.CaptureText(driver,errormsg,logger,"Error Messgage");
            logger.log(LogStatus.INFO,"The error message is " + ErrorMsg );
        }//end of capture error message method

}//end of java class
