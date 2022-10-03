package leetcode.masud.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/two-sum/
* 1
* */
public class TwoSum {
    public static void main(String args[]) {
        int[] wealths = new int[]{2,7,11,15};
        int target = 9;


    }
    static public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[0] =i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[result[0]]+nums[j] == target){
                    result[1] =  j;
                    break;
                }
            }
            if(result[1] != 0) {
                break;
            }
        }
        return result;
    }

    static public int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> checkedMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainTarget = target - nums[i];
            if (checkedMap.get(remainTarget) != null){
                return new int[]{checkedMap.get(remainTarget),i};
            } else {
                checkedMap.put(nums[i], i);
            }
        }
        return new int[] {-1,-1};
    }

}
