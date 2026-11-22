class Solution {
    public int strStr(String hay, String n) {
        int i=0; 
        int j =0;
        int firstIdx = -1;
        while(j != n.length()){
            if(i == hay.length()) return -1;
            if(n.charAt(j) == hay.charAt(i)){
                i++; j++;
                if(j == n.length()) return i-j;
            } else{
                i = i-j+1;
                j=0;
                firstIdx = -1;
            }
        }
        return firstIdx;
    }
}