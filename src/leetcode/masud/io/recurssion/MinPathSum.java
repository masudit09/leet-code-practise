package leetcode.masud.io.recurssion;

import java.util.HashMap;
import java.util.Map;

public class MinPathSum {

    public static void main(String args[]) {
        System.out.print(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    static public int minPathSum(int[][] grid) {
        Map<String, Integer> memo = new HashMap<>();
        int row = grid.length;
        int col = grid[0].length;
        return findMinPathSum(0,0,row, col, grid, memo);
    }
    static public int findMinPathSum(int startRow, int startCol, int row, int col, int[][] grid, Map<String, Integer> memo) {
        String key = startRow+","+startCol;
        if(memo.get(key) != null) {
            return memo.get(key);
        }
        if(startRow>=row || startCol >= col) {
            return Integer.MAX_VALUE;
        }
        if(startRow == row-1 && startCol == col-1) {
            return grid[startRow][startCol];
        }
        memo.put(key, grid[startRow][startCol] + Math.min(findMinPathSum(startRow+1,startCol, row, col, grid, memo),
                findMinPathSum(startRow,startCol+1, row, col, grid, memo)));
        return memo.get(key);
    }
}
