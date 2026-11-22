class Solution {
    public boolean checkString(String s) {
        int countB =  0;
        for(int i=0; i<s.length(); i++){
             
            if(s.charAt(i) == 'b') countB ++;
            if(s.charAt(i) =='a' && countB >0) return false;
        }
        return true;
    }
}