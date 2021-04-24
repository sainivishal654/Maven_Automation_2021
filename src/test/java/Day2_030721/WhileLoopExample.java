package Day2_030721;

public class WhileLoopExample {
    public static void main(String[] args) {
        String[] cities;

        cities = new String [4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";

        //set the initializer 1
        int i = 0;

        //set the gate keeper/end point for while
        while(i < cities.length) {

            System.out.println("My city is " + cities[i]);

            //set the counter
            i = i + 1;
        }//end of while
    } //end of main
}//end of java class
