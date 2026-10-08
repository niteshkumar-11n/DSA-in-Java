class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans ="";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if( ch == '(') {
                st.add('(');
                if(st.size()>1) ans += '(';
            }
            if(ch ==')') {
                if(st.size() == 1)  st.pop();
                else {
                    ans += ')';
                    st.pop();
                }
            }
        }
        return ans;
    }
}