package Google_Page_Object;


import Reusable_library.Abstract_Class;

public class Base_Class extends Abstract_Class {


    //this page class is a static reference for the page object classes
    //so I can use it on my test class
    public static Google_Home googleHomePage(){
        Google_Home googleHomePage = new Google_Home(driver);
        return  googleHomePage;
    }//end of googleHomePage method


}
