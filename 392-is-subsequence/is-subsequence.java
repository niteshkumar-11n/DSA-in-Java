class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int i=0, j=0;
        while( i!=arr1.length && j != arr2.length){
            if(arr1[i] == arr2[j] ) i++;
            j++;         
        }
        if(i==arr1.length) return true;
        else return false;
    }
}