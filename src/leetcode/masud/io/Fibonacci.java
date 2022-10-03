package leetcode.masud.io;

public class Fibonacci {
    static int fib[];
    public static void main(String args[]) {
        int num = 5;
        fib = new int[num+1];
        for(int i=0; i<=num; i++) {
//            System.out.print(recursiveFibonacci(i)+" ");
            System.out.print(recursiveFibonacci(i)+" ");
        }
//        System.out.println("Result is"+recursiveFibonacci(-5));
    }

    static int recursiveFibonacci(int input) {
        if(input<=1)
            return input;
        return recursiveFibonacci(input -1) + recursiveFibonacci(input-2);
    }
}
