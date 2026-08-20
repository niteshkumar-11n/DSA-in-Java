class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int []dp1 = new int[n];
        int []dp2 = new int[n];
        if(n==1) return 1;
        for(int i=0; i<n; i++){
            dp1[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i])    dp1[i]= Math.max(dp1[j]+1,dp1[i]);
            }
        }
        for(int i=n-1; i>=0; i--){
            dp2[i] = 1;
            for(int j=n-1; j>i; j--){
                if(arr[j]<arr[i])  dp2[i]= Math.max(dp2[j]+1,dp2[i]);
            }
        }
        int maxLen =0;
        for(int i=0; i<n; i++){
            if(dp1[i]>1 && dp2[i]>1){
                int len = dp1[i]+dp2[i]-1;
                maxLen = Math.max(maxLen,len);
            }
            
        }
        return n-maxLen;

        
    }
}