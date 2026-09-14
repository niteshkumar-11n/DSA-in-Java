class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean flag1 = false;
        boolean flag2 = false;
        int overlap_width = rec1[2]-rec2[0];
        int overlap_hight = rec1[3]-rec2[1];
        if(rec1[1] < rec2[3] && rec2[1] < rec1[3]) flag1 = true;
        if(rec1[0] < rec2[2] && rec2[0] < rec1[2]) flag2 = true;
        return flag1 && flag2;

        
    }
}