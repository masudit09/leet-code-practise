package leetcode.masud.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/two-sum/
* 1
* */
public class PalindromeNumber {
    public static void main(String args[]) {
        int x = -121;
        System.out.println("Result is: "+ isPalindrome(x));
    }
    static public boolean isPalindrome(int x) {
//        String inputLitteral = ""+x;
//        int inputLength = inputLitteral.length();
//        for (int i = 0; i < inputLength/2; i++) {
//            if(inputLitteral.charAt(i) != inputLitteral.charAt(inputLength-i-1)) {
//                return false;
//            }
//        }
        if(x < 0) {
            return false;
        }
        int revNum = 0;
        int orgNum = x;
        while(orgNum > 0) {
            revNum = revNum*10+orgNum%10;
            orgNum = orgNum/10;
        }
//        System.out.println(revNum);
        return x == revNum;
    }

}
