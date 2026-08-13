class Solution {
    public int maxProfit(int[] arr) {
      
        int total_profit=0;
      
        for(int i=1; i<arr.length; i++){
            if(arr[i]>arr[i-1]) total_profit += arr[i]-arr[i-1];
        }
        return total_profit;
    }
}