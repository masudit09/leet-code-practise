package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String args[]) {
        System.out.print(rob(new int[]{1,2,3,1}));
    }
    static public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        return stolenMoney(0,nums, memo);
    }
    static private int stolenMoney(int index, int[] nums, Map<Integer, Integer> memo) {
        if(memo.get(index) != null) {
            return memo.get(index);
        }
        if(index>=nums.length)
            return 0;
        if(index==nums.length)
            return nums[index];
        int included = nums[index]+stolenMoney(index+2, nums, memo);
        int excluded = stolenMoney(index+1, nums, memo);
        memo.put(index,Math.max(included, excluded));
        return memo.get(index);
    }
}
