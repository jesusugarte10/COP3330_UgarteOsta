import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TaskApp {

    static Scanner scan = new Scanner(System.in);

    public TaskApp() throws FileNotFoundException{

    }

	public void mainTaskMenu() throws FileNotFoundException {

        TaskList list = new TaskList();

        boolean exit = false;

        while (!exit) {
            System.out.print("\n\nTask List Main Menu\n------------------\n");
            System.out.print("\n1) create a new list\n2) load an existing list\n3) quit\n\n> ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nnew task list has been created");
                    mainTaskApp(list);
                    break;

                case 2:
                    scan.nextLine();
                    System.out.print("Enter the filename to load: ");
                        String Filename = scan.next().toLowerCase();

                        while(!Filename.endsWith("_task.txt")){
                            System.out.print("\nWARNING: FILE SHOULD END WITH _contact.txt");
                            System.out.print("\nEnter the filename to load: ");
                            Filename = scan.next().toLowerCase();
                        }

                    try {
                        list = list.loadTaskFile(Filename);
                    } catch (IOException e) {
                        System.out.println("WARNING: UNABLE TO LOAD FILE - TRY AGAIN");;
                    }
                    break;

                case 3:
                    exit = true;
                    break;
            }
        }
	}

    private void mainTaskApp(TaskList list) throws FileNotFoundException {

        String title, description, date;
        int index;
        boolean exit = false;

        while(!exit)
        {
            System.out.print("\n\nList Operation Menu\n---------\n");
            System.out.print("\n1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu\n\n> ");
            
            int choice = scan.nextInt();

            switch(choice){

                case 1:
                    list.printList();
                    break;
                
                case 2:

                    scan.nextLine();
                    System.out.print("\n\nTask title: ");
                    title = scan.nextLine();
                    System.out.print("Task description: ");
                    description = scan.nextLine();
                    System.out.print("Task due date (YYYY-MM-DD):");
                    date = scan.nextLine();

                    try{ 
                        TaskItem data = new TaskItem(title, description, date, "");
                        list.add(data);
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("\n\nWARNING: INVALID INPUT TRY AGAIN");
                    }
                    break;

                case 3:

                    list.printList();

                    if(list.isTaskListEmpty()){
                        System.out.println("\n\nWARNING: LIST EMPTY");
                        break;
                    }

                    //scanning values
                    scan.nextLine();
                    System.out.print("\nWhich task will you edit? ");
                    index = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter a new title for task " + index + ":");
                    title = scan.nextLine();
                    System.out.print("Enter a new description for task: " + index + ":");
                    description = scan.nextLine();
                    System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index + ":");
                    date = scan.nextLine();

                    try{
                        list.editTaskList(index, title, description, date);
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("WARNING: INVALID INPUT TRY AGAIN");
                    }catch (IndexOutOfBoundsException ex){
                        System.out.println("WARNING: INDEX OUT OF BOUNDS");
                    }

                    break;


                case 4:

                    list.printList();

                    if(list.isTaskListEmpty()){
                        System.out.println("\n\nWARNING: LIST EMPTY");
                        break;
                    }
                    scan.nextLine();
                    System.out.print("\n\nWhich task will you remove?: ");
                    index = scan.nextInt();
                    try{  
                        list.remove(index);
                    }catch (IndexOutOfBoundsException ex){
                        System.out.println("WARNING: INDEX OUT OF BOUNDS");
                    }

                    break;

                case 5:

                    if(list.isTaskListEmpty()){
                        System.out.println("\n\nWARNING: LIST EMPTY");
                        break;
                    }

                    list.printList();

                    System.out.print("\n\nWhich task will you mark as completed?: ");
                    index = scan.nextInt();

                    try{
                        list.completeTaskList(index);
                    }catch(IllegalArgumentException ex){
                        System.out.println("WARNING: INVALID INPUT TRY AGAIN");
                    }catch (IndexOutOfBoundsException ex){
                        System.out.println("WARNING: INDEX OUT OF BOUNDS");
                    }

                    break;

                case 6:

                    if(list.isTaskListEmpty()){
                        System.out.println("\n\nWARNING: LIST EMPTY");
                        break;
                    }

                    list.printList();

                    System.out.print("\n\nWhich task will you mark as not completed?: ");
                    index = scan.nextInt();

                    try{
                        list.uncompleteTaskList(index);
                    }catch(IllegalArgumentException ex){
                        System.out.println("WARNING: INVALID INPUT TRY AGAIN");
                    }catch (IndexOutOfBoundsException ex){
                        System.out.println("WARNING: INDEX OUT OF BOUNDS");
                    }

                    break;

                case 7:

                    scan.nextLine();
                    System.out.print("\n\nEnter the filename to save as: ");
                    String newFilename = scan.next().toLowerCase();

                    if(newFilename.endsWith("_task.txt") && !list.isTaskListEmpty())
                        list.save(newFilename);
                    else
                        System.out.println("WARNING: INVALID FILENAME \n Should end with '_task.txt' ");
                    break;

                case 8:

                    exit = true;
                    break;
            }
        }
    }
}
