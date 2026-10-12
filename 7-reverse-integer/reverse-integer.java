class Solution {
    public int reverse(int x) {
        int rev=0;
        boolean flag = false;
        if(x<0) flag =true;
        x = Math.abs(x);
        while(x >0){
            int carry = x%10;
            if(rev > Integer.MAX_VALUE / 10) return 0;
            rev = (rev*10)+carry;
            x = x/10; 
        }
        if(flag == true) return rev = -rev;
        return rev;
    }
}