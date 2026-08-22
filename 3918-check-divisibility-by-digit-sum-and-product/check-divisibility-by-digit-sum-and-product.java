class Solution {
    public boolean checkDivisibility(int n) {
        int a = n;
        int sum=0,pro=1;
        while(n>0){
            int r = n%10;
            sum +=r;
            pro *=r;
            n /=10;
        }
        int total = sum+pro;
        if(total>a) return false;
        else if(a%total ==0) return true;
        else return false;
    }

}