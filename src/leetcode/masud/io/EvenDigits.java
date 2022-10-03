package leetcode.masud.io;

/*
* https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/
* 1295
* */
public class EvenDigits {
    public static void main(String args[]) {
        int[] nums = new int[]{12,345,2,6,7896};
        System.out.println("Result is"+findNumbers(nums));
    }

    static public int findNumbers(int[] nums) {
        int result =0;
        for (int i = 0; i < nums.length; i++) {
            int digits = getDigitCount(nums[i]);
            if(digits%2==0) {
                result ++;
            }
        }
        return result;
    }
    static public int getDigitCount(int num) {
        int count = 0;
        if(num == 0) {
            count = 1;
        }
        if(num < 0) {
            num *= -1;
        }
        while (num>0) {
            count++;
            num/=10;
        }
        return count;
    }
}
