/*
Made By Jesus Ugarte
*/

import java.util.Scanner;

public class Encrypter{

    Scanner scan = new Scanner(System.in);

    public static void main( String[] args) {

        Scanner scan = new Scanner(System.in);
        //Creating the scanner

        System.out.println("Please enter 4 digits\n");
        String word = scan.nextLine();

        //If number lenght is not equal to 4 keep asking
        while(word.length() != 4)
        {
            System.out.println("Please enter 4 digits\n");
            word = scan.nextLine();
        }

        //Calling the function from the other classes
        String ecryptedValue = encrypt(word);
        System.out.println(ecryptedValue);

        scan.close();
    }

    public static String encrypt(String word) {

        int num = Integer.parseInt(word);

        //Creating Array
        int[] array = new int[5];

        //Filling the Array
        for (int i = 4; i > 0;i--)
        {   
            array[i] = num%10;
            num = num/10;
            array[i] = (array[i] + 7) % 10 ;
        }

            //Swapping Numbers
            int temp = array[1];
            array[1] = array[3];
            array[3] = temp;
            temp = array[2];
            array[2] = array[4];
            array[4] = temp;

            //creating array to be filled
            String str = "";

            //Printing Values
            for ( int i= 1; i < 5;i++)
            {  
                str += array[i];
            }
    
            return str;
    }
}