class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int count =0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch =='('){
                st.push(count);
                count =0;
            }
            else {
                if (s.charAt(i-1) == '(')  count = 1;
                else {
                    count  =  count*2;
                }
                count = st.pop() + count;
            }
        }
        return count;
    }
}