class Solution {
    public  boolean isPalindrom(int i,int j, String s){
        if(i>=j) return true;

        if(s.charAt(i) == s.charAt(j))  return isPalindrom(i+1,j-1, s);
        else return false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int start_Point = 0;
        int maxLen = -1;
        for(int i=0; i<n; i++){
            for (int j = i; j <n ; j++) {
                if (isPalindrom(i,j,s) ){
                    if(j-i+1 >maxLen) {
                        maxLen = j-i+1;
                        start_Point = i;
                    }
                }
                
            }
        }
        return s.substring(start_Point,start_Point+maxLen);
        
       
    }
}