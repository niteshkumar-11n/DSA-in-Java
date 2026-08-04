class Solution {
    public int uniquePath(int st_row,int st_col, int [][]arr,int [][] dp){
        int m = arr.length; // row 
        int n = arr[0].length; // col
        if(st_col>=n || st_row >= m) return 0;
        if(arr[st_row][st_col] ==1 ) return 0;
        if(st_row == m-1 && st_col == n-1) return 1;
        if(dp[st_row][st_col] != -1) return dp[st_row][st_col];
        int rightway =  uniquePath(st_row,st_col+1, arr,dp);
        int downway =  uniquePath(st_row+1,st_col, arr,dp);
        return dp[st_row][st_col] = rightway+downway;

    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int [][] dp  = new int[arr.length][arr[0].length];
        for(int[] row:dp) Arrays.fill(row,-1);
        int n =uniquePath(0,0,arr,dp);
        return n;
    }
}