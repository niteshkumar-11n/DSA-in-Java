class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        for(int k=l; k<=r; k++){
            int sum =0;
            for (int i = 0; i < k; i++) {
                    sum += nums.get(i);
                }
                if(sum>0) min = Math.min(min, sum);
            for (int i = k; i <n ; i++) {
                sum = sum-nums.get(i-k)+nums.get(i);
                if(sum>0) min = Math.min(min, sum);
            }
        }
           
        
        if(min == Integer.MAX_VALUE) return -1;
        else return min;
    }
}