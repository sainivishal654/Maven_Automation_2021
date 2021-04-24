package Express_Page_Object;

import Reusable_library.Abstract_Class;
import Reusable_library.Reusable_Actions_PageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Express_SweatShirtAndHoodies extends Abstract_Class {

    //we have to declare a local logger so we can use it on the page
    ExtentTest logger;
    public Express_SweatShirtAndHoodies(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class

    //define all the WebElement you need using @FindBy concept
    @FindBy(xpath = "//a[text()='Sweaters']")
    WebElement sweaters;

    //Create a method to click on Sweatshirt
    public void clickonSweaters(){
        Reusable_Actions_PageObject.clickOnElement(driver,sweaters,logger,"Sweaters");
    }//end of sweater webpage







}//end of java class

