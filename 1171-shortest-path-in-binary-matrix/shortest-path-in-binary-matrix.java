class Solution {
    class Triplate implements Comparable<Triplate>{
        int row;
        int col;
        int dis;
        Triplate(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
        public  int compareTo(Triplate t){
            return  Integer.compare(this.dis,t.dis);
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] result = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] direction = {{1,1},{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}};
        PriorityQueue<Triplate> pq = new PriorityQueue<>();
        if(m==0 || n==0 || grid[0][0] !=0 ) return -1;
        pq.add(new Triplate(0,0,0));

        result[0][0] = 0;
        while(pq.size()>0){
            Triplate top = pq.remove();
            int x = top.row;
            int y = top.col;
            int dis = top.dis;
            if(x== m-1 && y == n-1) return dis+1;
            for (int i=0; i<8; i++){
                int x_ =x+ direction[i][0];
                int y_ =y+ direction[i][1];
                if(x_>=0 && x_<m && y_>=0 && y_ <n && grid[x_][y_] == 0 && result[x_][y_] >dis+1 ){
                    pq.add(new Triplate(x_,y_,dis+1));
                    result[x_][y_]  = dis+1;

                }
            }
        }
        return  -1;


    }
}