import java.util.Scanner;
import java.io.*;

public class App {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, IllegalAccessException {

        boolean exit = false;
        String Data = new String();
        TaskList list = new TaskList(Data);

        while (!exit) {
            System.out.print("\nMain Menu\n---------\n");
            System.out.print("\n1) create a new list\n2) load an existing list\n3) quit\n\n> ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nnew task list has been created");
                    Data = TaskList(Data);
                    break;

                case 2:
                    System.out.print("\nEnter the filename to load: ");
                    String Filename = scan.next().toLowerCase();
                    
                    Data = list.LoadFile(Filename);
                    break;

                case 3:
                    exit = true;
                    break;
            }
        }
        System.out.println("\nProcess finished with exit code 0");
    }

    public static String TaskList(String Data) throws IOException, IllegalAccessException {

        boolean exit = false;
        
        while (!exit) 
        {   
            TaskList List = new TaskList(Data);

            System.out.print("\n\nList Operation Menu\n---------\n");
            System.out.print("\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu\n\n> ");
            
            int choice = scan.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("\nCurrent Tasks\n---------\n");
                    List.viewList();
                    break;

                case 2:

                    System.out.print("\nCurrent Tasks\n---------\n\n");
                    scan.nextLine();

                    //scanning values
                    System.out.print("Task title: ");
                    String title = scan.nextLine();
                    System.out.print("Task description: ");
                    String description = scan.nextLine();
                    System.out.print("Task due date (YYYY-MM-DD):");
                    String date = scan.nextLine();
                    System.out.print("\n");

                    //add item
                    TaskItem Item = new TaskItem(Data, title, description, date);
                    Data = Item.add();
                    break;

                case 3:

                    System.out.print("\nCurrent Tasks\n---------\n\n");
                    if(Data.isEmpty())
                    {
                        System.out.println("WARNING, UNABLE TO EDIT EMPTY TASK LIST");
                        break;
                    }

                    List.viewList();

                    scan.nextLine();
                    //scanning values
                    System.out.print("\nWhich task will you edit? ");
                    int placeToedit = scan.nextInt();
                    System.out.print("Enter a new title for task " + placeToedit + ":");
                    String editTitle = scan.nextLine();
                    System.out.print("Enter a new description for task: " + placeToedit + ":");
                    String editDescription = scan.nextLine();
                    System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + placeToedit + ":");
                    String editDate = scan.nextLine();
                    System.out.print("\n");

                    Data = List.editList(placeToedit, editTitle, editDescription, editDate);

                    break;

                case 4:

                    System.out.print("\nCurrent Tasks\n---------\n\n");
                    if(Data.isEmpty())
                    {
                        System.out.println("WARNING, UNABLE TO EDIT EMPTY TASK LIST");
                        break;
                    }

                    List.viewList();
                    //Task List
                    System.out.print("\n\nWhich task will you remove?: ");
                    int placeToDelete = scan.nextInt();

                    Data = List.delete(placeToDelete);
                    break;

                case 5:

                    System.out.print("\nCompleted Tasks\n---------\n\n");
                    if(Data.isEmpty())
                    {
                        System.out.println("WARNING, UNABLE TO EDIT EMPTY TASK LIST");
                        break;
                    }

                    List.viewList();
                    // completed tasks
                    System.out.print("\n\nWhich task will you mark as completed?: ");
                    int placeToComplete = scan.nextInt();
                    
                    Data = List.complete(placeToComplete);
                    break;

                case 6:

                    System.out.print("\nUncompleted Tasks\n---------\n\n");
                    if(Data.isEmpty())
                    {
                        System.out.println("WARNING, UNABLE TO EDIT EMPTY TASK LIST");
                        break;
                    }

                    List.viewList();

                    System.out.print("\n\nWhich task will you mark as not completed?: ");
                    int placeToUncomplete = scan.nextInt();

                    // uncompleted tasks
                    Data = List.uncomplete(placeToUncomplete);
                    break;
                    
                case 7:

                    //save in file defined by user
                    System.out.print("\nEnter the filename to save as: ");
                    String newFilename = scan.next().toLowerCase();

                    if(newFilename.endsWith(".txt") && !Data.isEmpty())
                            SaveFile(newFilename, Data);
                    else
                    {
                        System.out.print("\nWARNING: NOT ABLE TO SAVE DATA");
                        break;
                    }

                    System.out.print("\ntask list has been saved");
                    break;

                case 8:
                    exit = true;
                    break;
            }
        }
        return Data;
    }


    public static void SaveFile(String fileName, String Data) throws IOException
    {
        // Accept a string  
        String str = Data; 
  
        // attach a file to FileWriter  
        FileWriter fw = new FileWriter(fileName); 

        for (int i = 0; i < str.length(); i++) 
            fw.write(str.charAt(i)); 

        fw.close();
    }
}