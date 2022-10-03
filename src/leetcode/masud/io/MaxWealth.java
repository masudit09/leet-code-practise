package leetcode.masud.io;

/*
* https://leetcode.com/problems/richest-customer-wealth/
* 1672
* */
public class MaxWealth {
    public static void main(String args[]) {
        int[][] accounts = new int[][]{{1,5},{7,3},{3,5}};
        System.out.println("Result is: "+maximumWealth(accounts));
    }
    static public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int personWealth = calcuateWealth(accounts[i]);
            if(personWealth > maxWealth) {
                maxWealth = personWealth;
            }
        }
        return maxWealth;
    }
    static public int calcuateWealth(int[] wealths) {
        int totalWealth = 0;
        for (int i = 0; i < wealths.length; i++) {
            totalWealth +=wealths[i];
        }
        return totalWealth;
    }
}
