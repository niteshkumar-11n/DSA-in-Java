class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans  = new String[m];
        for(int i=0; i<m; i++){
            char [] grid = new char[n];
            for (int j = 0; j < n; j++) {
                if (i==0 || j == n-1) grid[j] = '.';
                else grid[j] = '#';

            }
            ans[i] = new String(grid);
        }
        return ans;
    }
}