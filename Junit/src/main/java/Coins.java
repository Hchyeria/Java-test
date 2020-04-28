import java.util.*;

public class Coins {
    // coins[0]: represents the value of coin
    // coins[1]: represents how many coin we have
    private static final int[][] coins = {{50, 1}, {20, 1}, {10, 1}, {5, 2}, {1, 3}};



    public boolean findByNumber(int number) {
        if (number < 0) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        return dfs(number, 0);
    }

    private boolean dfs(int number, int level) {
        if (level == coins.length) {
            return number == 0;
        }
        int[] coin = coins[level];
        int branch = Math.min(coin[1], number / coin[0]);
        for (int i = 0; i <= branch; ++i) {
            if (dfs(number - i * coin[0], level + 1)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Integer, Boolean> getTest() {
        Map<Integer, Boolean> res = new HashMap<>();
        dfs2(res, 0, 0);
        return res;
    }

    private static void dfs2(Map<Integer, Boolean> res, int level, int sum) {
        if (level == coins.length) {
            res.put(sum, true);
            return;
        }
        for (int i = 0; i <= coins[level][1]; ++i) {
            dfs2(res, level + 1, sum + coins[level][0] * i);
        }
    }

}
