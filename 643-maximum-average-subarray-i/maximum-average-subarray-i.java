class Solution {
    public double findMaxAverage(int[] arr, int k) {
    int sum =0;
    
    int n = arr.length;
    for(int a=0; a<=k-1; a++){
        sum+=arr[a];
    }
    double maxSum = sum;
    int i=0, j = k;
    while (j<n){
        sum = sum-arr[i]+arr[j];
        maxSum = Math.max(maxSum,sum);        
        j++;
        i++;
        
    }
    return maxSum / (double) k;
    }
}