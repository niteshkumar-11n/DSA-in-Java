class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0 ,j= n-1;
        int maxWater =0;
        while(i<=j){
            int waterContains = Math.min(height[j],height[i])*(j-i);
            maxWater = Math.max(maxWater,waterContains);
            if(height[j]>height[i]) i++;
            else j--;
            
        }
        return maxWater;
    }
}