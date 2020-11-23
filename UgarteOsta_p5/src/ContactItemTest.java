import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


public class ContactItemTest {

    @Test
    public void testToString(){
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        assertEquals("Jesus Ugarte 321-946-7914 juga@ucf.com", data.toString());
    }

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class , () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> new ContactItem("Jesus", "Ugarte", "321-946-7914", ""));
    }

    
    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> new ContactItem("", "Ugarte", "321-946-7914", "jesus@ucf.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> new ContactItem("Jesus", "", "321-946-7914", "jesus@ucf.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> new ContactItem("Jesus", "Ugarte", "", "jesus@ucf.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> new ContactItem("Jesus", "Ugarte", "321-946-7914", "jesus@ucf.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertThrows(IllegalArgumentException.class,() -> list.editContactList(0, "", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "Jesus", "Ugarte", "321-946-7914", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "", "Ugarte", "321-946-7914", "jesus@ucf.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "Jesus", "", "321-946-7914", "jesus@ucf.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "", "Ugarte", "", "jesus@ucf.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList list = new ContactList();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        assertDoesNotThrow(() -> list.editContactList(0, "Jesus", "Ugarte", "321-946-7914", "jesus@ucf.com"));

    }
}
