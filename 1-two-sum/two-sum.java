class Solution {
    public int[] twoSum(int[] arr, int target) {
     int [] temp = new int[2];
     int n=arr.length;
      for(int i=0; i<n-1; i++)  {
        for(int j=i+1; j<n; j++) {
            if(arr[i]+arr[j]==target){
                temp[0] = i;
                temp[1] = j;
                return temp;
            }
            
        }
      }
      return new int[0];
    }
}