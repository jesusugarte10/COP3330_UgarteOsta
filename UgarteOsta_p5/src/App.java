import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        boolean exit = false;

        while (!exit) {
            System.out.print("\nSelect Your Application\n---------\n");
            System.out.print("\n1) Task list\n2) Contact list\n3) quit\n\n> ");

            int choice = getChoice();

            switch (choice) {
                case 1:
                    TaskApp taskApp = new TaskApp();
                    taskApp.mainTaskMenu();
                    break;

                case 2:
                    ContactApp contactApp = new ContactApp();
                    contactApp.mainContactMenu();
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("WARNING: Please Enter valid choice");
            }
        }
        System.out.println("\nProcess finished with exit code 0");
    }

    private static int getChoice(){

        while(true){ 
            try{   
                int choice = scan.nextInt();
                return choice;
            }catch(InputMismatchException ex){
                scan.nextLine();
                System.out.println("WARNING: NOT A NUMBER\n\nPlease Enter a number Below ");
            }
        }
    }

}
