class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int  minlen = Integer.MAX_VALUE , n = arr.length;
        int i=0 , j=0, sum =0;

        while(j<n){
            sum += arr[j];
            
            while(sum>= target){
                int len = j-i+1;
                minlen = Math.min(minlen,len);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        if(minlen == Integer.MAX_VALUE)   return 0;
        else return minlen;
    }
}