import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    static Scanner scan = new Scanner(System.in);

    public ContactApp() throws FileNotFoundException {

    }

    public void mainContactMenu() throws FileNotFoundException {

        ContactList list = new ContactList();

        boolean exit = false;

        while (!exit) {
            System.out.print("\n\nContact List Main Menu\n---------\n");
            System.out.print("\n1) create a new list\n2) load an existing list\n3) quit\n\n> ");

            int choice = getChoice();

            switch (choice) {
                
                case 1:
                    System.out.print("\nnew contact list has been created");
                    mainContactApp(list);
                    break;

                case 2:
                    scan.nextLine();
                    System.out.print("Enter the filename to load: ");
                        String Filename = scan.next().toLowerCase();

                        while(!Filename.endsWith("_contact.txt")){
                            System.out.print("\nWARNING: FILE SHOULD END WITH _contact.txt");
                            System.out.print("\nEnter the filename to load: ");
                            Filename = scan.next().toLowerCase();
                        }

                    try {
                        list = list.loadContactFile(Filename);
                    } catch (IOException e) {
                        System.out.println("WARNING: UNABLE TO LOAD FILE - TRY AGAIN");;
                    }
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("WARNING: Please Enter valid choice");
            }
        }
    }

    public void mainContactApp(ContactList list) throws FileNotFoundException {

        String name, lastName, phone, email;
        int index;
        boolean exit = false;
            
        while (!exit) 
        {  
            System.out.print("\n\nList Operation Menu\n---------\n");
            System.out.print("\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) save the current list\n6) quit to the main menu\n\n> ");
            
            int choice = getChoice();

            switch (choice) {

                case 1:
                    list.printList();
                    break;

                case 2:
                    scan.nextLine();
                    System.out.print("\n\nFirst name: ");
                    name = scan.nextLine();
                    System.out.print("Last name name: ");
                    lastName = scan.nextLine();
                    System.out.print("Phone Number (xxx-xxx-xxxx): ");
                    phone = scan.nextLine();
                    System.out.print("Email address (x@y.z): ");
                    email = scan.nextLine();

                    try{ 
                        ContactItem data = new ContactItem(name, lastName, phone, email);
                        list.add(data);
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("\n\nWARNING: INVALID INPUT TRY AGAIN");
                    }
                    break;

                case 3:

                    if(list.isContactListEmpty()){
                        System.out.println("\n\nWARNING: LIST EMPTY");
                        break;
                    }

                    list.printList();

                    scan.nextLine();
                    System.out.print("\n\nWhich contact will you edit?: ");
                    index = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter a new first name for contact " + index + ": ");
                    name = scan.nextLine();
                    System.out.print("Enter a new last name name for contact " + index + ": ");
                    lastName = scan.nextLine();
                    System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + ": ");
                    phone = scan.nextLine();
                    System.out.print("Enter a new email address (x@y.z) for contact " + index + ": ");
                    email = scan.nextLine();

                    try{
                        list.editContactList(index, name, lastName, phone, email);
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("WARNING: INVALID INPUT TRY AGAIN");
                    }
                    break;

                case 4:

                    list.printList();

                    if(list.isContactListEmpty()){
                        System.out.println("\n\nWARNING: LIST EMPTY");
                        break;
                    }
                    scan.nextLine();
                    System.out.print("\n\nWhich contact will you remove?: ");
                    index = scan.nextInt();
                    try{  
                        list.remove(index);
                    }catch (IndexOutOfBoundsException ex){
                        System.out.println("WARNING: INDEX OUT OF BOUNDS");
                    }

                    break;

                case 5:
                    scan.nextLine();
                    System.out.print("\n\nEnter the filename to save as: ");
                    String newFilename = scan.next().toLowerCase();

                    if(newFilename.endsWith("_contact.txt") && !list.isContactListEmpty())
                        list.save(newFilename);
                    else
                        System.out.println("WARNING: INVALID FILENAME \n Should end with '_contact.txt' ");
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("WARNING: Please Enter valid choice");

            }
        }
    }
    
    private int getChoice(){

        while(true){ 
            try{   
                int choice = scan.nextInt();
                return choice;
            }catch(InputMismatchException ex){
                scan.nextLine();
                System.out.println("WARNING: NOT A NUMBER\nPlease Enter a number Below ");
            }
        }
    }
}
