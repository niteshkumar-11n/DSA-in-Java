class Solution {
    public  int  isPalindrom(int i,int j,int [][]dp, String s){
        if(i>=j) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j))  return  dp[i][j] = isPalindrom(i+1,j-1,dp, s);
        else return dp[i][j] = 0;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int start_Point = 0;
        int maxLen = -1;
        int [][] dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }

        }
        for(int i=0; i<n; i++){
            for (int j = i; j <n ; j++) {
                if (isPalindrom(i,j,dp,s) == 1){
                    if(j-i+1 >maxLen) {
                        maxLen = j-i+1;
                        start_Point = i;
                    }
                }

            }
        }
        return s.substring(start_Point,start_Point+maxLen);


    }
}