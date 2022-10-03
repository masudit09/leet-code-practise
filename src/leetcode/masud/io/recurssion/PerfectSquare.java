package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquare {

    public static void main(String args[]) {
//        System.out.println("Result: " + coinChanges(new int[]{186,419,83,408}, 6249));
//        System.out.println("Result: " + coinChanges(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
        System.out.println("Result: " + numSquares(13));
    }
    static public int numSquares(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
    return getNumSquares(n, memo);
    }
    static public int getNumSquares(int n, Map<Integer, Integer> memo) {
        if(memo.get(n) != null) {
            return memo.get(n);
        }
        if(n == 0)
            return 0;

        int min = 0;
        for(int i= 1; i<=Math.sqrt(n); i++) {
            int square  = i*i;
            int res  = 1+ getNumSquares( n-square, memo);
            if(min == 0 || res < min)
                min = res;
        }
        memo.put(n, min);
        return memo.get(n);
    }
}
