import com.evil.sort.BubbleSort;
import com.evil.sort.Insertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * BubbleSortTest
 *
 * @author qinhu
 * @version 0.0.1
 * @since 2023-06-19
 */
public class SortTest {
    @Test
    public void bubbleSortTest() {

        BubbleSort sort = new BubbleSort();

        int[] nums = {3, 2, 1, 5, 4};
        int[] nums1 = {5, 4, 3, 2, 1};

        sort.sort(nums);
        sort.sort(nums1);

        Assertions.assertArrayEquals(new int[]{1,2,3,4,5},nums);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5},nums1);

    }

    @Test
    public void insertionSortTest() {

        Insertion sort = new Insertion();

        int[] nums = {3, 2, 1, 5, 4};
        int[] nums1 = {5, 4, 3, 2, 1};

        sort.sort(nums);
        sort.sort(nums1);

        Assertions.assertArrayEquals(new int[]{1,2,3,4,5},nums);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5},nums1);

    }
}
