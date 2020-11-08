import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class TestCases {

    @Test
    public void savedTaskListCanBeLoaded() throws IOException {
        TaskList list = new TaskList("");
        assertNotNull("", list.LoadFile("k.txt"));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() throws IllegalAccessException {
        TaskItem item = new TaskItem("DATA","title","description","12-12-12");
        assertEquals(false, item.Validate());
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle() throws IllegalAccessException {
        TaskItem item = new TaskItem("DATA","","description","1212-12-12");
        assertEquals(false, item.Validate());
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() throws IllegalAccessException {
        TaskItem item = new TaskItem("DATA","title","description","2020-12-12");
        assertEquals(true, item.Validate());
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() throws IllegalAccessException {
        TaskItem item = new TaskItem("DATA","title","description","2020-12-12");
        assertEquals(true, item.Validate());
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() throws IllegalAccessException {
        TaskItem item = new TaskItem("null","title","description","12-12-12");
        assertEquals("null", item.add());
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() throws IllegalAccessException {
        TaskItem item = new TaskItem("","title","description","2020-12-12");
        assertEquals("\n0)[2020-12-12] title: description", item.add());
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() throws IllegalAccessException {
        TaskItem item = new TaskItem("null","","description","12-12-12");
        assertEquals("null", item.add());
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() throws IllegalAccessException {
        TaskItem item = new TaskItem("DATA","title","description","2020-12-12");
        assertEquals(true, item.Validate());
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n***0)[2020-12-12] title: description");
        assertEquals("\n***0)[2020-12-12] title: description", list.uncomplete(5));
    }
    @Test
    public void addingTaskItemsIncreasesSize() throws IllegalAccessException {
        TaskItem item = new TaskItem("null","title","description","2020-12-12");
        item.add();
        assertEquals( 1, item.getsize());
    }
    @Test
    public void removingTaskItemsDecreasesSize() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description\n1)[1999-13-17] title2: description2");
        list.delete(0);
        assertEquals(1, list.getListSize(2));
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[2020-12-12] title: description");
        assertEquals("\n0)[2020-12-12] title: description", list.complete(6));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[2020-12-12] title: description");
        assertEquals("\n0)[2020-12-12] title: description", list.editList(6, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[1999-13-17] title: description", list.editList(6, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[2020-12-12] editTitle: editDescription", list.editList(0, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[1999-13-17] title: description", list.editList(8, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[2020-12-12] editTitle: editDescription", list.editList(0, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[1999-13-17] title: description", list.editList(9, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[2020-12-12] editTitle: editDescription", list.editList(0, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void editingTaskItemChangesValues() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[2020-12-12] editTitle: editDescription", list.editList(0, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[2020-12-12] editTitle: editDescription", list.editList(0, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[2020-12-12] editTitle: editDescription", list.editList(0, "editTitle", "editDescription", "2020-12-12"));
    }

    @Test
    public void editingTaskItemTitleChangesValue() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[2020-12-12] editTitle: editDescription", list.editList(0, "editTitle", "editDescription", "2020-12-12"));
    }
    @Test
    public void newTaskListIsEmpty() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals(true , !list.Emptydata());
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[1999-13-17] title: description");
        assertEquals("\n0)[1999-13-17] title: description", list.delete(8));
    }
    @Test
    public void completingTaskItemChangesStatus() throws IllegalAccessException {
        TaskList list = new TaskList("\n0)[2020-12-12] title: description");
        assertEquals("\n***0)[2020-12-12] title: description", list.complete(0));
    }
    @Test
    public void uncompletingTaskItemChangesStatus() throws IllegalAccessException {
        TaskList list = new TaskList("\n***0)[2020-12-12] title: description");
        assertEquals("\n0)[2020-12-12] title: description", list.uncomplete(0));
    }
}
