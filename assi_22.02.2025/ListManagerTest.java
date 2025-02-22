
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {
    ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        assertTrue(list.contains(5));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        manager.removeElement(list, 5);
        assertFalse(list.contains(5));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        assertEquals(1, manager.getSize(list));
    }
}
