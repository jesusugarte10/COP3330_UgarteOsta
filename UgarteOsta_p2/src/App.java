//Made by Jesus Ugarte - Object Oriented Programming Class

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class App{

    //Declaring the Scanner fucntion and a funciton to format the double when printing
    private static Scanner scan = new Scanner(System.in);
    private static DecimalFormat df2 = new DecimalFormat("#.##");


    //Main Method
    public static void main(String[] args) {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    //Display Bmi Info given the sum of two numbers
    private static void displayBmiInfo(BodyMassIndex bmi) {

        double value = bmi.getSum();

        System.out.print("The BMI is: " + df2.format(value) + bmi.getCategory());
    }

    //Printing BMI average
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {

        double totalSum = 0;

        for (int i = 0; i < bmiData.size(); i++){
            totalSum += bmiData.get(i).getSum();
        }

        System.out.println("The BMI Average is: " +  df2.format(totalSum / bmiData.size()) );
    }

    
    public static boolean moreInput() {

        char ch = '0';

        //Checking if value of ch is wether y or n
        while(ch != 'Y' || ch != 'N'){

            System.out.println("Add Input? Y or N");

            ch = scan.next().charAt(0);
            scan.nextLine();

            //Failcheck to make sure we convert to uppercase
            ch = Character.toUpperCase(ch);

            if(ch == 'Y'){

                return true;
            }
            if(ch == 'N'){

                return false;
            }
        }
        //Returning Values
        return false;
    }


    public static double getUserHeight(){

        double height = -1;

        //Checking that numbers are positive
        while (height < 0){

            System.out.println("Please Enter height in inches:");
            height = scan.nextDouble();
            scan.nextLine();
        }
        
        return height;
    }

    public static double getUserWeight(){

        double weight = -1;

        //Checking that numbers are positive
        while (weight < 0){

            System.out.println("Please Enter weight in pounds:");
            weight = scan.nextDouble();
            scan.nextLine();
        }

        return weight;
    }

}