class Solution {
    public int minPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        //int [][]dp = new int[m][n];
        //dp[0][0] =arr[0][0];
        for (int i=1; i<m; i++){
            arr[i][0] = arr[i-1][0]+arr[i][0];
        }
        for (int j=1; j<n; j++){
            arr[0][j] = arr[0][j-1]+arr[0][j];
        }
        
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                arr[i][j] = arr[i][j] + Math.min(arr[i-1][j],arr[i][j-1]);
            }
        }
        return arr[m-1][n-1];
    }
}