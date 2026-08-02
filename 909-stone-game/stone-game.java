class Solution {
    public int  game(int[] arr,int i,int j,int [][] dp) {
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int take_i = arr[i] + Math.min(game(arr,i+2,j,dp),game(arr,i+1,j-1,dp));
        int take_j = arr[j] +Math.min(game(arr,i+1,j-1,dp),game(arr,i,j-2,dp));
        return dp[i][j]= Math.max(take_i,take_j);
    }
    public boolean stoneGame(int[] arr) {
        int sum =0;
        int n =arr.length;
        for(int i=0; i<n; i++){
            sum+= arr[i];
        }
        int [][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int player_1 = game(arr,0,n-1,dp);
        int player_2 = sum-player_1;
        if(player_1>=player_2) return true;
        else return false;
       
    }
}