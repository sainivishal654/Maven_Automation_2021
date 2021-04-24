package Day2_030721;

public class zPractice {//While Loop

    public static void main(String[] args) {

        int[] zipcode, streetNumber;

        streetNumber = new int[4];
        streetNumber[0] = 5653;
        streetNumber[1] = 5654;
        streetNumber[2] = 5655;
        streetNumber[3] = 5656;


        zipcode = new int [4];
        zipcode[0] =19723;
        zipcode[1] = 134092;
        zipcode[2] = 197922;
        zipcode[3] = 12328012;

        //set the initializer 1
        int i = 0;

        //set the gate keeper/end point for while
        while(i < streetNumber.length) {

            System.out.println("My street number is " + streetNumber[i] + "," +" and my zip code is " +zipcode[i] + ".");

            //set the counter
            i = i + 1;
        }//end of while
    } //end of main
}//end of java class

