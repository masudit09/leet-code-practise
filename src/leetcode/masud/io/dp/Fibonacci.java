package leetcode.masud.io.dp;

public class Fibonacci {
    static int fib[];
    public static void main(String args[]) {
        int num = 5;
        fib = new int[num+1];
        for(int i=0; i<=num; i++) {
            System.out.print(dpFibonacci(i)+" ");
        }
    }

    static int dpFibonacci(int input) {
        if(input<=0)
            return fib[input] = 0;
        if(input == 1 && input == 2)
            return fib[input] = 1;

        return fib[input] = fib[input -1] + fib[input -2];

    }
}
