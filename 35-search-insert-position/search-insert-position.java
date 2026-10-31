class Solution {
    public int searchInsert(int[] arr, int x) {
        int lo =0; 
        int hi = arr.length-1;
        int lb = arr.length;
        while(lo<=hi){
            int mid = lo +(hi-lo)/2;
            if(arr[mid]>=x) {
                lb = Math.min(lb,mid);
                hi =  mid-1;
            }
            else lo = mid+1;
  
        }
        return lb;
    }
}