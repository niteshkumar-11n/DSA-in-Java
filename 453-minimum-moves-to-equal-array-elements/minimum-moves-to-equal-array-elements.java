class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int i=0; 
        int min = arr[0];
        while( i<n){
           min = Math.min(arr[i],min);
            i++;
        }
        for( i=0; i<n; i++){
            arr[i] = arr[i]-min;
        }
        int sum =0;
        for( i=0; i<n; i++){
            sum +=arr[i];
        }
        return sum;
    }
}