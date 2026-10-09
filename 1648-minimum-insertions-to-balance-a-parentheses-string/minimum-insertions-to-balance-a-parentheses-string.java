class Solution {
    public int minInsertions(String s) {

        int count =0;
        int ans =0;
        int n = s.length();
        int i=0;
       while(i<n) {
            
            if(s.charAt(i) == '('){
                count++;
                i++;
            }
            else {
                if(count>0) count--;
                else{
                    ans++;
                }
                if (i+1<n&& s.charAt(i+1) ==')') i +=2;
                else {
                    ans ++;
                    i++;
                }

            }
       }
       return ans + count*2;
    }
}