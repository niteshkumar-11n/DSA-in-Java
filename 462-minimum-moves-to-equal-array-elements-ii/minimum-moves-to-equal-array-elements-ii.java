class Solution {
    public int minMoves2(int[] arr) {
        int n = arr.length; 
        for(int i=0; i<n-1; i++ ){
            for(int j=0; j<n-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        int mid = arr[n/2];  // find the mid of the arr for reduce the gap between the element for equaling the element 
        int moves =0;
        for(int i=0; i<n; i++){
            moves += Math.abs(arr[i] - mid); // add all the abslute value  which is comes + &-  arr[i]-mid
        }  
        return moves;     
    }
}