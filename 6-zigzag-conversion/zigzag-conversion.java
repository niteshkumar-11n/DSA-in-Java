class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1) return s;
        String[] ans = new String[numRows];
        Arrays.fill(ans, "");
        int j=0;
        while(j<s.length()){
            for (int i = 0; i < numRows && j<s.length(); i++) ans[i] += s.charAt(j++);
            for (int i = numRows - 2; i > 0  && j < s.length(); i--) ans[i] += s.charAt(j++);
            
        }
        String res = "";
        for (int i = 0; i <numRows ; i++)  res +=ans[i];
        return res;
        
    }
}