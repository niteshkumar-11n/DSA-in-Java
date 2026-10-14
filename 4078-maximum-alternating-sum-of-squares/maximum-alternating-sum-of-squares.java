class Solution {
    public long maxAlternatingSum(int[] nums) {
        long neg_sum = 0;
        long pos_sum =0;
        int n= nums.length;
        for(int i = 0; i <nums.length; i++) {
            nums[i] = (nums[i]*nums[i]);
        }
        Arrays.sort(nums);    
        for(int i = 0; i <nums.length/2; i++) {
            neg_sum += nums[i];
        }
        for(int k = nums.length/2; k <nums.length; k++) {
            pos_sum += nums[k];
        }
        return  pos_sum - neg_sum;
    }
}