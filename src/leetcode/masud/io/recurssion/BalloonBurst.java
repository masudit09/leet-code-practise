package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class BalloonBurst {
    public static void main(String args[]) {
//        System.out.println("Result: " + coinChanges(new int[]{186,419,83,408}, 6249));
//        System.out.println("Result: " + coinChanges(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
        System.out.println("Result: " + maxCoins(new int[]{3,1,5,8}));
    }
    static public int maxCoins(int[] nums) {
        int[] newArray = new int[nums.length+2];
        newArray[0] = 1;
        newArray[newArray.length-1] =1;
        for(int i=0; i< nums.length; i++) {
            newArray[i+1] = nums[i];
        }
        int[][] memory = new int[nums.length+2][nums.length+2];
        Map<String, Integer> memo = new HashMap<>();
//        return getMaxCoins(1 , newArray.length-2, newArray, memo);
        return getMaxCoins(1 , newArray.length-2, newArray, memory);
    }
//    static public int getMaxCoins(int left, int right ,int[] nums, Map<String, Integer> memo) {
//        String key = left + "," + right;
//        if(left > right) {
//            return 0;
//        }
//        if(memo.get(key) != null) {
//            return memo.get(key);
//        }
//        memo.put(key, 0);
//        for(int i=left; i<=right;i++) {
////            int coins = (getVal(left-1,nums) * getVal(i,nums) * getVal(right+1,nums));
//            int coins = nums[left-1] * nums[i] * nums[right+1];
//            coins += (getMaxCoins(left, i-1, nums, memo) + getMaxCoins(i+1, right, nums, memo));
//            memo.put(key, Math.max(memo.get(key), coins));
//        }
//        return memo.get(key);
//    }
    static public int getMaxCoins(int left, int right ,int[] nums, int[][] memory) {
        if(left > right) {
            return 0;
        }
        if(memory[left][right] != 0) {
            return memory[left][right];
        }
        memory[left][right] =0;
        for(int i=left; i<=right;i++) {
//            int coins = (getVal(left-1,nums) * getVal(i,nums) * getVal(right+1,nums));
            int coins = nums[left-1] * nums[i] * nums[right+1];
            coins += (getMaxCoins(left, i-1, nums, memory) + getMaxCoins(i+1, right, nums, memory));
            memory[left][right] = Math.max(memory[left][right], coins);
        }
        return memory[left][right];
    }
    static public int getVal(int index, int[] nums) {
        if(index <0 || index >= nums.length) {
            return 1;
        }
        return nums[index];

    }



}
