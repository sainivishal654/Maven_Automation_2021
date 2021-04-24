package Day7_032721;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");
        cities.add("Bronx");

        for (int i =0; i<cities.size();i++){
            System.out.println("My city is " + cities.get(i));
        }// end of loop


    }//end of main method
}// end of java class



/**array list gives us the felexibility to add variables wihtout defining**/