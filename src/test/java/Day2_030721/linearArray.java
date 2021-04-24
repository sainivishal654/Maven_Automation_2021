package Day2_030721;

public class linearArray {
    public static void main(String[] args) {
        //declare the variables
        String[] cities; //you declare as many variable as you want
        int[] streetNumber;
        cities = new String []{"Brooklyn", "Queens", "Manhattan", "Bronx", "Staten Island"};
        streetNumber = new int[] {222, 345, 567, 1000};

        //I want to print queens and street number as 222;

        System.out.println("My city is " +cities[1] + " and street number is " +streetNumber[0]);

    }//end of main method
}//end of java class
