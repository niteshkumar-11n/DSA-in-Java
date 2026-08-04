class Solution {
    public int addDigits(int n) {
        while(true){
            int sum=0;
            while(n>0){
                int digit = n%10;
                sum += digit;
                n = n/10;
            }
            if(sum<10) return sum;
            n = sum;
        }
    }
}