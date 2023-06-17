import com.evil.linkedlist.LinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * LinkedListTest
 *
 * @author qinhu
 * @version 0.0.1
 * @since 2023-06-17
 */
@DisplayName("LinkedListTest")
public class LinkedListTest {
    @Test
    public void testAdd() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.iterator(System.out::println);
    }
}
