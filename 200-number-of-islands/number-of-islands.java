class Solution {
    public int numIslands(char[][] grid) {
        boolean [][] vist =  new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0; i< grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] =='1' && !vist[i][j]){
                    bfs(i,j,grid,vist);
                    count++;

                }
            }
        }
        return count;
    }
    public  void  bfs(int i,int j, char [][] grid, boolean [][] vist){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        while(q.size()>0){
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];
            // right =row,col+1
            if((col+1)< grid[0].length){
                if (!vist[row][col+1] && grid[row][col+1]=='1'){
                    q.add(new int []{row,col+1});
                    vist[row][col+1] = true;
                }
            }
            // down  = row+1,col
            if((row+1)< grid.length){
                if (!vist[row+1][col] && grid[row+1][col]=='1'){
                    q.add(new int []{row+1,col});
                    vist[row+1][col] = true;
                }
            }
            // top  = row-1,col
            if(row>0){
                if (!vist[row-1][col] && grid[row-1][col]=='1'){
                    q.add(new int []{row-1,col});
                    vist[row-1][col] = true;
                }
            }
            // left =row,col-1
            if(col>0){
                if (!vist[row][col-1] && grid[row][col-1]=='1'){
                    q.add(new int []{row,col-1});
                    vist[row][col-1] = true;
                }
            }
        }
    }
}