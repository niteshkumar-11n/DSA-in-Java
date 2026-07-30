class Solution {
    public int minimumPushes(String s) {
        int n = s.length();
        if(n<9) return n;
        else{
            int a = n/8;
            int r = n%8;
            if(a ==1) return 8+2*r;
            if(a ==2) return 24+3*r;
            else return 48+4*r;
        }
        
    }
    
}