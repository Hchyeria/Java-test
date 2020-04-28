import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class BubbleSortTest {
	@Test
	public void test(){
		int[] array = {1, 6, 2, 2, 5};
		int[] result = {1, 2, 2, 5, 6};
		assertArrayEquals(result,BubbleSort.BubbleSort(array));
	}
}
