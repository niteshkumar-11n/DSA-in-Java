class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int org_area_1 = (ax2-ax1)*(ay2-ay1);
        int org_area_2 = (bx2-bx1)*(by2-by1);

        int x_st = Math.max(ax1,bx1);
        int x_end = Math.min(ax2,bx2);

        
        int y_st = Math.max(ay1,by1);
        int y_end = Math.min(ay2,by2);
        int x_len = Math.max(0,(x_end-x_st));
        int y_len = Math.max(0,(y_end - y_st));
        
        int overlap_area = x_len * y_len;
        
        return (org_area_1+org_area_2) - overlap_area;
 
    }
}