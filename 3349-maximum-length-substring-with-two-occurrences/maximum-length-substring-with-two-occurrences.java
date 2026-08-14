class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int j=0,i=0;
        int ans =0;
        for(i=0; i<n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            } else  map.put(ch,1);
            while(map.get(s.charAt(i))>2){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                j++;
            }
            ans = Math.max(ans,i-j+1);
        }
        return ans;
    }
}