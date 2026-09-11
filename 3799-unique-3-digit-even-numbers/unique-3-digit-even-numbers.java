class Solution {
    public int totalNumbers(int[] digits) {
        int[] count  = new int[10];
        int n = digits.length;
        int total_evenNumber =0;
        for (int i=0; i<n; i++){
            count[digits[i]]++;
        }
        for (int h = 1; h <=9; h++) {
                if (count[h] ==0) continue;
                count[h]--;
            for (int t = 0; t <=9; t++) {
                if (count[t] ==0) continue;
                count[t]--;
                for (int o = 0; o < 9; o+=2) {
                    if (count[o] ==0) continue;
                    total_evenNumber ++;
                }
                count[t]++;  
            }
            count[h]++;
            }
        return total_evenNumber;
    }
}