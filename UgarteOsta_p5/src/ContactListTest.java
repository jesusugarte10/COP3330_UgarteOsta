import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

public class ContactListTest {

    @Test
    public void savedContactListCanBeLoaded() throws FileNotFoundException {
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        list.save("sample.txt");
        assertDoesNotThrow(()-> list.loadContactFile("sample.txt"));
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertThrows(IllegalArgumentException.class, () -> list.editContactList( 0, "", "", "", ""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class, () -> list.editContactList( -99, "Jesus", "Ugarte", "321-946-7914", "Juga@ucf.com"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "", "Ugarte", "321-946-7914", "Juga@ucf.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "Jesus", "", "321-946-7914", "Juga@ucf.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "Jesus", "Ugarte", "", "Juga@ucf.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "Jesus", "Ugarte", "321-946-7914", "Juga@ucf.com"));
    }

    @Test
    public void addingItemsIncreasesSize(){

        ContactList list = new ContactList();
        int before = list.getContactListSize();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        int after = list.getContactListSize();
        assertEquals(1, after - before);
    }

    @Test
    public void newListIsEmpty(){
        ContactList list = new ContactList();
        assertEquals(true, list.isContactListEmpty());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList list = new ContactList();
        int before = list.getContactListSize();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        int after = list.getContactListSize();
        assertEquals(1, after - before);
        list.remove(0);
        after = list.getContactListSize();
        assertEquals(0, after - before);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(99));
    }
}
