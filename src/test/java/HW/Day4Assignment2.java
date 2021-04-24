
//Assignment2
package HW;

public class Day4Assignment2 {
    public static void main(String[] args) {


        String gradeSystem = "A";
        switch (gradeSystem) {
            case "A":
                System.out.println("Excellent");
                break;
            case "B":
                System.out.println("Well Done");
                break;
            case "C":
                System.out.println("Satisfactory");
                break;
            case "D":
                System.out.println("Passed");
                break;
            case "E":
                System.out.println("Fail");
                break;
            default:
                System.out.println("Invalid grade: " + gradeSystem);

        }//end of case statement
    }//end of main method
}//end of java class
