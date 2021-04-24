
//Assignment 3
package HW;

import Day2_030721.WhileLoopExample;

public class Day4Assignment3 {
    public static void main(String[] args) {

        //Variables
        String[] Cities;

        Cities = new String[4];
        Cities[0] = "Brooklyn";
        Cities[1] = "Queens";
        Cities[2] = "Manhattan";
        Cities[3] = "Staten";

        int i = 0;

        while( i < Cities.length) {

            if (Cities[i] == "Brooklyn"){
                System.out.println("My city is " + Cities[i]);
            } else if (Cities[i] == "Manhattan") {
                System.out.println("My city is " + Cities[i]);
            }
            //counter
            i = i+1;
        }//end of loop statement

    }//end of main method
}//end of java class
