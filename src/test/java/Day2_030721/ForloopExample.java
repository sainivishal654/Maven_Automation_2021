package Day2_030721;

public class ForloopExample {
    public static void main(String[] args) {
        String[] cities, houseAddress;

        cities = new String [4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";

        houseAddress = new String[4];
        houseAddress[0] = "222";
        houseAddress[1] = "345";
        houseAddress[2] = "633";
        houseAddress[3] = "565";


        //set your iteration to loop through all the values form cities

        for(int i =0;i< 4; i++){
            //print out all values in one print statement

            System.out.println("My city is " + cities[i] + ", and my" + " house address is " + houseAddress[i]);
        }//end of for loop

    }//end of main
}//end of java class
