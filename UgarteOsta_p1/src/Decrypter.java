/*
Made By Jesus Ugarte
*/

import java.util.Scanner;

public class Decrypter {

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
        String decryptedValue = decrypt(word);
        System.out.println(decryptedValue);

        scan.close();
    }

    public static String decrypt(String word) {

        int num = Integer.parseInt(word);

        //Initializing array
        int[] array = new int[5];
        
        //Filling array
        for (int i = 4; i > 0;i--)
        {   
            array[i] = num%10;
            num = num/10;
            array[i] = (array[i] +3 ) % 10 ;
        }

            //Swapping Values 
            int temp = array[1];
            array[1] = array[3];
            array[3] = temp;
            temp = array[2];
            array[2] = array[4];
            array[4] = temp;

            //Creating string Value
            String str = "";

            //Printing Values
            for ( int i= 1; i < 5;i++)
            {  
                str += array[i];
                //Adding characters to string
            }

            return str;
    }
}
