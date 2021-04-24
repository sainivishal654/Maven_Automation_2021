package Day2_030721;

public class DynamicArray {
    public static void main(String[] args) {
        //declare countries variables
        String[] countries;
        //declare int variable
        int[] streetNumber;

        //set the length of the array for number of data it can store
        countries = new String [4];
        countries[0]= "USA";
        countries[1] = "Spain";
        countries[2] = "Bangladesh";
        countries[3] = "India";

        //set the Length of the array for the street number
        streetNumber = new int [4];
        streetNumber [0] = 222;
        streetNumber [1] = 333;

        //print use from countries list
        System.out.println("Country is " +countries[0] + ", and " + "streetNumber is " +streetNumber[1]);
    }
}
