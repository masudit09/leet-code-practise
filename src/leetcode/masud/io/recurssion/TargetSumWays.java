package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class TargetSumWays {
    public static void main(String args[]) {
        System.out.print(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    static public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return findTargetSumWays(nums.length-1, 0, nums, target, memo);

    }
    static private int findTargetSumWays(int index, int currentSum, int[] nums, int target, Map<String, Integer> memo) {
        String key = index+","+currentSum;
        if(memo.get(key) != null) {
            return memo.get(key);
        }
        if(index < 0 && currentSum == target)
            return 1;
        if(index < 0 )
            return 0;
        int positiveSum = findTargetSumWays(index-1, currentSum+nums[index], nums, target, memo);
        int negativeSum = findTargetSumWays(index-1, currentSum-nums[index], nums, target, memo);
        memo.put(key, positiveSum+negativeSum);

        return memo.get(key);

    }
}
