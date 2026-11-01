class Solution {
    public int minimumOperations(int[] arr) {
        int c=0;
        int count=0;
        for(int i=0; i<arr.length; i++){
            count = arr[i] %3;
            if(count !=0) c++;

        }
        return c;
    }
}