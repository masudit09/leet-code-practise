package leetcode.masud.io;

import java.util.Arrays;

public class MoveZero {
    public static void main(String args[]) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
//        System.out.println("Result is"+moveZeroes(nums));
    }
    static public void moveZeroes(int[] nums) {
        int movedZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] ==0) { //12
                 //3
                movedZero+=1;
            } else {
                nums[i-movedZero] = nums[i];
            }
        }
        for(int i = 0; i < movedZero; i++) {
            nums[nums.length-i-1] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
//[1,2,0,3,12]