class Solution {
    public int  winner(int[] nums,int i,int j,int [][] dp) {
        if(i>j) return 0;
        if(i == j) return nums[i];
        if(dp[i][j] !=-1) return dp[i][j];
        int take_i = nums[i] - winner(nums, i+1, j,dp);
        int take_j = nums[j] - winner(nums, i, j-1,dp);
        
        return dp[i][j] = Math.max( take_i , take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int [][] dp = new int [n][n];
        for(int [] row:dp) {
            Arrays.fill(row,-1);
        }
        return winner(nums,0,n-1,dp)>=0;
    }
}