class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        long ans = -1;
        long start = 1,end = x;
        while(start<=end){
            long mid = start+(end-start)/2;
            if(mid*mid>x){
                end = mid-1;
            } else if(mid*mid == x) return (int)mid;
            else{
                ans = mid;
                start  = mid+1;}
            
        }
        return (int)ans;
        
    }
}