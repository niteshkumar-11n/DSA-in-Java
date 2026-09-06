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
        int []r = {-1,0,1,0};
        int [] c = {0,-1,0,1};
        pq.add(new Triplate(0,0,0));
        while(pq.size()>0){
            Triplate top = pq.remove();
            int col = top.col;
            int row = top.row;
            int effort = top.efforts;
            if(row==m-1 && col ==n-1) break;;
            for(int i=0; i<4; i++){
                int newRow =row+ r[i];
                int newCol = col+c[i];
                if(newCol<0 || newRow<0 || newCol>n-1 ||newRow>m-1) continue;
                int e = Math.abs(arr[row][col]- arr[newRow][newCol]);
                e = Math.max(e, effort);
                if(ans[newRow][newCol]>e) {
                    ans[newRow][newCol] = e;
                    pq.add(new Triplate(newRow,newCol,e));
                }

            }            
        }
        return ans[m-1][n-1];
    }
}