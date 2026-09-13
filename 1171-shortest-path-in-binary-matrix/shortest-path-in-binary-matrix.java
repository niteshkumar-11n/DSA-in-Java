class Solution {
    class Pair {
    int row;
    int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] direction = {{1,1},{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}};
        Queue<Pair> q = new LinkedList<>();
        if(m==0 || n==0 || grid[0][0] !=0 ) return -1;
        q.add(new Pair(0,0));
        int lvl =0;
        while(q.size()>0){
            int size = q.size();
            while(size>0){
                Pair top = q.remove();
    
                int x = top.row;
                int y = top.col;
                if (x== m-1 && y == n-1) return lvl+1;
                for (int i=0; i<8; i++){
                    int x_ =x+ direction[i][0];
                    int y_ =y+ direction[i][1];
                    if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n && grid[x_][y_] == 0) {
                        q.add(new Pair(x_,y_));
                        grid[x_][y_] =1;
                    }
                }
                size--;
            }
            lvl++;

        }
        return  -1;


    }
}