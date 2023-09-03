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
    public void test() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.forEach(System.out::println);

        linkedList.remove(3);
        linkedList.forEach(System.out::println);
    }
}
