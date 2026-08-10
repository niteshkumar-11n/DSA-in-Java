class Solution {
    public int minsteps(int i, int j, StringBuilder a, StringBuilder b, int[][]dp) {
        if(i == -1) return j+1;
        if(j == -1) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return  dp[i][j] = minsteps(i-1, j-1, a, b, dp);
        else{
            int del = minsteps(i-1, j, a, b, dp);
            int ins = minsteps(i, j-1, a, b, dp);
            int rep = minsteps(i-1, j-1, a, b, dp);
            return  dp[i][j] = 1+Math.min(del, Math.min(rep,ins));
        }
    }
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int n = a.length(), m = b.length();
        int [][]dp = new int[n][m];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
        return minsteps(n-1, m-1, a, b, dp);

    }
}