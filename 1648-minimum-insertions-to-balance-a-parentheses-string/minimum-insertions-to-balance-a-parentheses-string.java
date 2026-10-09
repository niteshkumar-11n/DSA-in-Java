class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int count =0;
        int ans=0;
        int n = s.length();
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                if (count == 1) {
                    ans++;   
                    if (st.size()>0) {
                        st.pop();
                    } else {
                        ans++;    
                    }
                    count = 0;
                }
                st.push('(');
            }
            else {
                count++;
                if(count == 2 ) {
                    if (st.size()>0 ){
                        st.pop();
                        count =0;
                    }else{
                        ans++;
                        count = 0;
                    }
                    
                }
            }
        }
        if (count == 1) {
                    ans++;   
                    if (st.size()>0) {
                        st.pop();
                    } else {
                        ans++;    
                    }
                    count = 0;
                }
       
        
        return (st.size()*2)+ans;
    }
}