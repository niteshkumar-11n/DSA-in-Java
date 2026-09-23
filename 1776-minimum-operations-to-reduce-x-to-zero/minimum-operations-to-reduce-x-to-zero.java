class Solution {

    public int minOperations(int[] arr, int x) {
        int target =0;
        for (int k = 0; k < arr.length; k++) {
            target += arr[k];
        }
         target = target - x;
        if(target<0 ) return -1;
        if(target == 0) return arr.length;
        int left =0;
        int sum =0;
        int maxLen =-1;

        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];

            while(sum> target){
                sum -= arr[left];
                left++;
            }
            if(sum == target) maxLen  = Math.max(maxLen, i-left+1);
        }
        if(maxLen == -1) return -1;
        else return arr.length - maxLen;

    }
}