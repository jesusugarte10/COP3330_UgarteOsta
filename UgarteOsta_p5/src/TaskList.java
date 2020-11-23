import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

    List<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void add(TaskItem data){
        tasks.add(data);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public void editTaskList(int index, String title, String description, String date){

        if(title.isEmpty() && description.isEmpty() && date.isEmpty())
            throw new IllegalArgumentException("Warning: All Items empty");
        
        if(index > getTaskListSize())
            throw new IllegalArgumentException("Warning: Index out of bounds");

        TaskItem data = null;
        TaskItem beforeData = tasks.get(index);

        try{
            data = new TaskItem(title, description, date, beforeData.getComplete());
            tasks.set(index, data);

        } catch (IllegalArgumentException ex){
            System.out.println("Warning: Unable to edit List, Please try again");
        }
    }

    public void completeTaskList(int index){
        
        TaskItem data = tasks.get(index);

        try{
            if(index > getTaskListSize())
                throw new IllegalArgumentException("Warning: Index out of bounds");

            data = new TaskItem(data.getTitle(), data.getDescription(), data.getDate(), "***");
            tasks.set(index, data);

        } catch (IllegalArgumentException ex){
            System.out.println("Warning: Unable to edit List, Please try again");
        }
        
    }

    public void uncompleteTaskList(int index){

        TaskItem data = tasks.get(index);
            
        try{        
            
            if(index > getTaskListSize())
                throw new IllegalArgumentException("Warning: Index out of bounds");

            data = new TaskItem(data.getTitle(), data.getDescription(), data.getDate(), "");
            tasks.set(index, data);

        } catch (IllegalArgumentException ex){
            System.out.println("Warning: Unable to edit List, Please try again");
        }
    }


    public String getItemDescriptionisValid(int index){
        
        TaskItem data = tasks.get(index);
        if(index > getTaskListSize())
            throw new IllegalArgumentException("Out of Bounds");

        return data.getDescription();
    }


    public String getItemTitleiIsValid(int index){
        
        TaskItem data = tasks.get(index);
        if(index > getTaskListSize())
            throw new IllegalArgumentException("Out of Bounds");
        return data.getTitle();
    }


    public String getItemDateisValid(int index){
        
        TaskItem data = tasks.get(index);
        if(index > getTaskListSize())
            throw new IllegalArgumentException("Out of Bounds");

        return data.getDate();
    }


    public boolean isTaskListEmpty(){
        return tasks.isEmpty();
    }

    public int getTaskListSize(){
        return tasks.size();
    }

    public void printList(){
        for(int i = 0; i < getTaskListSize(); i++) {
            TaskItem data = tasks.get(i);
            System.out.print( "\n"+ i + ")" + data.getComplete() + " [" + data.getDate() + "]"+ data.getTitle() + ": " + data.getDescription());
        }
    }

    public void save(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (TaskItem task : tasks)
             pw.println(task); // call toString() IN CONTACT ITEM
        pw.close();
    }


    public TaskList loadTaskFile(String fileName) throws IOException {

        BufferedReader in = null;
        TaskList list = new TaskList();

        try {   
            in = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = in.readLine()) != null) {

                String[] arr = str.split(" ");
                TaskItem data = new TaskItem(arr[1], arr[2], arr[3], arr[0]);
                list.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
                System.out.println("Task list has been loaded");
            }
        }
        return list;
    }


}
