package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String args[]) {
        System.out.print(fib(3));
    }
    static public int fib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return getFib(n, memo);

    }
    static public int getFib(int n, Map<Integer, Integer> memo) {
        if(memo.get(n) != null) {
            return memo.get(n);
        }
        if(n==0 || n==1)
            return n;
        memo.put(n, fib(n-1) + fib(n-2));
        return memo.get(n);
    }


}
