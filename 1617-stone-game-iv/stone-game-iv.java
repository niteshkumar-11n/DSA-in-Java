class Solution {
    public boolean solve(int n, int []dp) {
        if(n==0) return false;
        if(dp[n] != -1){
            if(dp[n] ==1) return true;
            else return false;
        } 
        for(int i=1; i*i<=n; i++){
            if(solve(n-i*i, dp) == false){
                dp[n] =1;
                return  true; // because ye jo call hai wo bob ke liye ki gyi hai wo nhi win kiya tabhi alice won the game
            } 
        }
        dp[n] = 0;
        return false;
    }
    public boolean winnerSquareGame(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n, dp); // if true it means alice won the game 
    }
}