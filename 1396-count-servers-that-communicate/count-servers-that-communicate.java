class Solution {
    public int countServers(int[][] grid) {
        int count =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] ==1) {
                    boolean flag = false;
                    for(int col =0; col<grid[0].length; col++ ){
                        if(grid[i][col] ==1 && col != j){
                            flag =true;
                            break;
                        }
                    }
                    
                    if(flag == false ){
                        for(int row =0; row<grid.length; row++ ){
                            if(grid[row][j] ==1 && row != i){
                                flag =true;
                                break;
                            }
                        }
                    }
                    if(flag == true ) count ++;
                }
            }
            
        }
        
        return count;
    }
}