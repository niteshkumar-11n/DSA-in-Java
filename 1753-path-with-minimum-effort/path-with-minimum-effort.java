class Solution {
    public class Triplate implements Comparable<Triplate> {
        int row;
        int col;
        int efforts;
        Triplate(int row, int col, int efforts){
            this.efforts =  efforts;
            this.row = row;
            this.col = col;
        }
        public int  compareTo(Triplate t) {
            if(this.efforts == t.efforts) return this.row - t.row;
            return Integer.compare(this.efforts,t.efforts);
        }
    }
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int [][] ans  = new int[m][n];
        for(int i=0; i<m; i++){
            for (int j = 0; j < n; j++)  ans[i][j] = Integer.MAX_VALUE;
        }
        ans[0][0] = 0;
        PriorityQueue<Triplate> pq = new PriorityQueue<>();
        pq.add(new Triplate(0,0,0));
        while(pq.size()>0){
            Triplate top = pq.remove();
            int col = top.col;
            int row = top.row;
            int effort = top.efforts;
            if(row==m-1 && col ==n-1) break;;
            if(row>0){ // going up  row-1
                int e = Math.abs(arr[row-1][col]- arr[row][col]);
                e = Math.max(e, effort);
                if(ans[row-1][col]>e) {
                    ans[row-1][col] = e;
                    pq.add(new Triplate(row-1,col,e));
                }
            }

            if(col>0){ // going left  col-1
                int e = Math.abs(arr[row][col-1]- arr[row][col]);
                e = Math.max(e, effort);
                if(ans[row][col-1]>e) {
                    ans[row][col-1] = e;
                    pq.add(new Triplate(row,col-1,e));
                }
            }

            if(row<m-1){ // going down  row+1
                int e = Math.abs(arr[row+1][col]- arr[row][col]);
                e = Math.max(e, effort);
                if(ans[row+1][col]>e) {
                    ans[row+1][col] = e;
                    pq.add(new Triplate(row+1,col,e));
                }
            }

            if(col<n-1){ // going right  col-1
                int e = Math.abs(arr[row][col+1]- arr[row][col]);
                e = Math.max(e, effort);
                if(ans[row][col+1]>e) {
                    ans[row][col+1] = e;
                    pq.add(new Triplate(row,col+1,e));
                }
            }
        }
        return ans[m-1][n-1];
    }
}