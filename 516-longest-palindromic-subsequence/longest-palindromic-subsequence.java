class Solution {
    public int lps(int i, int j, StringBuilder a, int [][]dp) {
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        if(a.charAt(i) ==a.charAt(j)) return dp[i][j] = 2+lps(i+1,j-1,a,dp);
        else return dp[i][j] = Math.max(lps(i+1,j,a,dp),lps(i,j-1,a,dp));
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder a = new StringBuilder(s);
        int n= a.length();
        int [][]dp = new int [n][n];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
        return lps(0, n-1,a,dp);
    }
}