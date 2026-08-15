class Solution {
    public int longestSubsequence(int[] arr) {
        int xor =arr[0];
        boolean all_zero = true;
        if (arr[0] != 0) {
        all_zero = false;
        }
        for(int i=1; i<arr.length; i++){
            xor ^= arr[i];
            if(arr[i] !=0) all_zero = false;
            
        }
        if(all_zero == true) return 0;
        else if(xor == 0 ) return arr.length-1;
        else return arr.length;
    }
}