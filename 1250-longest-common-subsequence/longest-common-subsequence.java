class Solution {
    public int lcs(int i,int j, StringBuilder  a, StringBuilder  b,int [][]dp) {
        if(i<0 || j<0) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = 1+lcs(i-1,j-1,a,b,dp);
        else return dp[i][j] = Math.max(lcs(i,j-1,a,b,dp),lcs(i-1,j,a,b,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int n = a.length(), m = b.length();
        int [][]dp = new int [n][m];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
        return lcs(n-1,m-1,a,b,dp);
    }
}