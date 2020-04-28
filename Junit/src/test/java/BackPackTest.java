import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BackPackTest {
	@Test
	public void test(){
		int m = 10;
		int n = 2;
		int[] w = {3, 4, 5};
        int[] p = {4, 5, 6};
		int[][] result = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4},{0, 0, 0, 4, 5, 5, 5, 9, 9, 9, 9},{0, 0, 0, 4, 5, 6, 6, 9, 10, 11, 11}};
		assertArrayEquals(result, BackPack.BackPack_Solution(m, n, w, p));
	}

}
