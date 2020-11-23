import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ContactList {

    List<ContactItem> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void add(ContactItem data){
        contacts.add(data);
    }

    public void remove(int index){
        contacts.remove(index);
    }

    public void editContactList(int index, String name, String lastName, String phone, String email){

        if(name.isEmpty() && lastName.isEmpty() && phone.isEmpty() && email.isEmpty())
            throw new IllegalArgumentException("Warning: All Items empty");
        
        if(index > getContactListSize())
            throw new IllegalArgumentException("Warning: Index out of bounds");

        ContactItem data = null;
        try{

            data = new ContactItem(name, lastName, phone, email);
            contacts.set(index, data);

        } catch (IllegalArgumentException ex){
            System.out.println("Warning: Unable to edit List, Please try again");
        }
        
    }

    public boolean isContactListEmpty(){
        return contacts.isEmpty();
    }


    public int getContactListSize(){
        return contacts.size();
    }

    public void printList(){
        for(int i = 0; i < getContactListSize(); i++) {
            ContactItem data = contacts.get(i);
            System.out.print( i + ") Name: " + data.getName() + " "+ data.getLastName() + "\nPhone: " + data.getPhone() + "\nEmail: " + data.getEmail() + "\n");
        }
    }

    public void save(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (ContactItem contact : contacts)
             pw.println(contact); // call toString() IN CONTACT ITEM
        pw.close();
    }


    public ContactList loadContactFile(String fileName) throws IOException {

        BufferedReader in = null;
        ContactList list = new ContactList();

        try {   
            in = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = in.readLine()) != null) {

                String[] arr = str.split(" ");
                ContactItem data = new ContactItem(arr[0], arr[1], arr[2], arr[3]);
                list.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
                System.out.println("contact list has been loaded");
            }
        }
        return list;
    }
}
