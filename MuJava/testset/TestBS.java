import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestBS {
	@Test
	public void test(){
		int array[] = new int[]{1,6,2,2,5};
		int result[] = new int[]{1,2,2,5,6};
		assertArrayEquals(result,BubbleSort.BubbleSort(array));
	}
}

