package leetcode.masud.io.recurssion;

public class ClimbStair {

    public static void main(String args[]) {
        System.out.print(climbStairs(3));
    }

    static public int climbStairs(int n) {
        return getClimbStairsCount(n, new int[45+2]);
    }

    static public int getClimbStairsCount(int n, int[] memo) {
        if(memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1) {
            return 1;
        }
        memo[n] = getClimbStairsCount(n - 1, memo) + getClimbStairsCount(n - 2, memo);
        return memo[n];
    }
}

