package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String args[]) {
        System.out.print(uniquePaths(3,2));
    }
    static public int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return findPath(0,0,m,n, memo);
    }
    static private int findPath(int visitedRow, int visitedColumn, int m, int n, Map<String, Integer> memo) {
        String position = visitedRow+","+visitedColumn;
        if(memo.get(position) != null) {
            return memo.get(position);
        }
    if(visitedRow >= m-1 || visitedColumn >= n-1) {
        return 1;
    }
        memo.put(position,findPath(visitedRow+1, visitedColumn, m, n, memo) +
            findPath(visitedRow, visitedColumn+1, m, n, memo));
    return memo.get(position);
    }
}
