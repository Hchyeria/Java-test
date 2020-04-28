
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class CoinsTest {
    private Coins coins;
    private int input;
    private boolean expected;

    public CoinsTest(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        coins = new Coins();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        Map<Integer, Boolean> trueTest = Coins.getTest();

        for (int i = 0; i < 50; ++i) {
            Random random = new Random();
            int caseTest = random.nextInt(100);
            if (!trueTest.containsKey(caseTest)) {
                trueTest.put(caseTest, false);
            }
        }

        return convert(trueTest);
    }

    private static Collection<Object[]>  convert(Map<Integer, Boolean> trueTest) {
        Collection<Object[]> res = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : trueTest.entrySet()) {
            res.add(new Object[] {entry.getKey(), entry.getValue()});
        }
        return res;
    }

    @Test
    public void findByNumber() {
        assertEquals(expected, coins.findByNumber(input));
    }
}
