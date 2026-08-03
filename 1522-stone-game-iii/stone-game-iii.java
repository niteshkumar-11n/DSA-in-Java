class Solution {
    public int game(int[] arr,int i,int []dp) {
        int n = arr.length;
        if(i>=n) return 0;
        int dif = Integer.MIN_VALUE;
        if(dp[i] != -1) return dp[i];
        dif = Math.max(dif,arr[i]-game(arr,i+1,dp)) ;
        if(i+1<n)   dif = Math.max(dif,arr[i]+arr[i+1]-game(arr,i+2,dp)) ;
        if(i+2<n)   dif = Math.max(dif,arr[i]+arr[i+1]+arr[i+2]-game(arr,i+3,dp)) ;
        return dp[i] = dif;
    }
    public String stoneGameIII(int[] arr) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        int res = game(arr,0,dp);
        if(res>0) return "Alice";
        else if(res<0) return "Bob";
        else return "Tie";
    }
}