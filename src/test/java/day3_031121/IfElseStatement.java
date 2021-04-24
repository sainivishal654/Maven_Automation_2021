package day3_031121;

public class IfElseStatement {
    public static void main(String[] args) {
        //declare the integer variables
        int a,b;
        a=4;
        b=3;

        //1.using if condition, verify that a i less than b
        if (a<b){
            //System.out.println("a is less than b");
        }//end of if condition

        //2.using if else condition, verify if a is less b, else it is greater or equal to b
        if (a<b){
            System.out.println("a is less than b");
        }else{
            System.out.println("a is either greater than b or equal to b");

            //3.using <= operator verify if a less than b or is equal to b

            if (a <=b){
                System.out.println("a is less than b or a is equal to b");
            }//end of if condition

        }//end of ifElse condition
    }//end of main method
}//end of java class
