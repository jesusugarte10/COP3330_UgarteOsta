
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

public class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate(){
        assertThrows(IllegalArgumentException.class , () -> new TaskItem("Title", "Description", "321-98-9", ""));
    }


    @Test
    public void constructorFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class , () -> new TaskItem("", "Description", "2020-01-01",""));
    }
    @Test
    public void constructorSucceedsWithValidDueDate(){
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "2020-01-12", ""));
    }
    @Test
    public void constructorSucceedsWithValidTitle(){
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "2020-01-12", ""));
    }
    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("Title", "Description", "2020-01-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.editTaskList(0, "Title", "newDescription", "2020-01-12"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("Jesus", "Ugarte", "2020-01-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.editTaskList(0, "Title", "Description", "2020-01-12"));
    }
    
    @Test
    public void editingTitleFailsWithEmptyString(){
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("Jesus", "Ugarte", "2020-01-12", "");
        list.add(data);
        assertThrows(IllegalArgumentException.class,() -> list.editTaskList(0, "", "", ""));
    }
    
    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskList list = new TaskList();
        TaskItem data = new TaskItem("Jesus", "Ugarte", "2020-01-12", "");
        list.add(data);
        assertDoesNotThrow(() -> list.editTaskList(0, "Title", "Description", "2020-01-12"));
    }

    
}
