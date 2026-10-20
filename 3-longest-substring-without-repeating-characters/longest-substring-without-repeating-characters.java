class Solution {
    
   public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        HashMap<Character,Integer> map  = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int i=0;
        int j =0;
        while ( j<s.length()){
            int len =0;
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>=i){
                len = j-i;
                max = Math.max(max,len);
                while(s.charAt(i) != ch) i++;
                i++;
            }
            map.put(ch,j);
            j++;
            len = j-i;
            max = Math.max(max,len);
        }
        return max;
    }
}