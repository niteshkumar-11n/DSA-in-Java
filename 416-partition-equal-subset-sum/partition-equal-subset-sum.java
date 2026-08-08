class Solution {
    public boolean subset(int i, int []arr, int target,int [][]dp ){
        if(i == arr.length){
            if(target== 0) return true;
            else return false;
        }
        if(dp[i][target] != -1){
            if(dp[i][target] ==1) return true;
            else return false;
        }

        boolean ans =false;
        boolean skip = subset(i+1, arr,target,dp);
        if(target-arr[i]<0) ans =  skip;

        else {
            boolean pick  = subset(i+1,arr, target-arr[i],dp);
            ans = pick||skip;
        }

        if(ans ==true) dp[i][target] =1;
        else dp[i][target] =0;
        return ans;
    }
    public boolean canPartition(int[] arr) {
        int sum=0;
        for(int i=0; i<arr.length; i++){
                sum+= arr[i];
        }
        if(sum%2 ==1) return false;
        int t = sum/2;
        int [][]dp = new int[arr.length][t+1];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<t+1; j++) dp[i][j] =-1;
        }
        return subset(0,arr,t,dp);
    }
}