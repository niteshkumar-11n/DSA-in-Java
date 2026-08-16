class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans  = new int[nums.length];
        int []prePro  = new int[nums.length];
        int []sufPro  = new int[nums.length];
        
        for (int i=1; i<prePro.length; i++){
            prePro[0] = 1;
            prePro[i] = prePro[i-1]*nums[i-1];
        }
        
        for (int i=sufPro.length-2; i>=0; i--){
            sufPro[sufPro.length-1] = 1;
            sufPro[i] = sufPro[i+1]*nums[i+1];
        }
        for (int i=0; i<sufPro.length; i++){
            ans[i] = sufPro[i]*prePro[i];
        }
        return ans;
        
        
    }
}