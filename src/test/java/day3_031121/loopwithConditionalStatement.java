package day3_031121;

public class loopwithConditionalStatement {
    public static void main(String[] args) {

        String[] country = new String[4];
        country[0]= "USA";
        country[1]= "Canada";
        country[2] = "Bangladesh";
        country[3] = "India";

        //using for loop print only when country is USA or Canada
        for(int i =0; i < country.length; i++){
            if(country[i]== "USA"){
                System.out.println("Country is " + country[i]);
            } else if(country[i] == "Canada") {
                System.out.println("Country is " + country[i]);
            }//end of conditional Statement
        }//end of loop method

        //using for loop with case statement print only when country is USA or Canada

        for(int i =0; i < country.length; i++){
            switch (country[i]) {
                case "USA":
                    System.out.println("Country is " + country[i]);
                    break;
                case "Canada":
                    System.out.println("Country is " + country[i]);
                    break;

            }//end of case statement
        }//end of for loop



    }//end of main method
}//end of java class
