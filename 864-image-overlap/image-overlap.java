class Solution {
    private int OverLap_count(int[][] img1, int[][] img2, int rowOffset, int colOffset) {
        int n = img1.length;
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int B_i = i+rowOffset;
                int B_j = j+colOffset;
                if(B_i<0 || B_i>=n|| B_j <0 || B_j>=n) continue;
                if(img1[i][j] ==1 && img2[B_i][B_j] ==1) count++;

            }
        }
        return count;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        // row_offset  -n+1 to n-1;
        // col_offset  -n+1 to n-1;
        int max_overlap =0;
        for(int row_offset = -n+1; row_offset<n; row_offset++){
            for (int col_offset = -n+1; col_offset <n ; col_offset++) {
                int count = OverLap_count(img1,img2,row_offset,col_offset);
                max_overlap = Math.max(max_overlap,count);

            }
        }
        return max_overlap;
    }
}