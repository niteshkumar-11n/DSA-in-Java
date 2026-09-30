class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int count =0;
        int max =0;
        int [] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
            count++;
            ans[i] = count % 2;
        } else {
            ans[i] = count % 2;
            count--;
        }

        }
        return ans;
    }
}