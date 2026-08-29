class Solution {
    public int removeElement(int[] arr, int val) {
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j] != val){
                arr[i] =  arr[j];
                i++;
            }
            j++;
        }
      return i;
    }
}