class Solution {
    public String maxSumOfSquares(int num, int sum) {
            if (sum > num *9) return  "";
            StringBuilder st = new StringBuilder();
            for (int i=0; i<num; i++){
                if (sum >=9) {
                    st.append(9);
                    sum -=9;
                } else{
                    st.append(sum);
                    sum =0;
                }
            }
            return st.toString();
    }
}