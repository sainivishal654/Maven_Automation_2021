package Day2_030721;

public class zActionItem {
    public static void main(String[] args) {

        // declare all variables

        String []zipcode;
        int []  streetNumber;


        //variables with values
        zipcode = new String [4];
        zipcode[0] = "08101";
        zipcode[1] = "08102";
        zipcode[2] = "08103";
        zipcode[3] = "08104";

        streetNumber = new int[4];
        streetNumber[0] = 5653;
        streetNumber[1] = 5654;
        streetNumber[2] = 5655;
        streetNumber[3] = 5656;

        //iteration
        for(int i=0; i < zipcode.length; i++){

            //print values in one statement
            System.out.println("My zip code is: " + zipcode[i]+"," + " and my street number is: " + streetNumber[i] +".");
        }//end of for loop
    }//end of main
}//end of java class
