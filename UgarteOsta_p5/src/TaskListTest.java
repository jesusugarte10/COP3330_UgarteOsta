import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

public class TaskListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        int before = list.getContactListSize();
        ContactItem data = new ContactItem("Jesus", "Ugarte", "321-946-7914", "juga@ucf.com");
        list.add(data);
        int after = list.getContactListSize();
        assertEquals(1, after - before);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-12-12", "");
        list.add(data);
        assertDoesNotThrow(()-> list.completeTaskList(0));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-12-12", "");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.completeTaskList(99));
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertThrows(IllegalArgumentException.class , () -> list.editTaskList(99, "Newtitle", "Newdescription", "2020-02-12"));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.editTaskList(0, "Newtitle", "Newdescription", "2020-02-12"));
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.editTaskList(0, "Newtitle", "Newdescription", "2020-02-12"));
    }

    @Test
    public void editingItemTitleFailsWithEmptyString() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertThrows( IllegalArgumentException.class, ()-> list.editTaskList(0, "", "", ""));
    
    }
    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertThrows( IllegalArgumentException.class, ()-> list.editTaskList(999, "Newtitle", "Newdescription", "2020-02-12"));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.editTaskList(0, "Newtitle", "Newdescription", "2020-02-12"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertThrows(IllegalArgumentException.class,() -> list.editTaskList(999, "Newtitle", "Newdescription", "2020-02-12"));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class,() -> list.getItemDescriptionisValid(99));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.getItemDescriptionisValid(0));
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class,() -> list.getItemDateisValid(99));
    
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.getItemDateisValid(0));
    
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class,() -> list.getItemTitleiIsValid(99));
    
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-02-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.getItemTitleiIsValid(0));
    }


    @Test
    public void newListIsEmpty() {
        TaskList list = new TaskList();
        assertEquals(true, list.isTaskListEmpty());
    }

    @Test
    public void removingItemsDecreasesSize() {
        TaskList list = new TaskList();
        int before = list.getTaskListSize();
        TaskItem data = new TaskItem("title", "description", "1212-12-12", "");
        list.add(data);
        int after = list.getTaskListSize();
        assertEquals(1, after - before);
        list.remove(0);
        after = list.getTaskListSize();
        assertEquals(0, after - before);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "1212-12-12", "");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class, () ->list.remove(99));
    }

    @Test
    public void savedTaskListCanBeLoaded() throws FileNotFoundException {
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-12-12", "");
        list.add(data);
        list.save("sample.txt");
        assertDoesNotThrow(()-> list.loadTaskFile("sample.txt"));
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-12-12", "***");
        list.add(data);
        assertDoesNotThrow(()-> list.uncompleteTaskList(0));
    }
    
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2020-12-12", "***");
        list.add(data);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.completeTaskList(99));
    }
    
}
