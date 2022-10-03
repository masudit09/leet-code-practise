package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String args[]) {
        System.out.print(minCostClimbingStairs(new int[]{10,15,20}));
    }

    static public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(getMinCostClimbingStairs(cost.length-1, cost, memo), getMinCostClimbingStairs(cost.length-2, cost, memo));
    }

    static public int getMinCostClimbingStairs(int index, int[] cost, Map<Integer, Integer> memo) {
        if(memo.get(index) != null) {
            return memo.get(index);
        }
        if(index < 0) {
            return 0;
        }
        if(index == 0 || index == 1) {
            return cost[index];
        }
        memo.put(index, cost[index] + Math.min(getMinCostClimbingStairs(index-1, cost, memo), getMinCostClimbingStairs(index-2, cost, memo)));
        return memo.get(index);
    }
}
