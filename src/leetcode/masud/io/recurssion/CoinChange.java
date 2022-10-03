package leetcode.masud.io.recurssion;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String args[]) {
//        System.out.println("Result: " + coinChanges(new int[]{186,419,83,408}, 6249));
//        System.out.println("Result: " + coinChanges(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
        System.out.println("Result: " + coinChanges(new int[]{2,5,4}, 11));
    }

    static public int coinChanges(int[] coins, int amount) {
//        return recursive(coins, amount, 0);
//        return memo(coins, amount, 0,new int[amount+1]);
        Map memo  = new HashMap<Integer, Integer>();
        return coinChangesHelper(coins, amount, memo);
    }


    static public int coinChangesHelper(int[] coins, int amount, Map<Integer, Integer> memo) {
        if(memo.get(amount) != null) {
            return memo.get(amount);
        }
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        int min  = -1;
        for(int coin: coins) {
            int reminder=amount - coin;
            int reminderQty = coinChangesHelper(coins, reminder, memo);
            if(reminderQty != -1) {
                int totalQuantity = reminderQty+1;
                if(min == -1 || totalQuantity<min) {
                    min = totalQuantity;
                }
            }
        }
        memo.put(amount, min);
        return memo.get(amount);
    }

    static public int memo(int[] coins, int rem, int index, int[] dp) {
        if(rem == 0) {
            return 0;
        }

        if(rem < 0) {
            return -1;
        }

        if(dp[rem] != 0) {
            System.out.println(Arrays.toString(dp));
            return dp[rem];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int result = memo(coins, rem - coins[i], i, dp);
            if(result < min && result >= 0) {
                min = result + 1;
            }
        }

        dp[rem] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[rem];
    }

    static private Integer dp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0; i < dp.length; i++) {
            for(int c : coins) {
                if(i >= c) {
                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
                    System.out.println("i="+i+", c="+c);
                    System.out.println(Arrays.toString(dp));
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    static int recursive(int[] coins, int amount, int index) {
    if(amount == 0) {
        return 0;
    }
    if(amount < 0 || index >= coins.length) {
        return -1;
    }
    int min = Integer.MAX_VALUE;
    for(int i = index; i < coins.length; i++) {
        int takeCurrentCoin = recursive(coins, amount - coins[i], i);

        if(takeCurrentCoin < min && takeCurrentCoin >= 0) {
            min = takeCurrentCoin + 1;
        }
    }

    return min == Integer.MAX_VALUE ? -1 : min;

    }


    static public int coinChange(int[] coins, int amount) {
        int count = Integer.MAX_VALUE;
        int tempCount = -1;

        if(amount == 0) {
            return 0;
        }

        for (int i = 0; i < coins.length; i++) {
            int dif = amount - coins[i];  // 6
            if(dif ==0) {
                return 1;
            } else {
                tempCount = 1;
            }
            while (dif > 0) {
                int nextMaxCoin  = Integer.MIN_VALUE;
                for(int j =0; j< coins.length ; j++) {
                    if(dif - coins[j] >=0 && nextMaxCoin < coins[j]) {
                        nextMaxCoin = coins[j];
                    }
                }
                if(nextMaxCoin != Integer.MIN_VALUE) {
                    dif = dif - nextMaxCoin;
                    tempCount++;
                } else {
                    dif = -1;
                }

            }
            if (tempCount < count && tempCount >1) {
                count = tempCount;
            }

        }
        return count == Integer.MAX_VALUE? -1: count;
    }
}
