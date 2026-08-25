class Solution {
    public boolean isPalindrome(int n) {
    int  rev_num=0;
    int x =n;
     while(n>0){
        int last_digit =  n%10;
        rev_num =rev_num* 10+last_digit;
        n=n/10;
     }
    if(rev_num != x) return false;
    else return true;

    }
}